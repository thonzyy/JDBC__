package day0817;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day0817.CheckTableDAO;

@SuppressWarnings("serial")
public class TableView extends JFrame {
	
	private JComboBox<String> jcbTable;
	private JTable jtTable;
	private DefaultTableModel dtmTable;
	private JScrollPane jspJtTable;
	
	
	public TableView() throws SQLException {
		super("테이블 선택");
		ArrayList<String> tname = new ArrayList<String>();
		CheckTableDAO ctDAO = new CheckTableDAO();
		String[] columnNames = {"컬럼명","데이터형","크기","null허용","default여부"};
		
		jcbTable = new JComboBox<String>();
		dtmTable = new DefaultTableModel(null,columnNames);
		jtTable = new JTable(dtmTable);
		jspJtTable = new JScrollPane(jtTable);
		
		tname = ctDAO.tableName();
		Collections.sort(tname);
		
		for(int i = 0; i< ctDAO.tableName().size(); i++) {
			jcbTable.addItem(tname.get(i));
		}
		
		TableEvt te = new TableEvt(this);
		jcbTable.addActionListener(te);
		
		JPanel jpNorth = new JPanel();
		jpNorth.add(jcbTable);
		
		add("North",jpNorth);
		add("Center",jspJtTable);
		
		setBounds(100,100,500,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public JComboBox<String> getJcbTable() {
		return jcbTable;
	}


	public JTable getJtTable() {
		return jtTable;
	}


	public DefaultTableModel getDtmTable() {
		return dtmTable;
	}


	public JScrollPane getJspJtTable() {
		return jspJtTable;
	}


	public void setJcbTable(JComboBox<String> jcbTable) {
		this.jcbTable = jcbTable;
	}


	public void setJtTable(JTable jtTable) {
		this.jtTable = jtTable;
	}


	public void setDtmTable(DefaultTableModel dtmTable) {
		this.dtmTable = dtmTable;
	}


	public void setJspJtTable(JScrollPane jspJtTable) {
		this.jspJtTable = jspJtTable;
	}
	
	
}

