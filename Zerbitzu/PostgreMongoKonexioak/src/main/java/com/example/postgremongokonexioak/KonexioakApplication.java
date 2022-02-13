package com.example.postgremongokonexioak;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class KonexioakApplication {

	public static void main(String[] args) {

		/* Sockets */

		int port = 9000;
		ServerSocket zerbitzaria;
		ZerbitzariHaria haria;
		int hariZenbatzailea = 0;

		try {
			zerbitzaria = new ServerSocket(port);
			System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.\n");

			while(true) {
				// bezeroarekin komunikatu eta ekintzak burutu
				Socket bezeroa = zerbitzaria.accept(); // Bezeroa
				System.out.println("Bezeroa konektatu da!");
				
				hariZenbatzailea++;
				
				haria = new ZerbitzariHaria(hariZenbatzailea, bezeroa);
				haria.start(); // haria martxan jarri eta buklean jarraitu
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
