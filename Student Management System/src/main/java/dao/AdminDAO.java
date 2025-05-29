package dao;

import java.util.ArrayList;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Admin;
import util.HibernateUtil;

public class AdminDAO implements DAOInterface<Admin> {
	@Override
	public void insert(Admin t) {
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
	public void update(Admin t) {
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
	public void delete(Admin t) {
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
	public ArrayList<Admin> selectAll() {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			ArrayList<Admin> list = new ArrayList<Admin>(session.createQuery("FROM Admin").list());
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
	public Admin selectByCode(String code) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Admin adm = (Admin) session.createQuery("FROM Admin a WHERE a.code = :code").setParameter("code", code)
					.uniqueResult();
			tx.commit();
			return adm;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public ArrayList<Admin> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, Admin t) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			int count = 0;
			switch (nameField) {
			case "username": {
				count = (int) session
						.createQuery("SELECT count(username) FROM Admin a WHERE a.username = :username AND a.id != :id")
						.setParameter("username", t.getUsername()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "code": {
				count = (int) session
						.createQuery("SELECT count(code) FROM Admin a WHERE a.code = :code AND a.id != :id")
						.setParameter("code", t.getCode()).setParameter("id", t.getId()).uniqueResult();
				if (count != 0)
					return false;
				break;
			}
			case "email": {
				count = (int) session
						.createQuery("SELECT count(email) FROM Admin a WHERE a.email = :email AND a.id != :id")
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