//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           MineSweeper
// Files:           MineSweeper.java
// Course:          CS200 Fall 2017
//
// Author:          Kunlun Wang
// Email:           kwang358@wisc.edu
// Lecturer's Name: Marc Renault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.  If you received no outside help from either type of 
// source, then please explicitly indicate NONE.
//
// Persons:         Bohong Chen; Daoxing Zhang
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


//FIXME file header comment

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//FIXME class header comment

public class TextManipulator {

    /**
     * Matches the case of the original string to that of the template as follows. 
     *
     * 1) If the length of template is the same or longer than the length of the original, the 
     *    returned string will match the case of the prefix of the template up to the length of the
     *    original string. 
     *    For example:
     *         template: XXxxxXxX
     *         original: azertYU
     *         returns:  AZertYu
     *
     * 2) If the length of the template is shorter than the length of the original, the prefix of the
     *    returned string up to the length of the template will match the case of the template. The 
     *    remaining characters should all be lower case.
     *    For example: 
     *         template: WxCv
     *         original: azertYU
     *         returns:  AzErtyu
     *
     * @param template Template of which characters should be which case.
     * @param original String to change the case of, based on the template.
     * @return A string containing the characters of original with the case matching that of 
     *         template.
     */
    public static String matchCase(String template, String original) {
        
    	String str = "";
    	
    	if (template.length()>original.length()) {
    		for (int i =0; i<original.length(); ++i) {
    			
    			
    			char char2= template.charAt(i);
    			
    			char char1= original.charAt(i);
    			
    			
    			if (Character.isUpperCase(char2)) { 
    				char1= Character.toUpperCase(char1); }
    			
    				else {
    					
    					char1=Character.toLowerCase(char1);
    					}
    			
    			str= str+ char1;
    		}
    	}
    	else {
    		for (int i=0; i< template.length(); ++i) {
    			
    			char char2=template.charAt(i);
    			
    			char char1= original.charAt(i);
    			
    			  			
    			if (Character.isUpperCase(char2)) {
    				
    				char1=Character.toUpperCase(char1); 
    				}
    			else {
    				
    				char1=Character.toLowerCase(char1);
    				}
    			
    			str=str+char1;
    		}
    		str=str+original.substring(template.length(),original.length()).toLowerCase();
    	}
    	return str;
    	 
    }
    		
    					
    			
    					
    				
    	
    			
    					
    			

    /**
     * Translates a word according to the data in wordList then matches the case. The parameter 
     * wordList contains the mappings for the translation. The data is organized in an ArrayList 
     * containing String arrays of length 2. The first cell (index 0) contains the word in the 
     * original language, called the key, and the second cell (index 1) contains the translation.
     *
     * It is assumed that the items in the wordList are sorted in ascending order according to 
     * the keys in the first cell. 
     *
     * @param word The word to translate.
     * @param wordList An ArrayList containing the translation mappings.          
     * @return The mapping in the wordList with the same case as the original. If no match is found
     *         in wordList, it returns a string of Config.LINE_CHAR of the same length as word.
     */
    public static String translate(String word, ArrayList<String[]> wordList) {
    	
    	boolean b= false;
        String ToRet="";
        
       
        	
        if (word!=".") {
        	for (int i=0; i<wordList.size();++i) {
        		if (word.equalsIgnoreCase(wordList.get(i)[0])) {
        			b=true;
        			ToRet=wordList.get(i)[1];
        		}
        	}
        }
        
    if (word.equals("!")) {
    	return "!";
    }
    
    if (word.equals(".")) {
    	return ".";
    }
    
    if (b) {
    	ToRet=matchCase(word, ToRet);
    	return ToRet;
    }
    
    else {
    	for (int i=0; i<word.length();++i) {
    		ToRet=ToRet+Config.LINE_CHAR;
    	}
    	return ToRet;
    }
    }
    
    	
    		
   		

