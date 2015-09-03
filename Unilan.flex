import java_cup.runtime.*;
import java.io.*;
import java.util.Arrays;
%%
%cup
%{
	StringBuffer string=new StringBuffer();
	private Data d = new Data();
	private TablaSimbolos tabla= new TablaSimbolos();
	private GenLabel gl=new GenLabel();
	private int i=0,w=0;
%}
%state STRING
%%

<YYINITIAL>{
	"yo ordenar"			{}

	"true"				{return new Symbol(sym.TTRUE);}
	"false"				{return new Symbol(sym.TFALSE);}}
	
	"+"				{return new Symbol(sym.MAS);}
	"*"				{return new Symbol(sym.POR);}
	"-"				{return new Symbol(sym.MEN);}
	"/"				{return new Symbol(sym.DIV);}

	"="				{return new Symbol(sym.ASIG);}
	"=="				{return new Symbol(sym.IGUAL);}
	"!="				{return new Symbol(sym.NIGUAL);}
	"<"				{return new Symbol(sym.MENOR);}
	">"				{return new Symbol(sym.MAYOR);}
	"<="				{return new Symbol(sym.MENIG);}
	">="				{return new Symbol(sym.MAYIG);}

	"&&"				{return new Symbol(sym.AND);}
	"||"				{return new Symbol(sym.OR);}	
	"!"				{return new Symbol(sym.NOT);}			

	"{"				{return new Symbol(sym.AC);}
	"}"				{return new Symbol(sym.CC);}
	";"				{return new Symbol(sym.PYC);}
	"("				{return new Symbol(sym.AP);}
	")"				{return new Symbol(sym.CP);}
	"["				{return new Symbol(sym.AA);}
	"]"				{return new Symbol(sym.CA);}
	","				{return new Symbol(sym.COMA);}

	\"				{string.setLength(0); yybegin(STRING);}

	0|[1-9][0-9]*			{return new Symbol(sym.NUM, new Integer(yytext()));}

	[a-zA-Z][a-zA-Z0-9]*		{	Simbolo s;
						String yytext= yytext();
						if((s = tabla.buscar(yytext))==null){
							s= tabla.insertar(yytext);
						}
						
						if (d.isVerb(yytext)){
							return new Symbol(sym.VERB,s);
						}
						else if (d.isSustantivo(yytext())){
							return new Symbol(sym.SUST,s);
						}
						else {
							return new Symbol(sym.IDENT,s);
						}

					}
	\t				{ }
	\r|\n				{ }//{return new Symbol(sym.EOL);}
	\ |\t\f				{ }

	[^]				{throw new Error("Illegal character < " + yytext() + " >");}
}

<STRING>{
	\"				{yybegin(YYINITIAL); return new Symbol(sym.TEXTO, string.toString());}
	[^]				{string.append(yytext());}
}
