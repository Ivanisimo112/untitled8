package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(scramble("rkqodlw", "world"));
        System.out.println(scramble("cedewaraaossoqqyt", "codewars"));
        System.out.println(scramble("katas", "steak"));
    }

    private static boolean scramble(String s1, String s2) {
        boolean b = true;
        if (s2.length() > s1.length()) {
            return false;
        }
        HashMap<Character, Integer> hashMapS1 = new HashMap<>();
        HashMap<Character, Integer> hashMapS2 = new HashMap<>();
        putInHashMap(s1, hashMapS1);
        putInHashMap(s2, hashMapS2);
        for (int i = 0; i < hashMapS2.size(); i++) {
            if (hashMapS1.get(s2.charAt(i)) == null || (hashMapS2.get(s2.charAt(i)) > (hashMapS1.get(s2.charAt(i))))) {
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
