package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App 
{
	public static String combineLetters(ArrayList<Integer> a1,ArrayList<Integer> a2,String s1,String s2) {
        System.out.println("inside combineLetters");
        String combined="";
        for(int i=0;i<a1.size();i++){
        	if(s1.equals("") || s2.equals(""))
        		return "empty string!";
        	//0 s are ignored
        	if(a1.get(i)==0)
        		continue;
        	
        	else if(a1.get(i)>s1.length()){
        		
        		
        		return "out of the string bounds!";
        	}
        	
        	else{	
        		
	            char cur=s1.charAt(a1.get(i)-1);
	            if(Character.isAlphabetic(cur))
	                combined+=cur;
	            else {
	                //or should this go into a test
	            
	                return "non letter char!";
	            }
        	}
        }
        for(int i=0;i<a2.size();i++){
        	if(s1.equals("") || s2.equals(""))
        		return "empty string!";
        	//0 s are ignored
        	if(a2.get(i)==0)
        		continue;
        	
        	
        	else if(a2.get(i)>s2.length()){
        
        		return "out of the string bounds!";
        	}
        	
        	else{	
        		
	            char cur=s2.charAt(a2.get(i)-1);
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
    	   port(getHerokuAssignedPort());

           get("/", (req, res) -> "Hello, World");

           post("/compute", (req, res) -> {
             //System.out.println(req.queryParams("input1"));
             //System.out.println(req.queryParams("input2"));
        	 //int arrray1
             String input1 = req.queryParams("input1");
             java.util.Scanner sc1 = new java.util.Scanner(input1);
             sc1.useDelimiter("[;\r\n]+");
             java.util.ArrayList<Integer> inputIntList1 = new java.util.ArrayList<>();
             while (sc1.hasNext())
             {
               int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
               inputIntList1.add(value);
             }
             System.out.println(inputIntList1);
        	 //int arrray2
             String input2 = req.queryParams("input2");
             java.util.Scanner sc2= new java.util.Scanner(input2);
             sc2.useDelimiter("[;\r\n]+");
             java.util.ArrayList<Integer> inputIntList2 = new java.util.ArrayList<>();
             while (sc2.hasNext())
             {
               int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
               inputIntList2.add(value);
             }
             System.out.println(inputIntList2);
             
             String inputStr1 = req.queryParams("input3");
             String inputStr2 = req.queryParams("input4");
             


            String result = App.combineLetters(inputIntList1,inputIntList2, inputStr1,inputStr2);

            Map map = new HashMap();
             map.put("result", result);
             return new ModelAndView(map, "compute.mustache");
           }, new MustacheTemplateEngine());


           get("/compute",
               (rq, rs) -> {
                 Map map = new HashMap();
                 map.put("result", "not computed yet!");
                 return new ModelAndView(map, "compute.mustache");
               },
               new MustacheTemplateEngine());
       }

       static int getHerokuAssignedPort() {
           ProcessBuilder processBuilder = new ProcessBuilder();
           if (processBuilder.environment().get("PORT") != null) {
               return Integer.parseInt(processBuilder.environment().get("PORT"));
           }
           return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
       }


    }

