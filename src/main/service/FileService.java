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
		logger.info("Inicia la lectura del archivo...");
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
						logger.info(String.format("Se proceso el numero de cuenta: %s", finaltAccountNumber));
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

			logger.info("Finalizo la lectura del archivo...");
			try {
				if (pw != null)
					pw.close();
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
	 * @return regresa el numero de cuenta ya validado y procesado.
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

		return scannValidData(vectorFinal);
	}

	/**
	 * Metodo que procesa el vector final con los numeros ya identificados y
	 * separados.
	 * 
	 * @param vectorFinal contiene el numero de cuenta.
	 * @return regresa el numero de cuenta ya validado y procesado.
	 */
	private String scannValidData(char[] vectorFinal) {
		int sumNumberDigit = 0;
		boolean illegalCharacter = false;
		int multi = 9;
		for (int i = 0; i < vectorFinal.length; i++) {
			if (utilService.isNumeric(String.valueOf(vectorFinal[i]))) {
				int digit = Integer.parseInt(String.valueOf(vectorFinal[i]));
				sumNumberDigit = (sumNumberDigit + (digit * multi));
				multi--;
			} else {
				illegalCharacter = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(vectorFinal));
		sb.append(" ");
		if (illegalCharacter) {
			sb.append("ILL");
		} else {
			if (sumNumberDigit % 11 == 0) {
				sb.append("OK");
			} else {
				sb.append("ERR");
			}
		}
		return sb.toString();
	}

}
