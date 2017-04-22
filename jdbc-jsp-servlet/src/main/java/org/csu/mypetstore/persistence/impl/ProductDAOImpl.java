package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.ProductDAO;
import org.csu.mypetstore.persistence.ResultSetManipulation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM product WHERE category = ?",new Object[]{categoryId},new FindListImpl(list));
        return list;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = new Product();
        DAOUtil.query("SELECT * FROM product WHERE productid = ?",new Object[]{productId}, resultSet -> {
            try {
                product.setCategoryId(resultSet.getString("category"));
                product.setDescription(resultSet.getString("descn"));
                product.setName(resultSet.getString("name"));
                product.setProductId(resultSet.getString("productid"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> list = new LinkedList<>();
        String sql = "select PRODUCTID,NAME,DESCN,CATEGORY  from PRODUCT WHERE lower(name) like '%"+keywords+"%'";
        Connection connection = DBUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            FindListImpl findList = new FindListImpl(list);
            while (resultSet.next()){
                findList.manipulation(resultSet);
            }
            resultSet.close();
            statement.close();
            DBUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        DAOUtil.query(sql,null,new FindListImpl(list));
        return list;
    }
    class FindListImpl implements ResultSetManipulation{
        private List<Product> list = null;

        public FindListImpl(List<Product> list) {
            this.list = list;
        }

        @Override
        public void manipulation(ResultSet resultSet) {
            try {
                Product product = new Product();
                product.setCategoryId(resultSet.getString("category"));
                product.setDescription(resultSet.getString("descn"));
                product.setName(resultSet.getString("name"));
                product.setProductId(resultSet.getString("productid"));
                list.add(product);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
