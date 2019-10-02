package assets;

public class Personnage {
	
	protected String name;
	protected String lastdirection;
	protected int PE, XP, PV;
	
	
	public Personnage(String name, String lastdirection, int PE, int XP, int PV) {
		this.name=name;
		this.lastdirection=lastdirection;
		this.PE=PE;
		this.XP=XP;
		this.PV=PV;
		
	}
	

}
