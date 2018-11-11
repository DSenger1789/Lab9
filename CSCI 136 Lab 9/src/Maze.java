import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 

public class Maze extends Application {
	
	
	 ImageView myImageView;
	 ImageView wallImageView;
	 int x = 0;
	 int y = 0;
	 int read;
	 GridPane myPane = new GridPane();
	 Scanner myScanner;
	 
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		File file1 = new File("./src/Lab9.1.txt");
		File file2 = new File("./src/Lab9.2.txt");
		
		ArrayList fileArray = new ArrayList();
		
		
		
		Random rand = new Random();
		int chosenFile = rand.nextInt(2);
		if (chosenFile == 0) {
			fileArray.add(file1);
			myScanner = new Scanner(file1);
		}
		else {
			fileArray.add(file2);
			myScanner = new Scanner(file2);
		}
		
		ArrayList<ImageView> wallArray = new ArrayList();
		
		
		
		Image image1 = new Image("file:src/hero.png");
		myImageView = new ImageView(image1);
		myImageView.setFitWidth(50);
		myImageView.setFitHeight(50);
		myImageView.setX(x);
		myImageView.setY(y);
		
		
		while (myScanner.hasNextLine()){
			String line = myScanner.nextLine();
			Scanner lineScan = new Scanner(line);
			//lineScan.useDelimiter(" ");
			while (lineScan.hasNext()) {
				read = lineScan.nextInt();	
				System.out.println(read);
				if (read == 1) {
					Image wall = new Image("file:src/wall.jpg");
					wallImageView = new ImageView(wall);
					wallImageView.setFitWidth(50);
					wallImageView.setFitHeight(50);
					wallImageView.setX(x);
					wallImageView.setY(y);
					wallArray.add(wallImageView);
				}
			
				x=x+10;
				if (read == 0) {
					
				//do nothing	
				}			
			}
			y = y +1;
			
		}
		
		//myPane.add(wallImageView, 10, 10);
		System.out.println("Something");
		
		
		
		
		
		
		myPane.add(myImageView, x, y);
		
		Group root = new Group(myImageView);
		Scene scene = new Scene(root,500,500,Color.WHITE);
		PrimaryStage.setTitle("MAZE");
		scene.setOnKeyPressed(this::listenUp);
		PrimaryStage.setScene(scene);
		PrimaryStage.show();
		
	}
	
	public void listenUp(KeyEvent event)
	{
		KeyCode myCode = event.getCode();
		
		if(myCode == KeyCode.A)
		{
			myImageView.setX(x-=10);
			
			
		}
		else if(myCode == KeyCode.D)
		{
			myImageView.setX(x+=10);
			
		}
		else if(myCode == KeyCode.S)
		{
			myImageView.setY(y+=10);
				
		}
		else if(myCode == KeyCode.W)
		{
			myImageView.setY(y-=10);
	
		}
		
		
	

	}
	
}