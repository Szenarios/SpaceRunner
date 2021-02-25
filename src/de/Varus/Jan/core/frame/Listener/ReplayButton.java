package de.Varus.Jan.core.frame.Listener;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.Varus.Jan.core.frame.GameSettings;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.End.ReplayButtonPrint;

public class ReplayButton extends ReplayButtonPrint implements MouseListener {
	/**
	 * {@link MouseListener} für {@link ReplayButtonPrint} 
	 * @param settings Die {@link GameSettings} des verlorendes Spiels. 
	 * @param dimension Die Frame Größe des Game Over Screens
	 */
	public ReplayButton(GameSettings settings, Dimension dimension) {
		super(settings, dimension);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.checkAndRun(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
