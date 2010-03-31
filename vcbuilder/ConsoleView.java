package vcbuilder;

import java.util.Enumeration;

public class ConsoleView extends WordView {

	public ConsoleView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoOutput() {
		for (Enumeration e = Words.elements() ; e.hasMoreElements() ;) {
	         System.out.println(e.nextElement());

	     }
		
	}

}
