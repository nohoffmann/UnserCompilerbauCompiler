package de.progbusters.compiler;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.progbusters.compiler.exceptions.FunctionAlreadyDefinedException;
import de.progbusters.compiler.exceptions.UndeclaredVariableException;
import de.progbusters.compiler.exceptions.UndefinedFunctionException;
import de.progbusters.compiler.exceptions.VariableAlreadyDefinedException;
import jasmin.ClassFile;

public class CompilerTest {
	private Path tempDir;
	
	@BeforeMethod
	public void createTempDir() throws Exception {
		tempDir = Files.createTempDirectory("compilerTest");
	}
	
	@AfterMethod
	public void delteTempDir() {
		deleteRecursive(tempDir.toFile());
	}
	
	private void deleteRecursive(File file) {
		if (file.isDirectory()) {
			for(File child : file.listFiles()) {
				deleteRecursive(child);
			}
		} 
		if (!file.delete() ) {
			throw new Error("Could not delete file <" + file + ">");
		}
	}

	@Test(dataProvider = "provide_code_expectedText")
	public void runningCode_outputsExpectedText(String description, String code, String expectedText) throws Exception {
		
		//execution
		String actualOutput = compileAndRun(code);
	  
		//evaluation
		Assert.assertEquals(actualOutput, expectedText);
	}

