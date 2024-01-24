package com.ronisumantri.jalinbisa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Scanner;

@ExtendWith(SpringExtension.class)
class JalinbisaApplicationTests {

	@Test
	void contextLoads() {

//		Scanner scanner = new Scanner(System.in);
		System.out.println("Masukkan sebuah bilangan integer: ");
//		int n = scanner.nextInt();
		int n = 5;

		for (int i = 1; i <= n; i++) {
			// Menambahkan spasi pada setiap baris
			for (int k = n - i; k > 0; k--) {
				System.out.print(" ");
			}

			// Menambahkan karakter '#' pada setiap baris
			for (int j = 1; j <= i; j++) {
				System.out.print("#");
			}

			System.out.println();
		}

//		scanner.close();
	}

}
