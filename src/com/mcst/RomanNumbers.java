package com.mcst;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    private static Map<Character, Integer> translateMap = new HashMap<>();

    public static int translate(String romanNumber) {
        initMap();
        int result = 0;
        while (romanNumber.length() > 1) {
            String pair = romanNumber.substring(0, 2);
            result += (translateMap.get(pair.charAt(1)) +
                    (translateMap.get(pair.charAt(0)) * pairSmallNumberFirst(pair)));
            romanNumber = romanNumber.replaceFirst(pair, "");
        }
        if (romanNumber.length() == 1) {
            result += translateMap.get(romanNumber.charAt(0));
        }
        return result;
    }

    private static int pairSmallNumberFirst(String pair) {
        if (translateMap.get(pair.charAt(0)) < translateMap.get(pair.charAt(1))) {
            if (translateMap.get(pair.charAt(1)) / translateMap.get(pair.charAt(0)) == 10 ||
                    translateMap.get(pair.charAt(1)) / translateMap.get(pair.charAt(0)) == 5) {
                return -1;
            } else {
                throw new IllegalArgumentException("Wrong number number sequence " + pair);
            }
        }
        return 1;
        //return translateMap.get(pair.charAt(0)) < translateMap.get(pair.charAt(1)) ? -1 : 1;
    }

    //TODO: use ImmutableMap.of....
    private static void initMap() {
        translateMap.put('I', 1);
        translateMap.put('V', 2);
        translateMap.put('X', 10);
        translateMap.put('L', 50);
        translateMap.put('C', 100);
        translateMap.put('D', 500);
        translateMap.put('M', 1000);
    }
}
