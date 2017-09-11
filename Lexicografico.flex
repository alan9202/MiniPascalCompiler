/* --------------------------Codigo de Usuario----------------------- */
package com.uaem.main;

import java_cup.runtime.*;
import java.io.Reader;

/* ------ Seccion de opciones y declaraciones de JFlex -------------- */
%% //inicio de opciones

/*
    Se cambia el nombre de la clase a AnalizadorLexicografico
*/
%class AnalizadorLexicografico

/*
	Se activa el contador de lineas, yyline
    Se activa el contador de columnas, yycolumn
*/
%line
%column

/*
	Se activa la compatibilidad con Java CUP para analizadores sintacticos
*/
%cup

/*
    El codigo entre %{ %} sera copiado integramente en el analizador generado.
*/
%{
    /*
    	Se generara un objeto java_cup.Symbol para guardar el tipo de token encontrado
	*/
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    /*
    	Se generara un objeto java_cup.Symbol para el tipo de token encontrado junto con su valor
	*/
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

/*
    Macros

    Declaracion de expresiones regulares que despues seran usadas en las reglas lexicograficas.
*/

/*
	Salto de linea: \n, \r o \r\n dependiendo del SO
*/
Salto = \r|\n|\r\n

/*
	Espacio en blanco, tabulador \t, salto de linea o avance de pagina \f, normalmente son ignorados
*/
Espacio = {Salto} | [ \t\f]

/*
	Numero entero
*/
Digito = 0 | [1-9][0-9]*

/*
    Identificador
*/
Identificador = [a-z]*

%% //fin de opciones

/* -------------------- Seccion de reglas lexicas ------------------ */

/*
   Esta seccion contiene expresiones regulares y acciones.
   Las acciones son código en Java que se ejecutara cuando se encuentre una entrada valida para la expresion regular correspondiente.
*/

/*
	YYINITIAL es el estado inicial del analizador lexicografico al empezar el escaneo.
    Las expresiones regulares solo serán comparadas si se encuentra en ese estado inicial.
    Es decir, cada vez que se encuentra una coincidencia el scanner vuelve al estado inicial.
    Por lo cual se ignoran estados intermedios.
*/

<YYINITIAL> {

    /*
        Regresa que el token EQUAL, declarado en la clase sym, fue encontrado.
    */
    ":=" {
        return symbol(sym.EQUAL);
    }

    /*
		Retorna que el token PROCEDURE, declarado en la clase sym, fue encontrado.
	*/
    "procedure" {
    	return symbol(sym.PROCEDURE);
    }

    /*
    	Retorna que el token IS, declarado en la clase sym, fue encontrado.
	*/
    "is" {
        return symbol(sym.IS);
    }

    /*
    	Retorna que el token INTEGER, declarado en la clase sym, fue encontrado.
	*/
    "Integer" {
        return symbol(sym.INTEGER);
    }

    /*
    	Retorna que el token TWOP, declarado en la clase sym, fue encontrado.
    */
    ":" {
        return symbol(sym.TWOP);
    }

    /*
    	Retorna que el token SEMI, declarado en la clase sym, fue encontrado.
    */
    ";" {
        return symbol(sym.SEMI);
    }

    /*
    	Retorna que el token BEGIN, declarado en la clase sym, fue encontrado.
    */
    "begin" {
        return symbol(sym.BEGIN);
    }

    /*
    	Retorna que el token END, declarado en la clase sym, fue encontrado.
	*/
    "end" {
        return symbol(sym.END);
    }

    /*
        Retorna que el token FOR, declarado en la clase sym, fue encontrado.
    */
    "for" {
        return symbol(sym.FOR);
    }

    /*
        Retorna que el token IN, declarado en la clase sym, fue encontrado.
    */
    "in" {
        return symbol(sym.IN);
    }

    /*
        Retorna que el token TO, declarado en la clase sym, fue encontrado.
    */
    "to" {
        return symbol(sym.TO);
    }

    /*
        Retorna que el token LOOP, declarado en la clase sym, fue encontrado.
    */
    "loop" {
        return symbol(sym.LOOP);
    }

    /*
        Retorna que el token ENDLOOP, declarado en la clase sym, fue encontrado.
    */
    "endloop" {
        return symbol(sym.ENDLOOP);
    }

    /*
        Retorna que el token IF, declarado en la clase sym, fue encontrado.
    */
    "if" {
        return symbol(sym.IF);
    }

    /*
        Retorna que el token THEN, declarado en la clase sym, fue encontrado.
    */
    "then" {
        return symbol(sym.THEN);
    }

    /*
        Retorna que el token ELSE, declarado en la clase sym, fue encontrado.
    */
    "else" {
        return symbol(sym.ELSE);
    }

    /*
        Retorna que el token ENDIF, declarado en la clase sym, fue encontrado.
    */
    "endif" {
        return symbol(sym.ENDIF);
    }

    /*
        Retorna que el token INPUT, declarado en la clase sym, fue encontrado.
    */
    "input" {
        return symbol(sym.INPUT);
    }

    /*
        Retorna que el token OUTPUT, declarado en la clase sym, fue encontrado.
    */
    "output" {
        return symbol(sym.OUTPUT);
    }

    /*
        Retorna que el token PIZQ, declarado en la clase sym, fue encontrado.
    */
    "(" {
        return symbol(sym.PIZQ);
    }

    /*
        Retorna que el token PDER, declarado en la clase sym, fue encontrado.
    */
    ")" {
        return symbol(sym.PDER);
    }

    /*
        Retorna que el token NULL, declarado en la clase sym, fue encontrado.
    */
    "null" {
        return symbol(sym.NULL);
    }

    /*
        Retorna que el token OP_ADD, declarado en la clase sym, fue encontrado.
    */
    "+" {
        return symbol(sym.OP_ADD);
    }

    /*
        Retorna que el token OP_SUB, declarado en la clase sym, fue encontrado.
    */
    "-" {
        return symbol(sym.OP_SUB);
    }

    /*
        Retorna que el token OP_MULT, declarado en la clase sym, fue encontrado.
    */
    "*" {
        return symbol(sym.OP_MULT);
    }

    /*
        Retorna que el token OP_DIV, declarado en la clase sym, fue encontrado.
    */
    "/" {
        return symbol(sym.OP_DIV);
    }

    /*
    	Si se encuentra un Numero, se imprime, se regresa un token del tipo Integer que representa un Numero y el valor que se obtuvo
    	de la cadena yytext al convertirla a Numero. yytext es el token encontrado.
	*/
    {Digito} {
        return symbol(sym.DIGITO, yytext());
    }

    /*
        Retorna que el token IDENTIFIER, declarado en la clase sym, fue encontrado.
    */
    {Identificador} {
        return symbol(sym.IDENTIFIER, yytext());
    }

    /*
    	No hace nada si encuentra el espacio en blanco
	*/
    {Espacio} {
    	/* ignora el espacio */
    }
}

/*
	Si el token contenido en la entrada no coincide con ninguna regla entonces se marca un token ilegal
*/
[^] {
	throw new Error("Caracter ilegal <"+yytext()+">");
}
