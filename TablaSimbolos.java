import java.util.*;

public class TablaSimbolos{
	HashMap t;
	int i;
	public TablaSimbolos(){
		t=new HashMap();
		i=0;
	}
	
	public Simbolo insertar(String nombre){
		Simbolo s = new Simbolo(nombre, new Integer(i));
		t.put(nombre,s);
		i++;
		return s;
	}

	public Simbolo buscar(String nombre){
		return (Simbolo)(t.get(nombre));
	}

	public void imprimir(){
		Iterator it=t.values().iterator();
		while(it.hasNext()){
			Simbolo s =(Simbolo)it.next();
			System.out.println(s.nombre + ": "+s.valor);
		}
	}
}
