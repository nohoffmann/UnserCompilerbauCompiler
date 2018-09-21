//Grammatik, um logische Ausdruecke zu parsen
//unbedingt notwendig, um Kontrollstrukturen wie if-else-statement oder Schleifen zu implementieren

grammar Boolean;

ID : [a-zA-Z]+;         //gueltige Namen sind mind. 1 Zeichen lang und bestehen aus Klein und/oder Grossbuchstaben
LPAREN : '(';           //oeffnende runde Klammer
RPAREN : ')';           //schliessende runde Klammer
WS : [ \t\r\n]+ -> skip; //ueberspringt Leerzeichen, Tabstops und Zeilenumbrueche

andGate : '&&';         //logische UND-Verknuepfung
orGate  : '||';         //logische ODER-Verknuepfung (inklusiv)
notGate : '!';          //logisches NICHT


boolVar : ID;

booleanAlgebra : boolVar
               | <assoc=right> LPAREN booleanAlgebra RPAREN
               | notGate booleanAlgebra
               | booleanAlgebra andGate booleanAlgebra
               | booleanAlgebra orGate booleanAlgebra;
