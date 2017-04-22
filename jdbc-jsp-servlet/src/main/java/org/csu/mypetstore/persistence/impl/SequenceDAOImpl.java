package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.DAOUtil;
import org.csu.mypetstore.persistence.SequenceDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pikachu on 2017/3/11.
 */
public class SequenceDAOImpl implements SequenceDAO {
    @Override
    public Sequence getSequence(Sequence sequence) {
        List<Sequence> list = new ArrayList<>(2);
        String sql = "SELECT * FROM sequence WHERE name = ?";
        Object[] params = new Object[]{
            sequence.getName()
        };
        DAOUtil.query(sql,params,resultSet -> {
            Sequence s = new Sequence();
            s.setName(resultSet.getString("name"));
            s.setNextId(resultSet.getInt("nextid"));
            list.add(s);
        });
        if (list.size()>0){
            return list.get(0);
        }else {
        return null;

        }
    }

    @Override
    public void updateSequence(Sequence sequence) {
        String sql = "UPDATE SEQUENCE\n" +
                "    SET NEXTID = ?\n" +
                "    WHERE NAME = ?";
        Object[] params = new Object[]{
                sequence.getNextId(),sequence.getName()
        };
        DAOUtil.update(sql,params);
    }
}
