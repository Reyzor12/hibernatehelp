package org.reyzor.test.hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class ProductCategory extends Model{

	private static final long serialVersionUID = -5793714159649426322L;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="parent_product_category", referencedColumnName="id")
	private ProductCategory parentProductCategory;
	
	@OneToMany(mappedBy="productCategory")
	private Set<Product> products = new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ProductCategory getParentProductCategory() {
		return parentProductCategory;
	}

	public void setParentProductCategory(ProductCategory parentProductCategory) {
		this.parentProductCategory = parentProductCategory;
	}

	public ProductCategory() {
		super();
	}
	
	public ProductCategory(long id) {
		super(id);
	}
	
}
