package com.walter.tacademy.WaltersAPI.service;

import com.walter.tacademy.WaltersAPI.domain.Book;

import java.util.Optional;

public interface BookService {

	Optional<Book> findById(Long id);
}
