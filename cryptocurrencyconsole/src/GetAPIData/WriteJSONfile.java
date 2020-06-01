package GetAPIData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteJSONfile {
	
	public static void writeFile(ArrayList<String> data) {
    try {
        FileWriter myWriter = new FileWriter("R:\\nomics\\output.json");
		for(String item : data) {
			myWriter.write(item);
		}
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
  }

