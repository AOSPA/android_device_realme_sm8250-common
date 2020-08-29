package vendor.oppo.hardware.biometrics.fingerprintpay.V1_0;

import java.util.ArrayList;

public final class IFAAStatusCode {
    public static final int IFAA_ERR_AUTHENTICATOR_SIGN = 2046820371;
    public static final int IFAA_ERR_BAD_ACCESS = 2046820354;
    public static final int IFAA_ERR_BAD_PARAM = 2046820355;
    public static final int IFAA_ERR_BUF_TOO_SHORT = 2046820357;
    public static final int IFAA_ERR_ERASE = 2046820366;
    public static final int IFAA_ERR_GEN_RESPONSE = 2046820368;
    public static final int IFAA_ERR_GET_AUTHENTICATOR_VERSION = 2046820373;
    public static final int IFAA_ERR_GET_DEVICEID = 2046820369;
    public static final int IFAA_ERR_GET_ID_LIST = 2046820372;
    public static final int IFAA_ERR_GET_LAST_IDENTIFIED_RESULT = 2046820370;
    public static final int IFAA_ERR_HASH = 2046820360;
    public static final int IFAA_ERR_KEY_GEN = 2046820363;
    public static final int IFAA_ERR_NOT_MATCH = 2046820367;
    public static final int IFAA_ERR_NO_OPTIONAL_LEVEL = 2046820375;
    public static final int IFAA_ERR_OUT_OF_MEM = 2046820358;
    public static final int IFAA_ERR_READ = 2046820364;
    public static final int IFAA_ERR_SIGN = 2046820361;
    public static final int IFAA_ERR_SUCCESS = 0;
    public static final int IFAA_ERR_TIMEOUT = 2046820359;
    public static final int IFAA_ERR_UNKNOWN = 2046820353;
    public static final int IFAA_ERR_UNKNOWN_CMD = 2046820356;
    public static final int IFAA_ERR_UN_INITIALIZED = 2046820374;
    public static final int IFAA_ERR_VERIFY = 2046820362;
    public static final int IFAA_ERR_WRITE = 2046820365;

