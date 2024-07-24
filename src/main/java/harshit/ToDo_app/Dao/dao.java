package harshit.ToDo_app.Dao;

import harshit.ToDo_app.Model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dao extends JpaRepository<ToDo, Long> {
    ToDo findById(int id);
    void deleteById(long id);
}
