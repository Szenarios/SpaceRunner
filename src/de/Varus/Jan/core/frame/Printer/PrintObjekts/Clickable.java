package de.Varus.Jan.core.frame.Printer.PrintObjekts;


public interface Clickable {
	/**
	 * Führt die das {@link Runnable} aus. 
	 * @param run Das {@link Runnable} was ausgewürt wird. 
	 */
	void perfrom(Runnable run ); 
	/**
	 * Gibt an ob der Ausgeführte Klick inerhalb des Buttons war. 
	 * @param x Die X Koordinate wo hingeclickt wurde. 
	 * @param y Die X Koordinate wo hingeclickt wurde. 
	 * @return Ob die Koordinaten auf dem Button liegen.
	 */
	boolean check(int x, int y); 
	/**
	 * Führt die Check methode aus und wenn true zurück gegeben wird auch die perform methode. 
	 * @param x Die X Koordinate wo hingeclickt wurde. 
	 * @param y Die X Koordinate wo hingeclickt wurde. 
	 */
	void checkAndRun(int x, int y); 
}
