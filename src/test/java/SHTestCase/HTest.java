package SHTestCase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.lzt.dao.userDaoImpl;
import com.lzt.entity.admin;


public class HTest{
	ClassPathXmlApplicationContext ctc;
	SessionFactory factory;
	
	
	@Before
	public void init(){
		ctc = new ClassPathXmlApplicationContext("MySpring_orm.xml");
		factory = ctc.getBean("sessionFactory",SessionFactory.class);
	}
	
	@Test
	public void testSession(){		
		Session session=factory.openSession();
		System.out.println(session);
		session.close();	
	}
	@Test
	public void save(){
		admin a = new admin();
		a.setPassword("1234567");
		a.setAge(19);
		a.setName("¹þ¹þ");
		a.setLikes("´ò¼Ü123");
		a.setMessage("asfsdkgn");
		//getHibernateTemplate().save(a);
		//getSessionFactory().getCurrentSession().saveOrUpdate(a);
		Session session=factory.openSession();
		session.save(a);
		session.close();
	}
	
	@Test
	public void update(){
		admin a = new admin();
		a.setId(15);
		a.setPassword("****");
		a.setAge(19);
		a.setName("¹þ¹þ¹þ¹þ¹þ");
		a.setLikes("²âÊÔ¸üÐÂ1234");
		a.setMessage("asfsdkgn");
		Session session=factory.openSession();
		Transaction tx =session.beginTransaction();//ÊÂÎñÌá½»
		session.update(a);
		tx.commit();
		session.close();
	}
	
	@Test
	public void get(){
		Session session=factory.openSession();
		admin a = (admin) session.get(admin.class, 14);
		System.out.println(a.toString());
		/*admin b = (admin) session.get(admin.class, 13);
		System.out.println(b.toString());*/
		session.close();
	}
	
	@Test
	public void delete(){
		Session session=factory.openSession();
		admin a = new admin();
		a.setId(15);
		/*a.setPassword("****");
		a.setAge(19);
		a.setName("¹þ¹þ¹þ¹þ¹þ");
		a.setLikes("²âÊÔ¸üÐÂ1234");
		a.setMessage("asfsdkgn");*/
		Transaction tx =session.beginTransaction();
		session.delete(a);
		tx.commit();
		session.close();
	}
	
	
	

}










