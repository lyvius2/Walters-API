package com.walter.tacademy.WaltersAPI.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository repository;

	@Test
	public void testSave() {
		Book book = new Book();
		book.setName("나는 일주일에 이틀만 일하기로 했다.");
		book.setIsbn10("1234567890");
		book.setIsbn13("1234567890112");

		assertThat(book.isNew()).isTrue();

		repository.save(book);

		assertThat(book.isNew()).isFalse();
	}

	@Test
	public void testFindByNameLike() {
		Book book = new Book();
		book.setName("나는 일주일에 이틀만 일하기로 했다.");
		book.setIsbn10("1234567890");
		book.setIsbn13("1234567890112");

		repository.save(book);

		List<Book> books = repository.findByNameLike("나는 일주일에%");
		assertThat(books).isNotEmpty();

		books = repository.findByNameLike("너는");
		assertThat(books).isEmpty();
	}
}