    /**
     * Converts a string to simplified Pig Latin then matching the case. The rules for simplified Pig 
     * Latin are as follows:
     * 1) If the word begins with a vowel (a, e, i, o, u, or y), then the string "way" is appended. 
     * 2) If the word begins with a consonant (any letter that is not a vowel as defined above), then
     *    the group of consonants at the beginning of the word are moved to the end of the string,
     *    and then the string "ay" is appended.
     * 3) If the word begins with any other character, the original string is returned.
     * Note 1: 'y' is always considered a vowel.
     * Note 2: An apostrophe that is not the first character of a word is treated as a consonant. 
     *
     * Some examples:
     *   Pig -> Igpay
     *   Latin -> Atinlay
     *   Scram -> Amscray
     *   I'd -> I'dway
     *   you -> youway
     *   crypt -> yptcray 
     *
     * @param word The word to covert to simplified Pig Latin.
     * @return The simplified Pig Latin of the parameter word with matching case.
     */
    public static String pigLatin(String word) {
        
    	
    	int x=0;
    	boolean b=false;
    	String pigword="";
    
    	
    	if(word.toLowerCase().charAt(0)=='a'||word.toLowerCase().charAt(0)=='e'||word.toLowerCase().charAt(0)=='i'||word.toLowerCase().charAt(0)=='o'||word.toLowerCase().charAt(0)=='u'||word.toLowerCase().charAt(0)=='y') {
    		pigword= word + "way";
    	}
    	
    	else {
    		for (int i=0; i<word.length(); ++i) {
    			if(word.toLowerCase().charAt(i)=='a'||word.toLowerCase().charAt(i)=='e'||word.toLowerCase().charAt(i)=='i'||word.toLowerCase().charAt(i)=='o'||word.toLowerCase().charAt(i)=='u'||word.toLowerCase().charAt(i)=='y') {
    				b=true;
    				x=i;
    				break;
    			}
    		}
    		if (b) {
    			pigword=word.substring(x)+word.substring(0,x) + "ay";
    			pigword=matchCase(word, pigword);
    		}
    		else {
    			return word;
    		}
    	}
    	return pigword;
    }
    			
    /**
     * Reverses a String, then matches the case.
     * For example: aZErty returns yTReza
     *
     * @param word The String to reverse.
     * @return The reverse of word with matching case.
     */
    public static String reverse(String word) {
    	
        String str="";
        
        for (int i=word.length()-1;i>=0; --i) {
        	
        	str= str+word.charAt(i);
        	
        	str=matchCase(word, str);
        	
        }
        return str;
    }

    /**
     * Builds a new ArrayList of Strings that contains the items of the ArrayList passed in, arrL,
     * but in reverse order.
     *
     * @param arrL The ArrayList of Strings to reverse.
     * @return A new ArraList of Strings that is the reverse of arrL.
     */
    public static ArrayList<String> reverse(ArrayList<String> arrL) {
    	
        ArrayList<String> reversedArrayList = new ArrayList<String>();
        
        for (int i=arrL.size()-1;i>=0;--i) {
        	
        	reversedArrayList.add(arrL.get(i));
        }
        return reversedArrayList;
       
        }
        

