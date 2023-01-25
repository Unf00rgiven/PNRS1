
package pnrs.java;

public class Student extends Osoba
{
	private String index;
	
	public void setIndex(String s)
	{
		index = s;
	}
	
	public String getIndex()
	{
		return index;
	}
	
	public void predstaviSe()
	{
		System.out.println("Zovem se " + ime + " " + prezime + ". " + "Broj indeksa: " + index);
	}
}