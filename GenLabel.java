import java.util.*;

public class GenLabel{
	int i;
	public GenLabel(){
		i=0;

	}
	
	public Label nuevo(){
		Label l=new Label(new Integer(i));
		i++;
		return l;
	}

}
