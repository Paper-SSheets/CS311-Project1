package edu.iastate.cs228.hw04.tests;

import edu.iastate.cs228.hw04.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import org.junit.Rule;

/**
 * 
 * @author Jamie Sampson
 *
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JamieHW04AllTests
{
	@Rule
	public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void CLQ_test_is_empty()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CLQ_test_is_empty_false()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		assertFalse(q.isEmpty());
	}
	
	@Test
	public void CLQ_test_enqueue_one()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CLQ_test_enqueue_two()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		assertEquals(q.getFront(), "A");
		q.enqueue("B");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CLQ_test_enqueue_multi()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		assertEquals(q.getFront(), "A");
		q.enqueue("B");
		assertEquals(q.getFront(), "A");
		q.enqueue("C");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CLQ_test_clear()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.clear();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CLQ_test_get_front_exc()
	{
		ex.expect(EmptyQueueException.class);
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.getFront();
	}
	
	@Test
	public void CLQ_test_dequeue_one()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CLQ_test_dequeue_exc()
	{
		ex.expect(EmptyQueueException.class);
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.dequeue();
	}
	
	@Test
	public void CLQ_test_dequeue_multi()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(q.getFront(), "A");
		q.dequeue();
		assertEquals(q.getFront(), "B");
		q.dequeue();
		assertEquals(q.getFront(), "C");
		q.dequeue();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CLQ_test_clear_no_exception()
	{
		CircularLinkedQueue q = new CircularLinkedQueue<String>();
		q.clear();
	}
	////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void CDLD_test_get_front_exc()
	{
		ex.expect(EmptyQueueException.class);
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.getFront();
	}
	
	@Test
	public void CDLD_test_get_back_exc()
	{
		ex.expect(EmptyQueueException.class);
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.getBack();
	}
	
	@Test
	public void CDLD_test_add_to_front_one()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		assertEquals(q.getBack(), "A");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CDLD_test_is_empty_true()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_is_empty_false()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		assertFalse(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_add_to_front_two()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		assertEquals(q.getFront(), "A");
		q.addToFront("B");
		assertEquals(q.getFront(), "B");
		assertEquals(q.getBack(), "A");
	}
	
	@Test
	public void CDLD_test_add_to_front_multi()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		assertEquals(q.getFront(), "A");
		q.addToFront("B");
		assertEquals(q.getFront(), "B");
		q.addToFront("C");
		assertEquals(q.getFront(), "C");
		assertEquals(q.getBack(), "A");
	}
	
	@Test
	public void CDLD_test_clear()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		q.addToFront("B");
		q.addToFront("C");
		q.addToFront("D");
		q.clear();
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_add_to_back_one()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		assertEquals(q.getBack(), "A");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CDLD_test_add_to_back_two()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		assertEquals(q.getBack(), "A");
		q.addToBack("B");
		assertEquals(q.getBack(), "B");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CDLD_test_add_to_back_multi()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		assertEquals(q.getBack(), "A");
		q.addToBack("B");
		assertEquals(q.getBack(), "B");
		q.addToBack("C");
		assertEquals(q.getBack(), "C");
		assertEquals(q.getFront(), "A");
	}
	
	@Test
	public void CDLD_test_remove_back_one()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		assertEquals(q.removeBack(), "A");
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_remove_front_one()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		assertEquals(q.removeFront(), "A");
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_remove_front_two()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		q.addToFront("B");
		assertEquals(q.removeFront(), "B");
		assertEquals(q.getFront(), "A");
		assertEquals(q.removeFront(), "A");
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_remove_back_two()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		q.addToBack("B");
		assertEquals(q.removeBack(), "B");
		assertEquals(q.getBack(), "A");
		assertEquals(q.removeBack(), "A");
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_remove_back_multi()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToBack("A");
		q.addToBack("B");
		q.addToBack("C");
		assertEquals(q.removeBack(), "C");
		assertEquals(q.getBack(), "B");
		assertEquals(q.removeBack(), "B");
		assertEquals(q.getBack(), "A");
		assertEquals(q.removeBack(), "A");
		assertTrue(q.isEmpty());
	}
	
	@Test
	public void CDLD_test_remove_front_mulit()
	{
		CircularDoublyLinkedDeque q = new CircularDoublyLinkedDeque<String>();
		q.addToFront("A");
		q.addToFront("B");
		q.addToFront("C");
		assertEquals(q.removeFront(), "C");
		assertEquals(q.getFront(), "B");
		assertEquals(q.removeFront(), "B");
		assertEquals(q.getFront(), "A");
		assertEquals(q.removeFront(), "A");
		assertTrue(q.isEmpty());
	}
	
///////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void recursion_test_display_row_of_characters()
	{
		assertEquals("BBBB", RecursionExercises.displayRowOfCharacters('B', 4));
		assertEquals("!!", RecursionExercises.displayRowOfCharacters('!', 2));
		assertEquals("   ", RecursionExercises.displayRowOfCharacters(' ', 3));
	}
	
	@Test
	public void recursion_test_display_backwards()
	{
		assertEquals("32", RecursionExercises.displayBackwards(new int[]
		{ 2, 3, 4 }, 2));
		assertEquals("1", RecursionExercises.displayBackwards(new int[]
		{ 1 }, 1));
		assertEquals("42911", RecursionExercises.displayBackwards(new int[]
		{ 1, 1, 9, 2, 4, 9 }, 5));
	}
	
	@Test
	public void recursion_test_is_palindrome()
	{
		assertFalse(RecursionExercises.isPalindrome("Racecar"));
		assertTrue(RecursionExercises.isPalindrome("racecar"));
		assertTrue(RecursionExercises.isPalindrome("1123211"));
		assertFalse(RecursionExercises.isPalindrome("1023211"));
		assertTrue(RecursionExercises.isPalindrome("HdssdH"));
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void recursion_test_get_second_smallest()
	{
		assertEquals(new Integer(2), RecursionExercises.getSecondSmallest(new Integer[]
		{ 1, 2, 3 }, 3));
		assertEquals(new Integer(-2), RecursionExercises.getSecondSmallest(new Integer[]
		{ -5, 2, 3, -2, 5 }, 5));
		assertEquals(new Integer(2), RecursionExercises.getSecondSmallest(new Integer[]
		{ 2, 2, 6, 3 }, 4));
		assertEquals(new Integer(-2), RecursionExercises.getSecondSmallest(new Integer[]
		{ 1, 2, 3, -2, -7 }, 5));
		assertEquals(new Integer(1), RecursionExercises.getSecondSmallest(new Integer[]
		{ 1, -3213, 3, 3394 }, 4));
	}
}