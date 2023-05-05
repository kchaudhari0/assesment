package com.test.assesment.service;

import com.test.assesment.dao.ContactRepository;
import com.test.assesment.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) {

        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact createContact(Contact contact) {
       return contactRepository.save(contact);
    }

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

    @Override
    public void deleteContact(int id) {
        contactRepository.deleteById(id);
    }
    @Override
    public List<Contact> searchContacts(String data) {
        return contactRepository.findByFirstNameContainingOrLastNameContainingOrEmailContaining(data, data, data);
    }
}
