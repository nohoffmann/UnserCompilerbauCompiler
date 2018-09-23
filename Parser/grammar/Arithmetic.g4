grammar Arithmetic;

//////////////////////////////////////////////////////////////////////////
//Token-Definitionen													//
//////////////////////////////////////////////////////////////////////////
ID: [a-zA-Z][a-zA-Z0-9]*;	//bezeichner								//
INTEGER : [0-9]+ ;         	//beliebige folge der ziffern 0 bis 9		//
WS : [ \t\r\n]+ -> skip ;	//ueberspringt spaces, tabstops, linefeeds	//
LPAREN : '(';		  		//oeffndende runde klammer					//
RPAREN : ')';		  		//schliessende runde klammer				//
//mathematische operatoren												//
PLUSOP : '+';															//
MINOP  : '-';															//
MULTOP : '*';															//
DIVOP  : '/';															//
																		//
//vergleichsoperatoren													//
LT  : '<'  ;															//
LEQ : '<=' ;															//
GT  : '>'  ;															//
GEQ : '>=' ;															//
EQ  : '==' ;															//
																		//
//logische verknuepfungen												//
AND : '&&' ;															//
OR : '||'  ;															//
NOT : '!'  ;															//
																		//
//sonstige operatoren													//
ASSIGNOP : '=';															//
//////////////////////////////////////////////////////////////////////////




//////////////////////////////////////////////////////////////////////////
//Grundlegende Regeln													//
//////////////////////////////////////////////////////////////////////////
//Startregel/axiom														//
program : progPart+ 													//
		;																//
																		//
progPart : statement 			#MainStatement							//
         | functionDefinition   #ProgPartFunctionDef					//
         ;																//
																		//
statement : println ';'													//
		  | varDeclaration ';'											//
		  | assignment ';'												//
		  | branch 														//
		  | loop														//
		  ;																//
		  	  															//
//Regel fuer Ausgabefunktion											//
println : 'println(' argument=expression ')' 							//
		;																//
//////////////////////////////////////////////////////////////////////////

		  

//////////////////////////////////////////////////////////////////////////
//Regeln fuer Variablen													//
//////////////////////////////////////////////////////////////////////////
varDeclaration : 'int' varName=ID 										//
			   ;														//
																		//
assignment : varName=ID ASSIGNOP expr=expression						//
			;															//
//////////////////////////////////////////////////////////////////////////





//////////////////////////////////////////////////////////////////////////
//Regeln fuer Funktionen												//
//////////////////////////////////////////////////////////////////////////
functionDefinition : 													//
	'int' functionName=ID LPAREN params=parameterDeclaration RPAREN 	//
		'{' 															//
			statements=statementList 									//
			'return' returnValue=expression ';'							//
		 '}' 															//
		 		   ;													//
																		//
functionCall : functionName=ID LPAREN arguments=expressionList RPAREN 	//
			 ;															//
																		//
statementList : statement*												//
			  ;															//
																		//
parameterDeclaration : 													//
	declarations+=varDeclaration (',' declarations+=varDeclaration)*	//
					|													//
					;													//
																		//
expressionList : expressions+=expression (',' expressions+=expression)*	//
			   |														//
			   ;														//
//////////////////////////////////////////////////////////////////////////




		  
//////////////////////////////////////////////////////////////////////////
//Regeln fuer Kontrollstrukturen										//
//////////////////////////////////////////////////////////////////////////
branch : 'if' '(' condition=expression ')' 								//
			onTrue=block 												//
		'else' 															//
			onFalse=block												//
	   ;																//
																		//
loop : 'while' '(' condition=expression ')' onTrue=block				//
	 ;																	//
																		//
block : '{' statement* '}' 												//
	  ;																	//
//////////////////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////
//Regeln fuer math. Ausdruecke											//
//////////////////////////////////////////////////////////////////////////
expression: INTEGER									#Number				//
	| varName=ID									#Variable			//
	| LPAREN expression RPAREN						#Parenthesis		//
	| expression DIVOP  expression  				#Division			//
	| expression MULTOP expression					#Multiplication		//
	| expression MINOP  expression  				#Subtraction		//
	| expression PLUSOP expression  				#Addition			//
	| expression compareOp=(LT | LEQ | GT | GEQ | EQ) expression	#Comparison
	| leftSide=expression AND rightSide=expression	#AndGate			//
	| leftSide=expression OR rightSide=expression	#OrGate				//
	| NOT expr=expression							#InverseGate		//
	| functionCall 									#functionCallExpression
	;																	//
//////////////////////////////////////////////////////////////////////////
