
package rtrk.pnrs;

//import rtrk.pnrs.cats.Lion;
//import rtrk.pnrs.cats.Cat;
//import rtrk.pnrs.cats.DomesticCat;
import rtrk.pnrs.cats.*;

public class AnimalKingdom
{
	public static void main(String []args)
	{
		Cat[] cats = 
		{ 
			new DomesticCat(), 
			new Lion() 
		};
		
		for(Cat c : cats)
		{
			c.pet();
		}
		
		try 
		{
			Listener l = new Listener();
			Portion p = new Portion();
			Cat neg = new Lion();
			float f = 10.0f;
			neg.feed(p, f, l);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception: " + e);
		}
	}
}