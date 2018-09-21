package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndefinedFunctionException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String functionName;
	
	public UndefinedFunctionException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " call to undefined function: <" + functionName + ">";

	}
	
}
