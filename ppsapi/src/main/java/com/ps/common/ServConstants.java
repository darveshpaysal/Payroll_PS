package com.ps.common;

/**
 *
 * @author PS
 */
public class ServConstants {

    public static final String ACTION_KEY = "action";
    public static final String TYPE_KEY = "type";
    public static final String SKIP_KEY = "skip";
    public static final String TOP_KEY = "top";
    public static final String SORT_KEY = "sort";
    public static final String FILTER_KEY = "filter";
    public static final String PARAM_KEY = "param";
    public static final String PARAMS_KEY = "params";
    public static final String PAGE_NO_KEY = "page";
    public static final String PRICE_KEY = "pprice";
    public static final String BEDS_KEY = "pbeds";
    public static final String BATHS_KEY = "pbaths";
    public static final String AREA_KEY = "area";
    public static final String YEAR_BUILT_KEY = "year";
    public static final String PRICE_MAX_KEY = "maxpprice";
    public static final String BEDS_MAX_KEY = "maxpbeds";
    public static final String BATHS_MAX_KEY = "maxpbaths";
    public static final String AREA_MAX_KEY = "maxarea";
    public static final String YEAR_BUILT_MAX_KEY = "maxyear";
    public static final String PRICE_MIN_KEY = "minpprice";
    public static final String BEDS_MIN_KEY = "minpbeds";
    public static final String BATHS_MIN_KEY = "minpbaths";
    public static final String AREA_MIN_KEY = "minarea";
    public static final String YEAR_BUILT_MIN_KEY = "minyear";

    public enum Action {
        LOOKUP("lookup"),
        SAVE("save"),
        UPDATE("update"),
        DELETE("delete");

        private String value;

        public String getValue() {
            return value;
        }

        private Action(String value) {
            this.value = value;
        }
    }

    public enum RequestType {
        CF_DESIGNATION("designation"),
        CF_SALARY_TYPE("salary_type"),
        CF_DEPARTMENT("department"),
        CF_STATE("state"),
        PROPERTY_DETAILS("propdtls"),
        PROPERTY_FILTER("fltrdd"),
        SCHOOLS("schools"),
        NEIGHBORHOODS("nbhds"),
        SIMILER_HOMES("shomes"),
        USER_SIGNIN("signin"),
        USER_SIGNUP("signup"),
        USER_PROFILE("profile"),
        USER_CHANGE_PASSWORD("chgpwd"),
        USER_SAVED_SEARCH("savedsearch"),
        USER_SAVED_HOMES("savedhomes"),
        USER_CONTACT_REQUEST("contreq"),
        APP_RESOURCE_BANDLE("resbndl"),
        APP_CONFIG("appcfg"),
        APP_FAQ("faq"),
        APP_PAGE("apppage"),
        VALIDATE_ACCESS_CODE("valaccesscode"),
        PROP_PRICE_TAX_HIST("pricetaxhist"),
        PROP_SHOWING("propshowing"),
        USER_PRE_APPROVAL("preapprov");

        private String value;

        public String getValue() {
            return value;
        }

        private RequestType(String value) {
            this.value = value;
        }
    }

   

}
