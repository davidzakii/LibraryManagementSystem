package com.tutusfunny.Library.service;

import com.tutusfunny.Library.entity.Patron;

import java.util.List;
import java.util.Optional;

public interface PatronService {
    Patron addPatron(Patron patron);

    List<Patron> getAllPatrons();

    Optional<Patron> getPatronById(Long id);

    Patron savePatron(Patron patron);

    Optional<Patron> updatePatron(Long id, Patron patronDetails);

    boolean deletePatron(Long id);
}