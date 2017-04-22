package org.csu.mypetstore.persistence.impl.test;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.service.AccountService;
import org.csu.mypetstore.service.CatalogService;
import org.csu.mypetstore.service.OrderService;

import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class OrderDAOImplTest {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        AccountService accountService = new AccountService();
        CatalogService catalogService = new CatalogService();
        Order order = new Order();
        Cart cart = new Cart();

        List<Product> list= catalogService.searchProductList("a");
        List<Item> items =  catalogService.getItemListByProduct(list.get(0).getProductId());
        for (Item i :
                items) {
            cart.addItem(i, true);
        }
        Account account = accountService.getAccount("pikachu");
        order.initOrder(account,cart);
        orderService.insertOrder(order);
    }
}
