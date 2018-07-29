import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDataReader {
	
	String filePath;
	
	public FileDataReader(String filePath) {
		
		this.filePath = filePath;
	}
	
	public int[][] readInputFromFileTo2dArray(int[][] triangle) {
		
		File triangleFile = new File(filePath);
		
		BufferedReader bufReader;
		try {
		    String line;
		    
		    bufReader = new BufferedReader(new FileReader(triangleFile));
		    int i = 0;
		    while ((line = bufReader.readLine()) != null) {
		        String[] triangleElementsValues = line.split(" ");
		        
		        int j = 0;
		        for(String value: triangleElementsValues) {
		        	
		        	triangle[i][j] = Integer.parseInt(value);		   
		        	j++;
		        }
		        i++;
		    }
		} catch (IOException e) {

			e.printStackTrace();
		}
		return triangle;
	}



	public int getLinesNumberInFile(int triangleSize) {
		
		File triangleFile = new File(filePath);
		
		BufferedReader bufReader = null;
		try {
			bufReader  = new BufferedReader(new FileReader(triangleFile));
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		
		try {
			while ((bufReader.readLine()) != null) {
				triangleSize++;
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return triangleSize;
	}


}
