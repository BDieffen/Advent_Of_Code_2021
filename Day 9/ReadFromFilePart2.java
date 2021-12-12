import java.net.*;
import java.io.*;
import java.util.*;


public class ReadFromFilePart2 {
	public static void main(String[] args) throws Exception {

		try{
		FileReader reader = new FileReader("Code Input.txt");
//		FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		List<String> inputLines = new ArrayList<String>();
		int finalSum = 0;
		int finalNumber = 0;
		int basinNum = 0;
		
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
here:					if(gridCompare[i][j] < 0){
						if(i == 0){
							if(j == 0){
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
							}else if(j == grid[i].length-1){
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
							}else{	
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
							}
						}else if(i == grid.length-1){
							if(j == 0){
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
							}else if(j == grid[i].length-1){
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
							}else{	
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
							}
						}else{
		
							if(j == 0){
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
							}else if(j == grid[i].length-1){
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
	
							}else{	
								if(gridCompare[i][j-1] > 0){
									gridCompare[i][j] = gridCompare[i][j-1];
									break here;
								}
								if(gridCompare[i][j+1] > 0){
									gridCompare[i][j] = gridCompare[i][j+1];
									break here;
								}
								if(gridCompare[i-1][j] > 0){
									gridCompare[i][j] = gridCompare[i-1][j];
									break here;
								}
								if(gridCompare[i+1][j] > 0){
									gridCompare[i][j] = gridCompare[i+1][j];
									break here;
								}
							}
						}
						basinNum++;
						gridCompare[i][j] = basinNum;
					}
					if(i == 0){
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}
						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}
						}
					}else if(i == grid.length-1){
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
						}
					}else{
	
						if(j == 0){
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}
						}else if(j == grid[i].length-1){
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}

						}else{	
							if(gridCompare[i][j-1] < 0){
								gridCompare[i][j-1] = gridCompare[i][j];
							}
							if(gridCompare[i][j+1] < 0){
								gridCompare[i][j+1] = gridCompare[i][j];
							}
							if(gridCompare[i-1][j] < 0){
								gridCompare[i-1][j] = gridCompare[i][j];
							}
							if(gridCompare[i+1][j] < 0){
								gridCompare[i+1][j] = gridCompare[i][j];
							}
						}
					}
				}
			}
		}


		int[] basins = new int[basinNum];


		// PRINTS GRIDCOMPARE
		for(int i = 0; i<gridCompare.length; i++){
			for(int j = 0; j<gridCompare[i].length; j++){
				//System.out.print(gridCompare[i][j] + " ");
				for(int k = 0; k<basins.length; k++){
					if(gridCompare[i][j] == k + 1){
						basins[k]++;
					}
				}
			}
			//System.out.println();
		}

		Arrays.sort(basins);

/*		for(int i : basins){
			System.out.println(i);
		}
*/

		for(int i = basins.length -1; i>basins.length-4;i--){
			System.out.println(basins[i]);
			if(i == basins.length-1){
				finalNumber += basins[i];
			}else{
				finalNumber = finalNumber * basins[i];
			}
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