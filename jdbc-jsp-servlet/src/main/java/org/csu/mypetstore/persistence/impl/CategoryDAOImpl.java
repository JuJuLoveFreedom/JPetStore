package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.persistence.CategoryDAO;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = new LinkedList<>();
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getString("catid"));
                category.setDescription(resultSet.getString("descn"));
                category.setName(resultSet.getString("name"));
                list.add(category);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category getCategory(String categoryId) {
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM category WHERE catid = ?");
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getString("catid"));
                category.setDescription(resultSet.getString("descn"));
                category.setName(resultSet.getString("name"));
                return category;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> findAllCategoriesId() {
        List<String> list = new LinkedList<>();
        DAOUtil.query("SELECT catid FROM category",null,resultSet -> {
           list.add(resultSet.getString("catid"));
        });
        return list;
    }
}
