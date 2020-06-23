package com.handingfei.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.handingfei.hgshop.domain.Sku;
import com.handingfei.hgshop.domain.SkuVo;

public interface SkuService {
	
	int add(Sku sku);
	
	int delBatch(int[] ids);
	
	int update(Sku sku);
	
	PageInfo<Sku> list(SkuVo skuVo);
	
	Sku getById(int id);

	List<Sku> listBySpuId(int spuId);

}
