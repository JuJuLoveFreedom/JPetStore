package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.LineItemDAO;
import org.csu.mypetstore.persistence.ResultSetManipulation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class LineItemImpl implements LineItemDAO {
    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        List<LineItem> list = new LinkedList<>();
        Object[] params = new Object[]{
          orderId
        };
        DAOUtil.query("SELECT * FROM lineitem WHERE orderid = ?",params,new FindList(list));
        return list;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        String sql="INSERT INTO lineitem(orderid, linenum, itemid, quantity, unitprice) VALUES (?,?,?,?,?)";
        Object[] params = new Object[]{
                lineItem.getOrderId(),lineItem.getLineNumber(),lineItem.getItemId(),lineItem.getQuantity(),lineItem.getUnitPrice()
        };
        DAOUtil.update(sql,params);
    }
    class FindList implements ResultSetManipulation{

        private List<LineItem> list;

        public FindList(List<LineItem> list) {
            this.list = list;
        }

        @Override
        public void manipulation(ResultSet resultSet) {
            try {
                LineItem item = new LineItem();
                item.setOrderId(resultSet.getInt("orderid"));
                item.setLineNumber(resultSet.getInt("linenum"));
                item.setItemId(resultSet.getString("itemid"));
                item.setQuantity(resultSet.getInt("quantity"));
                item.setUnitPrice(resultSet.getBigDecimal("unitprice"));
                list.add(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
