package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredConstantException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String constName;
	
	public UndeclaredConstantException(Token constNameToken) {
		super(constNameToken); 
		this.constName = constNameToken.getText();
	}


	@Override
	public String getMessage(){
		return line + ":" + column + " undeclared constant <" + constName + ">";
	}
}