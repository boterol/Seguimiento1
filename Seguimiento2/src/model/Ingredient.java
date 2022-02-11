package model;

import exception.NegativeNumberException;

public class Ingredient 
{
	private String name;
	private double weight;
	
	public Ingredient(String n, double w) 
	{
		name = n;
		weight = w;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public double getWeight() 
	{
		return weight;
	}
	
	public void addWeight(double additionalW) throws NegativeNumberException
	{
		if (additionalW<0)
		{
			throw new NegativeNumberException();
		}
		else
		{
			weight+=additionalW;
		}
	}
	
	public void removeWeight(double removedW) throws NegativeNumberException
	{
		if(removedW<0)
		{
			throw new NegativeNumberException();
		}
		else
		{
			weight-=removedW;
		}
	}
	
}