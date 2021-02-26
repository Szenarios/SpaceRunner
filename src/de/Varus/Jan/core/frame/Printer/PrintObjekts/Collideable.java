package de.Varus.Jan.core.frame.Printer.PrintObjekts;

import java.awt.Rectangle;
/**
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public interface Collideable {
	/**
	 * Die Hitbox des Objektes 
	 * @return Die Hitbox als {@link Rectangle}.
	 */
	Rectangle getHitbox(); 
}
