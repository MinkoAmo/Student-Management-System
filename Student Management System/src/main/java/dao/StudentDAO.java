package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;

public class StudentDAO implements DAOInterface<Student> {

	@Override
	public void insert(Student t) {
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
	public void update(Student t) {
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
	public void delete(Student t) {
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
	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			ArrayList<Student> list = new ArrayList<Student>(session.createQuery("FROM Student").list());
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
	public Student selectByCode(String code) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Student std = (Student) session.createQuery("FROM Student a WHERE a.code = :code")
					.setParameter("code", code).uniqueResult();
			tx.commit();
			return std;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public ArrayList<Student> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, Student t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			int count = 0;
			switch (nameField) {
			case "username": {
				count = (int) session
						.createQuery("SELECT count(username) FROM Student a WHERE a.username = :username AND a.id != :id")
						.setParameter("username", t.getUsername()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "code": {
				count = (int) session
						.createQuery("SELECT count(code) FROM Student a WHERE a.code = :code AND a.id != :id")
						.setParameter("code", t.getCode()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "email": {
				count = (int) session
						.createQuery("SELECT count(email) FROM Student a WHERE a.email = :email AND a.id != :id")
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