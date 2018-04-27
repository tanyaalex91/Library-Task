package by.htp.library.dao;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.Employee;
import by.htp.library.bean.Entity;

public interface BaseDao<T extends Entity>{
	
	public void create();
	public T read(int id);
	public List<T> readAll();
	public void update();
	public void delete(int i);
	
	
	
	
	

}
