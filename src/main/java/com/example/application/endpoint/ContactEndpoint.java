package com.example.application.endpoint;

import com.example.application.entity.Account;
import com.example.application.entity.Contact;
import com.example.application.entity.Lead;
import com.example.application.entity.User;
import com.example.application.repository.ContactRepository;
import com.example.application.response.ResponseData;
import com.example.application.service.CrmService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import com.vaadin.fusion.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

@Endpoint
@AnonymousAllowed
@AllArgsConstructor
public class ContactEndpoint {

//    private ContactRepository contactRepository;
//
//    public static class CrmData {
//        @Nonnull
//        public List<@Nonnull Account> accounts = Collections.emptyList();
//        public List<@Nonnull Contact> contacts = Collections.emptyList();
//        public List<@Nonnull Lead> leads = Collections.emptyList();
//        public List<@Nonnull User> users = Collections.emptyList();
//    }
//
//    @Nonnull
//    public CrmData getCrmData() {
//        CrmData crmData = new CrmData();
//        crmData.contacts = contactRepository.findAll();
//        return crmData;
//    }
//
//    @Nonnull
//    public Contact saveContact(Contact contact) {
//        return contactRepository.save(contact);
//    }
    @Autowired
    private CrmService crmService;

    public ResponseData getAllContacts(){
        ResponseData<Contact> res = new ResponseData<>();
        try {
            res.setResult((List<Contact>) crmService.findAllContact());
        } catch (Exception ex) {
        }


        return res;
    }
}


