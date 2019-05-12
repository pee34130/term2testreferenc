package gui;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class InputField extends VBox {
	
	private TextField textField;
	
	public InputField(String title, String promptText) {
		Label Title = new Label(title);
		Title.setFont(Font.font(18));
		textField = new TextField(promptText);
		setAlignment(Pos.CENTER);
		setPadding(new Insets(10));
		setSpacing(10);
		getChildren().addAll(Title,textField);
		
		
		
	}

	public String getText() {

		return textField.getText();
	}
	
}
