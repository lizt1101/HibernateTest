package com.lzt.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzt.dao.userDao;
import com.lzt.dao.userDaoImpl;
import com.lzt.entity.B;
import com.lzt.entity.admin;

@Service("userService")
public class userServiceImpl implements userService{
	
	@Autowired
	private userDao dao;
	
	/*@Resource(name="userDao")
	private userDaoImpl dao;*/
	
	public List<admin> getAdmin(){
		return dao.select();
	}
	
	public admin get(int id) {	
		return dao.get(1);
	}

	public List<admin> getadmin1() {
		
		return dao.selectadmin();
	}

	public Long updateadmin(String hql, Object... params) {
		
		return dao.updateadmin(hql, params);
	}

	public admin saveupdate(admin ad) {
		// TODO Auto-generated method stub
		return dao.save(ad);
	}

	public List<Integer> getDoorIds() {
		
		return dao.getDoorIds();
	}

	public B getDoorName(int id) {
		return dao.getDoorName(id);
	}

	public void updateA(Integer id, String doorName) {
		dao.updateA(id, doorName);
		
	}

}
