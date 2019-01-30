package com.mycompany.app;

import junit.framework.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;
//import org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
   
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testCombined(){
    	int[] a1={7,2,1};
    	int[] a2={3,5,2};
    	String s=App.combineLetters(a1,a2,"teststring1","teststring2");
    	assertEquals(s,"retsse");
    }
    
    //tests any integer exceedes string's length
    public void testOutofBound(){
    	int[] a1={13,2,1};
    	int[] a2={3,5,2};
    	String s=App.combineLetters(a1,a2,"teststring1","teststring2");
    	assertEquals(s,"out of the string bounds!");
    }
    public void testEmptyString(){
    	int[] a1={7,2,1};
    	int[] a2={3,5,2};
    	String s=App.combineLetters(a1,a2,"","teststring2");
    	assertEquals(s,"empty string!");
    }
    public void testNonLetterChar(){
    	int[] a1={7,2,1};
    	int[] a2={3,5,2};
    	String s=App.combineLetters(a1,a2,"!!!!!!!!!","teststring2");
    	assertEquals(s,"non letter char!");
    }
    public void testZerosIgnored(){
    	int[] a1={0,0,0};
    	int[] a2={0,0,0};
    	String s=App.combineLetters(a1,a2,"teststring1","teststring2");
    	assertEquals(s,"");
    }
}
