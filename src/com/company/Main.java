package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
        System.out.println(scramble("cedewaraaosoqqyt", "codewars"));
        System.out.println(scramble("katas", "steak"));
    }

    private static boolean scramble(String s1, String s2) {
        boolean b = true;
        if (s2.length() > s1.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMapS1 = new HashMap<>();
        putInHashMap(s1, hashMapS1);
        for (int i = 0; i < s2.length(); i++) {
            if (hashMapS1.get(s2.charAt(i)) != null) {
                hashMapS1.put(s2.charAt(i), hashMapS1.get(s2.charAt(i)) - 1);
            } else {
                b = false;
                break;
            }
            if (hashMapS1.get(s2.charAt(i)) == -1) {
                b = false;
                break;
            }
        }
        return b;
    }

    private static void putInHashMap(String s, HashMap<Character, Integer> hashMap) {
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == null) {
                hashMap.put(s.charAt(i), 1);
            } else {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            }
        }
    }
}
