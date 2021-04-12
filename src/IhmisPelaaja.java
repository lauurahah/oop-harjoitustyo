public class IhmisPelaaja extends Pelaaja {
	
	public IhmisPelaaja(String nimi, char merkki) {
		super(nimi, merkki);
		
	}
	
	@Override
	public void pelaaVuoro(Peli p) {
		
		Lauta l = p.annaLauta();
		System.out.println("Valitse ruutu v�lilt� 1-9\r\n");
		l.tulostaPelilauta();
		String paikka = Main.yleislukija().nextLine();
		boolean asetus = false;
		
		while (asetus == false) {
			try {
				
				//T�M� SEURAAVA UUTTA
				if(paikka.equals("t") || paikka.equals("T")) {								
					//TODO: miten kertoa koodilla ett� millon tahansa input 't' niin aletaan tallentamaan...
				
					System.out.println("Tallennetaan..."); 	
					p.tallennaPeli();
								
				
				}
				if(paikka.equals("j") || paikka.equals("J")) {								
					//TODO: miten kertoa koodilla ett� millon tahansa input 't' niin aletaan tallentamaan...
				
					System.out.println("Ladataan aiempi peli..."); 	
					p.lataaPeli();
		//		    pelinen.pelaaPeli();
								
				
				}
				
				//T�H�N ASTI
			asetus = l.asetaMerkki(super.annaMerkki(), Integer.parseInt(paikka)); //metodi palauttaa true tai false
			
			

			
			
			}catch (IllegalArgumentException e){
				
				System.out.println("Paikan tulee olla v�lilt� 1-9!");
				paikka = Main.yleislukija().nextLine();
				continue;
				
			}catch (Exception e){
				
				System.out.println("Sinun tulee asettaa merkki vapaalle ruudulle!");
				paikka = Main.yleislukija().nextLine();
				continue;
			}	
		}	
		
	}																							

}
