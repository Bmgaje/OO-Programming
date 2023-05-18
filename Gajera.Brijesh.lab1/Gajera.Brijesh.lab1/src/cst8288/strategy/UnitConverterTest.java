/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.strategy;



/**
 *
 * @author Brijesh4205
 */
public class UnitConverterTest {
    

    /**
     *
     * @param args command line arguments
     * 
     */
    public static void main(String[] args) {
//		FCconverter FtoC = new FCconverter();
//                System.out.printf("%5.2f in Fahrenheit is %5.2f Celsius\n", 70.0, FtoC.convert(70.0));
//		
//		CFconverter CtoF = new CFconverter();
//		System.out.printf("%5.2f in Celsius is %5.2f Fahrenheit\n", 20.0, CtoF.convert(20.0));
		
//                String strategy = "FtoC";
                UnitConverter unitconverter = new UnitConverter();
                
               
                System.out.printf("%5.2f in Fahrenheit is %5.2f Celsius\n", 70.0,unitconverter.converter(70.0));   
               	System.out.printf("%5.2f in Celsius is %5.2f Fahrenheit\n", 20.0, unitconverter.converter(20.0));
                System.out.printf("%5.2f in Kilometer is %5.2f miles\n", 50.0, unitconverter.converter(50.0));
                System.out.printf("%5.2f in miles is %5.2f Kilometer\n", 69.23, unitconverter.converter(69.23));
                System.out.printf("%5.2f in acres is %5.2f hectares\n", 56.78, unitconverter.converter(56.78));
                System.out.printf("%5.2f in hectares is %5.2f acres\n", 89.36, unitconverter.converter(89.36));
               
                

                   }
	}



