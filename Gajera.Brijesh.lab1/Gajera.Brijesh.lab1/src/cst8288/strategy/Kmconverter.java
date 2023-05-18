/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class Kmconverter implements IConverterStrategy  {
        double Kilometers;
    @Override
    public double converter(double miles) {
     return miles = Kilometers / (1.6);
     
         

    }
    
}
