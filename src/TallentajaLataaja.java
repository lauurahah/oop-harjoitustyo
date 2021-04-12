import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;


public interface TallentajaLataaja {
	//toteutetaan peli-luokassa
	
	public void tallennaPeli() {  //Tarvisiko tämä parametriksi sen Peli-olion?
		                                      //Poistin String nimi parametrista
	//tähän try-catchi/exceptioni?
		FileWriter fw = new FileWriter("Tallennus.txt");
		BufferedWriter tallennus = new BufferedWriter(fw);
		tallennus.write(annaPelaaja1()); //vai annaPelaaja1
		tallennus.write(""+Peli.annaPelaaja2()); //miten löytää ekan ja tokan? entä jos onkin
		                                  //konepelaaja?
		tallennus.write(Peli.annaLauta()); //miten char kirjoitetaan
		tallennus.write(""+Peli.annaKukaVuorossa());
		
		tallennus.close();
	}
	
//	public Peli lataaPeli(String nimi);
// jos nimetään konepelaaja konepelaajaksi ja jos pelaaja2 nimi on konepelaaja, niin
// sitten jos pelaaja2 nimi=
	
	public void lataaPeli() { //tehdäänkö tähän try-catchi/exceptioni?
		FileReader fr = new FileReader("Tallennus.txt");
		BufferedReader lataus= new BufferedReader(fr); 
		
		eka=lataus.readLine();
		toka=lataus.readLine();
		lauta= //milläs tämä luetaan
		vuorossa=lataus.readLine();
		
		lataus.close();
				
		
		
	}
}

//tarvitseeko kumpikin parametriksi laudan?