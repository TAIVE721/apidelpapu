package com.arquebuscorp.api.apidelpapu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arquebuscorp.api.apidelpapu.Entities.Producto;
import com.arquebuscorp.api.apidelpapu.Repositories.ProductRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Producto> getProductos() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto) {
        return productRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto producto2 = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto2.setNombre(producto.getNombre());
        producto2.setPrecio(producto.getPrecio());

        return productRepository.save(producto2);
    }

    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productRepository.delete(producto);
        return "Producto eliminado";
    }
}
