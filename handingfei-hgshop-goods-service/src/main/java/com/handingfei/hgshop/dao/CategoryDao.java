package com.handingfei.hgshop.dao;

import java.util.List;

import com.handingfei.hgshop.domain.Category;

public interface CategoryDao {

	List<Category> listByParentId(int parentId);

	int add(Category cat);

	int update(Category cat);

	int delete(int id);

}
