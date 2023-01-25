
package pnrs.java;

public abstract class Osoba
{
	protected String ime;
	
	protected String prezime;
	
	public void setName(String s)
	{
		ime = s;
	}
	
	public String getName()
	{
		return ime;
	}
	
	public void setSurname(String s)
	{
		prezime = s;
	}
	
	public String getSurname()
	{
		return prezime;
	}

	public abstract void predstaviSe();
}