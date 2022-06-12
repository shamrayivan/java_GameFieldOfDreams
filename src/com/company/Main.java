package com.company;

import java.util.Scanner;

public class Main {
    static String word = "goodday";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Угадай слово");
        int lengthWord = word.length();
        String maskWord = "*".repeat(lengthWord);
        System.out.println(maskWord);

        do {
            System.out.println("Введите букву");
            char c = input.next().charAt(0);
            if (word.indexOf(c) >= 0) {
                System.out.println("Удача");
                for (char elem : word.toCharArray()) {
                    if (elem == c) {
                        maskWord = replaceMaskLetter(c, maskWord);
                    }
                }
                System.out.println(maskWord);
            }else {
                System.out.println("Промах, попробуй еще");
                System.out.println(maskWord);
            }

        }while (maskWord.contains("*"));
        System.out.println("Ты победил!");
    }
    public static String replaceMaskLetter (char c, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                stringBuilder.append(c);
            }else if (maskWord.charAt(i) != '*') {
                stringBuilder.append(maskWord.charAt(i));
            }else {
                stringBuilder.append("*");
            }
        }
        return stringBuilder.toString();
    }
}
