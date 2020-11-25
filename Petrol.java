package university;

import java.util.Scanner;
public class Petrol
{
	/*
	 * Author - Noy Swisa 318851821
	 * The program gets car's fuel consumption by the real(double type) number of miles/gallon.
	 * then, calculate and print the car's fuel consumption by the number of liters/100km.
	 * We assume that the input is correct and that real-positive numbers are entered.
	 */
	public static void main(String[] args)
	{
		
		//final parameters
		final double MILE_TO_KM = 1.609;
		final double GALLON_TO_LITERS = 3.785;
		final int MAX=100;
		final int AMOUNT_OF_KM = 100 ;
		
		//get user input - number of miles/gallon
		System.out.println("Please enter the car's petrol consumption "+
		"measured in miles/gallon: ");
		Scanner scan = new Scanner(System.in) ;
		double milesPerGallon = scan.nextDouble();
		
		//calculation - 
		double kmPerGallon = milesPerGallon * MILE_TO_KM ; // transfer miles to km
		double kmPerLiter =  GALLON_TO_LITERS / kmPerGallon ; // transfer gallon to liter
		double kmPer100Liter = AMOUNT_OF_KM * kmPerLiter ;
		
		//rounding the result - two numbers after the dot
		double beforeRounding = kmPer100Liter ; 
		double afterRounding = Math.round(beforeRounding*MAX)/(MAX*1.0);
		kmPer100Liter = afterRounding ; 
		
		//print the answer
		System.out.println("The car's petrol consumption converted " +
		"to liters/100km is: \n" + kmPer100Liter);

		
	}//end of method main

}//end of class Petrol
