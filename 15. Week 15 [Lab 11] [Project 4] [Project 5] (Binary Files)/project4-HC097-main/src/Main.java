/**
 *Project 4: GUIs
 *
 * @author Harley Combest
 * @version 1.0
 * */
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.sun.javafx.tk.Toolkit;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;



// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main extends Application{
	
	/** The file name. */
	private String fileName = "Mesonet.txt";

	//Here you can write your custom methods

	/**
	 * This method takes the data from a txt file and parses it out into a list of strings.
	 *
	 * @return ArrayList<String> stIDs: ArrayList of strings from txt file.
	 */
	public ArrayList<String> txtToList() {
		
		String fileName = this.fileName;
		
		ArrayList<String> stIDs = new ArrayList<String>();
        try{
            Scanner input = new Scanner(fileName);
            File file = new File(input.nextLine());
            input = new Scanner(file);

            while(input.hasNextLine()){

                String line = input.nextLine();       
                stIDs.add(line);
                

            }input.close();
            
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return stIDs;
    }
	
	
	/**
	 * This method gets the hamming distances between existing station IDs and a given station ID and returns an ArrayList of the stIDs at hamming distances from 0 to 4.
	 *
	 * @param stID the st ID
	 * @return ArrayList<ArrayList<String>> distances: an ArrayList of String ArrayLists containing station IDs by corresponding hamming distances
	 */
	public ArrayList<ArrayList<String>> hammingDistances(String stID) {
		
		ArrayList<String> temp = txtToList();
		
		if(temp.contains(stID)) {
			//do nothing
		}else {
			temp.add(stID);
		}
		
		ArrayList<ArrayList<String>> distances = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> dist0 = new ArrayList<String>();
		ArrayList<String> dist1 = new ArrayList<String>();
		ArrayList<String> dist2 = new ArrayList<String>();
		ArrayList<String> dist3 = new ArrayList<String>();
		ArrayList<String> dist4 = new ArrayList<String>();
		
		int hamDist = 0;
		
		for(int i = 0; i < temp.size(); i++) {
			
			String strTemp = temp.get(i);
			hamDist = hammingDistance(stID, strTemp);
			
			if(hamDist == 0) {
				dist0.add(strTemp);
			}else if(hamDist == 1) {
				dist1.add(strTemp);
			}else if(hamDist == 2) {
				dist2.add(strTemp);
			}else if(hamDist == 3) {
				dist3.add(strTemp);
			}else if(hamDist == 4) {
				dist4.add(strTemp);
			}else {
				System.out.print("method hammingDistances() has met failure");
			}
			
		}
		
		Collections.sort(dist0);
		distances.add(dist0);
		Collections.sort(dist1);
		distances.add(dist1);
		Collections.sort(dist2);
		distances.add(dist2);
		Collections.sort(dist3);
		distances.add(dist3);
		Collections.sort(dist4);
		distances.add(dist4);
		
		return distances;
	}
	
	/**
	 * This method gets the hamming distance bewteen two strings of equal length.
	 *
	 * @param stID1 the st ID 1
	 * @param stID2 the st ID 2
	 * @return int hamDist: the hamming distance between two strings
	 */
	public int hammingDistance(String stID1, String stID2) {
		
		int i = 0;
		int hamDist = 0;
		
		while(i <  stID1.length()) {
			if(stID1.charAt(i) != stID2.charAt(i)) {
				hamDist++;
			}
			i++;
		}
		
		return hamDist;
	}
	
	/**
	 * This method acts as a print statement testing ground.
	 */
	public void test() {
		
		//For txtToList()		
		txtToList();

		//For hammingDistance()
		String testSt = "ZERO";
		hammingDistance(testSt, "BEAV");
		
		//For hammingDistances()
		ArrayList<ArrayList<String>> distancesOfTest = hammingDistances(testSt);
		distancesOfTest.get(3);
		
	}
	
	/** This method returns the nth term in the Fibonacci sequence.
	 * 
	 * @param n the term index
	 * @return the nth Fibonacci number
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public int fibonacci(int n) {
		
		if(n < 0) {
			throw new IllegalArgumentException("");
		}
		
		if(n == 0 || n == 1) {
			return n;
		}else {
			//System.out.println(fibonacci(n-1) + fibonacci(n-2));
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
		  
		//return 0;
	}
	
	
	
	/**
	 * Start.
	 *
	 * @param primaryStage the primary stage
	 */
	// Here to start
	public void start(Stage primaryStage) {
		try {

			//Your code...

			GridPane grid = new GridPane();

			grid.setAlignment(Pos.TOP_LEFT);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			
			Scene scene = new Scene(grid, 1000, 1000);

			primaryStage.setTitle("JavaFX Graphics");
			primaryStage.setScene(scene);
			primaryStage.show();




			//Your code... this is the main part where you can write all of your code.
			test();
			ArrayList<String> stationIDs = txtToList();
			
			Label stationID = new Label("Choose Station ID:");
			ComboBox compareWithStation = new ComboBox(FXCollections.observableArrayList(stationIDs));
			
			Label enterHamDist = new Label("Enter Hamming Distance: ");
			Label hamDistVal = new Label(" ");
			//making hamDistVal seen
			hamDistVal.setTextFill(Color.BLACK);
			
			
			Slider hamDistSlider = new Slider();
			
			hamDistSlider.setMin(0);
			hamDistSlider.setMax(4);
			hamDistSlider.setValue(2);
			
			hamDistSlider.setOrientation(Orientation.HORIZONTAL);
		    hamDistSlider.setMaxWidth(700);
		    //Tick marks and increments
		    hamDistSlider.setShowTickMarks(true);
		    hamDistSlider.setShowTickLabels(true);
		    hamDistSlider.setMajorTickUnit(1.0f);
		    hamDistSlider.setBlockIncrement(1.0f);
		    //Knob movement in regards to exact integers
		    hamDistSlider.valueProperty().addListener((obs, oldval, newVal) -> 
		    hamDistSlider.setValue(newVal.intValue()));
		    
		    Button showStation = new Button("Show Station(s)");
		    ListView stationsList = new ListView();
		    //stationsList.setPrefHeight(200);
		   
		    Button showDistances = new Button("Hamming Distance Distribution");
		    ListView hammingDistances = new ListView();
		    //hammingDistances.setPrefHeight(150);
		    
		    ObservableList<PieChart.Data>pieChartData = FXCollections.observableArrayList();
		    final PieChart chart = new PieChart(pieChartData);
              	chart.setTitle("Hammer Distance Distribution");
		    
		    Button addStID = new Button("Add Station ID");
		    TextField stationText = new TextField();
		    
		    Label enterIndex = new Label("Enter the nth term of the Fibonacci sequence (PROCEED SLOWLY): ");
		    
		    Slider indexTerms = new Slider(0, 50, 0);
		    
		    indexTerms.setOrientation(Orientation.HORIZONTAL);
		    indexTerms.setMaxWidth(700);
		    indexTerms.setPrefWidth(300);
		    
		    indexTerms.setShowTickMarks(true);
		    indexTerms.setShowTickLabels(true);
		    indexTerms.setMajorTickUnit(5.0);
		    indexTerms.setBlockIncrement(1.0);
		    
		    ListView numberInTerm = new ListView();
	
		    NumberAxis xAxis = new NumberAxis();
		    xAxis.setLabel("nth Term");
		    
		    NumberAxis yAxis = new NumberAxis();
		    yAxis.setLabel("Fibbonaci #");
		    
		    LineChart lineChart = new LineChart(xAxis, yAxis);
		    Button resetChart = new Button("Reset");
		    
		    
		    EventHandler<ActionEvent> addStationID = new EventHandler<ActionEvent>() {
            	public void handle(ActionEvent h) {
            		
            		String tempStation = stationText.getText();
            		compareWithStation.getItems().addAll(
            			    tempStation
            			);
            	
            		stationText.clear();
            	}
            };
            
            addStID.setOnAction(addStationID);
		    
		    EventHandler<ActionEvent> choosingAStation = 
	                  new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	
	            	
	            	//value label change in regards to knob movement
	            	hamDistSlider.valueProperty().addListener( 
	   		             new ChangeListener<Number>() { 
	   		          	 
	   		            public void changed(ObservableValue <? extends Number >  
	   		                      observable, Number oldValue, Number newValue) 
	   		            { 
	   		            	
	   		                hamDistVal.setText("                                              " + newValue); 
	   		                int index = (int) hamDistSlider.getValue();
	   		                
	   		                String tempStation = String.valueOf(compareWithStation.getValue());
	   		                
	   		                EventHandler<ActionEvent> showStationPressed = new EventHandler<ActionEvent>() {
	   		                	public void handle(ActionEvent f) {
	   		                		stationsList.getItems().clear();
	   		                		ArrayList<String> stationsOfDistance;
	   		                		hammingDistances(tempStation);
	   		                		stationsOfDistance = hammingDistances(tempStation).get(index);
	   		   		                for(int i = 0; i < stationsOfDistance.size(); i++) {
	   		   		                	stationsList.getItems().add(stationsOfDistance.get(i));
	   		   		                }
	   		   		               
	   		                	}
	   		                };
	   		                
	   		                showStation.setOnAction(showStationPressed);
	   		                
	   		                EventHandler<ActionEvent> calculateHammingDistances = new EventHandler<ActionEvent>() {
	   		                	public void handle(ActionEvent g) {
	   		                		hammingDistances.getItems().clear();
	   		                			   		               		
	   		                		ArrayList<ArrayList<String>> distributionsOfDistance;
	   		                		distributionsOfDistance = hammingDistances(tempStation);
	   		   		                for(int i = 0; i < distributionsOfDistance.size(); i++) {
	   		   		                	hammingDistances.getItems().add("Distance " + i +" - "+ distributionsOfDistance.get(i).size());
	   		   		             
	   		   		                }
	   		   		                
	   		   		                pieChartData.clear();
	   		   		                pieChartData.add(new PieChart.Data("Distance " + 0, distributionsOfDistance.get(0).size()));
	   		   		                pieChartData.add(new PieChart.Data("Distance " + 1, distributionsOfDistance.get(1).size()));
	   		   		                pieChartData.add(new PieChart.Data("Distance " + 2, distributionsOfDistance.get(2).size()));
	   		   		                pieChartData.add(new PieChart.Data("Distance " + 3, distributionsOfDistance.get(3).size()));
	   		   		                pieChartData.add(new PieChart.Data("Distance " + 4, distributionsOfDistance.get(4).size()));
	   		   		                
	   		   		                
	   		                	}
	   		                	
	   		                		
	   		                };
	   		                		
	   		                showDistances.setOnAction(calculateHammingDistances);
	   		                
	   		                
	   		            }
	   		        
	   		            
	   		         
	   		      });
	            	
	            	
	            	
	            } 
	        };
	        
	        
	        compareWithStation.setOnAction(choosingAStation);
	        
	        
	        //Fibonacci Calulation slider by index
	        indexTerms.valueProperty().addListener( 
  		             new ChangeListener<Number>() { 
  		          	 
  		            public void changed(ObservableValue <? extends Number >  
  		                      observable, Number oldValue, Number newValue) 
  		            { 
  		            	int index = (int) indexTerms.getValue();
  		            	int fibonacciNumber = fibonacci(index);
  		            	numberInTerm.getItems().add(fibonacciNumber + " is the number at the " + index + "th index of the Fibonnaci Sequence");
  		            	XYChart.Series series = new XYChart.Series();
  		            	series.setName("Fibonacci Sequence");
  		            	series.getData().add(new XYChart.Data(index, fibonacciNumber));
  		                lineChart.getData().add(index, series);
  		                
  		              EventHandler<ActionEvent> resetPressed = new EventHandler<ActionEvent>() {
 		                	public void handle(ActionEvent h) {
 		                		series.getData().removeAll(Collections.singleton(lineChart.getData().setAll())); 
 		                		numberInTerm.getItems().clear();
 		                		indexTerms.setValue(0);
 		                		
 		                		stationsList.getItems().clear();
 		 		                hammingDistances.getItems().clear();
 		 		                pieChartData.clear();
 		 		                	                
 		                	}
 		                };
 		                
 		                resetChart.setOnAction(resetPressed);
 		                 		            
  		            }
  		        
  		            
  		         
  		      });
	        
		    
		   
		    grid.add(stationID, 0, 0);
		    grid.add(compareWithStation, 0, 1);
		    grid.add(enterHamDist, 0, 2);
		    grid.add(hamDistVal, 0, 2);
		    grid.add(hamDistSlider, 0, 4);
		    grid.add(showStation, 0, 5);
		    grid.add(stationsList, 0, 6);
		    grid.add(showDistances, 0, 7);
		    grid.add(hammingDistances, 0, 8);
		    grid.add(addStID, 0, 9);
		    grid.add(stationText, 0, 10);
		    
		    grid.add(enterIndex, 20, 0);
		    grid.add(indexTerms, 20, 2);
		    grid.add(numberInTerm, 20, 4);
		    grid.add(lineChart, 20, 6);
		    grid.add(chart, 20, 8);
		    grid.add(resetChart, 20, 10);
		    
		    
			
			
			
			

		}
		catch (
		Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// Launch application
	public static void main(String[] args) {
		launch(args);
	}
}
