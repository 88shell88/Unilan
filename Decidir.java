import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class Decidir{
	int i=0;
	String cl,contentClass,contentConstructor, contentClose = "";
	BufferedReader br = null;
	String context;
	LinkedList<String> list;
	public class MyException extends Exception {
    		public MyException(String message) {
        		super(message);
    		}
	}
	Data d = new Data();
	public Decidir(){
		list= new LinkedList<String>();
	}
	public void simple(String clase, String func, LinkedList<Object> var){
		i++;
		cl="";
		br= null;
		try{
			br = new BufferedReader(new FileReader("context"));
			context = br.readLine();
			if (Arrays.asList(d.sustantivos).contains(clase)){
				cl=clase;
				d.changeContext(cl);
			}else if (clase.equals("")){
				cl = d.contextHasFunction(func);
				if(cl.equals("")){throw new MyException("not a valid action for this context");}
				else{d.changeContext(cl);}
			}else{
				throw new MyException("not a valid action for this context");
			}
			list.add(cl+" cl"+i+" = new "+cl+"();\n");
			list.add("cl"+i+"."+func+"(\"");
			while(!var.isEmpty()){
				list.add(var.removeFirst().toString());
			}
			list.add("\");\n");
		}catch(IOException e){e.printStackTrace();}
		catch(MyException e){e.printStackTrace();}
	}
	public void end(){
		list.add("}\n");
	}
	public void dIf(String st){
		list.add("if("+st+"){\n");
	}
	public void dWhile(String st){
		list.add("while("+st+"){\n");
	}
	public void dFor(int input){
		i++;
		list.add("for(int i"+i+"=0;i"+i+"<"+input+";i"+i+"++){\n");
	}
	public void dWhileCap(String st, int input){
		i++;
		list.add("int i"+i+"=0;\n");
		list.add("while("+st+" && i"+i+"<"+input+"){\n");
		list.add("i"+i+"++;\n");
	}
	public void start(){
		contentClass = "public class Llamada{\n";
		contentConstructor = "public Llamada(){\n";
		
	}
	public void stop(){
		try{
			contentClose = "}\n}";
			File file= new File("/home/unilan/Unilan/Llamada.java");
			if(!file.exists()){file.createNewFile();}
			FileWriter fw= new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(contentClass);
			bw.write(contentConstructor);
			while(!list.isEmpty()){
				bw.write(list.removeFirst());
			}
			bw.write(contentClose);
			bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
	public void defVar(String st, int input){
		list.add("int "+st+" = "+input+";\n");
	}
	public void asigVar(String st, int input){
		list.add(st+" = "+input+";\n");
	}
}
