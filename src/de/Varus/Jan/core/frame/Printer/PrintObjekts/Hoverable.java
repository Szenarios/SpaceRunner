package de.Varus.Jan.core.frame.Printer.PrintObjekts;
/**
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
	 * Wird aufgerufen wenn der Mauszeiger das Objekt verlässt. 
	 */
	void onHoverRelease(); 
}
