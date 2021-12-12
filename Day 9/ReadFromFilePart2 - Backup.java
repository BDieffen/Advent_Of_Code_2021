import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class ReadFromFilePart2 {
	public static void main(String[] args) throws Exception {

		try{
//		FileReader reader = new FileReader("Code Input.txt");
		FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		List<String> inputLines = new ArrayList<String>();
		int finalSum = 0;
		int finalNumber = 0;
		int basinNum = 1;
		
		while((line = bufferedReader.readLine()) != null){
			//String[] lineStuff = line.split(" ");
			inputLines.add(line);
		}
		reader.close();

		int[][] grid = new int[inputLines.size()][inputLines.get(0).length()];
		int[][] gridCompare = new int[inputLines.size()][inputLines.get(0).length()];

		// CREATE THE GRID
		for(int i = 0; i<inputLines.size(); i++){
			String[] newLine = inputLines.get(i).split("");
			for(int j = 0; j<newLine.length; j++){
				grid[i][j] = Integer.parseInt(newLine[j]);
				gridCompare[i][j] = -1;
			}
		}

		// PRINTS GRID
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
//				System.out.print(grid[i][j]);

				// MARK ALL 9s ON THE COMPARE MAP
				if(grid[i][j] == 9){
					gridCompare[i][j] = 0;
				}
			}
//			System.out.println();
		}

		// DOES CALCULATIONS
		for(int i = 0; i<grid.length; i++){
			for(int j = 0; j<grid[i].length; j++){
				if(gridCompare[i][j] != 0){
					if(gridCompare[i][j] < 0){
						basinNum++;
						gridCompare[i][j] = basinNum;
					}
					if(i == 0){
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}
						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}
						}
					}else if(i == grid.length-1){
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
						}
					}else{
	
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}

						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = basinNum;
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = basinNum;
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = basinNum;
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = basinNum;
							}
						}
					}
				}
			}
		}





		// PRINTS GRIDCOMPARE
		for(int i = 0; i<gridCompare.length; i++){
			for(int j = 0; j<gridCompare[i].length; j++){
				System.out.print(gridCompare[i][j] + " ");
			}
			System.out.println();
		}


		// PRINT OUT FINAL SUM
		System.out.println("Final number: " + finalNumber);

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