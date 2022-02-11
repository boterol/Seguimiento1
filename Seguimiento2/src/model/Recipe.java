package model;

import java.util.ArrayList;
import java.util.List;

import exception.NegativeNumberException;

public class Recipe {
	private List<Ingredient> ingredients;
	
	public Recipe() { //String n, double w  -> parametros 
		ingredients = new ArrayList<Ingredient>();
	}
	
	
	public void addIngredient(String n, double w) throws NegativeNumberException {
		
		Ingredient searched = null;
		for (int i = 0; i < ingredients.size() && searched==null; i++) {
			Ingredient current = ingredients.get(i);
			if(current.getName().equals(n)) {
				searched = current;
			}
		}
		
		if(searched!=null) {
			searched.addWeight(w);
		}else {
			Ingredient newIngredient = new Ingredient(n, w);
			
			
			
			ingredients.add(newIngredient);
		}		
	}
	
	public void removeIngredient(String n) throws Exception
	{
		for(int i=0; i<ingredients.size(); i++)
		{
			if (ingredients.get(i).getName()==n)
			{
				ingredients.remove(i);
				i=ingredients.size();
			}
			else if(i==ingredients.size()-1)
			{
				throw new Exception();
			}
		}
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}
	
	public int getSize() throws Exception
	{
		int size=ingredients.size();
		if (size==0)
		{
			throw new Exception();
		}
		return size;
	}
	
	public String getName(int i)
	{
		String n="";
		n=ingredients.get(i).getName();
		return n;
	}
	
	public double getWeight(int i)
	{
		double w=ingredients.get(i).getWeight();
		return w;
	}
}