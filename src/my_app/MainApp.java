package my_app;

import java.util.Scanner;

import map_assets.Box;
import map_assets.Map;

public class MainApp {

	public static void main(String[] args){
		
		int count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Use automatic (a) or manual (m) ?");
		String choice = scan.next();
		while (!(choice.equals("a") || choice.equals("m"))) {
			System.out.println("Wrong answer, please select between automatic(a) and manual(m).");
			choice = scan.next();
		}
		
		
		if (choice.equals("a")) {
			Map.getInstance().displayMap();
			while (Map.getInstance().getListCharacter().size() > 1 && count != 30) {
				Map.getInstance().newStep();
				count++;
			}
			
			if (count < 30) {
				System.out.println("The simulation is over and " + Map.getInstance().getListCharacter().get(0).getContentBox().getClass() + " won the war.");
			}
			else {
				int nbrGood = 0;
				int nbrBad = 0;
				for (Box box : Map.getInstance().getListCharacter()) {
					if (box.getContentBox().getIsGood()) {
						nbrGood++;
					}
					else {
						nbrBad++;
					}
				}
				if (nbrGood - nbrBad == 0) {
					System.out.println("Simulation is over but no winner found.");
				}
				if (nbrGood - nbrBad < 0) {
					System.out.println("Simulation is over and The Bad ones won.");
				}
				if (nbrGood - nbrBad > 0) {
					System.out.println("Simulation is over and the Good ones won.");
				}
			}
			System.exit(0);
		}
		
		
		else {
			Map.getInstance().displayMap();
			while (Map.getInstance().getListCharacter().size() > 1 && count != 30) {
				System.out.println("Select next step (n) or quit (q).");
				String next = scan.next();
				while (!next.equals("q") && !next.equals("n")) {
					System.out.println("Wrong answer, please select next step (n) or quit (q).");
					next = scan.next();
				}
				if (next.equals("q")) {
					System.out.println("You've chosen to quit the simulation, goodbye.");
					System.exit(0);
				}
				else {
					Map.getInstance().newStep();
					count++;
				}
			}
			
			if (count < 30) {
				System.out.println("The simulation is over and " + Map.getInstance().getListCharacter().get(0).getContentBox().getClass() + " won the war.");
			}
			else {
				int nbrGood = 0;
				int nbrBad = 0;
				for (Box box : Map.getInstance().getListCharacter()) {
					if (box.getContentBox().getIsGood()) {
						nbrGood++;
					}
					else {
						nbrBad++;
					}
				}
				if (nbrGood - nbrBad == 0) {
					System.out.println("Simulation is over but no winner found.");
				}
				if (nbrGood - nbrBad < 0) {
					System.out.println("Simulation is over and The Bad ones won.");
				}
				if (nbrGood - nbrBad > 0) {
					System.out.println("Simulation is over and the Good ones won.");
				}
			}
			System.exit(0);
		}
	}
}