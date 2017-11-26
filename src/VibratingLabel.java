import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class VibratingLabel extends JFrame{
	public VibratingLabel() {
		super("�����ϴ� ������ �����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("�������̺�");
		c.add(label);				// ���̺� �����
		
		setSize(300, 300);
		setLocation(100, 100); 
		setVisible(true);
		
		VibratingThread vt = new VibratingThread(label);	// �����ϴ� ���̺�
		vt.start();	
	}
	class VibratingThread extends Thread implements Runnable{
		JLabel la;
		public VibratingThread(JLabel la) {this.la = la;}
		public void run() {
			Random r = new Random();
			int x = la.getX();
			int y = la.getY();
			
			while(true) {
				try {
					Thread.sleep(10); 		//10ms�� �������� sleep() ���
				} catch(InterruptedException e) {return;}
				int sign = 1;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpX = x + r.nextInt(5)*sign;
				if(r.nextBoolean()) sign = 1;
				else sign = -1;
				int tmpY = y + r.nextInt(5)*sign;
				la.setLocation(tmpX, tmpY);
			}
		}	
	}
	public static void main(String[] args) {
		new VibratingLabel();
	}
}