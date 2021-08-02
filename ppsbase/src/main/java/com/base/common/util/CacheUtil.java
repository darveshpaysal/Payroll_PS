package com.base.common.util;

import com.base.biz.service.AppCacheSO;
import static com.base.common.util.AppUtil.isBlank;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Raman
 */
public class CacheUtil {

    private static final Map<String, Map<String, Object>> cache = new HashMap<>();

    private CacheUtil() {
    }

    public static Object get(CacheTypeKey cacheTypeKey, String elementKey) {
        Object object = null;
        if (cacheTypeKey != null) {
            Map<String, Object> typeMap = get(cacheTypeKey);
            if (typeMap != null && !typeMap.isEmpty()) {
                if (!isBlank(elementKey)) {
                    object = typeMap.get(elementKey);
                } else {
                    object = typeMap;
                }
            }
        }
        return object;
    }

    public static Map<String, Object> get(CacheTypeKey cacheTypeKey) {
        Map<String, Object> values = null;
        if (cacheTypeKey != null) {
            values = cache.get(cacheTypeKey.getValue());
            if (values == null || values.isEmpty()) {
                values = initCacheType(cacheTypeKey);
            }
        }
        return values;
    }

    public static Map<String, Object> initCacheType(CacheTypeKey cacheTypeKey) {
       Map<String, Object> values = null;
        if (cacheTypeKey != null) {
            values = AppCacheSO.getInstance().loadCache(cacheTypeKey.getValue());
            if (values != null) {
                cache.put(cacheTypeKey.getValue(), values);
            }
        }
        return values;
    }

    public static void initCache() {
        cache.clear();
        for (CacheTypeKey cacheType : CacheTypeKey.values()) {
            initCacheType(cacheType);
        }

    }

    public static enum CacheTypeKey {
        SYSTEM_MESSAGES("SYSTEM_MESSAGES");
        private String value;

        private CacheTypeKey(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static String getSystemMessage(String msgId) {
        return (String) get(CacheTypeKey.SYSTEM_MESSAGES, msgId);
    }

    public static String getSystemMessage(String msgId, String... values) {
        String message = (String) get(CacheTypeKey.SYSTEM_MESSAGES, msgId);
        int count = 1;
        if (values != null && values.length > 0) {
            for (String replaceBy : values) {
                message = replaceMgsWithPlaceHolder(message, "{" + count + "}", replaceBy);
                count++;
            }
        }
        return message;
    }

    public static String replaceMgsWithPlaceHolder(String msg, String replaceMe, String replaceBy) {
        StringBuilder sb = new StringBuilder(msg);
        if (!(isBlank(msg) || isBlank(replaceMe) || isBlank(replaceBy))) {
            int start = msg.indexOf(replaceMe);
            if (start > -1) {
                sb.replace(start, start + replaceMe.length(), replaceBy);
            } else {
                //TODO if any of the parameter is blank or empty
            }
        } else {
            //TODO if any of the parameter is blank or empty
        }
        return sb.toString();
    }

    public static enum SysMsgs {
        MEMB_CHECK_IN_TODAY_TEST("CHECK_IN_101"),
        MEMB_CHECK_IN_NOT_TODAY_TEST("CHECK_IN_102"),
        MEMB_TEST_NEG("TESTS_103"),
        MEMB_TEST_DEC("TESTS_104"),
        MEMB_TEST_POS("TESTS_105"),
        MEMB_TEST_RES("TESTS_106"),
        MEMB_TEST_LAT("TESTS_107"),
        PTNR_MEMB_CHECK_IN("CHECK_IN_108"),
        PTNR_MEMB_NOT_CHECK_IN("CHECK_IN_109"),
        PTNR_MEMB_TEST_TODAY("TESTS_110"),
        PTNR_MEMB_TEST_NOT_TODAY("TESTS_111"),
        PTNR_MEMB_TEST_RES("TESTS_112"),
        PTNR_MEMB_TEST_RES_VRFY("TESTS_113"),
        PTNR_MEMB_TEST_DEC("TESTS_114"),
        SPOT_CHECK("SPOT_115"),
        MEMB_SIGNUP("SIGNUP_117"),
        PTNR_SIGNUP("SIGNUP_118"),
        RELATIONSHIP_SIGNUP_MSG("SIGNUP_119"),
        BEING_PTNR_SIGNUP_MSG("SIGNUP_120"),
        CARD_OWNER_SIGNUP_MSG("SIGNUP_121"),
        SPOT_CHK_ACCT_ACTIVE("SPOT_122"),
        SPOT_CHK_CYCLE_DATE("SPOT_123"),
        SPOT_CHK_TOMORROW_EXIST("SPOT_124"),
        SPOT_CHK_TODAY_RANDOM_TEST("SPOT_125"),
        SPOT_CHK_FREE_TEST("SPOT_126"),
        SPOT_CHK_SCH_TOMORROW_PAID("SPOT_127"),
        SPOT_CHK_DISPLAY_MSG("SPOT_128"),
        SPOT_CHK_FREE_SCH("SPOT_130"),
        SPOT_CHK_PAID_ORDER("SPOT_131"),
        MEMB_SPOT_CHK_TOMORROW_EXIST("SPOT_132"),
        MEMB_SPOT_CHK_DISPLAY_MSG("SPOT_133"),
        MEMB_SPOT_CHK_ACCT_ACTIVE("SPOT_134"),
        MEMB_SPOT_CHK_CYCLE_DATE("SPOT_135"),
        MEMB_SPOT_CHK_MONIT_EVENT("SPOT_136"),
        SPOT_CHK_MONITORING_EVENT("SPOT_137"),
        UNUSED_SPOT_CHK_TEST("SPOT_139"),
        SPOT_CHK_SCHEDULED_MSG("SPOT_140"),
        SPOT_CHK_NO_PLAN("SPOT_141"),
        IMDT_SPOT_CHK_SCH("SPOT_142"),
        SPOT_CHK_TEST_AWAITING("SPOT_143"),
        MGR_FREE_SPOT_CHK_CONT("SPOT_144"),
        TRIAL_PLAN_SIGNUP_MSG("SIGNUP_145"),
        LOGIN_FAILED("LOGIN_1"),
        BUSINESS_WELCOME_MSG("SIGNUP_146"),
        BUSINESS_WELCOME_COPY_MSG("SIGNUP_147"),
        BUSINESS_WELCOME_SIG_MSG("SIGNUP_148")
        ;
        private String value;

        private SysMsgs() {
        }

        private SysMsgs(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
