import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {

    try{
	FileReader reader = new FileReader("Code Input.txt");
//	FileReader reader = new FileReader("Test Input.txt");
	BufferedReader bufferedReader = new BufferedReader(reader);
	
	String line;
	int totalOverlappingPoints = 0;
	int xMax = 0;
	int yMax = 0;
	int xDif = 0;
	int yDif = 0;

	List<String> listOfCoor = new ArrayList<String>();
	
	while((line = bufferedReader.readLine()) != null){
		//String[] lineStuff = line.split(" ");
		listOfCoor.add(line);
		
	}


// PLOTS THE COORDINATES INTO AN ARRAY
	String[][] coordinates = new String[listOfCoor.size()][2];
	for(int i=0; i<listOfCoor.size();i++){
		coordinates[i] = listOfCoor.get(i).split(" -> ");
	}

// FINDS THE MAX VALUE OF X AND Y
	for(int i=0; i<coordinates.length; i++){
		for(int j=0; j<coordinates[i].length; j++){
//			System.out.print(coordinates[i][j] + " ");
			if(Integer.parseInt(coordinates[i][j].split(",")[0]) > xMax){
				xMax = Integer.parseInt(coordinates[i][j].split(",")[0]);
			}
			if(Integer.parseInt(coordinates[i][j].split(",")[1]) > yMax){
				yMax = Integer.parseInt(coordinates[i][j].split(",")[1]);
			}
		}
//		System.out.println();
	}


// CREATES THE FIELD
	int[][] field = new int[xMax+2][yMax+2];
	for(int i=0; i<field.length; i++){
		for(int j=0; j<field[i].length; j++){
			field[i][j] = 0;
		}
//		System.out.print(field[i]);
//		System.out.println();
	}



	for(int i=0; i<coordinates.length; i++){
		int x1=0, y1=0, x2=0, y2=0;
		String[] firstPointStr = coordinates[i][0].split(",");
		String[] secondPointStr = coordinates[i][1].split(",");
		x1 = Integer.parseInt(firstPointStr[0]);
		y1 = Integer.parseInt(firstPointStr[1]);
		x2 = Integer.parseInt(secondPointStr[0]);
		y2 = Integer.parseInt(secondPointStr[1]);
		boolean firstPointMatch = true;
		boolean secondPointMatch = true;

// FINDS THE DIFFERENCES BETWEEN THE POINTS
		if(x1 == x2){
			firstPointMatch = true;
		}else{
			firstPointMatch = false;
			xDif = x1-x2;
		}
		if(y1 == y2){
			secondPointMatch = true;
		}else{
			secondPointMatch = false;
			yDif = y1-y2;
		}


		if(x1!=x2 && y1!=y2){
			int biggestDif = 0;
			if(Math.abs(xDif)>Math.abs(yDif)){
				biggestDif = xDif;
			}else biggestDif = yDif;

			List<int[]> points = new ArrayList<int[]>();
			int smallX = 0;
			int bigX = 0;
			int smallY = 0;
			int bigY = 0;
			if(x1>=x2){
				bigX = x1;
				smallX = x2;
			}else{
				bigX = x2;
				smallX = x1;
			}
			if(y1>=y2){
				bigY = y1;
				smallY = y2;
			}else{
				bigY = y2;
				smallY = y1;
			}


			int newX = x1;
			int newY = y1;
			points.add(new int[]{newX, newY});
			
			
			for(int j=0; j<Math.abs(biggestDif); j++){
				if(x1!=x2){
					if(x1>x2){
						x1-=1;
						newX = x1;						
					}else if(x1<x2){
						x1+=1;
						newX = x1;	
					}
				}
				if(y1!=y2){
					if(y1>y2){
						y1-=1;
						newY = y1;						
					}else if(y1<y2){
						y1+=1;
						newY = y1;	
					}
				}
			points.add(new int[]{newX, newY});
			}	
//			newX = x2;
//			newY = y2;
//			points.add(new int[]{newX, newY});
	
			for(int j=0; j<points.size(); j++){
				field[points.get(j)[1]][points.get(j)[0]]++;
			}
			points.clear();
			xDif = 0;
			yDif = 0;


			
		}else if(x1==x2){
			if(y1>y2) {
				for (int j = y2; j <= y1; j++){
					field[j][x1]++;
				}
			}else{
				for (int j = y1; j <= y2; j++){
					field[j][x1]++;
				}
			}
		}else if(y1==y2){
			if(x1>x2){
				for(int j = x2; j <= x1; j++){
					field[y1][j]++;
				}
			}else{
				for(int j = x1; j <= x2; j++){
					field[y1][j]++;
				}
			}
		}




// RESET CHECKING IF VALUES ARE EQUAL
		firstPointMatch = true;
		secondPointMatch = true;


//		for(int j=0; j<coordinates[i].length; j++){
//		}
	}



// CALCULATES TOTAL NUMBER OF OVERLAPPING POINTS GREATER THAN 2
	for(int i=0; i<field.length; i++){
		for(int j=0; j<field[i].length; j++){
//			System.out.print(field[i][j] + " ");
			if(field[i][j] > 1){
				totalOverlappingPoints++;
			}
		}
//		System.out.println();
	}

	System.out.println();
	System.out.println("Max X value is: " + xMax);
	System.out.println("Max Y value is: " + yMax);
	System.out.println("Total overlapping points greater than two: " + totalOverlappingPoints);
	
	reader.close();
    }
	catch (IOException e){
	System.out.println("An error has occurred.");
	e.printStackTrace();
	}
    }
}