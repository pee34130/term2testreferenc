package building;

import building.base.Building;
import building.base.ItemProducer;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Sawmill extends ProducingBuilding {

	private static final int HARVEST_INTERVAL = 3;
	private boolean wood=false;
	private int havestTime =HARVEST_INTERVAL;
	
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/sawmill.png");
		target.getChildren().add(icon);
		
		// TODO: fill this boolean
		boolean readyToProduceWood=wood;		// is this sawmill ready to produce wood?
		
		if(readyToProduceWood) {
			ItemIcon itemIcon = ItemType.WOOD.toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canProduceItem() {
		
		return wood;
	}

	@Override
	public Item getProducedItem() {
		if(canProduceItem()) {
			wood=false;
			return Item.wood();
		}
		return null;
	}

	@Override
	public void operate() {
		if(!wood) {
			havestTime-=1;
			if(havestTime==0) {
				wood=true;
				havestTime=HARVEST_INTERVAL;
			}
		}
		
	}
}
