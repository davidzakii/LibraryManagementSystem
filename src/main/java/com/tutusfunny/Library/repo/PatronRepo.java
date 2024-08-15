package com.tutusfunny.Library.repo;

import com.tutusfunny.Library.entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Long> {
}
