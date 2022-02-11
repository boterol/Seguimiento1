package model;

import static org.junit.Assert.*;

import org.junit.Test;
import exception.NegativeNumberException;

public class IngredientTest {
	private Ingredient ingredient;

	public void setupStage1()
	{
		ingredient=new Ingredient("Tomate", 245);
	}
	
	@Test
	public void test1()
	{
		setupStage1();
		double w=54;
		boolean exceptionTrue=false;
		try
		{
			ingredient.addWeight(w);
		}
		catch(NegativeNumberException e)
		{
			exceptionTrue=true;
		}
		assertEquals(ingredient.getWeight(), (double) (245+54), 0.001);
		assertFalse(exceptionTrue);
	}
	
	@Test
	public void test2() 
	{
		setupStage1();
		double w=-100;
		boolean exceptionTrue=false;
		try
		{
			ingredient.addWeight(w);
		}
		catch(NegativeNumberException e)
		{
			exceptionTrue=true;
		}
		assertEquals(ingredient.getWeight(), (double)245, 0.001);
		assertTrue(exceptionTrue);
	}
	
	@Test
	public void test3()
	{
		setupStage1();
		double wout=45;
		boolean exceptionTrue=false;
		try
		{
			ingredient.removeWeight(wout);
		}
		catch (NegativeNumberException e)
		{
			exceptionTrue=true;
		}
		assertEquals(ingredient.getWeight(), 200, 0.001);
		assertFalse(exceptionTrue);
	}
	
	@Test
	public void test4()
	{
		setupStage1();
		double wout=-100;
		boolean exceptionTrue=false;
		try
		{
			ingredient.removeWeight(wout);
		}
		catch (NegativeNumberException e)
		{
			exceptionTrue=true;
		}
		assertEquals(ingredient.getWeight(), 245, 0.001);
		assertTrue(exceptionTrue);
	}
	
}
