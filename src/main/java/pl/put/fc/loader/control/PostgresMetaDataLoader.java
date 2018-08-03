package pl.put.fc.loader.control;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.fasterxml.jackson.databind.JsonNode;
import pl.put.fc.datamodel.MetaDataRow;
import pl.put.fc.loader.boundary.AbstractMetaDataLoader;
import pl.put.fc.model.Product;

public class PostgresMetaDataLoader extends AbstractMetaDataLoader {
    
    private Session session;
    private Transaction transaction;
    
    public PostgresMetaDataLoader(Session session) {
        this.session = session;
    }
    
    public void loadToDb(JsonNode node) {
        MetaDataRow dataRow = getRow(node);
        Product product = new Product();
        product.setId(dataRow.getProductId());
        product.setTitle(dataRow.getTitle());
        product.setPrice(dataRow.getPrice());
        product.setBrand(dataRow.getBrand());
        
        session.persist(product);
    }
    
    @Override
    public void finishConnection() {
        session.close();
    }
    
    @Override
    public void beginTransaction() {
        transaction = session.beginTransaction();
    }
    
    @Override
    public void endTransaction() {
        transaction.commit();
    }
}
