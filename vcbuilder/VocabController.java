package vcbuilder;

import java.util.Observer;

public class VocabController {

	private WordView View;
	private WordNetModel Model;
	
	public void AddWord(String Word) throws WordNotFoundException
	{
		Model.AddWord(Word);
	}

	public void Display()
	{
		View.DoOutput();
	}
	
	VocabController() {
		View = new FileView();
		Model = new WordNetModel();

		Model.addObserver(View);
	}
}
