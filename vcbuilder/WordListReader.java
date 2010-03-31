package vcbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import java.util.ArrayList;
import java.util.Iterator;

public class WordListReader implements Iterable{

	private ArrayList<String> Words;
	private BufferedReader WordBuffer;
	public WordListReader(Reader WordReader) {
		Words = new ArrayList<String>();
		WordBuffer = new BufferedReader(WordReader);
	}
	
	public void ReadIn() {
		try {
			while (WordBuffer.ready())
			{
				Words.add(WordBuffer.readLine());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		//System.out.println(Words.toString());
	}

	public Iterator iterator() {
		return Words.iterator();
	}
}
