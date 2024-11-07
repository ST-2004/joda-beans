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
import java.util.NoSuchElementException;
import java.util.Optional;

import org.joda.beans.Bean;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.MetaProperty;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock person JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public final class ImmDeprecated implements Cloneable, ImmutableBean {

    /**
     * The field with deprecated annotation and Javadoc tag.
     * @deprecated Use something else
     */
    @Deprecated
    @PropertyDefinition
    private final String deprecatedBoth;

    /**
     * The field with deprecated Javadoc tag only.
     * @deprecated Use something else
     */
    @PropertyDefinition
    private final String deprecatedJavadoc;

    @Deprecated
    @PropertyDefinition
    private final String deprecatedAnnotation;

    @Deprecated
    @PropertyDefinition(get = "optional")
    private final String deprecatedOptional;

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code ImmDeprecated}.
     * @return the meta-bean, not null
     */
    public static ImmDeprecated.Meta meta() {
        return ImmDeprecated.Meta.INSTANCE;
    }

    static {
        MetaBean.register(ImmDeprecated.Meta.INSTANCE);
    }

    /**
     * Returns a builder used to create an instance of the bean.
     * @return the builder, not null
     */
    public static ImmDeprecated.Builder builder() {
        return new ImmDeprecated.Builder();
    }

    private ImmDeprecated(
            String deprecatedBoth,
            String deprecatedJavadoc,
            String deprecatedAnnotation,
            String deprecatedOptional) {
        this.deprecatedBoth = deprecatedBoth;
        this.deprecatedJavadoc = deprecatedJavadoc;
        this.deprecatedAnnotation = deprecatedAnnotation;
        this.deprecatedOptional = deprecatedOptional;
    }

    @Override
    public ImmDeprecated.Meta metaBean() {
        return ImmDeprecated.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the field with deprecated annotation and Javadoc tag.
     * @return the value of the property
     * @deprecated Use something else
     */
    @Deprecated
    public String getDeprecatedBoth() {
        return deprecatedBoth;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the field with deprecated Javadoc tag only.
     * @return the value of the property
     * @deprecated Use something else
     */
    @Deprecated
    public String getDeprecatedJavadoc() {
        return deprecatedJavadoc;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the deprecatedAnnotation.
     * @return the value of the property
     * @deprecated Deprecated
     */
    @Deprecated
    public String getDeprecatedAnnotation() {
        return deprecatedAnnotation;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the deprecatedOptional.
     * @return the optional value of the property, not null
     * @deprecated Deprecated
     */
    @Deprecated
    public Optional<String> getDeprecatedOptional() {
        return Optional.ofNullable(deprecatedOptional);
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a builder that allows this bean to be mutated.
     * @return the mutable builder, not null
     */
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            ImmDeprecated other = (ImmDeprecated) obj;
            return JodaBeanUtils.equal(this.deprecatedBoth, other.deprecatedBoth) &&
                    JodaBeanUtils.equal(this.deprecatedJavadoc, other.deprecatedJavadoc) &&
                    JodaBeanUtils.equal(this.deprecatedAnnotation, other.deprecatedAnnotation) &&
                    JodaBeanUtils.equal(this.deprecatedOptional, other.deprecatedOptional);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(deprecatedBoth);
        hash = hash * 31 + JodaBeanUtils.hashCode(deprecatedJavadoc);
        hash = hash * 31 + JodaBeanUtils.hashCode(deprecatedAnnotation);
        hash = hash * 31 + JodaBeanUtils.hashCode(deprecatedOptional);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(160);
        buf.append("ImmDeprecated{");
        buf.append("deprecatedBoth").append('=').append(JodaBeanUtils.toString(deprecatedBoth)).append(',').append(' ');
        buf.append("deprecatedJavadoc").append('=').append(JodaBeanUtils.toString(deprecatedJavadoc)).append(',').append(' ');
        buf.append("deprecatedAnnotation").append('=').append(JodaBeanUtils.toString(deprecatedAnnotation)).append(',').append(' ');
        buf.append("deprecatedOptional").append('=').append(JodaBeanUtils.toString(deprecatedOptional));
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code ImmDeprecated}.
     */
    public static final class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code deprecatedBoth} property.
         */
        private final MetaProperty<String> deprecatedBoth = DirectMetaProperty.ofImmutable(
                this, "deprecatedBoth", ImmDeprecated.class, String.class);
        /**
         * The meta-property for the {@code deprecatedJavadoc} property.
         */
        private final MetaProperty<String> deprecatedJavadoc = DirectMetaProperty.ofImmutable(
                this, "deprecatedJavadoc", ImmDeprecated.class, String.class);
        /**
         * The meta-property for the {@code deprecatedAnnotation} property.
         */
        private final MetaProperty<String> deprecatedAnnotation = DirectMetaProperty.ofImmutable(
                this, "deprecatedAnnotation", ImmDeprecated.class, String.class);
        /**
         * The meta-property for the {@code deprecatedOptional} property.
         */
        private final MetaProperty<String> deprecatedOptional = DirectMetaProperty.ofImmutable(
                this, "deprecatedOptional", ImmDeprecated.class, String.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "deprecatedBoth",
                "deprecatedJavadoc",
                "deprecatedAnnotation",
                "deprecatedOptional");

        /**
         * Restricted constructor.
         */
        private Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case -1108081708:  // deprecatedBoth
                    return this.deprecatedBoth;
                case -1632501085:  // deprecatedJavadoc
                    return this.deprecatedJavadoc;
                case 1044703554:  // deprecatedAnnotation
                    return this.deprecatedAnnotation;
                case 1434300979:  // deprecatedOptional
                    return this.deprecatedOptional;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public ImmDeprecated.Builder builder() {
            return new ImmDeprecated.Builder();
        }

        @Override
        public Class<? extends ImmDeprecated> beanType() {
            return ImmDeprecated.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code deprecatedBoth} property.
         * @return the meta-property, not null
         * @deprecated Use something else
         */
        @Deprecated
        public MetaProperty<String> deprecatedBoth() {
            return deprecatedBoth;
        }

        /**
         * The meta-property for the {@code deprecatedJavadoc} property.
         * @return the meta-property, not null
         * @deprecated Use something else
         */
        @Deprecated
        public MetaProperty<String> deprecatedJavadoc() {
            return deprecatedJavadoc;
        }

        /**
         * The meta-property for the {@code deprecatedAnnotation} property.
         * @return the meta-property, not null
         * @deprecated Deprecated
         */
        @Deprecated
        public MetaProperty<String> deprecatedAnnotation() {
            return deprecatedAnnotation;
        }

        /**
         * The meta-property for the {@code deprecatedOptional} property.
         * @return the meta-property, not null
         * @deprecated Deprecated
         */
        @Deprecated
        public MetaProperty<String> deprecatedOptional() {
            return deprecatedOptional;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case -1108081708:  // deprecatedBoth
                    return ((ImmDeprecated) bean).getDeprecatedBoth();
                case -1632501085:  // deprecatedJavadoc
                    return ((ImmDeprecated) bean).getDeprecatedJavadoc();
                case 1044703554:  // deprecatedAnnotation
                    return ((ImmDeprecated) bean).getDeprecatedAnnotation();
                case 1434300979:  // deprecatedOptional
                    return ((ImmDeprecated) bean).deprecatedOptional;
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            metaProperty(propertyName);
            if (quiet) {
                return;
            }
            throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
        }

    }

    //-----------------------------------------------------------------------
    /**
     * The bean-builder for {@code ImmDeprecated}.
     */
    public static final class Builder extends DirectFieldsBeanBuilder<ImmDeprecated> {

        private String deprecatedBoth;
        private String deprecatedJavadoc;
        private String deprecatedAnnotation;
        private String deprecatedOptional;

        /**
         * Restricted constructor.
         */
        private Builder() {
        }

        /**
         * Restricted copy constructor.
         * @param beanToCopy  the bean to copy from, not null
         */
        private Builder(ImmDeprecated beanToCopy) {
            this.deprecatedBoth = beanToCopy.getDeprecatedBoth();
            this.deprecatedJavadoc = beanToCopy.getDeprecatedJavadoc();
            this.deprecatedAnnotation = beanToCopy.getDeprecatedAnnotation();
            this.deprecatedOptional = beanToCopy.deprecatedOptional;
        }

        //-----------------------------------------------------------------------
        @Override
        public Object get(String propertyName) {
            switch (propertyName.hashCode()) {
                case -1108081708:  // deprecatedBoth
                    return this.deprecatedBoth;
                case -1632501085:  // deprecatedJavadoc
                    return this.deprecatedJavadoc;
                case 1044703554:  // deprecatedAnnotation
                    return this.deprecatedAnnotation;
                case 1434300979:  // deprecatedOptional
                    return this.deprecatedOptional;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
        }

        @Override
        public Builder set(String propertyName, Object newValue) {
            switch (propertyName.hashCode()) {
                case -1108081708:  // deprecatedBoth
                    this.deprecatedBoth = (String) newValue;
                    break;
                case -1632501085:  // deprecatedJavadoc
                    this.deprecatedJavadoc = (String) newValue;
                    break;
                case 1044703554:  // deprecatedAnnotation
                    this.deprecatedAnnotation = (String) newValue;
                    break;
                case 1434300979:  // deprecatedOptional
                    this.deprecatedOptional = (String) newValue;
                    break;
                default:
                    throw new NoSuchElementException("Unknown property: " + propertyName);
            }
            return this;
        }

        @Override
        public Builder set(MetaProperty<?> property, Object value) {
            super.set(property, value);
            return this;
        }

        @Override
        public ImmDeprecated build() {
            return new ImmDeprecated(
                    deprecatedBoth,
                    deprecatedJavadoc,
                    deprecatedAnnotation,
                    deprecatedOptional);
        }

        //-----------------------------------------------------------------------
        /**
         * Sets the field with deprecated annotation and Javadoc tag.
         * @param deprecatedBoth  the new value
         * @return this, for chaining, not null
         * @deprecated Use something else
         */
        @Deprecated
        public Builder deprecatedBoth(String deprecatedBoth) {
            this.deprecatedBoth = deprecatedBoth;
            return this;
        }

        /**
         * Sets the field with deprecated Javadoc tag only.
         * @param deprecatedJavadoc  the new value
         * @return this, for chaining, not null
         * @deprecated Use something else
         */
        @Deprecated
        public Builder deprecatedJavadoc(String deprecatedJavadoc) {
            this.deprecatedJavadoc = deprecatedJavadoc;
            return this;
        }

        /**
         * Sets the deprecatedAnnotation.
         * @param deprecatedAnnotation  the new value
         * @return this, for chaining, not null
         * @deprecated Deprecated
         */
        @Deprecated
        public Builder deprecatedAnnotation(String deprecatedAnnotation) {
            this.deprecatedAnnotation = deprecatedAnnotation;
            return this;
        }

        /**
         * Sets the deprecatedOptional.
         * @param deprecatedOptional  the new value
         * @return this, for chaining, not null
         * @deprecated Deprecated
         */
        @Deprecated
        public Builder deprecatedOptional(String deprecatedOptional) {
            this.deprecatedOptional = deprecatedOptional;
            return this;
        }

        //-----------------------------------------------------------------------
        @Override
        public String toString() {
            StringBuilder buf = new StringBuilder(160);
            buf.append("ImmDeprecated.Builder{");
            buf.append("deprecatedBoth").append('=').append(JodaBeanUtils.toString(deprecatedBoth)).append(',').append(' ');
            buf.append("deprecatedJavadoc").append('=').append(JodaBeanUtils.toString(deprecatedJavadoc)).append(',').append(' ');
            buf.append("deprecatedAnnotation").append('=').append(JodaBeanUtils.toString(deprecatedAnnotation)).append(',').append(' ');
            buf.append("deprecatedOptional").append('=').append(JodaBeanUtils.toString(deprecatedOptional));
            buf.append('}');
            return buf.toString();
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
