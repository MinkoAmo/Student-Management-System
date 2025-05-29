package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Teacher;
import util.HibernateUtil;

public class TeacherDAO implements DAOInterface<Teacher> {

	@Override
	public void insert(Teacher t) {
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
	public void update(Teacher t) {
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
	public void delete(Teacher t) {
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
	public List<Teacher> selectAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			ArrayList<Teacher> list = new ArrayList<Teacher>(session.createQuery("FROM Teacher").list());
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
	public Teacher selectByCode(String code) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Teacher tea = (Teacher) session.createQuery("FROM Teacher a WHERE a.code = :code")
					.setParameter("code", code).uniqueResult();
			tx.commit();
			return tea;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public ArrayList<Teacher> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, Teacher t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			int count = 0;
			switch (nameField) {
			case "username": {
				count = (int) session
						.createQuery("SELECT count(username) FROM Teacher a WHERE a.username = :username AND a.id != :id")
						.setParameter("username", t.getUsername()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "code": {
				count = (int) session
						.createQuery("SELECT count(code) FROM Teacher a WHERE a.code = :code AND a.id != :id")
						.setParameter("code", t.getCode()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "email": {
				count = (int) session
						.createQuery("SELECT count(email) FROM Teacher a WHERE a.email = :email AND a.id != :id")
						.setParameter("email", t.getEmail()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return false;
		}
	}

}