package com.av.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.av.entity.School;
import com.av.service.SchoolService;

@RestController
public class SchoolController {
	
	@Autowired
	SchoolService service;
	
	@PostMapping("/save")
	public String insertData(@RequestBody School sc) {
		String msg = service.insertData(sc);
		return msg;
	}
	
	@DeleteMapping("/delete/{sId}")
	public String deleteData(@PathVariable int sId) {
		String msg = service.deleteData(sId);
		return msg;
	}
	
	@PutMapping("/update/{sId}")
	public String updateData(@RequestBody School sc, @PathVariable int sId) {
		String msg = service.updateData(sc, sId);
		return msg;
	}
	
	@GetMapping("/getSingleRecord/{sId}")
	public School getSingleRecord(@PathVariable int sId) {
		School sc = service.getSingleRecord(sId);
		return sc;
	}
	
	@GetMapping("/getAllData")
	public List<School> getAllData(){
		List<School> list = service.getAllData();
		return list;
	}

}
