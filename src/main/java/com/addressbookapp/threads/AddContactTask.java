package com.addressbookapp.threads;

import com.addressbookapp.model.Contact;
import com.addressbookapp.repository.ContactRepository;

public class AddContactTask implements Runnable {

    private final ContactRepository repository;
    private final Contact contact;

    public AddContactTask(ContactRepository repository, Contact contact) {
        this.repository = repository;
        this.contact = contact;
    }

    @Override
    public void run() {
        repository.addContact(contact);
        System.out.println("Inserted contact: " + contact.getFirstName());
    }
}