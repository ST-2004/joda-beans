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

import java.util.Map;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.impl.direct.DirectBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Mock JavaBean, used for testing.
 * 
 * @author Stephen Colebourne
 */
@BeanDefinition
public class CompanyAddressResult extends AbstractResult<CompanyAddress> {

    @Override
    public String getResultType() {
        return "CompanyAddress";
    }

    //------------------------- AUTOGENERATED START -------------------------
    ///CLOVER:OFF
    /**
     * The meta-bean for {@code CompanyAddressResult}.
     * @return the meta-bean, not null
     */
    public static CompanyAddressResult.Meta meta() {
        return CompanyAddressResult.Meta.INSTANCE;
    }

    static {
        JodaBeanUtils.registerMetaBean(CompanyAddressResult.Meta.INSTANCE);
    }

    @Override
    public CompanyAddressResult.Meta metaBean() {
        return CompanyAddressResult.Meta.INSTANCE;
    }

    //-----------------------------------------------------------------------
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            return super.equals(obj);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash ^ super.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder(32);
        buf.append(getClass().getSimpleName());
        buf.append('{');
        int len = buf.length();
        toString(buf);
        if (buf.length() > len) {
            buf.setLength(buf.length() - 2);
        }
        buf.append('}');
        return buf.toString();
    }

    @Override
    protected void toString(StringBuilder buf) {
        super.toString(buf);
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-bean for {@code CompanyAddressResult}.
     */
    public static class Meta extends AbstractResult.Meta<CompanyAddress> {
        /**
         * The singleton instance of the meta-bean.
         */
        static final Meta INSTANCE = new Meta();

        /**
         * The meta-properties.
         */
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
                this, (DirectMetaPropertyMap) super.metaPropertyMap());

        /**
         * Restricted constructor.
         */
        protected Meta() {
        }

        @Override
        public BeanBuilder<? extends CompanyAddressResult> builder() {
            return new DirectBeanBuilder<CompanyAddressResult>(new CompanyAddressResult());
        }

        @Override
        public Class<? extends CompanyAddressResult> beanType() {
            return CompanyAddressResult.class;
        }

        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }

        //-----------------------------------------------------------------------
    }

    ///CLOVER:ON
    //-------------------------- AUTOGENERATED END --------------------------
}
