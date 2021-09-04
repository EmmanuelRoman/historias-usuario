package main.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileService {

	static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FileService.class.getName());

	PatternService patternService = new PatternService();

	/**
	 * 
	 * @param pathFileInputParam  parametro para el path del archivo txt de entrada
	 *                            que contiene los numeros de cuenta generados por
	 *                            la maquina
	 * @param pathFileOutputParam parametro para el path del archivo txt de salida
	 *                            que contiene los numeros de cuenta validados
	 */
	public void processFileAndWriteAccountNumbers(String pathFileInputParam, String pathFileOutputParam) {

		BufferedReader inputFile = null;
		FileWriter outputFile = null;
		PrintWriter pw = null;
		try {
			outputFile = new FileWriter(pathFileOutputParam);
			pw = new PrintWriter(outputFile);
			inputFile = new BufferedReader(new FileReader(pathFileInputParam));
			
			String lineAccountNumber = inputFile.readLine();
			
			while (lineAccountNumber != null) {
				pw.println(lineAccountNumber);
				lineAccountNumber = inputFile.readLine();				
			}

		} catch (FileNotFoundException e) {
			logger.severe("Error: Fichero no encontrado");
			logger.severe(e.getMessage());
		} catch (Exception e) {
			logger.severe("Error de lectura del fichero");
			logger.severe(e.getMessage());
		} finally {
			try {
				if (inputFile != null)
					inputFile.close();
				if (null != outputFile)
					outputFile.close();
			} catch (Exception e) {
				logger.severe("Error al cerrar el fichero");
				logger.severe(e.getMessage());
			}
		}
	}

	
}
