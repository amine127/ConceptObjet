package our_app;

import java.util.Random;

import assets.Map;

public class MainApp {

	public static void main(String[] args) {
		Map testMap = new Map(6, 6);
		testMap.displayMap();
		System.out.println();
		
		Random randomGenerator = new Random();
		int rdmIndex1 = randomGenerator.nextInt(testMap.getNbrLine()), rdmIndex2 = randomGenerator.nextInt(testMap.getNbrColumn());
		System.out.println(testMap.getListBox().get(rdmIndex1).get(rdmIndex2));
		System.out.println("Surroundings : " + testMap.surroundings(testMap.getListBox().get(rdmIndex1).get(rdmIndex2)));
		
		System.out.println(testMap.getListBox().get(4).get(0));
		System.out.println("Surroundings : " + testMap.surroundings(testMap.getListBox().get(4).get(0)));
	}

}
