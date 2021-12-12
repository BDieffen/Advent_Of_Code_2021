import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class try_This {
    static ArrayList<Integer> numbers = new ArrayList<Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<String>();
        Scanner textfile = new Scanner(new File("Code Input.txt"));
        while (textfile.hasNextLine()) {
            String line = textfile.nextLine();
            list.add(line);
        }
        int[][] heightMap = new int[list.size()][list.get(0).length()];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                heightMap[i][j] =Integer.parseInt(list.get(i)
                                        .substring(j, j + 1));
            }
        }
        for (int i = 0; i < heightMap.length; i++) {
            for (int j = 0; j < heightMap[i].length; j++) {
                if (i == 0 && j == 0) {
                    if (heightMap[i][j + 1] > heightMap[i][j] && 
                        heightMap[i + 1][j] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (i == 0 && j == heightMap[i].length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && 
                        heightMap[i + 1][j] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (i == heightMap.length - 1 && j == 0) {
                    if (heightMap[i][j + 1] > heightMap[i][j] &&                             
                        heightMap[i - 1][j] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (i == heightMap.length - 1 && j == 
                         heightMap[i].length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && 
                        heightMap[i - 1][j] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (i == 0) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && 
                        heightMap[i + 1][j] > heightMap[i][j] &&
                        heightMap[i][j + 1] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (i == heightMap.length - 1) {
                    if (heightMap[i][j - 1] > heightMap[i][j] && 
                        heightMap[i - 1][j] > heightMap[i][j] &&
                        heightMap[i][j + 1] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (j == 0) {
                    if (heightMap[i + 1][j] > heightMap[i][j] && 
                        heightMap[i - 1][j] > heightMap[i][j] &&
                        heightMap[i][j + 1] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else if (j == heightMap.length - 1) {
                    if (heightMap[i + 1][j] > heightMap[i][j] && 
                        heightMap[i - 1][j] > heightMap[i][j] &&
                        heightMap[i][j - 1] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                } else {
                    if (heightMap[i + 1][j] > heightMap[i][j] && 
                        heightMap[i - 1][j] > heightMap[i][j] &&
                        heightMap[i][j - 1] > heightMap[i][j] &&                            
                        heightMap[i][j + 1] > heightMap[i][j]) {
                        explore(i, j, heightMap);
                    }
                }
            }
        }
        Collections.sort(numbers);
        Collections.reverse(numbers);
        System.out.println(numbers.get(0) * numbers.get(1) * numbers.get(2));
    }

    public static void explore(int i, int j, int[][] heightMap) {
        Stack<String> s = new Stack<String>();
        Set<String> set = new HashSet<String>();
        int x, y, count;
        s.push((i + "," + j));
        set.add((i + "," + j));
        count = 0;
        while (s.size() > 0) {
            String pop = s.pop();
            x = Integer.parseInt(pop.substring(0, pop.indexOf(",")));
            y = Integer.parseInt(pop.substring(pop.indexOf(",") + 1));
            if (y - 1 >= 0 && heightMap[x][y - 1] != 9) {
                int size = set.size();
                set.add((x) + "," + (y - 1));
                if (size != set.size()) {
                    s.push((x) + "," + (y - 1));
                }
            }
            if (y + 1 < heightMap[x].length && heightMap[x][y + 1] != 9) {
                int size = set.size();
                set.add((x) + "," + (y + 1));
                if (size != set.size()) {
                    s.push((x) + "," + (y + 1));
                }
            }
            if (x - 1 >= 0 && heightMap[x - 1][y] != 9) {
                int size = set.size();
                set.add((x - 1) + "," + (y));
                if (size != set.size()) {
                    s.push((x - 1) + "," + (y));
                }
            }
            if (x + 1 < heightMap.length && heightMap[x + 1][y] != 9) {
                int size = set.size();
                set.add((x + 1) + "," + (y));
                if (size != set.size()) {
                    s.push((x + 1) + "," + (y));
                }
            }
            if (heightMap[x][y] == 9) {
                count--;
            }
            count++;
        }
        numbers.add(count);
    }
}