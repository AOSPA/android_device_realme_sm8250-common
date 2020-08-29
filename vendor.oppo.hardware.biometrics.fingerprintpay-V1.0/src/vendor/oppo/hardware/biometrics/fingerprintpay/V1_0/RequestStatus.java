package vendor.oppo.hardware.biometrics.fingerprintpay.V1_0;

import java.util.ArrayList;

public final class RequestStatus {
    public static final int REQUESTSTATUS_OK = 0;
    public static final int REQUESTSTATUS_UNKNOWN = 1;

    public static final String toString(int o) {
        if (o == 1) {
            return "REQUESTSTATUS_UNKNOWN";
        }
        if (o == 0) {
            return "REQUESTSTATUS_OK";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0x");
        stringBuilder.append(Integer.toHexString(o));
        return stringBuilder.toString();
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        if ((o & 1) == 1) {
            list.add("REQUESTSTATUS_UNKNOWN");
            flipped = 0 | 1;
        }
        list.add("REQUESTSTATUS_OK");
        if (o != flipped) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0x");
            stringBuilder.append(Integer.toHexString((~flipped) & o));
            list.add(stringBuilder.toString());
        }
        return String.join(" | ", list);
    }
}
