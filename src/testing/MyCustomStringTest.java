package testing;
/**
 * Name: My Anh Huynh
 * Class: SWE 3643 - Summer 2021
 * Assignment #4
 */


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyCustomStringTest {
	private MyCustomStringInterface mycustomstring;

	@BeforeEach
	void setUp() throws Exception {
		mycustomstring = new MyCustomString();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		mycustomstring = null;
	}

	@Test
	void testCountNumber1() {
		mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
	assertEquals(9, mycustomstring.countNumbers());
	}
	@Test( expected = NullPointerException.class)
	void testCountNumbersNullStringException() {
		mycustomstring.setString(null);
	mycustomstring.countNumbers();
	}
	@Test (expected = IllegalArgumentException.class)
    public void testCountNumbersEmptyString() {
		mycustomstring.setString("");
		mycustomstring.countNumbers();
    }
	 @Test
	    public void testCountNumbersStringWithNoNumbersOrWhitespace() {
		 mycustomstring.setString("Thisstringhasnonumbersorwhitespace.");
	        Assert.assertEquals(0, mycustomstring.countNumbers());
	    }
	 @Test
	    public void testCountNumbersStringWithNoNumbersAndWhitespace() {
		 mycustomstring.setString("This string has no \\r\\n number in it.");
	        Assert.assertEquals(1, mycustomstring.countNumbers());
	    }
	 @Test
	    public void testCountNumbersStringWithNumbersAndWhitespace() {
		 mycustomstring.setString("This string has \\r\\n a 1 in it.");
	        Assert.assertEquals(1, mycustomstring.countNumbers());
	    }
	 @Test
	    public void testCountNumbersNumberAtEnd() {
		 mycustomstring.setString("This string ends in a \\r\\n a 1");
	        Assert.assertEquals(1, mycustomstring.countNumbers());
	    }
	 @Test
	    public void testCountNumbersAtBeggining() {
		 mycustomstring.setString("1 this string starts in in a \\r\\n a number.");
	        Assert.assertEquals(1, mycustomstring.countNumbers());
	    }
	 private final String PeterPiper = "Peter Piper picked a peck of pickled peppers.";
	 @Test
	    public void testReverseNCharacters1() {
	        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
	        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", mycustomstring.reverseNCharacters(4, false));
	    }

	    @Test
	    public void testReverseNCharacters2() {
	        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
	        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", mycustomstring.reverseNCharacters(4, true));
	    }
	    @Test(expected = IllegalArgumentException.class)
	    public void testReverseNCharactersNegativeNStringNotNull() {
	    	mycustomstring.setString(PeterPiper);
	    	mycustomstring.reverseNCharacters(-1,true);
	    }
	    @Test(expected = NullPointerException.class)
	    public void testReverseNCharactersNegativeNStringNull() {
	    	mycustomstring.setString(null);
	    	mycustomstring.reverseNCharacters(-1,true);
	    }
	    @Test
	    public void testReverseNCharactersIntMaxN() {
	    	mycustomstring.setString(PeterPiper);
	    	mycustomstring.reverseNCharacters(Integer.MAX_VALUE,true);
	    }
	    @Test(expected = NullPointerException.class)
	    public void testReverseNCharactersNullStringNValid() {
	    	mycustomstring.setString(null);
	    	mycustomstring.reverseNCharacters(Integer.MAX_VALUE,true);
	    }
	    @Test
	    public void testReverseNCharactersEmptyString() {
	    	mycustomstring.setString(PeterPiper);
	        assertEquals("", mycustomstring.reverseNCharacters(Integer.MAX_VALUE, true));
	    }
	    @Test
	    public void testReverseNCharactersGreaterThan0() {
	    	mycustomstring.setString("");
	        assertEquals("", mycustomstring.reverseNCharacters(4, false));
	    }
	    @Test
	    public void testReverseNCharactersZeroString1() {
	    	mycustomstring.setString("1");
	        assertEquals("1", mycustomstring.reverseNCharacters(0, false));
	    }
	    @Test
	    public void testReverseNCharactersGreaterThanString() {
	    	mycustomstring.setString(PeterPiper);
	        assertEquals(new StringBuilder(PeterPiper).reverse().toString(), mycustomstring.reverseNCharacters(PeterPiper.length()+1, false));
	    }
	    @Test
	    public void testReverseNCharactersLessThanStringPadded() {
	    	mycustomstring.setString("test");
	        assertEquals("setXXt", mycustomstring.reverseNCharacters(new String("test").length()-1, true));
	    }
	    @Test
	    public void testReverseNCharactersLessThanString() {
	    	mycustomstring.setString("test");
	        assertEquals("sett", mycustomstring.reverseNCharacters(new String("test").length()-1, false));
	    }
	    @Test
	    public void testConvertDigitsToNamesInSubstring1() {
	        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
	        mycustomstring.convertDigitsToNamesInSubstring(17, 24);
	        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", mycustomstring.getString());
	    }
	    @Test (expected = NullPointerException.class)
	    public void testConvertDigitsToNamesInSubstringNullString() {
	    	mycustomstring.setString(null);
	    	mycustomstring.convertDigitsToNamesInSubstring(0, 0);
	    }
	    @Test (expected = MyIndexOutOfBoundsException.class)
	    public void testConvertDigitsToNamesInSubstringStartPositionLessThan1() {
	    	mycustomstring.setString("");
	    	mycustomstring.convertDigitsToNamesInSubstring(0, 1);
	    }
	    @Test (expected = IllegalArgumentException.class)
	    public void testConvertDigitsToNamesInSubstringEndPositionLessThanStartPosition() {
	    	mycustomstring.setString(" ");
	    	mycustomstring.convertDigitsToNamesInSubstring(2, 1);
	    }
	    @Test (expected = MyIndexOutOfBoundsException.class)
	    public void testConvertDigitsToNamesInSubstringEndPositionEqualToStartPosition() {
	    	mycustomstring.setString(" ");
	    	mycustomstring.convertDigitsToNamesInSubstring(2, 2);
	    }
	    @Test (expected = MyIndexOutOfBoundsException.class)
	    public void testConvertDigitsToNamesInSubstringEndPositionGreaterThanString() {
	    	mycustomstring.setString(" ");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, 2);
	    }
	    @Test
	    public void testConvertDigitsToNamesInSubstringNoNumbersInTheStringStartAt1() {
	    	mycustomstring.setString("This is a string with no numbers.");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, 6);
	    }
	    @Test(expected = MyIndexOutOfBoundsException.class)
	    public void testConvertDigitsToNamesInSubstringEmptyStringStartAndStop1() {
	    	mycustomstring.setString("");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, 1);
	    }
	    @Test(expected = MyIndexOutOfBoundsException.class)
	    public void testConvertDigitsToNamesInSubstringEmptyString() {
	    	mycustomstring.setString("");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, 2);
	    }
	    @Test
	    public void testConvertDigitsToNamesInSubstringOneNumber() {
	    	mycustomstring.setString("10");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, 2);
	        assertEquals("Onezero",mycustomstring.getString());
	    }
	    @Test
	    public void testConvertDigitsToNamesInSubstringTwoNumbers() {
	    	mycustomstring.setString("10 10");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, customStringObjectUnderTest.getString().length());
	        assertEquals("Onezero Onezero",mycustomstring.getString());
	    }
	    @Test
	    public void testConvertDigitsToNamesInSubstringTwoNumbers() {
	    	mycustomstring.setString("10 10");
	    	mycustomstring.convertDigitsToNamesInSubstring(1, customStringObjectUnderTest.getString().length());
	        assertEquals("Onezero Onezero",mycustomstring.getString());
	    }














	    
}
