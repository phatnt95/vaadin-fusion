package com.example.application.endpoint;

import com.example.application.entity.Contact;
import com.example.application.repository.ContactRepository;
import com.example.application.service.CrmService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.fusion.Endpoint;
import com.vaadin.fusion.Nonnull;
import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@Endpoint
@AnonymousAllowed
@AllArgsConstructor
public class ContactEndpoint {

    private ContactRepository contactRepository;

    public static class CrmData {
        @Nonnull
        public List<@Nonnull Contact> contacts = Collections.emptyList();
    }

    @Nonnull
    public CrmData getCrmData() {
        CrmData crmData = new CrmData();
        crmData.contacts = contactRepository.findAll();
        return crmData;
    }

    @Nonnull
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}


