package building;

import building.base.Building;
import building.base.ItemProducer;
import building.base.ItemReceiver;
import item.Item;
import item.ItemType;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import logic.Direction;
import logic.Field;
import ui.BuildingIcon;
import ui.ItemIcon;

public class ConveyorBelt extends ProducingandReceivingBuilding {
	
	private Direction dir;
	private Item item = null, item_receive = null;
	
	@Override
	public void operate() {
		if(item != null && item_receive == null) {
			Building b = Field.instance.getBuildingInFront(dir);
			if(b instanceof ItemReceiver) {
				ItemReceiver ir = (ItemReceiver) b;
				if(ir.canReceiveItem(item.getType())) {
					ir.receiveItem(item);
					item = null;
				}
			}
		}
		else if(item_receive == null && item == null) {
			Building b = Field.instance.getBuildingInBack(dir);			
			if(!(b instanceof ConveyorBelt)) {
				if(b instanceof ItemProducer) {
					ItemProducer ip = (ItemProducer) b;
					if(ip.canProduceItem()) {
						item = ip.getProducedItem();
					}
				}
			}
		}
	}


	public ConveyorBelt(Direction direction) {
		dir = direction;
	}

	
	@Override
	public void beforeCycle() {
		if(item_receive != null && item == null) {
			item = item_receive;
			item_receive = null;			
		}
	}
	
	/* getters & setters */
	public Item getItemOnBelt() {
		if(item == null)	return item_receive;
		if(item_receive == null)return item;
		return null;
	}
	
	public Direction getDirection() {
		return dir;
	}

	@Override
	public void render(StackPane target) {
		
		BuildingIcon icon = new BuildingIcon("file:res/belt.png");
		
		switch(this.getDirection()) {
		case RIGHT:
			icon.setRotate(90);
			break;
		case LEFT:
			icon.setRotate(270);
			break;
		case DOWN:
			icon.setRotate(180);
			break;
		default:
			break;
		}
		
		target.getChildren().add(icon);
		
		Item itemOnBelt = this.getItemOnBelt();
		
		if(itemOnBelt != null) {
			ItemIcon itemIcon = itemOnBelt.getType().toItemIcon();
			StackPane.setAlignment(itemIcon, Pos.TOP_CENTER);
			target.getChildren().add(itemIcon);
		}
	}


	@Override
	public boolean canProduceItem() {
		if(this.item == null) {
			return false;
		}
		return true;
	}


	@Override
	public Item getProducedItem() {
		Item re = item;
		item = null;
		item_receive = null;
		return re;
	}


	@Override
	public boolean canReceiveItem(ItemType item) {
		return (item_receive == null && this.item == null);
	}


	@Override
	public void receiveItem(Item item) {
		item_receive = item;
		this.item = null;
	}
	
}
