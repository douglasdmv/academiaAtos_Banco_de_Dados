package br.com.tinylog;

import org.tinylog.Logger;

public class Principal {

	public static void main(String[] args) {
		Logger.info("Welcome to Tinylog");
		Logger.debug("Debug logging");
		Logger.error("Error logging");
		Logger.trace("Trace logging");
		Logger.warn("Warn logging");
	}

}
