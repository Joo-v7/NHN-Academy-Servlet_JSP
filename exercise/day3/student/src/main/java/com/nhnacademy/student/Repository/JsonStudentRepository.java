package com.nhnacademy.student.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.student.Student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;

    private static final String JSON_FILE_PATH="/Users/joo/Servlet-Jsp/exercise/day3/student/src/main/json/student.json";

    public JsonStudentRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        File file = new File(JSON_FILE_PATH);

        if(file.exists()) {
            file.delete();
        }
    }

    private synchronized List<Student> readJsonFile() {
        File file = new File(JSON_FILE_PATH);
        List<Student> students = new ArrayList<>();

        if(!file.exists()) {
            return students;
        }

        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ){
            students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>(){});
            return students;
        }catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<Student> studentList) {
        File file = new File(JSON_FILE_PATH);

        try(
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ){
            objectMapper.writeValue(bufferedWriter, studentList);
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Student student) {
        List<Student> students = readJsonFile();
        students.add(student);
        writeJsonFile(students);
    }

    @Override
    public void update(Student student) {
        List<Student> students = readJsonFile();
        for(int i=0; i<students.size(); i++) {
            Student list = students.get(i);
            if(list.getId().equals(student.getId())) {
                students.set(i, student);
            }
        }
        writeJsonFile(students);
    }

    @Override
    public void deleteById(String id) {
        List<Student> students = readJsonFile();
        try{
            Student target = new Student();
            for(Student student : students){
                if(student.getId().equals(id)){
                    target = student;
                }
            }
            students.remove(target);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        List<Student> students = readJsonFile();
        for(Student student : students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
        List<Student> students = readJsonFile();
        return students;
    }

    @Override
    public boolean existById(String id) {
        List<Student> students = readJsonFile();
        for(Student student : students){
            if(student.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
}
