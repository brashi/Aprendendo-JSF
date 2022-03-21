package com.esig.app;

import com.esig.app.Todo;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TodoDao {
	
	private Transaction transac;
	private Session session;
	
	public void addTodo(Todo todo) {
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transac = session.beginTransaction();
			
			Todo t = new Todo();
			t.setTitulo(todo.getTitulo());
			t.setDescricao(todo.getDescricao());
			t.setResponsavel(todo.getResponsavel());
			t.setPrioridade(todo.getPrioridade());
			t.setDone(todo.isDone());
			
			session.save(t);
			transac.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void removeTodo(Todo todo) {
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transac = session.beginTransaction();
			session.delete(todo);
			transac.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void update(Todo todo) {
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transac = session.beginTransaction();
			session.update(todo);
			transac.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public List<Todo> getList() {
		List<Todo> lista = new ArrayList<>();
		try {
			session = ConexaoHibernate.getSessionFactory().openSession();
			transac = session.beginTransaction();
			
			Criteria crit = session.createCriteria(Todo.class);
			lista = crit.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return lista;
	}
}
