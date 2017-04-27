package bg.java.book.address;

public interface PhoneBook {
	public void addRecord(String name,String telephoneNumber);
	public void removeRecord(String name);
	public String getTelephoneNumber(String name);
	public void printPhoneBook(); 
}
