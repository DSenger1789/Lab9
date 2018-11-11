import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

 

public class Maze extends Application {

	 ImageView myImageView;
	 ImageView wallImageView;
	 int x = 0;
	 int y = 0;
	 int read;
	 int col;
	 int row;
	 GridPane myPane = new GridPane();
	 
	 
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage PrimaryStage) throws Exception {
		
		
		File file1 = new File("./src/Lab9.1.txt");
		File file2 = new File("./src/Lab9.2.txt");
		
		File fileArray [] = new File[2];
		fileArray[0] = file1;
		fileArray[1] = file2;
		
		Random rand = new Random();
		int chosenFile = rand.nextInt(2);
		File chosenMaze = fileArray[chosenFile];
		
		BufferedReader buffer = new BufferedReader(new FileReader("./src/Lab9.1.txt"));
		
	     int [][] wallArray = null;
		
	     int row1 = 0;
	     int size = 0;
	     
	     String line;
	     
	     while ((line = buffer.readLine()) !=null) {
	    	 String[] vals = line.trim().split("\\s+");
	    	 
	    	 if (wallArray == null) {
	    		 size = vals.length;
	    		 wallArray = new int[size][size];
	    	 }
	    	 for (col = 0; col < size; col++) {
	    		 wallArray[row][col] = Integer.parseInt(vals[col]);
	    	 }
	    	 row++;
	     }
	     
		Scanner myScanner = new Scanner(chosenMaze);
		
		String str = "";
		int size1 = wallArray.length;
		
		if (wallArray != null) {
			for (int row = 0; row < size; row++) {
				str += " ";
				for (col = 0; col <size; col++) {
					str += String.format("%2d", wallArray[row][col]);
					if (col < size -1) {
						str += " | ";
					}
				}
				if (row < size - 1) {
					str += "+";
					for (col = 0; col<size; col++) {
						for (int i =0; i<4; i++) {
							str += "-";
						}
						if (col<size-1) {
							str += "+";
						}
					}
					str+= "\n";
				} else{
					str +="\n";
				}
			}
		}
		
		System.out.println(str);
		
		/*while (myScanner.hasNextLine()){
			String line = myScanner.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(" ");
		
			while (lineScan.hasNext()) {
				read = lineScan.nextInt();
				col = read;
				col++;
				
			
				x=x+10;
				if (read == 0) {
					
				//do nothing	
				}			
			}
			y = y +1;
			
		}*/
		Image wall = new Image("file:src/wall.jpg");
		wallImageView = new ImageView(wall);
		wallImageView.setFitWidth(50);
		wallImageView.setFitHeight(50);
		myPane.add(wallImageView, x, y);
		System.out.println("Something");
		
		
		Image image1 = new Image("file:src/hero.png");
		myImageView = new ImageView(image1);
		myImageView.setFitWidth(50);
		myImageView.setFitHeight(50);
		myImageView.setX(x);
		myImageView.setY(y);
		
		
		
		Image image = new Image("file:src/maze_background.jpg");
		ImagePattern pattern = new ImagePattern(image);
		
		
		
	
		
		Group root = new Group(myImageView);
		Scene scene = new Scene(root,500,500,Color.WHITE);
		scene.setFill(pattern);
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