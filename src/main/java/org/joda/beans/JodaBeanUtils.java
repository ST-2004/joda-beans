/*
 *  Copyright 2001-present Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.beans;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;

import org.joda.beans.gen.TypeExtractor;
import org.joda.beans.gen.TypeVariableExtractor;
import org.joda.beans.gen.WildcardTypeExtractor;
import org.joda.beans.impl.direct.DirectBean;
import org.joda.beans.impl.flexi.FlexiBean;
import org.joda.collect.grid.DenseGrid;
import org.joda.collect.grid.Grid;
import org.joda.collect.grid.ImmutableGrid;
import org.joda.collect.grid.SparseGrid;
import org.joda.convert.StringConvert;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.Table;
import com.google.common.collect.TreeMultiset;

/**
 * A set of utilities to assist when working with beans and properties.
 */
public final class JodaBeanUtils {

    /**
     * The cache of meta-beans.
     */
    private static final StringConvert converter = new StringConvert();

    /**
     * Restricted constructor.
     */
    private JodaBeanUtils() {
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the standard string format converter.
     * <p>
     * This returns a singleton that may be mutated (holds a concurrent map).
     * New conversions should be registered at program startup.
     * 
     * @return the standard string converter, not null
     */
    public static StringConvert stringConverter() {
        return converter;
    }

    //-----------------------------------------------------------------------
    /**
     * Checks if two objects are equal handling null.
     * 
     * @param obj1  the first object, may be null
     * @param obj2  the second object, may be null
     * @return true if equal
     */
    public static boolean equal(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        if (obj1.getClass().isArray()) {
            return equalsArray(obj1, obj2);
        }
        // this does not handle arrays embedded in objects, such as in lists/maps,
        // but you shouldn't use arrays like that, should you?
        return obj1.equals(obj2);
    }

    // extracted from equal(Object,Object) to aid hotspot inlining
    private static boolean equalsArray(Object obj1, Object obj2) {
        if (obj1.getClass() != obj2.getClass()) {
            return false;
        }
        return switch (obj1) {
            case Object[] objects -> Arrays.deepEquals(objects, (Object[]) obj2);
            case int[] ints -> Arrays.equals(ints, (int[]) obj2);
            case long[] longs -> Arrays.equals(longs, (long[]) obj2);
            case byte[] bytes -> Arrays.equals(bytes, (byte[]) obj2);
            case double[] doubles -> Arrays.equals(doubles, (double[]) obj2);
            case float[] floats -> Arrays.equals(floats, (float[]) obj2);
            case char[] chars -> Arrays.equals(chars, (char[]) obj2);
            case short[] shorts -> Arrays.equals(shorts, (short[]) obj2);
            case boolean[] booleans -> Arrays.equals(booleans, (boolean[]) obj2);
            default -> false;  // unreachable?
        };
    }

    /**
     * Checks if two floats are equal based on identity.
     * <p>
     * This performs the same check as {@link Float#equals(Object)}.
     * 
     * @param val1  the first value, may be null
     * @param val2  the second value, may be null
     * @return true if equal
     */
    public static boolean equal(float val1, float val2) {
        return Float.floatToIntBits(val1) == Float.floatToIntBits(val2);
    }

    /**
     * Checks if two floats are equal within the specified tolerance.
     * <p>
     * Two NaN values are equal. Positive and negative infinity are only equal with themselves.
     * Otherwise, the difference between the values is compared to the tolerance.
     * 
     * @param val1  the first value, may be null
     * @param val2  the second value, may be null
     * @param tolerance  the tolerance used to compare equal
     * @return true if equal
     */
    public static boolean equalWithTolerance(float val1, float val2, double tolerance) {
        return (Float.floatToIntBits(val1) == Float.floatToIntBits(val2)) || Math.abs(val1 - val2) <= tolerance;
    }

    /**
     * Checks if two doubles are equal based on identity.
     * <p>
     * This performs the same check as {@link Double#equals(Object)}.
     * 
     * @param val1  the first value, may be null
     * @param val2  the second value, may be null
     * @return true if equal
     */
    public static boolean equal(double val1, double val2) {
        return Double.doubleToLongBits(val1) == Double.doubleToLongBits(val2);
    }

    /**
     * Checks if two doubles are equal within the specified tolerance.
     * <p>
     * Two NaN values are equal. Positive and negative infinity are only equal with themselves.
     * Otherwise, the difference between the values is compared to the tolerance.
     * The tolerance is expected to be a finite value, not NaN or infinity.
     * 
     * @param val1  the first value, may be null
     * @param val2  the second value, may be null
     * @param tolerance  the tolerance used to compare equal
     * @return true if equal
     */
    public static boolean equalWithTolerance(double val1, double val2, double tolerance) {
        return (Double.doubleToLongBits(val1) == Double.doubleToLongBits(val2)) || Math.abs(val1 - val2) <= tolerance;
    }

    /**
     * Returns a hash code for an object handling null.
     * 
     * @param obj  the object, may be null
     * @return the hash code
     */
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj.getClass().isArray()) {
            return hashCodeArray(obj);
        }
        return obj.hashCode();
    }

    // extracted from hashCode(Object) to aid hotspot inlining
    private static int hashCodeArray(Object obj) {
        return switch (obj) {
            case Object[] objects -> Arrays.deepHashCode(objects);
            case int[] ints -> Arrays.hashCode(ints);
            case long[] longs -> Arrays.hashCode(longs);
            case byte[] bytes -> Arrays.hashCode(bytes);
            case double[] doubles -> Arrays.hashCode(doubles);
            case float[] floats -> Arrays.hashCode(floats);
            case char[] chars -> Arrays.hashCode(chars);
            case short[] shorts -> Arrays.hashCode(shorts);
            case boolean[] booleans -> Arrays.hashCode(booleans);
            default -> obj.hashCode();  // unreachable?
        };
    }

    /**
     * Returns a hash code for a {@code boolean}.
     * 
     * @param value  the value to convert to a hash code
     * @return the hash code
     */
    public static int hashCode(boolean value) {
        return value ? 1231 : 1237;
    }

    /**
     * Returns a hash code for an {@code int}.
     * 
     * @param value  the value to convert to a hash code
     * @return the hash code
     */
    public static int hashCode(int value) {
        return value;
    }

    /**
     * Returns a hash code for a {@code long}.
     * 
     * @param value  the value to convert to a hash code
     * @return the hash code
     */
    public static int hashCode(long value) {
        return Long.hashCode(value);
    }

    /**
     * Returns a hash code for a {@code float}.
     * 
     * @param value  the value to convert to a hash code
     * @return the hash code
     */
    public static int hashCode(float value) {
        return Float.hashCode(value);
    }

    /**
     * Returns a hash code for a {@code double}.
     * 
     * @param value  the value to convert to a hash code
     * @return the hash code
     */
    public static int hashCode(double value) {
        return Double.hashCode(value);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns the {@code toString} value handling arrays.
     * 
     * @param obj  the object, may be null
     * @return the string, not null
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj.getClass().isArray()) {
            return toStringArray(obj);
        }
        return obj.toString();
    }

    // extracted from toString(Object) to aid hotspot inlining
    private static String toStringArray(Object obj) {
        return switch (obj) {
            case Object[] objects -> Arrays.deepToString(objects);
            case int[] ints -> Arrays.toString(ints);
            case long[] longs -> Arrays.toString(longs);
            case byte[] bytes -> Arrays.toString(bytes);
            case double[] doubles -> Arrays.toString(doubles);
            case float[] floats -> Arrays.toString(floats);
            case char[] chars -> Arrays.toString(chars);
            case short[] shorts -> Arrays.toString(shorts);
            case boolean[] booleans -> Arrays.toString(booleans);
            default -> obj.toString(); // unreachable?
        };
    }

    //-----------------------------------------------------------------------
    /**
     * Checks if the two beans have the same set of properties.
     * <p>
     * This comparison checks that both beans have the same set of property names
     * and that the value of each property name is also equal.
     * It does not check the bean type, thus a {@link FlexiBean} may be equal
     * to a {@link DirectBean}.
     * <p>
     * This comparison is usable with the {@link #propertiesHashCode} method.
     * The result is the same as that if each bean was converted to a {@code Map}
     * from name to value.
     * 
     * @param bean1  the first bean to compare, not null
     * @param bean2  the second bean to compare, not null
     * @return true if equal
     */
    public static boolean propertiesEqual(Bean bean1, Bean bean2) {
        var names = bean1.propertyNames();
        if (!names.equals(bean2.propertyNames())) {
            return false;
        }
        for (var name : names) {
            var value1 = bean1.property(name).get();
            var value2 = bean2.property(name).get();
            if (!equal(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a hash code based on the set of properties on a bean.
     * <p>
     * This hash code is usable with the {@link #propertiesEqual} method.
     * The result is the same as that if each bean was converted to a {@code Map}
     * from name to value.
     * 
     * @param bean  the bean to generate a hash code for, not null
     * @return the hash code
     */
    public static int propertiesHashCode(Bean bean) {
        var hash = 7;
        var names = bean.propertyNames();
        for (var name : names) {
            var value = bean.property(name).get();
            hash += hashCode(value);
        }
        return hash;
    }

    /**
     * Returns a string describing the set of properties on a bean.
     * <p>
     * The result is the same as that if the bean was converted to a {@code Map}
     * from name to value.
     * 
     * @param bean  the bean to generate a string for, not null
     * @param prefix  the prefix to use, null ignored
     * @return the string form of the bean, not null
     */
    public static String propertiesToString(Bean bean, String prefix) {
        if (prefix == null) {
            return propertiesToString(bean, "");
        }
        var names = bean.propertyNames();
        var buf = new StringBuilder((names.size()) * 32 + prefix.length()).append(prefix);
        buf.append('{');
        if (!names.isEmpty()) {
            for (var name : names) {
                var value = bean.property(name).get();
                buf.append(name).append('=').append(value).append(',').append(' ');
            }
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    /**
     * Flattens a bean to a {@code Map}.
     * <p>
     * The returned map will contain all the properties from the bean with their actual values.
     * 
     * @param bean  the bean to generate a string for, not null
     * @return the bean as a map, not null
     */
    public static Map<String, Object> flatten(Bean bean) {
        var propertyMap = bean.metaBean().metaPropertyMap();
        var map = new LinkedHashMap<String, Object>(propertyMap.size());
        for (var entry : propertyMap.entrySet()) {
            map.put(entry.getKey(), entry.getValue().get(bean));
        }
        return Collections.unmodifiableMap(map);
    }

    //-----------------------------------------------------------------------
    /**
     * Copies properties from a bean to a different bean type.
     * <p>
     * This copies each non-null property value from the source bean to the destination builder
     * provided that the destination builder supports the property name and the type is compatible.
     * 
     * @param <T>  the type of the bean to create
     * @param sourceBean  the bean to copy from, not null
     * @param destType  the type of the destination bean, not null
     * @return the copied bean as a builder
     * @throws RuntimeException if unable to copy a property
     */
    public static <T extends Bean> BeanBuilder<T> copy(Bean sourceBean, Class<T> destType) {
        var destMeta = MetaBean.of(destType);
        @SuppressWarnings("unchecked")
        var destBuilder = (BeanBuilder<T>) destMeta.builder();
        return copyInto(sourceBean, destMeta, destBuilder);
    }

    /**
     * Copies properties from a bean to a builder, which may be for a different type.
     * <p>
     * This copies each non-null property value from the source bean to the destination builder
     * provided that the destination builder supports the property name and the type is compatible.
     * 
     * @param <T>  the type of the bean to create
     * @param sourceBean  the bean to copy from, not null
     * @param destMeta  the meta bean of the destination, not null
     * @param destBuilder  the builder to populate, not null
     * @return the updated builder
     * @throws RuntimeException if unable to copy a property
     */
    public static <T extends Bean> BeanBuilder<T> copyInto(Bean sourceBean, MetaBean destMeta, BeanBuilder<T> destBuilder) {
        var sourceMeta = sourceBean.metaBean();
        for (var sourceProp : sourceMeta.metaPropertyIterable()) {
            if (destMeta.metaPropertyExists(sourceProp.name())) {
                var destProp = destMeta.metaProperty(sourceProp.name());
                if (destProp.propertyType().isAssignableFrom(sourceProp.propertyType())) {
                    var sourceValue = sourceProp.get(sourceBean);
                    if (sourceValue != null) {
                        destBuilder.set(destProp, sourceValue);
                    }
                }
            }
        }
        return destBuilder;
    }

    //-----------------------------------------------------------------------
    /**
     * Deep clones an array.
     * <p>
     * This performs a deep clone and handles multi-dimensional arrays.
     * There is no protection against cycles in the object graph beyond {@code StackOverflowError}.
     * <p>
     * Unfortunately, primitive arrays don't play nicely with generics, thus callers must cast the result.
     * 
     * @param original  the original array to clone, null returns null
     * @return the cloned array, null if null input
     * @throws IllegalArgumentException if the original object is not an array
     * @since 2.12.0
     */
    @SuppressWarnings("unchecked")
    public static Object cloneArray(Object original) {
        if (original == null) {
            return null;
        }
        int len = Array.getLength(original);
        Class<?> arrayType = original.getClass().getComponentType();
        Object copy = Array.newInstance(arrayType, len);
        for (int i = 0; i < len; i++) {
            Array.set(copy, i, Cloner.INSTANCE.clone(Array.get(original, i)));
        }
        return copy;
    }

    /**
     * Deep clones a bean, without cloning an {@code ImmutableBean}.
     * <p>
     * This performs a deep clone. There is no protection against cycles in
     * the object graph beyond {@code StackOverflowError}.
     * 
     * @param <T>  the type of the bean
     * @param original  the original bean to clone, null returns null
     * @return the cloned bean, null if null input
     */
    public static <T extends Bean> T clone(T original) {
        if (original == null || original instanceof ImmutableBean) {
            return original;
        }
        return cloneAlways(original);
    }

    /**
     * Deep clones a bean always.
     * <p>
     * This performs a deep clone. There is no protection against cycles in
     * the object graph beyond {@code StackOverflowError}.
     * This differs from {@link #clone()} in that immutable beans are also cloned.
     * 
     * @param <T>  the type of the bean
     * @param original  the original bean to clone, not null
     * @return the cloned bean, not null
     */
    public static <T extends Bean> T cloneAlways(T original) {
        @SuppressWarnings("unchecked")
        var builder = (BeanBuilder<T>) original.metaBean().builder();
        for (var mp : original.metaBean().metaPropertyIterable()) {
            if (mp.style().isBuildable()) {
                var value = mp.get(original);
                builder.set(mp.name(), Cloner.INSTANCE.clone(value));
            }
        }
        return builder.build();
    }

    //-----------------------------------------------------------------------
    /**
     * Checks if the value is not null, throwing an exception if it is.
     * 
     * @param value  the value to check, may be null
     * @param propertyName  the property name, should not be null
     * @throws IllegalArgumentException if the value is null
     */
    public static void notNull(Object value, String propertyName) {
        if (value == null) {
            throw new IllegalArgumentException(notNullMsg(propertyName));
        }
    }

    // extracted from notNull(Object,String) to aid hotspot inlining
    private static String notNullMsg(String propertyName) {
        return "Argument '" + propertyName + "' must not be null";
    }

    /**
     * Checks if the value is not blank, throwing an exception if it is.
     * <p>
     * Validate that the specified argument is not null and has at least one non-whitespace character.
     * 
     * @param value  the value to check, may be null
     * @param propertyName  the property name, should not be null
     * @throws IllegalArgumentException if the value is null or empty
     */
    public static void notBlank(String value, String propertyName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(notEmpty(propertyName));
        }
    }

    /**
     * Checks if the value is not empty, throwing an exception if it is.
     * 
     * @param value  the value to check, may be null
     * @param propertyName  the property name, should not be null
     * @throws IllegalArgumentException if the value is null or empty
     */
    public static void notEmpty(String value, String propertyName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(notEmpty(propertyName));
        }
    }

    // extracted from notEmpty(?,String) to aid hotspot inlining
    private static String notEmpty(String propertyName) {
        return "Argument '" + propertyName + "' must not be empty";
    }

    /**
     * Checks if the collection value is not empty, throwing an exception if it is.
     * 
     * @param value  the value to check, may be null
     * @param propertyName  the property name, should not be null
     * @throws IllegalArgumentException if the value is null or empty
     */
    public static void notEmpty(Collection<?> value, String propertyName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(notEmpty(propertyName));
        }
    }

    /**
     * Checks if the map value is not empty, throwing an exception if it is.
     * 
     * @param value  the value to check, may be null
     * @param propertyName  the property name, should not be null
     * @throws IllegalArgumentException if the value is null or empty
     */
    public static void notEmpty(Map<?, ?> value, String propertyName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(notEmpty(propertyName));
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Extracts the collection content type as a {@code Class} from a property.
     * <p>
     * This method allows the resolution of generics in certain cases.
     * 
     * @param prop  the property to examine, not null
     * @return the collection content type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> collectionType(Property<?> prop) {
        return collectionType(prop.metaProperty(), prop.bean().getClass());
    }

    /**
     * Extracts the collection content type as a {@code Class} from a meta-property.
     * <p>
     * The target type is the type of the object, not the declaring type of the meta-property.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @return the collection content type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> collectionType(MetaProperty<?> prop, Class<?> contextClass) {
        return extractTypeClass(prop, contextClass, 1, 0);
    }

    /**
     * Extracts the map value type generic type parameters as a {@code Class} from a meta-property.
     * <p>
     * The target type is the type of the object, not the declaring type of the meta-property.
     * <p>
     * This is used when the collection generic parameter is a map or collection.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @return the collection content type generic parameters, empty if unable to determine, no nulls
     */
    public static List<Class<?>> collectionTypeTypes(MetaProperty<?> prop, Class<?> contextClass) {
        var type = extractType(prop, contextClass, 1, 0);
        return extractTypeClasses(type, contextClass);
    }

    /**
     * Extracts the map key type as a {@code Class} from a meta-property.
     * 
     * @param prop  the property to examine, not null
     * @return the map key type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> mapKeyType(Property<?> prop) {
        return mapKeyType(prop.metaProperty(), prop.bean().getClass());
    }

    /**
     * Extracts the map key type as a {@code Class} from a meta-property.
     * <p>
     * The target type is the type of the object, not the declaring type of the meta-property.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @return the map key type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> mapKeyType(MetaProperty<?> prop, Class<?> contextClass) {
        return extractTypeClass(prop, contextClass, 2, 0);
    }

    /**
     * Extracts the map value type as a {@code Class} from a meta-property.
     * 
     * @param prop  the property to examine, not null
     * @return the map value type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> mapValueType(Property<?> prop) {
        return mapValueType(prop.metaProperty(), prop.bean().getClass());
    }

    /**
     * Extracts the map value type as a {@code Class} from a meta-property.
     * <p>
     * The target type is the type of the object, not the declaring type of the meta-property.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @return the map value type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> mapValueType(MetaProperty<?> prop, Class<?> contextClass) {
        return extractTypeClass(prop, contextClass, 2, 1);
    }

    /**
     * Extracts the map value type generic type parameters as a {@code Class} from a meta-property.
     * <p>
     * The target type is the type of the object, not the declaring type of the meta-property.
     * <p>
     * This is used when the map value generic parameter is a map or collection.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @return the map value type generic parameters, empty if unable to determine, no nulls
     */
    public static List<Class<?>> mapValueTypeTypes(MetaProperty<?> prop, Class<?> contextClass) {
        var type = extractType(prop, contextClass, 2, 1);
        return extractTypeClasses(type, contextClass);
    }

    /**
     * Low-level method to extract generic type information.
     * 
     * @param prop  the property to examine, not null
     * @param contextClass  the context class to evaluate against, not null
     * @param size  the number of generic parameters expected
     * @param index  the index of the generic parameter
     * @return the type, null if unable to determine or type has no generic parameters
     */
    public static Class<?> extractTypeClass(MetaProperty<?> prop, Class<?> contextClass, int size, int index) {
        return eraseToClass(extractType(prop, contextClass, size, index));
    }

    private static final Map<Class<?>, TypeExtractor> extractors = Map.of(
            WildcardType.class, new WildcardTypeExtractor(),
            TypeVariable.class, new TypeVariableExtractor()
    );

    private static Type handleWithExtractor(Type type, Class<?> contextClass) {
        for (Class<?> clazz : extractors.keySet()) {
            if (clazz.isInstance(type)) {
                return extractors.get(clazz).extract(type, contextClass);
            }
        }
        return type;
    }

    private static Type extractType(MetaProperty<?> prop, Class<?> contextClass, int size, int index) {
        var genType = prop.propertyGenericType();
        if (genType instanceof ParameterizedType pt) {
            var types = pt.getActualTypeArguments();
            if (types.length == size) {
                var type = types[index];
                return handleWithExtractor(type, contextClass);
            }
        }
        return null;
    }

    private static List<Class<?>> extractTypeClasses(Type type, Class<?> contextClass) {
        var result = new ArrayList<Class<?>>();
        if (type != null) {
            if (type instanceof ParameterizedType pt) {
                var actualTypes = pt.getActualTypeArguments();
                for (var actualType : actualTypes) {
                    if (actualType instanceof TypeVariable<?> tvar) {
                        actualType = resolveGenerics(tvar, contextClass);
                    }
                    var cls = eraseToClass(actualType);
                    result.add(cls != null ? cls : Object.class);
                }
            }
        }
        return result;
    }

    // cache the type variable lookup by Class
    private static final ClassValue<Map<Type, Type>> RESOLVED_TYPE_VARIABLES = new ClassValue<>() {
        @Override
        protected Map<Type, Type> computeValue(Class<?> contextClass) {
            var resolved = new HashMap<Type, Type>();
            findTypeVars(contextClass, resolved);
            if (resolved.size() > 1) {
                // simplify, eg 'T=N, N=String' is simplified to 'T=String, N=String'
                for (var entry : resolved.entrySet()) {
                    var value = entry.getValue();
                    while (resolved.containsKey(value)) {
                        value = resolved.get(value);
                    }
                    entry.setValue(value);
                }
            }
            return Collections.unmodifiableMap(resolved);
        }

        private void findTypeVars(Type type, HashMap<Type, Type> resolved) {
            if (type instanceof Class<?> cls) {
                // check parent class and interfaces
                findTypeVars(cls.getGenericSuperclass(), resolved);
                for (var genInterface : cls.getGenericInterfaces()) {
                    findTypeVars(genInterface, resolved);
                }

            } else if (type instanceof ParameterizedType pt) {
                // find actual types that have been captured
                var actualTypeArguments = pt.getActualTypeArguments();
                // find type variables declared in source code
                var rawType = eraseToClass(pt.getRawType());
                var typeParameters = rawType.getTypeParameters();
                for (var i = 0; i < actualTypeArguments.length; i++) {
                    resolved.put(typeParameters[i], actualTypeArguments[i]);
                }
                findTypeVars(rawType, resolved);
            }
        }
    };

    // resolve generic type variables
    // if a subclass is defined as 'extends Foo<String>' and the superclass is 'Foo<T>'
    // then we know that 'T = String' in the context of the subclass
    // NOTE: this may return a type variable
    public static Type resolveGenerics(TypeVariable<?> typevar, Class<?> contextClass) {
        var resolved = RESOLVED_TYPE_VARIABLES.get(contextClass);
        return resolved.getOrDefault(typevar, typevar);
    }

    // erases a Type to a Class
    static Class<?> eraseToClass(Type type) {
        return switch (type) {
            case null -> null;
            case Class<?> cls -> cls;
            case ParameterizedType parameterizedType -> eraseToClass(parameterizedType.getRawType());
            case GenericArrayType arrType -> {
                var componentType = arrType.getGenericComponentType();
                var componentClass = eraseToClass(componentType);
                yield componentClass != null ? componentClass.arrayType() : null;
            }
            case TypeVariable<?> tvar -> {
                var bounds = tvar.getBounds();
                yield bounds.length == 0 ? Object.class : eraseToClass(bounds[0]);
            }
            case WildcardType wild -> {
                var bounds = wild.getUpperBounds();
                yield bounds.length == 0 ? Object.class : eraseToClass(bounds[0]);
            }
            default -> null;
        };
    }

    //-------------------------------------------------------------------------
    /**
     * Checks if two beans are equal ignoring one or more properties.
     * <p>
     * This version of {@code equalIgnoring} only checks properties at the top level.
     * For example, if a {@code Person} bean contains an {@code Address} bean then
     * only properties on the {@code Person} bean will be checked against the ignore list.
     * 
     * @param bean1  the first bean, not null
     * @param bean2  the second bean, not null
     * @param properties  the properties to ignore, not null
     * @return true if equal
     * @throws IllegalArgumentException if inputs are null
     */
    public static boolean equalIgnoring(Bean bean1, Bean bean2, MetaProperty<?>... properties) {
        JodaBeanUtils.notNull(bean1, "bean1");
        JodaBeanUtils.notNull(bean2, "bean2");
        JodaBeanUtils.notNull(properties, "properties");
        if (bean1 == bean2) {
            return true;
        }
        if (bean1.getClass() != bean2.getClass()) {
            return false;
        }
        return switch (properties.length) {
            case 0 -> bean1.equals(bean2);
            case 1 -> {
                var ignored = properties[0];
                for (var mp : bean1.metaBean().metaPropertyIterable()) {
                    if (!ignored.equals(mp) && !JodaBeanUtils.equal(mp.get(bean1), mp.get(bean2))) {
                        yield false;
                    }
                }
                yield true;
            }
            default -> {
                var ignored = Set.of(properties);
                for (var mp : bean1.metaBean().metaPropertyIterable()) {
                    if (!ignored.contains(mp) && !JodaBeanUtils.equal(mp.get(bean1), mp.get(bean2))) {
                        yield false;
                    }
                }
                yield true;
            }
        };
    }

    //-----------------------------------------------------------------------
    /**
     * Returns an iterator over all the beans contained within the bean.
     * <p>
     * The iterator is a depth-first traversal of the beans within the specified bean.
     * The first returned bean is the specified bean.
     * Beans within collections will be returned.
     * <p>
     * A cycle in the bean structure will cause an infinite loop.
     * 
     * @param bean  the bean to iterate over, not null
     * @return the iterator, not null
     */
    public static Iterator<Bean> beanIterator(Bean bean) {
        return new BeanIterator(bean);
    }

    //-------------------------------------------------------------------------
    /**
     * Chains two meta-properties together.
     * <p>
     * The resulting function takes an instance of a bean, queries using the first
     * meta-property, then queries the result using the second meta-property.
     * If the first returns null, the result will be null.
     * 
     * @param <P>  the type of the result of the chain
     * @param mp1  the first meta-property, not null
     * @param mp2  the second meta-property, not null
     * @return the chain function, not null
     */
    public static <P> Function<Bean, P> chain(MetaProperty<? extends Bean> mp1, MetaProperty<P> mp2) {
        notNull(mp1, "MetaProperty 1");
        notNull(mp1, "MetaProperty 2");
        return b -> {
            var first = mp1.get(b);
            return first != null ? mp2.get(first) : null;
        };
    }

    /**
     * Chains a function to a meta-property.
     * <p>
     * The resulting function takes an instance of a bean, queries using the first
     * function, then queries the result using the second meta-property.
     * If the first returns null, the result will be null.
     * 
     * @param <P>  the type of the result of the chain
     * @param fn1  the first meta-property, not null
     * @param mp2  the second meta-property, not null
     * @return the chain function, not null
     */
    public static <P> Function<Bean, P> chain(Function<Bean, ? extends Bean> fn1, MetaProperty<P> mp2) {
        notNull(fn1, "Function 1");
        notNull(fn1, "MetaProperty 2");
        return b -> {
            var first = fn1.apply(b);
            return first != null ? mp2.get(first) : null;
        };
    }

    //-------------------------------------------------------------------------
    /**
     * Obtains a comparator for the specified bean query.
     * <p>
     * The result of the query must be {@link Comparable}.
     * <p>
     * To use this with a meta-property append {@code ::get} to the meta-property,
     * for example {@code Address.meta().street()::get}.
     * 
     * @param query  the query to use, not null
     * @param ascending  true for ascending, false for descending
     * @return the comparator, not null
     */
    public static Comparator<Bean> comparator(Function<Bean, ?> query, boolean ascending) {
        return (ascending ? comparatorAscending(query) : comparatorDescending(query));
    }

    /**
     * Obtains an ascending comparator for the specified bean query.
     * <p>
     * The result of the query must be {@link Comparable}.
     * 
     * @param query  the query to use, not null
     * @return the comparator, not null
     */
    public static Comparator<Bean> comparatorAscending(Function<Bean, ?> query) {
        Objects.requireNonNull(query, "query must not be null");
        return new Comp(query);
    }

    /**
     * Obtains a descending comparator for the specified bean query.
     * <p>
     * The result of the query must be {@link Comparable}.
     * 
     * @param query  the query to use, not null
     * @return the comparator, not null
     */
    public static Comparator<Bean> comparatorDescending(Function<Bean, ?> query) {
        Objects.requireNonNull(query, "query must not be null");
        return Collections.reverseOrder(new Comp(query));
    }

    //-------------------------------------------------------------------------
    /**
     * Comparator.
     */
    private static final class Comp implements Comparator<Bean> {
        private final Function<Bean, ?> query;

        private Comp(Function<Bean, ?> query) {
            this.query = query;
        }

        @Override
        public int compare(Bean bean1, Bean bean2) {
            @SuppressWarnings("unchecked")
            var value1 = (Comparable<Object>) query.apply(bean1);
            Object value2 = query.apply(bean2);
            return value1.compareTo(value2);
        }
    }

    //-------------------------------------------------------------------------
    /**
     * Clones an object.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static class Cloner {
        public static final Cloner INSTANCE = getInstance();

        private static Cloner getInstance() {
            try {
                ImmutableGrid.of();  // check if class is available
                return new CollectCloner();
            } catch (Exception | LinkageError ex) {
                try {
                    ImmutableMultiset.of();  // check if class is available
                    return new GuavaCloner();
                } catch (Exception | LinkageError ex2) {
                    return new Cloner();
                }
            }
        }

        Cloner() {
        }

        Object clone(Object value) {
            return switch (value) {
                case null -> value;
                case Bean bean -> cloneAlways(bean);
                case SortedSet set -> cloneIterable(set, new TreeSet(set.comparator()));
                case Set set -> cloneIterable(set, LinkedHashSet.newLinkedHashSet(set.size()));
                case Collection coll -> cloneIterable(coll, new ArrayList(coll.size()));
                case Iterable iterable -> cloneIterable(iterable, new ArrayList());
                case SortedMap map -> cloneMap(map, new TreeMap(map.comparator()));
                case Map map -> cloneMap(map, LinkedHashMap.newLinkedHashMap(map.size()));
                case java.util.Date date -> date.clone();
                case long[] array -> array.clone();
                case int[] array -> array.clone();
                case short[] array -> array.clone();
                case byte[] array -> array.clone();
                case char[] array -> array.clone();
                case double[] array -> array.clone();
                case float[] array -> array.clone();
                case boolean[] array -> array.clone();
                case Object[] array -> cloneArray(array);
                default -> value;
            };
        }

        Object cloneIterable(Iterable original, Collection cloned) {
            for (var item : original) {
                cloned.add(clone(item));
            }
            return cloned;
        }

        Object cloneMap(Map original, Map cloned) {
            for (var item : original.entrySet()) {
                var entry = (Entry) item;
                cloned.put(clone(entry.getKey()), clone(entry.getValue()));
            }
            return cloned;
        }

        Object cloneArray(Object[] originalArray) {
            var copy = originalArray.clone();
            for (var i = 0; i < copy.length; i++) {
                copy[i] = clone(originalArray[i]);
            }
            return copy;
        }
    }

    //-------------------------------------------------------------------------
    /**
     * Clones an object.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static class GuavaCloner extends Cloner {
        GuavaCloner() {
        }

        @Override
        Object clone(Object value) {
            return switch (value) {
                case null -> value;
                case ImmutableCollection coll -> coll;
                case ImmutableMap map -> map;
                case ImmutableMultimap map -> map;
                case ImmutableTable table -> table;
                case SortedMultiset set -> cloneIterable(set, TreeMultiset.create(set.comparator()));
                case Multiset mset -> cloneIterable(mset, LinkedHashMultiset.create(mset.size()));
                case SetMultimap mmap -> cloneMultimap(mmap, LinkedHashMultimap.create());
                case ListMultimap mmap -> cloneMultimap(mmap, ArrayListMultimap.create());
                case Multimap mmap -> cloneMultimap(mmap, ArrayListMultimap.create());
                case BiMap bimap -> cloneMap(bimap, HashBiMap.create(bimap.size()));
                case Table table -> cloneTable(table, HashBasedTable.create());
                default -> super.clone(value);
            };
        }

        Object cloneMultimap(Multimap original, Multimap cloned) {
            for (var key : original.keySet()) {
                var values = original.get(key);
                for (var value : values) {
                    cloned.put(clone(key), clone(value));
                }
            }
            return cloned;
        }

        Object cloneTable(Table original, Table cloned) {
            for (var item : original.cellSet()) {
                var cell = (Table.Cell) item;
                cloned.put(clone(cell.getRowKey()), clone(cell.getColumnKey()), clone(cell.getValue()));
            }
            return cloned;
        }
    }

    //-------------------------------------------------------------------------
    /**
     * Clones an object.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static class CollectCloner extends GuavaCloner {
        CollectCloner() {
        }

        @Override
        Object clone(Object value) {
            return switch (value) {
                case null -> value;
                case ImmutableGrid grid -> grid;
                case DenseGrid grid -> cloneGrid(grid, DenseGrid.create(grid.rowCount(), grid.columnCount()));
                case Grid grid -> cloneGrid(grid, SparseGrid.create(grid.rowCount(), grid.columnCount()));
                default -> super.clone(value);
            };
        }

        Object cloneGrid(Grid original, Grid cloned) {
            for (var item : original.cells()) {
                var cell = (Grid.Cell) item;
                cloned.put(cell.getRow(), cell.getColumn(), clone(cell.getValue()));
            }
            return cloned;
        }
    }

}
