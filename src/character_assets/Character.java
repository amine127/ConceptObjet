package character_assets;

import java.util.Random;

import map_assets.Entity;

public abstract class Character extends Entity{
	
	protected String name;
	protected int PE;
	protected int XP;
	protected int PV;
	protected boolean isGood;
	
	public Character(String name) {
		super();
		this.name = name;
		this.XP = 0;;
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
	public boolean getIsGood() {
		return isGood;
	}
	
	public boolean fight(Entity enemy) {
		Random randomGenerator = new Random();
		int mySpell = randomGenerator.nextInt(9)*10 + XP;
		int enemySpell = randomGenerator.nextInt(9)*10 + enemy.getXP();
		while (mySpell == enemySpell) {
			mySpell = randomGenerator.nextInt(9)*10 + XP;
			enemySpell = randomGenerator.nextInt(9)*10 + enemy.getXP();
		}
		if (mySpell > enemySpell) {
			System.out.println(this.name + " attacked " + enemy.getName() + " and succeeded. " + enemy.getName() + " died.");
			return true;
		}
		else {
			System.out.println(this.name + " attacked " + enemy.getName() + " and failed. " + this.name + " died.");
			return false;
		}
	}
}
