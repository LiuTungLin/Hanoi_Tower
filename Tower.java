package main;

public class Tower {
	
	public Rod A = new Rod("A");
	public Rod B = new Rod("B");
	public Rod C = new Rod("C");
	public int step;
	
	public Tower(int n) {
		for(int i=n; i>=1; i--) {
			A.stack.push(i);
		}
		step = 0;
		print();
	}
	
	public void move(Rod source, Rod board) {
		board.stack.push(source.stack.pop());
		step++;
		System.out.printf("steps:%d from %s to %s\n", step, source.name, board.name);
		System.out.println("Current state:"+step);
	}
	
	public void move(int n, Rod source, Rod board, Rod target) {
		if(n == 1) {
			move(source, target);
			print();
		}
		if(n>1) {
			move(n-1, source, target, board);
			move(source, target);
			print();
			move(n-1, board, source, target);
		}
	}
	
	public void print() {
		System.out.printf("A|-");
		for(int i=0; i<A.stack.size(); i++) {
			System.out.print(A.stack.elementAt(i));
		}
		
		System.out.printf("\nB|-");
		for(int i=0; i<B.stack.size(); i++) {
			System.out.print(B.stack.elementAt(i));
		}
		
		System.out.printf("\nC|-");
		for(int i=0; i<C.stack.size(); i++) {
			System.out.print(C.stack.elementAt(i));
		}
		System.out.println("\n--------------");
	}
}
