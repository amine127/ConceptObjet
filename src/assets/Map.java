package assets;

public class Map {
	private int lengthMap;
	private int widthMap;
	
	public Map(int length, int width) {
		this.lengthMap = length;
		this.widthMap = width;
		
	}
	
	@Override
	public String toString() {
		return printMap();
	}
	
	// faire avec des listes par soucis d'accessibilité
	public String printMap() {
		String mapDisplay = "";
		
		for (int i = 0; i < this.lengthMap; i++) {
			for (int j = 0; j < this.widthMap; j++) {
				if (j == 0) {
					mapDisplay += "|";
				}
				mapDisplay += "o|";
			}
			mapDisplay += "\n____________________" + "\n";
		}
		return mapDisplay;
	}
}
