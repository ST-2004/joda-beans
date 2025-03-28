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
 * Mock address JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class SimpleName
        implements Bean {

    /** The forename. */
    @PropertyDefinition(alias = "firstName")
    private String forename;
    /** The  middle names. */
    @PropertyDefinition
    private String[] middleNames;
    /** The surname. */
    @PropertyDefinition(alias = "givenName")
    private String surname;

    /**
     * Creates an instance.
     */
    public SimpleName() {
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code SimpleName}.
     * @return the meta-bean, not null
     */
    public static SimpleName.Meta meta() {
        return SimpleName.Meta.INSTANCE;
    }

    static {
        MetaBean.register(SimpleName.Meta.INSTANCE);
    }

    @Override
    public SimpleName.Meta metaBean() {
        return SimpleName.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the forename.
     * @return the value of the property
     */
    public String getForename() {
        return forename;
    }

    /**
     * Sets the forename.
     * @param forename  the new value of the property
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * Gets the the {@code forename} property.
     * @return the property, not null
     */
    public final Property<String> forename() {
        return metaBean().forename().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the  middle names.
     * @return the value of the property
     */
    public String[] getMiddleNames() {
        return middleNames;
    }

    /**
     * Sets the  middle names.
     * @param middleNames  the new value of the property
     */
    public void setMiddleNames(String[] middleNames) {
        this.middleNames = middleNames;
    }

    /**
     * Gets the the {@code middleNames} property.
     * @return the property, not null
     */
    public final Property<String[]> middleNames() {
        return metaBean().middleNames().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the surname.
     * @return the value of the property
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the surname.
     * @param surname  the new value of the property
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Gets the the {@code surname} property.
     * @return the property, not null
     */
    public final Property<String> surname() {
        return metaBean().surname().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public SimpleName clone() {
        return JodaBeanUtils.cloneAlways(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            SimpleName other = (SimpleName) obj;
            return JodaBeanUtils.equal(this.getForename(), other.getForename()) &&
                    JodaBeanUtils.equal(this.getMiddleNames(), other.getMiddleNames()) &&
                    JodaBeanUtils.equal(this.getSurname(), other.getSurname());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(getForename());
        hash = hash * 31 + JodaBeanUtils.hashCode(getMiddleNames());
        hash = hash * 31 + JodaBeanUtils.hashCode(getSurname());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(128);
        buf.append("SimpleName{");
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    protected void toString(StringBuilder buf) {
        buf.append("forename").append('=').append(JodaBeanUtils.toString(getForename())).append(',').append(' ');
        buf.append("middleNames").append('=').append(JodaBeanUtils.toString(getMiddleNames())).append(',').append(' ');
        buf.append("surname").append('=').append(JodaBeanUtils.toString(getSurname())).append(',').append(' ');
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code SimpleName}.
     */
    public static class Meta extends DirectMetaBean {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-property for the {@code forename} property.
         */
        private final MetaProperty<String> forename = DirectMetaProperty.ofReadWrite(
                this, "forename", SimpleName.class, String.class);
        /**
         * The meta-property for the {@code middleNames} property.
         */
        private final MetaProperty<String[]> middleNames = DirectMetaProperty.ofReadWrite(
                this, "middleNames", SimpleName.class, String[].class);
        /**
         * The meta-property for the {@code surname} property.
         */
        private final MetaProperty<String> surname = DirectMetaProperty.ofReadWrite(
                this, "surname", SimpleName.class, String.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "forename",
                "middleNames",
                "surname");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                case 132835675:  // firstName (alias)
                    return this.forename;
                case 404996787:  // middleNames
                    return this.middleNames;
                case -1852993317:  // surname
                case 1469046696:  // givenName (alias)
                    return this.surname;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends SimpleName> builder() {
            return new DirectBeanBuilder<>(new SimpleName());
        }

        @Override
        public Class<? extends SimpleName> beanType() {
            return SimpleName.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
        /**
         * The meta-property for the {@code forename} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> forename() {
            return forename;
        }

        /**
         * The meta-property for the {@code middleNames} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String[]> middleNames() {
            return middleNames;
        }

        /**
         * The meta-property for the {@code surname} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> surname() {
            return surname;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                case 132835675:  // firstName (alias)
                    return ((SimpleName) bean).getForename();
                case 404996787:  // middleNames
                    return ((SimpleName) bean).getMiddleNames();
                case -1852993317:  // surname
                case 1469046696:  // givenName (alias)
                    return ((SimpleName) bean).getSurname();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                case 132835675:  // firstName (alias)
                    ((SimpleName) bean).setForename((String) newValue);
                    return;
                case 404996787:  // middleNames
                    ((SimpleName) bean).setMiddleNames((String[]) newValue);
                    return;
                case -1852993317:  // surname
                case 1469046696:  // givenName (alias)
                    ((SimpleName) bean).setSurname((String) newValue);
                    return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    //-------------------------- AUTOGENERATED END --------------------------
}
