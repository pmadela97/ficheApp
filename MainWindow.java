import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow extends JFrame implements Serializable, ActionListener,Runnable{

	
	private static final long serialVersionUID = 1L;
	
	ArrayList<Fiche> allFicheList = new ArrayList<Fiche>();
	ArrayList<Fiche> ficheList = new ArrayList<Fiche>(); 
	
	private JPanel panel = new JPanel();
	private FicheDialog dialogWindow;
	
	
	WordsTableView ficheTable = new WordsTableView(ficheList);
	
	JLabel newWordL = new JLabel("Nowe s³owo");
	JLabel newWordTranslatedL = new JLabel("T³umaczenie");
	
	JButton searchB = new JButton("Wyszukaj");
	JButton addWordB = new JButton("Dodaj s³owo");
	
	JTextField newWordTF = new JTextField("");
	JTextField newWordTranslatedTF = new JTextField("");

	
	
	int allListIndex = 0;
	
	public static void main(String args[]) {
		
		MainWindow main = new MainWindow();
		
	}
	
	private void addItemsToPanel() {
		newWordTF.setColumns(30);
		newWordTranslatedTF.setColumns(30);
		newWordTranslatedTF.setEditable(false);

		
		panel.add(newWordL);
		panel.add(newWordTF);
		panel.add(newWordTranslatedL);
		panel.add(newWordTranslatedTF);
		panel.add(searchB);
		panel.add(addWordB);
		searchB.addActionListener(this);
		addWordB.addActionListener(this);
		dialogWindow = new FicheDialog(this);
		Thread thread = new Thread(dialogWindow);
		thread.start();
		
		ficheTable.refresh();
		
	}
	
	
	MainWindow(){
		
		setTitle("Fiszki");
		setSize(450,550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		addItemsToPanel();
		panel.add(ficheTable);
		setContentPane(panel);
		try {
			readFromFile("dataX.txt");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ficheTable.refresh();
		
	}
	
	
	private void find() {
		String a = newWordTF.getText();
		allListIndex = 0;

		for(Fiche fiche : allFicheList) {
			if(fiche.getWord().equals(a) == true){
				newWordTranslatedTF.setText(fiche.gettWord());
				newWordTranslatedTF.setEditable(false);
				 
						
			break;	
			}
			else {
				newWordTranslatedTF.setText(null);
				newWordTranslatedTF.setEditable(true);
			}
			
			allListIndex++;

			
		}
		
	}
	private void readFromFile() {
		String line;
		ArrayList<Character> letterList = new ArrayList<Character>();
		String wordA = "";
		String wordB = "";
		String c = "";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader ("data.txt"));
			line = reader.readLine();
			int counter = 0;
			int size = 0;
			while(line!= null) {
				size = line.length();
				
				char b = ' ';
				c = "";
				for(int i = 0; i < size; i ++) {
					char a = line.charAt(i);
		
					if((a > 60  &&  a < 91) || (a > 96 && a < 123) || a== 261|| a== 263|| a== 281|| a== 322|| a== 324|| a== 243|| a== 347|| a== 378|| a== 380) {
						c = c+a;
						
					}
					else if(  (a >=0 &&  a<33 ) &&  (b >32 )){
						{
							c = c+' ';
							
								
							}
							
							
						}
						
						b = a;
					
					
					
				}
				
				
			
				String[] wordLine = c.split(" ", 2);
				wordA= wordLine[0];
				wordB = wordLine[1];
				
				allFicheList.add(new Fiche(wordA,wordB));
				line = reader.readLine();
			}

			reader.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			
			e.printStackTrace();
		}
	

		
	}

	
	private void readFromFile(String fileName) throws ClassNotFoundException, IOException {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		allFicheList.clear();
		allFicheList = (ArrayList<Fiche>) ois.readObject();
		ois.close();
		
		
		
	}
	private void saveToFile() throws IOException {
		File file = new File("dataX.txt");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allFicheList);
		oos.close();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		if(event == searchB) {
			if(newWordTF != null) {
				find();
				
			}
			if(newWordTranslatedTF.isEditable() != true) {
				ficheList.add(allFicheList.get(allListIndex));
				ficheTable.refresh();

			}
			ficheTable.refresh();
		}
			if(event == addWordB) {
				if(newWordTF != null  || (newWordTranslatedTF != null && newWordTranslatedTF.getText().equals(" ") != true)  ) {
					
					Fiche fiche = new Fiche(newWordTF.getText(),newWordTranslatedTF.getText());
					ficheList.add(fiche);
					allFicheList.add(fiche);
					try {
						saveToFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ficheTable.refresh();
					
				}
			
			
		}
		
	}

	@Override
	public void run() {
for(;;) {
	Random rand = new Random();
	
	
	
	
	
	
}
		
	}
	
	
	
	
	
}