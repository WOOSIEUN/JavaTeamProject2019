import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame implements ActionListener{
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 500;
	public static final int ROW = 1000;
	public static final int COLUMN = 4;
	
	public MainFrame(int FID, String Name) {
		//������ ����
		super("Property Management System");
		setSize(400, 400);
		setResizable(false);		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//����¿� �ʿ��� ���� ����
		int date, amount, cnt = 0;
		String majorClassification, minorClassification;
		String fileName = (intToString(FID) + " " + Name +".txt");
		
		//���̺� ����� - ����� ������ �ҷ��� �迭 �����
		String tableHeader[] = {"��¥","��з�","�Һз�","�ݾ�"};
		String contents[][] = new String[ROW][COLUMN];
		
		//������ ���Ͽ��� ������ �ҷ��ͼ� contents �迭�� �����ϱ�.		
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream(fileName));			
		} catch (FileNotFoundException e) {
			System.out.println(fileName + "������ �������� �ʽ��ϴ�. ���α׷� ������ ���α׷��� �����մϴ�.");
			System.exit(0);
		}
		while (inputStream.hasNext()) {
			try {
				contents[cnt][0] = intToString(inputStream.nextInt());
				contents[cnt][1] = inputStream.next();
				contents[cnt][2] = inputStream.next();
				contents[cnt++][3] = intToString(inputStream.nextInt());
			} catch (InputMismatchException e) {
				System.out.println("���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
				System.exit(0);
			}
		}
		DefaultTableModel tableModel = new DefaultTableModel(contents,tableHeader);
		JTable accountTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(accountTable);
		
		add(scrollPane);
		inputStream.close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int stringToInt(String string) {
		return Integer.parseInt(string);
	}
	public String intToString(int integer) {
		return String.valueOf(integer);
	}
}
