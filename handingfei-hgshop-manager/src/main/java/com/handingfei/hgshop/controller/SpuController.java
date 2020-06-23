package com.handingfei.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.handingfei.hgshop.domain.Brand;
import com.handingfei.hgshop.domain.Spu;
import com.handingfei.hgshop.domain.SpuVo;
import com.handingfei.hgshop.service.BrandService;
import com.handingfei.hgshop.service.SpuService;

@Controller
@RequestMapping("spu")
public class SpuController {
	
	
	@Autowired
	FileUpload fileUpload;
	
	@Reference(timeout = 5000)
	SpuService spuService;
	
	@Reference
	BrandService brandService;
	
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,SpuVo spuVo) {
		
		PageInfo<Spu> pageInfo = spuService.list(spuVo);
		//获取品牌
		List<Brand> brands = brandService.list();
		
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		request.setAttribute("brands", brands);
		
		return "spu/list";
	}
	
	@RequestMapping("toadd")
	public String toadd(HttpServletRequest request) {
		
		//获取品牌
		List<Brand> brands = brandService.list();
		request.setAttribute("brands", brands);
		
		return "spu/add";
		
	}
	
	@RequestMapping("add")
	@ResponseBody
	public boolean add(HttpServletRequest request,Spu spu,MultipartFile myFile) {
		//上传图片
		String filePath = fileUpload.uploadd(myFile);
		spu.setSmallPic(filePath);
		int add = spuService.add(spu);
		
		return add>0;
		
	}
	
	
	/**
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("toupdate")
	public String toupdate(HttpServletRequest request,int id) {
		
		//获取品牌
		List<Brand> brands = brandService.list();
		request.setAttribute("brands", brands);
		
		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);
		
		
		return "spu/update";
		
	}
	
	/**
	 * 
	 * @param request
	 * @param spu
	 * @param myFile
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public boolean update(HttpServletRequest request,Spu spu,MultipartFile myFile) {
		if(!myFile.isEmpty()) {
			//上传图片
			String filePath = fileUpload.uploadd(myFile);
			spu.setSmallPic(filePath);
		}else {
			spu.setSmallPic(null);
		}
		int add = spuService.update(spu);
		
		return add>0;
		
	}
	
	
	
	
}