    /**
     * The method that displays the main program menu and reads the user's menu choice.
     * The full menu has the following format where the (assuming that Config.MISSING_CHAR is '-'):
     * 
     * --------------------------------------------------------------------------------
     * Text Manipulator Program
     * --------------------------------------------------------------------------------
     * Current input file: ---
     * Current output file: ---
     * Current dictionary: ---
     * Current mode: Interleaved
     * Current mods: TPWL
     * --------------------------------------------------------------------------------
     * Main menu:
     * 1) Display Output
     * 2) Save Output
     * Manipulations:
     *        T)ranslate
     *        P)ig latin
     *        W)ord reverse
     *        L)ine reverse
     * Configuration:
     *        I)nput file.
     *        O)utput file.
     *        D)ictionary file.
     *        M)ode Toggle.
     *        H)ide/show Menu.
     * Q)uit
     * Enter action: 
     *
     * Notes:
     *   - The lines consist of 80 Config.LINE_CHAR characters.
     *   - The input file, output file and dictionary names are 3 Config.LINE_CHAR characters if 
     *     appropriate value in files is null, otherwise display the appropriate value in files.
     *   - The Current mode displays "Interleaved" when modeBoth is true and "Modified" when false.
     *   - The Current mods displays (in the following order) 'T' if translate is toggled, 'P' if
     *     Pig Latin is toggled, 'W' if word reverse is toggled, and 'L' if line reverse is toggled.
     *   - The manipulation and configuration options are preceded by a single tab.
     *   - There is no new line following the final "Enter action: " prompt.
     *
     * @param sc The reference to the Scanner object for reading input from the user.
     * @param files A string array containing the input file name, the output file name, and the
     *              dictionary file name in that exact order. The entries may be null. The length
     *              of the array is Config.NUM_FILES. The input file name is at index 
     *              Config.FILE_IN, the output file name is at index Config.FILE_OUT, and the
     *              dictionary file name is at index Config.FILE_DICT.
     * @param modFlags A boolean array where the values are true if the given modification is set
     *                 to be applied. 
     * @param modeBoth True if the display command will alternate lines from the modified text and
     *                 the original text.
     * @param showMenu If true the entire menu is shown, otherwise only the "Enter Action: " line is
                       shown.
     * @return The first character of the line inputed by the user.
     */
    public static char promptMenu(Scanner sc, String[] files, boolean[] modFlags, boolean modeBoth,
                                  boolean showMenu) {
    	if (showMenu==true) { 
    		
    	
        for (int i=1; i<=80; i++) {
        	System.out.print(Config.LINE_CHAR);
        }
        System.out.println();
        
        System.out.println("Text Manipulator Program");
        
        for (int i=1; i<=80; i++) {
        	System.out.print(Config.LINE_CHAR);
        }
        
        System.out.println();
        
        String Input="";
        String Output="";
        String Dictionary="";
        
        if (files[Config.FILE_IN] != null) {
        	Input= files[Config.FILE_IN];
        }
        else {
        	Input = ""+Config.LINE_CHAR+Config.LINE_CHAR+Config.LINE_CHAR;
        }
        
        if (files[Config.FILE_OUT] != null) { 
        	Output= files[Config.FILE_OUT];
        	
        }
        else {
        	Output=""+Config.LINE_CHAR+Config.LINE_CHAR+Config.LINE_CHAR;
        }
        
        if (files[Config.FILE_DICT]!=null) {
        	Dictionary=files[Config.FILE_DICT];
        }
        else {
        	Dictionary=""+Config.LINE_CHAR+Config.LINE_CHAR+Config.LINE_CHAR; 
        }
        
        System.out.println("Current input file: "+Input);
        System.out.println("Current output file: "+Output);
        System.out.println("Current dictionary: "+Dictionary);
        System.out.print("Current mode: ");
        
        if (modeBoth==true) {
        	System.out.println("Interleaved");
        }
        else {
        	System.out.println("Modified");
        }
        
        System.out.print("Current mods: " );
        
        if (modFlags[Config.MOD_TRANS]==true) {
        	System.out.print("T");
        }
        if (modFlags[Config.MOD_PIG]==true) {
        	System.out.print("P");
        }
        if (modFlags[Config.MOD_REV_WORD]==true) {
        	System.out.print("W");
        }
        if (modFlags[Config.MOD_REV_LINE]==true) {
        	System.out.print("L");
        }
        System.out.println();
        
        for (int i=1; i<=80; i++) {
        	System.out.print(Config.LINE_CHAR); 
        } 
        System.out.println();
        System.out.println("Main menu:");
        System.out.println("1) Display Output");
        System.out.println("2) Save Output");
        System.out.println("Manipulations:");
        System.out.println("\t"+"T)ranslate");
        System.out.println("\t"+"P)ig latin");
        System.out.println("\t"+"W)ord reverse");
        System.out.println("\t"+"L)ine reverse");
        System.out.println("Configuration:");
        System.out.println("\t"+"I)nput file.");
        System.out.println("\t"+"O)utput file.");
        System.out.println("\t"+"D)ictionary file.");
        System.out.println("\t"+"M)ode Toggle.");
        System.out.println("\t"+"H)ide/show Menu.");
        System.out.println("Q)uit");
        System.out.print("Enter action: ");
    	}
    	else {
    		System.out.print("Enter action: ");
    	}
    	char ret = (sc.nextLine()).charAt(0);
    	return ret;
   
        
      
    }

