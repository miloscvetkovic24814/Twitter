package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {
	
	TwitterPoruka tviterPoruka;

	@Before
	public void setUp() throws Exception {
		tviterPoruka = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tviterPoruka = null;
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tviterPoruka.setKorisnik(null);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tviterPoruka.setKorisnik("");
	}
	
	@Test
	public void testSetKorisnikSveOK() {
		tviterPoruka.setKorisnik("Pera");
		assertEquals("Pera", tviterPoruka.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tviterPoruka.setPoruka(null);	
	}
	
	@Test
	public void testSetPorukaPrazanString() {
		tviterPoruka.setPoruka("");
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaBrojKarakteraVeciOd140() {
		String s1 = "";
		for (int i = 0; i < 150; i++) {
			s1 += "a";
		}
		tviterPoruka.setPoruka(s1);
	}
	
	@Test
	public void testSetPorukaSveOK() {
		tviterPoruka.setPoruka("Dobar dan");
		assertEquals("Dobar dan", tviterPoruka.getPoruka());
	}

	@Test
	public void testToString() {
		tviterPoruka.setKorisnik("Mika");
		tviterPoruka.setPoruka("Cao");
		assertEquals("KORISNIK:" + "Mika" + " PORUKA:" + "Cao", tviterPoruka.toString());
	}

}
