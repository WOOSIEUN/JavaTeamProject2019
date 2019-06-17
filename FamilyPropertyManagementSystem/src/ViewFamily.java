import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ViewFamily extends JFrame {

	public ViewFamily(String FID) {
		setTitle("���� ����");
		setSize(200, 300);
		setResizable(false);
		setLocation(960, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());

		Scanner inputStream = null;
		String tableHeader[] = {"���̵�", "�̸�", "��������"};
		String viewFamilyContents[][] = null;
		String tFID = null, tID = null, tPW = null, tName = null, tRelation = null;
		
		int cnt = 0;
		try {
			inputStream = new Scanner(new FileInputStream("./Data/Login/JoinMembership.txt"));
			while (inputStream.hasNext()) {
				tFID = inputStream.next();
				tID = inputStream.next();
				tPW = inputStream.next();
				tName = inputStream.next();
				tRelation = inputStream.next();
				if (tFID.equals(FID)) cnt++;
			}
			viewFamilyContents = new String[cnt][3];
			inputStream.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�. ���α׷� ������ ���α׷��� �����մϴ�.");
			System.exit(0);
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
			System.exit(0);
		}
		try {
			int rowcnt = 0;
			inputStream = new Scanner(new FileInputStream("./Data/Login/JoinMembership.txt"));
			while (inputStream.hasNext()) {
				tFID = inputStream.next();
				tID = inputStream.next();
				tPW = inputStream.next();
				tName = inputStream.next();
				tRelation = inputStream.next();
				if (tFID.equals(FID)) {
					viewFamilyContents[rowcnt][0] = tName;
					viewFamilyContents[rowcnt][1] = tID;
					viewFamilyContents[rowcnt++][2] = tRelation;
				}
			}
			inputStream.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʽ��ϴ�. ���α׷� ������ ���α׷��� �����մϴ�.");
			System.exit(0);
		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
			System.exit(0);
		}
		//���̺����
		DefaultTableModel viewFamilyTableModel = new DefaultTableModel(viewFamilyContents, tableHeader);
		JTable viewfamilyAccountTable = new JTable(viewFamilyTableModel);
		JScrollPane viewFamilyScrollPane = new JScrollPane(viewfamilyAccountTable);
		add(viewFamilyScrollPane, BorderLayout.CENTER);

		// JTable���� �÷����� Ŭ��������, ������ �� ����
		viewfamilyAccountTable.setAutoCreateRowSorter(true);
		TableRowSorter viewFamilyAccountTableSorter = new TableRowSorter(viewFamilyTableModel);
		viewfamilyAccountTable.setRowSorter(viewFamilyAccountTableSorter);
		
		setVisible(true);
	}	
}
