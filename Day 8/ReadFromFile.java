import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ReadFromFile {
	public static void main(String[] args) throws Exception {

		try{
		FileReader reader = new FileReader("Code Input.txt");
//		FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		String[] signalPatterns;
		String[][] patternSep;
		String[] outputValues;
		String[][] outputSep;
		List<String[]> inputs = new ArrayList<String[]>();
		int numTimesDigitsAppear = 0;
		

// PUTS EACH INPUT LINE INTO A LIST
		while((line = bufferedReader.readLine()) != null){
			String[] lineStuff = line.split(" \\| ");
			inputs.add(lineStuff);
		}
		reader.close();
		signalPatterns = new String[inputs.size()];
		outputValues = new String[inputs.size()];
// PUTS EACH SIDE OF THE INPUT LINES INTO THEIR OWN ARRAY
		for(int i = 0; i<inputs.size(); i++){
			signalPatterns[i] = inputs.get(i)[0];
			outputValues[i] = inputs.get(i)[1];
			for(int j=0; j<inputs.get(i).length; j++){
				inputs.get(i)[j] = inputs.get(i)[j].trim();
			}
		}
// PUTS EACH INDIVIDUAL VALUE INTO IT'S OWN ARRAY SLOT
		patternSep = new String[signalPatterns.length][signalPatterns[0].split(" ").length];
		outputSep = new String[outputValues.length][outputValues[0].split(" ").length];
		for(int i = 0; i<signalPatterns.length; i++){
			patternSep[i] = signalPatterns[i].split(" ");
		}
		for(int i = 0; i<outputValues.length; i++){
			outputSep[i] = outputValues[i].split(" ");
		}
// PRINTS OUT EACH VALUE. USED FOR TESTING PURUPOSES
/*		for(int i = 0; i<patternSep.length; i++){
			for(int j = 0; j<patternSep[i].length; j++){
				System.out.print(patternSep[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i<outputSep.length; i++){
			for(int j = 0; j<outputSep[i].length; j++){
				System.out.print(outputSep[i][j] + " ");
			}
			System.out.println();
		}
*/
// FIND CORRESPONDING EASY DIGITS FOR PART 1 OF THE CHALLENGE
		for(int i = 0; i<outputSep.length; i++){
			for(int j = 0; j<outputSep[i].length; j++){
				if(outputSep[i][j].length() == 2){
					numTimesDigitsAppear++;
				}else if(outputSep[i][j].length() == 4){
					numTimesDigitsAppear++;
				}else if(outputSep[i][j].length() == 3){
					numTimesDigitsAppear++;
				}else if(outputSep[i][j].length() == 7){
					numTimesDigitsAppear++;
				}
			}
		}
// PRINTS OUT NUM OF TIMES DIGITS APPEAR (PART 1)
		System.out.println(numTimesDigitsAppear);


		}
		catch (IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
	    	}
	}
}