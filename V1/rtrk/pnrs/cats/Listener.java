
package rtrk.pnrs.cats;

public class Listener implements IEat
{
	public void onEatingFinished(Cat c)
	{
		c.pet();
	}
}