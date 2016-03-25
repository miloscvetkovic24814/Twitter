package com.twitter.poruke;

/**
 * Klasa TwitterPoruka predstavlja neki tvit koji postavlja odredjeni korisnik
 * Tvitera. Svaki tvit se sastoji iz imena korisnika tj. njegovog korisnickog
 * naloga i poruke koju korisnik salje.
 * 
 * @author Milos Cvetkovic
 *
 */

public class TwitterPoruka {

	/**
	 * Atribut korisnik predstavlja korisnika (nalog) koji salje poruku na
	 * Tviteru.
	 */
	private String korisnik;

	/**
	 * Atribut poruka predstavlja sadrzinu same poruke koja se salje.
	 */
	private String poruka;

	/**
	 * Metoda vraca ime korinickog naloga koji salje tvit.
	 * 
	 * @return String
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja ime korisnickog naloga koji zeli da posalje tvit.
	 * 
	 * @throws RuntimeException
	 *             ako je uneti korisnik null ili prazan String.
	 * 
	 * @param korisnik
	 *            Predstavlja ime korisnika (nalog).
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca sadrzinu poruke tj. samog tvita.
	 * 
	 * @return String
	 */

	public String getPoruka() {
		// Mana se manifestovala jer je metoda vracala String "poruka" umesto
		// sadrzinu promenljive poruka, pa je to izmenjeno.
		return poruka;
	}

	/**
	 * Metoda postavlja sadrzinu poruke koju korisnik zeli da tvituje.
	 * 
	 * @throws RuntimeException
	 *             ako je uneta poruka null ili veca od 140 karaktera.
	 * 
	 * @param poruka
	 *            Predstavlja sadrzinu poruke (tvita).
	 */
	public void setPoruka(String poruka) {
		// Mana se nalazila u uslovu, ispitivana je pogresna promenljiva
		// this.poruka umesto poruka, pa je to trebalo prvo izmeniti (padali su
		// testovi za slucaj kada je sve u redu, kada je String prazan i
		// toString metoda).
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Redefinisana metoda toString koja pokazuje sam tvit tj. korisnika i
	 * sadrzinu poruke.
	 */
	public String toString() {
		// Kao sto je vec receno test je padao jer se nalazila mana u uslovu
		// metode setPoruka (this.poruka umesto poruka).
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
