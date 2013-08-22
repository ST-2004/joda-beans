/*
 *  Copyright 2001-2013 Stephen Colebourne
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
package org.joda.beans.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlID;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;
import org.joda.beans.impl.flexi.FlexiBean;

/**
 * Mock person JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public final class SimplePerson implements Cloneable, Bean {

    /** The forename. */
    @PropertyDefinition
    private String forename;
    /** The surname. */
    @PropertyDefinition
    private String surname;
    /** The number of cars. */
    @PropertyDefinition
    private transient int numberOfCars;
    @PropertyDefinition
    private final List<Address> addressList = new ArrayList<Address>();
    @PropertyDefinition
    private final Map<String, Address> otherAddressMap = new HashMap<String, Address>();
    @PropertyDefinition
    private final List<List<Address>> addressesList = new ArrayList<List<Address>>();
    @PropertyDefinition
    private Address mainAddress;
    @PropertyDefinition
    @XmlID
    private final FlexiBean extensions = new FlexiBean();

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code SimplePerson}.
     * @return the meta-bean, not null
     */
    public static SimplePerson.Meta meta() {
        return SimplePerson.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(SimplePerson.Meta.INSTANCE);
    }

    @Override
    public SimplePerson.Meta metaBean() {
        return SimplePerson.Meta.INSTANCE;
    }

    @Override
    public <R> Property<R> property(String propertyName) {
        return metaBean().<R>metaProperty(propertyName).createProperty(this);
    }

    @Override
    public Set<String> propertyNames() {
        return metaBean().metaPropertyMap().keySet();
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
    /**
     * Gets the number of cars.
     * @return the value of the property
     */
    public int getNumberOfCars() {
        return numberOfCars;
    }

    /**
     * Sets the number of cars.
     * @param numberOfCars  the new value of the property
     */
    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    /**
     * Gets the the {@code numberOfCars} property.
     * @return the property, not null
     */
    public final Property<Integer> numberOfCars() {
        return metaBean().numberOfCars().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the addressList.
     * @return the value of the property
     */
    public List<Address> getAddressList() {
        return addressList;
    }

    /**
     * Sets the addressList.
     * @param addressList  the new value of the property
     */
    public void setAddressList(List<Address> addressList) {
        this.addressList.clear();
        this.addressList.addAll(addressList);
    }

    /**
     * Gets the the {@code addressList} property.
     * @return the property, not null
     */
    public final Property<List<Address>> addressList() {
        return metaBean().addressList().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the otherAddressMap.
     * @return the value of the property
     */
    public Map<String, Address> getOtherAddressMap() {
        return otherAddressMap;
    }

    /**
     * Sets the otherAddressMap.
     * @param otherAddressMap  the new value of the property
     */
    public void setOtherAddressMap(Map<String, Address> otherAddressMap) {
        this.otherAddressMap.clear();
        this.otherAddressMap.putAll(otherAddressMap);
    }

    /**
     * Gets the the {@code otherAddressMap} property.
     * @return the property, not null
     */
    public final Property<Map<String, Address>> otherAddressMap() {
        return metaBean().otherAddressMap().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the addressesList.
     * @return the value of the property
     */
    public List<List<Address>> getAddressesList() {
        return addressesList;
    }

    /**
     * Sets the addressesList.
     * @param addressesList  the new value of the property
     */
    public void setAddressesList(List<List<Address>> addressesList) {
        this.addressesList.clear();
        this.addressesList.addAll(addressesList);
    }

    /**
     * Gets the the {@code addressesList} property.
     * @return the property, not null
     */
    public final Property<List<List<Address>>> addressesList() {
        return metaBean().addressesList().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the mainAddress.
     * @return the value of the property
     */
    public Address getMainAddress() {
        return mainAddress;
    }

    /**
     * Sets the mainAddress.
     * @param mainAddress  the new value of the property
     */
    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    /**
     * Gets the the {@code mainAddress} property.
     * @return the property, not null
     */
    public final Property<Address> mainAddress() {
        return metaBean().mainAddress().createProperty(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the extensions.
     * @return the value of the property
     */
    public FlexiBean getExtensions() {
        return extensions;
    }

    /**
     * Sets the extensions.
     * @param extensions  the new value of the property
     */
    public void setExtensions(FlexiBean extensions) {
        this.extensions.clear();
        this.extensions.putAll(extensions);
    }

    /**
     * Gets the the {@code extensions} property.
     * @return the property, not null
     */
    public final Property<FlexiBean> extensions() {
        return metaBean().extensions().createProperty(this);
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            SimplePerson other = (SimplePerson) obj;
            return JodaBeanUtils.equal(getForename(), other.getForename()) &&
                    JodaBeanUtils.equal(getSurname(), other.getSurname()) &&
                    (getNumberOfCars() == other.getNumberOfCars()) &&
                    JodaBeanUtils.equal(getAddressList(), other.getAddressList()) &&
                    JodaBeanUtils.equal(getOtherAddressMap(), other.getOtherAddressMap()) &&
                    JodaBeanUtils.equal(getAddressesList(), other.getAddressesList()) &&
                    JodaBeanUtils.equal(getMainAddress(), other.getMainAddress()) &&
                    JodaBeanUtils.equal(getExtensions(), other.getExtensions());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash += hash * 31 + JodaBeanUtils.hashCode(getForename());
        hash += hash * 31 + JodaBeanUtils.hashCode(getSurname());
        hash += hash * 31 + JodaBeanUtils.hashCode(getNumberOfCars());
        hash += hash * 31 + JodaBeanUtils.hashCode(getAddressList());
        hash += hash * 31 + JodaBeanUtils.hashCode(getOtherAddressMap());
        hash += hash * 31 + JodaBeanUtils.hashCode(getAddressesList());
        hash += hash * 31 + JodaBeanUtils.hashCode(getMainAddress());
        hash += hash * 31 + JodaBeanUtils.hashCode(getExtensions());
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(288);
        buf.append(getClass().getSimpleName());
        buf.append('{');
        buf.append("forename").append('=').append(getForename()).append(',').append(' ');
        buf.append("surname").append('=').append(getSurname()).append(',').append(' ');
        buf.append("numberOfCars").append('=').append(getNumberOfCars()).append(',').append(' ');
        buf.append("addressList").append('=').append(getAddressList()).append(',').append(' ');
        buf.append("otherAddressMap").append('=').append(getOtherAddressMap()).append(',').append(' ');
        buf.append("addressesList").append('=').append(getAddressesList()).append(',').append(' ');
        buf.append("mainAddress").append('=').append(getMainAddress()).append(',').append(' ');
        buf.append("extensions").append('=').append(getExtensions());
        buf.append('}');
        return buf.toString();
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code SimplePerson}.
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
                this, "forename", SimplePerson.class, String.class);
        /**
         * The meta-property for the {@code surname} property.
         */
        private final MetaProperty<String> surname = DirectMetaProperty.ofReadWrite(
                this, "surname", SimplePerson.class, String.class);
        /**
         * The meta-property for the {@code numberOfCars} property.
         */
        private final MetaProperty<Integer> numberOfCars = DirectMetaProperty.ofReadWrite(
                this, "numberOfCars", SimplePerson.class, Integer.TYPE);
        /**
         * The meta-property for the {@code addressList} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<Address>> addressList = DirectMetaProperty.ofReadWrite(
                this, "addressList", SimplePerson.class, (Class) List.class);
        /**
         * The meta-property for the {@code otherAddressMap} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<Map<String, Address>> otherAddressMap = DirectMetaProperty.ofReadWrite(
                this, "otherAddressMap", SimplePerson.class, (Class) Map.class);
        /**
         * The meta-property for the {@code addressesList} property.
         */
        @SuppressWarnings({"unchecked", "rawtypes" })
        private final MetaProperty<List<List<Address>>> addressesList = DirectMetaProperty.ofReadWrite(
                this, "addressesList", SimplePerson.class, (Class) List.class);
        /**
         * The meta-property for the {@code mainAddress} property.
         */
        private final MetaProperty<Address> mainAddress = DirectMetaProperty.ofReadWrite(
                this, "mainAddress", SimplePerson.class, Address.class);
        /**
         * The meta-property for the {@code extensions} property.
         */
        private final MetaProperty<FlexiBean> extensions = DirectMetaProperty.ofReadWrite(
                this, "extensions", SimplePerson.class, FlexiBean.class);
        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, null,
                "forename",
                "surname",
                "numberOfCars",
                "addressList",
                "otherAddressMap",
                "addressesList",
                "mainAddress",
                "extensions");

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        protected MetaProperty<?> metaPropertyGet(String propertyName) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return forename;
                case -1852993317:  // surname
                    return surname;
                case 926656063:  // numberOfCars
                    return numberOfCars;
                case -1377524046:  // addressList
                    return addressList;
                case 1368089592:  // otherAddressMap
                    return otherAddressMap;
                case -226885792:  // addressesList
                    return addressesList;
                case -2032731141:  // mainAddress
                    return mainAddress;
                case -1809421292:  // extensions
                    return extensions;
            }
            return super.metaPropertyGet(propertyName);
        }

        @Override
        public BeanBuilder<? extends SimplePerson> builder() {
            return new DirectBeanBuilder<SimplePerson>(new SimplePerson());
        }

        @Override
        public Class<? extends SimplePerson> beanType() {
            return SimplePerson.class;
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
         * The meta-property for the {@code surname} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<String> surname() {
            return surname;
        }

        /**
         * The meta-property for the {@code numberOfCars} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Integer> numberOfCars() {
            return numberOfCars;
        }

        /**
         * The meta-property for the {@code addressList} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<List<Address>> addressList() {
            return addressList;
        }

        /**
         * The meta-property for the {@code otherAddressMap} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Map<String, Address>> otherAddressMap() {
            return otherAddressMap;
        }

        /**
         * The meta-property for the {@code addressesList} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<List<List<Address>>> addressesList() {
            return addressesList;
        }

        /**
         * The meta-property for the {@code mainAddress} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<Address> mainAddress() {
            return mainAddress;
        }

        /**
         * The meta-property for the {@code extensions} property.
         * @return the meta-property, not null
         */
        public final MetaProperty<FlexiBean> extensions() {
            return extensions;
        }

        //-----------------------------------------------------------------------
        @Override
        protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
            switch (propertyName.hashCode()) {
                case 467061063:  // forename
                    return ((SimplePerson) bean).getForename();
                case -1852993317:  // surname
                    return ((SimplePerson) bean).getSurname();
                case 926656063:  // numberOfCars
                    return ((SimplePerson) bean).getNumberOfCars();
                case -1377524046:  // addressList
                    return ((SimplePerson) bean).getAddressList();
                case 1368089592:  // otherAddressMap
                    return ((SimplePerson) bean).getOtherAddressMap();
                case -226885792:  // addressesList
                    return ((SimplePerson) bean).getAddressesList();
                case -2032731141:  // mainAddress
                    return ((SimplePerson) bean).getMainAddress();
                case -1809421292:  // extensions
                    return ((SimplePerson) bean).getExtensions();
            }
            return super.propertyGet(bean, propertyName, quiet);
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
            switch (propertyName.hashCode()) {
            case 467061063:  // forename
                ((SimplePerson) bean).setForename((String) newValue);
                return;
            case -1852993317:  // surname
                ((SimplePerson) bean).setSurname((String) newValue);
                return;
            case 926656063:  // numberOfCars
                ((SimplePerson) bean).setNumberOfCars((Integer) newValue);
                return;
            case -1377524046:  // addressList
                ((SimplePerson) bean).setAddressList((List<Address>) newValue);
                return;
            case 1368089592:  // otherAddressMap
                ((SimplePerson) bean).setOtherAddressMap((Map<String, Address>) newValue);
                return;
            case -226885792:  // addressesList
                ((SimplePerson) bean).setAddressesList((List<List<Address>>) newValue);
                return;
            case -2032731141:  // mainAddress
                ((SimplePerson) bean).setMainAddress((Address) newValue);
                return;
            case -1809421292:  // extensions
                ((SimplePerson) bean).setExtensions((FlexiBean) newValue);
                return;
            }
            super.propertySet(bean, propertyName, newValue, quiet);
        }

    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
