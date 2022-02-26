package com.example.application.service;

import com.example.application.entity.Contact;
import com.example.application.entity.Lead;
import com.example.application.entity.User;
import com.example.application.repository.AccountRepository;
import com.example.application.repository.ContactRepository;
import com.example.application.repository.LeadsRepository;
import com.example.application.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CrmService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private LeadsRepository leadsRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Contact> findAllContact(){
        return contactRepository.findAll();
    }
    public Contact save(Contact contact){
        return contactRepository.save(contact);
    }
    public List<Lead> findAllLead(){
        return leadsRepository.findAll();
    }
    public Lead save(Lead contact){
        return leadsRepository.save(contact);
    }
    public List<User> findAllUser(){
        return userRepository.findAll();
    }
    public User save(User contact){
        return userRepository.save(contact);
    }
}
