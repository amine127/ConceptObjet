package assets;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private int nbrLine;
	private int nbrColumn;
	private ArrayList<Box> listBox = new ArrayList<Box>();
	
	public Map(int nbrLine, int nbrColumn) {
		this.nbrLine = nbrLine;
		this.nbrColumn = nbrColumn;
		this.createBoxes();
		this.generateObstacle();
	}
	
	public ArrayList<Box> getListBox() {
		return listBox;
	}
	
	public void displayMap() {
		for (int i = 0; i < nbrLine; i++) {
			
			for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
			System.out.println();
			for (int j = 0; j < nbrColumn; j++) {
				System.out.print("| " + this.listBox.get((i*10)+j).getContentBox() + " |");
			}
			System.out.println();
		}
		for (int k = 0; k < nbrColumn; k++) { System.out.print(" --- "); }
	}
	
	public void createBoxes() {
		for (int i = 0; i < nbrLine; i++) {
			for (int j = 0; j < nbrColumn; j++) {
				listBox.add(new Box(i, j, true));
			}
		}
	}
	
	public void generateObstacle() {
		Random randomGenerator = new Random();
		
		for (int i = 0; i < 10; i++) {
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
	
}
