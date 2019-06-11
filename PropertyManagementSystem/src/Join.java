import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Join extends JFrame implements ActionListener {

	private JTextField tfid;
	private JTextField tid;
	private JTextField tpw;
	private JTextField tn;
	private JTextField tr;
	boolean isExist;
	boolean isDuplicated;

	public Join() {
		
		//FID ���� Ȯ�ΰ� ���̵� �ߺ��� Ȯ���ϴ� boolean ������ ������ �ʱ�ȭ. (�ش� ������ ���� ���� ����)
		isExist = false;
		isDuplicated = true;

		JPanel p = new JPanel();

		// ���� �׸����� ���
		JLabel lfid = new JLabel("������ȣ");
		JLabel lid = new JLabel("���̵�");
		JLabel lpw = new JLabel("��й�ȣ");
		JLabel ln = new JLabel("�̸�");
		JLabel lr = new JLabel("��������");

		// �ߺ�Ȯ�� ��ư
		JButton a1 = new JButton("FID ��ȿ�� �˻�");
		JButton a2 = new JButton("���̵� �ߺ�üũ");

		// �� �׸񺰷� �ؽ�Ʈâ �����
		tfid = new JTextField();
		tid = new JTextField();
		tpw = new JTextField();
		tn = new JTextField();
		tr = new JTextField();

		// ȭ�鿡 ǥ��
		add(lfid);
		add(tfid);
		add(a1);
		add(lid);
		add(tid);
		add(a2);
		add(lpw);
		add(tpw);
		add(ln);
		add(tn);
		add(lr);
		add(tr);

		// ��ư ���� �� ȭ�鿡 ǥ��

		JButton j1 = new JButton("����");
		JButton j2 = new JButton("���");
		add(j1);
		add(j2);

		// �׸񺰷� ��ġ ����
		lfid.setBounds(40, 30, 80, 40);
		lid.setBounds(40, 70, 80, 40);
		lpw.setBounds(40, 110, 80, 40);
		ln.setBounds(40, 150, 80, 40);
		lr.setBounds(40, 190, 80, 40);

		tfid.setBounds(120, 30, 150, 40);
		tid.setBounds(120, 70, 150, 40);
		tpw.setBounds(120, 110, 150, 40);
		tn.setBounds(120, 150, 150, 40);
		tr.setBounds(120, 190, 150, 40);

		a1.setBounds(300, 30, 200, 40);
		a2.setBounds(300, 70, 200, 40);

		j1.setBounds(160, 330, 80, 30);
		j2.setBounds(290, 330, 80, 30);

		// ��ư �������� ����ǵ���
		a1.addActionListener(this);
		a2.addActionListener(this);
		j1.addActionListener(this);
		j2.addActionListener(this);

		// ��ü ��� ȭ�鿡 ǥ��
		add(p);
		setSize(550, 500);
		setTitle("ȸ������");
		setLocation(960, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		try {
			String buttonString = e.getActionCommand();			
			int number1;
			
			// ���� ��ȣ ��ȿ�� üũ�ϱ�
			if (buttonString.equals("FID ��ȿ�� �˻�")) {
				Scanner in = new Scanner(new FileInputStream("./Data/Login/FID.txt"));
				while (in.hasNextInt()) {
					number1 = in.nextInt();
					if (number1 == (stringToInt(tfid.getText()))) {
						isExist = true;
						break;
					}
				}
				in.close();
				if (isExist == true) {
					JOptionPane.showMessageDialog(null, "�����ϴ� FID�Դϴ�.");
					tfid.setEditable(false);					
				} else {
					JOptionPane.showMessageDialog(null, "FID�� �������� �ʽ��ϴ�.");
				}
			}

			// ���̵� �ߺ� üũ�ϱ�
			else if (buttonString.equals("���̵� �ߺ�üũ")) {
				Scanner input = new Scanner(new FileReader("./Data/Login/ID.txt"));				
				while (input.hasNext()) {
					String str = input.next();
					if (str.equals(tid.getText())) {
						isDuplicated = true;
						break;
					} else {
						isDuplicated = false;
					}
				}
				input.close();
				if (isDuplicated == true) {
					JOptionPane.showMessageDialog(null, "�ߺ��� ���̵��Դϴ�");
				} else {
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�");
					tid.setEditable(false);
				}
			}
			
			// ���� ��ư ������ �ؽ�Ʈ���Ͽ� �Է�
			else if (buttonString.equals("����")) {
				if (isDuplicated == false && isExist == true) { // ������ȣ�� �ְ� ���̵� �ߺ� Ȯ���� ������� ��
					PrintWriter createFIDNameFile = new PrintWriter(new FileOutputStream("./Data/Account/" + tfid.getText() + " " + tn.getText() + ".txt"));
					PrintWriter output = new PrintWriter(new FileWriter("./Data/Login/ID.txt", true));
					PrintWriter outputStream = new PrintWriter(new FileWriter("./Data/Login/JoinMembership.txt", true));
					//������ ����
					outputStream.println(tfid.getText() + " " + tid.getText() + " " + tpw.getText() + " " + tn.getText() + " " + tr.getText() + " ");
					output.println("");
					output.println("" + tid.getText());
					outputStream.close();
					output.close();
					//���� ���� ���� ����
					createFIDNameFile.println("0");
					createFIDNameFile.close();
					//�˾�â ���� ����
					JOptionPane.showMessageDialog(null, "ȸ�������� �����߽��ϴ�!");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "FID ��ȿ�� Ȯ�ΰ� ID �ߺ�üũ�� Ȯ�� ���ּ���.");
				}
			}
			
			// ��ҹ�ư ������ ȸ������ ���
			else if (buttonString.equals("���")) {
				this.dispose();
			}
			
			// ����ó��
			else
				JOptionPane.showMessageDialog(null, "����ġ ���� ���� �߻�. �����ڿ��� �����ϼ���.");
		} catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
		}
	}

	private static int stringToInt(String text) {
		return Integer.parseInt(text.trim());
	}
}
