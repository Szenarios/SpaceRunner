package de.Varus.Jan.core.Discord.RPC;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
/**
 * Managet die Status Meldung von Discord im gesamten Programm. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class DiscordStatus  {
	/**
	 * Thread der die RPC am Leben hält. 
	 */
	private DiscordRPCUpdateThread updateThread;
	/**
	 * Der Tatsächliche Discord RPC
	 */
	private DiscordRPC rpc; 
	/**
	 * Der Momentante Status des Spiels. 
	 */
	private DiscordGameStatus status; 
	/**
	 * Die zu letzt erreichten Punkte. 
	 */
	private int lastScore = 0; 
	
	/**
	 * Die Application ID
	 */
	private final String APPLICATIONID = "814229570395570207"; 

	/**
	 * Die Discord Status Klasse diese im Discord den Status des Spiels Anzeigt. 
	 */
	public DiscordStatus() {
		rpc = DiscordRPC.INSTANCE; 
		DiscordRichPresence presence = new DiscordRichPresence();
		presence.startTimestamp = System.currentTimeMillis() / 1000; 
		presence.largeImageKey = "mainimg"; 
		presence.largeImageText = "SpaceRunner by Szenarios"; 
		
		presence.details = "just started ..."; // Zeigt "just Started" an 
		rpc.Discord_UpdatePresence(presence);
		
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        rpc.Discord_Initialize(APPLICATIONID, handlers, true, "");
        
        updateThread = new DiscordRPCUpdateThread(rpc); 
        updateThread.start();
	}
	/**
	 * Ändern die angezeigt Punkzahl!
	 * @param points die neue erreichte Punktzahl die Angezeigt werden soll. 
	 */
	public  void chancePoints(int points) {
		if(getStatus() == DiscordGameStatus.PLAYING) {
			DiscordRichPresence presence = new DiscordRichPresence();
			presence.details = "Currently Playing \nPoints: " + points; 
			setLastScore(points);
			
			presence.startTimestamp = System.currentTimeMillis() / 1000; 
			presence.largeImageKey = "mainimg"; 
			presence.largeImageText = "SpaceRunner by Szenarios";
			rpc.Discord_UpdatePresence(presence);
		}
	}
	/**
	 * Ändern den Game Status. 
	 * @param status Der neue Discord Game Status
	 */
	public void chandeGameStatus(DiscordGameStatus status) {
		setStatus(status);

		DiscordRichPresence presence = new DiscordRichPresence();
		switch (getStatus()) {
		case MENU:
			presence.details = "Idle in Menu!"; 
			break;
		case PLAYING: 
			presence.details = "Playing!"; 
			break; 
		case DEAD: 
			presence.details = "Dead!\nLast Score: "+ lastScore; 
			break; 
		default:
			presence.details = "Unknown!"; 
			break;
		}
		presence.startTimestamp = System.currentTimeMillis() / 1000; 
		presence.largeImageKey = "mainimg"; 
		presence.largeImageText = "SpaceRunner by Szenarios";
		rpc.Discord_UpdatePresence(presence);
	}
	
	/**
	 * Gibt den Aktuellen Game Status an!
	 * @return Gibt den Aktuellen {@linkplain DiscordGameStatus} zurück
	 */
	public DiscordGameStatus getStatus() {
		return this.status;
	}
	/**
	 * Ändern dne Aktuellen {@linkplain DiscordGameStatus}. 
	 * @param status Der neue {@linkplain DiscordGameStatus}
	 */
	public void setStatus(DiscordGameStatus status) {
		this.status = status;
	}
	/**
	 * Gibt die Letzte erreichte Punktzahl an!
	 * @return Die Letzte erreichte Punktzahl als {@linkplain Integer}
	 */
	public int getLastScore() {
		return lastScore;
	}
	/**
	 * Ändern die letzte erreichte Punktzahl!
	 * @param lastScore Die neue Erreichte Punktzahl.
	 */
	public void setLastScore(int lastScore) {
		this.lastScore = lastScore;
	}
	
	
}
