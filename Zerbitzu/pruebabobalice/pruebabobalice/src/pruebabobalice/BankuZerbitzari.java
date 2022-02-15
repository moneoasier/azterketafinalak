package pruebabobalice;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class BankuZerbitzari {
	public static int contua;
	
	public static void main(String[] args) {
		ServerSocket zerbitzaria;
		Socket bezeroa;
		HariZerbitzaria hariZerbitzaria;
		int hariZenbatzailea = 0;
		contua = 100;
		try {
			zerbitzaria = new ServerSocket(6000);
		
			System.out.println("Zerbitzaria martxan...");
			while(contua > 0)
			{
				bezeroa = new Socket();
				bezeroa = zerbitzaria.accept(); // bezeroaren zai
				hariZenbatzailea++;
				hariZerbitzaria = new HariZerbitzaria(hariZenbatzailea, bezeroa);
				hariZerbitzaria.start(); // haria martxan jarri eta buklean jarraitu
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
