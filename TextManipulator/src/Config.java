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
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * This class contains the constants used in the TextManipulator program. These constants may be changed
 * when testing and so your program should use the constants but not the values.
 * 
 * @author Marc Renault
 *
 */
public class Config {

    /** 
     * The number of files and the indexes for the different file names.
     */
    public static final int NUM_FILES = 3;
    public static final int FILE_IN = 0; //Input file
    public static final int FILE_OUT = 1; //Output file
    public static final int FILE_DICT = 2; //Dictionary file

    /**
     * The number of text modifications and the indexes for the different modifications.
     */
    public static final int NUM_MODS = 4;
    public static final int MOD_TRANS = 0; //Translation
    public static final int MOD_PIG = 1; //Pig Latin
    public static final int MOD_REV_WORD = 2; //Reverse word
    public static final int MOD_REV_LINE = 3; //Reverse line

    /**
     * The character used for lines.
     */
    public static final char LINE_CHAR = '-';

}
