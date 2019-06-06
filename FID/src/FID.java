
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* ������ȣ ���� ���α׷�  */
public class FID extends JFrame implements ActionListener{ 

	
	private JTextField id;
	
	
	public FID() { //â ����
		
		setSize(600,150);
		setTitle("���� ���� ��ȣ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel j = new JPanel();
		setLayout(new FlowLayout());
		
		
		//��ư, ���� ������ȣ â ����
		JLabel label = new JLabel("���� ������ȣ");
		add(label);
		
		id = new JTextField(20);
		add(id);
		
		JButton FidButton =new JButton("������ȣ ����");
		add(FidButton);
		
		//'�Ϸ�'������ â ����
		JButton Closed = new JButton("�Ϸ�");
		Ending End = new Ending();
		Closed.addActionListener(End);
		add(Closed);
	  
	    //��ư ����
		FidButton.addActionListener(this);
		
		//��ü ���
		add(j);
		
	}
	
	public static void main(String[] args) {
		
		   FID f=new FID();
		   f.setVisible(true);
		   
	}
		


	public static String ID() {
		
		//���� ��ȣ 6�ڸ� ���� ����
		Random rand = new Random();
		String num = "";
			
		for(int i=0;i<6;i++) {
					
			String ran = Integer.toString(rand.nextInt(9)+1);
					
			if(num.contains(ran)) {
				i-=1;
			}			
			else
				num += ran;
			}
				
		return num;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String buttonString = e.getActionCommand();
				
			if (buttonString.equals("������ȣ ����")) { //'������ȣ ����'��ư ������ �� ���� ����
				
				// ���� ��ȣ ���Ͽ� ����(�����ؼ�)
				PrintWriter outputStream=null;
				try {
					outputStream = new PrintWriter(new FileOutputStream("FID.txt",true));
				} 
				catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
			
				// â�� ������ȣ ����
				id.setText(ID());
				//�ؽ�Ʈ ���Ͽ� ������ȣ ����
				outputStream.println(id.getText());
				outputStream.close();
				
				JOptionPane.showMessageDialog(null, "������ȣ�� �����Ǿ����ϴ�.");
				//JOptionPane.CLOSED_OPTION;
			}
				
		else
			//���� 
		     id.setText(getWarningString());
		
		
			
	}
	
}
 

