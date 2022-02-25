import { makeAutoObservable, observable, runInAction } from 'mobx';

import Contact from 'Frontend/generated/com/example/application/entity/Contact';
import { ContactEndpoint } from 'Frontend/generated/endpoints';
import { uiStore } from './app-store';

export class CrmStore {
  contacts: Contact[] = [];
  constructor() {
    makeAutoObservable(
      this,
      {
        initFromServer: false,
        contacts: observable.shallow,
      },
      { autoBind: true }
    );

    this.initFromServer();
  }

  async initFromServer() {
    const data = await ContactEndpoint.getCrmData();

    runInAction(() => {
      this.contacts = data.contacts;
    });
  }


  async saveContact(contact: Contact) {
    try {
      const saved = await ContactEndpoint.saveContact(contact);
      if (saved) {
        this.saveLocal(saved);
        uiStore.showSuccess('Contact saved.');
      } else {
        uiStore.showError('Contact save failed.');
      }
    } catch (e) {
      console.log(e);
      uiStore.showError('Contact save failed.');
    }
  }

  // async deleteContact(contact: Contact) {
  //   if (!contact.id) return;

  //   try {
  //     await ContactEndpoint.deleteContact(contact.id);
  //     this.deleteLocal(contact);
  //   } catch (e) {
  //     console.log('Contact delete failed');
  //   }
  // }

  private saveLocal(saved: Contact) {
    const contactExists = this.contacts.some((c) => c.id === saved.id);
    if (contactExists) {
      this.contacts = this.contacts.map((existing) => {
        if (existing.id === saved.id) {
          return saved;
        } else {
          return existing;
        }
      });
    } else {
      this.contacts.push(saved);
    }
  }

  //  private deleteLocal(contact: Contact) {
  //   this.contacts = this.contacts.filter((c) => c.id !== contact.id);
  //  }
}

