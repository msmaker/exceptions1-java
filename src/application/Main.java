package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Numero do Quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do checkIn (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do checkOut (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva " + reserva);

			System.out.println();
			System.out.println("Entre com a nova data para reserva:");
			System.out.print("Data do checkIn (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do checkOut (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reserva.AtualizaçãoDaData(checkIn, checkOut);
			System.out.println("Reserva " + reserva);
			
		} 
		catch (ParseException e) {
			System.out.println("Data invalida: ");
		} 
		catch (DomainException e) {
			System.out.println("Erro de reserva: " + e.getMessage());
		}
		sc.close();

	}

}
