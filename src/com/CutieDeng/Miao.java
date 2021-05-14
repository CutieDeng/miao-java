package com.CutieDeng;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Miao {
    private final static char[] miaos = {'\u200b', '\u200c', '\u200d'};

    private static char get(int i) {
        return miaos[i];
    }

    private static int check(char s) {
        for (int i = 0; i < miaos.length; i++) {
            if (s == miaos[i]) {
                return i;
            }
        }
        return -1;
    }

    public static String decode(String sequence) {
        String regex = "喵,，。？！~、—《》”“\"'";
        if (!sequence.matches(String.format("[%s%c%c%c]{1,}",regex, miaos[0], miaos[1], miaos[2]))) {
            return null;
        }
        char[] letters = sequence.toCharArray();
        regex = "[" + regex + "]";
        List<Character> codeList = new ArrayList<>();
        for (char letter : letters) {
            if (Character.toString(letter).matches(regex)) {
                continue;
            }
            codeList.add(letter);
        }
        int value = 0;
        StringBuilder decodeString = new StringBuilder();
        for (Character character : codeList) {
            switch (check(character)) {
                case 0:
                    value = ( value << 1 ) | 1;
                    break;
                case 1:
                    value <<= 1;
                    break;
                case 2:
                    decodeString.append((char) value);
                    value = 0;
                    break;
            }
        }
        return decodeString.toString();
    }

    public static String encode(String sequence) {
        char[] letters = sequence.toCharArray();
        StringBuilder encodeString = new StringBuilder("喵");
        for (char letter : letters) {
            String s = Integer.toString(letter, 2);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    encodeString.append(get(1));
                }
                else {
                    encodeString.append(get(0));
                }
            }
            encodeString.append(get(2));
        }
        encodeString.append("喵");
        return encodeString.toString();
    }

}
