package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.LineItem;

import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public interface LineItemDAO {

    List<LineItem> getLineItemsByOrderId(int orderId);

    void insertLineItem(LineItem lineItem);

}
