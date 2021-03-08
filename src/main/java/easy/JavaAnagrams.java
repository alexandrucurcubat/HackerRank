package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaAnagrams {
//    static boolean isAnagram(String a, String b) {
//        if (a.length() != b.length()) return false;
//        a = a.toLowerCase();
//        b = b.toLowerCase();
//        int sum = 0;
//        for (char c = 'a'; c <= 'z'; c++) {
//            for (int i = 0; i < a.length(); i++) {
//                if (a.charAt(i) == c) sum++;
//                if (b.charAt(i) == c) sum--;
//            }
//            if (sum != 0) return false;
//        }
//        return true;
//    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int k = 0; k < b.length(); k++) {
            char letter = b.charAt(k);
            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                Integer frequency = map.get(letter);
                map.put(letter, ++frequency);
            }
        }
        for (int k = 0; k < a.length(); k++) {
            char letter = a.charAt(k);
            if (!map.containsKey(letter)) return false;
            Integer frequency = map.get(letter);
            if (frequency == 0) {
                return false;
            } else {
                map.put(letter, --frequency);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.println((isAnagram(a, b)) ? "Anagrams" : "Not Anagrams");
        scanner.close();

    }
}
