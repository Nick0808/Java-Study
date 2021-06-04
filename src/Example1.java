// Multi-tasking : 프로세스 단위
// Multi-Threading : 스레드 단위
// 자원 공유 : 파일 , DB, 메모리.....
// 스레드 클래스를 상속받아 스레드를 구현
// 자바에서는 다중상속을 지원하지 않으므로 두 개의 클래스를 상속받을 수 없다.

// 스레드로 정의
class MyTest extends Thread{
	public String name;
	
	public MyTest(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	// 스레드로 정의한 클래스느느 반드시 run() 메소드를 오버라이딩
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 내부의 코드는 스레드로 동작
		for(int count = 1; count <= 10; count++) {
			System.out.print(name+count);
		}
		System.out.println();
	}
}

class Parent {
	
}

// Runnable이라는 인터페이스를 사용하면 스레드를 구현가능

class MyRun extends Parent implements Runnable{
		public String name;
		
		public MyRun(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
		}
		
		@Override
		public void run() {
		// TODO Auto-generated method stub
			for(int count = 1; count <= 10; count++) {
				System.out.print(name+count);
			}
			System.out.println();
		}
}

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test3();
	}
	
	public static void test1() {
		MyTest th1 = new MyTest("A");
		th1.run();
		
		MyTest th2 = new MyTest("B");
		th2.run();
		
		// 일반적인 코드의 수행
		// A1A2A3A4A5A6A7A8A9A10
		// B1B2B3B4B5B6B7B8B9B10
	}
	
	public static void test2() {
		MyTest th1 = new MyTest("A");
		th1.start(); // 스레드로 수행 : 무엇을 run()코드를
		MyTest th2 = new MyTest("B");
		th2.start();
	}
	
	public static void test3() {
		MyRun run1 = new MyRun("C");
		// runnable 객체는 스레드 객체의 인수로 사용되어 스레드를 수행할 수 있다.
		Thread th1 = new Thread(run1);
		th1.start();
		
		MyRun run2 = new MyRun("D");
		// runnable 객체는 스레드 객체의 인수로 사용되어 스레드를 수행할 수 있다.
		Thread th2 = new Thread(run2);
		th2.start();
	}
}
