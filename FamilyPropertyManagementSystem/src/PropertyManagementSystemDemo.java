
public class PropertyManagementSystemDemo {
	MainFrame mainFrame; //����������
	LoginWindow loginView; //�α���ȭ��
	Join JoinFrame; //ȸ������ ȭ��
	FID FIDFrame; //FID ����ȭ��

	public static void main(String[] args) {
		//PropertyManagementSystemDemo Ŭ���� ����
		PropertyManagementSystemDemo PMSDemo = new PropertyManagementSystemDemo();
		PMSDemo.loginView = new LoginWindow(); // �α���â ���̱�
		PMSDemo.loginView.setMain(PMSDemo); // �α���â���� ���� Ŭ����������		
	}
	
	//ȸ������â ���� �޼ҵ�
	public void showJoinFrame(){
		this.JoinFrame = new Join(); //ȸ������â
		JoinFrame.setVisible(true);
	}
	
	public void showFIDFrame(){
		this.FIDFrame =new FID(); //���� ������ȣ ����
		FIDFrame.setVisible(true);
	}
	
	//���������� ���� �޼ҵ�
	public void showMainFrame(int FID, String ID, String Name, String Relation){
		loginView.dispose(); // �α���â�ݱ�
		this.mainFrame = new MainFrame(FID, ID, Name, Relation); //���������� ����
	}

}