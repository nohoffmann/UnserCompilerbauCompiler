package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ConstantReassignException extends CompileException {

	private static final long serialVersionUID = 1L;
	private String constName;
	
	public ConstantReassignException(Token ConstantNameToken) {
		super(ConstantNameToken);
		this.constName = ConstantNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " cannot reassign constants: <" + constName + ">";

	}
	
}
