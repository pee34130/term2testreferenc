package building;
import java.sql.CallableStatement;

import building.base.Building; 
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import logic.GameState;
import ui.BuildingIcon;
import ui.ItemIcon;
import item.ItemType;
public class Anvil extends ProducingandReceivingBuilding  {
	private static final int CRAFT_DELAY = 5;
	private static final int ENERGY_CONSUMPTION = 15;
	private boolean wood=false;
	private boolean iron_plate=false;
	private boolean sword=false;	
	private int craftDelayCurrent= CRAFT_DELAY;
	public void operate() {
		if(GameState.instance.consumeElectricity(ENERGY_CONSUMPTION)&&!sword) {
		    craftDelayCurrent-=1;
		    if(craftDelayCurrent==0) {
		    	sword=true;
		    	wood=false;
		    	iron_plate=false;
		    	craftDelayCurrent=CRAFT_DELAY;
		    	
		    }
		}
		
		
	}
	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/anvil.png");
		target.getChildren().add(icon);
		
		
		HBox status = new HBox();
		StackPane.setAlignment(status, Pos.TOP_CENTER);
		
		// TODO: fill this booleans
		boolean ready=sword;			// is this anvil ready (finished crafting iron sword)?
		boolean hasWood=wood;		// does this anvil has wood on it?
		boolean hasIronPlate=iron_plate;	// does this anvil has an iron plate on it?
		
		if(ready) {
			status.getChildren().add(ItemType.IRON_SWORD.toItemIcon());
		} else {
			if(hasWood) {
				status.getChildren().add(ItemType.WOOD.toItemIcon());
			}
			if(hasIronPlate) {
				status.getChildren().add(ItemType.IRON_PLATE.toItemIcon());
			}
		}
		target.getChildren().add(status);
	}
	
	public boolean canReceiveItem(ItemType ofType) {
		if(ofType == ItemType.WOOD && !wood)return true;
		if(ofType == ItemType.IRON_PLATE && !wood)return true;

		return false;
	}
	
	public void receiveItem(Item item) {
		if(canReceiveItem(item.getType())) {
			if(item.getType()==ItemType.WOOD)wood=true;
			if(item.getType()==ItemType.IRON_PLATE)iron_plate=true;
			
			
		}
		
	}
	
	@Override
	public Item getProducedItem() {
		if(canProduceItem()) {
			sword=false;
			return Item.ironSword();
		}
		return null;
	}
	

	@Override
	public boolean canProduceItem() {
		
		return sword;
	}

	

	
}
