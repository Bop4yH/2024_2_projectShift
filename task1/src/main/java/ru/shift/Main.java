package ru.shift;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = parseArg();
        if (x != 0) {
            printTable(x);
        } else {
            System.out.println("Only integer numbers between 1 and 32");
        }
    }

    public static void printTable(int x) {
        final int squareLength = String.valueOf(x * x).length();
        final int length = String.valueOf(x).length();
        final String sep = "-".repeat(length) + ("+" + "-".repeat(squareLength)).repeat(x);

        for (int i = 0; i <= x; i++) {
            System.out.printf("%" + length + "s", i == 0 ? "" : i);
            for (int j = 1; j <= x; j++) {
                System.out.printf("|" + "%" + squareLength + "d", (i == 0 ? 1 : i) * j);
            }
            System.out.println();
            System.out.println(sep);
        }
    }

    public static int parseArg() {
        Scanner in = new Scanner(System.in);
        int x;
        try {
            x = in.nextInt();
        } catch (Exception e) {
            x = 0;
        }
        if (x < 1 || 32 < x) {
            x = 0;
        }
        return x;
    }
}