import java.net.*;
import java.io.*;


public class ReadMultiLine {
    public static void main(String[] args) throws Exception {
	int numberOfLarger = 0;
	int numToCompare = 0;
	int currentWindowValue = 0;
	int lineNum = 1;

	int bufferLimit = 1000;

	String testLine;

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		String windowLine;
		
		while((line = bufferedReader.readLine()) != null){
			bufferedReader.mark(bufferLimit);
			currentWindowValue = 0;

			for(int i = 0; i<3; i++){
				if((windowLine = bufferedReader.readLine()) != null){
					currentWindowValue = currentWindowValue + Integer.parseInt(windowLine);
				}
			}

			if(currentWindowValue > numToCompare){
				numberOfLarger++;
				//System.out.println(currentWindowValue);
			}
			numToCompare = currentWindowValue;
			lineNum++;
			bufferedReader.reset();
		}
		System.out.println(numberOfLarger);

	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}