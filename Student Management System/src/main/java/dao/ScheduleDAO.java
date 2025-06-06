package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Room;
import entities.Schedule;
import util.HibernateUtil;

public class ScheduleDAO implements DAOInterface<Schedule> {

	@Override
	public void insert(Schedule t) {
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
	public void update(Schedule t) {
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
	public void delete(Schedule t) {
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
	public List<Schedule> selectAll() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			ArrayList<Schedule> list = new ArrayList<Schedule>(session.createQuery("FROM Schedule").list());
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
	public Schedule selectByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Schedule> selectByCondition(Map<String, Object> filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsBy(String nameField, Schedule t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean existsBy(Schedule t) {
		Transaction tx = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			Schedule s = (Schedule) session
					.createQuery("From Schedule s Where s.id != :id AND s.date = :date AND s.timeSlot = :timeSlot")
					.setParameter("id", t.getId()).setParameter("date", t.getDate())
					.setParameter("timeSlot", t.getTimeSlot()).uniqueResult();
			tx.commit();
			return s == null;
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
			return false;
		}
	}
}
