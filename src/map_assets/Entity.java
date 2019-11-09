package map_assets;

public class Entity extends CharacterAccess {

	protected String tag = " ";
	protected boolean isGood;

	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean getIsGood() {
		return isGood;
	}
	
	@Override
	public String getName() {
		return null;
	}
	@Override
	public void setName(String name) {}
	@Override
	public int getPE() {
		return 0;
	}
	@Override
	public void setPE(int pE) {}
	@Override
	public int getXP() {
		return 0;
	}
	@Override
	public void setXP(int xP) {}
	@Override
	public int getPV() {
		return 0;
	}
	@Override
	public void setPV(int pV) {}
	@Override
	public void fight(Character enemy) {}
}
