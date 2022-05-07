package Factory;

import Errors.FileNotLoaded;
import Errors.OperationNotSupported;
import Errors.UnableToCreateOperation;
import Operations.Operation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OperationFactory {
    private Properties config = new Properties();

    private static volatile OperationFactory instance;

    private OperationFactory() throws FileNotLoaded {
        try{
            config.load(OperationFactory.class.getResourceAsStream("config.properties"));
        } catch (Exception e) {
            throw new FileNotLoaded("Config");
        }

    }

    public static OperationFactory getInstance () throws FileNotLoaded {
        if (instance == null) {
            synchronized (OperationFactory.class) {
                if (instance == null) {
                    instance = new OperationFactory();
                }
            }
        }
        return instance;
    }
    public Operation getOperation (String operationName) throws OperationNotSupported, UnableToCreateOperation {
        if(!config.containsKey(operationName)) {
            throw new OperationNotSupported("Operation '" + operationName + "' not supported");
        }
        try {
            var cls = Class.forName(config.getProperty(operationName));
            var constructor = cls.getDeclaredConstructor();
            return (Operation)constructor.newInstance();
        } catch (Exception ex) {
            throw new UnableToCreateOperation("Unable to create operation '" + operationName + "'", ex);
        }

    }
}
