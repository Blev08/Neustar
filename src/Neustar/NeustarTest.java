/**
 * 
 */
package Neustar;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Randall Blevins
 *
 */
public class NeustarTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	public Neustar test = new Neustar();
	public int[] cnt = new int[5];
	List<String> list = new ArrayList<String>();
	
	@Before
	public void setUp(){
		list.add("FOOD gibberish");
		list.add("SHELTER gibberish");
		list.add("PLACE Washington");
		list.add("STUFF gibberish");
		list.add("ANIMAL duck");
		list.add("ANIMAL dog");
		list.add("PERSON Bill");
		list.add("COMPUTER windows");
		list.add("OTHER pizza");
	}
	
	@Test
	public void readFileTest() {
		List<String> hold = new ArrayList<String>();
		try {
			hold = Neustar.readFile("c:\\input\\input.txt");
		} catch (IOException e) {
			System.out.print("Error: " + e);
		}
		assertEquals(hold.size(), 10);
	}
	
	@Test
	public void readNonExistantFileTest() {
		
		try {
			list = Neustar.readFile("input.txt");
			exception.expect(FileNotFoundException.class);
		} catch (IOException e) {
			System.out.print("Error: " + e);
		}
	}
	
	@Test
	public void removeInvalidsTest() {
		list = Neustar.removeInvalids(list);
		assertEquals(list.size(), 6);
	}
	
	/**
	 * Note:
	 * hold[0] = PERSON
	 * hold[0] = PLACE
	 * hold[0] = ANIMAL
	 * hold[0] = COMPUTER
	 * hold[4] = OTHER
	 */
	@Test
	public void tallyTypesTest() {
		int[] hold = Neustar.tallyTypes(list);
		assertEquals(hold[0], 1);
		assertEquals(hold[1], 1);
		assertEquals(hold[2], 2);
		assertEquals(hold[3], 1);
		assertEquals(hold[4], 1);
	}
}
