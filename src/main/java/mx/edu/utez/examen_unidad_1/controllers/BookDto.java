package mx.edu.utez.examen_unidad_1.controllers;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String name;
    private String isbn;
    private String nombreAutor;
    private String apellidoAutor;
    private String categoria;
    private Integer paginas;
    LocalDate fechaDePublicacion;


}
