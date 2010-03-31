package vcbuilder;

import net.didion.jwnl.JWNL;
import java.io.FileInputStream;
//import net.didion.jwnl.data.POS;
import net.didion.jwnl.dictionary.Dictionary;
//import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.IndexWordSet;


import java.util.ArrayList;
import java.util.Iterator;

public class WordNetModel extends WordModel {
	private ArrayList<IndexWordSet> WordSets;

	public void AddWord(String Word) throws WordNotFoundException
	{
		IndexWordSet iWordSet = null;
			
		try {
			iWordSet = Dictionary.getInstance().lookupAllIndexWords(Word);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		if (iWordSet.size() == 0)
			throw new WordNotFoundException(iWordSet.getLemma());
		
		WordSets.add(iWordSet);
		setChanged();
		
		//System.out.println("WordModel::AddWord(" + iWordSet.toString() + ")" );
		notifyObservers(iWordSet);
	}

	WordNetModel() {
		WordSets = new ArrayList<IndexWordSet>();
		try {
			JWNL.initialize(new FileInputStream("file_properties.xml"));
		} catch (Exception Ex) {
			Ex.printStackTrace();
			System.exit(-1);
		}
	}

	public Iterator iterator() {
		return WordSets.iterator();
	}
}
