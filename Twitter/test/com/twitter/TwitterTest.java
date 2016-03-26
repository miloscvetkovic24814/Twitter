package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	private Twitter tviter;

	@Before
	public void setUp() throws Exception {
		tviter = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		tviter = null;
	}

	@Test
	public void testVratiSvePoruke() {
		tviter.vratiSvePoruke();
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiNullParametri() {
		String korisnik = null;
		String poruka = null;
		tviter.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikPrazanString() {
		String korisnik = "";
		String poruka = "";
		for (int i = 0; i < 150; i++) {
			poruka += "a";
		}
		tviter.unesi(korisnik, poruka);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUnesiPorukuVecuOd140() {
		String korisnik = "Pera";
		String poruka = "";
		for (int i = 0; i < 150; i++) {
			poruka += "a";
		}
		tviter.unesi(korisnik, poruka);
	}

	@Test
	public void testUnesiSveOk() {
		String korisnik = "Pera";
		String poruka = "Cao";
		tviter.unesi(korisnik, poruka);
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		assertEquals(tp.toString(), tviter.vratiSvePoruke().getLast().toString());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		String tag = null;
		tviter.vratiPoruke(5, tag);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazanString() {
		String tag = "";
		tviter.vratiPoruke(5, tag);
	}

	@Test
	public void testVratiPorukeMaxBrojManjiIliJednakOdNule() {
		String korisnik = "Pera";
		String poruka = "danas";
		for (int i = 0; i < 150; i++) {
			tviter.unesi(korisnik, poruka);
		}
		tviter.vratiPoruke(0, poruka);
	}

	@Test
	public void testVratiPorukeSveOk() {
		String tag = "danas";
		tviter.vratiPoruke(15, tag);
	}

}
