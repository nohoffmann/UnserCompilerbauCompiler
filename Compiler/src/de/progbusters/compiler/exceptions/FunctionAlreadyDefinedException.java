package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class FunctionAlreadyDefinedException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String functionName;
	
	public FunctionAlreadyDefinedException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}

	public String getMessage() {
		return line + ":" + column + " function already defined: <" + functionName + ">";

	}
	
}
