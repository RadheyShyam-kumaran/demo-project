package demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import demo.model.Product;

@Service
public class ProductService {

    private Map<Long, Product> productStore = new HashMap<>();
    private Long counter = 1L;

    public ProductService() {
        addProduct(new Product(null, "Laptop", "High performance laptop", 1000, 10));//CHANGED
        addProduct(new Product(null, "Phone", "Latest smartphone", 699.99, 25));
        addProduct(new Product(null, "Headphones", "Noise cancelling headphones", 199.99, 50));
        addProduct(new Product(null, "Tablet", "10 inch display tablet", 499.99, 16));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productStore.values()); // used to get all values 
    }

    public Product getProductById(Long id) {
        return productStore.get(id);         // used to fecth data by id
    }

    public Product addProduct(Product product) {
        product.setId(counter++);
        productStore.put(product.getId(), product);
        return product;								// adding the product in object so it will store it until the project ir redoployed 
    }

    public Product updateProduct(Long id, Product product) {
        if (!productStore.containsKey(id)) return null;  //these changes will be there untill redoplyed
        product.setId(id);
        productStore.put(id, product);
        return product;
    }

    public boolean deleteProduct(Long id) {
        if (!productStore.containsKey(id)) return false;
        productStore.remove(id);				//delete the product 
        return true;
    }
}
