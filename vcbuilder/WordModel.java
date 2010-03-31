package vcbuilder;

import java.util.Observable;

//import java.util.Observable;

public abstract class WordModel extends Observable implements Iterable {

	public abstract void AddWord(String Word) throws WordNotFoundException;
	
}
