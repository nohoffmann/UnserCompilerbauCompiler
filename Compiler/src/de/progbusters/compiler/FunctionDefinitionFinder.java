package de.progbusters.compiler;

import org.antlr.v4.runtime.tree.ParseTree;

import de.progbusters.compiler.exceptions.FunctionAlreadyDefinedException;
import de.progbusters.parser.ArithmeticBaseVisitor;
import de.progbusters.parser.ArithmeticParser.FunctionDefinitionContext;

/**@brief
 * Die Klasse FunctionDefintionFinder wird vor dem eigentlichen Auswerten des ParseTree genutzt, um alle Funktionsdefinitionen zu pruefen  
 * @author noah
 *
 */
public class FunctionDefinitionFinder {
	
	/**@brief
	 * Die einzige Methode der Klasse. Besucht den Parsetree, um Funktionsdefintionen zu finden
	 * @param tree
	 * @return
	 */
	public static FunctionList findFunctions(ParseTree tree) {
		//legt eine Liste mit allen Funktionen an
		final FunctionList definedFunctions = new FunctionList();
		//nutzt den von ANTLR generierten Visitor
		new ArithmeticBaseVisitor<Void>() {
			//verarbeitet Funktionsdefintionen
			@Override
			public Void visitFunctionDefinition(FunctionDefinitionContext ctx) {
				String functName = ctx.functionName.getText();
				int paramCount = ctx.params.declarations.size();
				
				//ueberprueft, ob eine funktion mit der gleichen signatur bereits vorhanden ist.
				if(definedFunctions.contains(functName, paramCount)) {
					throw new FunctionAlreadyDefinedException(ctx.functionName);
				}
				
				//fuegt die Funktion der Liste hinzu
				definedFunctions.add(functName, paramCount);
				return null;
			}
		}.visit(tree);
		//gibt die Liste zurueck
		return definedFunctions;
	}
	

}
