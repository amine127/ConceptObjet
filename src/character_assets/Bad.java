package character_assets;

public abstract class Bad extends Character{

	public static int maxPV = 100;
	public static int maxPE = 120;
	
	public Bad(String name) {
		super(name);
		this.PE = Bad.maxPE;
		this.PV = Bad.maxPV;
		this.isGood = false;
	}
}
