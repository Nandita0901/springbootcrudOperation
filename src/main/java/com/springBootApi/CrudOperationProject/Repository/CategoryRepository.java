package com.springBootApi.CrudOperationProject.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBootApi.CrudOperationProject.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
