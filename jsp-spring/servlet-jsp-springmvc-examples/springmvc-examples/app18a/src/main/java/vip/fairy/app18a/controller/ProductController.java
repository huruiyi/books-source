package vip.fairy.app18a.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.fairy.app18a.domain.Product;
import vip.fairy.app18a.form.ProductForm;

@Controller
public class ProductController {

  private static final Log logger = LogFactory.getLog(ProductController.class);

  @RequestMapping(value = "/product_input")
  public String inputProduct() {
    logger.info("inputProduct called");
    return "ProductForm";
  }

  @RequestMapping(value = "/product_save")
  public String saveProduct(ProductForm productForm, Model model) {
    logger.info("saveProduct called");
    Product product = new Product();
    product.setName(productForm.getName());
    product.setDescription(productForm.getDescription());
    product.setPrice(Float.parseFloat(productForm.getPrice()));
    model.addAttribute("product", product);
    return "ProductDetails";
  }
}
