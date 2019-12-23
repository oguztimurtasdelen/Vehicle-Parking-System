import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkStatus
{
	String carPlate;
	private String fullName;
	private String phoneNumber;
	private String eMail;
	String place;
	String entryTime = getDateTime();
	String getDateTime()
	{
		DateFormat dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		Date date = new Date();
		return dateTimeFormat.format(date);
		
	}
	
	
	
	
	
	public String getCarPlate() 
	{
		return carPlate;
	}
	public void setCarPlate(String carPlate) 
	{
		this.carPlate = carPlate;
	}
	
	
	
	public String getFullName() 
	{
		return fullName;
	}
	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}
	
	
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public String geteMail() 
	{
		return eMail;
	}
	public void seteMail(String eMail) 
	{
		this.eMail = eMail;
	}
	
	
	
	public String getPlace() 
	{
		return place;
	}
	public void setPlace(String place) 
	{
		this.place = place;
	}
	
	
	
	public String getEntryTime() 
	{
		return entryTime;
	}
	public void setEntryTime(String entryTime) 
	{
		this.entryTime = entryTime;
	}
	

}
