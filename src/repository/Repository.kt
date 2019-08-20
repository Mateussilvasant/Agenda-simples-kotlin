package repository

import model.Contact

class Repository {

    companion object {

        private val contactList = mutableListOf<Contact>()

        fun save(contact: Contact) {
            contactList.add(contact)
        }

        fun delete(contact: Contact) {
            contactList.remove(contact)
        }

        fun getList(): List<Contact> {
            return contactList
        }
    }

}