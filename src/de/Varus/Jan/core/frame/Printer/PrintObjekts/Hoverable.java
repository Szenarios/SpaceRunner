package de.Varus.Jan.core.frame.Printer.PrintObjekts;
/**
 * Man kann �ber das Objekt Hovern.
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface Hoverable {
	/**
	 * Wird aufgerufen wenn der Mauszeiger auf dem Objekt ist. 
	 */
	void onHover(); 
	/**
	 * Wird aufgerufen wenn der Mauszeiger das Objekt verl�sst. 
	 */
	void onHoverRelease(); 
}
