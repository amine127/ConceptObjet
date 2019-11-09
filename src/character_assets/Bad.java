package character_assets;

public abstract class Bad extends Character{

	public Bad(String name) {
		super(name);
		this.PE = 120;
		this.PV = 100;
		this.isGood = false;
	}
}
