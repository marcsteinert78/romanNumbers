package com.mcst;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
    private Map<Character, Integer> translateMap = new HashMap<>();

    public RomanNumbers() {
        this.initMap();
    }

    public int translate(String romanNumber) {
        int result = 0;
        while (romanNumber.length() > 1) {
            String pair = romanNumber.substring(0, 2);
            if (translateMap.get(pair.charAt(0)) < translateMap.get(pair.charAt(1))) {
                result += (translateMap.get(pair.charAt(1)) - translateMap.get(pair.charAt(0)));
            } else {
                result += translateMap.get(pair.charAt(0)) + translateMap.get(pair.charAt(1));
            }
            romanNumber = romanNumber.replace(pair, "");
        }
        if (romanNumber.length() == 1) {
            result += translateMap.get(romanNumber.charAt(0));
        }
        return result;
    }

    //TODO: use Map.of....
    private void initMap() {
        this.translateMap.put('I', 1);
        this.translateMap.put('V', 2);
        this.translateMap.put('X', 10);
        this.translateMap.put('L', 50);
        this.translateMap.put('C', 100);
        this.translateMap.put('D', 500);
        this.translateMap.put('M', 1000);
    }
}
