package com.CutieDeng;

import java.util.Scanner;

import static com.CutieDeng.Miao.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String trim = scanner.nextLine().trim();
        String decode;
        if ((decode = decode(trim)) == null) {
            System.out.println(encode(trim));
        }
        else {
            System.out.println(decode);
        }
    }
}
