
public class Lauta {
	
	private char[][] lauta = {    
		  							{ '1', '2', '3' },
		  							{ '4', '5', '6' },
		  							{ '7', '8', '9' }
							};
	
	//private Pelaaja vuorossa; 	//tähän voisi tallentaa sen, kenen vuoro on
							   // Roosan kommentti: lauta ei taida saada mistään tietoa pelaajista, eli tämä täytyy varmaankin olla toisessa luokassa, peli-luokassa?.
	
	//public Lauta() {      *ei taida tarvita tätä lainkaan?
			
	//	}



	
public void tulostaPelilauta() {	
		
		System.out.println("Tässä on lauta:");
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


// pitäisikö tämän metodin olla public Lauta, jotta palauttaa laudan? <- RK: en ihan tiedä mitä meinaat, mutta static tämä ei voi mielestäni olla
public boolean asetaMerkki(char merkki, int paikka) throws IllegalArgumentException, Exception {
	boolean onnistui = false;
	if(paikka<1 || paikka>9) {
		throw new IllegalArgumentException("Paikan tulee olla väliltä 1-9!");     // RK: Tässä tämä mielestäni toimii, mutta tuonne for-loopin sisään täytyy laittaa joku muu, 
																				// koska kun ne otetaan kiinni, niille täytyy antaa yleispätevä virheviesti.
																			  //  eli jos yrittää laittaa varattuun ruutuun, se ei ole ohi taulun, ei siis laiton vaan jokin muu poikkeus...
	}	
	int laskuri=1;							//RK: en oikein hahmota mitä tämä laskuri tekee tässä metodissa, eikös ne numerot ole jo syötetty sinne?
	for(int i=0;i<this.lauta.length;i++) {  //nää (this.lauta.length) vois olla varmaankin myös lukuja 3 kun laudan koko on vakio?
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

//pitikö tähän luokkaan luoda myös annaMerkki? Mitä se tekee? -ei tarvitse


public boolean onkoVoittanut(Pelaaja p) {
	
		Boolean voitto=false;
		for (int i = 0; i < lauta.length; i++) { 
		    for (int j = 0; j < lauta[i].length; j++) {
		    	if(lauta[i][j]==p.annaMerkki()) {
		    		if(i!=0 && i!=lauta.length-1 && lauta[i+1][j]==p.annaMerkki() && lauta[i-1][j]==p.annaMerkki() || //rivi ei ole eka eikä vika ja ylemmässä ja alemmassa ruudussa on samat
		    			i==0 && lauta[i+1][j]==p.annaMerkki() && lauta[i+2][j]==p.annaMerkki() ||  //rivi on eka ja ylemmässä ja sitä seuraavassa ruudussa on samat
		    			i==lauta.length-1 && lauta[i-1][j]==p.annaMerkki() && lauta[i-2][j]==p.annaMerkki() ||    //rivi on vika ja alemmassa ja sitä alemmassa ruudussa on samat 
		    			j!=0 && j!=lauta.length-1 && lauta[i][j+1]==p.annaMerkki() && lauta[i][j-1]==p.annaMerkki() ||  //sarake ei ole eka eikä vika ja vas ja oik ruudussa on samat
		    			j==0 && lauta[i][j+1]==p.annaMerkki() && lauta[i][j+2]==p.annaMerkki() ||    //sarake on eka ja vas ja oik ruudussa on samat
		    			j==lauta.length-1 && lauta[i][j-1]==p.annaMerkki() && lauta[i][j-2]==p.annaMerkki() ||  //sarake on vika ja vas ja siitä vas on samat
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
	int merkkejä=0;
	for (int i = 0; i < this.lauta.length; i++) {
	    for (int j = 0; j < this.lauta[i].length; j++) {
	    	if(this.lauta[i][j]=='X' || this.lauta[i][j]=='O') {
	    		merkkejä=merkkejä+1;
	    	}
	    }	
	}
	if(merkkejä==9) {
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