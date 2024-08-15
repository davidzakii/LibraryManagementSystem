package com.tutusfunny.Library.service.IMPL;

import com.tutusfunny.Library.entity.Patron;
import com.tutusfunny.Library.repo.PatronRepo;
import com.tutusfunny.Library.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServiceIMPL implements PatronService {

    @Autowired
    private PatronRepo patronRepo;

    public List<Patron> getAllPatrons() {
        return patronRepo.findAll();
    }

    public Optional<Patron> getPatronById(Long id) {
        return patronRepo.findById(id);
    }

    @Override
    public Patron savePatron(Patron patron) {
        return null;
    }

    public Patron addPatron(Patron patron) {
        return patronRepo.save(patron);
    }

    public Optional<Patron> updatePatron(Long id, Patron updatedPatron) {
        Optional<Patron> patronOptional = patronRepo.findById(id);
        if (patronOptional.isPresent()) {
            Patron patron = patronOptional.get();
            patron.setName(updatedPatron.getName());
            patron.setContactInfo(updatedPatron.getContactInfo());
            return Optional.of(patronRepo.save(patron));
        } else {
            return Optional.empty(); // Handle error
        }
    }

    public boolean deletePatron(Long id) {
        patronRepo.deleteById(id);
        return false;
    }
}
