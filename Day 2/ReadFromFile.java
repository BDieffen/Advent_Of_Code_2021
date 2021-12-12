import java.net.*;
import java.io.*;


public class ReadFromFile {
    public static void main(String[] args) throws Exception {
	int numberOfLarger = 0;
	int horizontal = 0;
	int depth = 0;
	int aim = 0;

	String lineDir;
	int lineNumVal = 1;

	    try{
		FileReader reader = new FileReader("Code Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		
		while((line = bufferedReader.readLine()) != null){
			String[] lineStuff = line.split(" ");
			lineDir = lineStuff[0];
			lineNumVal = Integer.parseInt(lineStuff[1]);

			if(lineDir.equals("forward")){
				horizontal = horizontal + lineNumVal;
				depth = depth + (aim * lineNumVal);
			}else if(lineDir.equals("down")){
				aim = aim + lineNumVal;
			}else if(lineDir.equals("up")){
				aim = aim - lineNumVal;
			}

			//currentLineValue = Integer.parseInt(line);
			
		}
		System.out.println("Horizontal: " + horizontal);
		System.out.println("Depth: " + depth);
		System.out.println("Aim: " + aim);
		System.out.println("Horizontal and Depth multiplied together = " + (horizontal * depth));
	      reader.close();
	    }
	    catch (IOException e){
		System.out.println("An error has occurred.");
		e.printStackTrace();
    	}
    }


}