import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class DistanceFrame extends JFrame {
	private Container frame;
	private JPanel panel1, panel2, panel3;
	private JLabel lblInput, lblOutput;
	private JTextField txtInput, txtOutput;
	private JButton btnCompute;
	private Font usefont = new Font("맑은 고딕", Font.BOLD, 20); // 폰트이름, 스타일, 사이즈
	
	public DistanceFrame() {
		// TODO Auto-generated constructor stub
		setTitle("Conversion");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame = getContentPane();
		frame.setLayout(new BorderLayout());
		
		inputPanel();
		outputPanel();
		compute();
		
		this.pack();
		this.setVisible(true);
		
	}
	
	public void inputPanel() {
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel1.setBackground(Color.CYAN);
		
		lblInput = new JLabel("거리를 입력하세요 (Km) ");
		// Label의 폰트 설정 : Font 객체를 사용
		
		lblInput.setFont(usefont); // 글꼴
		
		txtInput = new JTextField(7); // 텍스트 필드
		txtInput.setFont(usefont);
		
		panel1.add(lblInput);
		panel1.add(txtInput);
		frame.add(panel1, BorderLayout.NORTH);
	}
	
	public void outputPanel() {
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel2.setBackground(Color.GREEN);
		
		lblOutput = new JLabel("변환 된 마일 입력하세요 (Mile) ");
		lblOutput.setFont(usefont);
		txtOutput = new JTextField(7); // 텍스트 필드
		txtOutput.setFont(usefont);
		
		panel2.add(lblOutput);
		panel2.add(txtOutput);
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	public void compute() {
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel3.setBackground(Color.YELLOW);
		
		btnCompute = new JButton("계산");
		btnCompute.setFont(usefont);
		
		panel3.add(btnCompute);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// 이벤트 처리
		// 리스너를 무명클래스로 작성하고 버튼에 바로 장착
		btnCompute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 1mile = 1.6km
				if(e.getSource() == btnCompute) {
					// 값이 존재하는지
					if(txtInput.getText().equals("")) {
					System.out.println("빈 값입니다.");	
					// 대화상자
					JOptionPane.showMessageDialog(null, "값을 입력하세요", "error", JOptionPane.ERROR_MESSAGE);
					
					} else {
					double km = Double.parseDouble(txtInput.getText()); // 입력된 문자데이터를 실수로 변환
					txtOutput.setText(String.valueOf(km / 1.6)); // 계산결과를 문자열로
					}
					
					
					
				}
			}
		});
	}
}

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DistanceFrame();
	}

}
