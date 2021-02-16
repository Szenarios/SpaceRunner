package de.Varus.Jan.core.frame.Listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.Varus.Jan.core.frame.Printer.IPrinter;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Clickable;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Drawable;

public class PrinterMouseListener implements MouseListener {
	
	private IPrinter printer; 
	public PrinterMouseListener(IPrinter printer) {
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
