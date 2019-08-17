package view

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.stage.Screen
import javafx.stage.Stage

open class MainApp : Application() {

     lateinit var sceneView: Scene
     lateinit var stage: Stage
     lateinit var mainRoot: StackPane

    companion object {
        val widthApp: Double = Screen.getPrimary().bounds.width * 0.30
        val heightApp: Double = Screen.getPrimary().bounds.height * 0.38
    }

    override fun start(primaryStage: Stage) {
        stage = primaryStage
        initPanel()
        sceneView = Scene(mainRoot)
        stage.isResizable = false
        stage.scene = sceneView
        initUI();
        stage.show()
    }

    fun initUI(){
        MainForm(this).initUI()
    }

    private fun initPanel() {
        var background: Rectangle = Rectangle(Companion.widthApp , Companion.heightApp)
        background.fill = Color.WHITESMOKE
        mainRoot = StackPane(background)
    }


}

fun main(args: Array<String>) {
    Application.launch(MainApp::class.java, *args)
}