package br.com.loggin;
import java.util.logging.Level;

public class Principal {

	public static void main(String[] args) {
		try {
			Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de Informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
		} catch (Exception e) {
			
		}

	}

}
