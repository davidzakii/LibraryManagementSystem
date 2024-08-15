package com.tutusfunny.Library.repo;

import com.tutusfunny.Library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {
}
