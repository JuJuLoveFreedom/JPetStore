package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.impl.CategoryDAOImpl;
import org.csu.mypetstore.persistence.impl.ItemDAOImpl;
import org.csu.mypetstore.persistence.impl.ProductDAOImpl;

import java.util.List;

//@Service
public class CatalogService {

    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private ProductDAO productDAO = new ProductDAOImpl();
    private ItemDAO itemDAO = new ItemDAOImpl();

  public List<Category> getCategoryList() {
//    return categoryMapper.getCategoryList();

    return categoryDAO.getCategoryList();
  }

  public Category getCategory(String categoryId) {
//    return categoryMapper.getCategory(categoryId);
    return categoryDAO.getCategory(categoryId);
  }

  public Product getProduct(String productId) {
//    return productMapper.getProduct(productId);
    return productDAO.getProduct(productId);
  }

  public List<Product> getProductListByCategory(String categoryId) {
//    return productMapper.getProductListByCategory(categoryId);
    return productDAO.getProductListByCategory(categoryId);
  }

  // TODO enable using more than one keyword
  public List<Product> searchProductList(String keyword) {
//    return productMapper.searchProductList("%" + keyword.toLowerCase() + "%");
    return productDAO.searchProductList(keyword);
  }

  public List<Item> getItemListByProduct(String productId) {
//    return itemMapper.getItemListByProduct(productId);
    return itemDAO.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {
//    return itemMapper.getItem(itemId);
    return itemDAO.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
//    return itemMapper.getInventoryQuantity(itemId) > 0;
    return itemDAO.getInventoryQuantity(itemId)>0;
  }
  public List<String> getAllCategoriesId(){
    return categoryDAO.findAllCategoriesId();
  }
}