
import java.io.*;
import java.net.*;

public class SocketTCP_Bezeroa_Maiuskulak {

	public static void main(String[] args) throws Exception {
		String host = "192.168.65.11";
		int port = 6000;
		String agurMezua = "agur";

		System.out.println("Socket TCP BEZEROA martxan... ");

		// Socket-a ireki
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

		while (0 != bidaltzekoTestua.trim().compareToIgnoreCase(agurMezua)) {
			System.out.print("Idatzi testu bat zerbitzariari: ");
			bidaltzekoTestua = brErabiltzailea.readLine(); // Erabiltzailearen testua
			pwos.println(bidaltzekoTestua); // Zerbitzariari bidaltzen diogu
			jasotakoTestua = br.readLine(); // Zerbitzariaren erantzuna jaso
			System.out.println("  Zerbitzariaren erantzuna => " + jasotakoTestua);
		}

		// Fluxuak eta socket-ak itxi
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
