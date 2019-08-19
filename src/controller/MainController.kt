package controller

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import service.ContactService
import view.ContactForm
import view.MainApp
import view.MainForm

class MainController(mainView: MainApp) {

    private val mainApp: MainApp = mainView
    private val viewMain: MainForm = MainForm(mainView)
    private val viewContact: ContactForm = ContactForm(this)

    init {
        viewMain.initUI(this)
    }

    /*Formulario contato */
    fun newContactEvent(): EventHandler<ActionEvent>? {
        return EventHandler {
            mainApp.backMenu(viewContact, viewMain)
        }
    }

    /*Remove um contato */
    fun removeContactEvent(): EventHandler<ActionEvent>? {
        return EventHandler {
            //ContactService.delete()
        }
    }

    /*Salva um contato*/
    fun saveContactEvent(): EventHandler<ActionEvent>? {
        return EventHandler {
            try {

                saveContact()
                loadList()
                mainApp.backMenu(viewMain, viewContact)

            } catch (e: Exception) {
                Alert(Alert.AlertType.INFORMATION, e.message).showAndWait()
            } finally {
                viewContact.clearFields()
            }
        }
    }

    /*Cancela a operacao menu contato*/
    fun cancelMenuForm(): EventHandler<ActionEvent>? {
        return EventHandler {
            mainApp.backMenu(viewMain, viewContact)
        }
    }

    /*Carrega a lista de contatos na view*/
    fun loadList() {
        val contacts = ContactService.getList()
        viewMain.tableContacts.items = FXCollections.observableList(contacts)
        viewMain.labelNumberContacts.text = "${contacts.size} contatos"
    }

    private fun saveContact() {
        ContactService.save(viewContact.nameField.text, viewContact.phoneField.text)
    }



}