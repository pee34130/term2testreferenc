package gui;

import static javafx.scene.layout.BorderStrokeStyle.SOLID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class BarChartPane extends VBox {

	private ObservableList<Data<String, Number>> barChartDataList = FXCollections.observableArrayList();;
	
	public BarChartPane () {
		
		// TODO Implements BarChartPane's contructor
		setAlignment(Pos.TOP_CENTER);
		setWidth(400);
		setPadding(new Insets(10));
		setSpacing(10);
		getChildren().addAll(createHeaderLabel(),createBarChart());

		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, SOLID, 
		CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}
	
	public int addItem(String item, int amount) {
				int ans; 
		for(Data i :barChartDataList) {
			if(item.equals(i.getXValue())) {
				ans =amount+Integer.parseInt(i.getYValue().toString());
			i.setYValue(ans);
			  return ans;
			}
	
			
		}
		return -1;


		// TODO Implements addItem(String item, int amount)

	}
	
	public Label createHeaderLabel() {
		
		Label header =new Label("Item Summary");
		header.setFont(Font.font(24));
		return header;

	}
	
	public BarChart<String, Number> createBarChart() {
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		String Wood = "Wood";
		String Iron = "Iron";
		String IronPlate = "Iron Plate";
		String IronSword = "Iron Sword";
		String Gem = "Gem";
		String Other = "Other";	
		barChartDataList.add(new Data(Wood,0));
	    barChartDataList.add(new Data(Iron,0));
	    barChartDataList.add(new Data(IronPlate, 0));
	    barChartDataList.add(new Data(IronSword, 0));
	    barChartDataList.add(new Data(Gem, 0));      
	    barChartDataList.add(new Data(Other, 0));

		BarChart<String,Number> chart =  new BarChart<String,Number>(xAxis,yAxis);
	
		XYChart.Series series1 = new XYChart.Series(barChartDataList);
		xAxis.setLabel("Item");  
	       
	    yAxis.setLabel("Amount"); 
          
       /* series1.getData().add(new XYChart.Data(Wood,0));
        series1.getData().add(new XYChart.Data(Iron,0));
        series1.getData().add(new XYChart.Data(IronPlate, 0));
        series1.getData().add(new XYChart.Data(IronSword, 0));
        series1.getData().add(new XYChart.Data(Gem, 0));      
        series1.getData().add(new XYChart.Data(Other, 0)); */
	    chart.getData().add(series1);
	    chart.setLegendVisible(false);
        
        return chart;
	}
	
}
