package miniCasino;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class MiniCasinoCharge extends JFrame{
	private JTextField textField;
	private MiniCasinoDAO dao = new MiniCasinoDAO();
	private int res = 0;
	public MiniCasinoCharge(String id) {
		super("캐쉬 충전");
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAvatar = new JLabel("아바타 창");
		lblAvatar.setBounds(296, 10, 176, 242);
		getContentPane().add(lblAvatar);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(296, 307, 57, 29);
		getContentPane().add(lblName);
		
		JLabel lblName_ = new JLabel(dao.getName(id));
		lblName_.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_.setBounds(355, 307, 113, 29);
		getContentPane().add(lblName_);
		
		JLabel lblID_ = new JLabel(id);
		lblID_.setHorizontalAlignment(SwingConstants.CENTER);
		lblID_.setBounds(355, 340, 113, 29);
		getContentPane().add(lblID_);
		
		JLabel lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(296, 340, 57, 29);
		getContentPane().add(lblID);
		
		JLabel lblCash = new JLabel("게임머니");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setBounds(296, 374, 57, 29);
		getContentPane().add(lblCash);
		
		DecimalFormat df = new DecimalFormat("###,###");
		JLabel lblCash_ = new JLabel(df.format(dao.getCashInfo(id))+"원");
		lblCash_.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash_.setBounds(355, 374, 113, 29);
		getContentPane().add(lblCash_);
		
		JLabel lblNewLabel = new JLabel("충전할 금액을 입력하세요:");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 453, 233, 39);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setBounds(281, 453, 334, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("원");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(624, 453, 27, 39);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("충전하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res = dao.setCharge(id,Integer.parseInt(textField.getText()));
				if(res != 0) JOptionPane.showMessageDialog(null, textField.getText()+"원이 충전되었습니다.");
				else JOptionPane.showMessageDialog(null, "충전실패.");
				lblCash_.setText(df.format(dao.getCashInfo(id))+"원");
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
		btnNewButton.setBounds(663, 454, 121, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("뒤로가기(메뉴)");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MiniCasinoMenu(id);
			}
		});
		btnBack.setFont(new Font("굴림", Font.PLAIN, 12));
		btnBack.setBounds(632, 71, 140, 29);
		getContentPane().add(btnBack);
		
		
		
		setVisible(true);
	}
}
