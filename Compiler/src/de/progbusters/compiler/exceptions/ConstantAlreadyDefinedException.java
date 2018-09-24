package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class ConstantAlreadyDefinedException extends CompileException {
	private static final long serialVersionUID = 1L;
	private String constName;
	
	public ConstantAlreadyDefinedException(Token constNameToken) {
		super(constNameToken);
		this.constName = constNameToken.getText();
	}
	
	public String getMessage() {
		return line + ":" + column + " constant already defined: <" + constName + ">";

	}
}
