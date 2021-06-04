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
		this.setTitle("피자주문");
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
	// 라디오버튼을 하나로 그룹
	private ButtonGroup grpPizza = new ButtonGroup();
	// 가격
	private static int price;
	
	public PizzaType() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(3, 2));
		this.setBorder(BorderFactory.createTitledBorder("Pizza Menu"));
		this.setPreferredSize(new Dimension(350, 350));
		
		for(int count = 0; count < 3; count++) {
			String name = String.format("%s (%d원)", namePizza[count], pricePizza[count]);
			// 라디오버튼 정의
			rdoPizza[count] = new JRadioButton(name);
			grpPizza.add(rdoPizza[count]);
			this.add(rdoPizza[count]);
			
			// 피자 이미지 가져오기
			imgPizza[count] = new ImageIcon("image/pizza"+(count+1)+".jpg");
			// 이미지 사이즈 조정 -> 이미지를 Image객체로 가져와야 함
			Image img = imgPizza[count].getImage().getScaledInstance(100, 100, 0);
			// Image 객체 -> ImageIcon으로 변환
			imgPizza[count] = new ImageIcon(img);
			// 이미지를 담기 위한 레이블
			lblPizza[count] = new JLabel(imgPizza[count]);
			this.add(lblPizza[count]);
			
			// 라디오버튼에 이벤트 장착
			rdoPizza[count].addItemListener(new PizzaItemClickListener());
	
		}
	}
	
	public static int getPrice() {
		return price;
	}
	
	// 라디오 버튼 이벤트 리스너
	// 선택이 변경될때마다 이벤트가 발생
	class PizzaItemClickListener implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) { // 아이템 상태가 변경될 때마다 콜백.
			// TODO Auto-generated method stub
			// 선택 여부를 모두 검사
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
		
		lblnumber = new JLabel("주문 개수 : ");
		txtNumber = new JTextField(5);
		panel.add(lblnumber);
		panel.add(txtNumber);
		this.add(panel);
		
		chkTake = new JCheckBox("To go");
		this.add(chkTake);
		
		// 체크박스 선택에 따른 이벤트 처리
		chkTake.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				// 체크여부 확인
				// e : 클릭한 체크박스의 정보가 e로 넘어감
				if(e.getStateChange() == ItemEvent.SELECTED) {
					togo = 1500;
				} else {
					togo = 0;
				}
			}
		});
		
		btnOrder = new JButton("결제");
		btnOrder.setPreferredSize(new Dimension(120, 50));
		this.add(btnOrder);
		
		lblPrice = new JLabel("금액");
		this.add(lblPrice);
		
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtNumber.getText().equals("")) {
					lblPrice.setText("개수를 입력하세요.");
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
