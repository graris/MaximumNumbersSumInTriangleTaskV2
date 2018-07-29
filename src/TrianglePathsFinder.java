import java.util.ArrayList;

public class TrianglePathsFinder {
	
	private ArrayList<ArrayList<Integer>> possiblePaths = new ArrayList<ArrayList<Integer>>();
	private int[][] triangle;


	public TrianglePathsFinder(int[][] triangle) {
		
		this.triangle = triangle;
	}

	
	public int findMaxSumAndPath(int[] path) {

		findPossiblePaths(new int[triangle.length], 0, 0, 0);
		
		int maxSum = Integer.MIN_VALUE,
			sum = 0;
		
		for (int i=0;i<possiblePaths.size();i++) {
					
			sum = 0;
			for (int j=0;j<possiblePaths.get(i).size();j++) {
				
				sum += possiblePaths.get(i).get(j);
			}
			
			if (sum > maxSum) {
				
				maxSum = sum;
				
				for (int j=0;j<possiblePaths.get(i).size();j++)
					path[j] = possiblePaths.get(i).get(j);
			}
			
		}
		
		return maxSum;
	}


	private void findPossiblePaths(int[] possiblePath, int pathLength, int nodeXCoord, int nodeYCoord) {

		// if we have reached bottom - stops executing this method
		if (nodeYCoord > triangle.length-1)
			return;
		
		possiblePath[pathLength] = triangle[nodeYCoord][nodeXCoord];
		pathLength++;
		
		// We have reached leaf of the tree (we have finished our 
		// journey to the bottom of triangle), so we can add this 
		// path to possible paths' list
		if ((nodeYCoord + 1) > (triangle.length-1)) {
			
			possiblePaths.add(new ArrayList<Integer>());
			
			for (int i=0; i<possiblePath.length; i++)
				possiblePaths.get(possiblePaths.size()-1).add(possiblePath[i]);
			
			
		} else {
		
			
			if (areBothNumbersNotEvenOrOdd(triangle[nodeYCoord][nodeXCoord], triangle[nodeYCoord+1][nodeXCoord]))
				// move to the left child node
				findPossiblePaths(possiblePath, pathLength, nodeXCoord, nodeYCoord+1);

			if (areBothNumbersNotEvenOrOdd(triangle[nodeYCoord][nodeXCoord], triangle[nodeYCoord+1][nodeXCoord+1]))
				// move to the right child node
				findPossiblePaths(possiblePath, pathLength, nodeXCoord+1, nodeYCoord+1);
		
		}
		
	}
	
	private static boolean areBothNumbersNotEvenOrOdd(int number1, int number2) {

		return (!(isEvenNumber(number1)&&isEvenNumber(number2))
			   &&(!(!isEvenNumber(number1)&&!isEvenNumber(number2))));
		
	}	

	private static boolean isEvenNumber(int number) {

		return number % 2 == 0;
		
	}
}
