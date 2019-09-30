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
		for(int i = 0; i < this.lengthMap; i++) {
			for (int j = 0; j < this.widthMap; i++) {
				System.out.print("**");
			}
			System.out.println();
		}
		return super.toString();
	}
	
	
}
