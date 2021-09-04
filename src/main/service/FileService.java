package main.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileService {

	static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FileService.class.getName());

	PatternService patternService = new PatternService();

	UtilService utilService = new UtilService();

	/**
	 * Metodo principal para el procesamiento del archivo de txt y la generacion de
	 * otro con los numeros ya procesados.
	 * 
	 * @param pathFileInputParam  parametro para el path del archivo txt de entrada
	 *                            que contiene los numeros de cuenta generados por
	 *                            la maquina
	 * @param pathFileOutputParam parametro para el path del archivo txt de salida
	 *                            que contiene los numeros de cuenta validados
	 */
	public void processFileAndWriteAccountNumbers(String pathFileInputParam, String pathFileOutputParam) {

		BufferedReader inputFile = null;
		char[][] matrizTemp = new char[3][27];
		int verticalCount = 0;
		FileWriter outputFile = null;
		PrintWriter pw = null;
		try {
			outputFile = new FileWriter(pathFileOutputParam);
			pw = new PrintWriter(outputFile);
			inputFile = new BufferedReader(new FileReader(pathFileInputParam));

			String lineAccountNumber = inputFile.readLine();

			while (lineAccountNumber != null) {
				if (lineAccountNumber.length() == 0 || verticalCount == 3)
					verticalCount = 0;

				// Se extrae toda la línea validando la cantidad de caracteres
				if (lineAccountNumber.length() == 27) {
					matrizTemp[verticalCount] = lineAccountNumber.toCharArray();
					verticalCount++;

					// Si llega a tres significa que ya se lleno la matriz y se envia para su
					// procesamiento.
					if (verticalCount == 3) {
						String finaltAccountNumber = extractNumberData(matrizTemp);
						// Conforme se obtiene el dato final se escribe en el documento.
						pw.println(finaltAccountNumber);
					}
				}
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

	/**
	 * Metodo que recorre la matriz que contiene el numero de cuenta completo,
	 * obtiene, separa y tranforma en patrones para despues validar que los datos
	 * obtenidos sean correctos.
	 * 
	 * @param matrizTemp contiene el numero de cuenta
	 * @return
	 */
	private String extractNumberData(char[][] matrizTemp) {
		char[] vectorTemp = new char[9];
		char[] vectorFinal = new char[9];
		int countStepStep = 0;

		for (int i = 0; i < 9; i++) {
			int vectorCountT = 0;
			for (int a = 0; a < 3; a++) {
				int step = countStepStep;
				for (int b = 0; b < 3; b++) {
					vectorTemp[vectorCountT] = matrizTemp[a][step];
					step++;
					vectorCountT++;
				}
			}
			vectorFinal[i] = patternService.getAccountNumber(vectorTemp);
			countStepStep = (countStepStep + 3);
		}

		return null;
	}



}
