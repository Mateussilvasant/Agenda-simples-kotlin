package service

import model.Contact
import repository.Repository

class ContactService {

    companion object {

        fun save(name: String, phone: String) {
            validateSave(name, phone)
            val contact  = Contact(name,phone)
            Repository.save(contact)
        }

        fun delete(name: String, phone: String) {
            validateDelete(name, phone)
            Repository.delete(Contact(name,phone))
        }

        fun getList() : List<Contact>{
            return Repository.getList()
        }

        private fun validateSave(name: String, phone: String) {
            if (name.isEmpty()) {
                throw Exception("Nome é obrigatório")
            }
            if (phone.isEmpty()) {
                throw Exception("Telefone é obrigatório")
            }
        }

        private fun validateDelete(name: String, phone: String) {
            if (name.isEmpty() || phone.isEmpty()) {
                throw Exception("É necessário selecionar um contato para remover")
            }
        }

    }

}