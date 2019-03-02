package capstone.product.controller;

import capstone.product.dto.Product;
import capstone.product.manager.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class ProductController {

    private final ProductManager manger;

    @Autowired
    public ProductController(ProductManager manger) {
        this.manger = manger;
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET, produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Product> getById(
            @PathVariable(value = "productId", required = true) String productId
    ) {
        Optional<Product> result = manger.getProductById(productId);
        return result.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.PUT, produces = APPLICATION_JSON_UTF8_VALUE)
    public void update(
            @PathVariable(value = "productId", required = true) String productId,
            @RequestParam(name = "price", required = true) double price
    ) {
        manger.updatePrice(productId, price);
    }

}