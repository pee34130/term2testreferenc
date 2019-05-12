package main;

import gui.BarChartPane;
import gui.CataloguePane;
import gui.ControlPane;
import gui.EventManager;
import gui.ItemLogPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	private BarChartPane barChartPane = new BarChartPane();
	private ItemLogPane itemLogPane = new ItemLogPane();
	private ControlPane controlpane = new ControlPane();
	private EventManager manage;
	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		root.setPrefHeight(500);
		root.setMaxHeight(500);
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		manage = new EventManager(barChartPane, itemLogPane, controlpane.getCatalogue());
		manage.setUpAddButtonEvent(controlpane.getAddButton(), controlpane.getAmountInputField());
		root.getChildren().addAll(controlpane,barChartPane,itemLogPane);
		Scene scene = new Scene(root,1000,500);
		primaryStage.setTitle("Blacksmith's Inventory Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
		// TODO Implement Main
		
	}
	
	public static void main (String [] args) {
		launch(args);
	}
}
