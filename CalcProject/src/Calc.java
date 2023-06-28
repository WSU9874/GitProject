interface StockPrediction {
	boolean predict();
}


public class Calc {
	private static double PI = 3.14;
	
	private String name;
	private int memory;
	
	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public Calc() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int addWithMemory(int a) {
		return this.memory + a;
	}
	
	public static int add(int a, int b) {
		
		
		return a+b;
	}
	public static double getCircleLength(double r) {
		return 2 * PI * r;
	}
}
