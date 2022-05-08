package Factory;

import Errors.FileNotLoaded;
import Errors.OperationNotSupported;
import Errors.UnableToCreateOperation;
import Operations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class OperationFactory {
    private static final Logger logger = LogManager.getLogger(OperationFactory.class);

    private Properties config = new Properties();

    private static volatile OperationFactory instance;

    private OperationFactory() throws FileNotLoaded {
        try{
            config.load(OperationFactory.class.getResourceAsStream("config.properties"));
            logger.info("Operation factory initialized successfully");
        } catch (Exception e) {
            logger.error("Config file not loaded");
            throw new FileNotLoaded("Config");
        }

    }

    public static OperationFactory getInstance () throws FileNotLoaded {
        if (instance == null) {
            synchronized (OperationFactory.class) {
                if (instance == null) {
                    instance = new OperationFactory();
                    logger.info("Operation factory instance created");
                }
            }
        }
        return instance;
    }
    public Operation getOperation (String operationName) throws OperationNotSupported, UnableToCreateOperation {
        if(!config.containsKey(operationName)) {
            logger.error("Operation '" + operationName + "' not supported");
            throw new OperationNotSupported("Operation '" + operationName + "' not supported");
        }
        try {
            var cls = Class.forName(config.getProperty(operationName));
            var constructor = cls.getDeclaredConstructor();
            return (Operation)constructor.newInstance();
        } catch (Exception ex) {
            logger.error("Cannot create operation "+operationName);
            throw new UnableToCreateOperation("Unable to create operation '" + operationName + "'", ex);
        }

    }
}
