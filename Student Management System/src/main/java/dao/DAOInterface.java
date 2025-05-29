package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DAOInterface<T> {
	public void insert(T t);

	public void update(T t);

	public void delete(T t);

	public List<T> selectAll();

	public T selectByCode(String code);

	public ArrayList<T> selectByCondition(Map<String, Object> filters);
	
	public boolean existsBy(String nameField, T t);
}
