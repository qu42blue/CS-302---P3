///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            PetriDish
// Files:            OrganismTester.java
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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * OrganismTester - test the Organism class
 *
 *
 */public class OrganismTester
{
	/**
	 * run tests on the Organism class
	 * @param args
	 */
	public static void main( String[] args)
	{
		StringBuilder outputBilder = new StringBuilder();
		// Create strings for first organism, "AAACG" and "TGAAA"
		String strand1 = "AAACG";
		String strand2 = "TGAAA";
		// Create strings for second organism, "TTTAA" and "TTTAA"
		String strand3 = "TTTAA";
		String strand4 = "TTTAA";
		System.out.println("***** Testing Constructor *****");
		outputBilder.append("***** Testing Constructor *****"+"\n");
		// Test constructor:
		// TODO: create two instances of Organism using strings
		Organism organism1 = new Organism(strand1, strand2);
		Organism organism2 = new Organism(strand3, strand4);
		
		// TODO: save the results of calling toString on each organism
		String output = organism1.toString();

		// compare the results of toString to expected results
		if (output.startsWith("AAACG TGAAA"))
		{
			// TODO: save the results of calling toString on each organism
			output = organism2.toString();
			if (output.startsWith("TTTAA TTTAA"))
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			}
			else{ 
				System.out.println("Failed for Organism 2: "
						+ "expected 'TTTAA TTTAA', " +				"returned '"+output.substring(0,11)+"'");
				
			outputBilder.append("Failed for Organism 2: "
					+ "expected 'TTTAA TTTAA', " +
					"returned '"+output.substring(0,11)+"'"+"\n");
			}
		}
		else {
			System.out.println("Failed for Organism 1: "
					+ "expected 'AAACG TTTTT', " +
			"returned '"+output.substring(0,11)+"'");
			
			outputBilder.append("Failed for Organism 1:"
					+ " expected 'AAACG TTTTT', " +
				"returned '"+output.substring(0,11)+"'"+"\n");
		}

		System.out.println("***** Testing getDominant() *****");
		outputBilder.append("***** Testing getDominant() *****"+"\n");

		// TODO: save the results of calling getDominant on each organism
		output = organism1.getDominant();
		if (output.equals("TGACG"))
		{
			output = organism2.getDominant();
			if (output.equals("TTTAA"))
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			} else {
				System.out.println("Failed for Organism 2: "
						+ "expected 'TTTAA', " +
				"returned '"+output+"'");
			
				outputBilder.append("Failed for Organism 2: "
						+ "expected 'TTTAA', " +
						"returned '"+output+"'"+"\n");
			}
		} 
		else {System.out.println("Failed for Organism 1: expected 'TGACG', " +
			"returned '"+output+"'");
		outputBilder.append("Failed for Organism 1: expected 'TGACG', " +
				"returned '"+output+"'"+"\n");
		}

		System.out.println("***** Testing isResistant *****");
		outputBilder.append("***** Testing isResistant *****"+"\n");
// TODO: replace false with the results of calling isResistant on organism 1
		boolean results = organism1.isResistant();
		if ( results )
		{
// TODO: replace false with the results of calling isResistant on organism 2
			results = organism2.isResistant();
			if ( ! results )
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			} 
			else { System.out.println("Failed for Organism 2: "
					+ "expected 'false', " +
				"returned '" + results + "'");
			
			outputBilder.append("Failed for Organism 2: expected 'false', " +
					"returned '" + results + "'"+"\n");
			}
		} 
		else 
		{ 
			System.out.println("Failed for Organism 1:"
					+ " expected 'true', " +
			"returned '" + results + "'");
		
			outputBilder.append("Failed for Organism 1: "
					+ "expected 'true', " +
					"returned '" + results + "'"+"\n");
		}

		System.out.println("***** Testing getMotility *****");
		outputBilder.append("***** Testing getMotility *****"+"\n");
// TODO: replace -1 with the results of calling getMotility on organism 1
		int motility = organism1.getMotility();
		if (motility == 1)
		{
// TODO: replace -1 with the results of calling getMotility on organism 2
			motility = organism2.getMotility();
			if (motility == 3)
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			} 
			else {System.out.println("Failed for Organism 2: expected '3', " +
				"returned '"+ motility +"'");
			outputBilder.append("Failed for Organism 2: expected '3', " +
					"returned '"+ motility +"'"+"\n");
			}
		} 
		else {System.out.println("Failed for Organism 1: expected '1', " +
			"returned '" + motility +"'");
		outputBilder.append("Failed for Organism 1: expected '1', " +
				"returned '" + motility +"'"+"\n");
		}

		System.out.println("***** Testing isPhotoSynthetic *****");
		outputBilder.append("***** Testing isPhotoSynthetic *****"+"\n");
// replace false with the results of calling isPhotosynthetic on organism 1
		results = organism1.isPhotosynthetic();
		if ( results )
		{
//replace false with the results of calling isPhotosynthetic on organism 2
			results = organism2.isPhotosynthetic();
			if ( ! results )
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			} 
			else {System.out.println("Failed for Organism 2: "
					+ "expected 'false', " +
				"returned '" +  results + "'");
			
			outputBilder.append("Failed for Organism 2: expected 'false', " +
					"returned '" +  results + "'"+"\n");
			}
		} 
		else { System.out.println("Failed for Organism 1: expected 'true', " +
			"returned '"+ results +"'");
			outputBilder.append("Failed for Organism 1: expected 'true', " +
				"returned '"+ results +"'"+"\n");
		}
		System.out.println("***** Testing hasCellWall *****");
		outputBilder.append("***** Testing hasCellWall *****"+"\n");
