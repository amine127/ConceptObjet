package character_assets;

public abstract class Good extends Character{

	public Good(String name) {
		super(name);
		this.PE = 100;
		this.PV = 120;
		this.isGood = true;
	}
}
