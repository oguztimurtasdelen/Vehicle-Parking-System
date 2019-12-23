import java.sql.Date;
import java.util.Scanner;

public class Driver
{
	static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		Driver dr = new Driver();
		SubscriberInfo subInfo = new SubscriberInfo();
		
		System.out.println("-----VEHICLE PARKING SYSTEM-----");
		System.out.println("");
		System.out.println("MENU");
		System.out.println("1. Subscribe");
		System.out.println("2. Unsubscribe");
		System.out.println("3. Subscription - Subscribed");
		System.out.println("4. Subscription - Unsubscribed");
		System.out.println("5. Administration");
		System.out.print("Choice: ");
		
		int request = scanner.nextInt();
		scanner.nextLine(); //Clear scanner!
		
		switch (request) 
		{
		case 1:
			System.out.print("Enter your car plate: ");
			String carPlate = scanner.nextLine();
			
			System.out.print("Enter your full name: ");
			String fullName = scanner.nextLine();
			
			System.out.print("Enter your phone number: ");
			String phoneNumber = scanner.nextLine();
			
			System.out.print("Enter your e-mail address: ");
			String eMail = scanner.nextLine();
			
			System.out.print("Enter your credit card number: ");
			String creditCardNumber = scanner.nextLine();
			
			String subscriptionDate = "20.12.2019";
			
			
			String subscriptionNumber = dr.passwordCreator();
			
			
			
			
			subInfo.MakeSubscriber(carPlate, subscriptionNumber, fullName, phoneNumber, eMail, creditCardNumber, subscriptionDate);
			
			break;
		
		case 2:
			subInfo.MakeUnsubscriber();
			
			break;
			
		case 3:
			System.out.println("3");
			
			break;
			
		case 4:
			System.out.println("4");
			
			break;
			
		case 5:
			System.out.println("5");
			
			break;
			
		default:
			break;
		}
		
	}
	
	
	private String passwordCreator()
	{
		// Apply encryption to password here!
		
		System.out.print("Please set a subscription number: ");
		String subscriptionNumber = scanner.nextLine();
		System.out.print("Please confirm your subscription number: ");
		String subscriptionNumberConfirmation = scanner.nextLine();
		
		if (subscriptionNumber.length() <= 6 && subscriptionNumber.equals(subscriptionNumberConfirmation) ) 
		{
			return subscriptionNumber;
		}
		else System.out.println("Please follow the conditions to set a password!"); return passwordCreator();
		
	}
	
}
