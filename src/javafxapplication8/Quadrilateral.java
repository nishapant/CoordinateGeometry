/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import static java.lang.Double.NaN;

/**
 *
 * @author pant9060
 */
public class Quadrilateral {
    private double x1,x2,x3,x4,y1,y2,y3,y4;
    private double slope1, slope2, slope3, slope4;
    private double distance1, distance2, distance3, distance4, area;
    public String quad;
    
    public Quadrilateral(String point1, String point2, String point3, String point4){ //constructor that gets all the 
        //input coordinates and changes them into integers so the data can be manipulated.
        int comma = point1.indexOf(",");
        x1 = Integer.parseInt(point1.substring(1,comma));
        y1 = Integer.parseInt(point1.substring(comma+1,point1.length() - 1));
        comma = point2.indexOf(",");
        x2 = Integer.parseInt(point2.substring(1,comma));
        y2 = Integer.parseInt(point2.substring(comma+1,point2.length() - 1));
        comma = point3.indexOf(",");
        x3 = Integer.parseInt(point3.substring(1,comma));
        y3 = Integer.parseInt(point3.substring(comma+1,point3.length() - 1));
        comma = point4.indexOf(",");
        x4 = Integer.parseInt(point4.substring(1,comma));
        y4 = Integer.parseInt(point4.substring(comma+1,point4.length() - 1));
        
    }
    
    public void calcSlopes(){ //calculates the slopes of each line by doing change in y over change in x. 
        //if the slope is undefined however, the slope is changed to NaN
        slope1 = (y2-y1)/(x2-x1);
        slope2= (y3-y2)/(x3-x2);
        slope3 = (y4-y3)/(x4-x3);
        slope4 = (y4-y1)/(x4-x1);
            
        if ((x2-x1)==0){
            slope1 = NaN;
        } 
        if ((x3-x2)==0){
            slope2 =NaN;
        }
        if ((x4-x3)==0){
            slope3= NaN;
        }
        if ((x4-x1)==0){
            slope4= NaN;
        }

    }
    
    public void calcDistance(){ //calculates the distance of each side of the quadrilateral
        distance1 = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1), 2));
        distance2= Math.sqrt(Math.pow((x3-x2),2)+ Math.pow((y3-y2), 2));
        distance3 = Math.sqrt(Math.pow((x4-x3),2)+ Math.pow((y4-y3), 2));
        distance4 =  Math.sqrt(Math.pow((x4-x1),2)+ Math.pow((y4-y1), 2));
    }
    
    public String compareSlopes(){ //uses the slopes to figure out what type of shape the quadrilateral is. lines with opposite reciprocal slopes
        //are perpendicular and lines with the same slopes are parallel. this is then used to figure out what the quadrilateral is based
        //on properties of quadrilaterals.
        String shape;
        if ((slope1==slope3)||(slope2==slope4)){
            shape = "Trapezoid";
            if((slope1==slope3)&&(slope2==slope4)||(slope1 == 0&& Double.isNaN(slope2))|| (Double.isNaN(slope1) && slope2 == 0)){
                shape = "Parallelogram";
                if((slope1 == (1/slope2)) || (slope1 == 0&& Double.isNaN(slope2))|| (Double.isNaN(slope1) && slope2 == 0)){
                    shape = "Rectangle";
                    quad = "rectangle";
                    if ((Math.abs(distance1-distance2)< 0.00001) && ((Math.abs(distance2-distance3)< 0.00001))){
                        //the doubles are tested for equality by doing this because of floating point errors so this way, it will still
                        //come out as true even if the numbers are 7.9999999 and 8.0 when being tested.
                        shape = "Square";
                        quad = "square";
                    }
                }else if ((Math.abs(distance1-distance2)< 0.00001) && ((Math.abs(distance2-distance3)< 0.00001))){
                    shape = "Rhombus";
                    quad = "rhombus";
                }
            }
        } else{
            shape = "Quadrilateral";
        }
        return shape;
    }
    
    public String calcArea(){ //calculates the area of the quadrilateral by doing base times height for squares and rectangles.
        //for rhombuses, the diagonals are calculated using distance formula and are multipled, then divided by two. 
        switch (quad) {
            case "square":
            case "rectangle":
                area = distance1*distance2;
                return Double.toString(Math.round(area*10.0)/10.0);
            case "rhombus":
                double diagonal1 = Math.sqrt(Math.pow((x3-x1),2)+ Math.pow((y3-y1), 2));
                double diagonal2 = Math.sqrt(Math.pow((x4-x2),2)+ Math.pow((y4-y2), 2));
                area = (diagonal1*diagonal2)/2;
                return Double.toString(Math.round(area*10.0)/10.0);
            default:
                return "";
        }
    }
}