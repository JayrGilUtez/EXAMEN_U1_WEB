package mx.edu.utez.examen_unidad_1.models.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Transactional
    @Modifying
    @Query("delete from Book b where b.id = ?1")
    void deleteBook(Long id);


}
