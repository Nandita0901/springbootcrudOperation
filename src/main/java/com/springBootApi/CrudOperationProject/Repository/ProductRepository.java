package com.springBootApi.CrudOperationProject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootApi.CrudOperationProject.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
