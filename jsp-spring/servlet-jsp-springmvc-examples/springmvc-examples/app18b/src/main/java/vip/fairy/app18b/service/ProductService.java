package vip.fairy.app18b.service;

import vip.fairy.app18b.domain.Product;

public interface ProductService {

  Product add(Product product);

  Product get(long id);
}
