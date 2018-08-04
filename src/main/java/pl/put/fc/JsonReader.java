package pl.put.fc;

import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.put.fc.loader.boundary.DataLoader;

public class JsonReader {
    
    public void read(String fileName, DataLoader dataLoader) throws JsonProcessingException, IOException {
        long startTime = System.currentTimeMillis();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        URL fileURL = getClass().getClassLoader().getResource(fileName);
        JsonParser parser = objectMapper.getFactory().createParser(fileURL);
        int i = 1;
        dataLoader.beginTransaction();
        while (parser.nextToken() != null) {
            JsonNode node = objectMapper.readTree(parser);
            dataLoader.loadEntitiesToDb(node);
            if ((i++ % 1) == 1000) {
                dataLoader.endTransaction();
                dataLoader.beginTransaction();
            }
        }
        dataLoader.endTransaction();
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
