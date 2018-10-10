/**
 * @file 	MyArithmeticVisitor.java
 * @author 	Noah Hoffmann
 * @date	05.09.2018
 * @brief 
 * nutzt einen von ANTLR generierten Visitor, um aus einem Parsetree Code in Jasmin-Syntax zu erstellen
 */

package de.progbusters.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import de.progbusters.compiler.exceptions.ConstantAlreadyDefinedException;
import de.progbusters.compiler.exceptions.ConstantReassignException;
import de.progbusters.compiler.exceptions.UndeclaredVariableException;
import de.progbusters.compiler.exceptions.UndefinedFunctionException;
import de.progbusters.compiler.exceptions.VariableAlreadyDefinedException;
import de.progbusters.parser.ArithmeticBaseVisitor;
import de.progbusters.parser.ArithmeticParser.AdditionContext;
import de.progbusters.parser.ArithmeticParser.AndGateContext;
import de.progbusters.parser.ArithmeticParser.AssignmentContext;
import de.progbusters.parser.ArithmeticParser.BranchContext;
import de.progbusters.parser.ArithmeticParser.ComparisonContext;
import de.progbusters.parser.ArithmeticParser.ConstDeclarationContext;
import de.progbusters.parser.ArithmeticParser.ConstantContext;
import de.progbusters.parser.ArithmeticParser.DivisionContext;
import de.progbusters.parser.ArithmeticParser.FunctionCallContext;
import de.progbusters.parser.ArithmeticParser.FunctionDefinitionContext;
import de.progbusters.parser.ArithmeticParser.InverseGateContext;
import de.progbusters.parser.ArithmeticParser.LoopContext;
import de.progbusters.parser.ArithmeticParser.MainStatementContext;
import de.progbusters.parser.ArithmeticParser.MultiplicationContext;
import de.progbusters.parser.ArithmeticParser.NegativeNumberContext;
import de.progbusters.parser.ArithmeticParser.NumberContext;
import de.progbusters.parser.ArithmeticParser.OrGateContext;
import de.progbusters.parser.ArithmeticParser.PrintlnContext;
import de.progbusters.parser.ArithmeticParser.ProgramContext;
import de.progbusters.parser.ArithmeticParser.SubtractionContext;
import de.progbusters.parser.ArithmeticParser.VarDeclarationContext;
import de.progbusters.parser.ArithmeticParser.VariableContext;


/**
 * @brief
 * Die Klasse MyArithmeticVisitor baut auf ANTLR-generiertem Code auf und implementiert die Jasmin-Code-Erzeugung auf Grundlage des vom Parser erstellen Syntaxbaum.
 *
 */
public class MyArithmeticVisitor extends ArithmeticBaseVisitor<String> {
	/**@brief
	 * Speichert Variablen. Dabei ist der key der Bezeichner der Variable und value der Index in der lokalen Variablentabell der JVM
	 */
	private Map<String, Integer> variables = new HashMap<>();
	/**@brief
	 * Speichert Schreibzugriffen auf Konstanten. Dabei ist der key der Bezeichner der Konstante und value die Zahl der Lesezugriffe in der lokalen Konstantentabell der JVM
	 */
	private Map<String, Boolean> constantsHasBeenAssigned = new HashMap<>();
	/**@brief
	 * Speichert definierte Funktionen.
	 */
	private FunctionList definedFunctions;
	/**@brief
	 * Zaehlt, wie viele if-else-statements vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int branchCount = 0;
	/**@brief
	 * Zaehlt, wie viele vergleiche vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int comparisonCount = 0;
	/**@brief
	 * Zaehlt, wie viele logische verknuepfungen vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int gateCount = 0;
	/**@brief
	 * Zaehlt, wie viele schleifen vorkommen, um jump-labels eindeutig zu benennen 
	 */
	private int loopCount = 0;
	
	/**
	 * Konstruktor der Klasse MyArithmeticVisitor
	 * @param definedFunctions Liste mit definierten Funktionen
	 */
	public MyArithmeticVisitor(FunctionList definedFunctions) {
		if(definedFunctions == null) {
			throw new NullPointerException("definedFunctions");
		} 
		this.definedFunctions = definedFunctions;
	}
	
