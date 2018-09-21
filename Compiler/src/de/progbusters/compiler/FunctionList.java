package de.progbusters.compiler;

import java.util.ArrayList;
import java.util.Collection;

/**@brief
 * Die Klasse FunctionList beinhaltet eine Liste von FunctionDefinition-Objekten und kann ueberpruefen, ob eine Funktion bereits definiert ist oder nicht.
 * Dabei wird nicht nur der Name, sondern auch die Parameterliste abgegelichen.
 */
public class FunctionList {
	/**
	 * List, die FunctionDefinitions speichert
	 */
	private Collection<FunctionDefinition> definitions = new ArrayList<>();
	
	/**
	 * Ueberprueft, ob eine Funktion mit der gleichen Signatur bereits vorhanden ist
	 * @param functName		Der Name der zu pruefenden Funktion
	 * @param paramCount	Die Anzahl der Parameter der zu pruefenden Funktions
	 * @return				true, falls vorhanden, sonst false
	 */
	public boolean contains(String functName, int paramCount) {
		// iteriert ueber Liste
		for(FunctionDefinition def : definitions) {
			//und prueft, ob eine Funktion mit der gleichen Signatur vorhanden ist
			if (def.functName.equals(functName)
			 && def.paramCount == paramCount) {
				return true;
			}		
		}
		return false;
	}
	
	/**
	 * fuegt der Liste eine weitere FunctionDefinition hinzu
	 * @param functName		Name der Funktion
	 * @param paramCount	Anzahl an Paramtern
	 */
	public void add(String functName, int paramCount) {
		definitions.add(new FunctionDefinition(functName, paramCount));
	}
	
	/**@brief
	 * Simple Datenstruktur, um Funktions-Definitionen zu speichern.
	 */
	private static class FunctionDefinition {
		/**@brief
		 * Der Name der Funktion
		 */
		private final String functName;
		/**@brief
		 * Die Anzahl der Parameter
		 */
		private final int paramCount;
		
		/**
		 * Konstruktor der Klasse FunctionDefinition
		 * @param functName		Name der Funktion	
		 * @param paramCount	Anzahl Parameter
		 */
		private FunctionDefinition(String functName, int paramCount) {
			super();
			this.functName = functName;
			this.paramCount = paramCount;
		}
		
	}
}
