import java.util.Scanner;

public class RunnableEx {

	static public void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아무 키나 입력>> ");
		scanner.nextLine(); // 어떤 키라도 입력되기를 기다림
		scanner.close();
		
		Thread th = new Thread(new CountingThread());	
		th.start();		//스레드 스타트
	}
}
class CountingThread implements Runnable {		// Runnable 인터페이스 사용
	@Override
	public void run() {
		System.out.println("스레드 실행 시작");		
		for(int i=1; i<=10; i++)			// for 반복문 사용하여 1부터 10까지 출력
			System.out.print(i + " ");
		System.out.println();
		System.out.println("스레드 종료");
	}
}
