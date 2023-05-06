package com.test.assesment.Repository;

import com.test.assesment.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    //Repository Method to search using firstname , lastname , email
    List<Contact> findByFirstNameContainingOrLastNameContainingOrEmailContaining(String firstName, String lastName, String email);
}
