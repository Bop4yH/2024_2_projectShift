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

        StringBuilder line;
        final StringBuilder sep = new StringBuilder("-".repeat(length))
                .append(("+" + "-".repeat(squareLength)).repeat(x));

        for (int i = 0; i <= x; i++) {
            line = new StringBuilder(" ".repeat(length - String.valueOf(i).length()) + (i == 0 ? " " : i));

            for (int j = 1; j <= x; j++) {
                line.append("|")
                        .append(" ".repeat(squareLength - String.valueOf((i == 0 ? 1 : i) * j).length()))
                        .append((i == 0 ? 1 : i) * j);
            }
            System.out.println(line);
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