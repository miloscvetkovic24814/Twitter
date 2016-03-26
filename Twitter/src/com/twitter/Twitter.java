package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa Twitter predstavlja skup tvitova, tj. sadrzi TwitterPoruke i omogucava
 * unos novih ili citanje postojecih poruka. Poseduje listu tih poruka (tvitova)
 * i metode za unos odnosno citanje svih ili samo nekoliko poruka.
 * 
 * @author Milos Cvetkovic
 *
 */
public class Twitter {

	/**
	 * Predstavlja listu poruka (tvitova).
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca listu svih poruka koje se u njoj nalaze.
	 * 
	 * @return LinkedList<TwitterPoruka> Predstavlja listu tvitova.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda kreira novu poruku (TwitterPoruka) i unosi je na kraj liste.
	 * 
	 * @param korisnik
	 *            Predstavlja korisnika (njegov korisnicki nalog).
	 * @param poruka
	 *            Predstavlja sadrzinu same poruke.
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda trazi odredjeni broj poruka koje sadrze zadati tag i njima puni niz koji zatim vraca kao povratnu vrednost.
	 * 
	 * @param maxBroj Predstavlja maksimalan broj poruka koje sadrze zadati tag.
	 * @param tag Predstavlja tag koji sadrze trazene poruke.
	 * @return TwitterPoruka[] Predstavlja niz zahtevanih poruka (tvitova).
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}

}
