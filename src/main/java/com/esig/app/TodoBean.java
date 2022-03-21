package com.esig.app;

import java.util.List;
import javax.faces.bean.ManagedBean;

import com.esig.app.Todo;
import com.esig.app.TodoDao;

@ManagedBean(name = "bean")
public class TodoBean {
	// Criação de Model e DAO.
	private TodoDao todoDao = new TodoDao();
	private Todo todo = new Todo();
	
	
	private String todoTitulo;
	private String todoDesc;
	private Todo.Prioridade todoPrioridade;
	
	public TodoBean() {
		System.out.println("Bean iniciado.");
	}
	
	public String addTodo() {
		if(todo.getTitulo() != "") {
			todoDao.addTodo(todo);
			todo.setTitulo(null);
			todo.setDone(false);
		}
		return "index";
	}
	
	public String removeTodo(Todo todo) {
		todoDao.removeTodo(todo);
		return "index";
	}
	
	public String changeTodo(Todo todo) {
		this.todo = todo;
		this.todo.setDone(!this.todo.isDone());
		todoDao.update(todo);
		todo.setTitulo(null);
		todo.setDone(false);
		return "index";
	}
	
	public List<Todo> getList() {
		return todoDao.getList();
	}
	
	public Todo getTodo() {
		return todo;
	}
	
	public void setTodo(Todo todo) {
		this.todo = todo;
	}
	
	
	public String getMessage() {
		return "Olá mundo!";	
	}
}
