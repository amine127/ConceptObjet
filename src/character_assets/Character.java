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
		if (PE < 0) {
			PE = 0;
		}
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
		if (PV < 0) {
			PV = 0;
		}
	}
	public boolean getIsGood() {
		return isGood;
	}
	
	/**
	 * Method that will randomly decide the issue of a fight between 2 Characters depending on their amount of XP.
	 * @return Returns if the attacking Character won the fight or not.
	 */
	public boolean fight(Entity enemy) {
		Random randomGenerator = new Random();
		
		/* Random value of attack depending on amount of XP */
		int mySpell = randomGenerator.nextInt(9)*10 + XP;
		int enemySpell = randomGenerator.nextInt(9)*10 + enemy.getXP();
		/* Random value of attack depending on amount of XP */
		
		//case when they are the same
		while (mySpell == enemySpell) {
			mySpell = randomGenerator.nextInt(9)*10 + XP;
			enemySpell = randomGenerator.nextInt(9)*10 + enemy.getXP();
		}
		//other cases
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