    /**
     * Prompts the user for a new file name. The prompt should be:
     * "Enter file name [curFileName]: ", where curFileName is the value from the parameter of the
     * same name. There should not be a new line following the prompt.
     *
     * @param sc The reference to the Scanner object for reading input from the user.
     * @param curFileName The current file name.
     * @return The value input by the user excluding any leading or trailing white space. If the
     *         input is an empty string, then curFileName is returned.  
     */
    public static String updateFileName(Scanner sc, String curFileName) {
        System.out.print("Enter file name [" + curFileName + "]: ");
        
        String fileName=sc.nextLine(); 
        
        if (fileName =="") {
        	return curFileName; 
        }
        fileName=fileName.trim();
        return fileName; 
        
        }
        
        

    /**
     * Opens and reads the contents of the dictionary file specified in fileName. The file is 
     * assumed to be a text file encoded in UTF-8. It is assumed that there is one translation 
     * mapping per line. Each line contains a key and its translation separated by a tab.
     * Note: The dictionary file is assumed to be sorted by the keys in ascending order. 
     *
     * For each line in the dictionary file, an entry is added into wordList. The entry is a String
     * array of length 2, where the value of index 0 is the key and the value of index 1 is the
     * translation.
     *
     * When opening the file, any FileNotFoundException is caught and the error message 
     * "Exception: File 'fileName' not found." followed by a new line is output,
     * where fileName is the name of the file that the method attempted to open.
     *
     * @param fileName
     * @param wordList Reference to ArrayList to contain the translation mappings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *                     caught when opening the file.
     */
    public static void readDictFile(String fileName,
                                    ArrayList<String[]> wordList) throws IOException {
    	Scanner Reader= null;
    	boolean b=true;
    	FileInputStream  Open= null;
    	
    	try {
    		if (fileName!=null) {
    			
    			Open= new FileInputStream(fileName);
    			
    			Reader=new Scanner (Open);
    			
    			while (Reader.hasNextLine()) {
    				String[] WL=new String[2];
    				for (String str: Reader.nextLine().split("\t")) {
    					
    				
    					if (b) {
    						WL[0]=str;
    						b=false;
    					}
    					else {
    						WL[1]=str;
    						b=true;
    					}
    				}
    					wordList.add(WL);
    			}
    		}
    	}
    	catch ( FileNotFoundException e) {
    		System.out.println("Exception: File '"+fileName+"' not found.");
    		
    	}
    	finally {
    		if (Reader!=null) {
    			Reader.close();
    		}
    	}
    	
    
    					
    	
    }

