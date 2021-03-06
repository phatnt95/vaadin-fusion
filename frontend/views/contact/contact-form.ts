import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from 'Frontend/views/view';
import '@vaadin/button';
import '@vaadin/combo-box';
import '@vaadin/text-field';
import { Binder, field } from '@vaadin/form';
import ContactModel from 'Frontend/generated/com/example/application/entity/ContactModel';
import { crmStore } from 'Frontend/stores/app-store';
import { listViewStore } from '../list/list-view-store';

@customElement('contact-form')
export class ContactForm extends View {
  
  protected binder = new Binder(this, ContactModel)

  constructor(){
    super();
    this.autorun(()=>{
      if (listViewStore.selectedContact) {
        this.binder.read(listViewStore.selectedContact);
      } else {
        this.binder.clear();
      }
    });
    
  }

  render() {
    const {model} = this.binder;
    return html`
      <vaadin-text-field label="First name" ${field(model.firstName)}></vaadin-text-field>
      <vaadin-text-field label="Last name" ${field(model.lastName)}></vaadin-text-field>
      <vaadin-text-field label="Email" ${field(model.email)}></vaadin-text-field>

      <div class="flex gap-s">
        <vaadin-button theme="primary" @Click=${this.save}>Save</vaadin-button>
        <vaadin-button theme="error">Delete</vaadin-button>
        <vaadin-button theme="tertiary" @click=${listViewStore.cancelEdit}>Cancel</vaadin-button>
      </div>
    `;
  }

  async save(){
    await this.binder.submitTo(crmStore.saveContact);
    this.binder.clear();
  }
}