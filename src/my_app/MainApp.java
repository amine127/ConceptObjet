package my_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import map_assets.Map;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		while (true) {	
			Map.getInstance().displayMap();
			System.out.println();
			
			/*TEST SURROUNDINGS*/
			//Random randomGenerator = new Random();
			//int rdmIndex1 = randomGenerator.nextInt(Map.getInstance().getNbrLine()), rdmIndex2 = randomGenerator.nextInt(Map.getInstance().getNbrColumn());
			//System.out.println(Map.getInstance().getListBox().get(rdmIndex1).get(rdmIndex2));
			//System.out.println("Surroundings : " + Map.getInstance().surroundings(Map.getInstance().getListBox().get(rdmIndex1).get(rdmIndex2)));
			/*TEST SURROUNDINGS*/
			
			/*BufferedReader to select to display next step of the simulation or leave.*/
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			while (line.equalsIgnoreCase("q") == false) {
				System.out.println("Press Enter for next step or type \"q\" to quit.");
			    line = in.readLine();
			}
			if (line.equalsIgnoreCase("q")) {
				in.close();
				System.out.println("You've chosen to leave the simulation, goodbye.");
			    System.exit(0);
			}
		    /*End BufferedReader*/
		}
	}
}