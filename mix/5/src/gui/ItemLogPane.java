package gui;
import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ItemLogPane extends StackPane {
	
	private ObservableList<Label> logDataList = FXCollections.observableArrayList();
	private ListView<Label> logListView;
	private int count = 1;
	
	public ItemLogPane() {
		
		setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, SOLID, 
			CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		logListView = new ListView<Label>(logDataList);
		logListView.setPrefWidth(400);
		logListView.setFocusTraversable(false);
		logListView.setPlaceholder(new Label("No Logs"));
		
		getChildren().add(logListView);
	}
	
	public void addData(String itemName, int amountAdded, int totalAmount) {
		Label newLabel; // TODO Adds new Label with specific format
		newLabel = new Label("Log#"+"{"+count+"}"+":"+"{"+amountAdded+"}"+"{"+itemName+"}(s) were added " + 
				"to the inventory ("+"{"+totalAmount+"})");
		logDataList.add(newLabel);
		logListView.scrollTo(newLabel);
		count+=1;
	}

}
