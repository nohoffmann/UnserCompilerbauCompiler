package de.progbusters.compiler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import de.progbusters.parser.ArithmeticLexer;
import de.progbusters.parser.ArithmeticParser;
import jasmin.ClassFile;

public class Main {
	public static void main(String[] args) throws Exception {
		String inputFile = ""/* "basic.maths"*/;
	//	String outputFile = "./tpblcOut.j";
				
		
		 for (String s: args) {
	            inputFile = s;
	        }
		
		CharStream input = CharStreams.fromFileName(inputFile);
		//writeJasminCodeToFile(compile(input), outputFile);
		
		createBytecode(input);
		
		/*obere Zeile schreibt auf Standardausgabe
		  untere Zeile schreibt in Datei outputFile*/
		//System.out.println(compile(input));
		
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

	
	static void createBytecode(CharStream inputStream) throws Exception {
		//setzt outputDir zu aktuellem verzeichnis
		Path outputDir = FileSystems.getDefault().getPath("./");
		
		//generieren von JasminCode
		String code = compile(inputStream);
		//Jasmin-Aufruf
		ClassFile classFile = new ClassFile();
		classFile.readJasmin(new StringReader(code), "", false);
		
		//.class datei schreiben
		Path outputPath = outputDir.resolve(classFile.getClassName() + ".class");
		try(OutputStream out = Files.newOutputStream(outputPath)) {
			classFile.write(out);
		}
	}

	
	//simple Hilfsfunktion, die den String jasminCode in die Datei filename schreibt
	static void writeJasminCodeToFile(String jasminCode, String filename) throws Exception {
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8")); 
		writer.write(jasminCode);
		writer.close();
		return;
	}

}