	////////////////////////////////GRUNDLEGENDES////////////////////////////////
	//Startpunkt des Programms
	public String visitProgram(ProgramContext ctx) {
		//es wird zwischen code f.d. main-funktion
		String mainCode = "";
		//und code von restlichen funktionen unterschieden, damit entsprechende definitionen im jasmin-code korrekt getrennt werden
		String functions = "";
		
		//iteriert ueber alle statements, um o.g. unterscheidung zu treffen
		for(int i = 0; i < ctx.getChildCount(); i++) {
			//besucht je einen knoten
			ParseTree child = ctx.getChild(i);
			String generatedCode = visit(child);
			
			//entscheidet, ob main-scope oder andere funktion
			if(child instanceof MainStatementContext) {
				mainCode += generatedCode + "\n";
			} else {
				functions += generatedCode + "\n";
			}
		}
		
		//gibt entsprechenden jasmin-code zurück
		return functions + "\n" + ".method public static main([Ljava/lang/String;)V\n" + 
				"  .limit stack 100\n" + 
				"  .limit locals 100\n" + 
				mainCode + "\n" +
				"  return\n" + 
				".end method\n";
	}

	/**@brief
	 * vearbeitet den Aufruf der println-Funktion
	 */
	public String visitPrintln(PrintlnContext ctx) {
		return  ";calling println\n" + 
				"getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 	//legt ein System.out Objekt auf den Stack
				visit(ctx.argument) + //"\n" +						//Argument der print-Funktion
				"invokevirtual java/io/PrintStream/println(I)V\n\n"; 			//ruft die Methode println des System.out-Objekts auf
	}
	
	/**@brief
	 * verarbeitet ganze Zahlen
	 */
	public String visitNumber(NumberContext ctx) {
		return "ldc " + ctx.getChild(0) + "\n";
	}
	
	/**@brief
	 * verarbeitet negative ganze Zahlen
	 */
	public String visitNegativeNumber(NegativeNumberContext ctx) {
		return "bipush -" + ctx.getChild(1) + "\n"; 
	}
	
