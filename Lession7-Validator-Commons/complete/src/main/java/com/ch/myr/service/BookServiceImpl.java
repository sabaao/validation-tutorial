package com.ch.myr.service;

import org.springframework.stereotype.Service;

import com.ch.myr.validator.annotations.MyrValidated;

import charles.lab.vo.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@MyrValidated
	@Override
	public String valid(Book book) {
		return "success";
	}

}
