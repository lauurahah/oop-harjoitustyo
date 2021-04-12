
public class Lauta {
	
	private char[][] lauta = {    
		  							{ '1', '2', '3' },
		  							{ '4', '5', '6' },
		  							{ '7', '8', '9' }
							};
	
	//private Pelaaja vuorossa; 	//t�h�n voisi tallentaa sen, kenen vuoro on
							   // Roosan kommentti: lauta ei taida saada mist��n tietoa pelaajista, eli t�m� t�ytyy varmaankin olla toisessa luokassa, peli-luokassa?.
	
	//public Lauta() {      *ei taida tarvita t�t� lainkaan?
			
	//	}



	
public void tulostaPelilauta() {	
		
		System.out.println("T�ss� on lauta:");
		for (int i = 0; i < this.lauta.length; i++) {
			for (int j = 0; j < this.lauta[i].length; j++) {
				System.out.print(this.lauta[i][j] + " ");
			} 
			System.out.println();
		}
		
	}

public String muutaLautaJonoksi() {
	String listaus = "";
		for(int i=0;i<this.lauta.length;i++) {
			for(int j=0;j<this.lauta[i].length;j++) {
			listaus=listaus+Character.toString(this.lauta[i][j]);
			}
		}
	return listaus;
}

public void laitaMerkitLaudalle(String lautajono) {

	int rivi=0;
	int sarake=0;
	for(int i=0; i<lautajono.length();i++) {
		this.lauta[rivi][sarake]=lautajono.charAt(i);
		sarake++;
		if(sarake==3) {
			rivi++;
			sarake=0;
		}
	}
	
}


// pit�isik� t�m�n metodin olla public Lauta, jotta palauttaa laudan? <- RK: en ihan tied� mit� meinaat, mutta static t�m� ei voi mielest�ni olla
public boolean asetaMerkki(char merkki, int paikka) throws IllegalArgumentException, Exception {
	boolean onnistui = false;
	if(paikka<1 || paikka>9) {
		throw new IllegalArgumentException("Paikan tulee olla v�lilt� 1-9!");     // RK: T�ss� t�m� mielest�ni toimii, mutta tuonne for-loopin sis��n t�ytyy laittaa joku muu, 
																				// koska kun ne otetaan kiinni, niille t�ytyy antaa yleisp�tev� virheviesti.
																			  //  eli jos yritt�� laittaa varattuun ruutuun, se ei ole ohi taulun, ei siis laiton vaan jokin muu poikkeus...
	}	
	int laskuri=1;							//RK: en oikein hahmota mit� t�m� laskuri tekee t�ss� metodissa, eik�s ne numerot ole jo sy�tetty sinne?
	for(int i=0;i<this.lauta.length;i++) {  //n�� (this.lauta.length) vois olla varmaankin my�s lukuja 3 kun laudan koko on vakio?
		for(int j=0; j<this.lauta[i].length;j++) {
			
			if(laskuri==paikka && this.lauta[i][j]== 'X') {
				throw new Exception("Sinun tulee asettaa merkki vapaalle ruudulle!");
			}
			if(laskuri==paikka && this.lauta[i][j]== 'O') {
				throw new Exception("Sinun tulee asettaa merkki vapaalle ruudulle!");
			}
			if(laskuri==paikka && this.lauta[i][j]!= 'X' && this.lauta[i][j]!='O') {
				this.lauta[i][j]=merkki;
				onnistui = true;
			}
			laskuri=laskuri+1;
		}
	}
	return onnistui;
}

//pitik� t�h�n luokkaan luoda my�s annaMerkki? Mit� se tekee? -ei tarvitse


public boolean onkoVoittanut(Pelaaja p) {
	
		Boolean voitto=false;
		for (int i = 0; i < lauta.length; i++) { 
		    for (int j = 0; j < lauta[i].length; j++) {
		    	if(lauta[i][j]==p.annaMerkki()) {
		    		if(i!=0 && i!=lauta.length-1 && lauta[i+1][j]==p.annaMerkki() && lauta[i-1][j]==p.annaMerkki() || //rivi ei ole eka eik� vika ja ylemm�ss� ja alemmassa ruudussa on samat
		    			i==0 && lauta[i+1][j]==p.annaMerkki() && lauta[i+2][j]==p.annaMerkki() ||  //rivi on eka ja ylemm�ss� ja sit� seuraavassa ruudussa on samat
		    			i==lauta.length-1 && lauta[i-1][j]==p.annaMerkki() && lauta[i-2][j]==p.annaMerkki() ||    //rivi on vika ja alemmassa ja sit� alemmassa ruudussa on samat 
		    			j!=0 && j!=lauta.length-1 && lauta[i][j+1]==p.annaMerkki() && lauta[i][j-1]==p.annaMerkki() ||  //sarake ei ole eka eik� vika ja vas ja oik ruudussa on samat
		    			j==0 && lauta[i][j+1]==p.annaMerkki() && lauta[i][j+2]==p.annaMerkki() ||    //sarake on eka ja vas ja oik ruudussa on samat
		    			j==lauta.length-1 && lauta[i][j-1]==p.annaMerkki() && lauta[i][j-2]==p.annaMerkki() ||  //sarake on vika ja vas ja siit� vas on samat
		    			// diagonaalien tarkistus
		    			i==0 && j==0 && lauta[1][1]==p.annaMerkki() && lauta[2][2]==p.annaMerkki() ||  
		    			i==2 && j==0 && lauta[1][1]==p.annaMerkki() && lauta[0][2]==p.annaMerkki()) {
		    			voitto=true;

		    			}
		    		}
		    	}
		    }
		
		return voitto;
		
	}


public boolean onkoLautaTaynna() {
	boolean taynna=false; 
	int merkkej�=0;
	for (int i = 0; i < this.lauta.length; i++) {
	    for (int j = 0; j < this.lauta[i].length; j++) {
	    	if(this.lauta[i][j]=='X' || this.lauta[i][j]=='O') {
	    		merkkej�=merkkej�+1;
	    	}
	    }	
	}
	if(merkkej�==9) {
		taynna=true;
	}
	return taynna;
}	    	
//	    	for(int a=1; a<10; a++) {
//	    		if(a == Integer.parseInt(String.valueOf(this.lauta[i][j]))) {
//	    			taynna = false;
//	    			
//	    		}
//	    	}
//	    }
//	}
				
//	return taynna;
//}

}