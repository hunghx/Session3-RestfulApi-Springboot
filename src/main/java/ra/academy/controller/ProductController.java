package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ra.academy.entity.Product;
import ra.academy.repository.IProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductController {
    private final IProductRepository productRepository;
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productRepository.findAll(),HttpStatus.OK);
    }
}