	/**@brief
	 * verarbeitet Zuweisungen. 
	 * Es erfolgt ein Zugriff auf die Variablen-Map, um den Index der lokalen Variablentabelle zu erhalten.
	 */
	public String visitAssignment(AssignmentContext ctx) {
		int index = -1;
		
		//wenn kein eintrag vorhanden ist, muss es eine variable sein
		if(constantsHasBeenAssigned.get(ctx.varName.getText()) == null) {
			index = requireVariableIndex(ctx.varName);
		} 
		//bei konstanten:
		//wenn bereits ein wert zugewiesen wurde, darf dies nicht erneut geschehen
		else if (constantsHasBeenAssigned.get(ctx.varName.getText()) == true) {
			throw new ConstantReassignException(ctx.varName);
		} 
		//falls erste zuweisung
		else {
			index = requireVariableIndex(ctx.varName);
			constantsHasBeenAssigned.put(ctx.varName.getText(), true);
		}
	
		return visit(ctx.expr) 
			 + "\n" 
			 + "istore " 
			 + index
			 + "\n";
	}

	
	////////////////////////////////VARIABLEN////////////////////////////////////
	/**@brief
	 * verarbeitet Variablen-Deklarationen.
	 * Der Name der Variable wird in der Hashmap variables mit dem zugehoerigen Index in der Variablentabelle gespeichert 
	 */
	public String visitVarDeclaration(VarDeclarationContext ctx) {
		if(variables.containsKey(ctx.varName.getText())) {
			throw new VariableAlreadyDefinedException(ctx.varName);
		}
		variables.put(ctx.varName.getText(), variables.size());	//speichert in variablen tabelle
		return ";delclaration\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von Variablen
	 * Es erfolgt ein Zugriff auf die Variablen-Map, um den Index der lokalen Variablentabelle zu erhalten.
	 */
	public String visitVariable(VariableContext ctx) {
		return "iload " 
			 + requireVariableIndex(ctx.varName)
			 + "\n";
	}
	
	
	////////////////////////////////KONSTANTEN///////////////////////////////////
	/**@brief
	 * verarbeitet Konstanten-Deklarationen.
	 * Der Name der Konstante wird in der Hashmap constants mit dem zugehoerigen Index in der Konstantentabelle gespeichert 
	 */
	public String visitConstDeclaration(ConstDeclarationContext ctx) {
		if(variables.containsKey(ctx.constName.getText())) {
			throw new ConstantAlreadyDefinedException(ctx.constName);
		}
		variables.put(ctx.constName.getText(), variables.size());	//speichert in constants tabelle
		constantsHasBeenAssigned.put(ctx.constName.getText(), false);
		return ";delclaration\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von Konstanten
	 * Es erfolgt ein Zugriff auf die Konstanten-Map, um den Index der lokalen Konstantentabelle zu erhalten.
	 */
	public String visitConstant(ConstantContext ctx) {
		return "iload " 
			 + requireVariableIndex(ctx.constName)
			 + "\n";
	}

	
	////////////////////////////////FUNKTIONEN///////////////////////////////////
	/**@brief
	 * verarbeitet funktions-aufrufe
	 */
	public String visitFunctionCall(FunctionCallContext ctx) {
		int numberOfParams = ctx.arguments.expressions.size();
		
		//ueberprueft, ob Funktion definiert wurde
		if(!definedFunctions.contains(ctx.functionName.getText(), numberOfParams)) {
			throw new UndefinedFunctionException(ctx.functionName);
		}
		
		String instructions = "";
		
		//verarbeitet ggf. uebergebene parameter
		String argumentInstructions = visit(ctx.arguments);
		if(argumentInstructions != null) {
			instructions += argumentInstructions + "\n";
		}
		
		//jasmin-instruction um funktion aufzurufen
		instructions +=  "invokestatic tpblcOut/" + ctx.functionName.getText() + "(";
		
		//generiert korrekte signatur fuer die funktion (anzahl der parameter)
		instructions += stringRepeat("I", numberOfParams);
		instructions += ")I\n";
		
		return instructions;
	}
	
	/**@brief
	 * verarbeitet funktions-deklarationen 
	 */
	public String visitFunctionDefinition(FunctionDefinitionContext ctx) {
		//kopiert die variablentabelle, um unterschiedliche scopes zu ermoeglichen
		Map<String, Integer> oldVariables = variables;

		//neue hasmap fuer den aktuellen gueltigkeitsbereich
		variables = new HashMap<>();
		//verarbeitet parameter-deklarationen der funktion
		visit(ctx.params);
		
		//verarbeitet funktionsrumpf
		String statementInstructions = visit(ctx.statements);
		
		//generiert korrekte signatur 
		String result = ".method public static " + ctx.functionName.getText() + "(";
		//aehnlich wie bei functionCall
		int numberOfParams = ctx.params.declarations.size();
		result += stringRepeat("I", numberOfParams);
		result += ")I\n"
			 + ".limit locals 100\n"
			 + ".limit stack 100\n"
			 //und fuehrt instructions in korrekter reihenfolge zusammen
			 + (statementInstructions == null ? " " : statementInstructions + "\n")
			 + visit(ctx.returnValue) + "\n"
			 + "ireturn\n"
			 + ".end method\n";
		
		//stellt die variablen-tabelle des vorangegangenen gueltigkeitsbereich wieder her
		variables = oldVariables;
		return result;
	}
	
	
	////////////////////////////////KONTROLLSTRUKTUREN///////////////////////////
	/**@brief
	 * verarbeitet if-else-statements
	 */
	public String visitBranch(BranchContext ctx) {
		String conditionInstructions = visit(ctx.condition);
		String onTrueInstructions = visit(ctx.onTrue);
		String onFalseInstructions = visit(ctx.onFalse);
		/*es muss ein index mitgezählt 
		  und angegeben werden, da sonst bei mehreren if-else-statements 
		  die labels nicht mehr eindeutig waeren*/
		branchCount++;	
		
		return conditionInstructions + "\n"
				//jasmin instruction, die zum angegebenen label springt, 
				//falls der wert auf dem stack != 0
				+ "ifne ifTrueLabel" + branchCount + "\n"
				//falls nicht gesprungen wurde, also wert auf dem stack == 0, 
				//werden die onFalseInstructions geladen
				+ onFalseInstructions + "\n"
				//und die onTrueInstructions uebersprungen
				+ "goto endIfLabel" + branchCount + "\n"
				+ "ifTrueLabel" + branchCount + ":\n"
				+ onTrueInstructions + "\n"
				+ "endIfLabel" + branchCount + ":\n";
	}
	
	/**@brief
	 * verarbeitet den Aufruf von while-Schleifen
	 */
	public String visitLoop(LoopContext ctx) {
		String conditionInstructions = visit(ctx.condition);
		String onTrueInstructions = visit(ctx.onTrue);
		//es muss ein counter mitgezaehlt werden, um die labels im jasmin code eindeutig benennen zu koennen
		loopCount++;
			
		return ";check condition\n" + 
				//bedingung fuer die schleife
				"conditionLabel" + loopCount + ":\n" + 
				conditionInstructions + "\n" +
				//wenn die bedingung true ist
				//sprung zum rumpf der schleife + 
				"ifne onTrueWhileLabel" + loopCount + "\n" + 
				//sonst abbruch der schleife 
				"goto endOfWhileLabel" + loopCount + "\n" +
				
				//funktionsrump
				"onTrueWhileLabel" + loopCount + ":\n" + 
				onTrueInstructions + "\n" +
				//am ende wird die condition erneut geprueft
				
				"goto conditionLabel" + loopCount + "\n" +
				//label fuer abbruch
				"endOfWhileLabel" + loopCount + ":";
	}
	
	
	///////////////////////////////ARITHMETIK UND LOGIK//////////////////////////
	/**@brief
	 * verarbeitet Divisionen
	 */
	public String visitDivision(DivisionContext ctx) {
		return visitChildren(ctx) + "\n"
				+ "idiv\n";
	}
	
	/**@brief
	 * verarbeitet Multiplikationen
	 */
	public String visitMultiplication(MultiplicationContext ctx) {
		return visitChildren(ctx) + "\n"
				+ "imul\n";
	}
	
	/**@brief
	 * verarbeitet Subtraktionen
	 */
	public String visitSubtraction(SubtractionContext ctx) {
		return visitChildren(ctx) + "\n"
				+ "isub\n";
	}
	
	/**@brief
	 * verarbeitet Additionen
	 */
	public String visitAddition(AdditionContext ctx) {
		return visitChildren(ctx) + "\n"
				+ "iadd\n";
	}
	
	/**@brief
	 * verarbeitet aufrufe von vergleichsoperatoren
	 */
	public String visitComparison(ComparisonContext ctx) {
		//zaehler haelt sprung labels eindeutig
		comparisonCount++;
		String compareInstruction = "";
		
		//jasmin aurufe fuer enstsprechende vergleiche
		switch(ctx.compareOp.getText()) {
			case "<": 
				compareInstruction = "if_icmplt";
				break;
			case "<=":
				compareInstruction = "if_icmple";
				break;
			case ">":
				compareInstruction = "if_icmpgt ";
				break;
			case ">=":
				compareInstruction = "if_icmpge";
				break;
			case "==":
				compareInstruction = "if_icmpeq";
				break;
			default:
				throw new IllegalArgumentException("Unknown operator: " + ctx.compareOp.getText());
		}
		
		return visitChildren(ctx) + "\n"
			  + compareInstruction + 
			  //wenn vergleich wahr ist, sprung zu onTrueLabel
			  " onTrueLabel" + comparisonCount + "\n" + 
		
			  //wenn vergleich falsch ist und kein sprung erfolgt, 
			  //wird eine 0 fuer false auf den stack geladen
			  "ldc 0 \n" + 
			  //ueberspringt true case
			  "goto onFalseLabel" + comparisonCount + "\n" +
			  
			  //nach dem onTrueLabel wird eine 1 fuer true auf den stack geladen
			  "onTrueLabel" + comparisonCount + ":\n" + 
			  "ldc 1 \n" + 
			  "onFalseLabel" + comparisonCount + ":\n" ;
	}
	
	/**@brief
	 * verarbeitet aufrufe des logischen und (&&)
	 */
	public String visitAndGate(AndGateContext ctx) {
		String leftSide = visit(ctx.leftSide);
		String rightSide = visit(ctx.rightSide);
		//zaehler haelt labels eindeutig
		gateCount++;
		
		return leftSide + 
				//wenn die linke seite false ist, muss der gesamte ausdruck false sein
				"ifeq onFalseAndLabel" + gateCount + "\n" + 
				rightSide + 
				//wenn die rechte seite false ist, muss der gesamte ausdruck false sein
				"ifeq onFalseAndLabel" + gateCount + "\n" + 
				
				//falls beide seiten true sind und nicht gesprungen wurde
				//wird eine 1 fuer true auf den stack gelegt
				"ldc 1\n" + 
				//und der false-teil uebersprungen
				"goto onTrueAndLabel" + gateCount + "\n" + 
				
				//falls zu diesem label gesprungen wurde
				"onFalseAndLabel" + gateCount + ":\n" + 
				//muss das ergebnis false (== 0) sein
				"ldc 0\n" + 
				"onTrueAndLabel"+ gateCount + ":\n";
		
	}
	
	/**@brief
	 * verarbeitet aurufe des logischen oder (||)
	 */
	public String visitOrGate(OrGateContext ctx) {
		String leftSide = visit(ctx.leftSide);
		String rightSide = visit(ctx.rightSide);
		//zaehler haelt labels eindeutig
		gateCount++;
		
		return leftSide + 
				//wenn die linke seite true ist, muss der gesamte ausdruck true sein
				"ifne onTrueOrLabel" + gateCount + "\n" + 
				rightSide +
				//wenn die rechte seite true ist, muss der gesamte ausdruck true sein
				"ifne onTrueOrLabel" + gateCount + "\n" + 
				
				//wenn keine der seiten true ist, wird eine 0 fuer false auf den stack geladen
				"ldc 0\n" + 
				//und der true-teil uebersprungen
				"goto onFalseOrLabel" + gateCount + "\n" + 
				
				//wenn mindestens eine der seiten true ist
				//und zu diesem label gesprungen wird
				"onTrueOrLabel" + gateCount + ":\n" + 
				//wird eine 1 fuer true auf den stack gelegt
				"ldc 1\n" + 
				"onFalseOrLabel" + gateCount + ":\n"; 
	}
	
	/**@brief
	 * verarbeitet aufrufe des logischen nicht (!)
	 */
	public String visitInverseGate(InverseGateContext ctx) {
		String expr = visit(ctx.expr);
		//zaehler haelt labels eindeutig
		gateCount++;
		
		return expr + 
				//wenn der ausdruck = false ist wird zum entsprechenden label gesprungen
				"ifeq onFalseNotLabel" + gateCount + "\n" + 
				//wenn nicht gesprungen wurde war der ausdruck true 
				//und es wird entsprechend eine 0 fuer false auf den stack gelegt
				"ldc 0\n" + 
				//ueberspringt restlichen code
				"goto onTrueNotLabel" + gateCount + "\n" + 
				
				//label das eine 1 fuer true auf den stack legt, wenn die eingabe 0 war
				"onFalseNotLabel" + gateCount + ":\n" + 
				"ldc 1 \n" + 
				"onTrueNotLabel" + gateCount + ":\n\n";
		
	}
	
		
	////////////////////////////////HILFSFUNKTIONEN (intern)//////////////////////
	/**@brief
	 * Simple Hilfsfunktion, die einen gegebenen String count-mal mit sich selbst konkateniert 
	 * @param string	Ausgangsstring, der wiederholt werden soll
	 * @param count		Anzahl der Wiederholungen
	 * @return			Zusammengesetzter String
	 */
	private String stringRepeat(String string, int count) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < count; i++) {
			result.append(string);
		}
		return result.toString();
	}

	/**@brief
	 * Loest den Namen einer Variablen zu dessen Index in der lokalen Variablentabelle auf
	 * @param varNameToken	Token mit dem Namen der Variablen
	 * @return				Index der Variablen in der lokalen Variablentabelle falls gefunden
	 */
	private int requireVariableIndex(Token varNameToken) {
		Integer varIndex = variables.get(varNameToken.getText());
		//falls variable nicht existiert
		if(varIndex == null) {
			throw new UndeclaredVariableException(varNameToken);
		}
		return varIndex;
	}
	
	/**@brief
	 * spezifiziert, wie zwei Strings konkateniert werden
	 */
	protected String aggregateResult(String aggregate, String nextResult) {
		if(aggregate == null) {
			return nextResult;
		}
		if(nextResult == null) {
			return aggregate;
		} else {
			return aggregate + nextResult;
		}
	}
}
