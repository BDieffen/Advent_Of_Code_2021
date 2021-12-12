import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		//FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		int lineNum = 0;
		List<String> bucket = new ArrayList<>();
		List<Board> listOfBoards = new ArrayList<>();

		int[][] tempBoard = new int[5][5];
		int boardLine = 0;

		// MAKE THE BOARDS
		while((line = bufferedReader.readLine()) != null){
			if(lineNum == 0){
				bucket = Arrays.asList(line.split(",",0));
				lineNum++;
			}else {
				if (!line.isBlank()) {
					if(boardLine == 0){
						listOfBoards.add(new Board());
					}
					if (boardLine < 5) {
						String[] tempLine = line.split("(?<=\\G...)");
						for (int i = 0; i < tempLine.length; i++) {
							tempBoard[boardLine][i] = Integer.parseInt(tempLine[i].trim());
							//System.out.print(tempBoard[boardLine][i] + " ");
						}
						listOfBoards.get(listOfBoards.size()-1).addLine(tempBoard[boardLine], boardLine);
						boardLine++;
					}
				}else {
					boardLine = 0;
				}
			}
		}


		bHere: for(String s : bucket){
			for(int i=0; i<listOfBoards.size(); i++){
				listOfBoards.get(i).checkNewNumber(Integer.parseInt(s));
				listOfBoards.get(i).hasWon();
				if(listOfBoards.get(i).isWinningBoard){
					//b.printBoard();
					System.out.println("Final number called was " + s);
					System.out.println(listOfBoards.get(i).calculateScore(Integer.parseInt(s)));
					System.out.println("The winning board is board number " + listOfBoards.indexOf(listOfBoards.get(i))
							+ " out of " + listOfBoards.size() + " boards");
					//break bHere;
					listOfBoards.remove(i);
					i--;
				}
			}
//			for(Board b : listOfBoards){
//			}
		}




//		for(Board b : listOfBoards){
//			b.printBoard();
//			System.out.println();
//		}

	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }
}