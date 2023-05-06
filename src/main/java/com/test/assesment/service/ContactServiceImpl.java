package com.test.assesment.service;

import com.test.assesment.Repository.ContactRepository;
import com.test.assesment.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {


    // Doing dependency injection for repository

    @Autowired
    private ContactRepository contactRepository;


    // method to get all contacts
    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // method to get contact by ID
    @Override
    public Contact getContactById(int id) {

        return contactRepository.findById(id).orElse(null);
    }

    //method to save a new contact
    @Override
    public Contact createContact(Contact contact) {

        return contactRepository.save(contact);
    }

    // method to update a contact
    @Override
    public Contact updateContact(int id, Contact contact) {
        Contact findContact = contactRepository.findById(id).orElse(null);
        if (findContact == null) {
            return null;
        }
        findContact.setFirstName(contact.getFirstName());
        findContact.setLastName(contact.getLastName());
        findContact.setEmail(contact.getEmail());
        findContact.setPhoneNumber(contact.getPhoneNumber());
        return contactRepository.save(findContact);
    }

    // method to delete a contact by ID
    @Override
    public void deleteContact(int id) {

        contactRepository.deleteById(id);
    }

    //method to search by firstname , lastname , or email
    @Override
    public List<Contact> searchContacts(String data) {
        return contactRepository.findByFirstNameContainingOrLastNameContainingOrEmailContaining(data, data, data);
    }
}
