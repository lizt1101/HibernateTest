package com.lzt.dao;

import java.util.List;

import com.lzt.entity.B;
import com.lzt.entity.admin;

public interface userDao {
	
	List<admin> select();
	
	admin get(int id);
	
	public List<admin> selectadmin();
	
	public Long updateadmin(final String hql,final Object... params);
	
	public admin save(admin ad);
	
	public List<Integer> getDoorIds();
	
	B getDoorName(int id);
	
	public void updateA(Integer id,String doorName);

}
