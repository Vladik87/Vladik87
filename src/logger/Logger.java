package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;

public class Logger {

    // TODO add log level from properties
    private static Logger instance;
    private final String LOG_FILE_PATH = "./resources/log.txt";

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void info(final Class clazz, final String message) {
        log(clazz, LogLevel.INFO, message);
    }

    public void debug(final Class clazz, final String message) {
        log(clazz, LogLevel.DEBUG, message);
    }

    public void error(final Class clazz, final String message) {
        log(clazz, LogLevel.ERROR, message);
    }

    // TODO try add file limitation up to 100 lines and create new log file
    public void log(final Class clazz, final LogLevel logLevel, final String message) {
        try (FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter)) {

            // TODO try create MessageBuilder
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(logLevel).append("] ");
            sb.append("[").append(clazz.getName()).append("] ");
            sb.append("[").append(Instant.now().toString()).append("] ");
            sb.append(message);

            printWriter.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
