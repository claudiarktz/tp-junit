package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void testSimpleAdd() {
		Money m12CHF = new Money(12, "CHF"); // cr�ation de donn�es
		Money m14CHF = new Money(14, "CHF");
		Money expected = new Money(26, "CHF");
		Money result = m12CHF.add(m14CHF); // ex�cution de la m�thode test�e
		assertTrue(expected.equals(result)); // comparaison
	}
	
	@Test
	public void testEquals() {
		Money m12CHF= new Money(12, "CHF");
		Money m14CHF= new Money(14, "CHF");
		assertTrue(!m12CHF.equals(null));
		assertEquals(m12CHF, m12CHF);
		assertEquals(m12CHF, new Money(12, "CHF"));
		assertTrue(!m12CHF.equals(m14CHF));
	}
}

