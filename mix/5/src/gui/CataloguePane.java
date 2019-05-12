package gui;





import com.sun.corba.se.spi.orbutil.fsm.Action;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CataloguePane extends GridPane {
	
	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();
	private ItemButton selectedItemButton = null;
	
	public CataloguePane () {
		
		// TODO Implements CataloguePane's constructor
		setAlignment(Pos.CENTER);
		setHgap(10);
		setVgap(10);
		ItemButton Wood = new ItemButton("Wood");
		ItemButton Iron = new ItemButton("Iron");
		ItemButton IronPlate = new ItemButton("Iron Plate");
		ItemButton IronSword = new ItemButton("Iron Sword");
		ItemButton Gem = new ItemButton("Gem");
		ItemButton Other = new ItemButton("Other");
		add(Wood, 0, 0);
		add(Iron, 1, 0);
		add(IronPlate, 2, 0);
		add(IronSword, 0, 1);
		add(Gem, 1, 1);
		add(Other, 2, 1);
		itemButtonList.add(Wood);
		itemButtonList.add(Iron);
		itemButtonList.add(IronPlate);
		itemButtonList.add(IronSword);
		itemButtonList.add(Gem);
		itemButtonList.add(Other);
		
		Wood.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton (Wood);
				selectedItemButton=Wood;
			}
		});
		Iron.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton ( Iron);
				selectedItemButton=Iron;
			}
		});
		IronPlate.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton (IronPlate);
				selectedItemButton=IronPlate;
			}
		});
		IronSword.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton (IronSword);
				selectedItemButton=IronSword;
			}
		});
		Gem.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton (Gem);
				selectedItemButton=Gem;
			}
		});
		Other.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setSelectedButton ( Other);
				selectedItemButton=Other;
			}
		});
		
	} 
	
	public void setSelectedButton ( ItemButton selectedItemButton ) {
		for(ItemButton i :itemButtonList) {
			i.unhighlight();
		}
		selectedItemButton.highlight();
		
		
	
	}
	
	public ItemButton getSelectedButton() {
		return selectedItemButton;

	
	}
	
}
