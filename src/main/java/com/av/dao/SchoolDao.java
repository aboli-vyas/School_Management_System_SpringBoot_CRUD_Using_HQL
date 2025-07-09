package com.av.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.av.entity.School;

@Repository
public class SchoolDao {

	@Autowired
	SessionFactory factory;

	public String insertData(School sc) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		String insertQuery = "insert into school(stud_id,stud_name,t_id,t_name)values(:studId,:studName,:tId,:tName)";

		Query<School> query = ss.createNativeQuery(insertQuery);

		query.setParameter("studId", sc.getStudId());
		query.setParameter("studName", sc.getStudName());
		query.setParameter("tId", sc.gettId());
		query.setParameter("tName", sc.gettName());

		query.executeUpdate();

		tr.commit();
		ss.close();
		return "Data is inserted";

	}

	public String deleteData(int sId) {

		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();

		int id = sId;

		String deleteQuery = "delete from School where id =:id";

		MutationQuery query = ss.createMutationQuery(deleteQuery);
		query.setParameter("id", id);
		query.executeUpdate();

		tr.commit();
		ss.close();
		return "Data is deleted";

	}
	
	public String updateData(School sc , int sId) {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = sId;
		
		String updateQuery = "update School set studName=:studName,tId=:tId,tName=:tName where id=:id";
		
		MutationQuery query = ss.createMutationQuery(updateQuery);
		query.setParameter("id", id);
		query.setParameter("studName" , sc.getStudName());
		query.setParameter("tId", sc.gettId());
		query.setParameter("tName", sc.gettName());
		
		query.executeUpdate();
		
		tr.commit();
		ss.close();
		
		return "Data is updated";
		
	}
	
	public School getSingleRecord(int sId) {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = sId;
		
		String getSingleQuery = "from School where id=:id";
		Query<School> query = ss.createQuery(getSingleQuery,School.class);
		query.setParameter("id", id);
		School sc = query.getSingleResult();
		
		tr.commit();
		ss.close();
		
		return sc;
		
	}
	
	public List<School> getAllData() {
		
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		
		String getAllQuery="from School";
		
		Query<School> query = ss.createQuery(getAllQuery,School.class);
		List<School> list = query.list();
		
		tr.commit();
		ss.close();
		return list;
	}
	
     
}
