import java.net.*;
import java.io.*;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		
		while((line = bufferedReader.readLine()) != null){
			String[] lineStuff = line.split(" ");
		}
	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}