// Multi-tasking : ���μ��� ����
// Multi-Threading : ������ ����
// �ڿ� ���� : ���� , DB, �޸�.....
// ������ Ŭ������ ��ӹ޾� �����带 ����
// �ڹٿ����� ���߻���� �������� �����Ƿ� �� ���� Ŭ������ ��ӹ��� �� ����.

// ������� ����
class MyTest extends Thread{
	public String name;
	
	public MyTest(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	// ������� ������ Ŭ�������� �ݵ�� run() �޼ҵ带 �������̵�
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// ������ �ڵ�� ������� ����
		for(int count = 1; count <= 10; count++) {
			System.out.print(name+count);
		}
		System.out.println();
	}
}

class Parent {
	
}

// Runnable�̶�� �������̽��� ����ϸ� �����带 ��������

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
		
		// �Ϲ����� �ڵ��� ����
		// A1A2A3A4A5A6A7A8A9A10
		// B1B2B3B4B5B6B7B8B9B10
	}
	
	public static void test2() {
		MyTest th1 = new MyTest("A");
		th1.start(); // ������� ���� : ������ run()�ڵ带
		MyTest th2 = new MyTest("B");
		th2.start();
	}
	
	public static void test3() {
		MyRun run1 = new MyRun("C");
		// runnable ��ü�� ������ ��ü�� �μ��� ���Ǿ� �����带 ������ �� �ִ�.
		Thread th1 = new Thread(run1);
		th1.start();
		
		MyRun run2 = new MyRun("D");
		// runnable ��ü�� ������ ��ü�� �μ��� ���Ǿ� �����带 ������ �� �ִ�.
		Thread th2 = new Thread(run2);
		th2.start();
	}
}
