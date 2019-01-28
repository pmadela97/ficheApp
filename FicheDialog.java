import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
public class FicheDialog extends JDialog implements Runnable{
	
	
	private static final long serialVersionUID = 1L;

	JPanel panel = new JPanel();
	
	JLabel wordL = new JLabel("s³owo");
	JLabel spaceL = new JLabel("                              ");
	JLabel wordTL = new JLabel("t³umaczenie");

	
	FicheDialog(JFrame frame){
		super(frame);
		setTitle("Losowa fiszka");
		setSize(200,250);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		panel.add(wordL);
		panel.add(spaceL);
		setContentPane(panel);
		
		setVisible(true);

		
	}


	@Override
	public void run() {
		try {

			
			Thread.sleep(100);
			
			panel.add(wordTL);
			setVisible(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	

}
