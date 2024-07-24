package harshit.ToDo_app.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import harshit.ToDo_app.Model.ToDo;
import org.springframework.stereotype.Service;
import harshit.ToDo_app.Dao.dao;

import java.util.ArrayList;
import java.util.List;

@Service
public class service {
    @Autowired
    dao dao;

    public List<ToDo> getAll() {
        List<ToDo> toDos = new ArrayList<>();
         dao.findAll().forEach(toDo -> toDos.add(toDo));
         return toDos;
    }

    public ToDo getById(int id) {
        return dao.findById(id);
    }

    public String add(ToDo todo) {
        dao.save(todo);
        return "Saved";
    }
    public String delete(int id) {
        dao.deleteById((long) id);
        return "Deleted";
    }

    @Transactional
    public String update(int id, ToDo todo) {
       ToDo a= dao.findById(id);
       a.setTitle(todo.getTitle());
       a.setDt(todo.getDt());
       a.setStat(todo.getStat());
       dao.save(a);
       return "Successfully updated";
    }
}
