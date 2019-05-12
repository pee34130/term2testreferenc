package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import building.Chest;
import building.ConveyorBelt;
import building.ProducingandReceivingBuilding;
import item.Item;
import item.ItemType;
import logic.Direction;
import logic.Field;
import logic.GameState;
import test.base.GameTest;

public class TestConveyorBeltOnField extends GameTest {
	@Test
	void testConveyorBeltMoveOneItemToRightPerUpdate() {
		ConveyorBelt cb1 = new ConveyorBelt(Direction.RIGHT);
		ConveyorBelt cb2 = new ConveyorBelt(Direction.RIGHT);
		ConveyorBelt cb3 = new ConveyorBelt(Direction.RIGHT);
		ConveyorBelt cb4 = new ConveyorBelt(Direction.RIGHT);
		Field.instance.at(1, 0).placeBuildingOnCell(cb1);
		Field.instance.at(2, 0).placeBuildingOnCell(cb2);
		Field.instance.at(3, 0).placeBuildingOnCell(cb3);
		Field.instance.at(4, 0).placeBuildingOnCell(cb4);
		
		
		cb1.receiveItem(Item.wood());
		//GameState.instance.update();
		assertNotNull(cb1.getItemOnBelt());
		//assertFalse(cb1.canProduceItem());

		GameState.instance.update();
		//assertNull(cb1.getItemOnBelt());
		assertNull(cb1.getItemOnBelt());
		assertNotNull(cb2.getItemOnBelt());
		//assertNull(cb3.getItemOnBelt());//
		//assertTrue(cb3.canReceiveItem(cb2.getItemOnBelt().getType()));
		//assertFalse(cb2.canReceiveItem(cb1.getItemOnBelt().getType()));
		assertNull(cb3.getItemOnBelt());
		assertFalse(cb1.canProduceItem());
		//assertTrue(cb2.getDelay());
		assertFalse(cb2.canProduceItem());
		GameState.instance.update();
		assertNull(cb2.getItemOnBelt());
		assertFalse(cb3.canProduceItem());
		assertNotNull(cb3.getItemOnBelt());
	}

	@Test
	void testConveyorBeltCanInsertItemToBuilding() {
		Chest chest = new Chest();
		ConveyorBelt cb1 = new ConveyorBelt(Direction.RIGHT);
		Field.instance.at(0, 0).placeBuildingOnCell(cb1);
		Field.instance.at(1, 0).placeBuildingOnCell(chest);
		
		cb1.receiveItem(Item.wood());
		GameState.instance.update();
		GameState.instance.update();
		assertNull(cb1.getItemOnBelt());
		assertEquals((int) chest.getInventory().get(ItemType.WOOD), 1);
	}
}