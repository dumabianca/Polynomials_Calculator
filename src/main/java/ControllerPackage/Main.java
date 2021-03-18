package ControllerPackage;

import DataModels.Model;
import ControllerPackage.Controller;
import ViewPackage.View;

public class Main {
    public static void main(String[] args)
    {
        View view= new View();

        Model model= new Model();
        Controller controller= new Controller(view, model);

        view.setVisible(true);


    }
}
