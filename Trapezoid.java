package university;

import java.util.Scanner;

public class Trapezoid {
	/*
	 * Author - Noy Swisa 318851821
	 * The program gets 6 numbers of type int.
	 * The first two numbers will indicate the left point coordinate of one trapezoid base.
	 * the third number is the lenght of this base.
	 * The 4th and 5th will indicate the left point coordinate of the other trapezoid base.
	 * the 6th number is the lenght of this base.
	 * the program will calculate and print trapezoid's are and perimeter.
	 * 
	 */
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int x1;
		int y1;
		int len1;
		int x2;
		int y2;
		int len2;
		
		//gets first 3 numbers
		System.out.println("Please enter the left point coordinates of the base "+
				"followed by its length : ");
				
		x1 = scan.nextInt();
		y1 = scan.nextInt();
		len1 = scan.nextInt();
				
		//gets second 3 numbers		
		System.out.println("Please enter the left point coordinates of the other base "+
						"followed by its length : ");
				
		x2 = scan.nextInt();
		y2 = scan.nextInt();
		len2 = scan.nextInt();
		
		
		int ax = x1; //x,y - point A of trapezoid
		int ay = y1;
		
		int bx = x1+len1; //x,y - point B of trapezoid
		int by = y1;
		
		int dx = x2; //x,y - point D of trapezoid
		int dy = y2;
		
		int cx = x2+len2; //x,y - point C of trapezoid
		int cy = y2;
		
		
		//calculating each side of the trapezod
		double topSide=len1;
		double downSide=len2;
		double leftSide=Math.sqrt((Math.pow((ax-dx), 2) + Math.pow((ay-dy), 2)));
		double rightSide=Math.sqrt((Math.pow((bx-cx), 2) + Math.pow((by-cy), 2)));
		double trapeHeight = Math.max(ay, dy) - Math.min(ay,dy) ;
		
		//calculating area and perimeter
		double trapeArea = ((topSide+downSide)*trapeHeight)/2; 
		double trapePer = topSide + downSide + leftSide + rightSide ; 
		
		//printing the answers
		System.out.println("Trapezoid area is : "+ trapeArea);
		System.out.println("Trapezoid perimeter is : "+ trapePer);
		
		
	}//end of method main

}//end of class Trapezoid
