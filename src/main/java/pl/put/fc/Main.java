package pl.put.fc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import pl.put.fc.loader.control.PostgresMetaDataLoader;

public class Main {
    
    private static final List<DataFile> DATA_FILES = Arrays.asList(DataFile.MUSICAL_INSTRUMENTS);
    
    public static void main(String[] args) throws JsonProcessingException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        MetaFileFixer metaFileFixer = new MetaFileFixer();
        try {
            DATA_FILES.forEach(file -> {
                try {
                    load(session, metaFileFixer, file);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    private static void load(Session session, MetaFileFixer metaFileFixer, DataFile file) throws IOException, JsonProcessingException {
        if (!metaFileFixer.isAlreadyFixed(file.getFixedMetaFile())) {
            metaFileFixer.fix(file.getOriginalMetaFile());
        }
        JsonReader jsonReader = new JsonReader();
        jsonReader.read(file.getFixedMetaFile(), new PostgresMetaDataLoader(session));
    }
}
