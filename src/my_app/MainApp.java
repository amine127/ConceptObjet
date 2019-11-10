package my_app;

import java.util.Scanner;

import map_assets.Box;
import map_assets.Map;

public class MainApp {

	public static void main(String[] args){
		
		int count = 0;
		
		//selection auto or manual
		Scanner scan = new Scanner(System.in);
		System.out.println("Use automatic (a) or manual (m) ?");
		String choice = scan.next();
		
		//insurance to get one of the possible answer
		while (!(choice.equals("a") || choice.equals("m"))) {
			System.out.println("Wrong answer, please select between automatic(a) and manual(m).");
			choice = scan.next();
		}
		
		//variables used to end the simulation if it only remains Goods or Bads
		boolean onlyGood = false, onlyBad = false;
		
		/* AUTO MODE */
		if (choice.equals("a")) {
			Map.getInstance().displayMap();
			while (onlyGood == onlyBad && count != 30) {
				onlyGood = false;
				onlyBad = false;
				Map.getInstance().newStep();
				for (Box b : Map.getInstance().getListCharacter()) {
					if (b.getContentBox().getIsGood()) {
						onlyGood = true;
					}
					else {
						onlyBad = true;
					}
				}
				count++;
			}
			
			if (count < 30) {
				if (onlyGood) {
					System.out.println(Map.getInstance().getListCharacter().size() + " Good(s) remaining, simulation is over and the Good ones won.");
				}
				else {
					System.out.println(Map.getInstance().getListCharacter().size() + " Bad(s) remaining, simulation is over and The Bad ones won.");
				}
			}
			else {
				if (onlyGood) {
					System.out.println(Map.getInstance().getListCharacter().size() + " Good(s) remaining, simulation is over and the Good ones won.");
				}
				else {
					if (onlyBad) {
						System.out.println(Map.getInstance().getListCharacter().size() + " Bad(s) remaining, simulation is over and The Bad ones won.");
					}
					else {
						System.out.println("Simulation is over but no winner found.");
					}
				}
			}
		}
		/* AUTO MODE */
		
		/* MANUAL MODE */
		else {
			Map.getInstance().displayMap();
			while (onlyGood == onlyBad && count != 30) {
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
					onlyGood = false;
					onlyBad = false;
					Map.getInstance().newStep();
					for (Box b : Map.getInstance().getListCharacter()) {
						if (b.getContentBox().getIsGood()) {
							onlyGood = true;
						}
						else {
							onlyBad = true;
						}
					}
					count++;
				}
			}
			
			if (count < 30) {
				if (onlyGood) {
					System.out.println(Map.getInstance().getListCharacter().size() + " Good(s) remaining, simulation is over and the Good ones won.");
				}
				else {
					System.out.println(Map.getInstance().getListCharacter().size() + " Bad(s) remaining, simulation is over and The Bad ones won.");
				}
			}
			else {
				if (onlyGood) {
					System.out.println(Map.getInstance().getListCharacter().size() + " Good(s) remaining, simulation is over and the Good ones won.");
				}
				else {
					if (onlyBad) {
						System.out.println(Map.getInstance().getListCharacter().size() + " Bad(s) remaining, simulation is over and The Bad ones won.");
					}
					else {
						System.out.println("Simulation is over but no winner found.");
					}
				}
			}
		}
		/* MANUAL MODE */
		
		//ending simulation
		System.exit(0);
	}
}