///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            PetriDish
// Files:            Experiment.java
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


import java.util.*;

/**
 * the class Experiment can allow the user do experiment to the organism.
 * Specifically, user can enter the strands of organism and do mutation and 
 * recombination. Also the traits can be displayed.
 */


public class Experiment {

	private static final Scanner STDIN = new Scanner(System.in);

	/**
	 * validation: determine whether the user's input of strands is valid

	 * @param entered strand
	 * @return whether the input is valid (in the base).
	 */
	private static boolean isValid(String sequence) {
		
		// whether the length of input strand is valid
		if(sequence.length() != Organism.STRAND_LENGTH) {
			System.out.println("Please enter a genetic sequence of length 5");
			return false;
		}
		String base = String.valueOf(Organism.BASES);
		
		// whether the entered letter of strand is in the base?
		boolean checkSequence = true;
		for(int i = 0; i < sequence.length(); i++) {
			if(!base.contains(String.valueOf(sequence.charAt(i)))) {
				checkSequence = false;
			}
		}
		if(!checkSequence) {
			System.out.println("Please enter a valid genetic sequence");
			return false;
		}
		
		return true;
	}
	/**
	 * validation: determine whether the user's input of strands'
	 *  number is valid get the user's input of strand and save it.
	 * @param 
	 * @return strands of input if the user's input is valid.
	 */
	private static PetriDish enterOrganisms()
	{
		System.out.print("How many organisms are there?");
		int numberOfOrganisms = STDIN.nextInt();
		// number of strands cannot be smaller or equal to zero
		if (numberOfOrganisms <= 0)
		{
			System.out.println("Please enter a number greater than 0");
		}
		else
		{
		// let user make the input of the specific strands.
	    // each organism has two strands
		Organism[] inOrganisms = new Organism[numberOfOrganisms];
		
		for(int i=0; i<numberOfOrganisms; i++) {
			System.out.println("Organism "+(i+1)+":");
			System.out.print("Enter strand 1:");
			String strand1 = STDIN.next();
			
			while(!isValid(strand1)) {
				strand1 = STDIN.next();
			}
			
			System.out.print("Enter strand 2:");
			String strand2 = STDIN.next();
			
			while(!isValid(strand2)) {
				strand2 = STDIN.next();
			}
			
			inOrganisms[i] = new Organism(strand1, strand2);
		}
		// return the strands in the Organism
		return new PetriDish(inOrganisms);
		}
		// does not return anything if the input is invalid
		return null; 
	}
	/**read the integer command
	 * 
	 * @param 
	 * @return the integer that user enters.
	 */
	private static int getMenuChoice()
	{
		return STDIN.nextInt();
	}

	/**
	 * main method - let the user create and manipulate organisms
	 * @param args command line input - UNUSED
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Martian Organism Simulator");
		
		PetriDish petriDish = null;
		
		while(true) {
			System.out.println("Choose one:");
			System.out.println("1 - Enter Organisms");
			System.out.println("2 - Display");
			System.out.println("3 - Mutate");
			System.out.println("4 - Recombine");
			System.out.println("5 - Quit");
			
			// get user's input integer
			int menuChoice = getMenuChoice();
			
			boolean quite = false;
			
			switch (menuChoice) {
			// input =1 : let user enters organisms.
				case 1:
					petriDish = enterOrganisms();
					break;
			// input =2
				case 2:
			// if there is no organism in the petridish
					if(petriDish==null) {
						System.out.println("No Organisms entered.");
						break;
					}
			        // if there is organism in the petridish, 
					//display the organism.
					petriDish.displayOrganisms();
					break;
			// input =3
				case 3:
					// if there is no organism in the petridish		
					if(petriDish==null) {
						System.out.println("No Organisms entered.");
						break;
					}
					// if there is organism in the petridish, 
					// mutate the organism.
					petriDish.mutateOrganisms();
					System.out.println("Organisms mutated.");
					break;
				//input =4
				case 4:
					// if there is no organism in the petridish		
					if(petriDish==null) {
						System.out.println("No Organisms entered.");
						break;
					}
					// if there is organism in the petridish, 
					// recombine the organism.
					petriDish.recombineOrganisms();
					System.out.println("Organisms recombined.");
					break;
				//input =5	break (quit)
				case 5:
					quite = true;
					break;
				// other input: invalid
				default:
				System.out.println("'"+menuChoice+"' is not a valid choice.");
				System.out.println("Please try again.");
				break;
			}
			if(quite) {
				break;
			}
		}
		// when quit
		System.out.println("Thanks for visiting!");
	}
}
