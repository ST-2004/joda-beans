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

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Currency;
import java.util.List;

import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.TypedMetaBean;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.DerivedProperty;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/**
 * Mock light bean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition(style = "light", constructorScope = "package")
public final class LightImmutable implements ImmutableBean, Serializable {

    /**
     * The number.
     */
    @PropertyDefinition
    private final int number;
    /**
     * The number.
     */
    @PropertyDefinition
    private final boolean flag;
    /**
     * The street.
     */
    @PropertyDefinition(validate = "notNull", get = "field")
    private final String street;
    /**
     * The town.
     */
    @PropertyDefinition(get = "optionalGuava")
    private final String town;
    /**
     * The city.
     */
    @PropertyDefinition(validate = "notNull", alias = "place")
    private final String city;
    /**
     * The owner.
     */
    @PropertyDefinition(validate = "notNull")
    private final ImmPerson owner;
    /**
     * The list.
     */
    @PropertyDefinition(validate = "notNull")
    private final ImmutableList<String> list;
    /**
     * The currency.
     */
    @PropertyDefinition(get = "optionalGuava")
    private final Currency currency;
    /**
     * The hidden text.
     */
    @PropertyDefinition(get = "")
    private final String hiddenText;
    /**
     * The long.
     */
    @PropertyDefinition
    private final long valueLong;
    /**
     * The short.
     */
    @PropertyDefinition
    private final short valueShort;
    /**
     * The char.
     */
    @PropertyDefinition
    private final char valueChar;
    /**
     * The byte.
     */
    @PropertyDefinition
    private final byte valueByte;

    //-----------------------------------------------------------------------
    // manual getter with a different name
    public String getStreetName() {
        return street;
    }

    // derived
    @DerivedProperty
    public String getAddress() {
        return number + " " + street + " " + city;
    }

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code LightImmutable}.
     */
    private static final TypedMetaBean<LightImmutable> META_BEAN =
            LightMetaBean.of(
                    LightImmutable.class,
                    MethodHandles.lookup(),
                    new String[] {
                            "number",
                            "flag",
                            "street",
                            "town",
                            "city",
                            "owner",
                            "list",
                            "currency",
                            "hiddenText",
                            "valueLong",
                            "valueShort",
                            "valueChar",
                            "valueByte"},
                    0,
                    Boolean.FALSE,
                    null,
                    null,
                    null,
                    null,
                    ImmutableList.of(),
                    null,
                    null,
                    0L,
                    (short) 0,
                    '\u0000',
                    (byte) 0)
                    .withAlias("place", "city");

    /**
     * The meta-bean for {@code LightImmutable}.
     * @return the meta-bean, not null
     */
    public static TypedMetaBean<LightImmutable> meta() {
        return META_BEAN;
    }

    static {
        MetaBean.register(META_BEAN);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance.
     * @param number  the value of the property
     * @param flag  the value of the property
     * @param street  the value of the property, not null
     * @param town  the value of the property
     * @param city  the value of the property, not null
     * @param owner  the value of the property, not null
     * @param list  the value of the property, not null
     * @param currency  the value of the property
     * @param hiddenText  the value of the property
     * @param valueLong  the value of the property
     * @param valueShort  the value of the property
     * @param valueChar  the value of the property
     * @param valueByte  the value of the property
     */
    LightImmutable(
            int number,
            boolean flag,
            String street,
            String town,
            String city,
            ImmPerson owner,
            List<String> list,
            Currency currency,
            String hiddenText,
            long valueLong,
            short valueShort,
            char valueChar,
            byte valueByte) {
        JodaBeanUtils.notNull(street, "street");
        JodaBeanUtils.notNull(city, "city");
        JodaBeanUtils.notNull(owner, "owner");
        JodaBeanUtils.notNull(list, "list");
        this.number = number;
        this.flag = flag;
        this.street = street;
        this.town = town;
        this.city = city;
        this.owner = owner;
        this.list = ImmutableList.copyOf(list);
        this.currency = currency;
        this.hiddenText = hiddenText;
        this.valueLong = valueLong;
        this.valueShort = valueShort;
        this.valueChar = valueChar;
        this.valueByte = valueByte;
    }

    @Override
    public TypedMetaBean<LightImmutable> metaBean() {
        return META_BEAN;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public int getNumber() {
        return number;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public boolean isFlag() {
        return flag;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the town.
     * @return the optional value of the property, not null
     */
    public Optional<String> getTown() {
        return Optional.fromNullable(town);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the city.
     * @return the value of the property, not null
     */
    public String getCity() {
        return city;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the owner.
     * @return the value of the property, not null
     */
    public ImmPerson getOwner() {
        return owner;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the list.
     * @return the value of the property, not null
     */
    public ImmutableList<String> getList() {
        return list;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the currency.
     * @return the optional value of the property, not null
     */
    public Optional<Currency> getCurrency() {
        return Optional.fromNullable(currency);
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the long.
     * @return the value of the property
     */
    public long getValueLong() {
        return valueLong;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the short.
     * @return the value of the property
     */
    public short getValueShort() {
        return valueShort;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the char.
     * @return the value of the property
     */
    public char getValueChar() {
        return valueChar;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the byte.
     * @return the value of the property
     */
    public byte getValueByte() {
        return valueByte;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            LightImmutable other = (LightImmutable) obj;
            return (this.number == other.number) &&
                    (this.flag == other.flag) &&
                    JodaBeanUtils.equal(this.street, other.street) &&
                    JodaBeanUtils.equal(this.town, other.town) &&
                    JodaBeanUtils.equal(this.city, other.city) &&
                    JodaBeanUtils.equal(this.owner, other.owner) &&
                    JodaBeanUtils.equal(this.list, other.list) &&
                    JodaBeanUtils.equal(this.currency, other.currency) &&
                    JodaBeanUtils.equal(this.hiddenText, other.hiddenText) &&
                    (this.valueLong == other.valueLong) &&
                    (this.valueShort == other.valueShort) &&
                    (this.valueChar == other.valueChar) &&
                    (this.valueByte == other.valueByte);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(number);
        hash = hash * 31 + JodaBeanUtils.hashCode(flag);
        hash = hash * 31 + JodaBeanUtils.hashCode(street);
        hash = hash * 31 + JodaBeanUtils.hashCode(town);
        hash = hash * 31 + JodaBeanUtils.hashCode(city);
        hash = hash * 31 + JodaBeanUtils.hashCode(owner);
        hash = hash * 31 + JodaBeanUtils.hashCode(list);
        hash = hash * 31 + JodaBeanUtils.hashCode(currency);
        hash = hash * 31 + JodaBeanUtils.hashCode(hiddenText);
        hash = hash * 31 + JodaBeanUtils.hashCode(valueLong);
        hash = hash * 31 + JodaBeanUtils.hashCode(valueShort);
        hash = hash * 31 + JodaBeanUtils.hashCode(valueChar);
        hash = hash * 31 + JodaBeanUtils.hashCode(valueByte);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(480);
        buf.append("LightImmutable{");
        buf.append("number").append('=').append(JodaBeanUtils.toString(number)).append(',').append(' ');
        buf.append("flag").append('=').append(JodaBeanUtils.toString(flag)).append(',').append(' ');
        buf.append("street").append('=').append(JodaBeanUtils.toString(street)).append(',').append(' ');
        buf.append("town").append('=').append(JodaBeanUtils.toString(town)).append(',').append(' ');
        buf.append("city").append('=').append(JodaBeanUtils.toString(city)).append(',').append(' ');
        buf.append("owner").append('=').append(JodaBeanUtils.toString(owner)).append(',').append(' ');
        buf.append("list").append('=').append(JodaBeanUtils.toString(list)).append(',').append(' ');
        buf.append("currency").append('=').append(JodaBeanUtils.toString(currency)).append(',').append(' ');
        buf.append("hiddenText").append('=').append(JodaBeanUtils.toString(hiddenText)).append(',').append(' ');
        buf.append("valueLong").append('=').append(JodaBeanUtils.toString(valueLong)).append(',').append(' ');
        buf.append("valueShort").append('=').append(JodaBeanUtils.toString(valueShort)).append(',').append(' ');
        buf.append("valueChar").append('=').append(JodaBeanUtils.toString(valueChar)).append(',').append(' ');
        buf.append("valueByte").append('=').append(JodaBeanUtils.toString(valueByte)).append(',').append(' ');
        buf.append("address").append('=').append(JodaBeanUtils.toString(getAddress()));
        buf.append('}');
        return buf.toString();
    }

    //-------------------------- AUTOGENERATED END --------------------------
}
