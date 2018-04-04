package com.my.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.model.Stdentu;
@Repository
public class StudentDao implements com.my.dao.StudentDao {

	
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Stdentu student) {
session.getCurrentSession().save(student);
	}

	@Override
	public void edit(Stdentu student) {
session.getCurrentSession().update(student);
	}

	@Override
	public void delete(int ID) {
session.getCurrentSession().delete(getStudent(ID));
	}

	@Override
	public Stdentu getStudent(int ID) {
		return (Stdentu) session.getCurrentSession().get(Stdentu.class,ID);
	}

	@Override
	public List getAllStudent() {
		return session.getCurrentSession().createQuery("from stdentu").list();
	}

}
