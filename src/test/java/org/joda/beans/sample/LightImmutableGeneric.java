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
import java.util.List;

import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaBean;
import org.joda.beans.TypedMetaBean;
import org.joda.beans.gen.BeanDefinition;
import org.joda.beans.gen.PropertyDefinition;
import org.joda.beans.impl.light.LightMetaBean;

import com.google.common.collect.ImmutableList;

/**
 * Mock light bean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition(style = "light")
public final class LightImmutableGeneric<T extends Number> implements ImmutableBean, Serializable {

    /**
     * The number.
     */
    @PropertyDefinition
    private final T number;
    /**
     * The number.
     */
    @PropertyDefinition
    private final List<T> list;

    //------------------------- AUTOGENERATED START -------------------------
    /**
     * The meta-bean for {@code LightImmutableGeneric}.
     */
    private static final MetaBean META_BEAN =
            LightMetaBean.of(
                    LightImmutableGeneric.class,
                    MethodHandles.lookup(),
                    new String[] {
                            "number",
                            "list"},
                    null,
                    ImmutableList.of());

    /**
     * The meta-bean for {@code LightImmutableGeneric}.
     * @return the meta-bean, not null
     */
    public static MetaBean meta() {
        return META_BEAN;
    }

    static {
        MetaBean.register(META_BEAN);
    }

    /**
     * The serialization version id.
     */
    private static final long serialVersionUID = 1L;

    private LightImmutableGeneric(
            T number,
            List<T> list) {
        this.number = number;
        this.list = (list != null ? ImmutableList.copyOf(list) : null);
    }

    @Override
    @SuppressWarnings("unchecked")
    public TypedMetaBean<LightImmutableGeneric<T>> metaBean() {
        return (TypedMetaBean<LightImmutableGeneric<T>>) META_BEAN;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public T getNumber() {
        return number;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the number.
     * @return the value of the property
     */
    public List<T> getList() {
        return list;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            LightImmutableGeneric<?> other = (LightImmutableGeneric<?>) obj;
            return JodaBeanUtils.equal(this.number, other.number) &&
                    JodaBeanUtils.equal(this.list, other.list);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = getClass().hashCode();
        hash = hash * 31 + JodaBeanUtils.hashCode(number);
        hash = hash * 31 + JodaBeanUtils.hashCode(list);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(96);
        buf.append("LightImmutableGeneric{");
        buf.append("number").append('=').append(JodaBeanUtils.toString(number)).append(',').append(' ');
        buf.append("list").append('=').append(JodaBeanUtils.toString(list));
        buf.append('}');
        return buf.toString();
    }

    //-------------------------- AUTOGENERATED END --------------------------
}
