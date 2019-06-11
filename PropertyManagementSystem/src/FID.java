import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* ������ȣ ���� ���α׷�  */
public class FID extends JFrame implements ActionListener {

	private JTextField id;

	public FID() { // â ����

		setSize(600, 150);
		setLocation(960, 500);
		setTitle("FID ����");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel j = new JPanel();
		setLayout(new FlowLayout());

		// ��ư, ���� ������ȣ â ����
		JLabel label = new JLabel("FID");
		add(label);

		id = new JTextField(20);
		add(id);

		JButton FidButton = new JButton("FID ����");
		add(FidButton);

		// '�Ϸ�'������ â ����
		JButton Closed = new JButton("�Ϸ�");
		Closed.addActionListener(this);
		add(Closed);

		// ��ư ����
		FidButton.addActionListener(this);

		// ��ü ���
		add(j);

	}

	public static String ID() {
		// ���� ��ȣ 6�ڸ� ���� ����
		Random rand = new Random();
		String num = "";
		boolean isDuplicated = true; //FID ���Ͽ��� �ߺ��� �ִ��� Ȯ��		
		String ran = null;
		while (isDuplicated == true) {			
			for (int i = 0; i < 6; i++) {
				ran = Integer.toString(rand.nextInt(10) + 0);
				if(num.contains(ran)) {
					i-=1;
				} else {
					num += ran;
				}
			}
			//�ߺ�Ȯ��
			Scanner inputStream = null;
			try {
				inputStream = new Scanner(new FileInputStream("./Data/Login/FID.txt"));
				while (inputStream.hasNextInt()) {
					int checknumber = inputStream.nextInt();
					if (checknumber == stringToInt(ran)) {
						isDuplicated = true;
					} else {
						isDuplicated = false;
					}
				}
				inputStream.close();	
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "����ġ ���� ���� �߻�. �����ڿ��� �����ϼ���.");
			}
		}
		return num;
	}

	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();
		
		if (buttonString.equals("FID ����")) { // '������ȣ ����'��ư ������ �� ���� ����
			// â�� ������ȣ ����
			id.setText(ID());
			id.setEditable(false);
			JOptionPane.showMessageDialog(null, "������ȣ�� �����Ǿ����ϴ�.");
			
		} else if (buttonString.equals("�Ϸ�")) {			
			// ���� ��ȣ ���Ͽ� ����
			PrintWriter createFIDFile = null;
			PrintWriter outputStream = null;
			try {
				createFIDFile = new PrintWriter(new FileOutputStream("./Data/Account/" + id.getText() + ".txt"));
				outputStream = new PrintWriter(new FileOutputStream("./Data/Login/FID.txt", true));
				// ���� ���� ���� ����
				createFIDFile.println("0");
				createFIDFile.close();
				// �ؽ�Ʈ ���Ͽ� FID ����
				outputStream.println("\n" + id.getText());
				outputStream.close();

			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(null, "����ġ ���� ���� �߻�. �����ڿ��� �����ϼ���.");
			}
			this.dispose();
			
		} else // ����ó��
			JOptionPane.showMessageDialog(null, "����ġ ���� ���� �߻�. �����ڿ��� �����ϼ���.");
	}

	public static int stringToInt(String string) {
		return Integer.parseInt(string);
	}

	public String intToString(int integer) {
		return String.valueOf(integer);
	}

}