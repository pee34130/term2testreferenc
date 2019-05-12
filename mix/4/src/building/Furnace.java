package building;

import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;

public class Furnace extends ProducingandReceivingBuilding {

	private static final int CRAFT_DELAY = 3;
	private static final int ENERGY_CONSUMPTION = 10;
	private boolean iron =false;
	private boolean iron_plate=false;
	private int craftcurrent=CRAFT_DELAY;
	
		
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/furnace.png");
		target.getChildren().add(icon);
		
		// TODO: fill these booleans
		boolean readyToProduceIronPlate=iron_plate;		// is this furnace ready to produce an iron plate?
		boolean hasIron=iron;						// does this furnace has iron in it?
		
		ItemIcon itemIcon = null;
		if (readyToProduceIronPlate) {
			itemIcon = ItemType.IRON_PLATE.toItemIcon();
		} else if(hasIron) {
			itemIcon = ItemType.IRON.toItemIcon();
		}
		
		if(itemIcon != null) {
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}

	@Override
	public boolean canProduceItem() {
		
		return iron_plate;
	}

	@Override
	public Item getProducedItem() {
		if(canProduceItem()) {
			iron_plate=false;
			return Item.ironPlate();
		}
		return null;
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		if(ofType==ItemType.IRON&&!iron)return true;
		return false;
	}

	@Override
	public void receiveItem(Item item) {
		if(canReceiveItem(item.getType())) {
			iron=true;
		}
		
	}

	@Override
	public void operate() {
		if(GameState.instance.consumeElectricity(ENERGY_CONSUMPTION)&&!iron_plate) {
			craftcurrent-=1;
			if(craftcurrent==0) {
				iron_plate=true;
				craftcurrent=CRAFT_DELAY;
			}
		}
		
	}

}
