import java.util.Random;

public class KonePelaaja extends Pelaaja {

	public KonePelaaja(String nimi, char merkki) {
		super(nimi, merkki);
		
	}

	@Override
	public String muutaPelaajaJonoksi() {
		return annaNimi()+","+annaMerkki()+","+PelaajanTyyppi.KONE;
	}
	public void pelaaVuoro(Peli p) {
		
		Lauta l = p.annaLauta();
		Random rnd = new Random(); 
		int paikka; /*olisi v‰lilt‰ 0-8, mutta + 1 siirt‰‰ v‰lille 1-9*/
		boolean asetus = false;
		
		while (asetus == false) {   //eli kunnes asetus onnistuu
			try { 
					paikka = rnd.nextInt(9)+1;
					asetus = l.asetaMerkki(super.annaMerkki(), paikka);   //metodi asetaMerkki() palauttaa truen jos asetus onnistui, 
												 // eli poistutaan silmukasta.
					
			}catch (Exception e ){ //T‰m‰ nappaa kaikki exceptionit ja k‰sittelee samalla tavalla.
				
				
				//System.out.print("*Kone yritti v‰‰r‰‰ tai varattua*\r\n");
				asetus = false;
			  //ei printata mit‰‰n koska tietokone ei tarvii ohjeita.
				
			}
		}
		
		System.out.print("****Kone on pelannut****\r\n");
	}	

}
