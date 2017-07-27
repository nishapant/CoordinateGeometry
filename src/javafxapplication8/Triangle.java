/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;


/**
 *
 * @author pant9060
 */
public class Triangle {
    private double x1,x2,x3,y1,y2,y3;
    private double a,b,c;
    public double area, perimeter;
    private String triangle;
    
    public Triangle(String point1, String point2, String point3){ //constructor that gets all the input coordinates
        //and changes them into integers so the data can be manipulated.
        int comma = point1.indexOf(",");
        x1 = Integer.parseInt(point1.substring(1,comma));
        y1 = Integer.parseInt(point1.substring(comma+1,point1.length() - 1));
        comma = point2.indexOf(",");
        x2 = Integer.parseInt(point2.substring(1,comma));
        y2 = Integer.parseInt(point2.substring(comma+1,point2.length() - 1));
        comma = point3.indexOf(",");
        x3 = Integer.parseInt(point3.substring(1,comma));
        y3 = Integer.parseInt(point3.substring(comma+1,point3.length() - 1));
    }
    
    public void calcDistance(){ //cacluates the distance of all the sides and sets them equal to variables a, b and c 
        //where c is the hypotenuse. this is done so it can be easily used in the pythagorean theorem.
        double distance1 = Math.sqrt(Math.pow((x2-x1),2)+ Math.pow((y2-y1), 2));
        double distance2= Math.sqrt(Math.pow((x3-x2),2)+ Math.pow((y3-y2), 2));
        double distance3 = Math.sqrt(Math.pow((x3-x1),2)+ Math.pow((y3-y1), 2));
        if ((distance1>=distance2) && (distance1 >= distance3)){
            c = distance1;
            b= distance2;
            a = distance3;
        }else if ((distance2 >= distance3) && (distance2 >= distance1)){
            c = distance2;
            b=distance1;
            a=distance3;
        }else{
            c=distance3;
            a=distance1;
            b=distance2;
        }
    }
    public String compareDistance(){ //uses the pythagorean theorem to figure out where the triangle is right,
        //acute or obtuse. it also compares the length of the sides to create a more specific name of the triangle
        //like scalene or isoceles.
        String angle;
        String length;
        if(Math.abs(Math.pow(c,2)-(Math.pow(a,2)+Math.pow(b, 2)))< 0.00001){ //This will still return true if there is a 
            //floating point error and the numbers are very close
            angle = "Right";
            triangle = "right" ;
        }else if (Math.pow(a,2)+Math.pow(b, 2)> Math.pow(c,2)){
            angle = "Acute";
        }else if (Math.pow(a,2)+Math.pow(b, 2)> Math.pow(c,2)){
            angle = "Obtuse";
        }
        else{
            angle = ""; //it is an equilateral triangle
        }
        
        if((Math.abs(a-b)< 0.00001) || (Math.abs(a-c)< 0.00001) || (Math.abs(b-c)< 0.00001)){
            length = "Isoceles";
            if(a==b && b==c){
                length = "Equilateral";
                triangle = "equilateral";
            }
        }else {
            length = "Scalene";
        }
        return(angle  + " " + length + " Triangle");
    }
    
    public String calcArea(){ //this calculates the area of the triangle. it checks whether it is an
        // equilateral or right triangle because to get the area of an equilateral triangle, the midpoint has to be 
        // found to draw the perpendicular bisector for the height.
        switch (triangle) {
            case "equilateral":
                double midpoint1 = (x2+x3)/2;
                double midpoint2 = ((y2+y3)/2);
                double length = Math.sqrt(Math.pow((midpoint1-x1),2)+ Math.pow((midpoint2-y1), 2));
                area = (length * b)/2;
                return Double.toString(Math.round(area*10.0)/10.0);
            case "right":
                area = (a*b)/2;
                return Double.toString(Math.round(area*10.0)/10.0);
            default:
                return "";
        }
        
        
    }
    
    public String calcPerimeter(){ //This calculates the perimeter of the traingle by adding the distances of each side
        perimeter = a + b + c;
        return Double.toString(Math.round(perimeter*100.0)/100.0);
        
    }
    
}
