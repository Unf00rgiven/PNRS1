package rtrk.pnrs.cats;

public abstract class Cat
{
	public abstract void pet();
	
	public void feed(Portion p, float f) throws Exception
	{
		p.setFood(f);
	}
	
	public void feed(Portion p, float f, IEat e) throws Exception
	{
		p.setFood(f);
		e.onEatingFinished(this);
	}
}