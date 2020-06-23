package com.handingfei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.handingfei.hgshop.domain.Category;
import com.handingfei.hgshop.domain.Sku;
import com.handingfei.hgshop.domain.Spu;
import com.handingfei.hgshop.domain.SpuVo;
import com.handingfei.hgshop.service.CategoryService;
import com.handingfei.hgshop.service.SkuService;
import com.handingfei.hgshop.service.SpuService;

@Controller
public class IndexController {
	
	/**
	 * 商品
	 */
	@Reference
	SpuService spuService;
	
	
	@Reference
	SkuService skuService;
	
	
	/**
	 * 分类
	 */
	@Reference
	CategoryService catService;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping({"/","index","main"})
	public String index(HttpServletRequest request,SpuVo spuVo) {
		
		
		PageInfo<Spu> pageInfo = spuService.list(spuVo);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		
		return "index";
	}
	
	@RequestMapping("getTree")
	@ResponseBody
	public List<Category> getTree(){
		return catService.list(0);
	}
	
	@RequestMapping("showdetail")
	public String showDetail(HttpServletRequest request,int  spuId) {
		// 获取spu
		Spu spu = spuService.getById(spuId);
		//获取sku
		List<Sku> skuList =  skuService.listBySpuId(spuId);
		request.setAttribute("spu", spu);
		request.setAttribute("skuList", skuList);
		
		return "detail";
		
		
	}
	
}
