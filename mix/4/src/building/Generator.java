package building;
import java.io.File;
//import com.sun.java.util.jar.pack.Package.Class.Field;

import building.base.Building;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Generator extends ReceivingBuilding {
	
	private static final int GENERATION_DELAY = 3;
	private static final int GENERATED_ELECTRICITY = 5;
	private boolean wood=false;
	private int generatorDelay =GENERATION_DELAY;

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/generator.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
		boolean hasWood=wood;		// does this generator has wood in it?
		
		if(hasWood) {
			ItemIcon itemIcon = ItemType.WOOD.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		if(ofType==ItemType.WOOD&&!wood)return true;
		return false;
	}

	@Override
	public void receiveItem(Item item) {
		if(canReceiveItem(item.getType())) {
			wood=true;
		}
		
	}

	@Override
	public void operate() {
		generatorDelay-=1;
		if(generatorDelay==0) {
			generatorDelay=GENERATION_DELAY;
			wood=false;
			GameState.instance.generateElectricity(GENERATED_ELECTRICITY);
		}
		
	}

}
