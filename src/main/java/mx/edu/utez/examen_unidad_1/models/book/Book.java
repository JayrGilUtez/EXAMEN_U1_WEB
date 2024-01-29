package mx.edu.utez.examen_unidad_1.models.book;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "books")
@ToString
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "isbn", length = 20, nullable = false, unique = true)
    private String isbn;

    @Column(name = "autor", length = 20, nullable = false)
    private String autor;

    @Column(name = "categoria", length = 20, nullable = false)
    private String categoria;

    @Column(name = "folio", length = 20, nullable = false)
    private String folio;

    @Column(name = "paginas", length = 20, nullable = false)
    private Integer paginas;

    @Column(name = "fecha_publicacion", columnDefinition = "DATE", nullable = false)
    LocalDate fechaDePublicacion;





// instrucciones
    /*
Nombre del Libro: El título del libro.
ISBN: Número Internacional Normalizado del Libro.
Autor: Nombre del autor del libro.
Páginas: Cantidad de páginas que tiene el libro.
Categoría: La categoría a la que pertenece el libro (p. ej., Ciencia Ficción, Historia, Novela, etc.).
Fecha de publicación
Folio (Se genera automáticamente)

     */


}


//<editor-fold desc="Notes">

//<editor-fold desc="Anotations">
/*
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "people")
@ToString
@AllArgsConstructor
@Builder
*/

//</editor-fold>

//<editor-fold desc="id - fechas">
/*
Id:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

Fechas:
    @Column(columnDefinition = "DATE", nullable = false)
    LocalDate birthdate;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NOW()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime createdAt;
*/

//</editor-fold>

//<editor-fold desc="relaciones">
/*
    =========================== OneToOne ======================================
    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;
    ---------------------------------------------------------------------------
    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties(value = {"person"})
    private User user;
    =========================== OneToOne ======================================


    =========================== ManyToMany ====================================
     @ManyToMany
         @JoinTable(
                 name = "user_roles",
                 joinColumns = @JoinColumn(name = "role_id"),
                 inverseJoinColumns = @JoinColumn(name = "user_id")
         )
         @JsonIgnore
         private Set<User> users;
     --------------------------------------------------------------------------
     @ManyToMany(mappedBy = "users")
         private Set<Role> roles;

    =========================== ManyToMany ====================================



    =========================== ManyToOne =====================================

      @ManyToOne
         @JoinColumn(name = "FK_INVOICE", nullable = false, updatable = false)
         private Invoice invoice;
    ----------------------------------------------------------------------------
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
         private List<InvoiceLine> lines;

    =========================== ManyToOne =====================================

*/

//</editor-fold>

//<editor-fold desc="Repository">
/*
Repository:

   @Repository
   public interface PersonRepository extends JpaRepository<Person, Long> {
       @Query("SELECT P FROM Person P WHERE P.curp = ?1")
       Person findPersonByCurp(String curp);

   }
*/

//</editor-fold>

//<editor-fold desc="Service">
/*
Service:

@Service
@Transactional
public class PersonService {
    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Transactional(readOnly = true)
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
    @Transactional
    public Person save(PersonDto personDto) {
        Person person = Person.builder()
                .name(personDto.getName())
                .surname(personDto.getSurname())
                .lastname(personDto.getLastname())
                .birthdate(personDto.getBirthDate())
                .curp(personDto.getCurp())
                .build();
        return personRepository.save(person);
    }
    @Transactional(readOnly = true)
    public List<Person> findAll(){
        return personRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Person findByCurp(String curp){
        return personRepository.findPersonByCurp(curp);
    }

}

*/

//</editor-fold>

//<editor-fold desc="Controller">
/*
Controller:

@RestController
@RequestMapping("/api/v1/person")
@CrossOrigin(origins = {"*"})
public class PersonController {
    private final PersonService service;
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Optional<Person> getOneById(@PathVariable Long  id){
        return service.findById(id);
    }

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.POST)
    public Person save(@RequestBody PersonDto personDto){
        return service.save(personDto);
    }

    @GetMapping("/getAll")
    public List<Person> findAll(){
       return service.findAll();
    }

    @GetMapping("/curp/{curp}")
    public Person findByCurp(@PathVariable String curp){
        return service.findByCurp(curp);
    }

}
*/

//</editor-fold>

//</editor-fold>
