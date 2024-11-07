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
package org.joda.beans.sample;

import java.util.Map;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class GenericAllFinal<T> implements Bean {

    /** The name. */
    @PropertyDefinition(validate = "notNull")
    private final String name;
    /** The value. */
    @PropertyDefinition(validate = "notNull")
    private final T value;

    public GenericAllFinal() {
        name = "foo";
        value = null;
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code GenericAllFinal}.
     * @return the meta-bean, not null
     */
    @SuppressWarnings("rawtypes")
    public static GenericAllFinal.Meta meta() {
        return GenericAllFinal.Meta.INSTANCE;
    }

    /**
     * The meta-bean for {@code GenericAllFinal}.
     * @param <R>  the bean's generic type
     * @param cls  the bean's generic type
     * @return the meta-bean, not null
     */
    @SuppressWarnings("unchecked")
    public static <R> GenericAllFinal.Meta<R> metaGenericAllFinal(Class<R> cls) {
        return GenericAllFinal.Meta.INSTANCE;
    }

    static {
        MetaBean.register(GenericAllFinal.Meta.INSTANCE);
    }

    @SuppressWarnings("unchecked")
    @Override
    public GenericAllFinal.Meta<T> metaBean() {
        return GenericAllFinal.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the name.
     * @return the value of the property, not null
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the the {@code name} property.
     * @return the property, not null
     */
    public final Property<String> name() {
        return metaBean().name().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the value.
     * @return the value of the property, not null
     */
    public T getValue() {
        return value;
    }

    /**
     * Gets the the {@code value} property.
     * @return the property, not null
     */
    public final Property<T> value() {
        return metaBean().value().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public GenericAllFinal<T> clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            GenericAllFinal<?> other = (GenericAllFinal<?>) obj;
            return JodaBeanUtils.equal(this.getName(), other.getName()) &&
                    JodaBeanUtils.equal(this.getValue(), other.getValue());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getName());
        hash = hash * 31 + JodaBeanUtils.hashCode(getValue());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append("GenericAllFinal{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("name").append('=').append(JodaBeanUtils.toString(getName())).append(',').append(' ');
        buf.append("value").append('=').append(JodaBeanUtils.toString(getValue())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code GenericAllFinal}.
     * @param <T>  the type
     */
    public static class Meta<T> extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        @SuppressWarnings("rawtypes")
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code name} property.
         */
        private final MetaProperty<String> name = DirectMetaProperty.ofReadOnly(
                this, "name", GenericAllFinal.class, String.class);
        /**
         * The meta-property for the {@code value} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<T> value = (DirectMetaProperty) DirectMetaProperty.ofReadOnly(
                this, "value", GenericAllFinal.class, Object.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "name",
                "value");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    return this.name;
                case 111972721:  // value
                    return this.value;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends GenericAllFinal<T>> builder() {
            return new DirectBeanBuilder<>(new GenericAllFinal<T>());
        }

        @SuppressWarnings({"unchecked", "rawtypes" })
        @Override
        public Class<? extends GenericAllFinal<T>> beanType() {
            return (Class) GenericAllFinal.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code name} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> name() {
            return name;
        }

        /**
         * The meta-property for the {@code value} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<T> value() {
            return value;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    return ((GenericAllFinal<?>) bean).getName();
                case 111972721:  // value
                    return ((GenericAllFinal<?>) bean).getValue();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 3373707:  // name
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: name");
                case 111972721:  // value
                    if (quiet) {
                        return;
                    }
                    throw new UnsupportedOperationException("Property cannot be written: value");
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

        @Override
        protected void validate(Bean bean) {
            JodaBeanUtils.notNull(((GenericAllFinal<?>) bean).name, "name");
            JodaBeanUtils.notNull(((GenericAllFinal<?>) bean).value, "value");
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
