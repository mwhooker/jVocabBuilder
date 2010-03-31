package vcbuilder;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observer;
import java.util.Observable;

import net.didion.jwnl.data.*;
import java.util.List;
import java.util.Collection;

public abstract class WordView implements Observer, Enumeration {
	public Hashtable<String, String> Words;

	public boolean hasMoreElements() {
		return Words.elements().hasMoreElements();
	}

	public Object nextElement() {
		return Words.elements().nextElement();
	}

	public void update(Observable arg0, Object arg1) {
		IndexWordSet WordSet = (IndexWordSet)arg1;
		String Definition = new String(FormatWords(WordSet));
		System.out.println("WordView::update(" + WordSet.getLemma() + ")");
		
		Words.put(WordSet.getLemma(), Definition);
		
		
		
	}

	public WordView() {
		Words = new Hashtable<String, String>();
	}
	
	public abstract void DoOutput();
	
	private String FormatWords(IndexWordSet IWS)	{
		String WordSenses = new String();
		
		try {
			Collection<IndexWord> WordCol =  IWS.getIndexWordCollection();
			Iterator<IndexWord> WordIt = WordCol.iterator();
			while (WordIt.hasNext())
			{
				IndexWord next = WordIt.next();
				WordSenses += FormatPOS(next);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		return WordSenses;
	}
	
	private String FormatPOS(IndexWord IW) {
		String WordSense = new String();
		WordSense = IW.getLemma() + ": " + IW.getPOS().getKey() + "\n";
		try {
			List<Synset> SenseList = Arrays.asList(IW.getSenses());
			Iterator<Synset> SenseIt = SenseList.iterator();
			for (int i = 1; SenseIt.hasNext(); ++i)
			{
				Synset next = SenseIt.next();
				WordSense += "\t" + i + ". " + next.getGloss() + "\n";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		return WordSense;
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	public void update(Observable obs, Object arg)
	{
		//System.out.println("PrintView::update");
		try {
			IndexWordSet WordSet = (IndexWordSet)arg;
			Collection<IndexWord> WordCol =  WordSet.getIndexWordCollection();
			Iterator<IndexWord> WordIt = WordCol.iterator();
			while (WordIt.hasNext())
			{
				IndexWord next = WordIt.next();
				System.out.println(next.getLemma() + ": " + next.getPOS().getKey());
				FormatDefintion(next);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
	}
	
	private String FormatDefintion(IndexWord Word)
	{
		String Definition = new String();
		//int SenseCount = Word.getSenseCount();
		
		try {
			List<Synset> SenseList = Arrays.asList(Word.getSenses());
			Iterator<Synset> SenseIt = SenseList.iterator();
			for (int i = 1; SenseIt.hasNext(); ++i)
			{
				Synset next = SenseIt.next();
				System.out.println(i + ". " + next.getGloss());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		return Definition;
	}
}
*/