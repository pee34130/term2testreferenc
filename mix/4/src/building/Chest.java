package building;

import java.util.HashMap;
import java.util.Map;
import building.base.Building;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import ui.BuildingIcon;

public class Chest extends ReceivingBuilding{
	private Map<ItemType, Integer> Inventory=  new HashMap<ItemType, Integer>();

	@Override
	public void render(StackPane target) {
		BuildingIcon icon = new BuildingIcon("file:res/chest.png");
		target.getChildren().add(icon);
		
		Label numberOfItemsLabel = new Label();
		String numberOfItemsText = Integer.toString(this.getInventory().values().stream().reduce(0, (a, b) -> a+b));
		numberOfItemsLabel.setText(numberOfItemsText);
		StackPane.setAlignment(numberOfItemsLabel, Pos.TOP_CENTER);

		target.getChildren().add(numberOfItemsLabel);
	}
	
	/* getters & setters */
	
	public Map<ItemType, Integer> getInventory() {
		return Inventory;
	}

	@Override
	public boolean canReceiveItem(ItemType ofType) {
		
		return true;
	}

	@Override
	public void receiveItem(Item item) {
		if(Inventory.containsKey(item.getType())) {
			Inventory.replace(item.getType(),Inventory.get(item.getType())+1);
			
		}
		else Inventory.put(item.getType(), 1);
		
	}

	@Override
	public void operate() {
		// TODO Auto-generated method stub
		
	}

}