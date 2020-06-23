package com.handingfei.hgshop.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.handingfei.hgshop.dao.SpuDao;
import com.handingfei.hgshop.domain.Spu;
import com.handingfei.hgshop.domain.SpuVo;
import com.handingfei.hgshop.service.SpuService;


@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl  implements SpuService{
	
	@Autowired
	SpuDao spuDao;

	@Override
	public PageInfo<Spu> list(SpuVo spuVo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(spuVo.getPage(),spuVo.getPageSize());
		return new PageInfo<Spu>(spuDao.list(spuVo));
		
	}

	@Override
	public int add(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.add(spu);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuDao.delBatch(ids);
	}

	@Override
	public int update(Spu spu) {
		// TODO Auto-generated method stub
		return spuDao.update(spu);
	}

	@Override
	public Spu getById(int id) {
		// TODO Auto-generated method stub
		return spuDao.getById(id);
	}

}
