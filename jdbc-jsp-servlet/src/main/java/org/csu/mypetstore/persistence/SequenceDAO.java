package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Sequence;

/**
 * Created by pikachu on 2017/3/11.
 */
public interface SequenceDAO {
    Sequence getSequence(Sequence sequence);
    void updateSequence(Sequence sequence);
}
