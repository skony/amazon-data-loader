package pl.put.fc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import pl.put.fc.loader.control.PostgresMetaDataLoader;
import pl.put.fc.loader.control.PostgresReviewDataLoader;

public class Main {
    
    private static final List<DataFile> DATA_FILES = Arrays.asList(DataFile.AMAZON_INSTANT_VIDEO);
    
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
            sessionFactory.close();
        }
    }
    
    private static void load(Session session, MetaFileFixer metaFileFixer, DataFile file) throws IOException, JsonProcessingException {
        if (!metaFileFixer.isAlreadyFixed(file.getFixedMetaFile())) {
            metaFileFixer.fix(file.getOriginalMetaFile());
        }
        JsonToDbLoader jsonReader = new JsonToDbLoader();
        jsonReader.load(file.getFixedMetaFile(), new PostgresMetaDataLoader(session));
        jsonReader.load(file.getReviewFile(), new PostgresReviewDataLoader(session));
    }
}
