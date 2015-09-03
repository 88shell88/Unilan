import java.util.*;

public class Print{
	public Print(){}
	
	public void print(String st){
		System.out.println("getstatic java/lang/System out Ljava/io/PrintStream;");
		System.out.println("ldc \""+st+"\"");
		System.out.println("invokevirtual java/io/PrintStream println (Ljava/lang/Object;)V");
	}

}