    /**
     * Opens and reads the contents of the input file specified in fileName. The input file is read
     * line by line. Each line is split into words and punction (excluding the apostrophe) and
     * stored in an ArrayList of Strings. These ArrayLists representing the line are stored in an
     * ArrayList of ArrayLists of Strings. Specifically, they are put in the ArrayList fileByLine
     * that is passed in as a parameter.
     *
     * For example, a file containing the following: 
     * Lorem ipsum dolor sit amet, consectetur adipiscing elit. Don'ec elementum tortor in mauris 
     * consequat vulputate.
     *
     * Would produce an ArrayList of ArrayLists containing 2 ArrayLists of Strings.
     * The first ArrayList would contain:
     *   "Lorem", "ipsum", "dolor", "sit", "amet", ",", "consectetur", "adipiscing", "elit", ".", 
     *   "Don'ec", "elementum", "tortor", "in", "mauris"
     * The second Arraylist would contain:
     *   "consequat", "vulputate", "."
     *
     * Note 1: The text file is assumed to be UTF-8.
     * Note 2: There are no assumption about the length of the file or the length of the lines.
     * Note 3: All single quotes (') are assumed to be apostrophes.
     *
     * When opening the file, any FileNotFoundException is caught and the error message 
     * "Exception: File 'fileName' not found." followed by a new line is output,
     * where fileName is the name of the file that the method attempted to open.
     *
     * @param fileName The name of the input text file to parse.
     * @param fileByLine Reference to ArrayList to contain the contents of the file line by line, 
     *                   where each line is an ArrayList of Strings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *                     caught when opening the file.
     */
    public static void readInputFile(String fileName,
                                     ArrayList<ArrayList<String> > fileByLine) throws IOException {
    	
    	    FileInputStream FIS =new FileInputStream(fileName);
        
        Scanner scnr = new Scanner(FIS);
        
        while (scnr.hasNextLine()) {
        	
        	String inputFile= scnr.nextLine();
        	String tmp="";
        
        	ArrayList<String>  ReadFI = new ArrayList<String> ();
        	
        	 for (int i=0; i<inputFile.length(); i++) {
        		 
        		 if ( Character.isLetter(inputFile.charAt(i))==true || inputFile.substring(i,i+1).equals("'")){ 
        			 tmp += inputFile.charAt(i);
        			 
        			 if (i==inputFile.length()-1) {
        				 ReadFI.add(tmp);
        			 }
        		 }
        		 
        			 
        			 else {
        				 if (tmp != "") {
        					 ReadFI.add(tmp);
        				 }
        				 tmp=""; // clear the string tmp for the next round 
        				 
        				 if (Character.isWhitespace(inputFile.charAt(i))==false) {
        					 ReadFI.add(inputFile.substring(i,i+1));
        				 }
        					
        				 
        		 }
        	 }
        	fileByLine.add(ReadFI);
        	ReadFI =new ArrayList<String>(); //clear the ArrayList for the next round 
        	
        	 }
        
        }
        
        
    

    /**
     * Opens and writes (overwrites if the file already exits) the modified contents of the input 
     * file specified contained in modFileByLine to a filecalled filename. medFileByLine is an 
     * ArrayList containing one ArrayList of String for each output line. 
     *
     * When producing the output file, each line should be terminated by a new line. Each 
     * non-punctuation should be Moreover, the
     * spacing around the punctuation should be as follows:
     * - Excluding, double quotes ("), no space between the preceding string and the punctuation and
     *   a space following.
     * - Double quotes (") will be treated as pairs:
     *    - the first double quote will be preceded by a space and will not have a space following.
     *    - the next double quote will not be preceded by space and will have a space following.  
     *
     * If modFileByLine is an ArrayList of ArrayLists containt 2 ArrayLists of Strings, such that:
     * - The first ArrayList contains:
     *   "Lorem", "ipsum", "\"", "dolor", "sit", "\"", "amet", ",", "consectetur", "adipiscing", 
     *   "elit", ".", "Don'ec", "elementum", "tortor", "in", "mauris"
     * - The second Arraylist contains:
     *   "consequat", "vulputate", "."
     *
     * The output to the file would be:
     * Lorem ipsum "dolor sit" amet consectetur adipiscing elit. Don'ec elementum tortor in mauris
     * consequat vulputate.
     *
     * Note 1: The output to the file is UTF-8.
     *
     * When opening the file, any FileNotFoundException is caught and the error message 
     * "Exception: File 'fileName' not found." followed by a new line is output,
     * where fileName is the name of the file that the method attempted to open.
     *
     * @param fileName The name of the input text file to parse.
     * @param modFileByLine Reference to ArrayList to contain the modified contents of the file line
     *                      by line, where each line is an ArrayList of Strings.
     * @throws IOException if an I/O error occurs when closing the file. FileNotFoundException is
     *                     caught when opening the file.
     */
    public static void saveToFile(String fileName,
                                  ArrayList<ArrayList<String> > modFileByLine) throws IOException {
        boolean b=false;
        
        FileOutputStream FOS=null;
        
        PrintWriter pw= null; 
        
        try {
        	if (fileName!=null) {
        		
        		FOS =new FileOutputStream (fileName);
        		
        		pw=new PrintWriter (FOS); 
        		
        		 for (int j=0; j<modFileByLine.size();++j) {
        			 
        			 pw.print(modFileByLine.get(j).get(0));
        			 
        			 for (int k=1; k<modFileByLine.get(k).size();++k) {
        				 
        				 if(modFileByLine.get(j).get(k).equals(".")) {
        					 
        					 pw.print(modFileByLine.get(j).get(k));
        				 }
        				
        				 else if (modFileByLine.get(j).get(k).equals("\"")&&b==false) {
        					 pw.print(" "+modFileByLine.get(j).get(k));
        					 b=true;
        				 }
        				 
        				 else if (modFileByLine.get(j).get(k).equals("\"")&&b==true) {
        					 pw.print(modFileByLine.get(j).get(k));
        					 b=false;
        					 
        				 }
        				 
        				 else if (modFileByLine.get(j).get(k).equals("!")) {
        					 pw.print(modFileByLine.get(j).get(k));
        				 }
        				 
        				 
        				 else {
        					 pw.print(" "+modFileByLine.get(j).get(k));
        				 }
        				 pw.println();
        			 }
        			 pw.flush();
        		 }
        	}
        }
        	
        	catch (FileNotFoundException e) {
        	 System.out.println("Exception: File '"+fileName+"' not found.");
        	}
        	finally {
        		if (pw!=null) {
        			pw.close();
        		}
        	}
        }
        				

