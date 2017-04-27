package bg.java.book.address;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBookImpl implements PhoneBook {
	 private TreeMap<String, String> phoneBook;
	 private ArrayList<String> fileRecords;
	 private File records;
	 private RegexTester regexTester;
	 private TreeMap<Integer, String> callsBook;
	public PhoneBookImpl(File records){
		this.records = records;
		phoneBook = new TreeMap<String, String>();
		callsBook = new TreeMap<Integer, String>();
		fileRecords = new ArrayList<String>();
		regexTester = new RegexTester();
	}
	public void run(){
		readFileRecords();
		addFileRecords();
	}
	public void makeCallOut(String name){
		 Set<Entry<Integer, String>> set = callsBook.entrySet();
	      Iterator<Entry<Integer, String>> iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry<Integer,String> callEntry = (Map.Entry<Integer,String>)iterator.next();
	        if(callEntry.getValue().equals(name)){
	        	int callCount =callEntry.getKey();
	        }
	      }
	}
	private void addFileRecords(){
		for (int i = 0; i < fileRecords.size(); i++) {
			String currentRecord = fileRecords.get(i);
			String[] nameNumbers = currentRecord.split(",");
			String name = nameNumbers[0];
			String phoneNumber =nameNumbers[1];
			boolean isNumberValid =regexTester.isNumberValid(phoneNumber);
			if(isNumberValid){
				phoneBook.put(name, phoneNumber);	
			}
		}
	}
	private void readFileRecords(){
		try {
			Scanner in = new Scanner(new FileReader(records));
			while(in.hasNext()){
				String currentLine = in.nextLine();
				fileRecords.add(currentLine);
			//	String[] nameNumbers = currentLine.split(",");
			//	String name =nameNumbers[0].trim();
			//	String phoneNumber =nameNumbers[1].trim();
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void addRecord(String name, String telephoneNumber) {
		phoneBook.put(name, telephoneNumber);
		
	}

	@Override
	public void removeRecord(String name) {
		phoneBook.remove(name);
		
	}

	@Override
	public String getTelephoneNumber(String name) {
		String telephoneNumber = phoneBook.get(name);
		return telephoneNumber;
	}

	@Override
	public void printPhoneBook() {
		 Set<Entry<String, String>> set = phoneBook.entrySet();
	      Iterator<Entry<String, String>> iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry<String,String> bookEntry = (Map.Entry<String,String>)iterator.next();
	         System.out.println("Name: "+ bookEntry.getKey() + " & Number is: " + bookEntry.getValue());
	      }
		
	}

	
}
