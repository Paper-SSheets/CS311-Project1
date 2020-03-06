package edu.iastate.cs228.hw04.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.iastate.cs228.hw04.RecursionExercises;

/**
 * @author Kyle Vetsch
 */
public class RecursionExercisesTest
{
	/** Test displayRowOfCharacters. */
	@Test
	public void displayRowOfCharacters()
	{
		assertEquals("+++++", RecursionExercises.displayRowOfCharacters('+', 5));
	}
	
	/** Test displayBackwards. */
	@Test
	public void displayBackwards()
	{
		assertEquals("21", RecursionExercises.displayBackwards(new int[]
		{ 1, 2, 3, 4 }, 2));
	}
	
	/** Test isPalindrome. */
	@Test
	public void isPalindrome()
	{
		assertTrue(RecursionExercises.isPalindrome("racecar"));
		assertFalse(RecursionExercises.isPalindrome("nascar"));
		assertFalse(RecursionExercises.isPalindrome("racingcar"));
	}
	
	/** Test getSecondSmallest. */
	@Test
	public void getSecondSmallest()
	{
		Integer lsol = 2;
		
		Integer[] l;
		
		l = new Integer[]
		{ 1, 2 };
		assertEquals(lsol, RecursionExercises.getSecondSmallest(l, l.length));
		
		l = new Integer[]
		{ 1, 2, 3, 5, 8, 10, 99 };
		
		assertEquals(lsol, RecursionExercises.getSecondSmallest(l, l.length));
		
		l = new Integer[]
		{ 3, 1, 2, 3, 95, 2, 9 };
		
		assertEquals(lsol, RecursionExercises.getSecondSmallest(l, l.length));
		
		l = new Integer[]
		{ 2, 2, 3, 4 };
		assertEquals(lsol, RecursionExercises.getSecondSmallest(l, l.length));
	}
}