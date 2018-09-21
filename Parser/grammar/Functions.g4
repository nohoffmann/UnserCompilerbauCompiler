grammar Functions;

ID : [a-zA-Z]+;
WS : [ \t\r\n]+ -> skip ;



function : dataType functionName'('(functionParameter)+')' ';'
         | dataType functionName'('')' ';';

functionName : ID ;

functionParameter : dataType ID
                | (dataType ID ',')+;


dataType : voidType
        | intType
        | floatType
        | boolType;


lCurlyBracket : '{';
rCurlyBracket : '}';


voidType : 'void';
intType : 'int';
floatType : 'float';
boolType : 'bool';
