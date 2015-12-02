package biz.uasm.auth.demo.log4j;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ClassDemoLog4jSimple {
    private static final Logger logger = Logger.getLogger(ClassDemoLog4jSimple.class.getName());

    public ClassDemoLog4jSimple() {
        super();
    }

    public static void main(String[] args) {
        ClassDemoLog4jSimple classDemoLog4jSimple = new ClassDemoLog4jSimple();
        //String propertiesFile = "/logging.properties";
        String propertiesFile = "/loggingV2.properties";
        //
        try {
            if (ClassDemoLog4jSimple.class.getResourceAsStream(propertiesFile) != null) {
                LogManager.getLogManager().readConfiguration(ClassDemoLog4jSimple.class.getResourceAsStream(propertiesFile));
            } else {
                logger.severe("Could not setup logger configuration - properties file not found");
            }
        } catch (IOException e) {
            //logger.severe("Could not setup logger configuration: " + e.toString());
            logger.severe("Could not setup logger configuration.");
        }
        //
        logger.info("Hello World!");
        logger.fine("Some text - normal work");
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Some text - normal work");
        }
        logger.entering(ClassDemoLog4jSimple.class.getName(), "Try to do");
        logger.config("Change config");
        logger.info("Some action");
        logger.log(Level.SEVERE, "Error doing XYZ {0} {1}", new Object[] { "1", "2" });
        logger.logp(Level.SEVERE, "class", "method", "Some action");
        logger.logrb(Level.SEVERE, "ClassDemoLog4jSimple", "main", "/resources.myresources", "key1");
        logger.exiting(ClassDemoLog4jSimple.class.getName(), "End to try to do");
    }
}
