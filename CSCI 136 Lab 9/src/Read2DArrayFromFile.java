import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Read2DArrayFromFile {
    public static int[][] create2DIntwallArrayFromFile(String filename) throws Exception {
        int[][] wallArray = null;

        // If included in an Eclipse project.
      
        // If in the same directory - Probably in your case...
        // Just comment out the 2 lines above this and uncomment the line
        // that follows.
        BufferedReader buffer = new BufferedReader(new FileReader("./src/Lab9.1.txt"));

        String line;
        int row = 0;
        int size = 0;

        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");

            // Lazy instantiation.
            if (wallArray == null) {
                size = vals.length;
                wallArray = new int[size][size];
            }

            for (int col = 0; col < size; col++) {
                wallArray[row][col] = Integer.parseInt(vals[col]);
            }

            row++;
        }

        return wallArray;
    }

    public static void printwallArray(int[][] wallArray) {
        String str = "";
        int size = wallArray.length;

        if (wallArray != null) {
            for (int row = 0; row < size; row++) {
                str += " ";
                for (int col = 0; col < size; col++) {
                    str += String.format("%2d",  wallArray[row][col]);
                    if (col < size - 1) {
                        str += " | ";
                    }
                }
                if (row < size - 1) {
                    str += "\n";
                    for (int col = 0; col < size; col++) {
                        for (int i = 0; i < 4; i++) {
                            str += "-";
                        }
                        if (col < size - 1) {
                            str += "+";
                        }
                    }
                    str += "\n";
                } else {
                    str += "\n";
                }
            }
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        int[][] wallArray = null;

        try {
            wallArray = create2DIntwallArrayFromFile("square.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        printwallArray(wallArray);
    }
}