package com.springBootApi.CrudOperationProject.entity;


import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

	public void setCategory1(Category category2) {
		// TODO Auto-generated method stub
		
	}

	public Object getName1() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(Object name2) {
		// TODO Auto-generated method stub
		
	}

	public Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCategory(Category category2) {
		// TODO Auto-generated method stub
		
	}

	

    // Getters and Setters
}
