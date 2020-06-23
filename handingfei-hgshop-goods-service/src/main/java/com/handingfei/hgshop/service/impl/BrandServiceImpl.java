package com.handingfei.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.handingfei.hgshop.dao.BrandDao;
import com.handingfei.hgshop.domain.Brand;
import com.handingfei.hgshop.service.BrandService;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	BrandDao brandDao;

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return brandDao.list();
	}

}
