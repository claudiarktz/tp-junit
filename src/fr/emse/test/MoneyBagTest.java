package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyBagTest {

	Money f12CHF;
	Money f14CHF;
	Money f7USD;
	Money f21USD;
	MoneyBag fMB1;
	MoneyBag fMB2;
	
	@Before
	public void setUp() {
		f12CHF = new Money(12, "CHF");
		f14CHF = new Money(14, "CHF");
		f7USD = new Money(7, "USD");
		f21USD = new Money(21, "USD");
		fMB1 = new MoneyBag(f12CHF, f7USD);
		fMB2 = new MoneyBag(f14CHF, f21USD);
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testBagEquals() {
		assertTrue(!fMB1.equals(null));
		assertEquals(fMB1, fMB1);
		assertTrue(!fMB1.equals(f12CHF));
		assertTrue(!f12CHF.equals(fMB1));
		assertTrue(!fMB1.equals(fMB2));
	}
	
	@Test
	public void TestMixedSimpleAdd() {
		Money bag[] = { f12CHF, f7USD };
		MoneyBag expected = new MoneyBag(bag);
		assertEquals(expected, f12CHF.add(f7USD));
	}
	
	@Test
	public void testBagSimpleAdd() {
	    Money expected[] = {f12CHF, f7USD};
	    MoneyBag expectedBag = new MoneyBag(expected);
	    
	    assertEquals(expectedBag, f12CHF.add(fMB1));
	}

	@Test
	public void testSimpleBagAdd() {
	    Money expected[] = {new Money(26, "CHF"), f21USD};
	    MoneyBag expectedBag = new MoneyBag(expected);
	    
	    assertEquals(expectedBag, fMB2.add(f12CHF));
	}

	@Test
	public void testBagBagAdd() {
	    Money expected[] = {new Money(26, "CHF"), new Money(28, "USD")};
	    MoneyBag expectedBag = new MoneyBag(expected);
	    
	    assertEquals(expectedBag, fMB1.add(fMB2));
	}
}
