package analisis;

import java_cup.runtime.Symbol;
import analisis.parser;

%%

%{

public String errores="";
String cadena="";

%}


%cup
%class scanner
%public
%line
%char
%column
%full
%state CADENA
%ignorecase

//Signos
abre="<"
cierra="/>"
cierrasolo=">"
abresolo="<\\"
dospuntos=":"
igual="="
coma = ","

//Etiquetas
cuerpos="<cuerpo>"
fincuerpos="</cuerpo>"
ponderacion ="<ponderacion>"
finponderacion = "</ponderacion>"
reporte="<reportes>"
finreportes="</reportes>"
estilo="<estilo>"
finestilo="</estilo>"




//Terminales
encabezados="encabezado"
carnet="carnet"
nombres="nombres"
apellidos="apellidos"

estudiante="estudiante"
valor="valor"
cuerpostyle="cuerpo"



//expresiones Regulares

num  = -?[0-9]+   
id      = [A-Za-zñÑ][_0-9A-Za-zñÑ\-áéíóú]*
cadena = "[_0-9A-Za-zñÑáéíóú]*"
porcentaje = [0-9]+%? 


SPACE   = [\ \r\t\f\t]
ENTER   = [\ \n]

%%  

<YYINITIAL> {abre}      { return new Symbol(sym.abre, yyline, yycolumn,"<");}
<YYINITIAL> {cierra}     	 { return new Symbol(sym.cierra, yyline, yycolumn,"/>");}
<YYINITIAL> {dospuntos}      { return new Symbol(sym.dospuntos, yyline, yycolumn,":");}
<YYINITIAL> {igual}     	 { return new Symbol(sym.igual, yyline, yycolumn,"=");}
<YYINITIAL> {cierrasolo}     	 { return new Symbol(sym.cierrasolo, yyline, yycolumn,">");}
<YYINITIAL> {abresolo}     	 { return new Symbol(sym.abresolo, yyline, yycolumn,"<\\");}
<YYINITIAL> {coma}     	 { return new Symbol(sym.coma, yyline, yycolumn,",");}

<YYINITIAL> {encabezados}      { return new Symbol(sym.encabezados, yyline, yycolumn,"encabezado");}
<YYINITIAL> {carnet}      { return new Symbol(sym.carnet, yyline, yycolumn,"carnet");}
<YYINITIAL> {nombres}      { return new Symbol(sym.nombres, yyline, yycolumn,"nombres");}
<YYINITIAL> {apellidos}      { return new Symbol(sym.apellidos, yyline, yycolumn,"apellidos");}
<YYINITIAL> {cuerpos}      { return new Symbol(sym.cuerpos, yyline, yycolumn,"<cuerpo>");}
<YYINITIAL> {fincuerpos}      { return new Symbol(sym.fincuerpos, yyline, yycolumn,"</cuerpo>");}
<YYINITIAL> {estudiante}      { return new Symbol(sym.estudiante, yyline, yycolumn,"estudiante");}
<YYINITIAL> {ponderacion}      { return new Symbol(sym.ponderacion, yyline, yycolumn,"<ponderacion>");}
<YYINITIAL> {finponderacion}      { return new Symbol(sym.finponderacion, yyline, yycolumn,"</ponderacion>");}
<YYINITIAL> {valor}      { return new Symbol(sym.valor, yyline, yycolumn,"valor");}
<YYINITIAL> {reporte}      { return new Symbol(sym.reporte, yyline, yycolumn,"<reportes>");}
<YYINITIAL> {finreportes}      { return new Symbol(sym.finreportes, yyline, yycolumn,"</finreportes>");}
<YYINITIAL> {estilo}      { return new Symbol(sym.estilo, yyline, yycolumn,"<estilo>");}
<YYINITIAL> {finestilo}      { return new Symbol(sym.finestilo, yyline, yycolumn,"</finestilo>");}
<YYINITIAL> {cuerpostyle}      { return new Symbol(sym.cuerpostyle, yyline, yycolumn,"cuerpo");}




<YYINITIAL> {num}    { return new Symbol(sym.num, yyline, yycolumn,yytext());}
<YYINITIAL> {id}        {return new Symbol(sym.id, yyline, yycolumn,yytext());}
<YYINITIAL> {cadena}        {return new Symbol(sym.cadena, yyline, yycolumn,yytext());}
<YYINITIAL> {porcentaje}        {return new Symbol(sym.porcentaje, yyline, yycolumn,yytext());}

<YYINITIAL> [\"]        { yybegin(CADENA); cadena+="\""; }
<YYINITIAL> {SPACE}     { /*Espacios en blanco, ignorados*/ }
<YYINITIAL> {ENTER}     { /*Saltos de linea, ignorados*/}


<YYINITIAL> . {
        String errLex = "Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1);
        errores+= errLex+"\n";
        System.out.println("Error léxico : '"+yytext()+"' en la línea: "+(yyline+1)+" y columna: "+(yycolumn+1));
        

}

<CADENA> {
        [\"] { String tmp=cadena+"\""; cadena=""; yybegin(YYINITIAL);  return new Symbol(sym.cadena, yychar,yyline,tmp); }
        [\n] {String tmp=cadena; cadena="";  
                System.out.println("Se esperaba cierre de cadena (\")."); 
                yybegin(YYINITIAL);
            }
        [^\"] { cadena+=yytext();}
}