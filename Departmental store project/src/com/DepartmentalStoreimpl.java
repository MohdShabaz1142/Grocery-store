package com;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DepartmentalStoreimpl implements DepartmentalStore 
{
	Scanner sc=new Scanner(System.in);

	//product id= key-->integer
	//product object is value-->product
	Map<Integer,Products> m=new LinkedHashMap();


	int totalbill=0;

	@Override
	public void addproduct() 
	{
		m.put(1,new Products("choco",10,20));
		m.put(2,new Products("biscuits",20,15));
		m.put(3,new Products("icecream",30,10));

	}

	@Override
	public void displayproduct() 
	{
		Set<Integer> keys= m.keySet();

		for(Integer key:keys)
		{
			Products p=m.get(key);//get(key)return product object based on the key
			System.out.println("enter "+key+ "to order"  +p.getName());
			System.out.println("available quantity:"+p.getQuantity());
			System.out.println("cost: Rs"+p.getCost());
			System.out.println("------------------------------------");
		}

	}

	@Override
	public void buyproducts() 
	{
		System.out.println("enter choice(key) to buy what type of product:");
		int choice=sc.nextInt();

		//getting product based on key(choice)
		Products p = m.get(choice);
		
		//if choice/key is not present,it returns null
		if(p!=null)
		{
			//business logic

			System.out.println("ener the quantity");
			int quantity=sc.nextInt();

			//checking if the quantity is available or not
			if(quantity<=p.getQuantity())
			{
				//calculating the current product cost
				int productcost=quantity * p.getCost();

				//setting the new updated quantity by calling the setter method
				p.setQuantity(p.getQuantity()-quantity);

				//adding the current product cost to total bill
				totalbill=totalbill+productcost;


				System.out.println("orderd  quantity is:"+quantity+" and quantity left with us is: "+p.getQuantity());
				System.out.println("current product cost is Rs:"+productcost);
				System.out.println("your total bill is:"+totalbill);
			}
			else 
			{
				try
				{
					throw new InvalidQuantityexception("invalid quntity kindly enter the valid quantity");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}


			}

		}
		else 
		{
			try
			{
				throw new InvalidChoiceException("invalid choice kindly enter the correct choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void checkout()
	{
		System.out.println("your totalbill is:"+totalbill);
		System.out.println("thank you for shopping with us ");
	}

}
