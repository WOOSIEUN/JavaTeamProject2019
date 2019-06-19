import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Help extends JFrame implements ActionListener {
	
	JTextArea helpTextArea;
	
	public Help() {
		setTitle("����");
		setSize(460, 600);
		setResizable(false);
		setLocation(960, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JLabel guideLabel = new JLabel("�ϴ� ��ư �� �ȳ��� ���ϴ� �׸��� �������ּ���.");
		add(guideLabel, BorderLayout.NORTH);
		
		helpTextArea = new JTextArea(10,10);
		helpTextArea.setEditable(false);	
		helpTextArea.setLineWrap(true);
		JScrollPane helpScroll = new JScrollPane(helpTextArea);
		helpScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(helpScroll, BorderLayout.CENTER);
		
		JPanel selectGuide = new JPanel();
		selectGuide.setLayout(new BoxLayout(selectGuide, BoxLayout.X_AXIS));
		
		JButton systemIntroduction = new JButton("�ý��� �ȳ�");
		systemIntroduction.addActionListener(this);
		selectGuide.add(systemIntroduction);
		
		JButton signUpAndIn = new JButton("���԰� �α���");
		signUpAndIn.addActionListener(this);
		selectGuide.add(signUpAndIn);
		
		JButton useProgram = new JButton("�̿� �ȳ�");
		useProgram.addActionListener(this);
		selectGuide.add(useProgram);
		
		JButton advancedSetting = new JButton("��� ����");
		advancedSetting.addActionListener(this);
		selectGuide.add(advancedSetting);
		
		JButton errorguide = new JButton("����");
		errorguide.addActionListener(this);
		selectGuide.add(errorguide);
		
		add(selectGuide, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("�ý��� �ȳ�")) {
			helpTextArea.setText("�ý��� �ȳ�\r\n" + 
					"\r\n" + 
					"���� ���� �ڻ� ���� �ý��� �Դϴ�.\r\n" + 
					"���� ���¿� ���� ���·� ������ �ڻ��� ������ �� ������, ���� ������ �Բ� ���� ���¸� ����ϰ� ������ �� �ֽ��ϴ�.");
		} else if (event.equals("���԰� �α���")) {
			helpTextArea.setText("����\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"1. FID (���� ���� ��ȣ)\r\n" + 
					"- ������ �ĺ��� FID�� ���� �̷�����ϴ�.\r\n" + 
					"- FID ������ �ʼ����̸�, ������ �ϳ��� FID�� �ʿ��մϴ�.\r\n" + 
					"-  �������� FID ���� ���� ����صνñ� �ٶ�� FID �нǽ� �����ڿ��� �������ֽñ� �ٶ��ϴ�.\r\n" + 
					"- ������ �ƴ� Ÿ�ΰ� FID�� �������� ���ʽÿ�. ���� ���������� ������ ����� ���ɼ��� �ֽ��ϴ�.\r\n" + 
					"\r\n" + 
					"2. ȸ������\r\n" + 
					"- ������ ���ؼ� ���� ������ȣ�� ��ȿ�� �˻�� ID �ߺ��˻縦 �ʿ�� �մϴ�.\r\n" + 
					"- �� ���� �˻縦 ������ ���ϸ� ������ �Ͻ� �� �����ϴ�.\r\n" + 
					"- ȸ�� ���� ���� ���� ������ �ʿ��� �ÿ� �����ڿ��� �������ּ���.\r\n" + 
					"\r\n" + 
					"3. �α���\r\n" + 
					"- �н����� �Է� �� ���͸� ġ�� �α��� ��ư�� ������ �ʰ� �α����� �� �� �ֽ��ϴ�.");
		} else if (event.equals("�̿� �ȳ�")) {
			helpTextArea.setText("�̿� �ȳ�\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"1. ȭ�� �Ұ�\r\n" + 
					"- ������ ���� ����, �������� ���� �����Դϴ�. ���� ������ ������ ���θ� �� �� �ֽ��ϴ�.\r\n" + 
					"- �ϴܿ��� �߰�, ����, ������ �� �� �ִ� �޴��� �ֽ��ϴ�.\r\n" + 
					"- ��� �޴����� ����, ���� ����, ������ �� �� �ֽ��ϴ�.\r\n" + 
					"- �� ���� ������ ����, ����, ������ �� �� �ִ� ������ �ֽ��ϴ�. �ش� ������ �߰�, ����, ���� ���� ����˴ϴ�.\r\n" + 
					"\r\n" + 
					"2. ������ �߰�\r\n" + 
					"- ��¥�� �� �� �� ������ ���̳� ��ǥ ���� ���ڸ� �Է����ּ���. (ex.2000.01.01)\r\n" + 
					"- ��з����� ���� �Ǵ� ���� �� �� ������ �������ּ���.\r\n" + 
					"- �Һз����� ���ϴ� ���� �Է��� �� �ֽ��ϴ�. (ex. ����, �뵷, �ĺ�)\r\n" + 
					"- �ݾ׶����� ������ �Է����ּ���.\r\n" + 
					"- ���� �Ǵ� ������ �����ؼ� �߰��� ������ ���¿� �߰��� �˴ϴ�.\r\n" + 
					"- ��� ĭ���� ���⸦ �ؼ��� �ȵ˴ϴ�. ���α׷� ������ �����ϴ� ���⸦ ���� ���� ���ʽÿ�.\r\n" + 
					"- ��ĭ�� �Է����� ���ʽÿ�. �� ���� ���α׷� ������ ������ �˴ϴ�.\r\n" + 
					"\r\n" + 
					"3. ������ ����\r\n" + 
					"- ������ ������ �� ���� ���� �� ���� ��ư�� ������ �����Ͱ� �����˴ϴ�.\r\n" + 
					"\r\n" + 
					"4. ������ ����\r\n" + 
					"- ��¥, ��з�, �Һз�, �ݾ� �� ������ ���� ���� �Է��Ͻʽÿ�.\r\n" + 
					"- �Է� �� ���� ��������, ���� �������� �������ֽʽÿ�.\r\n" + 
					"- �� ������ �Ϸ��ϰ� ������ ���� �����Ͻʽÿ�, �� �� �ٷ� ������ ������ ���������� ������ �˴ϴ�.\r\n" + 
					"- ���� ����Ŭ���Ͽ� ������ �� �հ� ����� ���������� �۵����� �ʽ��ϴ�,\r\n" + 
					"- ��� ĭ���� ���⸦ �ؼ��� �ȵ˴ϴ�. ���α׷� ������ �����ϴ� ���⸦ ���� ���� ���ʽÿ�.\r\n" + 
					"- ��ĭ�� �Է����� ���ʽÿ�. �� ���� ���α׷� ������ ������ �˴ϴ�.\r\n" + 
					"\r\n" + 
					"5. ������ ����\r\n" + 
					"- ��� �޴� - ������ Ŭ���ϸ� ������ �˴ϴ�.\r\n" + 
					"- ������ ���ÿ� �ý����� ����� �� ���� ������ �߰�, ����, ������ ���������� �۵����� ���� �� �ֽ��ϴ�.\r\n" + 
					"- ���� �� �ݵ�� ������ ���뿡 ������ ������ Ȯ�����ּ���.\r\n" + 
					"\r\n" + 
					"6. ���� ����\r\n" + 
					"- FID�� ���� ȸ���� ����� �����ݴϴ�.\r\n" + 
					"- ������ �ƴ� ȸ���� ��Ͽ� �ִٸ� �����ڿ��� �����ּ���.\r\n" + 
					"\r\n" + 
					"7. ����\r\n" + 
					"- �̿�� ������ ����� ������ �� �ֽ��ϴ�.\r\n" + 
					"- �� �� �ñ��� ���̳� ������ �߰ߵǸ� �����ڿ��� �����ּ���.");
		} else if (event.equals("��� ����")) {
			helpTextArea.setText("��� ����\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"1. �ش� ���α׷��� FID.txt, ID.txt, JoinMembership.txt ������ ù ����ÿ��� �ݵ�� �����ؾ� �մϴ�.\r\n" + 
					"\r\n" + 
					"2. FID ID JoinMembership ���Ͽ� �׽�Ʈ ���̽� �ϳ��� �� �Է��ؾ��ϸ�, ./Data/Account ������ ����, ���� ������ ���� �ϳ��� �ʼ������� �Է��ؾ��մϴ�.");
		} else if (event.equals("����")) {
			helpTextArea.setText("����\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"��Ÿ ���� �߻��� �����ڿ��� �������ּ���.\r\n" + 
					"\r\n" + 
					"����ó : ramtk6726@naver.com");
		} else {
			JOptionPane.showMessageDialog(null, "����ġ ���� ���� �߻�. �����ڿ��� �����ϼ���.");
		}		
	}
	
}
