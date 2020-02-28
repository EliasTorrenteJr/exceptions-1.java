package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner s = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = s.nextInt();
		System.out.print("Checki-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(s.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(s.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: CHeck-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Checki-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(s.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(s.next());
			
			String error = reservation.updataDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
						
		}
			
		
		s.close();
		
	}

}
