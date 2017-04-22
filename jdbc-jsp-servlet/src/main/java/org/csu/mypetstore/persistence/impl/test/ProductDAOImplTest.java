package org.csu.mypetstore.persistence.impl.test;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.impl.ProductDAOImpl;

import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class ProductDAOImplTest {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> list = productDAO.searchProductList("a");
    }
}
