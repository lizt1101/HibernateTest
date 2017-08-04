package com.lzt.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.lzt.entity.B;
import com.lzt.entity.admin;

@Repository("userDao")
public class userDaoImpl extends HibernateDaoSupport implements userDao {

	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}
	
	
	public admin get(int id) {
		return getHibernateTemplate().get(admin.class, id);	
	}
	
	public List<admin> select(){
		String sql = "select name from user";
		Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		//System.out.println(query.setResultTransformer(Transformers.aliasToBean(admin.class)).list());
		System.out.println(query.list());
		return query.list();
	}
	
	public List<admin> selectadmin(){
		Criteria criteria = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(admin.class);
		criteria.add(Restrictions.gt("age", 17));
		criteria.addOrder(Order.desc("age"));
		criteria.setMaxResults(5);
		criteria.setFirstResult(0);
		List<admin> list = criteria.list();
		for (admin admin : list) {
			System.out.println(admin.toString());
		}
		return criteria.list();	
	}
	
	//HibernateCallback
	public Long updateadmin(final String hql,final Object... params){
		Long l = (Long) getHibernateTemplate().execute(new HibernateCallback<Object>(){

			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery(hql);
				int i=0;
				for (Object p : params) {
					query.setParameter(i++, p);
				}
				Integer rows = query.executeUpdate();
				return new Long(rows);
			}
		});
		return l;
	}

	public admin save(admin ad) {
		getSessionFactory().getCurrentSession().saveOrUpdate(ad);
		return ad;
	}


	public List<Integer> getDoorIds() {
		String sql = "select td.doorId from test_door td GROUP BY td.doorId;";
		Query query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		//System.out.println(query.setResultTransformer(Transformers.aliasToBean(admin.class)).list());
		//System.out.println(query.list());
		return query.list();
	}


	public B getDoorName(int id) {
		
		return getHibernateTemplate().get(B.class, id);
	}


	public void updateA(Integer id, String doorName) {
		String sql = "update test_door td set td.doorName =:doorName where td.doorId=:id";
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createSQLQuery(sql)
				.setParameter("doorName", doorName).setParameter("id", id);
		query.executeUpdate();
	}
	
	
	
	
	
	
	
	

}
