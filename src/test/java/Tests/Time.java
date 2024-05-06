package Tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");  
		 LocalDateTime now = LocalDateTime.now();  
		 System.out.println(dtf.format(now)); 

	}

}
