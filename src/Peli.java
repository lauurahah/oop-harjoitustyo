import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class Peli {
//implements TallentajaLataaja{

		private Pelaaja eka;  
		private Pelaaja toka;
		private Lauta l;
		private Pelaaja vuorossa;
		private Lauta lautanen;
		private String lautajono;
		private String vuoro;
		
		
		public Peli(Pelaaja eka, Pelaaja toka) {   //Konstruktori
			
			this.l = new Lauta();
			this.eka = eka;
			this.toka = toka;
			
			
			System.out.println("\r\nJes, eikun pelaamaan!\n"
								+ "xoxoxoxoxoxoxoxoxo");	
			vuoro="2";
			
		}
		
		public static Peli luoPeli() {    //luo ja palauttaa Pelin syˆtteen tietojen pohjalta
			
			System.out.println("\r\nSyˆt‰ pelaajan 1 nimi:");
			String ohje = Main.yleislukija().nextLine();
			Pelaaja eka = new IhmisPelaaja(ohje, 'X'); 
			//TODO:
			// tarviiko t‰h‰n jonkun poikkeusk‰sittelyn jos yritet‰‰n esim. 
			// syˆtt‰‰ tyhj‰‰ nimeksi?
			
			System.out.println("\r\nPelaatko konetta vastaan? \r\n"
					+ "joo = 1\r\n"
					+ "en = 2\r\n"
					+ "Valintasi:");
			
			ohje = Main.yleislukija().nextLine();
			Pelaaja toka = null;
			
			while ( toka == null) {
				if (ohje.equals("1")) {		// ohje 1 = koneen kanssa peli
					
					toka = new KonePelaaja("Kone", 'O');
					System.out.println("\r\nKonepelaaja luotu.");
				
				}else if (ohje.equals("2")){						//  ohje 2 = luodaan toinen ihmispelaaja
					
					System.out.println("\r\nSyˆt‰ pelaajan 2 nimi:");
					ohje = Main.yleislukija().nextLine();
					toka = new IhmisPelaaja(ohje, 'O');
			
				
				
				}else{
				
					System.out.println("Valitse 1 tai 2!");
					ohje = Main.yleislukija().nextLine();
				}
			}	
				
			return new Peli(eka,toka);
		}
		
		
		
		public void pelaaPeli() {
			 while (this.l.onkoVoittanut(eka) == false && this.l.onkoVoittanut(toka) == false && this.l.onkoLautaTaynna() == false) {
				 if(vuoro=="2") {
					 System.out.println("\r\n>>> Vuorossa on "+eka.annaNimi()+", merkkisi on "+eka.annaMerkki());
					 eka.pelaaVuoro(this);
					 vuoro="1";
					 this.vuorossa = eka;
					 
				 }
				if (l.onkoVoittanut(eka) == false && l.onkoLautaTaynna() == false && vuoro=="1") {
					
					System.out.print("\r\n>>> Vuorossa on "+toka.annaNimi());
							
							if (toka instanceof IhmisPelaaja) {
								System.out.println(", merkkisi on "+toka.annaMerkki());
							}else {
								System.out.println(", pelaa merkill‰ O.");
							}
					
					toka.pelaaVuoro(this);
					vuoro="2";
					this.vuorossa = toka;
					

					
					
				}	

				if (l.onkoVoittanut(eka) == true || l.onkoVoittanut(toka) == true) {
					 System.out.println("xoxoxoxoxoxoxoxoxo\r\n"
							 			+ "Onnea "
							 			+vuorossa.annaNimi()
							 			+", voitit pelin!"
							 			);
					 					l.tulostaPelilauta();
					 System.out.println("xoxoxoxoxoxoxoxoxo");
					 
					 break;
				}
				
				if (l.onkoLautaTaynna() == true) {
					 System.out.println("\r\n Pelilauta on t‰yttynyt, ei voittajaa!");
					 l.tulostaPelilauta();
					break;
				}
			 }
			 
		
		}
		
		
		
		/* Rajapinnan metodien toteutus*/
		// importattiin bufferit ja fileet
		public void tallennaPeli() {
			try {
			File f= new File("Tallennus.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter tallennus = new BufferedWriter(fw);
			tallennus.write(eka.annaNimi());
			tallennus.newLine();
			tallennus.write(eka.annaMerkki());
			tallennus.newLine();
			tallennus.write(toka.annaNimi());
			tallennus.newLine();
			tallennus.write(toka.annaMerkki());
			tallennus.newLine();
			tallennus.write(l.muutaLautaJonoksi());
			tallennus.newLine();
			tallennus.write(vuoro);
//			tallennus.write(uusiPeli.annaKukaVuorossa().annaNimi());
			tallennus.newLine();
			
//			tallennus.flush();
			tallennus.close();
			System.out.println("Tallennellaan...");
			}
			catch(Exception e){
				System.out.println("Tallennus ei onnistunut!");
			}
		}
//			System.out.println("\r\nMill‰ nimell‰ peli tallennetaan?\r\n");
//			String ohje = Main.yleislukija().nextLine();
			
//			try {
            
//t‰h‰n try-catchi/exceptioni?
//			BufferedWriter tallennus = new BufferedWriter(new FileWriter("Tallennus.txt"));
//			tallennus.write("ghg"); //vai annaPelaaja1
//			tallennus.write(toka.annaNimi()); //miten lˆyt‰‰ ekan ja tokan? ent‰ jos onkin

        //konepelaaja?
			//tallennus.write(annaLauta()); //miten char kirjoitetaan
			//tallennus.write(""+Peli.annaKukaVuorossa());

//			tallennus.close();
//			System.out.print("Pelin tallennus onnistui!");
//			}
//			catch(Exception e){
	//		}
//			}

			
			
			//TODO:
			//Lis‰‰ m‰‰riteltyyn tiedostoon (CSV) uuden avain-arvo-parin
			//avain = nimi, arvo = peli-olio muutettava tallennettavaan muotoon
			// t‰‰ tuottaa mulle tuskaa...



		
		public void lataaPeli() {
			try {
			File f = new File("Tallennus.txt");
			FileReader fr = new FileReader(f);
			BufferedReader lataus= new BufferedReader(fr); 
			String ekannimi = lataus.readLine();
			char ekanmerkki = (char)lataus.read();
			eka = new IhmisPelaaja(ekannimi, ekanmerkki);
			String tyhj‰ = lataus.readLine();
			String tokannimi = lataus.readLine();
			char tokanmerkki = (char)lataus.read();
			toka = new IhmisPelaaja (tokannimi, tokanmerkki); //ent‰ jos toka on kone
			String tyhj‰1 = lataus.readLine();
			String lautajono = lataus.readLine();
			Peli pelinen = new Peli(eka, toka);
			l.laitaMerkitLaudalle(lautajono);
			vuoro = lataus.readLine();
			
	//		lautajono.laitaMerkitLaudalle();
 //    		lautanen.tulostaPelilauta();
//			lauta= //mill‰s t‰m‰ luetaan
//			vuorossa=lataus.readLine();
			
			
			if(vuoro=="2") {
				vuorossa = toka;
			}
			if(vuoro=="1") {
				vuorossa = eka;
			}
			
			System.out.println("Lataus onnistui! Ekan pelaaja nimi on "+ ekannimi +"\r\nTokan "
					+ "pelaajan nimi on "+tokannimi +". Viimeisen merkin on laittanut" +vuoro
							+ "Seuraavana vuorossa on " + vuorossa.annaNimi()
					+ ". Merkkisi on "+vuorossa.annaMerkki());
					//+ lauta);
			l.tulostaPelilauta();
			lataus.close();
//			eka.pelaavuoro(pelinen);
//			toka.pelaaVuoro(this);
//     		pelinen.pelaaPeli();
			}
			catch(Exception e) {
				
			}
			
			//TODO:
			//Hakee tiedostosta pelin avaimella(nimi) ja k‰ynnist‰‰ pelin uudelleen, 
			//miten? Ehk‰‰ pelaaPeli()-metodilla.
			//Mietitt‰v‰ miten vuoro tarkistetaan, eli mik‰ on pelin tila.
		}
		
		
		public Lauta annaLauta() {
			
			return this.l;
		}
	
		public Pelaaja annaPelaaja1() {
		 return eka;
		}
	
		public Pelaaja annaPelaaja2() {
			 return toka;
		}
		
		public Pelaaja annaKukaVuorossa() {
			
			return vuorossa;
		}
}
