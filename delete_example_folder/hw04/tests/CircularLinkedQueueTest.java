package edu.iastate.cs228.hw04.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw04.CircularLinkedQueue;
import edu.iastate.cs228.hw04.EmptyQueueException;

/**
 * @author Kyle Vetsch
 */
public class CircularLinkedQueueTest
{
	/** Queue. */
	private CircularLinkedQueue<Integer> q;
	
	/** Set up test fixture. */
	@Before
	public void setUp()
	{
		this.q = new CircularLinkedQueue<>();
	}
	
	/** Tear down test fixture. */
	@After
	public void tearDown()
	{
		this.q = null;
	}
	
	/** Test enqueue. */
	@Test
	public void enqueue()
	{
		this.q.enqueue(5);
		this.q.enqueue(7);
		this.q.enqueue(8);
		
		assertEquals(Integer.valueOf(5), this.q.getFront());
	}
	
	/** Test dequeue. */
	@Test
	public void dequeue()
	{
		this.q.enqueue(5);
		this.q.enqueue(7);
		this.q.enqueue(8);
		
		assertEquals(Integer.valueOf(5), this.q.dequeue());
		assertEquals(Integer.valueOf(7), this.q.dequeue());
		assertEquals(Integer.valueOf(8), this.q.dequeue());
	}
	
	/** Test getFront. */
	@Test
	public void getFront()
	{
		this.q.enqueue(5);
		
		assertEquals(Integer.valueOf(5), this.q.getFront());
		
		this.q.enqueue(7);
		this.q.enqueue(8);
		
		assertEquals(Integer.valueOf(5), this.q.getFront());
		
		this.q.dequeue();
		
		assertEquals(Integer.valueOf(7), this.q.getFront());
	}
	
	/** Test getFrontEmpty. */
	@Test(expected = EmptyQueueException.class)
	public void getFrontEmpty()
	{
		this.q.getFront();
	}
	
	/** Test isEmpty. */
	@Test
	public void isEmpty()
	{
		assertTrue(this.q.isEmpty());
		this.q.enqueue(1);
		assertFalse(this.q.isEmpty());
	}
	
	/** Test clear. */
	@Test
	public void clear()
	{
		this.q.enqueue(1);
		this.q.enqueue(2);
		this.q.enqueue(3);
		this.q.clear();
		assertTrue(this.q.isEmpty());
	}
}