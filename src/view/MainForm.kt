package view

import controller.MainController
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import model.Contact

class MainForm(mainApp : MainApp) : StackPane() {

    private val mainView : MainApp = mainApp
    private var buttonNewContact : Button = Button()
    private var buttonRemoveContact : Button = Button()
    var labelNumberContacts : Label = Label()
    lateinit var tableContacts : TableView<Contact>
    private var boxView : VBox = VBox()

    fun initUI(controller : MainController) {
        setUI()
        setEvents(controller)
        controller.loadList()
    }

    private fun setUI(){
        val subBox = HBox()
        tableContacts = TableView()

        buttonNewContact.text = "Novo Contato"
        buttonRemoveContact.text = "Remover Contato"
        labelNumberContacts.text = "0 Contatos"
        labelNumberContacts.padding = Insets(10.0,10.0,10.0,MainApp.widthApp * 0.30)

        buttonNewContact.prefWidth = MainApp.widthApp * 0.30
        buttonNewContact.prefHeight = MainApp.heightApp * 0.10
        buttonRemoveContact.prefWidth = MainApp.widthApp * 0.30
        buttonRemoveContact.prefHeight = MainApp.heightApp * 0.10

        boxView.spacing = MainApp.widthApp * 0.010

        val nomeColumn = TableColumn<Contact,String>("Nome")
        nomeColumn.prefWidth = MainApp.widthApp / 2
        nomeColumn.cellValueFactory = PropertyValueFactory<Contact,String>("name")


        val numeroColumn = TableColumn<Contact,String>("Número")
        numeroColumn.prefWidth = MainApp.widthApp / 2
        numeroColumn.cellValueFactory = PropertyValueFactory<Contact,String>("phone")

        tableContacts.columns.addAll(nomeColumn,numeroColumn)

        subBox.children.addAll(buttonNewContact,buttonRemoveContact,labelNumberContacts)
        boxView.children.addAll(subBox,tableContacts)
        children.add(boxView)

        mainView.mainRoot.children.add(this)
    }

    private fun setEvents(controller : MainController){
        buttonNewContact.onAction = controller.newContactEvent()
        buttonRemoveContact.onAction = controller.removeContactEvent()
    }

}