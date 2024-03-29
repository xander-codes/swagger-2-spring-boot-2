package com.tutorial.swaggerdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SwaggerAPIController {
    List<String> productsList = new ArrayList<>();

    @GetMapping(value = "/products")
    public List<String> getProducts() {
        return productsList;
    }

    @PostMapping(value = "/products")
    public String createProduct(@RequestBody String product) {
        productsList.add(product);
        return "Product is saved successfully";
    }

    @PatchMapping("/products/{product}")
    public String modifyProduct(@PathVariable String product, @RequestBody String newProduct){
        productsList.remove(product);
        productsList.add(newProduct);
        return "Product was modified";
    }

    @DeleteMapping("/products/{product}")
    public void deleteProduct(@PathVariable String product) {
        productsList.remove(product);
    }
}
