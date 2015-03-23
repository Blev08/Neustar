/**
 * 
 */
package Neustar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author Randall Blevins
 *
 */
public class Neustar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Command Line File Input
		String filename = "";
		List<String> input = new ArrayList<String>();
		if(args.length > 0){
			filename = args[0];
		}
		
		//File Input Read
		try {
			input = readFile(filename);
		} catch (IOException e) {
			System.out.println("Error:" + e);
			System.exit(0);
		}
		
		//Removing Duplicates
		List<String> uniques = new ArrayList<String>(new LinkedHashSet<String>(input));
		
		//Processing
		uniques = removeInvalids(uniques);
		int[] tallies = tallyTypes(uniques);
		output(uniques, tallies);
	}


	/**
	 * Method: output
	 * @param uniques - ordered list of non-duplicate and valid values 
	 * @param tallies - int array containing the count of the main categories contained in the list 
	 */
	private static void output(List<String> uniques, int[] tallies) {
		System.out.println("CATEGORY COUNT");
		System.out.println("PERSON " + tallies[0]);
		System.out.println("PLACE " + tallies[1]);
		System.out.println("ANIMAL " + tallies[2]);
		System.out.println("COMPUTER " + tallies[3]);
		System.out.println("OTHER " + tallies[4]);
		
		for(int i=0; i<uniques.size(); ++i){
			System.out.println(uniques.get(i));
		}
	}
	
	
	/**
	 * Method: tallyTypes
	 * @param uniques - ordered list of non-duplicate and valid values
	 * @return int array containing the count of the main categories contained in the list  
	 */
	protected static int[] tallyTypes(List<String> uniques) {
		int[] tallies = new int[5];
		for(int i = 0; i < uniques.size(); ++i){
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("PERSON")) {
				tallies[0]++;
			}
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("PLACE")) {
				tallies[1]++;
			}
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("ANIMAL")) {
				tallies[2]++;
			}
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("COMPUTER")) {
				tallies[3]++;
			}
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("OTHER")) {
				tallies[4]++;
			}
		}
		return tallies;
	}

	/**
	 * Method: removeInvalids
	 * @param uniques - ordered list containing no duplicate String values 
	 * @return cleanArr - returns a list of Strings that contains only values of PERSON, PLACE, ANIMAL, COMPUTER, or OTHER 
	 */
	protected static List<String> removeInvalids(List<String> uniques) {
		List<String> cleanArr = new ArrayList<String>();
		for(int i = 0; i < uniques.size(); ++i){
			if(uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("PERSON") || 
					uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("PLACE")  || 
					uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("ANIMAL") ||
					uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("COMPUTER") || 
					uniques.get(i).substring(0, uniques.get(i).indexOf(" ")).equals("OTHER")){
				cleanArr.add(uniques.get(i));
			}
		}
		return cleanArr;
	}

	/**
	 * Method: readFile
	 * @param file - source of input file name
	 * @return List of Strings in which each string contains one line of the input file 
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	protected static List<String> readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String line = null;
	    List<String> list = new ArrayList<String>();
	    	    
	    while( ( line = reader.readLine() ) != null ) {
	    	line = line.trim();
	    	if(line.length()!=0){
	    		list.add(line);
	    	}
	    }
	    return list;
	}
}
