package org.reyzor.test.hibernate.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product extends Model{

	private static final long serialVersionUID = -2715105481312497463L;
	
	@NotNull(message="field title is null")
	@Size(min = 4, max = 14, message="123")
	@Column(name="title")
	private String title;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@NotNull
	@Column(name="price")
	private BigDecimal price;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="product_category_id", referencedColumnName="id")
	private ProductCategory productCategory;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Product() {
		super();
	}
	
	public Product(long id) {
		super(id);
	}
	
	public String toSrting() {
		return super.getId() + " - " + title + " - " + description + " - ";
	}
	
}
