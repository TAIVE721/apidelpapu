package com.arquebuscorp.api.apidelpapu.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arquebuscorp.api.apidelpapu.Entities.Producto;

public interface ProductRepository extends JpaRepository<Producto, Long> {

}
