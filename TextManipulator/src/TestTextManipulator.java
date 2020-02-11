/**
 * This file contains testing methods for the TextManipulator project.
 */

import java.util.ArrayList;
import java.util.Scanner;


/**
 * This class contains a few methods for testing methods in the TextManipulator
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Kunlun Wang
 * @author FIXME add your name here when you add tests and comment the tests
 *
 */
public class TestTextManipulator {

    /**
     * This is the main method that runs the various tests. Uncomment the tests
     * when you are ready for them to run.
     * 
     * @param args  (unused)
     */
	
	
    public static void main(String [] args) {  
    	// matchCase, translate, pigLatin, reverse(String), reverse(ArrayList<String>), manipulate
   
    		testmatchCase();
    		testtranslate();
    		testpigLatin();
    		testreverseString();
    		testreverseArrayList();
    		testmanipulate();
    		
    }
    
    
       
    
    /**
     * This is intended check method matchCase.  
     * 
     * @param template: the standard form 
     * @param original: input to be modified 
     * @param toRet: return value
     * @param bl: boolean to test if the test has passed 
     *
     */
    
    private static void testmatchCase() {
    	String [] template = {"marc", "MARC", "Mr", "mRmArC", "!"};
    	String [] original= {"MaRK", "mArk", "wAnGkL", "Mw", "."};
    	String toRet="";
    	boolean bl= false;
    	
    	toRet=TextManipulator.matchCase(template[0],original[0]); // testing toLowercase
    	if(!toRet.equals("mark")) {
    		System.out.println("Test matchCase failed: toLowerCase error.");
    		bl=true;
    	}
    	
    	toRet=TextManipulator.matchCase(template[1],original[1]);// testing toUpperCase
    	if(!toRet.equals("MARK")) {
    		System.out.println("Test matchCase failed: toUpperCase error.");
    		bl=true;
    	}
    	
    	
    	toRet=TextManipulator.matchCase(template[2],original[2]);// testing template shorter than original situation 
    	if(!toRet.equals("Wangkl")) {
    		System.out.println("Test matchCase failed: template shorter than original error.");
    		bl=true;
    	}
    	
    	toRet=TextManipulator.matchCase(template[3],original[3]);// testing template longer than original
    	if(!toRet.equals("mW")) {
    		System.out.println("Test matchCase failed: template longer than original error.");
    		bl=true;
    	}
    	
    	toRet=TextManipulator.matchCase(template[4],original[4]);// testing punctuation
    	if(!toRet.equals(".")) {
    		System.out.println("Test matchCase failed: punctuation error");
    		bl=true;
    	}
    	
    	if (!bl) {
    		System.out.println("Test matchCase passed!");
    	}
    	}
    	
        
    
    /**This method is meant to test the the translate method
     * @param toRet:the return value
     * @param bl:boolean 
     * 
     * @param wordList:arraylist of translate 
     * @param first: create wordList 
     * 
     * 
     */
    private static void testtranslate() {
    	ArrayList<String[]>wordList= new ArrayList<String[]>();
    	String toRet="";
    	boolean bl=false;
    	
    	String [] first= {"a	", "un(e)" };
    	String [] second= {"are", 	"être" };
    	String [] third= {"black",	"noir(e)"};
    	String [] fourth= {"blue",	"bleu(e)"};
    	String [] fifth= {"bLack", "noir(e)"};
    	
    	wordList.add(first);
    	wordList.add(second);
    	wordList.add(third);
    	wordList.add(fourth);
    	wordList.add(fifth);
    	
    	toRet= TextManipulator.translate("a", wordList);
    	if (!toRet.equals("un(e)")) {
    		System.out.println("Test translate failed: method error." );
    		bl=true;
    	}
    	
    	
    	toRet= TextManipulator.translate("mark", wordList);
    	if (!toRet.equals("----")) {
    		System.out.println("Test translate failed: Config.LINE_CHAR error." );
    		bl=true;
    	}
    	
    	toRet= TextManipulator.translate("!", wordList);
    	if (!toRet.equals("!")) {
    		System.out.println("Test translate failed: punctuation error." );
    		bl=true;
    	}
    	
    	toRet= TextManipulator.translate("bLack", wordList);
    	if (!toRet.equals("noir(e)")) {
    		System.out.println("Test translate failed: calling matchCase error." );
    		bl=true;
    	}
        if (!bl) {
        	System.out.print("Test translate passed!");
        }
        }
    
