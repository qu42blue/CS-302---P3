///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            PetriDish
// Files:            PetriDish.java
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



/*
 * PetriDish
 *
 * Class that implements experiments on a set of Organisms
 */
public class PetriDish {

	/* Array of the organisms alive in the petri dish */
	private Organism[] alive;

	/**
	 * Constructor
	 * Create a new PetriDish containing the input Organisms
	 *
	 * @param inOrganisms Array of Organisms to put in the PetriDish
	 */
	public PetriDish(Organism[] inOrganisms)
	{
		alive = inOrganisms;
	}

	/**
	 * Display the current contents of the PetriDish
	 */
	public void displayOrganisms()
	{
		System.out.println("Organisms:");
		for(int i = 0; i < alive.length; i++) 
		{ 
			System.out.println((i+1)+": "+alive[i].toString());
		}
		System.out.println();
	}

	/**
	 * Mutate all the organisms in the PetriDish.
	 */
	public void mutateOrganisms()
	{
		for(int i = 0; i < alive.length; i++) 
		{ 
			alive[i].mutate();
		}
	}

	/**
	 * Finds the fittest member in an array of Organisms
	 * @param input array of Organisms
	 * @return the fittest member of the array
	 */
	
	private static Organism findFittest(Organism[] input)
	{
		Organism tempOrganism = input[0];
		
		for(int i = 1; i < input.length; i++) 
		{
			if(tempOrganism.getFitness() < input[i].getFitness()) 
			{
				tempOrganism = input[i];
			}
		}
		return tempOrganism;
	}
	
	
	
	/**
	 * combine all the organisms, retaining the fittest
	 * offspring of each primary parent
	 *
	 * COMPLETE - DO NOT ALTER
	 */
	public void recombineOrganisms()
	{
		if (alive != null) {
			/* Array to hold the fittest offspring as they are computed */
			Organism[] newalive = new Organism[alive.length];
			/* Array to hold the offspring of a particular primary parent */
			Organism[] offspring = new Organism[alive.length];
			for(int i = 0; i < newalive.length; ++i)
			{
				/* combine each organism as primary parent with each
				 * other organism (including itself) as secondary parent*/
				for(int j = 0; j < offspring.length; ++j)
				{
					offspring[j] = alive[i].recombine(alive[j]);
				}
				// Put the fittest offspring into the new array
				newalive[i] = PetriDish.findFittest(offspring);
			}
			/* When all recombinations are complete, replace
			 * the alive array with the new array of fittest offspring */
			alive = newalive;
   		}
	}
}
