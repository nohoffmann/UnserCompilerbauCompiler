package de.progbusters.compiler;

/**@brief
 * repraesentiert eine Variable
 */
public class Variable {
	String dataType;
	String varName;
	String value;
	boolean isConstant;
	
	/**
	 * @brief Konstruktor der Klasse Variable
	 * @param dataType		Datentyp der Variable
	 * @param varName		Name der Variable
	 * @param value			Wert der Variable
	 * @param isConstant	Flag, ob Wert konstant ist
	 */
	public Variable(String dataType, String varName, String value, boolean isConstant) {
		super();
		this.dataType = dataType;
		this.varName = varName;
		this.value = value;
		this.isConstant = isConstant;
	}
	
	/**
	 * @brief ueberprueft an Hand von Datentyp und Name, ob eine Variabel bereits vorhanden ist
	 * @param right		Die zu vergleichende Variable
	 * @return			true, falls vorhanden. false, falls nicht.
	 */
	boolean isEqual(Variable right) {
		if(/*	this.dataType == right.dataType			//gleicher Datentyp
		 &&	*/this.varName == right.varName) {		//und gleicher Name
			return true;							//bedeuten, dass die Variable schon vorhanden ists
		} else {
			return false;
		}
	}
	
	/**
	 * Simple set-Methode fuer den Wert
	 * @param value der zu setzende Wert
	 */
	void setValue(String value ) {
		this.value = value;
	}
}
