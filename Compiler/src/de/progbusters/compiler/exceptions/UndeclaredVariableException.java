package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends CompileException{
	private static final long serialVersionUID = 1L;
	private String varName;
	
	public UndeclaredVariableException(Token varNameToken) {
		super(varNameToken); 
		this.varName = varNameToken.getText();
	}


	@Override
	public String getMessage(){
		return line + ":" + column + " undeclared variable <" + varName + ">";
	}
}
