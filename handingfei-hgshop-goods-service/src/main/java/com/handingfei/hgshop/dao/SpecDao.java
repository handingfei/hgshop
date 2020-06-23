package com.handingfei.hgshop.dao;

import java.util.List;

import com.handingfei.hgshop.domain.Spec;
import com.handingfei.hgshop.domain.SpecOption;

public interface SpecDao {

	int deleteSpecOptions(int ...ids);

	int addSpec(Spec spec);

	int addSpecOption(SpecOption specOption);

	int update(Spec spec);

	Spec getById(int id);

	List<Spec> list(String name);

	int deleteSpec(int[] ids);

	List<Spec> listNames();

}
