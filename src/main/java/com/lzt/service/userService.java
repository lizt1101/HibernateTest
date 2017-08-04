package com.lzt.service;

import java.util.List;

import javax.annotation.Resource;

import com.lzt.dao.userDaoImpl;
import com.lzt.entity.B;
import com.lzt.entity.admin;

public interface userService {
	admin get(int id);
	
	List<admin> getAdmin();
	
	public List<admin> getadmin1();
	
	public Long updateadmin(final String hql,final Object... params);
	
	public admin saveupdate(admin ad);
	public List<Integer> getDoorIds();
	B getDoorName(int id);
	public void updateA(Integer id,String doorName);

}
