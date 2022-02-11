package model;

import exception.NegativeNumberException;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecipeTest {
	
	private Recipe recipe;
	
	public void setupStage1()
	{
		recipe=new Recipe();
	}
	
	public void setupStage2() throws NegativeNumberException
	{
		setupStage1();
		recipe.addIngredient("Cebolla", 315);
		recipe.addIngredient("Ajo", 58);
		recipe.addIngredient("Arroz", 520);
	}
	
	@Test
	public void test1() throws Exception
	{
		setupStage1();
		String n="sal";
		double w=12;
		boolean exceptionTrue=false;
		try
		{
			recipe.addIngredient(n, w);
		}
		catch (Exception e)
		{
			exceptionTrue=true;
		}
		assertEquals(recipe.getSize(), 1);
		assertEquals(recipe.getName(recipe.getSize()-1), n);
		assertEquals(recipe.getWeight(recipe.getSize()-1), w, 0.001);
		assertFalse(exceptionTrue);
	}
	
	@Test
	public void test2() throws Exception
	{
		setupStage2();
		String n="Pimienta";
		double w=6;
		boolean exceptionTrue=false;
		try
		{
			recipe.addIngredient(n, w);
		}
		catch (Exception e)
		{
			exceptionTrue=true;
		}
		assertEquals(recipe.getSize(), 4);
		assertEquals(recipe.getName(recipe.getSize()-1), n);
		assertEquals(recipe.getWeight(recipe.getSize()-1), w, 0.001);
		assertFalse(exceptionTrue);
	}
	
	@Test
	public void test3() throws Exception
	{
		setupStage2();
		String n="Ajo";
		double w=21;
		boolean exceptionTrue=false;
		try
		{
			recipe.addIngredient(n, w);
		}
		catch (Exception e)
		{
			exceptionTrue=true;
		}
		assertEquals(recipe.getSize(), 3);
		assertEquals(recipe.getWeight(recipe.getSize()-1), 79, 0.001);
		assertFalse(exceptionTrue);
	}
	
	@Test
	public void test4() throws Exception
	{
		setupStage2();
		String n="Ajo";
		boolean exceptionTrue=false;
		try
		{
			recipe.removeIngredient(n);
		}
		catch(Exception e)
		{
			exceptionTrue=true;
		}
		assertEquals(recipe.getSize(), 2);
		assertEquals(recipe.getName(0), "Cebolla");
		assertEquals(recipe.getName(1), "Arroz");
	}
	
}
