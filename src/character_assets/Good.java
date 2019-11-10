package character_assets;

public abstract class Good extends Character{

	public static int maxPE = 100;
	public static int maxPV = 120;
	
	public Good(String name) {
		super(name);
		this.PE = Good.maxPE;
		this.PV = Good.maxPV;
		this.isGood = true;
	}
}
