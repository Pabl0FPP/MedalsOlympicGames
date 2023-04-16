import exceptions.IncorrectInputException;
import model.Country;
import model.CountryMedals;

import java.io.IOException;
import java.util.*;
public class Menu {

    Scanner sc=new Scanner(System.in);

    CountryMedals countryMedals=new CountryMedals();


    public void menu() throws IOException {

        boolean exit=false;
        int option=0;

        while(!exit) {
            System.out.println("1. Ingresar un país\n" +
                    "2. Mostrar medallería\n" +
                    "3. Mostrar total de medallas\n" +
                    "4. Mostrar países\n" +
                    "5. Salir");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    try {
                        input();
                    }catch (IncorrectInputException e){
                        e.printStackTrace();
                    }
                    countryMedals.save();
                    break;
                case 2 :
                    countryMedals.showMedals();
                    break;
                case 3 :
                    countryMedals.showTotalMedals();
                    break;
                case 4 :
                    countryMedals.showCountries();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Digite una opción correcta");
                    break;
            }
        }

    }

    public void input() throws IncorrectInputException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese los datos de la siguiente manera:");
        System.out.println("Nombre del pais++No. de medallas de oro++ No. de medallas de silver ++ No. de medallas de bronze");
        String input = sc.nextLine();
        String[] data = input.split("\\+\\+");
        countryMedals.getCountries().add(
                new Country(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3])));
    }




}
