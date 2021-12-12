import java.net.*;
import java.io.*;
import java.util.*;

public class AOC_11 {
	public static int numFlashes = 0;
	public static int[][] oncePerTurn;
	public static void main(String[] args) throws Exception {

		try {
			FileReader reader = new FileReader("Code Input.txt");
//			FileReader reader = new FileReader("Test Input.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;
			List<String> inputLines = new ArrayList<String>();
			int numSteps = 100;
			int stepCount = 0;
			Boolean allFlash = false;

			while ((line = bufferedReader.readLine()) != null) {
//			String[] lineStuff = line.split(" ");
				inputLines.add(line);
			}
			reader.close();

			int[][] grid = new int[inputLines.size()][inputLines.get(0).length()];
			oncePerTurn = new int[grid.length][grid[0].length];
			for(int i=0; i<grid.length; i++){
				String[] temp = inputLines.get(i).split("");
				for (int j=0; j<temp.length; j++){
					grid[i][j] = Integer.parseInt(temp[j]);
				}
			}

			//for (int i=0 ;i<numSteps;i++){
			while(!allFlash){
				stepCount++;
				grid = cycle(grid);

				for(int j=0; j<oncePerTurn.length; j++) {
					for (int k = 0; k < oncePerTurn[j].length; k++) {
						if(oncePerTurn[j][k] == 1) {
							grid[j][k] = 0;
							oncePerTurn[j][k] = 0;
						}
						if(grid[j][k] > 9){
							grid[j][k] = 0;
						}
					}
				}


				for(int j=0; j<grid.length; j++){
					for(int k=0; k<grid[j].length; k++){
						//System.out.print(grid[j][k]);
					}
					//System.out.println();
				}
				//System.out.println();

				allFlash = allSame(grid);
			}

			System.out.println("First step where all flash: " + stepCount);
		}
		catch (IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
	    	}
	}

	public static int[][] cycle(int[][] grd){
		int[][] arr = grd;
		List<int[]> pointsOverNine = new ArrayList<int[]>();


		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]++;
				if (arr[i][j] > 9) {
					if (oncePerTurn[i][j] == 0) {
						pointsOverNine.add(new int[]{i, j});
						oncePerTurn[i][j] = 1;
					}
				}
			}
		}
		if (pointsOverNine.size() > 0) {
			arr = flash(arr, pointsOverNine);
		}

		return arr;
	}

	public static int[][] flash(int[][] grd, List<int[]> li){
		int[][] arr = grd;

		List<int[]> pointsToFlash = li;

		while(pointsToFlash.size() > 0) {
			for (int i = pointsToFlash.size() - 1; i >= 0; i--) {
				numFlashes++;
				//arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1]] = 0;

				if (pointsToFlash.get(i)[0] == 0) {
					if (pointsToFlash.get(i)[1] == 0) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] + 1]++;
					} else if (pointsToFlash.get(i)[1] == arr[0].length - 1) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] - 1]++;
					} else {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] - 1]++;
					}
				} else if (pointsToFlash.get(i)[0] == arr.length - 1) {
					if (pointsToFlash.get(i)[1] == 0) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] + 1]++;
					} else if (pointsToFlash.get(i)[1] == arr[0].length - 1) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] - 1]++;
					} else {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] - 1]++;
					}
				} else {
					if (pointsToFlash.get(i)[1] == 0) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] + 1]++;

					} else if (pointsToFlash.get(i)[1] == arr[0].length - 1) {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] - 1]++;
					} else {
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0]][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1]]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] + 1][pointsToFlash.get(i)[1] - 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] + 1]++;
						arr[pointsToFlash.get(i)[0] - 1][pointsToFlash.get(i)[1] - 1]++;
					}
				}
				pointsToFlash.remove(i);
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j] > 9) {
						if (oncePerTurn[i][j] == 0) {
							pointsToFlash.add(new int[]{i, j});
							oncePerTurn[i][j] = 1;
						}
					}
				}
			}
		}

		return arr;
	}

	public static Boolean allSame(int[][] inp){
		int[][] arr = inp;
		for(int i=0; i<arr.length;i++){
			for(int j=0; j<arr[i].length; j++){
				if(arr[0][0] != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}