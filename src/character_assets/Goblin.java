package character_assets;

import java.util.Random;

public class Goblin extends Bad{

	public Goblin() {
		super();
		this.tag = "G";
	}
	
	public void move() {
		String pick = this.selectRandomMove();
		switch (pick) {
		case "fou":
			
		}
	}
}
