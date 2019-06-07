import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame implements ActionListener{
   private static final int WIDTH = 1000;
   private static final int HEIGHT = 500;
   private int ROW;
   private static final int COLUMN = 4;

   //���� �̸�
   private String personalFileName;
   private String familyFileName;
   //���ΰ� ������ ROW count
   private int cnt;
   //���̺� ����
   DefaultTableModel personalAccountTableModel;
   JTable personalAccountTable;
   JScrollPane personalScrollPane;
   DefaultTableModel familyAccountTableModel;
   JTable familyAccountTable;
   JScrollPane familyScrollPane;
   //���ΰ� ������ ���� ���� ���� �ؽ�Ʈ�ʵ�
   JTextField personalIncome;
   JTextField personalconsumption;
   JTextField personalTotal;
   JTextField familyIncome;
   JTextField familyconsumption;
   JTextField familyTotal;
   //������ ���Կ� �ʿ��� �ؽ�Ʈ�ʵ�
   JTextField dateField;
   JTextField majorClassificationField;
   JTextField minorClassificationField;
   JTextField amountField;
   //�޺��ڽ� ����
   DefaultComboBoxModel selectComboModel;
   JComboBox selectCombo;

   public MainFrame(int FID, String Name) {
      //������ ����
      super("Property Management System");
      setSize(400, 400);
      setResizable(false);      
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      //����¿� �ʿ��� ���� �ʱ�ȭ
      cnt = 0;

      //���� �̸� ����
      familyFileName = (intToString(FID) + ".txt");
      personalFileName = (intToString(FID) + " " + Name +".txt");

      //���̺��� ���� panel ����
      JPanel tablePanel = new JPanel();
      tablePanel.setLayout(new GridLayout(1,2));

      //���̺� ����� - ����� ������ �ҷ��� �迭 �����
      String tableHeader[] = {"��¥","��з�","�Һз�","�ݾ�"};
      String personalContents[][] = null;
      String familyContents[][] = null;

      //���� ���� ������ �ε�
      Scanner inputStream = null;
      try {
         inputStream = new Scanner(new FileInputStream(personalFileName));         
      } catch (FileNotFoundException e) {
         System.out.println(personalFileName + "������ �������� �ʽ��ϴ�. ���α׷� ������ ���α׷��� �����մϴ�.");
         System.exit(0);
      }
      //�迭�� ���� ���� �о����.
      try {
         ROW = inputStream.nextInt();
         personalContents = new String[ROW][COLUMN];
      } catch (InputMismatchException e) {
         System.out.println("���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
         System.exit(0);
      }
      inputStream.nextLine();
      //�迭�� �� �����ϱ�
      while (inputStream.hasNext()) {
         try {
            personalContents[cnt][0] = intToString(inputStream.nextInt());
            personalContents[cnt][1] = inputStream.next();
            personalContents[cnt][2] = inputStream.next();
            personalContents[cnt++][3] = intToString(inputStream.nextInt());
         } catch (InputMismatchException e) {
            System.out.println("���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
            System.exit(0);
         }
      }
      inputStream.close();
      //���̺� �����
      personalAccountTableModel = new DefaultTableModel(personalContents,tableHeader);
      personalAccountTable = new JTable(personalAccountTableModel);
      personalScrollPane = new JScrollPane(personalAccountTable);
      tablePanel.add(personalScrollPane);
      
      cnt=0;
      //���� ���� ������ �ε�
      try {
         inputStream = new Scanner(new FileInputStream(familyFileName));         
      } catch (FileNotFoundException e) {
         System.out.println(familyFileName + "������ �������� �ʽ��ϴ�. ���α׷� ������ ���α׷��� �����մϴ�.");
         System.exit(0);
      }
      //�迭�� ���� ���� �о����.
      try {
         ROW = inputStream.nextInt();
         familyContents = new String[ROW][COLUMN];
      } catch (InputMismatchException e) {
         System.out.println("���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
         System.exit(0);
      }
      inputStream.nextLine();
      //�迭�� �� �����ϱ�
      while (inputStream.hasNext()) {
         try {
            familyContents[cnt][0] = intToString(inputStream.nextInt());
            familyContents[cnt][1] = inputStream.next();
            familyContents[cnt][2] = inputStream.next();
            familyContents[cnt++][3] = intToString(inputStream.nextInt());
         } catch (InputMismatchException e) {
            System.out.println("���� �ε��� ������ �߻��߽��ϴ�. ���α׷��� �����մϴ�.");
            System.exit(0);
         }
      }
      inputStream.close();
      //���̺� �����
      familyAccountTableModel = new DefaultTableModel(familyContents,tableHeader);
      familyAccountTable = new JTable(familyAccountTableModel);
      familyScrollPane = new JScrollPane(familyAccountTable);
      tablePanel.add(familyScrollPane);
      add(tablePanel, BorderLayout.CENTER);

      //���� ���� ������ ����� �� �� �г� ����.
      JPanel sumPanel = new JPanel();
      sumPanel.setLayout(new GridLayout(2,2));
      JPanel personalSumPanel = new JPanel();
      personalSumPanel.setLayout(new BoxLayout(personalSumPanel, BoxLayout.X_AXIS));
      JPanel familySumPanel = new JPanel();
      familySumPanel.setLayout(new BoxLayout(familySumPanel, BoxLayout.X_AXIS));
      JPanel personalSumLabelPanel = new JPanel();
      personalSumLabelPanel.setLayout(new BoxLayout(personalSumLabelPanel, BoxLayout.X_AXIS));
      JPanel familySumLabelPanel = new JPanel();
      familySumLabelPanel.setLayout(new BoxLayout(familySumLabelPanel, BoxLayout.X_AXIS));

      //�� ���� �� sumPanel�� ���̱�
      JLabel personalIncomeLabel = new JLabel("  ���μҺ�  ");
      personalSumLabelPanel.add(personalIncomeLabel);
      JLabel personalconsumptionLabel = new JLabel("  ��������  ");
      personalSumLabelPanel.add(personalconsumptionLabel);
      JLabel personalTotalLabel = new JLabel("  ��������  ");
      personalSumLabelPanel.add(personalTotalLabel);
      JLabel familyIncomeLabel = new JLabel("  �����Һ�  ");
      familySumLabelPanel.add(familyIncomeLabel);
      JLabel familyconsumptionLabel = new JLabel("  ��������  ");
      familySumLabelPanel.add(familyconsumptionLabel);
      JLabel familyTotalLabel = new JLabel("  ��������  ");
      familySumLabelPanel.add(familyTotalLabel);
      sumPanel.add(personalSumLabelPanel);
      sumPanel.add(familySumLabelPanel);

      //�� �ؽ�Ʈ�ʵ� ������ ���� �Ұ��ϰ� �ʱ�ȭ, �� �гο� ���̱�
      personalIncome = new JTextField("");
      personalIncome.setEditable(false);
      personalSumPanel.add(personalIncome);
      personalconsumption = new JTextField("");
      personalconsumption.setEditable(false);
      personalSumPanel.add(personalconsumption);
      personalTotal = new JTextField("");
      personalTotal.setEditable(false);
      personalSumPanel.add(personalTotal);
      familyIncome = new JTextField("");
      familyIncome.setEditable(false);
      familySumPanel.add(familyIncome);
      familyconsumption = new JTextField("");
      familyconsumption.setEditable(false);
      familySumPanel.add(familyconsumption);
      familyTotal = new JTextField("");
      familyTotal.setEditable(false);
      familySumPanel.add(familyTotal);
      sumPanel.add(personalSumPanel);
      sumPanel.add(familySumPanel);
      add(sumPanel, BorderLayout.NORTH);

      //�� ���� ����ϴ� �޼ҵ� �ʿ� -> �ش� �޼ҵ�� �� ���� ���� �Է¸��� �ʿ��� ������ ����.

      //������ ���� ���� ����
      //�г� ����
      JPanel dataManagementPanel = new JPanel();
      dataManagementPanel.setLayout(new GridLayout(3,4));

      //������ ���Կ� �ʿ��� Text Field�� �ȳ������� ���� �� ����.      
      JLabel dateLabel = new JLabel("��¥");
      dataManagementPanel.add(dateLabel);
      dateField = new JTextField("(yyyymmdd)");
      dataManagementPanel.add(dateField);
      JLabel majorClassificationLabel = new JLabel("��з�");
      dataManagementPanel.add(majorClassificationLabel);
      majorClassificationField = new JTextField("(����/����)");
      dataManagementPanel.add(majorClassificationField);
      JLabel minorClassificationLabel = new JLabel("�Һз�");
      dataManagementPanel.add(minorClassificationLabel);
      minorClassificationField = new JTextField("(���� ����)");
      dataManagementPanel.add(minorClassificationField);
      JLabel amountLabel = new JLabel("�ݾ�");
      dataManagementPanel.add(amountLabel);
      JTextField amountField = new JTextField("�����Է�");
      dataManagementPanel.add(amountField);
      
      
      
      //�޺��ڽ� �߰�
      String []selectPORF = new String[]{"����", "����"};
      selectCombo = new JComboBox();       
      selectComboModel = new DefaultComboBoxModel(selectPORF);
      selectCombo.setModel(selectComboModel);
      dataManagementPanel.add(selectCombo);
      
      //��ư �߰� - �߰� ����
      
      JButton insert = new JButton("�߰�");
      insert.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String event = e.getActionCommand();
             if(event == "�߰�") {
                //�ʵ忡 �Է��� �� �ޱ�
                String inputString[] = new String[4];
                inputString[0] = dateField.getText();
                inputString[1] = majorClassificationField.getText();
                inputString[2] = minorClassificationField.getText();
                inputString[3] = amountField.getText(); 
                String select = (String)selectComboModel.getSelectedItem();
                //�ʵ� �� �Է�
                if(select == "����") {
                   familyAccountTableModel.addRow(inputString);
                } else if (select == "����" ) {
                   personalAccountTableModel.addRow(inputString);
                } else {
                   System.out.println("����ġ ���� ������ �߻��߽��ϴ�. �����ڿ��� �������ּ���.");
                }          
                //�ʵ� �ʱ�ȭ
                dateField.setText("");
                majorClassificationField.setText("");
                minorClassificationField.setText("");
                amountField.setText(""); 
             } else {
                System.out.println("����ġ ���� ������ �߻��߽��ϴ�. �����ڿ��� �������ּ���.");
             }
         }
      });
      dataManagementPanel.add(insert);
      JButton delete = new JButton("����");
      delete.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String event = e.getActionCommand();
            if (event == "����") {
                if(personalAccountTable.getSelectedRow() != -1) {
                   personalAccountTableModel.removeRow(personalAccountTable.getSelectedRow());
                } else if (familyAccountTable.getSelectedRow() != -1){
                   familyAccountTableModel.removeRow(familyAccountTable.getSelectedRow());
                } else {
                   return;
                }   
             } else {
                System.out.println("����ġ ���� ������ �߻��߽��ϴ�. �����ڿ��� �������ּ���.");
             }
         }
      });
      dataManagementPanel.add(delete);
      JButton modify = new JButton("����");
      modify.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String event = e.getActionCommand();            
            if (event == "����") {
               String select = (String)selectComboModel.getSelectedItem();
               String modifyString = null;
               if(select == "����" && personalAccountTable.getSelectedRow() != -1 && personalAccountTable.getSelectedColumn() != -1) {
                  //������ ���� ���� ������ ���� �Է��� �ʵ��� ���� modifyString ������ ����
                  if(personalAccountTable.getSelectedColumn() == 0) {
                     modifyString = dateField.getText();
                  } else if(personalAccountTable.getSelectedColumn() == 1) {
                     modifyString = majorClassificationField.getText();
                  } else if(personalAccountTable.getSelectedColumn() == 2) {
                     modifyString = minorClassificationField.getText();
                  } else if(personalAccountTable.getSelectedColumn() == 3) {
                     modifyString = amountField.getText();
                  } else {
                     return;
                  }
                  //������ ��� ���� ������ ����
                  personalAccountTableModel.setValueAt(modifyString,personalAccountTable.getSelectedRow(),personalAccountTable.getSelectedColumn());             
                } else if (select == "����" && familyAccountTable.getSelectedRow() != -1 && familyAccountTable.getSelectedColumn() != -1){
                   // ���� �κ� �����ڵ�. ���� ����
                   if(familyAccountTable.getSelectedColumn() == 0) {
                     modifyString = dateField.getText();
                  } else if(familyAccountTable.getSelectedColumn() == 1) {
                     modifyString = majorClassificationField.getText();
                  } else if(familyAccountTable.getSelectedColumn() == 2) {
                     modifyString = minorClassificationField.getText();
                  } else if(familyAccountTable.getSelectedColumn() == 3) {
                     modifyString = amountField.getText();
                  } else {
                     return;
                  }
                   familyAccountTable.setValueAt(modifyString,familyAccountTable.getSelectedRow(),familyAccountTable.getSelectedColumn());
                } else {
                   return;
                }
                if(personalAccountTable.getSelectedColumn() == 0 || familyAccountTable.getSelectedColumn() == 0) {
//                   //��¥�� ���� �ʿ�
                }
             } else {
                System.out.println("����ġ ���� ������ �߻��߽��ϴ�. �����ڿ��� �������ּ���.");
             }
         }
      });
      dataManagementPanel.add(modify);
            
      //dataMangementPanel ���������� SOUTH�� �߰�
      add(dataManagementPanel, BorderLayout.SOUTH);
      

   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String event = e.getActionCommand();
       if (event == "����") {
          if(personalAccountTable.getSelectedRow() != -1) {
             personalAccountTableModel.removeRow(personalAccountTable.getSelectedRow());
          } else if (familyAccountTable.getSelectedRow() != -1){
             familyAccountTableModel.removeRow(familyAccountTable.getSelectedRow());
          } else {
             return;
          }   
       } else {
         System.out.println("����ġ ���� ������ �߻��߽��ϴ�. �����ڿ��� �������ּ���.");
      }  
   }

   public int stringToInt(String string) {
      return Integer.parseInt(string);
   }
   public String intToString(int integer) {
      return String.valueOf(integer);
   }
}