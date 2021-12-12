import java.net.*;
import java.io.*;
import java.util.*;

public class AOC_10 {
	public static void main(String[] args) throws Exception {

		try{
		FileReader reader = new FileReader("Code Input.txt");
//		FileReader reader = new FileReader("Test Input.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		String line;
		List<String> inputLines = new ArrayList<String>();
		List<String> chars = new ArrayList<String>();
		List<Long> scores = new ArrayList<Long>();
		Long winningScore = 0L;

		while((line = bufferedReader.readLine()) != null){
//			String[] lineStuff = line.split(" ");
			inputLines.add(line);
		}
		reader.close();


		for(int i=inputLines.size()-1; i>=0; i--){
here:			for(int j = 0; j<inputLines.get(i).length(); j++){
				chars = new ArrayList<String>();
				String[] arr = inputLines.get(i).split("");
				for(String c : arr){
					if(c.equals("(")){
						chars.add(c);
					}else if(c.equals("[")){
						chars.add(c);
					}else if(c.equals("{")){
						chars.add(c);
					}else if(c.equals("<")){
						chars.add(c);
					}else{
						if(c.equals(")")){
							if(chars.get(chars.size()-1).equals("(")){
								chars.remove(chars.size()-1);
							}else{
//								winningScore += 3;
								inputLines.remove(i);
								chars = new ArrayList<String>();
								break here;
							}
						}else if(c.equals("]")){
							if(chars.get(chars.size()-1).equals("[")){
								chars.remove(chars.size()-1);
							}else{
//								winningScore += 57;
								inputLines.remove(i);
								chars = new ArrayList<String>();
								break here;
							}
						}else if(c.equals("}")){
							if(chars.get(chars.size()-1).equals("{")){
								chars.remove(chars.size()-1);
							}else{
//								winningScore += 1197;
								inputLines.remove(i);
								chars = new ArrayList<String>();
								break here;
							}
						}else if(c.equals(">")){
							if(chars.get(chars.size()-1).equals("<")){
								chars.remove(chars.size()-1);
							}else{
//								winningScore += 25137;
								inputLines.remove(i);
								chars = new ArrayList<String>();
								break here;
							}
						}else{
							chars = new ArrayList<String>();
							break here;
						}
					}
				}
//				chars = new ArrayList<String>();
			}
				Long newScore = 0L;
				if(chars.size() > 0){
					for(int k=chars.size()-1; k>=0; k--){
						if(chars.get(k).equals("(")){
							newScore = (newScore*5) + 1;
//							System.out.print(")");
						}else if(chars.get(k).equals("[")){
							newScore = (newScore*5) + 2;
//							System.out.print("]");
						}else if(chars.get(k).equals("{")){
							newScore = (newScore*5) + 3;
//							System.out.print("}");
						}else if(chars.get(k).equals("<")){
							newScore = (newScore*5) + 4;
//							System.out.print(">");
						}
						chars.remove(chars.size()-1);
					}
				}
//				System.out.println();
				if(newScore > 0){
					scores.add(newScore);
				}
		}
	
		Long[] sortedScores = new Long[scores.size()];
		for(int i = 0; i<sortedScores.length; i++){
			sortedScores[i] = scores.get(i);
		}

		Arrays.sort(sortedScores);

		for(int i = 0; i<sortedScores.length; i++){
			System.out.println(sortedScores[i]);
		}


		winningScore = sortedScores[sortedScores.length/2];
		
/*		for(String s : inputLines){
			System.out.println(s);
		}		
*/
		System.out.println("Total Score: " + winningScore);

		}
		catch (IOException e){
			System.out.println("An error has occurred.");
			e.printStackTrace();
	    	}
	}
}