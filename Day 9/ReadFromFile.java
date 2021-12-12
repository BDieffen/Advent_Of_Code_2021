import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class ReadFromFile {
	public static void main(String[] args) throws Exception {

		try{
		FileReader reader = new FileReader("Code Input.txt");
//		FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		List<String> inputLines = new ArrayList<String>();
		int finalSum = 0;
		
		while((line = bufferedReader.readLine()) != null){
			//String[] lineStuff = line.split(" ");
			inputLines.add(line);
		}
		reader.close();

		int[][] grid = new int[inputLines.size()][inputLines.get(0).length()];

		// CREATE THE GRID
		for(int i = 0; i<inputLines.size(); i++){
			String[] newLine = inputLines.get(i).split("");
			for(int j = 0; j<newLine.length; j++){
				grid[i][j] = Integer.parseInt(newLine[j]);
			}
		}

		// PRINTS GRID
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}

		// DOES CALCULATIONS
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
				if(i == 0){
					if(j == 0){
						if(smallest(grid[i][j],grid[i][j+1],grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else if(j == grid[i].length-1){
						if(smallest(grid[i][j],grid[i][j-1],grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else{	
						if(smallest(grid[i][j],grid[i][j-1],grid[i][j+1],grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}
				}else if(i == grid.length-1){
					if(j == 0){
						if(smallest(grid[i][j],grid[i][j+1],grid[i-1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else if(j == grid[i].length-1){
						if(smallest(grid[i][j],grid[i][j-1],grid[i-1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else{	
						if(smallest(grid[i][j],grid[i][j-1],grid[i][j+1],grid[i-1][j])){
							finalSum += grid[i][j] + 1;
						}
					}
				}else{

					if(j == 0){
						if(smallest(grid[i][j],grid[i][j+1],grid[i-1][j], grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else if(j == grid[i].length-1){
						if(smallest(grid[i][j],grid[i][j-1],grid[i-1][j], grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}else{	
						if(smallest(grid[i][j],grid[i][j-1],grid[i][j+1],grid[i-1][j], grid[i+1][j])){
							finalSum += grid[i][j] + 1;
						}
					}
				}
			}
		}



		// PRINT OUT FINAL SUM
		System.out.println("Final sum: " + finalSum);

		}
		catch (IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
	    	}
	}


	public static Boolean smallest(int inQuestion, int a, int b){
		if(inQuestion < a && inQuestion < b){
			return true;
		}else return false;
	}
	public static Boolean smallest(int inQuestion, int a, int b, int c){
		if(inQuestion < a && inQuestion < b && inQuestion < c){
			return true;
		}else return false;
	}
	public static Boolean smallest(int inQuestion, int a, int b, int c, int d){
		if(inQuestion < a && inQuestion < b && inQuestion < c && inQuestion < d){
			return true;
		}else return false;
	}

}