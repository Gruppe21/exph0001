// DETTE ER BARE EN STOR, DUM TESTKRØLL

package it1901g21;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

public class Zoomable_map extends JFrame{

	public static void main(String[] args) {
		JEditorPane jep = new JEditorPane();
		jep.setEditable(false);   

	try {
			jep.setPage("map.html");
		}catch (IOException e) {
		  jep.setContentType("text/html");
		  jep.setText("Could not load");
		} 
  
		JFrame f = new JFrame("Show those maddafakkings sheep");
		f.setSize(600,450);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600,450));
		f.setVisible(true);
		
		}

}