    public static final String toString(int o) {
        if (o == 0) {
            return "IFAA_ERR_SUCCESS";
        }
        if (o == IFAA_ERR_UNKNOWN) {
            return "IFAA_ERR_UNKNOWN";
        }
        if (o == IFAA_ERR_BAD_ACCESS) {
            return "IFAA_ERR_BAD_ACCESS";
        }
        if (o == IFAA_ERR_BAD_PARAM) {
            return "IFAA_ERR_BAD_PARAM";
        }
        if (o == IFAA_ERR_UNKNOWN_CMD) {
            return "IFAA_ERR_UNKNOWN_CMD";
        }
        if (o == IFAA_ERR_BUF_TOO_SHORT) {
            return "IFAA_ERR_BUF_TOO_SHORT";
        }
        if (o == IFAA_ERR_OUT_OF_MEM) {
            return "IFAA_ERR_OUT_OF_MEM";
        }
        if (o == IFAA_ERR_TIMEOUT) {
            return "IFAA_ERR_TIMEOUT";
        }
        if (o == IFAA_ERR_HASH) {
            return "IFAA_ERR_HASH";
        }
        if (o == IFAA_ERR_SIGN) {
            return "IFAA_ERR_SIGN";
        }
        if (o == IFAA_ERR_VERIFY) {
            return "IFAA_ERR_VERIFY";
        }
        if (o == IFAA_ERR_KEY_GEN) {
            return "IFAA_ERR_KEY_GEN";
        }
        if (o == IFAA_ERR_READ) {
            return "IFAA_ERR_READ";
        }
        if (o == IFAA_ERR_WRITE) {
            return "IFAA_ERR_WRITE";
        }
        if (o == IFAA_ERR_ERASE) {
            return "IFAA_ERR_ERASE";
        }
        if (o == IFAA_ERR_NOT_MATCH) {
            return "IFAA_ERR_NOT_MATCH";
        }
        if (o == IFAA_ERR_GEN_RESPONSE) {
            return "IFAA_ERR_GEN_RESPONSE";
        }
        if (o == IFAA_ERR_GET_DEVICEID) {
            return "IFAA_ERR_GET_DEVICEID";
        }
        if (o == IFAA_ERR_GET_LAST_IDENTIFIED_RESULT) {
            return "IFAA_ERR_GET_LAST_IDENTIFIED_RESULT";
        }
        if (o == IFAA_ERR_AUTHENTICATOR_SIGN) {
            return "IFAA_ERR_AUTHENTICATOR_SIGN";
        }
        if (o == IFAA_ERR_GET_ID_LIST) {
            return "IFAA_ERR_GET_ID_LIST";
        }
        if (o == IFAA_ERR_GET_AUTHENTICATOR_VERSION) {
            return "IFAA_ERR_GET_AUTHENTICATOR_VERSION";
        }
        if (o == IFAA_ERR_UN_INITIALIZED) {
            return "IFAA_ERR_UN_INITIALIZED";
        }
        if (o == IFAA_ERR_NO_OPTIONAL_LEVEL) {
            return "IFAA_ERR_NO_OPTIONAL_LEVEL";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString(o));
        return stringBuilder.toString();
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("IFAA_ERR_SUCCESS");
        if ((o & IFAA_ERR_UNKNOWN) == IFAA_ERR_UNKNOWN) {
            list.add("IFAA_ERR_UNKNOWN");
            flipped = 0 | IFAA_ERR_UNKNOWN;
        }
        if ((o & IFAA_ERR_BAD_ACCESS) == IFAA_ERR_BAD_ACCESS) {
            list.add("IFAA_ERR_BAD_ACCESS");
            flipped |= IFAA_ERR_BAD_ACCESS;
        }
        if ((o & IFAA_ERR_BAD_PARAM) == IFAA_ERR_BAD_PARAM) {
            list.add("IFAA_ERR_BAD_PARAM");
            flipped |= IFAA_ERR_BAD_PARAM;
        }
        if ((o & IFAA_ERR_UNKNOWN_CMD) == IFAA_ERR_UNKNOWN_CMD) {
            list.add("IFAA_ERR_UNKNOWN_CMD");
            flipped |= IFAA_ERR_UNKNOWN_CMD;
        }
        if ((o & IFAA_ERR_BUF_TOO_SHORT) == IFAA_ERR_BUF_TOO_SHORT) {
            list.add("IFAA_ERR_BUF_TOO_SHORT");
            flipped |= IFAA_ERR_BUF_TOO_SHORT;
        }
        if ((o & IFAA_ERR_OUT_OF_MEM) == IFAA_ERR_OUT_OF_MEM) {
            list.add("IFAA_ERR_OUT_OF_MEM");
            flipped |= IFAA_ERR_OUT_OF_MEM;
        }
        if ((o & IFAA_ERR_TIMEOUT) == IFAA_ERR_TIMEOUT) {
            list.add("IFAA_ERR_TIMEOUT");
            flipped |= IFAA_ERR_TIMEOUT;
        }
        if ((o & IFAA_ERR_HASH) == IFAA_ERR_HASH) {
            list.add("IFAA_ERR_HASH");
            flipped |= IFAA_ERR_HASH;
        }
        if ((o & IFAA_ERR_SIGN) == IFAA_ERR_SIGN) {
            list.add("IFAA_ERR_SIGN");
            flipped |= IFAA_ERR_SIGN;
        }
        if ((o & IFAA_ERR_VERIFY) == IFAA_ERR_VERIFY) {
            list.add("IFAA_ERR_VERIFY");
            flipped |= IFAA_ERR_VERIFY;
        }
        if ((o & IFAA_ERR_KEY_GEN) == IFAA_ERR_KEY_GEN) {
            list.add("IFAA_ERR_KEY_GEN");
            flipped |= IFAA_ERR_KEY_GEN;
        }
        if ((o & IFAA_ERR_READ) == IFAA_ERR_READ) {
            list.add("IFAA_ERR_READ");
            flipped |= IFAA_ERR_READ;
        }
        if ((o & IFAA_ERR_WRITE) == IFAA_ERR_WRITE) {
            list.add("IFAA_ERR_WRITE");
            flipped |= IFAA_ERR_WRITE;
        }
        if ((o & IFAA_ERR_ERASE) == IFAA_ERR_ERASE) {
            list.add("IFAA_ERR_ERASE");
            flipped |= IFAA_ERR_ERASE;
        }
        if ((o & IFAA_ERR_NOT_MATCH) == IFAA_ERR_NOT_MATCH) {
            list.add("IFAA_ERR_NOT_MATCH");
            flipped |= IFAA_ERR_NOT_MATCH;
        }
        if ((IFAA_ERR_GEN_RESPONSE & o) == IFAA_ERR_GEN_RESPONSE) {
            list.add("IFAA_ERR_GEN_RESPONSE");
            flipped |= IFAA_ERR_GEN_RESPONSE;
        }
        if ((IFAA_ERR_GET_DEVICEID & o) == IFAA_ERR_GET_DEVICEID) {
            list.add("IFAA_ERR_GET_DEVICEID");
            flipped |= IFAA_ERR_GET_DEVICEID;
        }
        if ((IFAA_ERR_GET_LAST_IDENTIFIED_RESULT & o) == IFAA_ERR_GET_LAST_IDENTIFIED_RESULT) {
            list.add("IFAA_ERR_GET_LAST_IDENTIFIED_RESULT");
            flipped |= IFAA_ERR_GET_LAST_IDENTIFIED_RESULT;
        }
        if ((IFAA_ERR_AUTHENTICATOR_SIGN & o) == IFAA_ERR_AUTHENTICATOR_SIGN) {
            list.add("IFAA_ERR_AUTHENTICATOR_SIGN");
            flipped |= IFAA_ERR_AUTHENTICATOR_SIGN;
        }
        if ((IFAA_ERR_GET_ID_LIST & o) == IFAA_ERR_GET_ID_LIST) {
            list.add("IFAA_ERR_GET_ID_LIST");
            flipped |= IFAA_ERR_GET_ID_LIST;
        }
        if ((IFAA_ERR_GET_AUTHENTICATOR_VERSION & o) == IFAA_ERR_GET_AUTHENTICATOR_VERSION) {
            list.add("IFAA_ERR_GET_AUTHENTICATOR_VERSION");
            flipped |= IFAA_ERR_GET_AUTHENTICATOR_VERSION;
        }
        if ((IFAA_ERR_UN_INITIALIZED & o) == IFAA_ERR_UN_INITIALIZED) {
            list.add("IFAA_ERR_UN_INITIALIZED");
            flipped |= IFAA_ERR_UN_INITIALIZED;
        }
        if ((IFAA_ERR_NO_OPTIONAL_LEVEL & o) == IFAA_ERR_NO_OPTIONAL_LEVEL) {
            list.add("IFAA_ERR_NO_OPTIONAL_LEVEL");
            flipped |= IFAA_ERR_NO_OPTIONAL_LEVEL;
        }
        if (o != flipped) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0x");
            stringBuilder.append(Integer.toHexString((~flipped) & o));
            list.add(stringBuilder.toString());
        }
        return String.join(" | ", list);
    }
}
