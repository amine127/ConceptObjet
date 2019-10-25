package character_assets;

import java.util.Random;

import map_assets.Entity;

public abstract class Character extends Entity{
	
	protected String name;
	protected int PE;
	protected int XP;
	protected int PV;
	protected String lastDirection;
	
	public Character() {
		super();
		this.XP = 0;
		this.lastDirection = "";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPE() {
		return PE;
	}
	public void setPE(int pE) {
		PE = pE;
	}
	public int getXP() {
		return XP;
	}
	public void setXP(int xP) {
		XP = xP;
	}
	public int getPV() {
		return PV;
	}
	public void setPV(int pV) {
		PV = pV;
	}
	public String getLastDirection() {
		return lastDirection;
	}
	public void setLastDirection(String lastDirection) {
		this.lastDirection = lastDirection;
	}

	public abstract void move();
	
	public String selectRandomMove() {
		Random randomGenerator = new Random();
		int pick = randomGenerator.nextInt(3);;
		switch (pick) {
		case 0:
			return "fou";
		case 1:
			return "tour";
		case 2:
			return "dame";
		case 3:
			return "roi";
		default:
			return "";
		}
	}
}
