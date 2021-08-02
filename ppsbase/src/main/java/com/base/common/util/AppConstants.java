package com.base.common.util;

/**
 *
 * @author raman
 */
public class AppConstants {
    
    public static final String TEST_CREATED_BY_SYSTEM = "SYSTEM";

    public enum DashboardKPI {
        CHECKIN_STATUS("CheckinStatus"),
        CHECKIN_RATE("CheckinRate"),
        MISS_TEST_YTD("MissTest"),
        SEL_TEST_RESULT("SelectedTest"),
        PENDING_TEST("PendingTest");

        private String value;

        public String getValue() {
            return value;
        }

        private DashboardKPI(String value) {
            this.value = value;
        }
    }

    public enum TestResult {
        SKIPPED("SKIP"),
        NEGATIVE("NEG"),
        POSITIVE("POS"),
        INVALID("INV"),
        DECLINED("DEC"),
        PENDING("PEND");

        private String value;

        public String getValue() {
            return value;
        }

        private TestResult(String value) {
            this.value = value;
        }
    }

    public enum ServiceUserType {
        HAYVER_USER("HAYV_USER"),
        ORG_USER("ORG_USER"),
        FAC_USER("FAC_USER");

        private String value;

        public String getValue() {
            return value;
        }

        private ServiceUserType(String value) {
            this.value = value;
        }
    }   
    
    public enum BillingCycle {
        MONTHLY("MO"),
        QUARTERLY("Q"),
        YEARLY("YR"),
        ONE_TIME("OT"),
        DAILY("DL"),
        WEEKLY("WK");
        
        private String value;

        public String getValue() {
            return value;
        }

        private BillingCycle(String value) {
            this.value = value;
        }
    }
    
     public enum ConfigType {
        TRIAL("TRIAL");
        private String value;

        public String getValue() {
            return value;
        }

        private ConfigType(String value) {
            this.value = value;
        }
    }
     
    public enum CatalogAPIMethods {
        LIST_CATALOG("list_available_catalogs"),
        CATALOG_BREAKDOWN("catalog_breakdown"),
        SEARCH_CATALOG("search_catalog"),
        VIEW_ITEM("view_item"),
        CART_ADDRESS("cart_set_address"),
        CART_ITEM_QTY("cart_set_item_quantity"),
        CART_ADD_ITEM("cart_add_item"),
        CART_REMOVE_ITEM("cart_remove_item"),
        CART_VIEW("cart_view"),
        CART_VALIDATE("cart_validate"),
        CART_ORDER_PLACE("cart_order_place"),
        ORDER_PLACE("order_place"),
        ORDER_TRACK("order_track"),
        ORDER_LIST("order_list");

        private String value;

        public String getValue() {
            return value;
        }

        private CatalogAPIMethods(String value) {
            this.value = value;
        }
    }
    
    public enum Apps {
        HAYVER_RECOVERY("REC"),
        HAYVER_SHIELD("SHD"),
        HAYVER_GUARD("GRD"),
        GRD("GUARD"),
        SHD("SHIELD"),
        REC("RECOVERY");

        private String value;

        public String getValue() {
            return value;
        }

        private Apps(String value) {
            this.value = value;
        }
    } 
    
    public enum QrColors {
          BLUE(0xFF40BAD0),
          PURPLE(0xFF8A4F9E),
          RED(0xFFE91C43),
          ORANGE(0xFFF4B13D),
          GREEN(0xFF00FF00),
          WHITE(0xFFFFFFFF),
          BLACK(0xFF000000);

          private final int argb;

          QrColors(final int argb){
              this.argb = argb;
          }

          public int getArgb(){
              return argb;
          }
      }
   
}
