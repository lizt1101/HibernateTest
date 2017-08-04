package com.lzt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzt.entity.B;
import com.lzt.entity.admin;
import com.lzt.service.userService;

@Controller
public class userController {

	/*@Resource(name="userservice")
	private userServiceImpl service;*/
	
	@Autowired
	private userService service;

	
	@RequestMapping("/toindex.do")
	public String toindex(){
		return "index";	
	}

	@RequestMapping("/test.do")
	public String totest(){
		System.out.println("dasfds");
		admin a = service.get(1);
		System.out.println(a.toString());
		
		return null;	
	}
	
	@RequestMapping("/test01.do")
	public String totest02(){
		System.out.println("123456");
		service.getAdmin();
		
		return null;
		
	}
	
	@RequestMapping("/test02.do")
	public String totest03(){
		System.out.println("����criteria");
		service.getadmin1();
		return null;
	}
	
	@RequestMapping("/test03.do")
	public String testHibernateRollback(){
		System.out.println("����HibernateRollback");
		String hql = "update admin set name=? where id=?";
		Long l = service.updateadmin(hql,"lzt1",1);
		System.out.println(l);
		return null;
	}
	
	@RequestMapping("/test04.do")
	public String testsaveupdate(){
		System.out.println("测试更新与保存");
		admin a = new admin();
		a.setId(17);
		a.setPassword("1234566756");
		a.setAge(29);
		a.setName("小明vv");
		a.setMessage("asfsdkgn");
		admin ad = service.saveupdate(a);
		System.out.println(ad.toString());
		return null;
	}
	
	@RequestMapping("/test05.do")
	public String testupdate(){
		List<Integer> list = service.getDoorIds();
		for (Integer id : list) {
			B b = service.getDoorName(id);
			//System.out.println("店铺:"+b.getDoorName());
			service.updateA(id, b.getDoorName());
		}
		return null;
		
	}

}



