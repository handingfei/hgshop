package com.handingfei.hgshop.service;

import com.github.pagehelper.PageInfo;
import com.handingfei.hgshop.domain.Spu;
import com.handingfei.hgshop.domain.SpuVo;

public interface SpuService {
	
	/**
	 * 查询
	 * @param spuVo
	 * @return
	 */
	PageInfo<Spu> list(SpuVo spuVo);
	
	int add(Spu spu);
	
	int deleteBatch(int[] ids);
	
	int update(Spu spu);
	
	Spu getById(int id);
	
	
	
	

}
