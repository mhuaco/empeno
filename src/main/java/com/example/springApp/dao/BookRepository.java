package com.example.springApp.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springApp.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
