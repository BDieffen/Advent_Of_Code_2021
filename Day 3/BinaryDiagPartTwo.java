import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


public class BinaryDiagPartTwo {
    public static void main(String[] args) throws Exception {

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		int charCount = 0;
		int[] binaryBucket = new int[2];;

		String binaryGamma = "";
		String binaryEpsilon = "";

		char gammaRate;
		char epsilonRate;

		String oxygenGenRating = "";
		String co2ScrubberRating = "";
		int[] higherNumbers;

		ArrayList<String> listOfBinaryValues = new ArrayList<String>();
		ArrayList<String> backupListOfBinaryValues = new ArrayList<String>();

		
		while((line = bufferedReader.readLine()) != null){
			listOfBinaryValues.add(line);
			backupListOfBinaryValues.add(line);
		}
		reader.close();
		charCount = listOfBinaryValues.get(0).length();
		backupListOfBinaryValues = listOfBinaryValues;



		for(int i = 0; i<charCount; i++){
			for(int j = 0; j<binaryBucket.length; j++){
				Arrays.fill(binaryBucket, 0);
			}
			for(String s : listOfBinaryValues){
				if(s.charAt(i) == '0'){
					binaryBucket[0] += 1;
				}else if(s.charAt(i) == '1'){
					binaryBucket[1] += 1;
				}
			}
			if(binaryBucket[0] > binaryBucket[1]){
				gammaRate = '0';
			}else if(binaryBucket[0] < binaryBucket[1]){
				gammaRate = '1';
			}else {
				gammaRate = '1';
			}


			System.out.println(gammaRate);

//			Iterator<String> it = listOfBinaryValues.iterator();
//			while(it.hasNext()){
//				String st = it.next();
//				if(Integer.parseInt(st.substring(i, i + 1)) != gammaRate){
//					if(listOfBinaryValues.size() > 1) {
//						it.remove();
//					}
//				}
//			}

			for(int j = listOfBinaryValues.size() - 1; j >= 0 ; j--){
				//if (Integer.parseInt(String.valueOf(listOfBinaryValues.get(j).charAt(i))) != gammaRate) {
				System.out.println(listOfBinaryValues.get(j));
				if (listOfBinaryValues.get(j).charAt(i) != gammaRate) {
					if(listOfBinaryValues.size() > 1) {
						listOfBinaryValues.remove(j);
					}
				}
			}
		}

		oxygenGenRating = listOfBinaryValues.get(0);


			System.out.println("----------------------------------------------");

			reader = new FileReader("Code Input.txt");
			bufferedReader = new BufferedReader(reader);
			while((line = bufferedReader.readLine()) != null){
				listOfBinaryValues.add(line);
				backupListOfBinaryValues.add(line);
			}
			reader.close();


			for(int i = 0; i<charCount; i++){
				for(int j = 0; j<binaryBucket.length; j++){
					Arrays.fill(binaryBucket, 0);
				}
				for(String s : backupListOfBinaryValues){
					if(s.charAt(i) == '0'){
						binaryBucket[0] += 1;
					}else if(s.charAt(i) == '1'){
						binaryBucket[1] += 1;
					}
				}
				if(binaryBucket[0] > binaryBucket[1]){
					epsilonRate = '1';
				}else if(binaryBucket[0] < binaryBucket[1]){
					epsilonRate = '0';
				}else {
					epsilonRate = '0';
				}

				System.out.println(epsilonRate);


//				Iterator<String> it = backupListOfBinaryValues.iterator();
//				while(it.hasNext()){
//					String st = it.next();
//					if(Integer.parseInt(st.substring(i, i + 1)) != epsilonRate){
//						if(backupListOfBinaryValues.size() > 1) {
//							it.remove();
//						}
//					}
//				}

				for(int j = backupListOfBinaryValues.size() - 1; j >= 0 ; j--){
					System.out.println(backupListOfBinaryValues.get(j));
					//if (Integer.parseInt(String.valueOf(backupListOfBinaryValues.get(j).charAt(i)) != epsilonRate) {
					if (backupListOfBinaryValues.get(j).charAt(i) != epsilonRate) {
						if(backupListOfBinaryValues.size() > 1) {
							backupListOfBinaryValues.remove(j);
						}
					}
				}
			}

		co2ScrubberRating = backupListOfBinaryValues.get(0);


		System.out.println(oxygenGenRating);
		System.out.println(Integer.parseInt(oxygenGenRating,2));
		System.out.println(co2ScrubberRating);
		System.out.println(Integer.parseInt(co2ScrubberRating,2));
		System.out.println(Integer.parseInt(oxygenGenRating,2) * Integer.parseInt(co2ScrubberRating,2));
		System.out.println(listOfBinaryValues.size());
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }

}




