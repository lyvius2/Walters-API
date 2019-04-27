package com.walter.tacademy.WaltersAPI.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByNameLike(String name);
	Optional<Book> findById(Long id);
}
