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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 

public class Maze extends Application {

	 ImageView myImageView;
	 ImageView wallImageView;
	 int x = 0;
	 int y = 0;
	 
	 
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		File file1 = new File("./src/Lab9.1.txt");
		File file2 = new File("./src/Lab9.2.txt");
		
		ArrayList fileArray = new ArrayList();
		fileArray.add(file1);
		fileArray.add(file2);
		
		Random rand = new Random();
		int chosenFile = rand.nextInt(2);
		int chosenMaze = (int) fileArray.get(chosenFile);
		
		Scanner myScanner = new Scanner((Readable) fileArray.get(chosenFile));
		
		while (myScanner.hasNextLine()){
			Scanner lineScan = new Scanner(myScanner.nextLine());
			
		}
		
		Image wall = new Image("file:src/wall.jpg");
		wallImageView = new ImageView(wall);
		wallImageView.setFitWidth(50);
		wallImageView.setFitHeight(50);
		wallImageView.setX(x);
		wallImageView.setY(y);
		
		Image image1 = new Image("file:src/hero.png");
		myImageView = new ImageView(image1);
		myImageView.setFitWidth(50);
		myImageView.setFitHeight(50);
		myImageView.setX(x);
		myImageView.setY(y);
		
		
		
	
		
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