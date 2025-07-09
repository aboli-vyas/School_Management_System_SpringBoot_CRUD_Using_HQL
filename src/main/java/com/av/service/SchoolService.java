package com.av.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av.dao.SchoolDao;
import com.av.entity.School;

@Service
public class SchoolService {

	@Autowired
	SchoolDao dao;

	public String insertData(School sc) {
		String msg = dao.insertData(sc);
		return msg;
	}

	public String deleteData(int sId) {
		String msg = dao.deleteData(sId);
		return msg;
	}

	public String updateData(School sc, int sId) {
		String msg = dao.updateData(sc, sId);
		return msg;
	}

	public School getSingleRecord(int sId) {
		School sc = dao.getSingleRecord(sId);
		return sc;
	}

	public List<School> getAllData() {
		List<School> list = dao.getAllData();
		return list;
	}

}
