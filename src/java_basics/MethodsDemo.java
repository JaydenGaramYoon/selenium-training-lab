package java_basics;

public class MethodsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodsDemo d = new MethodsDemo();
		d.getData();
		MethodsDemo.getData2();
		MethodsDemo2 d1 = new MethodsDemo2();
		d1.getUserData(); //when the method is non-static, belongs to specific instance (object) of the class
		getData2(); //when the method is static -> belongs to the method itself, does not rely on instance data
	}
	
	public void getData() { //if add 'static' the method belongs to the class, not object
		//public [return type] [method name]
		System.out.println("get Data -> object.method");
	}
	public static void getData2() { //if add 'static' the method belongs to the class, not object
		//public [return type] [method name]
		System.out.println("get Data2 by adding static-> calling Class.method");
	}
}
