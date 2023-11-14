package br.edu.infnet.appvenda.models.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLoggerService {
	
	private static final String FILE_NAME = "files/log.txt";

    private static final Logger logger = Logger.getLogger(FileLoggerService.class.getName());

    private static void initializeLogger() throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		String fileName = FILE_NAME + timeStamp;

        FileHandler fileHandler = new FileHandler(fileName);

        fileHandler.setFormatter(new SimpleFormatter());

        logger.addHandler(fileHandler);

    }

    public static void logException(String message) throws IOException {

        initializeLogger();

        logger.log(Level.SEVERE, message);

    }
}
