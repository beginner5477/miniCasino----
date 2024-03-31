package miniCasino;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MiniCasinoMain extends JFrame{
	private JTextField txtID;
	private JPasswordField txtPwd;
	private JLabel lblTitle,lblID,lblPwd;
	private JButton btnFindID,btnLogin,btnFindPwd,btnSignup;
	private MiniCasinoDAO dao = new MiniCasinoDAO();
	private int res = 0;
	
	public MiniCasinoMain() {
		super("미니 카지노");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 73);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("Welcome to miniCasino");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 40));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 760, 73);
		pn1.add(lblTitle);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 93, 760, 458);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		btnLogin = new JButton("로그인");
		btnLogin.setFont(new Font("굴림", Font.BOLD, 25));
		
		
		txtPwd = new JPasswordField();
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 30));
		txtPwd.setBounds(230, 204, 349, 54);
		pn2.add(txtPwd);
		btnLogin.setBounds(591, 206, 134, 54);
		pn2.add(btnLogin);
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("굴림", Font.BOLD, 30));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(51, 125, 167, 54);
		pn2.add(lblID);
		
		lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("굴림", Font.BOLD, 30));
		lblPwd.setBounds(51, 204, 167, 54);
		pn2.add(lblPwd);
		
		txtID = new JTextField();
		txtID.setFont(new Font("굴림", Font.PLAIN, 30));
		txtID.setBounds(230, 124, 349, 55);
		pn2.add(txtID);
		txtID.setColumns(10);
		
		btnFindID = new JButton("아이디찾기");
		btnFindID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindID.setFont(new Font("굴림", Font.BOLD, 25));
		btnFindID.setBounds(93, 315, 190, 54);
		pn2.add(btnFindID);
		
		btnFindPwd = new JButton("비밀번호찾기");
		btnFindPwd.setFont(new Font("굴림", Font.BOLD, 25));
		btnFindPwd.setBounds(295, 315, 190, 54);
		pn2.add(btnFindPwd);
		
		btnSignup = new JButton("회원가입");
		btnSignup.setFont(new Font("굴림", Font.BOLD, 25));
		btnSignup.setBounds(497, 315, 190, 54);
		pn2.add(btnSignup);
//		==========위는 UI세팅===============아래는 메소드설정부=================================================
		//로그인 버튼
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = dao.getLoginInfo(txtID.getText(),txtPwd.getText());
				if(res == 1)
				{
					JOptionPane.showMessageDialog(null, "로그인 성공~");
					dispose();
					new MiniCasinoMenu(txtID.getText());
				}
				else JOptionPane.showMessageDialog(null, "로그인 실패...");
			}
		});
		
		
		
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new MiniCasinoMain();
	}
}
