package org.csu.mypetstore.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pikachu on 2017/3/11.
 */
public interface ResultSetManipulation {
    void manipulation(ResultSet resultSet) throws SQLException;
}
