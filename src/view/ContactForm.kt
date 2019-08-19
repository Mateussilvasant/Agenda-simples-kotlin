package view

import controller.MainController
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.HBox
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox

class ContactForm(mainController: MainController) : StackPane() {

    private var nameLabel : Label = Label()
    var nameField : TextField = TextField()
    private var phoneLabel : Label = Label()
    var phoneField : TextField = TextField()
    private var buttonSaveContact : Button = Button()
    private var buttonCancel : Button = Button()
    private var vboxView : VBox = VBox()
    private var controller : MainController = mainController

    init{
        initUI()
        setEvents(controller)
    }

    private fun setEvents(controller: MainController) {
        buttonSaveContact.onAction = controller.saveContactEvent()
        buttonCancel.onAction = controller.cancelMenuForm()
    }

    private fun initUI() {
        nameLabel.text = "Nome"
        phoneLabel.text = "Telefone"
        buttonSaveContact.text = "Salvar"
        buttonCancel.text = "Cancelar"

        vboxView.padding = Insets(MainApp.widthApp * 0.15)
        vboxView.spacing = MainApp.heightApp * 0.050

        buttonSaveContact.prefWidth = MainApp.widthApp * 0.17
        buttonSaveContact.prefHeight = MainApp.widthApp * 0.05

        buttonCancel.prefWidth = MainApp.widthApp * 0.17
        buttonCancel.prefHeight = MainApp.widthApp * 0.05


        val buttons = HBox(buttonSaveContact,buttonCancel)
        buttons.alignment = Pos.CENTER

        vboxView.children.addAll(VBox(nameLabel,nameField),VBox(phoneLabel,phoneField), buttons)
        children.add(vboxView)
    }

    fun clearFields() {
        phoneField.text = ""
        nameField.text = ""
    }


}