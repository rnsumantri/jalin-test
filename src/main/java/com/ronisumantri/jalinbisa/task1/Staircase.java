package com.ronisumantri.jalinbisa.task1;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fill with Integer: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int k = n - i; k > 0; k--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("#");
            }

            System.out.println();
        }

        scanner.close();
    }
}
