package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do checkIn (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do checkOut (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.print("Erro de reserva: A data de chackOut deve ser após a data do checkIn");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva " + reserva);

			System.out.println();
			System.out.println("Entre com a nova data para reserva:");
			System.out.print("Data do checkIn (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do checkOut (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			String error = reserva.AtualizaçãoDaData(checkIn, checkOut);
			if (error != null) {
				System.out.println("Reserva: " + error);
			} else {
				System.out.println("Reserva: " + reserva);
			}
		}

		sc.close();

	}

}
