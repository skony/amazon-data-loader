package pl.put.fc.loader.boundary;

import com.fasterxml.jackson.databind.JsonNode;

public interface DataLoader {
    
    void loadToDb(JsonNode node);
    
    void finishConnection();
    
    void beginTransaction();
    
    void endTransaction();
}
