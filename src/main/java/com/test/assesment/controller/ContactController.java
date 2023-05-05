package com.test.assesment.controller;

import com.test.assesment.entity.Contact;
import com.test.assesment.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/contact")
public class ContactController {


    @Autowired
    private ContactService contactService;

    @GetMapping("/getAllContacts")
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @PostMapping("")
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable int id, @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
    }

    @GetMapping("/searchByField")
    public List<Contact> searchContacts(@RequestParam String field) {
        return contactService.searchContacts(field);
    }
}

