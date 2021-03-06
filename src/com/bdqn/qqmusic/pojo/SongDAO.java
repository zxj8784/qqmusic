package com.bdqn.qqmusic.pojo;

import com.bdqn.qqmusic.dao.BaseDAO;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Song
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.bdqn.qqmusic.pojo.Song
 * @author MyEclipse Persistence Tools
 */

public class SongDAO extends BaseDAO {
	private static final Logger log = LoggerFactory.getLogger(SongDAO.class);
	// property constants
	public static final String SNAME = "sname";
	public static final String SCOMPOSE = "scompose";
	public static final String SARRANGEMENT = "sarrangement";

	public void save(Song transientInstance) {
		log.debug("saving Song instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Song persistentInstance) {
		log.debug("deleting Song instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Song findById(java.lang.Integer id) {
		log.debug("getting Song instance with id: " + id);
		try {
			Song instance = (Song) getSession().get(
					"com.bdqn.qqmusic.pojo.Song", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Song instance) {
		log.debug("finding Song instance by example");
		try {
			List results = getSession()
					.createCriteria("com.bdqn.qqmusic.pojo.Song")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Song instance with property: " + propertyName
				+ ", value: " + value);
		try {
			Query queryObject = null;
			/*
			 * if(propertyName.equals("aname")){ //在HQL语句中定义命名参数要用”:”开头 String
			 * queryString = "from Song as s where s.artist.aname=:aname";
			 * System.out.println(queryString); queryObject =
			 * getSession().createQuery(queryString);
			 * queryObject.setProperties(value);
			 * //System.out.println(queryString); }else
			 * if(propertyName.equals("rname")){ String queryString =
			 * "from Song as s where s.record.rname=:rname";
			 * System.out.println(queryString); queryObject =
			 * getSession().createQuery(queryString);
			 * queryObject.setProperties(value); }else{
			 */
			String queryString = "from Song as model where model."
					+ propertyName + "= ?";
			queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			// System.out.println(queryString);
			// }
			// Query a = queryObject;
			List<Song> list = queryObject.list();
			// 输出查询语句
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPropertyAndPage(String propertyName, Object value,
			int pageNum, int line) {
		try {
			Query queryObject = null;
			String queryString = "from Song as model where model."
					+ propertyName + "= ?";
			queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			queryObject.setFirstResult((pageNum - 1) * line);
			queryObject.setMaxResults(line);
			List<Song> list = queryObject.list();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySname(Object sname) {
		return findByProperty(SNAME, sname);
	}

	public List findByScompose(Object scompose) {
		return findByProperty(SCOMPOSE, scompose);
	}

	public List findBySarrangement(Object sarrangement) {
		return findByProperty(SARRANGEMENT, sarrangement);
	}

	public List findAll() {
		log.debug("finding all Song instances");
		try {
			String queryString = "from Song";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public List findAll(int pageNum, int line) {
		log.debug("finding all Song instances");
		try {
			String queryString = "from Song";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setFirstResult((pageNum - 1) * line);
			queryObject.setMaxResults(line);
			List<Song> list = queryObject.list();
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Song merge(Song detachedInstance) {
		log.debug("merging Song instance");
		try {
			Song result = (Song) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Song instance) {
		log.debug("attaching dirty Song instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Song instance) {
		log.debug("attaching clean Song instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	
	public static void main(String[] args){
		System.out.println(new SongDAO().findAll().size());
	}
}