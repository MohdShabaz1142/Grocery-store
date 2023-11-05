package com;
import java.util.Scanner;
public class Solution 
{

	public static void main(String[] args) 
	{
		System.out.println("welcome to Deprtmental project");
		System.out.println("********************************");

		Scanner sc= new Scanner(System.in);

		//upcasting
		DepartmentalStore store=new DepartmentalStoreimpl();

		store.addproduct();//method call

		int choice=1;

		while(choice==1)
		{
			store.displayproduct(); 
			store.buyproducts();
			System.out.println("press 1 to continue or press any other key to checkout:");
			choice=sc.nextInt();
			System.out.println("--------------------------------------------------------");
		}
		store.checkout();






	}
}
