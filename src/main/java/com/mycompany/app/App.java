package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
	public static String combineLetters(int[] a1,int[] a2,String s1,String s2) {
        System.out.println("inside combineLetters");
        String combined="";
        for(int i=0;i<a1.length;i++){
        	if(s1.equals("") || s2.equals(""))
        		return "empty string!";
        	//0 s are ignored
        	if(a1[i]==0)
        		continue;
        	
        	else if(a1[i]>s1.length()){
        		
        		
        		return "out of the string bounds!";
        	}
        	
        	else{	
        		
	            char cur=s1.charAt(a1[i]-1);
	            if(Character.isAlphabetic(cur))
	                combined+=cur;
	            else {
	                //or should this go into a test
	            
	                return "non letter char!";
	            }
        	}
        }
        for(int i=0;i<a2.length;i++){
        	if(s1.equals("") || s2.equals(""))
        		return "empty string!";
        	//0 s are ignored
        	if(a2[i]==0)
        		continue;
        	
        	else if(a2[i]>s2.length()){
        
        		return "out of the string bounds!";
        	}
        	
        	else{	
        		
	            char cur=s2.charAt(a2[i]-1);
	            if(Character.isAlphabetic(cur))
	                combined+=cur;
	            else {
	                //or should this go into a test
	            	return "non letter char!";
	            }
        	}
        }
        return combined;
       
      }
	
    public static void main( String[] args )
    {
       
    }
}
