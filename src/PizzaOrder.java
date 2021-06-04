import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class PizzaFrame extends JFrame {
	private Container frame;
	
	public PizzaFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("�����ֹ�");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame = getContentPane();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		
		PizzaType type = new PizzaType();
		frame.add(type);
		
		PizzaOrder order = new PizzaOrder();
		frame.add(order);
		
		this.pack();
		this.setVisible(true);
	}
}

class PizzaType extends JPanel {
	private JRadioButton[] rdoPizza = new JRadioButton[3];
	private JLabel[] lblPizza = new JLabel[3];
	private ImageIcon[] imgPizza = new ImageIcon[3];
	private String[] namePizza = {"Hawaiian Pizza", "Potato Pizza", "Cheese Pizza"};
	private int[] pricePizza = {15000, 16000, 13000};
	// ������ư�� �ϳ��� �׷�
	private ButtonGroup grpPizza = new ButtonGroup();
	// ����
	private static int price;
	
	public PizzaType() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(BorderFactory.createTitledBorder("Pizza Menu"));
		this.setPreferredSize(new Dimension(350, 350));
		
		for(int count = 0; count < 3; count++) {
			String name = String.format("%s (%d��)", namePizza[count], pricePizza[count]);
			// ������ư ����
			rdoPizza[count] = new JRadioButton(name);
			grpPizza.add(rdoPizza[count]);
			this.add(rdoPizza[count]);
			
			// ���� �̹��� ��������
			imgPizza[count] = new ImageIcon("image/pizza"+(count+1)+".jpg");
			// �̹��� ������ ���� -> �̹����� Image��ü�� �����;� ��
			Image img = imgPizza[count].getImage().getScaledInstance(100, 100, 0);
			// Image ��ü -> ImageIcon���� ��ȯ
			imgPizza[count] = new ImageIcon(img);
			// �̹����� ��� ���� ���̺�
			lblPizza[count] = new JLabel(imgPizza[count]);
			this.add(lblPizza[count]);
			
			// ������ư�� �̺�Ʈ ����
			rdoPizza[count].addItemListener(new PizzaItemClickListener());
	
		}
	}
	
	public static int getPrice() {
		return price;
	}
	
	// ���� ��ư �̺�Ʈ ������
	// ������ ����ɶ����� �̺�Ʈ�� �߻�
	class PizzaItemClickListener implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) { // ������ ���°� ����� ������ �ݹ�.
			// TODO Auto-generated method stub
			// ���� ���θ� ��� �˻�
			for(int count = 0; count < 3; count++) {
				if(rdoPizza[count].isSelected())
					price = pricePizza[count];
			}
		}
	}
	
}


public class PizzaOrder extends JPanel{
	private JPanel panel;
	private JLabel lblnumber, lblPrice;
	private JTextField txtNumber;
	private JCheckBox chkTake;
	private JButton btnOrder;
	private int togo;
	
	
	public PizzaOrder() {
	// TODO Auto-generated constructor stub
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		this.setPreferredSize(new Dimension(150, 350));
		this.setBorder(BorderFactory.createTitledBorder("Order"));
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
		
		lblnumber = new JLabel("�ֹ� ���� : ");
		txtNumber = new JTextField(5);
		panel.add(lblnumber);
		panel.add(txtNumber);
		this.add(panel);
		
		chkTake = new JCheckBox("To go");
		this.add(chkTake);
		
		// üũ�ڽ� ���ÿ� ���� �̺�Ʈ ó��
		chkTake.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				// üũ���� Ȯ��
				// e : Ŭ���� üũ�ڽ��� ������ e�� �Ѿ
				if(e.getStateChange() == ItemEvent.SELECTED) {
					togo = 1500;
				} else {
					togo = 0;
				}
			}
		});
		
		btnOrder = new JButton("����");
		btnOrder.setPreferredSize(new Dimension(120, 50));
		this.add(btnOrder);
		
		lblPrice = new JLabel("�ݾ�");
		this.add(lblPrice);
		
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtNumber.getText().equals("")) {
					lblPrice.setText("������ �Է��ϼ���.");
				} else {
					int totalPrice = PizzaType.getPrice(); 
					totalPrice *= Integer.parseInt(txtNumber.getText());
					totalPrice -= togo;
					lblPrice.setText(Integer.toString(totalPrice));
				}
			}
		});
		
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PizzaFrame();
	}

}
