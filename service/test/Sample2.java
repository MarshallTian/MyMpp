package test;
public class Sample2 {
	public String name;
	
	public String sayHello(String name) {
		return "Hello, " + name + "!";
	}

	public static void main(String[] args) {
		Sample2 s = new Sample2();
		s.sayHello("John!");
	}
}
