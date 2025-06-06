package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Account;
import util.HibernateUtil;

public class AccountDAO implements DAOInterface<Account> {
	@Override
	public void insert(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account selectByCode(String username) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Account acc = (Account) session.createQuery("FROM Account a WHERE a.username = :username").setParameter("username", username).uniqueResult();
			tx.commit();
			return acc;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return null;
		}
	}

	@Override
	public ArrayList<Account> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, Account t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean existsBy(Account t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			int count = (int) session.createQuery(
					"SELECT count(username) FROM Account a WHERE a.username = :username AND a.password != :password")
					.setParameter("username", t.getUsername()).setParameter("password", t.getPassword()).uniqueResult();
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