// TODO: replace false with the results of calling hasCellWall on organism 1
		results = organism1.hasCellWall();
		if ( ! results )
		{
// TODO: replace false with the results of calling hasCellWall on organism 2
			results = organism2.hasCellWall();
			if ( results )
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			} else {System.out.println("Failed for Organism 2: "
					+ "expected 'true', " +
				"returned '"+ results +"'");
			outputBilder.append("Failed for Organism 2: expected 'true', " +
					"returned '"+ results +"'"+"\n");
			}
		} 
		else {System.out.println("Failed for Organism 1: expected 'false', " +
			"returned '" +  results +"'");
			outputBilder.append("Failed for Organism 1: expected 'false', " +
				"returned '" +  results +"'");		
		}

		System.out.println("***** Testing getFitness *****");
		outputBilder.append("***** Testing getFitness *****"+"\n");
// TODO: replace -1 with the results of calling getFitness on organism 1
		int fitness = organism1.getFitness();
		if ( fitness  == 12 )
		{
// TODO: replace -1 with the results of calling getFitness on organism 2
			fitness = organism2.getFitness();
			if ( fitness  == 11 )
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			}
          else 
          {System.out.println("Failed for Organism 2: expected '11', " +
				"returned '" + fitness +"'");
			outputBilder.append("Failed for Organism 2: expected '11', " +
					"returned '" + fitness +"'"+"\n");
			}
		} 
		else {
			System.out.println("Failed for Organism 1: expected '12', " +
			"returned '"+ fitness +"'");
		outputBilder.append("Failed for Organism 1: expected '12', " +
				"returned '"+ fitness +"'"+"\n");
		}

		System.out.println("***** Testing toString() *****");
		outputBilder.append("***** Testing toString() *****"+"\n");
		// TODO: save the results of calling toString on each organism 1
		output = organism1.toString();
		if ( output.equals( "AAACG TGAAA TGACG 1 R  P  NW 12" ) )
		{
			// TODO: save the results of calling toString on each organism 2
			output = organism2.toString();
			if ( output.equals( "TTTAA TTTAA TTTAA 3 NR NP W  11" ) )
			{
				System.out.println("Passed.");
				outputBilder.append("Passed."+"\n");
			}
			else 
			{ System.out.println("Failed for Organism 2: expected " +			"'TTTAA TTTAA TTTAA 3 NR NP W  11', returned '"+output+"'");
			outputBilder.append("Failed for Organism 2: expected " +
					"'TTTAA TTTAA TTTAA 3 NR NP W  11', "
					+ "returned '"+output+"'"+"\n");
			}
		} 
		else  
		{
			System.out.println("Failed for Organism 1: expected " +			"'AAACG TGAAA TGACG 1 R  P  NW 12', returned '"+output+"'");
		outputBilder.append("Failed for Organism 1: expected " +
		"'AAACG TGAAA TGACG 1 R  P  NW 12', returned '"+output+"'"+"\n");
		}

		System.out.println("***** Testing recombine() *****");
		outputBilder.append("***** Testing recombine() *****"+"\n");
		
		// TODO: replace with call to recombine organism 1 with organism 2
		
		Organism offspring = organism1.recombine(organism2);
		System.out.println("Result of recombination: '" + offspring + "'");
		outputBilder.append("Result of recombination: '" +
		offspring + "'"+"\n");
		
		System.out.println("***** Testing mutate() *****");
		outputBilder.append("***** Testing mutate() *****"+"\n");
		
		// TODO: replace "ORG1" with reference to organism 1 (in all places)
		// TODO: replace "ORG2" with reference to organism 2 (in all places)
		
		System.out.println("Original Organism 1: '" + organism1 + "'");
		System.out.println("Original Organism 2: '" + organism2 + "'");
		outputBilder.append("Original Organism 1: '" + organism1 + "'"+"\n");
		outputBilder.append("Original Organism 2: '" + organism2 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG1
		
		organism1.mutate();
		System.out.println("Mutated  Organism 1: '" + organism1 + "'");
		outputBilder.append("Mutated  Organism 1: '" + organism1 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG2
		
		organism2.mutate();
		System.out.println("Mutated  Organism 2: '" + organism2 + "'");
		outputBilder.append("Mutated  Organism 2: '" + organism2 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG1
		
		organism1.mutate();
		System.out.println("Mutated  Organism 1: '" + organism1 + "'");
		outputBilder.append("Mutated  Organism 1: '" + organism1 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG2
		
		organism2.mutate();
		System.out.println("Mutated  Organism 2: '" + organism2 + "'");
		outputBilder.append("Mutated  Organism 2: '" + organism2 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG1
		
		organism1.mutate();
		System.out.println("Mutated  Organism 1: '" + organism1 + "'");
		outputBilder.append("Mutated  Organism 1: '" + organism1 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG2
		
		organism2.mutate();
		System.out.println("Mutated  Organism 2: '" + organism2 + "'");
		outputBilder.append("Mutated  Organism 2: '" + organism2 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG1
		
		organism1.mutate();
		System.out.println("Mutated  Organism 1: '" + organism1 + "'");
		outputBilder.append("Mutated  Organism 1: '" + organism1 + "'"+"\n");
		
		// TODO: replace this line with call to mutate ORG2
		
		organism2.mutate();
		System.out.println("Mutated  Organism 2: '" + organism2 + "'");
		outputBilder.append("Mutated  Organism 2: '" + organism2 + "'"+"\n");
		
		PrintWriter writer;
		
		try 
		{
			writer = new PrintWriter("expected_out.txt", "UTF-8");
			writer.print(outputBilder.toString());
			writer.close();
		} 
		catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}