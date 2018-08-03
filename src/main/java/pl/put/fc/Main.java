package pl.put.fc;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import pl.put.fc.loader.control.PostgresMetaDataLoader;

public class Main {
    
    public static void main(String[] args) throws JsonProcessingException, IOException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            // MetaFileFixer metaFileFixer = new MetaFileFixer();
            // metaFileFixer.fix("meta_Musical_Instruments.json");
            JsonReader jsonReader = new JsonReader();
            jsonReader.read("meta_Musical_Instruments_fixed.json", new PostgresMetaDataLoader(session));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
