package de.progbusters.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class CompileException extends RuntimeException {
	private static final long serialVersionUID = -3546840023649947687L;
	protected int line;
	protected int column;
	
	public CompileException(Token token) {
		this.line = token.getLine();
		this.column = token.getCharPositionInLine();
	}
}
