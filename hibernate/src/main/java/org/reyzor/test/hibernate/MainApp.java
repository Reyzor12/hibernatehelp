package org.reyzor.test.hibernate;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.reyzor.test.hibernate.model.Product;

public class MainApp {

	public static void main(String[] args) {
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		
		Validator validator = validatorFactory.getValidator();
		
		Product product = new Product();
		product.setTitle("123");
		
		Set<ConstraintViolation<Product>> constrs = validator.validate(product);
		
		for(ConstraintViolation<Product> constr:constrs) {
			
			StringBuilder stringBuilder = new StringBuilder("property: ");
			
			stringBuilder.append(constr.getInvalidValue());
			stringBuilder.append(" message: ");
			stringBuilder.append(constr.getMessage());
			stringBuilder.append(" path: ");
			stringBuilder.append(constr.getPropertyPath());
			
			System.out.println(stringBuilder);
		}
		
	}

}
