package com.test.assesment.dao;

import com.test.assesment.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact , Integer> {

    List<Contact> findByFirstNameContainingOrLastNameContainingOrEmailContaining(String firstName, String lastName, String email);
}
