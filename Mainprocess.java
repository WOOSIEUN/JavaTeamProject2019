
public class Mainprocess {
	LoginWindow loginView;
	TestFrm testFrm;
	
	public static void main(String[] args) {
		
		// ����Ŭ���� ����
		Mainprocess main = new Mainprocess();
		main.loginView = new LoginWindow(); // �α���â ���̱�
		main.loginView.setMain(main); // �α���â���� ���� Ŭ����������
	}
	
	// �׽�Ʈ������â
	public void showFrameTest(){
		loginView.dispose(); // �α���â�ݱ�
		this.testFrm = new TestFrm(); // �׽�Ʈ������ ����
	}
}
