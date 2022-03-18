package mx.com.cuamatziinc.ventas.categoryservice.service.imp;

import org.springframework.stereotype.Service;

import mx.com.cuamatziinc.ventas.categoryservice.repository.IRepositoryCategory;
import mx.com.cuamatziinc.ventas.categoryservice.service.IServiceCategory;
import mx.com.cuamatziinc.ventas.commonscategory.entity.ProductCategory;
import mx.com.cuamatziinc.ventas.commonsservice.service.imp.ServiceCommon;

@Service
public class ServiceCategory extends ServiceCommon<ProductCategory, IRepositoryCategory> implements IServiceCategory {

}
