package ariketa3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Zerbitzaria_Zenbakia {
	
	public static void main(String[] args) throws IOException {
		
		Random rand = new Random();
		int low = 1;
		int high = 100;
		int zenbakiZuzena = rand.nextInt(high-low) + low;
		
		int port = 6000;
		//String agurmezua = "*";
		ServerSocket zerbitzaria = new ServerSocket(port);
		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // 1. bezeroa
		
		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("Bezeroa konektatu da!");
		System.out.println("Zenbakia jaso arte martxan egongo naiz oraingoan.");
		
		// Bezeroaren irteera fluxua 
		OutputStream os = bezeroa.getOutputStream();
		PrintWriter pwos = new PrintWriter(os, true);
		// Bezeroaren sarrera fluxua
		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String jasotakoTestua;
		String bidaltzekoTestua;
		
		while(null != (jasotakoTestua=br.readLine())) 
		{
		
			System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
			
			if(Integer.parseInt(jasotakoTestua)==zenbakiZuzena)
			{
				pwos.println("ZORIONAK");
				break; // bukletik irtengo gara
				
			}else if (Integer.parseInt(jasotakoTestua)>zenbakiZuzena) {
				pwos.println("zenbaki TXIKIAGOA");
				
			} else if (Integer.parseInt(jasotakoTestua)<zenbakiZuzena) {
				pwos.println("zenbaki HANDIAGOA");
			} 
		}
		
		// Fluxuak eta socket-ak itxi
		System.out.println("Konexioak isten...");
		br.close();
		isr.close();
		is.close();
		pwos.close();
		os.close();		
		bezeroa.close();
		System.out.println("Socket TCP ZERBITZARIA itzalita. Agur!");
		zerbitzaria.close();
		
	}
}
