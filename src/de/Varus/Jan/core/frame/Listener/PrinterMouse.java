package de.Varus.Jan.core.frame.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class PrinterMouse implements MouseListener {
	/**
	 * Aktueller Printer auf dem der MouseListener Reagiert. 
	 */
	private IPrinter printer; 
	/**
	 * Erzeugt einen MouseListener der alle {@linkplain Clickable} Interaktiv macht. 
	 * @param printer Der Aktuelle Printer auf dem der MouseListener interagieren soll. 
	 */
	public PrinterMouse(IPrinter printer) {
		this.printer = printer; 
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		for(Drawable d : printer.getDrawable()) {
			if(d instanceof Clickable) {
				((Clickable)d).checkAndRun(event.getX(), event.getY());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {}

	@Override
	public void mouseExited(MouseEvent event) {}

	@Override
	public void mousePressed(MouseEvent event) {}

	@Override
	public void mouseReleased(MouseEvent event) {}
}
