package mx.edu.utez.examen_unidad_1.models.author;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private String name;
    private String lastname;

    @Override
    public String toString() {
        return name + " " + lastname;
    }
}
