package rtrk.pnrs.cats;

public class Portion
{
	private float food;
	
	public Portion()
	{
		food = 0;
	}
	
	public void setFood(float f) throws Exception
	{
		if(f > 0)
			food = f;
		else
			throw new Exception("Food cannot be negative!");
	}
	
	public float getFood()
	{
		return food;
	}
}