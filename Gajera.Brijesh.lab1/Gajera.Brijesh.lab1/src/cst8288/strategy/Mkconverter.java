/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class Mkconverter implements IConverterStrategy {

     double miles;
        
    @Override
    public double converter(double Kilometers) {
        return Kilometers = miles * 1.6 ;
    }
}
