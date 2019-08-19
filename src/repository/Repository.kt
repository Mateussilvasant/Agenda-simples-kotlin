package repository

import model.Contact

class Repository  {

    companion object {

        private val contactList = mutableListOf<Contact>()

        fun save(contact: Contact) {
            contactList.add(contact)
        }

        fun delete(contact: Contact) {

        }

        fun getList() : List<Contact>{
            return contactList
        }
    }

}