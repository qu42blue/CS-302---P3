///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            PetriDish
// Files:            Organism.java
// Semester:         CS302 Spring 2015
//
// Author:          QuHarrison Terry 
// Email:            qterry@wisc.edu
// CS Login:         quharrison
// Lecturer's Name:  Deb Deppler
// Lab Section:      321
// 
// Pair Partner:    Xiaobo Wang
// Email:			xwang532@wisc.edu
// CS Login:        xiaobo
// Lecturer's Name: Deb Deppler
// Lab Section:     325
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Random;
/**
 * the class organism contains multiple functions of evaluating the 
 * organism. It can return a string that contains the strands in organism,
* the dominant strands, mobility score,  resistant condition,
* photosynthetic condition, cell wall condition and the fitness score
 */



public class Organism {

	// CLASS CONSTANTS
	public static final Random RAND = new Random(Config.SEED);
	public static final int NUM_STRANDS = 2;
	public final static int STRAND_LENGTH = 5;
	public final int CELL_WALL_VALUE = 5;
	public final int PHOTOSYNTHESIS_VALUE = 5;
	public final int RESISTANCE_VALUE = 5;
	public final int MOTILITY_VALUE = 2;
	public final static  char[] BASES = {'A', 'C', 'G', 'T'};

	// INSTANCE FIELDS
	private String[] strands = new String[NUM_STRANDS];

	// CONSTRUCTOR
	public Organism(String strand1, String strand2) {
		
		strands[0] = strand1;
		strands[1] = strand2;
	}

	// METHODS
	/**
	 *get the dominant strand the two strands in an organism

	 * @param 
	 * @return dominant strand         
	 */
	public String getDominant() {
		char[] dominant = new char[STRAND_LENGTH];
		
		for(int i = 0; i < STRAND_LENGTH; i++) {
			// compare the letter at the same position in each strand. 
			if(strands[0].charAt(i) >= strands[1].charAt(i)) 
			{
				dominant[i] = strands[0].charAt(i);
			} 
			else 
			{
				dominant[i] = strands[1].charAt(i);
			}
		}
		// return a string that has the dominant strand
		return String.valueOf(dominant); 
	}
	/**
	 * determine whether the organism is resistant.

	 * @param 
	 * @return whether the organism is resistant
	 */
	public boolean isResistant() {
		//Returns true if the dominant genetic code of the 
		//Organism contains a 'C' followed by a 'G', false otherwise.
		
		String dominantGeneticCode = getDominant();
		if(dominantGeneticCode.contains("CG")) 
		{
			return true;
		}
		return false;
	}
	
	/**
	 * get the motility condition by finding the numbers of T in
	 * the dominant strand.

	 * @param 
	 * @return Motility value       
	 */
	public int getMotility() {
		int countT = 0;
		String dominantGeneticCode = getDominant();
		for(int i = 0; i < dominantGeneticCode.length(); i++)
		{
			if(dominantGeneticCode.charAt(i) == 'T') 
			{
				countT++;
			}
		}
		// return the number of "T"s in the dominant strand
		return countT;
	}
	/**
	 * determine whether the organism is photosynthetic.

	 * @param 
	 * @return  whether the organism is photosynthetic        
	 */
	public boolean isPhotosynthetic() {
		//determine whether the first strand comes 
		//alphabetically (lexicographically) before the second strand.
		if(strands[0].compareTo(strands[1]) < 0) 
		{
			return true;
		}
		return false;
	}
	/**
	 * determine whether the organism has cell wall.

	 * @param 
	 * @return whether the organism has cell wall       
	 */
	public boolean hasCellWall() {
		// get the dominant strand.
		String dominantGeneticCode = getDominant();
		// set the return boolean value to false.
		boolean hasCellWall = false;
		
		//set hasCellWall to true if the dominant genetic code of the Organism 
		//contains any two letters repeated consecutively
		for(int i = 0; i < dominantGeneticCode.length(); i++) 
		{
			if(i == dominantGeneticCode.length()-1) 
			{
				continue;
			}
			if(dominantGeneticCode.charAt(i) == 
					dominantGeneticCode.charAt(i+1)) 
			{
				hasCellWall = true;
			}
		}
		
		return hasCellWall;
	}

	/**
	 * return a String that contains the strands in organism,
	 * the dominant strands, mobility score,  resistant condition,
	 * photosynthetic condition, cell wall condition and the fitness
	 * score
	 * 
	 * @param 
	 * @return a string containing the imformation about the organism         
	 */
	public String toString() {
    return  strands[0]+" "+strands[1]+" "+getDominant()+" "
	        +getMotility()+" "+(isResistant()?"R ":"NR")+" "
		    +(isPhotosynthetic()?"P ":"NP")+" "
			+(hasCellWall()?"W ":"NW")+" "+getFitness();
	}
	/**
	 *mutate the organism.

	 * @param 
	 *          
	 */
	public void mutate() {
		// Using RAND.nextInt to get the random index.
		int strandSiteIndex = RAND.nextInt(STRAND_LENGTH);
		// randomly select a valid base for each strand.
	char replacementForSiteStrand1 = BASES[RAND.nextInt(BASES.length)];
	char replacementForSiteStrand2 = BASES[RAND.nextInt(BASES.length)];
		
	// replace the letter in the original strand according to the random
	// index and random bases.
	String newStrand1 = strands[0].substring(0, strandSiteIndex)
		+replacementForSiteStrand1+strands[0].substring(strandSiteIndex+1);
		
	String newStrand2 = strands[1].substring(0, strandSiteIndex)
		+replacementForSiteStrand2+strands[1].substring(strandSiteIndex+1);
		
		strands[0] = newStrand1;
		strands[1] = newStrand2;
		
	}

	/** recombine the Organisms.
	 * "this" Organism is the primary parent and
	 * "other" is the secondary parent.
	 *
	 * @param other The secondary parent
	 * @return recombined organism
	 */
	public Organism recombine(Organism other) {
		//the primary parent Organism determines the first strand of genetic material 
		//in the offspring, and the secondary parent determines the second strand. 
		// Using RAND.nextInt to generate the random number of strand
		
		int indexOfFirstStrand = RAND.nextInt(NUM_STRANDS);
		String firstStrand = this.strands[indexOfFirstStrand];
		
		int indexOfSecondStrand = RAND.nextInt(NUM_STRANDS);
		String secondStrand = other.strands[indexOfSecondStrand];
		
		return new Organism(firstStrand, secondStrand);
	}
	
	/**
	 * get the fitness score of the organism

	 * @param 
	 * @return fitness score          
	 */
	public int getFitness()
	{
		// add motility score.
		int fitnessScore = MOTILITY_VALUE * getMotility();
		// add "resistant" score.
		if(isResistant()) 
		{
			fitnessScore += RESISTANCE_VALUE;
		}
		// add "photosynthetic" score.
		if(isPhotosynthetic()) 
		{
			fitnessScore += PHOTOSYNTHESIS_VALUE;
		}
		// add "CellWall" score.
		if(hasCellWall()) 
		{
			fitnessScore += CELL_WALL_VALUE;
		}
		// return the final score.
		return fitnessScore;
	}
}
