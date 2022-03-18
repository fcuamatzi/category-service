package mx.com.cuamatziinc.ventas.categoryservice.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.cuamatziinc.ventas.categoryservice.service.IServiceCategory;
import mx.com.cuamatziinc.ventas.commonscategory.entity.ProductCategory;
import mx.com.cuamatziinc.ventas.commonsservice.controller.ControllerCommon;


@RestController
public class ControllerCategory extends ControllerCommon<ProductCategory, IServiceCategory> {

	@PutMapping("/{id}")
	public ResponseEntity<?> modify(@RequestBody ProductCategory category, @PathVariable Long id) {
		Optional<ProductCategory> o = this.serviceCommon.findById(id);

		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		ProductCategory productCategoryDB = o.get();

		productCategoryDB.setName(category.getName());

		this.serviceCommon.save(productCategoryDB);

		return ResponseEntity.status(HttpStatus.CREATED).body(productCategoryDB);

	}

}
