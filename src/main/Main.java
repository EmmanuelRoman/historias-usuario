package main;

import main.service.FileService;

public class Main {

	static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		FileService fileService = new FileService();
		fileService.processFileAndWriteAccountNumbers("c://temp//test.txt", "c://temp//result_final_main.txt");
	}

}
