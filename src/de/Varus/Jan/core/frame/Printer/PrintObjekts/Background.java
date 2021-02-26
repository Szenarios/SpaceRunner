package de.Varus.Jan.core.frame.Printer.PrintObjekts;
/**
 * 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface Background {
	/**
	 * Gibt an ob der Background gezeichnet werden soll. 
	 * @return {@link Boolean} ob der Background gezeichnet werden soll. 
	 */
	boolean print(); 
	/**
	 * setzt den Wert ob der Background gezeichnet werden soll.
	 * @param print Der neue Wert der angibt ob der Background gezeicht werden soll. 
	 */
	void setPrint(boolean print); 
}
