package com.cog.service;

import com.cog.exception.StudentNotFound;
import com.cog.model.Admin;
import com.cog.model.Student;
import com.cog.repository.AdminRepo;
import com.cog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private StudentRepository srepo;
    @Autowired
    private AdminRepo arepo;

    public Student save(Student s) {
        if (srepo.findByEmail(s.getEmail()).isPresent())
            throw new StudentNotFound("Email Address is Already Registered !😣😫");
        return srepo.save(s);
    }

    public Student find(int id) throws StudentNotFound {
        if (srepo.findById(id).isPresent()) {
            return srepo.findById(id).get();
        }
        throw new StudentNotFound("Student not found 😣😫");
    }

    public List<Student> findAll() {

        return srepo.findAll();
    }

    public String saveAdmin(Admin a) {
        a.setPassword(passwordEncoder.encode(a.getPassword()));
        arepo.save(a);
        return "Sign up done successfully 😍";
    }


    public String deleteStudent(int id) throws StudentNotFound {

        if (srepo.findById(id).isPresent()) {
            srepo.deleteById(id);
            return "deleted 😂";
        }
        throw new StudentNotFound("Student not found 😥");
    }


}
