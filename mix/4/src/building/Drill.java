package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import sun.java2d.HeadlessGraphicsEnvironment;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Drill extends ProducingBuilding{

	private static final int HARVEST_INTERVAL = 4;
	private static final int ENERGY_CONSUMPTION = 5;
	private boolean iron=false;
	private  int havestTime =HARVEST_INTERVAL;
	

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/drill.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
		boolean readyToProduceIron = iron;		// is this drill ready to produce iron?
		
		if(readyToProduceIron) {
			ItemIcon itemIcon = ItemType.IRON.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}


	@Override
	public boolean canProduceItem() {
		
		return iron;
	}


	@Override
	public Item getProducedItem() {
		if(iron) {
			iron=false;
			return Item.iron();
		}
		return null;
	}


	@Override
	public void operate() {
		if(GameState.instance.consumeElectricity(ENERGY_CONSUMPTION)) {
			if(!iron)havestTime -=1;
		    if(havestTime==0) {
		    	iron=true;
		    	havestTime=HARVEST_INTERVAL;
		    	
		    }
		}
		
	}
}
