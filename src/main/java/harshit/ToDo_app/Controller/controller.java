package harshit.ToDo_app.Controller;

import harshit.ToDo_app.Service.service;
import harshit.ToDo_app.Model.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class controller {
    @Autowired
    service service;
    @GetMapping("all")
    public List<ToDo> getAll() {
        return service.getAll();
    }
    @GetMapping("id/{id}")
    public ToDo getById(@PathVariable int id) {
        return service.getById(id);
    }
    @PutMapping("add")
    public String add(@RequestBody ToDo todo) {
        return service.add(todo);
    }
    @DeleteMapping("delete/{id}")
    public String del(@PathVariable int id)
    {
        return service.delete(id);
    }
    @PostMapping("update/{id}")
    public String update(@PathVariable int id, @RequestBody ToDo todo) {
        return service.update(id, todo);
    }
}
