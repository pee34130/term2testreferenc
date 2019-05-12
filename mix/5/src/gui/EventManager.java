package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class EventManager {

	private BarChartPane barChartPane;
	private ItemLogPane itemLogPane;
	private CataloguePane cataloguePane;

	public EventManager(BarChartPane barChartPane, ItemLogPane itemLogPane, CataloguePane cataloguePane) {
		this.barChartPane = barChartPane;
		this.itemLogPane = itemLogPane;
		this.cataloguePane = cataloguePane;
	}

	public void setUpAddButtonEvent(Button addButton, InputField amountInput) {
		addButton.setOnAction(new AddButtonEventHandler(amountInput));
	}

	private class AddButtonEventHandler implements EventHandler<ActionEvent> {

		private InputField amountInput;

		public AddButtonEventHandler(InputField amountInput) {
			this.amountInput = amountInput;
		}

		@Override
		public void handle(ActionEvent arg0) {
			try {
				if (cataloguePane.getSelectedButton() == null) {
					// TODO Implements an alert
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Please Select An Item To Be Added");
					alert.showAndWait();
				}
				int amount=Integer.parseInt(amountInput.getText());
				if (amount <= 0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Please Fill In Positive Vote Value");
					alert.showAndWait();
				} else {
					//not complete
					String name =cataloguePane.getSelectedButton().getItem();
					// TODO add data to BarChartPane and ItemLogPane
					int total =barChartPane.addItem(name, amount);
					itemLogPane.addData(name, amount,total );
					
				}
			} catch (NumberFormatException e) {
				if (amountInput.getText().equals("")) {
					// TODO Implements an alert
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setContentText("Amount Cannot Be Empty");
					alert.showAndWait();
				} else {
					// TODO Implements an alert
					Alert alert = new Alert(AlertType.ERROR);
					alert.setContentText("Incorrect Vote Format");
					alert.showAndWait();
				}
			}
		}

	}
}
