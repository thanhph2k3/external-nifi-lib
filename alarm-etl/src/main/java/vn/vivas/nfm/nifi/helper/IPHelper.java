package vn.vivas.nfm.nifi.helper;

import java.util.List;

public class IPHelper {

    public static boolean matches(String ip, List<String> list) {

        long targetIp = ipToLong(ip);

        for (String item : list) {

            item = item.trim();

            if (item.isEmpty()) {
                continue;
            }

            // CIDR subnet
            if (item.contains("/")) {

                if (isInSubnet(targetIp, item)) {
                    return true;
                }

            }

            // Single IP
            else {

                if (targetIp == ipToLong(item)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isInSubnet(long targetIp, String cidr) {

        String[] parts = cidr.split("/");

        long networkIp = ipToLong(parts[0]);
        int prefix = Integer.parseInt(parts[1]);

        long mask = prefix == 0
                ? 0
                : (0xFFFFFFFFL << (32 - prefix)) & 0xFFFFFFFFL;

        long network = networkIp & mask;
        long broadcast = network | (~mask & 0xFFFFFFFFL);

        return targetIp >= network && targetIp <= broadcast;
    }

    private static long ipToLong(String ip) {

        String[] parts = ip.split("\\.");

        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid IP: " + ip);
        }

        long result = 0;

        for (String part : parts) {

            int value = Integer.parseInt(part);

            if (value < 0 || value > 255) {
                throw new IllegalArgumentException("Invalid IP: " + ip);
            }

            result = (result << 8) | value;
        }

        return result;
    }
}