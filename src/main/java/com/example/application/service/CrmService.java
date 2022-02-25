package com.example.application.service;

import com.example.application.entity.Contact;
import com.example.application.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CrmService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }
    public Contact saveContact(Contact contact){
        return contactRepository.save(contact);
    }
}
