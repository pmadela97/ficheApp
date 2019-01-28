import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
public class FicheDialog extends JDialog implements Runnable{
	
	
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	
	JLabel wordL = new JLabel("s³owo");
	JLabel spaceL = new JLabel("");
	JLabel wordTL = new JLabel("t³umaczenie");

	
	FicheDialog(JFrame frame,String a,String b){
		setTitle("Losowa fiszka");
		setSize(200,120);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		wordL.setText(a);
		wordTL.setText(b);
		panel.add(wordL);
		panel.add(spaceL);
		wordTL.setForeground(Color.GREEN);
		spaceL.setPreferredSize(new Dimension(200,10));
		setContentPane(panel);
		
		setVisible(true);

		
	}


	@Override
	public void run() {
		try {

			
			Thread.sleep(5000);
			
			panel.add(wordTL);
			setVisible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	

}
