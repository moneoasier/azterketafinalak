package pruebabobalice;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class HariZerbitzaria extends Thread {
	BufferedReader sarreraFluxua;
	PrintWriter irteeraFluxua;
	Socket socket = null;
	String agurMezua = "agur";
	int hariZenbakia = -1;
	private static int dirua = 150;

	public HariZerbitzaria(int hariZenbakia, Socket s) {
		this.hariZenbakia = hariZenbakia;
		this.socket = s;

		try {
			// Sarrera eta irteerako fluxuak sortzen dira
			sarreraFluxua = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			irteeraFluxua = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String jasotakoTestua = "";
		String bidaltzekoTestua = "";
		System.out.println(
				"HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + this.socket.toString());
				
		while (0 != bidaltzekoTestua.trim().compareToIgnoreCase(agurMezua)) {
			try {
				jasotakoTestua = sarreraFluxua.readLine(); // Bezeroak bidalitakoa jaso
				
				if(dirua>0) {
					if(jasotakoTestua.equals("ken")) {
						dirua -=15;
						System.out.println(this.hariZenbakia+" hariak dirua kendu du");
					}
					if(jasotakoTestua.equals("gei")) {
						dirua +=10;
						System.out.println(this.hariZenbakia+" hariak dirua gehitu du");
					}
				}else {
					bidaltzekoTestua = agurMezua;
					irteeraFluxua.println(bidaltzekoTestua);
				}
				
				irteeraFluxua.println(jasotakoTestua+" "+dirua);// Jasotakoa maiuskulatara bihurtu eta bidali
				irteeraFluxua.flush();
				System.out.println(jasotakoTestua);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Bob eta alice banandu egin dira"
				+ this.socket.toString());
		try {
			irteeraFluxua.close();
			sarreraFluxua.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
