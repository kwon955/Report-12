import java.util.Scanner;

public class RunnableEx {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�ƹ� Ű�� �Է�>> ");
		scanner.nextLine(); // � Ű�� �ԷµǱ⸦ ��ٸ�
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start();		//������ ��ŸƮ
	}
}
class CountingThread implements Runnable {		// Runnable �������̽� ���
	@Override
	public void run() {
		System.out.println("������ ���� ����");		
		for(int i=1; i<=10; i++)			// for �ݺ��� ����Ͽ� 1���� 10���� ���
			System.out.print(i + " ");
		System.out.println();
		System.out.println("������ ����");
	}
}
