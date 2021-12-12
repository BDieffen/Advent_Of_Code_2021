import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ReadFromFilePart2 {
	public static void main(String[] args) throws Exception {

		try{
//		FileReader reader = new FileReader("Code Input.txt");
		FileReader reader = new FileReader("Test Input.txt");
//		FileReader reader = new FileReader("Another Test.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		String[] signalPatterns;
		String[][] patternSep;
		String[] outputValues;
		String[][] outputSep;
		List<String[]> inputs = new ArrayList<String[]>();
		int sumOfDigits = 0;
		String valueToAdd = "";
		String zero = "";
		String one = "";
		String two = "";
		String three = "";
		String four = "";
		String five = "";
		String six = "";
		String seven = "";
		String eight = "";
		String nine = "";
		String allChars = "";
		

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

		for(int i = 0; i<patternSep.length; i++){
			Boolean nineWasDone = false;
			List<String> leftovers = new ArrayList<String>();
			// FIND CORRESPONDING EASY DIGITS
			for(int j = 0; j<patternSep[i].length; j++){
				String tempStr = patternSep[i][j];


				if(tempStr.length() == 2){
					one = tempStr;
				}else if(tempStr.length() == 4){
					four = tempStr;
				}else if(tempStr.length() == 3){
					seven = tempStr;
				}else if(tempStr.length() == 7){
					eight = tempStr;
					allChars = eight;
				}
			}
			// FIND CORRESPONDING DIFFICULT DIGITS
			for(int j = 0; j<patternSep[i].length; j++){
				String topRight = "";
				String tempStr = patternSep[i][j];	

				if(tempStr.length() == 6){
					if(!numsMatch(seven.split(""), tempStr)){
						six = tempStr;
					}else{
						if(numsMatch(four.split(""), tempStr)){
							nine = tempStr;
							nineWasDone = true;
						}else{
							zero = tempStr;
						}
					}
				}else if(tempStr.length() == 5){
					if(nineWasDone){
						String decidingFactor = removeChars(nine.split(""), allChars);
						if(numsMatch(seven.split(""), tempStr)){
							three = tempStr;
						}else if(tempStr.contains(decidingFactor)){
							two = tempStr;
						}else{
							five = tempStr;
						}
					}else{
						leftovers.add(tempStr);
					}
				}
			}

			for(int j=0; j<leftovers.size(); j++){
				String decidingFactor = removeChars(nine.split(""), allChars);
				if(numsMatch(seven.split(""), leftovers.get(j))){
					three = leftovers.get(j);
				}else if(leftovers.get(j).contains(decidingFactor)){
					two = leftovers.get(j);
				}else{
					five = leftovers.get(j);
				}
			}

			// PRINTS STUFF (TESTING PURPOSES)		
			System.out.println("Zero: " + zero);
			System.out.println("One: " + one);
			System.out.println("Two: " + two);
			System.out.println("Three: " + three);
			System.out.println("Four: " + four);
			System.out.println("Five: " + five);
			System.out.println("Six: " + six);
			System.out.println("Seven: " + seven);
			System.out.println("Eight: " + eight);
			System.out.println("Nine: " + nine);
			System.out.println();


			for(int j = 0; j<outputSep[i].length; j++){
				String tempOut = outputSep[i][j];

				System.out.println("tempOut = " + tempOut);
	
				if(sortString(tempOut).equals(sortString(zero))){
					valueToAdd = valueToAdd + "0";
				}else if(sortString(tempOut).equals(sortString(one))){
					valueToAdd = valueToAdd + "1";
				}else if(sortString(tempOut).equals(sortString(two))){
					valueToAdd = valueToAdd + "2";
				}else if(sortString(tempOut).equals(sortString(three))){
					valueToAdd = valueToAdd + "3";
				}else if(sortString(tempOut).equals(sortString(four))){
					valueToAdd = valueToAdd + "4";
				}else if(sortString(tempOut).equals(sortString(five))){
					valueToAdd = valueToAdd + "5";
				}else if(sortString(tempOut).equals(sortString(six))){
					valueToAdd = valueToAdd + "6";
				}else if(sortString(tempOut).equals(sortString(seven))){
					valueToAdd = valueToAdd + "7";
				}else if(sortString(tempOut).equals(sortString(eight))){
					valueToAdd = valueToAdd + "8";
				}else if(sortString(tempOut).equals(sortString(nine))){
					valueToAdd = valueToAdd + "9";
				}
				System.out.println("evaluates to = " + valueToAdd);
			}
			System.out.println();
			//System.out.println(valueToAdd);
			sumOfDigits = sumOfDigits + Integer.parseInt(valueToAdd);
			valueToAdd = "";


		}





// PRINTS OUT SUM OF OUTPUT VALUES
		System.out.println(sumOfDigits);


		}
		catch (IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
	    	}
	}

	public static String sortString(String str){
		String newStr = str;		

		char charArray[] = newStr.toCharArray();
		Arrays.sort(charArray);
		newStr = String.valueOf(charArray);	
		
		return newStr;	
	}

	public static boolean numsMatch(String[] arr, String against){
		for(int i=0; i<arr.length; i++){
			if(!against.contains(arr[i])){
				return false;
			}
		}
		return true;
	}

	public static boolean isMatch(String[] arr, String against){
		for(int i=0; i<arr.length; i++){
			if(!against.contains(arr[i])){
				return false;
			}
		}
		return true;
	}

	public static String removeChars(String[] arr, String against){
		String newSt = against;
		for(int i=0; i<arr.length; i++){
			if(newSt.contains(arr[i])){
				newSt = newSt.replaceAll(arr[i],"");
			}
		}	
		return newSt;
	}
}