package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.TeachingClass;
import util.HibernateUtil;

public class TeachingClassDAO implements DAOInterface<TeachingClass>{

	@Override
	public void insert(TeachingClass t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.save(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public void update(TeachingClass t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.update(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public void delete(TeachingClass t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			session.delete(t);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	@Override
	public List<TeachingClass> selectAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			ArrayList<TeachingClass> list = new ArrayList<TeachingClass>(session.createQuery("FROM TeachingClass").list());
			tx.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public TeachingClass selectByCode(String code) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			TeachingClass tc = (TeachingClass) session.createQuery("FROM TeachingClass tc WHERE tc.code = :code")
					.setParameter("code", code).uniqueResult();
			tx.commit();
			return tc;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public ArrayList<TeachingClass> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, TeachingClass t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			int count = 0;
			switch (nameField) {
			case "code": {
				count = (int) session
						.createQuery("SELECT count(code) FROM TeachingClass a WHERE a.code = :code AND a.id != :id")
						.setParameter("code", t.getCode()).setParameter("id", t.getId()).uniqueResult();
				break;
			}
			}
			tx.commit();
			return count == 0;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return false;
		}
	}

}
