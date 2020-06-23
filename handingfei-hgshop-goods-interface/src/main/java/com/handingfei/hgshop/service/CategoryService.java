package com.handingfei.hgshop.service;

import java.util.List;

import com.handingfei.hgshop.domain.Category;

public interface CategoryService {
	
	// 查询列表
	List<Category> list(int parentId);
	
	// 添加
	int add(Category cat);
	
	
	// 修改
	int update(Category cat);
	
	// 删除
	int delete(int id);
	

}
