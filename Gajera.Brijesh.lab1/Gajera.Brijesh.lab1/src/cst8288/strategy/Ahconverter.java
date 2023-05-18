/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class Ahconverter implements IConverterStrategy  {
    double hectares;
    @Override
    public double converter(double acres) {
      return acres = hectares * 0.405;  
    }
    
}
