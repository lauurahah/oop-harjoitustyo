import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println("xoxoxoxoxoxoxoxoxo\r\n"
				+"Peli on Ristinolla!\r\n"
				+ "Valikko:\r\n"
				+ "p Pelaa uusi peli\r\n"
				+ "t Tallenna peli\r\n"
				+ "j Jatka tallennettua peli‰\r\n");
		
		String ohje = yleislukija().nextLine();
		Peli uusiPeli = null;
		int onkoJarkea = 0;
		
		while (onkoJarkea == 0) {
			
			if ( ohje.equals("p") || ohje.equals("P")) {

				uusiPeli = Peli.luoPeli();
				uusiPeli.pelaaPeli();
				onkoJarkea = 1;
				
			}else if(ohje.equals("t") || ohje.equals("T")) {								
			//TODO: miten kertoa koodilla ett‰ millon tahansa input 't' niin aletaan tallentamaan...
				
				if (uusiPeli == null) {
					
					System.out.println("Et ole viel‰ pelannut peli‰, ei voida tallentaa.");		//eli ei ole viel‰ peli‰ mit‰ tallentaa
					ohje = yleislukija().nextLine();
					continue; 
					
				}else {
					
					uusiPeli.tallennaPeli(); 	
					
					//eli peli on jo luotu
					onkoJarkea = 1;	
				}
				
				
			}else if (ohje.equals("j") || ohje.equals("J")) {
			
			System.out.println("Anna tallennetun pelin nimi jota haluat jatkaa?");
			
			onkoJarkea = 1;
			//TODO: 
			//Peli haettuPeli = Peli.lataaPeli(yleislukija().nextLine());
			//miten haettua peli‰ aletaan pelaamaan keskeytyneest‰ kohdasta?
			// toimisko ihan vaan pelaaPeli() ?
			
			}else {
				
				System.out.println("Valitse joku seuraavista:\r\n"
									+ "p Pelaa uusi peli\r\n"
									+ "t Tallenna peli\r\n"
									+ "j Jatka tallennettua peli‰\r\n");
				ohje = yleislukija().nextLine();
				onkoJarkea = 0;
			}
		
		}
		
		yleislukija().close();

	}
	
	public static Scanner yleislukija() {		//T‰m‰ saattaa olla v‰‰r‰ss‰ paikassa, ehk‰ pit‰isi luoda oma luokka t‰lle.
												//Selvitell‰‰n ennen palautusta!

		final Scanner lukija = new Scanner(System.in);
		return lukija;
	}
	
	

}
