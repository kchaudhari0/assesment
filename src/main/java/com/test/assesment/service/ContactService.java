package com.test.assesment.service;

import com.test.assesment.entity.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAllContacts();
    Contact getContactById(int id);
    Contact createContact(Contact contact);
    Contact updateContact(int id, Contact contact);
    void deleteContact(int id);
    List<Contact> searchContacts(String query);

}
