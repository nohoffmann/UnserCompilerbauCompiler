package de.progbusters.compiler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import de.progbusters.parser.ArithmeticLexer;
import de.progbusters.parser.ArithmeticParser;

public class Main {
	public static void main(String[] args) throws Exception {
		String inputFile = ""/* "basic.maths"*/;
		String outputFile = "./tpblcOut.j";
		
		 for (String s: args) {
	            inputFile = s;
	        }
		
		CharStream input = CharStreams.fromFileName(inputFile);
		
		
		/*obere Zeile schreibt auf Standardausgabe
		  untere Zeile schreibt in Datei outputFile*/
		//System.out.println(compile(input));
		writeJasminCodeToFile(compile(input), outputFile);
	}
	
	//startet lexer, parser und visitor
	public static String compile(CharStream input) {
		ArithmeticLexer ariLex = new ArithmeticLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(ariLex);
		ArithmeticParser ariParser = new ArithmeticParser(tokens);
		
		ParseTree tree = ariParser.program();
		//ermittelt zunaechst alle Funktionsdefinitionen, damit keine Vowaertsdeklarationen benoetigt werden
		FunctionList definedFunctions = FunctionDefinitionFinder.findFunctions(tree);
		return createJasminFile(new MyArithmeticVisitor(definedFunctions).visit(tree));
	}

	//fuegt restliche benoetigte Statements hinzu
	private static String createJasminFile(String instructions) {
		return ".class public tpblcOut\n" + 
				".super java/lang/Object\n" + 
				"\n" + 
				instructions;
	}

	//simple Hilfsfunktion, die den String jasminCode in die Datei filename schreibt
	static void writeJasminCodeToFile(String jasminCode, String filename) throws Exception {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8")); 
		writer.write(jasminCode);
		writer.close();
		return;
	}
	
}