    /**
     * Prints out the modified file (and possibly interleaved with the original file) to the screen.
     *
     * If modeBoth is false, then the contents of modFileByLine is output line by line. Each word is
     * output followed by a space except for the last word. Each line is terminated with a new line
     * character.
     *
     * For the non-interleaved mode, consider the following example:
     * modFileByLine contains 2 ArrayList of Strings: 
     *          1: "Où", "est", "la", "bibliothèque", "?"
     *          2: "Aucune", "idée", "."
     *
     * The output would be:
     * Où est la bibliothèque ?
     * Aucune idée .
     *
     * Otherwise, modeBoth is true, then the contents of modFileByLine is interleaved with fileByline. 
     * Lines are printed out in order. First, a line from modFileByLine is output followed by a new
     * line character followed by the corresponding line in fileByLine. In order to better match up
     * the corresponding words in the corresponding lines, the short word is appended with spaces to
     * the length of the longer word. Between each word adjusted for length is an additional space.
     *
     * For the interleaved mode, consider the following example:
     * 
     * modFileByLine contains 2 ArrayList of Strings: 
     *          1: "Où", "est", "la", "bibliothèque", "?"
     *          2: "Aucune", "idée", "."
     * fileByLine contains 1 ArrayList of Strings: 
     *          1: "Where", "is", "the", "library", "?"
     *          2: "No", "idea", "."
     *
     * The output would be:
     * Où    est la  bibliothèque ?
     * Where is  the library      ?   
     * Aucune idée .
     * No     idea . 
     * 
     * @param fileByLine An ArrayList of ArrayList of Strings containing the original content.
     * @param modFileByLine An ArrayList of ArrayList of Strings containing the modified content.
     * @param modeBoth Flag to indicate if the original file should be interleaved.
     * @throws Exception Throws an Exception with the message "Number of lines in modified version
     *                   differs from original." if the size of fileByLine differes from 
     *                   modFileByLine.
     * @throws Exception Throws an Exception with the message "Number of words on line i in modified
     *                   version differs from original.", where i should be the 0-based line index
     *                   where the size of the ArrayList at index i in fileByLine differes from the
     *                   ArrayList at index i in modFileByLine.
     */
    public static void display(ArrayList<ArrayList<String> > fileByLine,
                               ArrayList<ArrayList<String> > modFileByLine,
                               boolean modeBoth) throws Exception {
    	
       if (modeBoth) {
    	   
    	   if (fileByLine.size()!=fileByLine.size()) {
    		   
    		   throw new Exception ("Number of lines in modified version differs from original.");
    	   }
    	   
    	   for (int a=0; a<modFileByLine.size();++a) { //interleaved mode starts!! 
    		   
    		   if (fileByLine.get(a).size()!=modFileByLine.get(a).size()) {
    			   throw new Exception ("Number of words on line i in modified versions differs from original");
    		   }
    		   for (int b=0; b<modFileByLine.get(a).size()-1;++b) {
    			   
    			   if (modFileByLine.get(a).get(b).length()>fileByLine.get(a).get(b).length()) {
    				   
    				   System.out.print(modFileByLine.get(a).get(b)+" "); //print out the content 
    				   
    				   for (int c=0; c<fileByLine.get(a).get(b).length()-fileByLine.get(a).get(b).length(); ++c) {
    					   
    					   System.out.print(" "); // Between each word adjusted for length is an additional space.
    					   }
    				   System.out.print(" ");
    			   }
    			   else {
    				   System.out.print(fileByLine.get(a).get(b)+" ");
    			   }
    		   }
    		   System.out.print(fileByLine.get(a).get(fileByLine.get(a).size()-1));
    		   
    		   System.out.println();
    		   
    		   System.out.println();
    		   
    		   
    			   
    			   
    			   }
    	   
    		   }
       
       else {
    	   
    	   for (int d=0; d<modFileByLine.size(); ++d) {
    		   
    		   if (fileByLine.get(d).size()!=modFileByLine.get(d).size()) {
    			   
    			   throw new Exception ("Number of words on line i in modified version differs from original");
    			   
    			   // Exception: size of fileByLine(original) is different from the size of modFileByLine(modified) 
    		   }
    		   
    		   for (int e=0; e< modFileByLine.get(d).size()-1;++e) {
    			   
    			   System.out.print(modFileByLine.get(d).get(e)+ " ");
    			   //
    		   }
    		   System.out.println(modFileByLine.get(d).get(modFileByLine.get(d).size()-1));
    		   //output the content of the modFileByLine
    		   
    	   }
    	   
    				   
    			   }
    		   }
    	 
     

