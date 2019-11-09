package character_assets;

import map_assets.Entity;

public abstract class CharacterAccess {
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract int getPE();
	public abstract void setPE(int pE);
	public abstract int getXP();
	public abstract void setXP(int xP);
	public abstract int getPV();
	public abstract void setPV(int pV);
	public abstract boolean getIsGood();
	
	public abstract boolean fight(Entity enemy);
}
