package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.OrderDAO;
import org.csu.mypetstore.persistence.ResultSetManipulation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public List<Order> getOrdersByUsername(String username) {
        List<Order> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM orders WHERE userid = ?", new Object[]{username}, new FindList(list));
        return list;
    }

    @Override
    public Order getOrder(int orderId) {
        List<Order> list = new LinkedList<>();
        DAOUtil.query("SELECT * FROM orders WHERE orderId = ?", new Object[]{orderId}, new FindList(list));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;

        }
    }

    @Override
    public void insertOrder(Order order) {
        String sql = "INSERT INTO orders(orderid, userid, orderdate, shipaddr1, shipaddr2, shipcity, shipstate, shipzip, shipcountry, " +
                "billaddr1, billaddr2, billcity, billstate, billzip, billcountry, courier, totalprice, " +
                "billtofirstname, billtolastname, shiptofirstname, shiptolastname, creditcard, exprdate, cardtype, locale) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] params = new Object[]{
          order.getOrderId(),order.getUsername(),order.getOrderDate(),order.getShipAddress1(),order.getShipAddress2(),order.getShipCity(),order.getShipState(),order.getShipZip(),order.getShipCountry(),
                order.getBillAddress1(),order.getBillAddress2(),order.getBillCity(),order.getBillState(),order.getBillZip(),order.getBillCountry(),order.getCourier(),order.getTotalPrice(),
                order.getBillToFirstName(),order.getBillToLastName(),order.getShipToFirstName(),order.getShipToLastName(),order.getCreditCard(),order.getExpiryDate(),order.getCardType(),order.getLocale()
        };
        DAOUtil.update(sql,params);
    }

    @Override
    public void insertOrderStatus(Order order) {
        DAOUtil.update("UPDATE orders SET shipstate = ? ,billstate = ? WHERE orderid = ?",new Object[]{order.getShipState(),order.getBillState(),order.getOrderId()});
    }

    class FindList implements ResultSetManipulation {
        private List<Order> list;

        public FindList(List<Order> list) {
            this.list = list;
        }

        @Override
        public void manipulation(ResultSet resultSet) {
            try {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderid"));
                order.setUsername(resultSet.getString("userid"));
                order.setOrderDate(resultSet.getDate("orderdate"));
                order.setShipAddress1(resultSet.getString("shipaddr1"));
                order.setShipAddress2(resultSet.getString("shipaddr2"));
                order.setShipCity(resultSet.getString("shipcity"));
                order.setShipState(resultSet.getString("shipstate"));
                order.setShipZip(resultSet.getString("shipzip"));
                order.setShipCountry(resultSet.getString("shipcountry"));
                order.setBillAddress1(resultSet.getString("billaddr1"));
                order.setBillAddress2(resultSet.getString("billaddr2"));
                order.setBillCity(resultSet.getString("billcity"));
                order.setBillState(resultSet.getString("billstate"));
                order.setBillZip(resultSet.getString("billzip"));
                order.setBillCountry(resultSet.getString("billcountry"));
                order.setCourier(resultSet.getString("courier"));
                order.setTotalPrice(resultSet.getBigDecimal("totalprice"));
                order.setBillToFirstName(resultSet.getString("billtofirstname"));
                order.setBillToLastName(resultSet.getString("billtolastname"));
                order.setShipToFirstName(resultSet.getString("shiptofirstname"));
                order.setShipToLastName(resultSet.getString("shiptolastname"));
                order.setCreditCard(resultSet.getString("creditcard"));
                order.setExpiryDate(resultSet.getString("exprdate"));
                order.setCardType(resultSet.getString("cardtype"));
                order.setLocale(resultSet.getString("locale"));
                list.add(order);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
