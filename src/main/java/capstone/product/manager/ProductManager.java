package capstone.product.manager;

import capstone.product.dto.Product;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);

    private final Ignite ignite;

    @Autowired
    public ProductManager(Ignite ignite) {
        this.ignite = ignite;
    }

    public Optional<Product> getProductById(String id) {
        final IgniteCache<String, Product> cache = ignite.getOrCreateCache("productCache");
        return Optional.ofNullable(cache.get(id));
    }

    public void updatePrice(String productId, double listPrice) {
        final IgniteCache<String, Product> cache = ignite.getOrCreateCache("productCache");
        cache.invoke(productId, (mutableEntry, objects) -> {
            if (mutableEntry.exists() && mutableEntry.getValue() != null) {
                LOGGER.debug("updating product entry into the cache invoke: {},{}", productId, listPrice);
                Product old = mutableEntry.getValue();
                old.setListPrice(listPrice);
                mutableEntry.setValue(old);
            } else {
                throw new RuntimeException(String.format("Product with id %s was not found", productId));
            }
            return null;
        });
    }
}
