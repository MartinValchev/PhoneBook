package bg.java.book.address;

public class RegexTester {
	private static final String REGEX = "((\\+3592)|(0)|(00359))((87)|(88)|(89))([2-9]{1})([0-9]{6})";
	
	public boolean isNumberValid(String telephoneNumber){
		if(telephoneNumber == null){
			return false;
		}
		return telephoneNumber.matches(REGEX);
	}
	public static void main(String[] args){
		RegexTester tester = new RegexTester();
		System.out.println(tester.isNumberValid(""));
	}
}
