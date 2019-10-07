package assets;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private int nbrLine;
	private int nbrColumn;
	private ArrayList<Box> safeZoneOrc = new ArrayList<Box>();
	private ArrayList<Box> safeZoneGoblin = new ArrayList<Box>();
	private ArrayList<Box> safeZoneHuman = new ArrayList<Box>();
	private ArrayList<Box> safeZoneElve = new ArrayList<Box>();
	private ArrayList<Box> listBox = new ArrayList<Box>();
	
	/**
	 * Constructor.
	 * @param nbrLine
	 * @param nbrColumn
	 */
	public Map(int nbrLine, int nbrColumn) {
		this.nbrLine = nbrLine;
		this.nbrColumn = nbrColumn;
		this.createBoxes();
		this.defineSafeZone();
		this.generateObstacle();
	}
	
	public ArrayList<Box> getSafeZoneOrc() {
		return safeZoneOrc;
	}
	public ArrayList<Box> getSafeZoneGoblin() {
		return safeZoneGoblin;
	}
	public ArrayList<Box> getSafeZoneHuman() {
		return safeZoneHuman;
	}
	public ArrayList<Box> getSafeZoneElve() {
		return safeZoneElve;
	}
	public ArrayList<Box> getListBox() {
		return listBox;
	}
	
	/**
	 * Displays the Map object following a special design.
	 */
	public void displayMap() {
		for (int i = 0; i < nbrLine; i++) {
			
			for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
			System.out.println();
			for (int j = 0; j < nbrColumn; j++) {
				System.out.print("| " + this.listBox.get((i*nbrColumn)+j).getContentBox() + " |");
			}
			System.out.println();
		}
		for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
	}
	
	/**
	 * Fills the Map object's attribute "listBox" with Box objects.
	 */
	public void createBoxes() {
		for (int i = 0; i < nbrLine; i++) {
			for (int j = 0; j < nbrColumn; j++) {
				listBox.add(new Box(i, j, true));
			}
		}
	}
	
	/**
	 * Generates obstacles in random Boxes from the Map.
	 * The number of generated obstacles depends on the size of the map. 
	 */
	public void generateObstacle() {
		Random randomGenerator = new Random();
		
		for (int i = 0; i < Math.floor(Math.sqrt(nbrLine*nbrColumn)); i++) {
			boolean done = false;
			int currentIndex = randomGenerator.nextInt((nbrLine * nbrColumn) - 1);
			if (listBox.get(currentIndex).getIsEmpty()) {
				listBox.get(currentIndex).setContentBox("A");
				listBox.get(currentIndex).setIsEmpty(false);
			}
			else {
				while (!done) {
					currentIndex = randomGenerator.nextInt((nbrLine * nbrColumn) - 1);
					if (listBox.get(currentIndex).getIsEmpty()) {
						listBox.get(currentIndex).setContentBox("A");
						listBox.get(currentIndex).setIsEmpty(false);
						done = true;
					}
				}
			}
		}
	}
	
	/**
	 * Defines which Box(es) compose different safe zone.
	 */
	public void defineSafeZone() {
		
		/* TODO Gérer levée d'exception si taille de la map trop petite */
		
		if (nbrLine * nbrColumn >= 36) {
			/*Associating boxes with Orc's safezone - upper left 2x2 corner*/
			safeZoneOrc.add(listBox.get(0));
			safeZoneOrc.add(listBox.get(1));
			safeZoneOrc.add(listBox.get(nbrColumn));
			safeZoneOrc.add(listBox.get(nbrColumn + 1));
			
			/*Associating boxes with Goblin's safezone - bottom right 2x2 corner*/
			safeZoneGoblin.add(listBox.get(nbrLine * (nbrColumn - 2)));
			safeZoneGoblin.add(listBox.get(nbrLine * (nbrColumn - 1)));
			safeZoneGoblin.add(listBox.get(nbrLine * nbrColumn - 2));
			safeZoneGoblin.add(listBox.get(nbrLine * nbrColumn - 1));
			
			/*Associating boxes with Human's safezone - upper right 2x2 corner*/
			safeZoneHuman.add(listBox.get(nbrColumn - 2));
			safeZoneHuman.add(listBox.get(nbrColumn - 1));
			safeZoneHuman.add(listBox.get(nbrLine + nbrColumn - 2));
			safeZoneHuman.add(listBox.get(nbrLine + nbrColumn - 1));
			
			/*Associating boxes with Elve's safezone - bottom left 2x2 corner*/
			safeZoneElve.add(listBox.get((nbrLine - 2) * nbrColumn));
			safeZoneElve.add(listBox.get((nbrLine - 2) * nbrColumn + 1));
			safeZoneElve.add(listBox.get((nbrLine - 1) * nbrColumn));
			safeZoneElve.add(listBox.get((nbrLine - 1) * nbrColumn + 1));
		}
	}
	
}
