package mx.com.cuamatziinc.ventas.categoryservice.repository;

import org.springframework.data.repository.CrudRepository;

import mx.com.cuamatziinc.ventas.commonscategory.entity.ProductCategory;

public interface IRepositoryCategory extends CrudRepository<ProductCategory, Long> {

}
