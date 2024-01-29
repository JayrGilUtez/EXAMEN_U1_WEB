package mx.edu.utez.examen_unidad_1.models.Generator;

import java.util.Random;

public class FolioGenerator {
//    String nombreLibro;
//    String nombreAutor;
//    String apellidoAutor;
//    String fecha;
//    String isbn;

    public static void main(String[] args) {
        FolioGenerator folioGenerator = new FolioGenerator();
        String folio =  folioGenerator.generateFolio("Harry Potter","JK","Rowling","2002-01-12","KDSHJFWER23");
        System.out.println(folio.toUpperCase());
        String fecha = "2002-12-12";

        System.out.println(fecha.substring(0,4) + fecha.substring(5,7)+ fecha.substring(8,10));

//        String nombreCompleto = "Jayr gil";
//        String nombre = nombreCompleto.substring(0,nombreCompleto.indexOf(" "));
//        String apellido = nombreCompleto.substring(nombreCompleto.indexOf(" "));
//        System.out.println(nombre);
//        System.out.println(apellido);

    }



    public String generateFolio(String nombreLibro, String nombreAutor, String apellidoAutor, String fecha, String isbn ){
        Random randomLetter = new Random();
        Random randomNumber = new Random();
        char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String folio = nombreLibro.substring(0,1)
                + nombreAutor.substring(0,1)
                + apellidoAutor.substring(0,2)
                + fecha + isbn.substring(0,4)
                + letters[randomLetter.nextInt(26)]
                + randomNumber.nextInt(10);

        return folio.toUpperCase();



    }

}
