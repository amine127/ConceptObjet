package map_assets;

import java.util.ArrayList;
import java.util.Random;

import character_assets.Elve;
import character_assets.Goblin;
import character_assets.Human;
import character_assets.Orc;

public final class Map {
	private int nbrLine;
	private int nbrColumn;
	private ArrayList<Box> safeZoneGood = new ArrayList<Box>();
	private ArrayList<Box> safeZoneBad = new ArrayList<Box>();
	private ArrayList<ArrayList<Box>> listBox = new ArrayList<ArrayList<Box>>();
	private ArrayList<Box> listCharacter = new ArrayList<Box>();
	
	private static volatile Map instance = null;
	
	/**
	 * Constructor.
	 * @param nbrLine
	 * @param nbrColumn
	 */
	private Map(int nbrLine, int nbrColumn) {
		this.nbrLine = nbrLine;
		this.nbrColumn = nbrColumn;
		this.createBoxes();
		this.defineSafeZone();
		this.generateObstacle();
		this.generateCreatures();
		this.fillListCharacter();
	}
	//Design pattern singleton
	public final static Map getInstance() {
		if (Map.instance == null) {
			Map.instance = new Map(8, 8);
		}
		return instance;
	}
	
	public ArrayList<Box> getSafeZoneGood() {
		return safeZoneGood;
	}
	public ArrayList<Box> getSafeZoneBad() {
		return safeZoneBad;
	}
	public ArrayList<ArrayList<Box>> getListBox() {
		return listBox;
	}
	public ArrayList<Box> getListCharacter() {
		return listCharacter;
	}
	public int getNbrLine() {
		return nbrLine;
	}
	public int getNbrColumn() {
		return nbrColumn;
	}
	
	
	/**
	 * Displays the Map object following a special design.
	 */
	public void displayMap() {
		for (int i = 0; i < nbrLine; i++) {
			
			for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
			System.out.println();
			for (int j = 0; j < nbrColumn; j++) {
				System.out.print("| " + listBox.get(i).get(j).getContentBox().getTag() + " |");
			}
			System.out.println();
		}
		for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
		System.out.println();
	}
	
	
	/**
	 * Creates ArrayLists, then fills them with Boxes.
	 */
	public void createBoxes() {
		for (int i = 0; i < nbrLine; i++) {
			listBox.add(new ArrayList<Box>());
			for (int j = 0; j < nbrColumn; j++) {
				listBox.get(i).add(new Box(i, j));
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
			int currentLine = randomGenerator.nextInt(nbrLine - 1);
			int currentColumn = randomGenerator.nextInt(nbrColumn - 1);
			if (listBox.get(currentLine).get(currentColumn).getIsEmpty()) {
				listBox.get(currentLine).get(currentColumn).setIsEmpty(false);
				listBox.get(currentLine).get(currentColumn).setContentBox(new Tree());
			}
			else {
				while (!done) {
					currentLine = randomGenerator.nextInt(nbrLine - 1);
					currentColumn = randomGenerator.nextInt(nbrColumn - 1);
					if (listBox.get(currentLine).get(currentColumn).getIsEmpty()) {
						listBox.get(currentLine).get(currentColumn).setIsEmpty(false);
						listBox.get(currentLine).get(currentColumn).setContentBox(new Tree());
						done = true;
					}
				}
				done = false;
			}
		}
	}
	
	
	/**
	 * Generates creatures in random Boxes from the Map.
	 * The number of generated creatures depends on the size of the map and it makes sure to
	 * generate the same amount of creature for each race.
	 */
	public void generateCreatures() {
		Random randomGenerator = new Random();
		int var = (nbrColumn*nbrLine / 16) - ((nbrColumn*nbrLine / 16)%4);
		
		for (int i = 1; i <= var; i++) {
			switch (i % 4) {
			case 0:
				boolean done = false;
				int currentLine = randomGenerator.nextInt(nbrLine - 1);
				int currentColumn = randomGenerator.nextInt(nbrColumn - 1);
				if (listBox.get(currentLine).get(currentColumn).getIsEmpty()) {
					listBox.get(currentLine).get(currentColumn).setIsEmpty(false);
					listBox.get(currentLine).get(currentColumn).setContentBox(new Human("Human" + i));
				}
				else {
					while (!done) {
						currentLine = randomGenerator.nextInt(nbrLine - 1);
						currentColumn = randomGenerator.nextInt(nbrColumn - 1);
						if (listBox.get(currentLine).get(currentColumn).getIsEmpty()) {
							listBox.get(currentLine).get(currentColumn).setIsEmpty(false);
							listBox.get(currentLine).get(currentColumn).setContentBox(new Human("Human" + i));
							done = true;
						}
					}
					done = false;
				}break;
			case 1:
				boolean done1 = false;
				int currentLine1 = randomGenerator.nextInt(nbrLine - 1);
				int currentColumn1 = randomGenerator.nextInt(nbrColumn - 1);
				if (listBox.get(currentLine1).get(currentColumn1).getIsEmpty()) {
					listBox.get(currentLine1).get(currentColumn1).setIsEmpty(false);
					listBox.get(currentLine1).get(currentColumn1).setContentBox(new Elve("Elve" + i));
				}
				else {
					while (!done1) {
						currentLine1 = randomGenerator.nextInt(nbrLine - 1);
						currentColumn1 = randomGenerator.nextInt(nbrColumn - 1);
						if (listBox.get(currentLine1).get(currentColumn1).getIsEmpty()) {
							listBox.get(currentLine1).get(currentColumn1).setIsEmpty(false);
							listBox.get(currentLine1).get(currentColumn1).setContentBox(new Elve("Elve" + i));
							done1 = true;
						}
					}
					done1 = false;
				}break;
			case 2:
				boolean done2 = false;
				int currentLine2 = randomGenerator.nextInt(nbrLine - 1);
				int currentColumn2 = randomGenerator.nextInt(nbrColumn - 1);
				if (listBox.get(currentLine2).get(currentColumn2).getIsEmpty()) {
					listBox.get(currentLine2).get(currentColumn2).setIsEmpty(false);
					listBox.get(currentLine2).get(currentColumn2).setContentBox(new Orc("Orc" + i));
				}
				else {
					while (!done2) {
						currentLine2 = randomGenerator.nextInt(nbrLine - 1);
						currentColumn2 = randomGenerator.nextInt(nbrColumn - 1);
						if (listBox.get(currentLine2).get(currentColumn2).getIsEmpty()) {
							listBox.get(currentLine2).get(currentColumn2).setIsEmpty(false);
							listBox.get(currentLine2).get(currentColumn2).setContentBox(new Orc("Orc" + i));
							done2 = true;
						}
					}
					done2 = false;
				}break;
			case 3:
				boolean done3 = false;
				int currentLine3 = randomGenerator.nextInt(nbrLine - 1);
				int currentColumn3 = randomGenerator.nextInt(nbrColumn - 1);
				if (listBox.get(currentLine3).get(currentColumn3).getIsEmpty()) {
					listBox.get(currentLine3).get(currentColumn3).setIsEmpty(false);
					listBox.get(currentLine3).get(currentColumn3).setContentBox(new Goblin("Goblin" + i));
				}
				else {
					while (!done3) {
						currentLine3 = randomGenerator.nextInt(nbrLine - 1);
						currentColumn3 = randomGenerator.nextInt(nbrColumn - 1);
						if (listBox.get(currentLine3).get(currentColumn3).getIsEmpty()) {
							listBox.get(currentLine3).get(currentColumn3).setIsEmpty(false);
							listBox.get(currentLine3).get(currentColumn3).setContentBox(new Goblin("Goblin" + i));
							done3 = true;
						}
					}
					done3 = false;
				}break;
			}
		}
	}

	
	/**
	 * Defines which Box(es) compose different safe zone.
	 */
	public void defineSafeZone() {
		if (nbrLine * nbrColumn >= 4) {
			for (int i = 0; i < nbrLine; i++) {
				for (int j = 0; j < 2; j++) {
					safeZoneGood.add(listBox.get(i).get(j));
					safeZoneBad.add(listBox.get(i).get(nbrColumn - 1 - j));
				}
			}
		}
	}
	

	/**
	 * Method to give each boxes around the given box. //Not optimized (X if/else)
	 * @param box
	 * @return Returns an ArrayList containing each adjacent box.
	 */
	public ArrayList<Box> surroundings(Box box) {
		ArrayList<Box> surroundings = new ArrayList<Box>();
		boolean firstLine = false, firstColumn = false, lastLine = false, lastColumn = false;
		if (box.getIndexLine() == 0) {
			firstLine = true;
		}
		if (box.getIndexLine() == nbrLine - 1) {
			lastLine = true;
		}
		if (box.getIndexColumn() == 0) {
			firstColumn = true;
		}
		if (box.getIndexColumn() == nbrColumn - 1) {
			lastColumn = true;
		}
		
		if (firstLine) {
			if (firstColumn) {
				surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
				surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
				surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() + 1));
			}
			else {
				if (lastColumn) {
					surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() - 1));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
				}
				else {
					surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() + 1));
					surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() - 1));
				}
			}
		}
		else {
			if (lastLine) {
				if (firstColumn) {
					surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
					surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() + 1));
					surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
				}
				else {
					if (lastColumn) {
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
					}
					else {
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() + 1));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
					}
				}
			}
			else {
				if (firstColumn) {
					surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
					surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() + 1));
					surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
					surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() + 1));
				}
				else {
					if (lastColumn) {
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
					}
					else {
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn()));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() - 1).get(box.getIndexColumn() + 1));
						surroundings.add(listBox.get(box.getIndexLine()).get(box.getIndexColumn() + 1));
						surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() - 1));
						surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn()));
						surroundings.add(listBox.get(box.getIndexLine() + 1).get(box.getIndexColumn() + 1));
					}
				}
			}
		}
		return surroundings;
	}
	
	/**
	 * Method to fill the ArrayList containing each alive Character.
	 */
	public void fillListCharacter() {
		listCharacter.clear();
		for (int i = 0; i < nbrLine; i++) {
			for (int j = 0; j < nbrColumn; j++) {
				if (listBox.get(i).get(j).getContentBox().getTag().equals("H") || listBox.get(i).get(j).getContentBox().getTag().equals("E") || listBox.get(i).get(j).getContentBox().getTag().equals("O") || listBox.get(i).get(j).getContentBox().getTag().equals("G")) {
					listCharacter.add(listBox.get(i).get(j));
				}
			}
		}
	}
	
	/**
	 * Method which needs to be called each iteration of the simulation.
	 * It displays the Map, says the position of each alive Character...
	 */
	public void newStep() {
		System.out.println();
		System.out.println("--------------- NEW STEP ---------------");
		System.out.println();
		System.out.println("Alive Characters : " + Map.getInstance().getListCharacter());
		for (Box b : listCharacter) {
			move(b);
		}
		fillListCharacter();
		System.out.println("New alive Characters : " + Map.getInstance().getListCharacter());
		Map.getInstance().displayMap();
		System.out.println();
		System.out.println("--------------- END STEP ---------------");
		System.out.println();
	}
	
	/**
	 * Method to select a random number of case to move.
	 * @return Returns a random int.
	 */
	public int selectRandomNbrCase() {
		Random randomGenerator = new Random();
		int nbrCase = randomGenerator.nextInt(Math.max(nbrColumn - 1, nbrLine - 1)) + 1;
		return nbrCase;	
	}
	
	/**
	 * Method that returns a random Box (i.e. direction) from the surroundings of the Box in parameter.
	 * @param box The Box from which you need to select a random direction.
	 * @return
	 */
	public Box selectRandomDirection(Box box) {
		Random randomGenerator = new Random();
		
		ArrayList<Box> possibleBox = new ArrayList<Box>();
		for (Box b : surroundings(box)) {
			if (b.getIsEmpty()) {
				possibleBox.add(b);
			}
		}
		if (!possibleBox.isEmpty()) {
			int intDir = randomGenerator.nextInt(possibleBox.size());
			
			return possibleBox.get(intDir);
		}
		else {
			return box;
		}
	}
	
	/**
	 * Method that empties the actual box and fills the other one with the content of the first one.
	 * @param box Box containing the Entity you want to move.
	 */
	public void move(Box box) {
		int nbrBoxMove = selectRandomNbrCase();
		int count = 0;
		
		Box newBox = selectRandomDirection(box);
		
		int deltaLine = newBox.getIndexLine() - box.getIndexLine();
		int deltaColumn = newBox.getIndexColumn() - box.getIndexColumn();
		
		while (count < nbrBoxMove) {
			if (newBox.getIsEmpty()) {
				newBox.setIsEmpty(false);
				newBox.setContentBox(box.getContentBox());
				
				box.setIsEmpty(true);
				box.setContentBox(new Entity());
				
				box = newBox;
				if ((box.getIndexLine() + deltaLine) >= 0 && (box.getIndexLine() + deltaLine) < nbrLine && (box.getIndexColumn() + deltaColumn) >= 0 && (box.getIndexColumn() + deltaColumn) < nbrColumn) {
					newBox = listBox.get(box.getIndexLine() + deltaLine).get(box.getIndexColumn() + deltaColumn);
					count++;
				}
				else {
					count = nbrBoxMove;
				}
			}
			else {
				count = nbrBoxMove;
			}
		}
		System.out.println(box.getContentBox().getName() + " moves.");
		Map.getInstance().displayMap();
		
		for (Box b : surroundings(box)) {
			if (box.getContentBox().getPV() > 0) {
				if (!b.getIsEmpty() && !b.getContentBox().getTag().equals("T")) {
					meet(box, b);
					Map.getInstance().displayMap();
				}
			}
		}
	}
	
	public void meet(Box box1, Box box2) {
		/* Enemies case */
		if (box1.getContentBox().getIsGood() != box2.getContentBox().getIsGood()) {
			if (box1.getContentBox().fight(box2.getContentBox())) {
				box1.getContentBox().setXP(box1.getContentBox().getXP() + box2.getContentBox().getXP());
				box2.getContentBox().setPV(0);
				box2.setIsEmpty(true);
				box2.setContentBox(new Entity());
			}
			else {
				box2.getContentBox().setXP(box2.getContentBox().getXP() + box1.getContentBox().getXP());
				box1.getContentBox().setPV(0);
				box1.setIsEmpty(true);
				box1.setContentBox(new Entity());
			}
		}
		/* Allies case */
		else {
			box1.getContentBox().setXP(box1.getContentBox().getXP() + 10);
			box2.getContentBox().setXP(box2.getContentBox().getXP() + 10);
			System.out.println(box1.getContentBox().getName() + " and " + box2.getContentBox().getName() + " met and shared 20 XP.");
		}
	}
}
