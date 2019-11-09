package my_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import character_assets.Human;
import map_assets.Map;

public class MainApp {

	public static void main(String[] args) throws IOException {
		
		Map.getInstance().displayMap();
		System.out.println("Alive Characters : " + Map.getInstance().getListCharacter());
		
		while (Map.getInstance().getListCharacter().size() > 1) {
			
			/*BufferedReader to select to display next step of the simulation or leave.*/
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String line = "";
			while (line.equalsIgnoreCase("q") == false) {
				System.out.println("Press Enter for next step or type \"q\" to quit.");
			    line = in.readLine();
			    Map.getInstance().newStep();
			}
			if (line.equalsIgnoreCase("q")) {
				in.close();
				System.out.println("You've chosen to leave the simulation, goodbye.");
			    System.exit(0);
			}
		    /*End BufferedReader*/
		}
		System.out.println("The simulation is over and " + Map.getInstance().getListCharacter().get(0).getContentBox().getClass() + " won the war.");
	}
}