    /**
     * Performs the actions specified by the modFlags to the input file stored in the ArrayList of
     * ArrayLists of Strings fileByLine. This method stores the modified string in a new ArrayList
     * of ArrayLists of Strings which it returns.
     *
     * There are 4 modifications that may be performed. They are to be process in the following 
     * order if indicated in modFlags:
     *   1 - Translation
     *   2 - To Pig Latin
     *   3 - Reverse the letters in each word
     *   4 - Reverse the words in each line
     *
     * @param fileByLine The original file stored as an ArrayList of ArrayLists of Strings.
     * @param dict An ArrayList of String arrays of length two. The ArrayList is assumed to be
     *             sorted in ascending order accordings to the strings at index 0. This will be the
     *             second argument for the translate method.
     * @param modFlags A boolean area of length Config.NUM_MODS that indicates which translation 
     *                 to perform by having a value of true in the appropriate cell as follows:
     *                 Index                  Modification
     *                 -------------------    --------------------------------
     *                 Config.MOD_TRANS       Translation
     *                 Config.MOD_PIG         To Pig Latin
     *                 Config.MOD_REV_WORD    Reverse the letters in each word
     *                 Config.MOD_REv_LINE    Reverse the words in each line
     *@return An ArrayList of ArrayLists of Strings, where each internal ArrayList is a line 
     *        which corresponds to the data in fileByLine but with the transformations applied in 
     *        the order specified above.
     */
    public static ArrayList<ArrayList<String> > manipulate(ArrayList<ArrayList<String> > fileByLine,
                                                           ArrayList<String[]> dict,
                                                           boolean[] modFlags) {
    	String tmp=""; 
    	
        ArrayList<ArrayList<String>> manipulateList = new ArrayList<ArrayList<String>>();
        if (modFlags[Config.MOD_TRANS]== false&&modFlags[Config.MOD_REV_WORD]==false&&modFlags[Config.MOD_PIG]==false&&modFlags[Config.MOD_REV_LINE]==false) {
        	return fileByLine;
        }
        else {
        	for (int i=0; i<fileByLine.size();++i) {
        		
        		ArrayList<String> arryL=new ArrayList<String>();
        		
        		for (int j=0; j<fileByLine.get(i).size(); ++j) {
        			
        			tmp = fileByLine.get(i).get(j);
        			
        			if (modFlags[Config.MOD_REV_WORD]==true) {
        				tmp=reverse(tmp);
        			}
        			
        			if (modFlags[Config.MOD_TRANS]==true) {
        				tmp= translate(tmp,dict);
        			}
        			
        			if (modFlags[Config.MOD_PIG]==true) {
        				tmp=pigLatin(tmp);
        			}
        			arryL.add(tmp);
        		}
        		manipulateList.add(arryL);
        		
        		if (modFlags[Config.MOD_REV_LINE]==true) {
        			
        			
        			manipulateList.set(i, reverse(manipulateList.get(i)));
        		}
        	}
        }
        return manipulateList;
        		
        
        //For Milestone 2, you will need to build a new ArrayList<ArrayList<String>> that will be
        //returned. Go through the each string in fileByLine and, if the boolean at
        //Config.MOD_TRANS in modFlags is true, then call the translate method, storing the modified
        //strings (otherwise store the original string) line by line as they are organized in fileByLine.

        //For Milestone 3, you will need to build a new ArrayList<ArrayList<String>> that will be
        //returned. For each string in fileByLine, you will need to check the booleans at
        //Config.MOD_TRANS, Config.MOD_PIG, and Config.MOD_REV_WORD in modFlags in that order. For
        //each one that is true, apply the appropriate transformation, storing them as in
        //Milestone 2. After having processed each string, if the boolean at Config.MOD_REV_LINE
        //in modFlags is true, reverse each line in the returning ArrayList<ArrayList<String>>.
    }


