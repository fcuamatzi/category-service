package mx.com.cuamatziinc.ventas.categoryservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.com.cuamatziinc.ventas.categoryservice.service.IServiceCategory;
import mx.com.cuamatziinc.ventas.commonscategory.entity.ProductCategory;
import mx.com.cuamatziinc.ventas.commonsservice.controller.ControllerCommon;


@RestController
public class ControllerCategory extends ControllerCommon<ProductCategory, IServiceCategory> {
	
	@Value("${mi.variable.entorno}")
	private String miVariable;
	
	@Value("${node.name}")
	private String nodeName;

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
	
	@GetMapping("/saludar")
	public ResponseEntity<?> saludar(){
		
		return ResponseEntity.ok(miVariable);
		
	}
	
	@GetMapping("/node")
	public ResponseEntity<?> getNodeNAme(){
		
		return ResponseEntity.ok(nodeName);
		
	}

}
