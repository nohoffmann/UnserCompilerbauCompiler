package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException{
	private static final long serialVersionUID = 1L;
	private String varName;
	
	public VariableAlreadyDefinedException(Token variableNameToken) {
		super(variableNameToken);
		this.varName = variableNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " variable already defined: <" + varName + ">";

	}
}