	@DataProvider
	public Object[][] provide_code_expectedText() throws Exception {
		return new Object[][] {
			{"chained arithmetic", "println(12345+2+3+4+5+2*10-48*(4-1)-16/4);", "12231" + System.lineSeparator()},
			{"addition", "println(1+4);", "5" + System.lineSeparator()}, 
			{"multiple print statements","println(1234); println(151);", "1234" + System.lineSeparator() + "151" + System.lineSeparator() },
			{"multiple print statements with arithmetic", "println(666); println(1234+5); println(1+1);", "666" + System.lineSeparator() + "1239" + System.lineSeparator() + "2" +System.lineSeparator() },
			{"arithmetic left to right add sub", "println(8-2+5);", "11" + System.lineSeparator()},
			{"arithmetic left to right mul div", "println(8/2*4);", "16" + System.lineSeparator()},
			{"order of operations","println(9-2*3);", "3" + System.lineSeparator()},
			
			{"variables and arithmetic", example("variables/arithmetic"), "2" + System.lineSeparator() + "60" + System.lineSeparator() },
			
			{"simple functions", example("functions/simple"), "42" + System.lineSeparator()},
			
			{"functions with statement in body", example("functions/function_body"), "42" + System.lineSeparator()},
			//testet Scopes, i wird sowohl in randomNumber() als auch im main-Scope definiert 
			{"scopes", example("functions/scopes"), "42" + System.lineSeparator() + "2" + System.lineSeparator() },
			//testet Funktionsparameter
			{"function parameters", example("functions/parameters"), "7" + System.lineSeparator() },
			//testet, ob mehrere Funktionen mit gleichem Namen, aber unterschiedlicher Parameterliste moeglich sind
			{"functions with equal name but different signature", example("functions/equal_name_different_signature"), "42" + System.lineSeparator() + "23" + System.lineSeparator() },
			//teste conditional branches
			{"if-else-statement with false", example("branch/if_int_false") , "69" + System.lineSeparator()} ,
			{"if-else-statement with true", example("branch/if_int_true") , "42" + System.lineSeparator()},
			
			{"lower than evaluates to true", "println(3<4);", "1" + System.lineSeparator()},
			{"lower than evaluates to false", "println(4<4);", "0" + System.lineSeparator()},
			
			{"equal evaluates to true", "println(1 == 1);", "1" + System.lineSeparator()},
			{"equal evaluates to false", "println(1 == 0);", "0" + System.lineSeparator()},
			
			{"lower or equal evaluates to true", "println(3<=4);", "1" + System.lineSeparator()},
			{"lower or equal evaluates to true", "println(4<=4);", "1" + System.lineSeparator()},
			{"lower or equal evaluates to false", "println(5<=4);", "0" + System.lineSeparator()},
			
			{"greater than evaluates to true", "println(4>3);", "1" + System.lineSeparator()},
			{"greater than evaluates to false", "println(4>4);", "0" + System.lineSeparator()},
			
			{"greater or equal evaluates to true", "println(5>=4);", "1" + System.lineSeparator()},
			{"greater or equal evaluates to true", "println(4>=4);", "1" + System.lineSeparator()},
			{"greater or equal evaluates to false", "println(3>=4);", "0" + System.lineSeparator()},
			
			{"false and false", "println(0 && 0);", "0" + System.lineSeparator()},
			{"true and false", "println(1 && 0);", "0" + System.lineSeparator()},
			{"false and true", "println(0 && 1);", "0" + System.lineSeparator()},
			{"true and true", "println(1 && 1);", "1" + System.lineSeparator()},
			
			{"false or false", "println(0 || 0);", "0" + System.lineSeparator()},
			{"true or false", "println(1 || 0);", "1" + System.lineSeparator()},
			{"false or true", "println(0 || 1);", "1" + System.lineSeparator()},
			{"true or true", "println(1 && 1);", "1" + System.lineSeparator()},
			
			{"notGate true", "println(!1);", "0" + System.lineSeparator()},
			{"notGate false", "println(!0);", "1" + System.lineSeparator()},
			
			{"loop test", example("loops/sum_from_0_to_5"), 
				"0" + System.lineSeparator() + 
				"1" + System.lineSeparator() +
				"3" + System.lineSeparator() + 
				"6" + System.lineSeparator() + 
				"10"+ System.lineSeparator()}
		};
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:8 undeclared variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifReadingUndefinedVariable() throws Exception{
		//execution
		compileAndRun("println(x);");
		//evaluation performed by expceted exception
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:0 undeclared variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifWritingUndefinedVariable() throws Exception{
		//execution
		compileAndRun("x=5;");
		//evaluation performed by expceted exception
	}
		
	@Test(expectedExceptions = VariableAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:4 variable already defined: <x>")
	public void compilingCode_throwsVariableAlreadyDefiniedException_whenRedifingVariable() throws Exception{
		//execution
		compileAndRun("int x;" + System.lineSeparator() + "int x;");
		//evaluation performed by expceted exception
	}

	@Test(expectedExceptions = UndefinedFunctionException.class, expectedExceptionsMessageRegExp = "1:8 call to undefined function: <undefinedFunct>")
	public void compilingCode_throwsUndefinedFunctionException_whenCallingUndefinedFunction() throws Exception{
		//execution
		compileAndRun("println(undefinedFunct());");
		//evaluation performed by expceted exception
	}
	
	@Test(expectedExceptions = FunctionAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:4 function already defined: <test>")
	public void compilingCode_throwsFunctionAlreadyDefinedException_whenDefiningAlreadyDefinedFunction() throws Exception{
		//execution
		compileAndRun("int test() { return 123; } \nint test() { return 123; } ");
		//evaluation performed by expceted exception
	}

	
	
	private static String example(String fileName) throws Exception {
		try(InputStream in = CompilerTest.class.getResourceAsStream("/examples/" + fileName + ".txt")) {
			if(in == null) {
				throw new IllegalArgumentException("No such example <" + fileName + ">");
			}
			return new Scanner(in, "UTF-8").useDelimiter("\\A").next();
		}
	}
	
	
	
	private String compileAndRun(String code) throws Exception {
		CharStream test = CharStreams.fromString(code);
		code = Main.compile(test);
		ClassFile classFile = new ClassFile();
		classFile.readJasmin(new StringReader(code), "", false);
		Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
		try(OutputStream out = Files.newOutputStream(outputPath)) {
			classFile.write(out);
		}
		//	classFile.write(Files.newOutputStream(outputPath));
		return runJavaClass(tempDir, classFile.getClassName());
	}

	private String runJavaClass(Path dir, String className) throws Exception{
		Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
		try(InputStream in = process.getInputStream()) {
			return new Scanner(in).useDelimiter("\\A").next();
		}
	}
}
