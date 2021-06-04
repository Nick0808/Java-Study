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
	private Font usefont = new Font("���� ����", Font.BOLD, 20); // ��Ʈ�̸�, ��Ÿ��, ������
	
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
		
		lblInput = new JLabel("�Ÿ��� �Է��ϼ��� (Km) ");
		// Label�� ��Ʈ ���� : Font ��ü�� ���
		
		lblInput.setFont(usefont); // �۲�
		
		txtInput = new JTextField(7); // �ؽ�Ʈ �ʵ�
		txtInput.setFont(usefont);
		
		panel1.add(lblInput);
		panel1.add(txtInput);
		frame.add(panel1, BorderLayout.NORTH);
	}
	
	public void outputPanel() {
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel2.setBackground(Color.GREEN);
		
		lblOutput = new JLabel("��ȯ �� ���� �Է��ϼ��� (Mile) ");
		lblOutput.setFont(usefont);
		txtOutput = new JTextField(7); // �ؽ�Ʈ �ʵ�
		txtOutput.setFont(usefont);
		
		panel2.add(lblOutput);
		panel2.add(txtOutput);
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	public void compute() {
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel3.setBackground(Color.YELLOW);
		
		btnCompute = new JButton("���");
		btnCompute.setFont(usefont);
		
		panel3.add(btnCompute);
		frame.add(panel3, BorderLayout.SOUTH);
		
		// �̺�Ʈ ó��
		// �����ʸ� ����Ŭ������ �ۼ��ϰ� ��ư�� �ٷ� ����
		btnCompute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 1mile = 1.6km
				if(e.getSource() == btnCompute) {
					// ���� �����ϴ���
					if(txtInput.getText().equals("")) {
					System.out.println("�� ���Դϴ�.");	
					// ��ȭ����
					JOptionPane.showMessageDialog(null, "���� �Է��ϼ���", "error", JOptionPane.ERROR_MESSAGE);
					
					} else {
					double km = Double.parseDouble(txtInput.getText()); // �Էµ� ���ڵ����͸� �Ǽ��� ��ȯ
					txtOutput.setText(String.valueOf(km / 1.6)); // ������� ���ڿ���
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