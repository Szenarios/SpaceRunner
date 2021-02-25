package de.Varus.Jan.core.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import de.Varus.Jan.core.Main;
import de.Varus.Jan.core.Discord.RPC.DiscordGameStatus;
import de.Varus.Jan.core.frame.Listener.ReplayButton;
import de.Varus.Jan.core.frame.Printer.PrintObjekts.Game.End.EndGameFramePrint;

public class EndGameSence {
	/**
	 * Das EndGame Frame 
	 */
	private EndGameFramePrint endGameFramePrint; 
	/**
	 * Der Replay Button 
	 */
	private ReplayButton replayButton; 
	
	/**
	 * Das Zwischengespeichert {@link BufferedImage} 
	 */
	private BufferedImage bufferedImage; 
	/**
	 * Das {@link Graphics2D} objekt von dem {@link BufferedImage}
	 */
	private Graphics2D graphics; 
	
	/**
	 * Die Y Koordinate 
	 */
	private int y; 
	/**
	 * Die X Koordinate 
	 */
	private int x; 
	
	/**
	 * Die {@link GameSettings} von dem verlorenden Spiel
	 */
	private GameSettings settings; 
	
	/**
	 * Wird genutzt um auf einer Printer ein neues Frame (EndFrame) zu zeichnen. 
	 * @param settings Einstellungne woraus der end Screen Score genommen wird. 
	 */
	public EndGameSence(GameSettings settings) {
		this.settings = settings; 
		this.endGameFramePrint = new EndGameFramePrint(); 
		this.replayButton = new ReplayButton(settings, new Dimension(endGameFramePrint.getImage().getWidth(null), endGameFramePrint.getImage().getHeight(null))); 
		
		bufferedImage = new BufferedImage(endGameFramePrint.width(), endGameFramePrint.height(), BufferedImage.TYPE_INT_ARGB);
		graphics = (Graphics2D) bufferedImage.getGraphics();
		
		x  = Main.mainFrame.getWidth() / 2 - (endGameFramePrint.width() / 2); 
		y = Main.mainFrame.getHeight() / 2 - (endGameFramePrint.height() / 2); 
		
	}
	/**
	 * Zeichnet auf dem Graphic den EndGame Frame mit Text sowie Retry button.
	 * @param graphics objekt auf dem gezeichnet wird. 
	 */
	public void drawOn(Graphics graphics) {
		Main.discordStatus.chandeGameStatus(DiscordGameStatus.DEAD);
		endGameFramePrint.draw((Graphics2D) this.graphics);
		replayButton.draw(this.graphics);
		
		drawScore();
		
		graphics.drawImage(bufferedImage, x, y, null); 
	}
	/**
	 * Zeichnet den Score auf das Endgame Frame 
	 */
	public void drawScore() {
		this.graphics.setColor(Color.white);
		this.graphics.setFont(new Font("Arial",Font.BOLD,60));
		this.graphics.drawString(settings.getScore() +"", endGameFramePrint.x() + (endGameFramePrint.width() / 2) - (this.graphics.getFont().getSize() /2), endGameFramePrint.y() + endGameFramePrint.height() / 2 + (this.graphics.getFont().getSize() /3));
	}
	/**
	 * Gibt ein {@link EndGameFramePrint} zurück. 
	 * @return Aktuelles {@link EndGameFramePrint}
	 */
	public EndGameFramePrint getEndGameFramePrint() {
		return endGameFramePrint;
	}
	/**
	 * Gibt ein {@link ReplayButton} zurück
	 * @return Gibt {@link ReplayButton} zurück. 
	 */
	public ReplayButton getReplayButton() {
		return replayButton;
	}
	
	
}
