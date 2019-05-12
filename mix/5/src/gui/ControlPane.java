package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ControlPane extends VBox {
	
	private CataloguePane catalogue;
	private InputField amountInputField;
	private Button addButton;
	
	public ControlPane () {

		// TODO Implements CataloguePane's constructor
		setAlignment(Pos.CENTER);
		setSpacing(15);
		setWidth(200);
		Label catalogueTitle = new Label("Choose an item");
		catalogueTitle.setFont(Font.font(18));
		catalogue =new CataloguePane();
		amountInputField = new InputField("Amount to add", "Input number here");
		addButton= new Button("add");
		addButton.setMaxWidth(150);
		this.getChildren().addAll(catalogueTitle,catalogue,amountInputField,addButton);

		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}

	public CataloguePane getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(CataloguePane catalogue) {
		this.catalogue = catalogue;
	}

	public InputField getAmountInputField() {
		return amountInputField;
	}

	public void setAmountInputField(InputField amountInputField) {
		this.amountInputField = amountInputField;
	}

	public Button getAddButton() {
		return addButton;
	}

	public void setAddButton(Button addButton) {
		this.addButton = addButton;
	}
	
	// TODO Implements getters for each field
	

}
