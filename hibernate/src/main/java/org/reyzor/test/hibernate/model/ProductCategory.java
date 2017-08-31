package org.reyzor.test.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory extends Model{

	private static final long serialVersionUID = -5793714159649426322L;

	private String title;
	
	private ProductCategory parentProductCategory;
	
	public ProductCategory() {
		super();
	}
	
	public ProductCategory(long id) {
		super(id);
	}
	
}
