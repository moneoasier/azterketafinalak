package com.example.postgremongokonexioak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import com.example.postgremongokonexioak.model.Puntuazioa;
import com.example.postgremongokonexioak.model.User;


public class ZerbitzariHaria extends Thread {
	BufferedReader sarreraFluxua;
	PrintWriter irteeraFluxua;
	Socket socket = null;

	int hariZenbakia = -1;

	public ZerbitzariHaria(int hariZenbakia, Socket s) {
		this.hariZenbakia = hariZenbakia;
		this.socket = s;

		try {
			// Sarrera eta irteerako fluxuak sortzen dira
			sarreraFluxua = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			irteeraFluxua = new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String jasotakoTestua = "";
		String bidaliBeharrekoTestua = "";

		ArrayList<Puntuazioa> puntuazioak = new ArrayList<>();

		// Buklea
		while (null != (jasotakoTestua)) {
			try {
				jasotakoTestua = sarreraFluxua.readLine();

				// Android-etik eskatzen da erabiltzaileak bidaltzeko
				if (jasotakoTestua != null && jasotakoTestua.equals("Erabiltzaileak bidali")) {
					
					System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
					bidaliBeharrekoTestua = androideraBidaliErabiltzaileak();
					irteeraFluxua.println(bidaliBeharrekoTestua);
				}

				// Puntuazioak jasotzen ditu
				if (jasotakoTestua != null && !jasotakoTestua.equals("bukatu")
						&& !jasotakoTestua.equals("Erabiltzaileak bidali")&& !jasotakoTestua.equals("Hor zaude?")) {
					
					System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
					String[] erregistroak = jasotakoTestua.split(";");

					for (int i = 0; i < erregistroak.length; i++) {
						String[] parts = erregistroak[i].split(",");
						puntuazioak
								.add(new Puntuazioa(Integer.parseInt(parts[0]),parts[1],Integer.parseInt(parts[2]), parts[3]));
					}
 
					postgresraBidaliPuntuazioak(puntuazioak);
					mongoraBidaliPuntuazioak(puntuazioak);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @return Android-era bidaliko den informazioa
	 */
	public String androideraBidaliErabiltzaileak() {
		KonexioaPostgre konexioaPostgre = new KonexioaPostgre();
		ArrayList<User> users = konexioaPostgre.selectUser();

		String userString = "";
		System.out.println("Android-era erabiltzaileak bidaltzen\n");
		for (User user : users) {
			userString = userString + user.getId() + "," + user.getName() + "," + user.getEmail() + ","
					+ user.getPassword() + ";";	
		}
		System.out.println(userString+"\n");
		return userString;
	}

	/**
	 * Postgresra puntuazioak bidaltzen ditu
	 * 
	 * @param p
	 */
	public void postgresraBidaliPuntuazioak(ArrayList<Puntuazioa> p) {
		KonexioaPostgre konexioaPostgre = new KonexioaPostgre();
		
		if(konexioaPostgre.insertPuntuazioa(p)==0) {
			System.out.println("Ez da ondo igo informazioa PostgreSQL");
		}else {
			System.out.println("Ondo igo informazioa PostgreSQL");
		}
	}

	/**
	 * Mongora puntuazioak bidaltzen ditu
	 * 
	 * @param puntuazioak
	 */
	public void mongoraBidaliPuntuazioak(ArrayList<Puntuazioa> puntuazioak) {
		KonexioaMongo konexioaMongo = new KonexioaMongo();
		if(konexioaMongo.insertPuntuazioa(puntuazioak)==0) {
			System.out.println("Ez da ondo igo informazioa Mongora");
		}else {
			System.out.println("Ondo igo informazioa Mongora");
		}
	}
}
