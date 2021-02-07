package de.Varus.Jan.core.frame.Printer.PrintObjekts;


public interface Clickable {
	void perfrom(Runnable run ); 
	boolean check(int x, int y); 
	void checkAndRun(int x, int y); 
}
