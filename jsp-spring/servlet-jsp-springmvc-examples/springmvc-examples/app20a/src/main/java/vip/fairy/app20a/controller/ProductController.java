package vip.fairy.app20a.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vip.fairy.app20a.domain.Product;

@org.springframework.stereotype.Controller

public class ProductController {

  private static final Log logger = LogFactory.getLog(ProductController.class);

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    logger.info("initBinder in ProductController");
    binder.initDirectFieldAccess();
    binder.setDisallowedFields("id");
    binder.setRequiredFields("name", "description", "price");
  }

  @RequestMapping(value = "/product_input")
  public String inputProduct(Model model) {
    model.addAttribute("product", new Product());
    logger.info("inputProduct called 2c");
    return "ProductForm";
  }

  @RequestMapping(value = "/product_save")
  public String saveProduct(@ModelAttribute Product product, BindingResult bindingResult, Model model) {
    logger.info("saveProduct called 2bb");

    if (bindingResult.hasErrors()) {
      logger.info("has errors");
      FieldError fieldError = bindingResult.getFieldError();
      logger.info("Code:" + fieldError.getCode() + ", field:" + fieldError.getField());
      return "ProductForm";
    }

    model.addAttribute("product", product);
    return "ProductDetails";
  }


}
