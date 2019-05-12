package building.base;

import item.Item;
import item.ItemType;

public interface ItemProducer {
	// delete the following line and FILL CODE
	public boolean canProduceItem();
	public Item getProducedItem() ;
}
