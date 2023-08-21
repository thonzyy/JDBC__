package day0821;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class LoginFormEvt extends WindowAdapter implements ActionListener {

	private LoginForm lf;
	
	public LoginFormEvt(LoginForm lf) {
		this.lf = lf;
	}
	
	
	
	@Override
	public void windowClosing(WindowEvent e) {
		lf.dispose();
	}



	@Override
	public void actionPerformed(ActionEvent ae) {
		chkEmpty();
	}
	
	public String InjectionBlock(String sql) {
		String resultSql = 
		sql.replaceAll(" ", "").replaceAll("--", "").replace("select", "")
		.replaceAll("insert", "").replaceAll("delete", "");
		return resultSql;
	}
	private void chkEmpty() {
		String id = lf.getJtfId().getText().trim();
		// 아이디가 비어있다면 경고창으로 아이디 입력을 보여준다.
		if("".equals(id)) {
			JOptionPane.showMessageDialog(lf, "아이디는 필수 입력!!!");
			lf.getJtfId().requestFocus();
			return;
		}
		
		// 비밀번호가 비어있다면 경고창으로 비밀번호 입력을 보여준다.
		String pass = new String(lf.getJpfPass().getPassword());
		if("".equals(pass)) {
			JOptionPane.showMessageDialog(lf, "비밀번호는 필수 입력!!!");
			lf.getJpfPass().requestFocus();
			return;
		}
		
		// 그렇지 않으면 loginCheck()를 호출한다.
//		id=InjectionBlock(id); id와 비밀번호에 sqlinjection에 해당하는 값이 존재하면 삭제
//		pass=InjectionBlock(pass);
		LoginVO lVO = new LoginVO(id,pass);
		loginCheck(lVO);
		
	}//chkEmpty
	
	private void loginCheck(LoginVO lVO) {
		InjectionTestDAO itDAO = InjectionTestDAO.getInstance();
		
		try {
//			LoginResultVO lrVO = itDAO.useStatementLogin(lVO);
		LoginResultVO lrVO = itDAO.usePreparedStatementLogin(lVO);

			if (lrVO == null) {
				JOptionPane.showMessageDialog(lf, "아이디나 비밀번호를 확인해주세요.");
				lf.getJlblOutput().setText("");
				return;
			}
			
			lf.getJlblOutput().setText(lrVO.getName() + "님 로그인 하셨습니다." + lrVO.getInput_date());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
