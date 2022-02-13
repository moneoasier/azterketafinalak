
import java.io.IOException;
import java.net.*;

public class ZerbitzariaMain {

	public static void main(String[] args) {
		ServerSocket zerbitzaria;
		Socket bezeroa;
		HariZerbitzaria hariZerbitzaria;
		int hariZenbatzailea = 0;
		try {
			zerbitzaria = new ServerSocket(6000);
		
			System.out.println("Zerbitzaria martxan...");
			while(true)
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
