
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class HariZerbitzaria extends Thread {
	BufferedReader sarreraFluxua;
	PrintWriter irteeraFluxua;
	Socket socket = null;

	ArrayList<String> haria1 = new ArrayList<>();

	String agurMezua = "agur";
	int hariZenbakia = -1;

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
		while (0 != jasotakoTestua.trim().compareToIgnoreCase(agurMezua)) {
			try {
				jasotakoTestua = sarreraFluxua.readLine(); // Bezeroak bidalitakoa jaso

				if (hariZenbakia == 1) {
					haria1.add(jasotakoTestua);

					irteeraFluxua.println(haria1.toString());// Jasotakoa maiuskulatara bihurtu eta bidali
					irteeraFluxua.flush();
					System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: "
							+ bidaltzekoTestua);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikazioa bukatu da: "
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
