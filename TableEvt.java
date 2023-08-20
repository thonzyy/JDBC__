package day0817;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.sql.SQLException;
import java.util.List;

public class TableEvt extends WindowAdapter implements ActionListener{
	
	private TableView tableView;
	
	public TableEvt(TableView tableView) {
		this.tableView = tableView;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == tableView.getJcbTable()) {
			selectTable();
		}
	}
	
	public void selectTable() {
		CheckTableDAO ctDAO = new CheckTableDAO();
		try {
			List<TableVO> list = ctDAO.selecTable(tableView.getJcbTable().getSelectedItem().toString());
			
			tableView.getDtmTable().setRowCount(0);
			
			String[] rowData = null;
			
			for(TableVO tVO : list) {
				rowData = new String[5];
				
				rowData[0] = tVO.getColumnName();
				rowData[1] = tVO.getDataType();
				
				if(tVO.getDataPrecision() != null) {
					rowData[2] = tVO.getDataPrecision();
				}else if (tVO.getDataPrecision() == null) {
					rowData[2] = tVO.getDataLength();
				}
				
				rowData[3] = tVO.getNullable();
				rowData[4] = tVO.getDataDefualt();
				
				tableView.getDtmTable().addRow(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
