package mephi.b22901.ae.lab1;


public class Lab1 {

    public static void main(String[] args) {
        
        // Создаем экземпляр графического интерфейса
        MainGui guiView = new MainGui();

        // Создаем контроллер и передаем ему ссылку на GUIView
        new GuiController(guiView);
       
    }
}