    /**
     * This is the main method for the TextManipulator program. This method contains the loop that
     * runs the prompt. It handles the user response and calls the methods that are necessary in
     * order to perform the actions requested by the user.
     *
     * The initial default behavior of the program is to show the full menu, to be in the "Modified"
     * mode, to have no modifications selected, and to have no values for the various file names.
     *
     * @param args (unused)
     */
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ArrayL = new ArrayList<ArrayList<String>>();
        
        String [] files = new String [Config.NUM_FILES];
        
        
        
        boolean mode =false; 
        boolean printMenu= true;
        
        boolean [] x = new boolean [Config.NUM_MODS]; 
        
        char n; 
        
         Scanner scnr= new Scanner (System.in);
         
         String curFileName = null;
         
         String m="";
         
         
         
         do {
        	 
        	 n= promptMenu (scnr,files,x,mode,printMenu);
        	 
        	 m= "" + n;
        	 
        	 if (m.equalsIgnoreCase("i")) { 
        		 
        		 curFileName= updateFileName(scnr, curFileName);
        		 
        		 
        		 
        		 files[Config.FILE_IN]= curFileName; 
        		 
        
        		 try {
        			 
        			 if (curFileName.equals("")) {
        				 
        				 files[Config.FILE_IN]=null;
        				 
        				 curFileName="null";
        			 }
        			 
        			 else 
        			 {
        				 
        				 readInputFile(curFileName, ArrayL);
        			 }
        		 }
        			 catch (IOException e) {
        				 System.out.println("Exception: File '" +curFileName+"' not found.");
        			 }
        	 }
        		 
        				 	
        		 else if (m.equalsIgnoreCase("h")) {
        			 printMenu=(!printMenu);
        		 }
        	 
        		 else if (m.equals("1")) {
        			 
        			 try {
        				 
        				 for (int i=1; i<=80; i++) {
        					 
        					 System.out.print(Config.LINE_CHAR);
        					 
        				 }
        				 
        				 System.out.println();
        				 
        				 display (ArrayL,ArrayL,mode);
        				 
        				 for (int i=1; i<=80; i++) {
        					 
        					 System.out.print(Config.LINE_CHAR);
        					 
        				 }
        				 
        				 System.out.println();
        			 }
        			catch (Exception g) {
        				
        				System.out.print("goodgame!");
        				
        			}
        		 }
        		 else if (m.equalsIgnoreCase("q")) {
        			 
        			 break;
        		 }
        	 
        		 else {
        			 
        			 System.out.println("Unknown option.");
        		 
        		 }
         
         }
         while (!(m.equalsIgnoreCase("q"))); 
    }
}
        	  
          
         
    
         
    
        				 
        					 
        						 
        			 
        		 
        				 
        				 
        			 
        				 
        			 
        
        
        
        
        
        
        
        
       
        
        
    
    