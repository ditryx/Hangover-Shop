package com.ditryx.hangover.controllers;

import com.ditryx.hangover.DAO.ProductService;
import com.ditryx.hangover.DTO.output.ProductDTO;
import com.ditryx.hangover.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable long id){
        Product product = this.productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductList(){
        return new ResponseEntity<>(this.productService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){

        Product product = productDTO.toEntity();
        this.productService.save(product);

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "type/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductByType(@PathVariable String type){
        Product product = this.productService.findByType(type);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Product> getProducts(@RequestParam(name="name", required=false, defaultValue="World") String name,
//                                     Model model
//    ) {
//        model.addAttribute("name", name);
//        return null;
//    }
//
//    @GetMapping("{id}")
//    public Product getProduct(@RequestParam(name="id") Model model){
//        return null;
//    }

}
