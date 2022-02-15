package ariketa3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Bezeroa_Zenbakia {
	
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 6000;
		//String agurmezua = "*";
		
		System.out.println("Socket TCP BEZEROA martxan... ");
		
		//Socket-a ireki
		Socket bezeroa = new Socket(host, port);
		
		// Bezeroaren irteera fluxua zerbitzariari mezuak bidaltzeko
		OutputStream os = bezeroa.getOutputStream();
		PrintWriter pwos = new PrintWriter(os, true);
		// Bezeroaren sarrera fluxua zerbitzaritik mezuak irakurtzeko
		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		// Erabiltzailearen sarrera fluxua
		InputStreamReader isrErabiltzailea = new InputStreamReader(System.in);
		BufferedReader brErabiltzailea = new BufferedReader(isrErabiltzailea);
				
		String jasotakoTestua = "";
		String bidaltzekoTestua = "";
		int zenbakia=0;
		
		while (0 != jasotakoTestua.compareToIgnoreCase("ZORIONAK"))
		{
			boolean isNumber=false;
			
			do {
				
				try {
					System.out.print("Sartu zenbaki bat: ");
					bidaltzekoTestua = brErabiltzailea.readLine(); // Erabiltzailearen testua
					zenbakia=Integer.parseInt(bidaltzekoTestua);
					pwos.println(zenbakia); // Zerbitzariari bidaltzen diogu
					isNumber=true;
				}catch(Exception e) {
					
					isNumber=false;
				}
				
			}while(!isNumber);
			
			
			jasotakoTestua = br.readLine(); // Zerbitzariaren erantzuna jaso
			System.out.println(jasotakoTestua);
			
		}
		
		// Erabiltzailearen fluxuak isten
		brErabiltzailea.close();
		isrErabiltzailea.close();
		
		//Fluxuak eta socket-ak itxi
		System.out.println("Konexioak isten...");
		br.close();
		isr.close();
		is.close();
		pwos.close();
		os.close();		
		bezeroa.close();
		System.out.println("Socket TCP BEZEROA itzalita. Agur!");
				

	}
}
