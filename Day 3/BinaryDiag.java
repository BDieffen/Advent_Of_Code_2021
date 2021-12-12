import java.net.*;
import java.io.*;


public class BinaryDiag {
    public static void main(String[] args) throws Exception {

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		int lineNum = 1;
		int charCount = 0;
		int[][] binaryBucket;

		String binaryGamma = "";
		String binaryEpsilon = "";

		int gammaRate = 0;
		int epsilonRate = 0;

		int oxygenGenRating = 0;
		int co2ScrubberRating = 0;

		bufferedReader.mark(100);
		line = bufferedReader.readLine();
		charCount = line.length();
		binaryBucket = new int[charCount][2];
		for(int i = 0; i<binaryBucket.length; i++){
			for(int j = 0; j<binaryBucket[i].length; j++){
				binaryBucket[i][j] = 0;
			}
		}
		bufferedReader.reset();

		
		while((line = bufferedReader.readLine()) != null){
			//charCount = line.length();
			//if(lineNum == 1){
				//binaryBucket = new int[charCount][2];
			//}

			for(int i = 0; i<charCount; i++){
				if(line.charAt(i) == '0'){
					binaryBucket[i][0] += 1;
				}else if(line.charAt(i) == '1'){
					binaryBucket[i][1] += 1;
				}
			}
			lineNum++;
		}

		for(int i = 0; i<charCount; i++){
			if(binaryBucket[i][0] > binaryBucket[i][1]){
				binaryGamma = binaryGamma + "0";
				binaryEpsilon = binaryEpsilon + "1";
			}else if(binaryBucket[i][0] < binaryBucket[i][1]){
				binaryGamma = binaryGamma + "1";
				binaryEpsilon = binaryEpsilon + "0";
			}
		}

		System.out.println("Gamma: " + binaryGamma);
		System.out.println("Gamma Dec: " + Integer.parseInt(binaryGamma,2));
		System.out.println("Epsilon: " + binaryEpsilon);
		System.out.println("Epsilon Dec: " + Integer.parseInt(binaryEpsilon,2));
		System.out.println("Power Consumption: " + (Integer.parseInt(binaryGamma,2) * Integer.parseInt(binaryEpsilon,2)));
	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}