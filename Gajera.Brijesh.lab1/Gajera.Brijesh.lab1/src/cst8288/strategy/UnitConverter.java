/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class UnitConverter {
    
private IConverterStrategy convertertype;

public UnitConverter(){
    this.convertertype = new CFconverter();   
}
public double converter(double unit){
return convertertype.converter(unit);
}

public void changeConverter(IConverterStrategy newStrategy){
    this.convertertype = newStrategy;
  // return converter.converter();
}
        
}
