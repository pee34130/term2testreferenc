package gui;

import org.omg.CORBA.PRIVATE_MEMBER;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
//import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sun.net.www.http.PosterOutputStream;

public class TimerGUI extends VBox{

	// implement your code here
	private Label nameLabel;
	private DisplayPart displayPart ;
	private ControlPart controlPart;

	public TimerGUI(String name) {
		
		

		nameLabel =new Label(name);
		nameLabel.setFont(new Font(22));
		displayPart = new DisplayPart();
		controlPart = new ControlPart();
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10));
		setSpacing(10);
		getChildren().addAll(nameLabel,displayPart,controlPart);
	}
	
	public String getName() {

		return nameLabel.getText().trim();
		
	}

	public DisplayPart getDisplayPart() {
		return displayPart;
	}

	public ControlPart getControlPart() {
		return controlPart;
	}
	

	
	
}
