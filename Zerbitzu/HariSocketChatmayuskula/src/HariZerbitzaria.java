
import java.io.*;
import java.net.*;

public class HariZerbitzaria extends Thread {
	BufferedReader sarreraFluxua;
	PrintWriter irteeraFluxua;
	Socket socket = null;
	
	String agurMezua = "agur";
	int hariZenbakia = -1;
	
	public HariZerbitzaria(int hariZenbakia, Socket s)
	{
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
	
	public void run()
	{
		String jasotakoTestua = "";
		String bidaltzekoTestua = "";
		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + this.socket.toString());
		while(0 != jasotakoTestua.trim().compareToIgnoreCase(agurMezua))
		{
			try {
				jasotakoTestua = sarreraFluxua.readLine(); // Bezeroak bidalitakoa jaso
				bidaltzekoTestua = jasotakoTestua.trim().toUpperCase();
				irteeraFluxua.println(bidaltzekoTestua); // Jasotakoa maiuskulatara bihurtu eta bidali
				irteeraFluxua.flush();
				System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikatzen: " + bidaltzekoTestua);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		System.out.println("HariZerbitzaria (" + this.hariZenbakia + ") bezeroarekin komunikazioa bukatu da: " + this.socket.toString());
		try {
			irteeraFluxua.close();
			sarreraFluxua.close();
			this.socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
