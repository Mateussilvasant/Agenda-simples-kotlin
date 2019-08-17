package view

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class MainForm(mainApp: MainApp) {

    var mainView : MainApp = mainApp
    var buttonNewContact : Button = Button()
    var buttonRemoveContact : Button = Button()
    var labelNumberContacts : Label = Label()
    lateinit var tableContacts : TableView<String>
    var boxView : VBox = VBox()

    fun initUI() {
        var subBox : HBox = HBox()
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

        var nomeColumn = TableColumn<String,String>("Nome")
        nomeColumn.prefWidth = MainApp.widthApp / 2
        var numeroColumn = TableColumn<String,String>("Número")
        numeroColumn.prefWidth = MainApp.widthApp / 2

        tableContacts.columns.addAll(nomeColumn,numeroColumn)

        subBox.children.addAll(buttonNewContact,buttonRemoveContact,labelNumberContacts)
        boxView.children.addAll(subBox,tableContacts)
        mainView.mainRoot.children.add(boxView)
    }

}