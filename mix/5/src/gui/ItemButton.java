package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ItemButton extends Button {
	
	private String item;
	
	public ItemButton (String item) {
		this.item=item;
		
		// TODO Completes ItemButton's constructor
		setPadding(new Insets(5));

		setBorder(new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		String url;
		switch(item) {
			case "Wood" : url = "Wood.png"; break;
			case "Iron" : url = "Iron_ore.png"; break;
			case "Iron Plate" : url = "Iron_plate.png"; break;
			case "Iron Sword" : url = "Iron_Sword.png"; break;
			case "Gem"	: url = "Gem.png"; break;
			default : url = "Other.png";
		}
		String impPath = ClassLoader.getSystemResource("img/"+url).toString();
		//String impPath = ClassLoader.getSystemResource(url).toString();
		//setGraphic(new ImageView(impPath));
		ImageView imageView = new ImageView(new Image(impPath));
		//setGraphic(new ImageView("file:./res/"+url));
		setGraphic(imageView);
		
				
	}
	
	public void highlight() {
		
		setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));

	}
	
	public void unhighlight() {

		setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
	}
	
	public String getItem() {
		return this.item;
	}
	
}
