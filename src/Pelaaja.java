public abstract class Pelaaja {
	
	private String nimi;
	private char merkki;
	
	public Pelaaja(String nimi, char merkki) {
		this.nimi = nimi;
		this.merkki = merkki;
	}
	
	public String annaNimi() {
		return nimi;
	}
	
	public char annaMerkki() {
		return merkki;
	}
	
	//metodi määritellään toteuttamaan syötteenä saatuun / randomilla saatuun sijaintiin merkin asettaminen.
	public abstract void pelaaVuoro(Peli p);
		
	public abstract String muutaPelaajaJonoksi();
	

}
