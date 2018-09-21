// Define a grammar called Hello
grammar Arithmetic;

ID : [0-9]+ ;             // beliebige folge der ziffern 0 bis 9
WS : [ \t\r\n]+ -> skip ; // ueberspringt leerzeichen, tabstops sowie linefeeds
LPAREN : '(';		  // oeffndende runde klammer
RPAREN : ')';		  // schliessende runde klammer


r : expression;

expression: number=ID					
	| lparen=LPAREN expression rparen=RPAREN										#Parenthesis
	| <assoc=right> faktorLinks=expression 		MULTOP faktorRechts=expression		#Multiplication
	| <assoc=right> dividend=expression 		DIVOP  divisor=expression			#Division
	| <assoc=right> summandLinks=expression 	PLUSOP summandRechts=expression		#Addition
	| <assoc=right> minuend=expression 			MINOP subtrahend=expression			#Subtraction //nach PEMDAS-Regel
	;				

//mathematische operatoren
PLUSOP : '+';
MINOP : '-';
MULTOP : '*';
DIVOP : '/';


