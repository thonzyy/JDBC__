package day0817;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ZipcodeSearchDesign extends JFrame {
	private DefaultTableModel dtmZipcode;
	private JTable jtZipcode;
	private JScrollPane jspJtZipcode;
	private JTextField jtfDong, jtfSelZipcode, jtfSelAddr;
	private JButton jbtnSearch;
	
	public ZipcodeSearchDesign () {
		super("우편번호 검색");
		//Model 객체화 
		String[] columnNames= {"우편번호","주소"};
		
		//컬럼 크기 변경
	
		dtmZipcode = new DefaultTableModel(null, columnNames);
		jtZipcode = new JTable(dtmZipcode);
		
		jspJtZipcode = new JScrollPane(jtZipcode);
		jspJtZipcode.setBorder(new TitledBorder("우편번호 검색"));
		jtZipcode.getColumnModel().getColumn(0).setPreferredWidth(80);
		jtZipcode.getColumnModel().getColumn(1).setPreferredWidth(420);
		jtZipcode.setRowHeight(25);
		
		JLabel jlblDong = new JLabel("동이름");
		jtfDong = new JTextField(10);
		jbtnSearch = new JButton("조회");
		
		jtfSelZipcode = new JTextField(5);
		jtfSelAddr = new JTextField(20);
		
		JPanel jpNorth= new JPanel();
		jpNorth.add(jlblDong);
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnSearch);
		
		JPanel jpSouth= new JPanel();
		jpSouth.add(new JLabel("우편번호"));
		jpSouth.add(jtfSelZipcode);
		jpSouth.add(new JLabel("주소"));
		jpSouth.add(jtfSelAddr);
		
		add(jpNorth,"North");
		add(jspJtZipcode,"Center");
		ZipcodeSearchEvt zes = new ZipcodeSearchEvt(this);
		jbtnSearch.addActionListener(zes);
		jtfDong.addActionListener(zes);
		jtZipcode.addMouseListener(zes);
		setBounds(100,100,500,600);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}


	/**
	 * @return the jtfSelZipcode
	 */
	public JTextField getJtfSelZipcode() {
		return jtfSelZipcode;
	}


	/**
	 * @param jtfSelZipcode the jtfSelZipcode to set
	 */
	public void setJtfSelZipcode(JTextField jtfSelZipcode) {
		this.jtfSelZipcode = jtfSelZipcode;
	}


	/**
	 * @return the jtfSelAddr
	 */
	public JTextField getJtfSelAddr() {
		return jtfSelAddr;
	}


	/**
	 * @param jtfSelAddr the jtfSelAddr to set
	 */
	public void setJtfSelAddr(JTextField jtfSelAddr) {
		this.jtfSelAddr = jtfSelAddr;
	}


	/**T
	 * @return the dtmZipcode
	 */
	public DefaultTableModel getDtmZipcode() {
		return dtmZipcode;
	}


	/**
	 * @param dtmZipcode the dtmZipcode to set
	 */
	public void setDtmZipcode(DefaultTableModel dtmZipcode) {
		this.dtmZipcode = dtmZipcode;
	}


	/**
	 * @return the jtZipcode
	 */
	public JTable getJtZipcode() {
		return jtZipcode;
	}


	/**
	 * @param jtZipcode the jtZipcode to set
	 */
	public void setJtZipcode(JTable jtZipcode) {
		this.jtZipcode = jtZipcode;
	}


	/**
	 * @return the jspJtZipcode
	 */
	public JScrollPane getJspJtZipcode() {
		return jspJtZipcode;
	}


	/**
	 * @param jspJtZipcode the jspJtZipcode to set
	 */
	public void setJspJtZipcode(JScrollPane jspJtZipcode) {
		this.jspJtZipcode = jspJtZipcode;
	}


	/**
	 * @return the jtfDong
	 */
	public JTextField getJtfDong() {
		return jtfDong;
	}


	/**
	 * @param jtfDong the jtfDong to set
	 */
	public void setJtfDong(JTextField jtfDong) {
		this.jtfDong = jtfDong;
	}


	/**
	 * @return the jbtnSearch
	 */
	public JButton getJbtnSearch() {
		return jbtnSearch;
	}


	/**
	 * @param jbtnSearch the jbtnSearch to set
	 */
	public void setJbtnSearch(JButton jbtnSearch) {
		this.jbtnSearch = jbtnSearch;
	}


	public static void main(String[] args) {
		new ZipcodeSearchDesign();

	}//main

}//class
