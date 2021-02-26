package de.Varus.Jan.core.Discord.RPC;

import club.minnced.discord.rpc.DiscordRPC;
/**
 * Updatet Discord RPC und ruft die Callbacks auf. 
 * @author Szenarios
 * @version B26.2.21 
 *
 */
public class DiscordRPCUpdateThread extends Thread {
	/**
	 * Der Discord RPC der am Leben gehalten wird. 
	 */
	private DiscordRPC rpc; 
	/**
	 * Ein Thread der den angebenden DiscordRPC ab leben hält.
	 * @param rpc Der angegebende DiscordRPC 
	 */
	public DiscordRPCUpdateThread(DiscordRPC rpc) {
		super("Discord RPC Update Thread");
		this.rpc = rpc; 
	}
	
	@Override
	public void run() {
		while(true) {
			this.rpc.Discord_RunCallbacks();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
