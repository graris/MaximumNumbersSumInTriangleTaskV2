import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		int triangleSize = 0;
		int[][] triangle = null;
				    
		String triangleFilePathName = "triangle.txt";
		
		FileDataReader fileDataReader = new FileDataReader(triangleFilePathName);
		
		triangleSize = fileDataReader.getLinesNumberInFile(triangleSize);
	      
	    triangle = new int[triangleSize][triangleSize];
		
		triangle = fileDataReader.readInputFromFileTo2dArray(triangle);		
		
		TrianglePathsFinder trianglePathsFinder = new TrianglePathsFinder(triangle);
		
		int[] path = new int[triangle.length];
		int maxSum = trianglePathsFinder.findMaxSumAndPath(path);		
		
		printMaxSumAndPath(path, maxSum);
		
	}


	private static void printMaxSumAndPath(int[] path, int maxSum) {
		System.out.print("Max Sum: " + maxSum);
		
		System.out.print("\nPath: ");
		for (int i=0;i<path.length;i++) {
			
			System.out.print(path[i]);
			if(i!=path.length-1) 
				System.out.print(", ");
			
		}
	}
	
}
