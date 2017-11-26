import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LabelGame extends JFrame{
	public LabelGame() {
		setTitle("���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300,300);	
		setVisible(true);
	}
	public static void main(String [] args) {
		new LabelGame();
	}
}
class GamePanel extends JPanel {		// gamepanel Ŭ���� �����
	public GamePanel() {
		setLayout(null);	
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				BubbleThread bubbleThread = new BubbleThread(e.getX(), e.getY());
				bubbleThread.start();
			}
		});
	}	
	class BubbleThread extends Thread {		// bubble ���Ӹ����
		JLabel bubble;
		public BubbleThread(int bubbleX, int bubbleY) {
			bubble = new JLabel();
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); 
			}
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY() - 5; 
				if(y < 0) {
					remove(bubble);
					repaint();
					return; 
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);			// 200ms�� �������� ����
				}
				catch(InterruptedException e) {}
			}
		}
	}
}