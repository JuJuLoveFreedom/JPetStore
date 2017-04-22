package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Category;

import java.util.List;

/**
 * Created by pikachu on 2017/3/10.
 */
public interface CategoryDAO {
    List<Category> getCategoryList();
    Category getCategory(String categoryId);
    // 找到所有的categoryid
    List<String> findAllCategoriesId();
}
