import java.awt.Dimension;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WordsTableView extends JScrollPane{
	

	private static final long serialVersionUID = 1L;
	JTable table;
	DefaultTableModel tableModel;
	Collection<Fiche> collection;
	
	WordsTableView(Collection<Fiche> collection){
		String[] columns = {"polski","angielski"};
		tableModel = new DefaultTableModel(columns,0);
		table = new JTable(tableModel);
		table.setColumnSelectionAllowed(false);
		table.setEnabled(false);
		setViewportView(table);
		this.collection = collection;
		setPreferredSize(new Dimension(400, 400));
		setBorder(BorderFactory.createTitledBorder("S³owa"));

		
		
		
		
		
	}
void refresh() {
	tableModel.setRowCount(0);
	
	for(Fiche fiche : collection) {
		String[] s = {fiche.getWord(), ""+fiche.gettWord()};
		tableModel.addRow(s);
		
		
	}
		
	}
	
	
}