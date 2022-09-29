package test;

import WhatIsIt.Calc;
import org.junit.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class TestCalc {
	private Calc c = null;
	
	@Test
	public void testAdd() throws IOException {
		System.out.println("testAdd");
		/*
		Calc c = new Calc();
		int res = c.add(2, 5);
		if (7 != res) {
			fail("Ha-ha");
		}

		assertTrue(res == 7);
		assertTrue("error", res == 7);
		assertEquals(7, res);
		assertNotNull(c);
		
		 */
		assertEquals(7, c.add(5, 2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		switch (Integer.parseInt(br.readLine())) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
		}
	}
	
	@Test
	public void testDiv() {
		System.out.println("testDiv");
		Calc c = new Calc();
		assertEquals(4, c.div(10, 5));
		
		// не надо так делать
//		try {
//			c.div(2, 0);
//			fail("Should be an exception");
//		} catch (Exception e) {
//			// do  nothing
//		}
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivException() {
		System.out.println("testDivException");
		new Calc().div(2, 0);
	}
	
	@Before
	public void setup() {
		System.out.println("setupBefore");
		c = new Calc();
	}
	
	@After
	public void setdown() {
		System.out.println("setdownAfter");
		c = null;
	}

	@BeforeClass
	public static void setupBeforeClass() {
		System.out.println("setupBeforeClass");
	}
	@AfterClass
	public static void setdownAfterClass() {
		System.out.println("setdownAfterClass");
	}
	
}
