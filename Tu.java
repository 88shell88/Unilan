public class Tu{
	public Tu(){}
	public String comprobar(){
		
	}
	public String definir(String st, Object o){
		if(o instanceof Integer){}
		else if(o instanceof String){}
	}
	public String asignar(String st, Object o){
		if(o instanceof Integer){}
		else if(o instanceof String){}
	}
}


n {:d.defVar(ident.nombre,n);:}CP
				|	AP IDENT:ident ASIG NUM:n{:d.asigVar(ident.nombre,n);:}CP
