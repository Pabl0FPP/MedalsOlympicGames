package model;

import com.google.gson.Gson;
import exceptions.IncorrectInputException;

import java.io.*;
import java.util.*;

public class CountryMedals {

    private ArrayList<Country> countries=new ArrayList<>();

    static String folder="Medalsdata";

    static String path = "MedalsData/MedalsData.txt";


    public CountryMedals(){
        this.countries = countries;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }



    public void showMedals(){
        if(countries!=null){
            Collections.sort(countries);

            countries.forEach(country -> {
                System.out.println(country.getName()+" / "+country.getGoldM()+ " medallas de oro / "+country.getSilverM()+" medallas de plata / "+country.getBronzeM()+ " medallas de bronce");
            });

        }else System.out.println(" La tabla de medallas esta vacia(No hay paises registrados) ");

    }

    public void showTotalMedals(){

        if(countries!=null){
            Collections.sort(countries, Comparator.comparingInt(Country::getTotalMedals));
            Collections.reverse(countries);

            countries.forEach(country -> {
                System.out.println(country.getName()+ " Total de medallas: "+country.getTotalMedals());
            });

        }else System.out.println(" La tabla de medallas esta vacia(No hay paises registrados) ");

    }

    public void showCountries(){
        selectionSort(countries);
        countries.forEach(country ->{
            System.out.println(country.getName());
        });
    }

    public static void selectionSort(ArrayList<Country> array){

        //rojo
        for(int i = 0 ; i < array.size()-1 ; i++){

            //azul
            for(int j = i+1 ; j < array.size() ; j++){

                if(array.get(j).getName().compareTo(array.get(i).getName())<0){
                    Country valorAzul= array.get(j);
                    Country valorRojo= array.get(i);
                    //array[j-1]=array[i];
                    array.set(j, valorRojo);
                    array.set(i, valorAzul);
                }
            }
        }
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);

        Gson gson=new Gson();
        String data=gson.toJson(countries);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();
        fos.close();

    }

    public void load() throws IOException {
        File file=new File(path);
        if (file.exists()) {

            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String content = "";
            String line = "";

            while ((line = reader.readLine()) != null) {
                //leer linea por linea
                content += line + "\n";
            }
            System.out.println("Se cargo lo siguiente:");
            System.out.println(content);
            Gson gson=new Gson();
            Country[] array=gson.fromJson(content, Country[].class);

            countries.addAll(Arrays.asList(array));
            fis.close();
        }else{
            File f= new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

}



