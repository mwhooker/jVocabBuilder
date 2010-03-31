package vcbuilder;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.*;

public class Main {
//	private static IndexWord DOG;
	/**
	 * @param args
	 */
	private static ArrayList<String> WordsNotFound;
	public static void main(String[] args) {
		
		WordsNotFound = new ArrayList<String>();
		VocabController VC = new VocabController();
		WordListReader Reader = null;
		try {
			Reader = new WordListReader(new FileReader("words.txt"));
		} catch (FileNotFoundException fnfex) {
			fnfex.printStackTrace();
			System.exit(-1);
		}
		Reader.ReadIn();
		
		Iterator<String> ReadIt = Reader.iterator();

		while (ReadIt.hasNext())
		{
			String next = ReadIt.next();
			Pattern space = Pattern.compile("\\s*");
			if (space.matcher(next).matches())
				continue;
			try {
				VC.AddWord(next);
			} catch (WordNotFoundException ex) {
				//System.out.println(ex.getMessage() + " not found");
				WordsNotFound.add(ex.getMessage());
			}
		}
		VC.Display();
		PrintNotFound();
		
	}
	static double rollDie(double face){

		for(int i=1;i<2;i++){
			face= 6-Math.floor(6*Math.random()) ;
			return face;
		}
	}
	private static void PrintNotFound()
	{
		Iterator<String> it = WordsNotFound.iterator();
		while (it.hasNext())
		{
			String next = it.next();
			System.out.println(next + " not found.");
		}
	}

}
