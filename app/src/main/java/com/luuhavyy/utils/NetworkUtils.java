package com.luuhavyy.utils;

public class NetworkUtils {
    public static String getCarrier(String phone) {
        String prefix = getPrefix(phone);
        if (prefix == null) return "Unknown";

        if (isViettel(prefix)) return "Viettel";
        if (isMobi(prefix)) return "Mobifone";
        if (isVina(prefix)) return "Vinaphone";
        if (isVietnamobile(prefix)) return "Vietnamobile";

        return "Unknown";
    }

    private static String getPrefix(String phone) {
        phone = phone.replaceAll("[^0-9]", "");
        if (phone.length() >= 10) {
            return phone.substring(phone.length() - 10, phone.length() - 7);
        }
        return null;
    }

    public static boolean isViettel(String prefix) {
        return prefix.equals("086") || prefix.equals("096") || prefix.equals("097") || prefix.equals("098") ||
                prefix.equals("032") || prefix.equals("033") || prefix.equals("034") ||
                prefix.equals("035") || prefix.equals("036") || prefix.equals("037") ||
                prefix.equals("038") || prefix.equals("039");
    }

    public static boolean isMobi(String prefix) {
        return prefix.equals("070") || prefix.equals("076") || prefix.equals("077") ||
                prefix.equals("078") || prefix.equals("079") || prefix.equals("089") ||
                prefix.equals("090") || prefix.equals("093");
    }

    public static boolean isVina(String prefix) {
        return prefix.equals("081") || prefix.equals("082") || prefix.equals("083") ||
                prefix.equals("084") || prefix.equals("085") || prefix.equals("088") ||
                prefix.equals("091") || prefix.equals("094");
    }

    public static boolean isVietnamobile(String prefix) {
        return prefix.equals("052") || prefix.equals("056") || prefix.equals("058") ||
                prefix.equals("092");
    }
}
