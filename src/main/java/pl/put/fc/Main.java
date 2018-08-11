package pl.put.fc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import pl.put.fc.loader.control.mongo.MongoDataLoadInvoker;
import pl.put.fc.loader.control.orient.OrientDataLoadInvoker;
import pl.put.fc.loader.control.postgres.PostgresDataLoadInvoker;

public class Main {
    
    private static final List<DataFile> DATA_FILES = Arrays.asList(DataFile.MUSICAL_INSTRUMENTS);
    private static PostgresDataLoadInvoker postgresDataLoadInvoker = new PostgresDataLoadInvoker();
    private static MongoDataLoadInvoker mongoDataLoadInvoker = new MongoDataLoadInvoker();
    private static OrientDataLoadInvoker orientDataLoadInvoker = new OrientDataLoadInvoker();
    
    public static void main(String[] args) throws JsonProcessingException, IOException {
        // postgresDataLoadInvoker.init();
        // mongoDataLoadInvoker.init();
        orientDataLoadInvoker.init();
        MetaFileFixer metaFileFixer = new MetaFileFixer();
        try {
            DATA_FILES.forEach(file -> proceedFile(metaFileFixer, file));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // postgresDataLoadInvoker.close();
            orientDataLoadInvoker.close();
        }
    }
    
    private static void proceedFile(MetaFileFixer metaFileFixer, DataFile file) {
        try {
            if (!metaFileFixer.isAlreadyFixed(file.getFixedMetaFile())) {
                metaFileFixer.fix(file.getOriginalMetaFile());
            }
            // postgresDataLoadInvoker.invoke(file);
            // mongoDataLoadInvoker.invoke(file);
            orientDataLoadInvoker.invoke(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    
}
