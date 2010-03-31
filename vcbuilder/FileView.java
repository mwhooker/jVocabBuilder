package vcbuilder;

import java.io.FileWriter;
import java.util.Enumeration;
//import java.io.ch

public class FileView extends WordView {

	public FileView() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DoOutput() {
		try {
			FileWriter out = new FileWriter("formatted.txt");
			for (Enumeration e = Words.elements() ; e.hasMoreElements() ;) {
		         out.write((String)e.nextElement() + "\n");
		     }
			
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		
		// TODO Auto-generated method stub

	}

}
