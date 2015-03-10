/* Jamey Dogom
   Comp. 282
   Project 3 */   

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class ReadInput {
	ReadInput()
	{
		
	}
	public int[] ReadPuzzle() throws IOException
	{
		int[] Puzzle = new int[9];
		int i=0;
		Scanner scanner = new Scanner(new File("in.txt"));
		while(scanner.hasNextInt())
		{
		    Puzzle[i++] = scanner.nextInt();
		}
		
          return Puzzle;
	}
	public String readBFS() throws FileNotFoundException
	{
		String input = "";
		Scanner scanner = new Scanner(new File("in.txt"));
		while(scanner.hasNextInt())
		{
		    input = input + String.valueOf(scanner.nextInt());
		}
		return input;
	}
}
