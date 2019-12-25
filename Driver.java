import java.util.Scanner;

public class Driver
{
	static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] args)
	{
		
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
			subInfo.MakeSubscriber();
			
			break;
		
		case 2:
			subInfo.MakeUnsubscriber();
			
			break;
			
		case 3:
			System.out.println("3");
			subInfo.UpdateInfo();
			
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
	
	
}
