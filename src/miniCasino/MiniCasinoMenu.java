package miniCasino;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class MiniCasinoMenu extends JFrame{
	private JLabel lblGameMenu,lblImage,lblAvatar,lblName,lblName_,lblID,lblID_,lblCash,lblCash_;
	private JButton btnHorseRace,btnEvenOdd,btnSlotM,btnRPS,btnPB;
	private MiniCasinoDAO dao = new MiniCasinoDAO();
	private JButton btnCharge;
	
	public MiniCasinoMenu(String id) {
		super("메뉴창");
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 145, 522);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblGameMenu = new JLabel("게임선택");
		lblGameMenu.setFont(new Font("굴림", Font.BOLD, 30));
		lblGameMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameMenu.setBounds(0, 10, 145, 41);
		pn1.add(lblGameMenu);
		
		btnHorseRace = new JButton("경마");
		btnHorseRace.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnHorseRace.setBounds(0, 76, 145, 41);
		pn1.add(btnHorseRace);
		
		btnEvenOdd = new JButton("홀짝게임");
		
		btnEvenOdd.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnEvenOdd.setBounds(0, 169, 145, 41);
		pn1.add(btnEvenOdd);
		
		btnSlotM = new JButton("슬롯머신");
		btnSlotM.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnSlotM.setBounds(0, 262, 145, 41);
		pn1.add(btnSlotM);
		
		btnRPS = new JButton("가위바위보");
		btnRPS.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnRPS.setBounds(0, 355, 145, 41);
		pn1.add(btnRPS);
		
		btnPB = new JButton("파워볼");
		btnPB.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		btnPB.setBounds(0, 448, 145, 41);
		pn1.add(btnPB);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(161, 10, 431, 522);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblImage = new JLabel("이미지용");
		lblImage.setBounds(0, 0, 431, 522);
		pn2.add(lblImage);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(596, 10, 176, 522);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		lblAvatar = new JLabel("아바타 창");
		lblAvatar.setBounds(0, 0, 176, 242);
		pn3.add(lblAvatar);
		
		lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0, 297, 57, 29);
		pn3.add(lblName);
		
		lblName_ = new JLabel(dao.getName(id));
		lblName_.setHorizontalAlignment(SwingConstants.CENTER);
		lblName_.setBounds(59, 297, 113, 29);
		pn3.add(lblName_);
		
		lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(0, 330, 57, 29);
		pn3.add(lblID);
		
		lblID_ = new JLabel(id);
		lblID_.setHorizontalAlignment(SwingConstants.CENTER);
		lblID_.setBounds(59, 330, 113, 29);
		pn3.add(lblID_);
		
		lblCash = new JLabel("게임머니");
		lblCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash.setBounds(0, 364, 57, 29);
		pn3.add(lblCash);
		
		DecimalFormat df = new DecimalFormat("###,###");
		lblCash_ = new JLabel( df.format(dao.getCashInfo(id))+"원");
		lblCash_.setHorizontalAlignment(SwingConstants.CENTER);
		lblCash_.setBounds(59, 364, 113, 29);
		pn3.add(lblCash_);
		
		btnCharge = new JButton("캐쉬충전");
		btnCharge.setFont(new Font("굴림", Font.BOLD, 20));
		btnCharge.setBounds(0, 434, 176, 88);
		pn3.add(btnCharge);
//		=========위는 UI 아래는 메소드영역===================================================
		//홀짝게임 버튼
		btnEvenOdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new EvenOdd(id);
			}
		});
		
		//캐쉬충전 버튼
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MiniCasinoCharge(id);
			}
		});
		setVisible(true);
	}
//	public static void main(String[] args) {
//		new MiniCasinoMenu();
//	}
}
