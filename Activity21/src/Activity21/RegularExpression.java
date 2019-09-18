package Activity21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	
	public static void main(String[] args) {
		
		RegularExpression re = new RegularExpression();

//		// . -> chỉ được phép 1 ký tự trước ký tự s
//		System.out.println("---------------------------------------------------");
//		re.CheckRegex(".s", "is");
//
//		// bất cứ chuỗi nào miễn có 1 ký tự s
//		System.out.println("---------------------------------------------------");
//		re.CheckRegex("s", "iss");
//		
//		// số điện thoại có 10 chữ số, đầu số phải là 09
//		System.out.println("---------------------------------------------------");
//		re.CheckRegex("09[0-9]{8}", "0938798009"); // success
//		re.CheckRegex("09[\\d]{8}", "0938798009"); // success
//		re.CheckRegex("09[\\d]{8}", "093879800"); // false
//		re.CheckRegex("09[\\d]{8}", "093879800X"); // false
//		
//		// địa chỉ email, độ dài đuôi mở rộng từ 2 đến 3 ký tự
//		System.out.println("---------------------------------------------------");
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "email@gmail.com"); // success
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "user01@gmail.com"); // success
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "@."); // false
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "email"); // false
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "email@gmail.c"); // false
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z0-9]+.[a-zA-Z]{2,3}", "email@gmail.c33"); // false
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z]+.[a-zA-Z]{2,3}", "email@gmail.comx"); // false
//		re.CheckRegex("[a-zA-Z0-9]+@+[a-zA-Z]+.[a-zA-Z]{2,3}", "email@gmail1.comx"); // false
//
//		System.out.println("---------------------------------------------------");
//		Matcher m = re.CheckRegex("Java", "Programming in Java. This is Java tutorial."); // success
//		re.Find(m);
//
//		System.out.println("---------------------------------------------------");
//		m = re.CheckRegex("[a]+", "Programming in aa Java. This is Java tutorial."); // success
//		re.Find(m);

//		System.out.println("---------------------------------------------------");
//		Matcher m = re.CheckRegex("[abc]+", "abccc"); // success

		Pattern p = Pattern.compile("(abc)+");		
		Matcher m = p.matcher("abcccabc");
		while(m.find())
		{
			System.out.println("--------");
			System.out.println("group:" + m.group());
			System.out.println("start:" + m.start());
			System.out.println("end:" + m.end());
		}
	}
	
	public Matcher CheckRegex(String regex, String input) {
		Pattern p = Pattern.compile(regex);		
		Matcher m = p.matcher(input);		
		boolean flag = m.matches();
		
		System.out.println("Regex: '" + regex + "' | Input: '" + input + "' => " + flag);
		
		return m;
	}
	
	public void Find(Matcher m) {
		while(m.find())
		{
			System.out.println("--------");
			System.out.println("group:" + m.group());
			System.out.println("start:" + m.start());
			System.out.println("end:" + m.end());
		}
	}

}
