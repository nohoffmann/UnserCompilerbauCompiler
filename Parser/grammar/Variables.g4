/**
 * WORK IN PROGRESS
 */

grammar Variables;

ID : [a-zA-Z]+;                                 //Kombination aus Klein- und/oder Grossbuchstaben, vgl. Spezifikation
NUMERICVALUE : [0-9]+;                          //ganze Zahlen
FLOATVALUE : [0-9]+'.'[0-9]+;                   //Gleitkommazahlen, '.'-character als Trennzeichen
WS : [ \t\r\n]+ -> skip;                        //ueberspringt Leerzeichen, Tabstops und Zeilenumbrueche

statement : declaration endofstatement
          | definition endofstatement
          | assignment endofstatement;

inttype : 'int';
floattype : 'float';


datatype : inttype | floattype;
value : NUMERICVALUE | FLOATVALUE;
name : ID;

//keywords u. character
assignmentop : '=';
constkeyword : 'const';
endofstatement : ';';


//bei einer definition wird eine variable des Typs datatype mit dem Namen name angelegt und mit dem Wert value initialisiert
definition : constkeyword datatype name assignmentop value
           | datatype name assignmentop value;

//bei einer declaration wird lediglich die Variable angelgt, dabei findet keine Initialisierung statt.
declaration : constkeyword datatype name
            | datatype name;

//zuweisungsoperation, der Variablen name wird der Wert value zugewiesen.
assignment : name assignmentop value;
