package capstone.product.config;

import capstone.product.dto.Product;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.store.cassandra.CassandraCacheStoreFactory;
import org.apache.ignite.cache.store.cassandra.datasource.DataSource;
import org.apache.ignite.cache.store.cassandra.persistence.KeyValuePersistenceSettings;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

@SpringBootApplication
@ComponentScan("capstone.product")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Ignite igniteInstance() {

        DataSource dataSource = new DataSource();
        dataSource.setContactPoints("127.0.0.1");

        IgniteConfiguration config = new IgniteConfiguration();

        CacheConfiguration cache = new CacheConfiguration("productCache");
        cache.setIndexedTypes(String.class, Product.class);
        cache.setReadThrough(true);
        cache.setWriteThrough(true);
        cache.setSqlSchema("products");

        CassandraCacheStoreFactory factory = new CassandraCacheStoreFactory();
        factory.setDataSource(dataSource);
        KeyValuePersistenceSettings persistenceSettings = new KeyValuePersistenceSettings(new ClassPathResource("persistence.xml"));
        factory.setPersistenceSettings(persistenceSettings);

        cache.setCacheStoreFactory(factory);
        config.setCacheConfiguration(cache);
        cache.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
        cache.setStatisticsEnabled(true);

        return Ignition.start(config);
    }

}
