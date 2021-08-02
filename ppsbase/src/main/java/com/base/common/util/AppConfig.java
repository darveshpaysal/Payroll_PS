package com.base.common.util;

/**
 *
 * @author raman
 */
public class AppConfig {

    public enum ConfigType {
        APP("APP"),
        TRIAL("TRIAL");

        private String value;

        public String getValue() {
            return value;
        }

        private ConfigType(String value) {
            this.value = value;
        }
    }

    public enum ConfigParam {
        TRIAL_PERIOD_DAYS("TRIAL_PERIOD_DAYS"),
        SESSION_WARNING_TIME("SESSION_WARNING_TIME"),       
        MAX_LOGIN_ATTEMPT("MAX_LOGIN_ATTEMPT"),
        PRODUCT_SKU_LENTH("PRODUCT_SKU_LENTH"),
        PRODUCT_SKU_WIDTH("PRODUCT_SKU_WIDTH"),
        PRODUCT_SKU_HEIGHT("PRODUCT_SKU_HEIGHT"),
        PRODUCT_SKU_WEIGHT("PRODUCT_SKU_WEIGHT"),
        ORDER_SLEEP_TIME("ORDER_SLEEP_TIME"),
        SHIPPING_METHOD_DESC("SHIPPING_METHOD_DESC"),
        APP_CONTEXT_PATH("APP_CONTEXT_PATH"),
        DEFAULT_BUFFER_CUPS("BUFFER_CUPS"),
        GEOCODING_API_KEY("GEOCODING_API_KEY"),
        COOKIE_MAX_AGE("COOKIE_MAX_AGE"),
        CONTACT_CODE_EXPIRY_MINUTES("CONTACT_CODE_EXPIRY_MINUTES"),
        KPI_COLUMNS("KPI_COLUMNS");

        private String value;

        public String getValue() {
            return value;
        }

        private ConfigParam(String value) {
            this.value = value;
        }
    }
}
