package com.mycompany.app;

import java.util.ArrayList;

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
    	ArrayList<Integer> l1 = new ArrayList<>();
    	l1.add(7);
    	l1.add(2);
    	l1.add(1);
     	ArrayList<Integer> l2 = new ArrayList<>();
    	l2.add(3);
    	l2.add(5);
    	l2.add(2);

    	String s=App.combineLetters(l1,l2,"teststring1","teststring2");
    	assertEquals(s,"retsse");
    }
    
    //tests any integer exceedes string's length
    public void testOutofBound(){
    	ArrayList<Integer> l1 = new ArrayList<>();
    	l1.add(13);
    	l1.add(2);
    	l1.add(1);
     	ArrayList<Integer> l2 = new ArrayList<>();
    	l2.add(3);
    	l2.add(5);
    	l2.add(2);
    	String s=App.combineLetters(l1,l2,"teststring1","teststring2");
    	assertEquals(s,"out of the string bounds!");
    }
    public void testEmptyString(){
    	ArrayList<Integer> l1 = new ArrayList<>();
    	l1.add(7);
    	l1.add(2);
    	l1.add(1);
     	ArrayList<Integer> l2 = new ArrayList<>();
    	l2.add(3);
    	l2.add(5);
    	l2.add(2);
    	String s=App.combineLetters(l1,l2,"","teststring2");
    	assertEquals(s,"empty string!");
    }
    public void testNonLetterChar(){
    	ArrayList<Integer> l1 = new ArrayList<>();
    	l1.add(7);
    	l1.add(2);
    	l1.add(1);
     	ArrayList<Integer> l2 = new ArrayList<>();
    	l2.add(3);
    	l2.add(5);
    	l2.add(2);
    	String s=App.combineLetters(l1,l2,"!!!!!!!!!","teststring2");
    	assertEquals(s,"non letter char!");
    }
    public void testZerosIgnored(){
    	ArrayList<Integer> l1 = new ArrayList<>();
    	l1.add(0);
    	l1.add(0);
    	l1.add(0);
     	ArrayList<Integer> l2 = new ArrayList<>();
    	l2.add(0);
    	l2.add(0);
    	l2.add(0);
    	String s=App.combineLetters(l1,l2,"teststring1","teststring2");
    	assertEquals(s,"");
    }
}
