import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Data{
	public String[] verbs= new String[] {"llamar","mensajear"};
	public String[] sustantivos = new String[] {"Telefono","Wassup"};
	public String[] Telefono = new String[] {"llamar"};
	public String[] Wassup = new String[] {"llamar","mensajear"};
	public List<String[]> versSust= new ArrayList<String[]>() {{
		add(new String[] {"Telefono","llamar"});
		add(new String[] {"Wassup","llamar"});
		add(new String[] {"Wassup","mensajear"});
	}};
	
	public Data(){
		/*verbs= {"llamar","mensajear"};
		sustantivos = {"Telefono","Wassup"};
		Telefono = {"llamar"};
		Wassup = {"llamar","mensajear"};*/
	}

	public boolean isVerb(String s){
		boolean b = false;
		if (Arrays.asList(verbs).contains(s)){b=true;}
		return b;
	}

	public boolean isSustantivo(String s){
		boolean b = false;
		if (Arrays.asList(sustantivos).contains(s)){b=true;}
		return b;
	}

	public String getContext(){
		BufferedReader br = null;
		String context="";
		
		try{
			br = new BufferedReader(new FileReader("context"));
			context = br.readLine();
		}catch(IOException e){e.printStackTrace();}
		return context;
	}
	
	public String contextHasFunction(String s){
		String ret="";
		String context= getContext();
		if (versSust.contains(new String[] {context,s})){ret=context;}

		return ret;
	}
	public void changeContext(String s){
		String content = s;
		try{
			File file= new File("context");
			if(!file.exists()){file.createNewFile();}
			FileWriter fw= new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
}

