package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.ItemDAO;
import org.csu.mypetstore.persistence.ResultSetManipulation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by pikachu on 2017/3/10.
 */
public class ItemDAOImpl implements ItemDAO {
    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {

    }

    @Override
    public int getInventoryQuantity(String itemId) {
        return 0;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND I.PRODUCTID = ?",new Object[]{productId},new FindList(list));
        return list;
    }

    @Override
    public Item getItem(String itemId) {
        List<Item> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM ITEM I, PRODUCT P WHERE P.PRODUCTID = I.PRODUCTID AND itemid = ?",new Object[]{itemId},new FindList(list));
        if (list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }
    class FindList implements ResultSetManipulation{
        List<Item> list = null;

        public FindList(List<Item> list) {
            this.list = list;
        }

        @Override
        public void manipulation(ResultSet resultSet) {
            try {
                Item item = new Item();
                item.setItemId(resultSet.getString("itemid"));
                item.setProductId(resultSet.getString("I.productid"));
                item.setListPrice(resultSet.getBigDecimal("listprice"));
                item.setUnitCost(resultSet.getBigDecimal("unitcost"));
                item.setSupplierId(resultSet.getInt("supplier"));
                item.setStatus(resultSet.getString("status"));
                item.setAttribute1(resultSet.getString("attr1"));
                item.setAttribute2(resultSet.getString("attr2"));
                item.setAttribute3(resultSet.getString("attr3"));
                item.setAttribute4(resultSet.getString("attr4"));
                item.setAttribute5(resultSet.getString("attr5"));

                Product product = new Product();
                product.setCategoryId(resultSet.getString("category"));
                product.setDescription(resultSet.getString("descn"));
                product.setName(resultSet.getString("name"));
                product.setProductId(resultSet.getString("P.productid"));
                item.setProduct(product);

                list.add(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}