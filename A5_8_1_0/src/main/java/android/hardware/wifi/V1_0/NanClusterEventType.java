package android.hardware.wifi.V1_0;

import java.util.ArrayList;

public final class NanClusterEventType {
    public static final int DISCOVERY_MAC_ADDRESS_CHANGED = 0;
    public static final int JOINED_CLUSTER = 2;
    public static final int STARTED_CLUSTER = 1;

    public static final String toString(int o) {
        if (o == 0) {
            return "DISCOVERY_MAC_ADDRESS_CHANGED";
        }
        if (o == 1) {
            return "STARTED_CLUSTER";
        }
        if (o == 2) {
            return "JOINED_CLUSTER";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList();
        int flipped = 0;
        list.add("DISCOVERY_MAC_ADDRESS_CHANGED");
        if ((o & 1) == 1) {
            list.add("STARTED_CLUSTER");
            flipped = 1;
        }
        if ((o & 2) == 2) {
            list.add("JOINED_CLUSTER");
            flipped |= 2;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((~flipped) & o));
        }
        return String.join(" | ", list);
    }
}
