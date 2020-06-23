package com.handingfei.hgshop.dao;

import java.util.List;

import com.handingfei.hgshop.domain.Spu;
import com.handingfei.hgshop.domain.SpuVo;
public interface SpuDao {

	int add(Spu spu);

	int delBatch(int[] ids);

	int update(Spu spu);

	Spu getById(int id);

	List<Spu> list(SpuVo spuVo);

}