    /**
     * This method is meant to test the pigLatin method
     * 
     * @param toRet: the return value
     * @param bl: boolean
     */
    private static void testpigLatin() {
        String toRet="";
        boolean bl=false;
        
        toRet=TextManipulator.pigLatin("Alabama");
        if (!toRet.equals("Alabamaway")) {
        	System.out.println("Test pigLatin failed: vowel rule error.");
        	bl=true;
        }
        
        
        
        toRet=TextManipulator.pigLatin("marc");
        if (!toRet.equals("arcmay")) {
        	System.out.println("Test pigLatin failed: consonants rule error.");
        	bl=true;
        }
        
        
        toRet=TextManipulator.pigLatin("Jim");
        if (!toRet.equals("imJay")) {
        	System.out.println("Test pigLatin failed: consonants rule error.");
        	bl=true;
        }
        
        
        
        toRet=TextManipulator.pigLatin(".");
        if (!toRet.equals(".")) {
        	System.out.println("Test pigLatin failed: other character rule error.");
        	bl=true;
        }
        
        if (!bl) {
        	System.out.println("Test pigLatin passed!");
        }
        }
        
        

        
    /**
     * This method is meant to test the reverse(String) method. 
     * 
     * @param toRet: return value
     * @param bl: boolean
     */
    private static void testreverseString() {
        String toRet="";
        boolean bl= false;
        
        toRet= TextManipulator.reverse("Mark");
        if(toRet.equals("kram")) {
        	System.out.println("Test reverse(String) falied: calling matchCase error.");
        	bl=true;
        }
        	
        
        toRet= TextManipulator.reverse("Marc");
        if(!toRet.equals("Cram")) {
        	System.out.println("Test reverse(String) falied: method error.");
        	bl=true;
        }
        
        toRet= TextManipulator.reverse("Jim");
        if(!toRet.equals("Mij")) {
        	System.out.println("Test reverse(String) falied: method error.");
        	bl=true;
        }
        
        toRet= TextManipulator.reverse("!");
        if(!toRet.equals("!")) {
        	System.out.println("Test reverse(String) falied: punctuation error.");
        	bl=true;
        }
        
        if (!bl) {
        	System.out.println("Test reverse(String) passed!");
        	
        }
        }
        
    
    /**
     * This method is meant to test the reverse(ArrayList)
     * 
     * @param first: ArrayList to be reversed
     * @param toret: the return value
     * @param bl: boolean 
     */
    private static void testreverseArrayList() {
        ArrayList<String> first=new ArrayList<String>();
        ArrayList<String> second=new ArrayList<String>();
        ArrayList<String> third=new ArrayList<String>();
        ArrayList<String> fourth=new ArrayList<String>();
        ArrayList<String> toRet=new ArrayList<String>();
        boolean bl=false;
        
        first.add("CS");
        first.add("Marc");
        first.add("Renault");
        	
        toRet=TextManipulator.reverse(first);
        if (!toRet.get(0).equals("Renault")||!toRet.get(1).equals("Marc")||!toRet.get(2).equals("CS")) {
        	System.out.println("Test reverse(ArrayList) failed: method error.");
        	bl=true;
        }
        
        second.add("Hi");
        second.add("professor");
        second.add("Renault");
        
        toRet=TextManipulator.reverse(second);
        if (!toRet.get(0).equals("Renault")||!toRet.get(1).equals("professor")||!toRet.get(2).equals("Hi")) {
        	System.out.println("Test reverse(ArrayList) failed: method error.");
        	bl=true;
        }
        
        third.add("Hey");
        third.add("Marc");
        third.add("!");
        
        toRet=TextManipulator.reverse(third);
        if (!toRet.get(0).equals("!")||!toRet.get(1).equals("Marc")||!toRet.get(2).equals("Hey")) {
        	System.out.println("Test reverse(ArrayList) failed: method error.");
        	bl=true;
        }
        
        fourth.add("!");
        fourth.add(".");
        fourth.add("#");
        
        toRet=TextManipulator.reverse(fourth);
        if (!toRet.get(0).equals("#")||!toRet.get(1).equals(".")||!toRet.get(2).equals("!")) {
        	System.out.println("Test reverse(ArrayList) failed: method error.");
        	bl=true;
        }
        
        if (!bl) {
        	System.out.print("Test reverse(String) passed!");
        }
    }
        
        		
        	
        
    
    /**
     * This method is meant to test the the manipulate method. 
     * 
     */
    private static void testManipulate() {
    	
    
        ArrayList<ArrayList<String>> toRet=new ArrayList<ArrayList<String>>();
        boolean bl=false;
        
        boolean[] modFlags= new boolean [Config.NUM_MODS];
        
        ArrayList<String[]> wordList= new ArrayList<String[]>();
        
        ArrayList<ArrayList<String>> fileByLine=new ArrayList<ArrayList<String>>();
        
        

}
}
    