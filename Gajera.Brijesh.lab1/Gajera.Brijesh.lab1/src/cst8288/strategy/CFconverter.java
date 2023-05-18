/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;

/**
 *
 * @author Brijesh4205
 */
public class CFconverter implements IConverterStrategy {
    private final double convFactor=1.8;
	private final double convOrigin=32.0;
	/**
	 * @param celsius value in Celsius to be converted
	 * @return equivalent in Fahrenheit
	 */
    
    
    public double converter(double celsius) {
      return celsius*convFactor + convOrigin;
    }

    
}
