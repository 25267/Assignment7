package kz.example.controller;

import kz.example.entity.Moder;
import kz.example.repository.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moder")
public class ModerController {

    @Autowired
    private ModeratorRepository moderatorRepository;

    @GetMapping("")
    public List<Moder> getAllModer(){
        return moderatorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Moder getModerById(@PathVariable("id") Long id){
        return moderatorRepository.findById(id).get();
    }

    @PostMapping("")
    public Moder createModer(@RequestBody Moder moder){
        return moderatorRepository.saveAndFlush(moder);
    }

    @DeleteMapping("/{id}")
    public void deleteModer(@PathVariable Long id) {

        moderatorRepository.deleteById(id);
    }
}
