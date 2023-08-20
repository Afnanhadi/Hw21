package com.example.hw21.Controller;

import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    private ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.AddTeacher(teacher);
        return ResponseEntity.status(200).body("add Teacher");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity UpdateTeacher(@RequestBody @Valid Teacher teacher, @PathVariable Integer id){
       teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("Update Product");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable  Integer id){
       teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Delete Teacher");
    }

}
