/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class Haconverter implements IConverterStrategy  {
    double acres;
    @Override
    public double converter(double hectares) {
     return hectares = acres * 2.47;    
    }
    
}
