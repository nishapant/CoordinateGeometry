/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author pant9060
 */
public class GUIController implements Initializable {
    
    @FXML
    private Label label, label1, label2, label3, label4;
    
    @FXML 
    private TextField textfield, textfield1, textfield2, textfield3,textfield4,textfield5,textfield6;
    
    @FXML
    private void handleQuadrilateral(ActionEvent event) { //controls what happens when the quadrilateral button
        //is pressed. it passes all the user inputs into the other classes.
         String coordinate1= textfield.getText();
         String coordinate2 = textfield1.getText() ;
         String coordinate3= textfield2.getText();
         String coordinate4 = textfield3.getText();
         Quadrilateral slopes = new Quadrilateral(coordinate1,coordinate2,coordinate3,coordinate4); 
         slopes.calcSlopes();
         slopes.calcDistance();
         label3.setText(slopes.compareSlopes());
         label4.setText(slopes.calcArea()+ " Units Squared");
         
    }
    
    @FXML
    private void handleTriangle(ActionEvent event) {//controls what happens when the triangle button
        //is pressed. it passes all the user inputs into the other classes.
        String coordinate1= textfield4.getText();
        String coordinate2 = textfield5.getText() ;
        String coordinate3= textfield6.getText();
        Triangle slopesTri = new Triangle(coordinate1,coordinate2,coordinate3);
        slopesTri.calcDistance();
        label.setText(slopesTri.compareDistance());
        label1.setText("Area: "+slopesTri.calcArea()+ " Units Squared");
        label2.setText("Perimeter: "+ slopesTri.calcPerimeter()+ " Units");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
