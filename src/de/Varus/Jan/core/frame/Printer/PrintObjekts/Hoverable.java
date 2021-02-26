package de.Varus.Jan.core.frame.Printer.PrintObjekts;

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
