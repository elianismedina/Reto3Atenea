<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Message;
import com.example.demo.Repositorio.CRUD.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> findAll(){
    
        return (List<Message>) messageCrudRepository.findAll();
        
    }
    
    public Optional<Message> getMessage(int id){
    
        return messageCrudRepository.findById(id);
                
    }
    
    public Message save(Message message){
    
        return messageCrudRepository.save(message);
        
    }
    
    public void delete(Message message){
    
        messageCrudRepository.delete(message);
    }
    
}

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Message;
import com.example.demo.Repositorio.CRUD.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> findAll(){
    
        return (List<Message>) messageCrudRepository.findAll();
        
    }
    
    public Optional<Message> getMessage(int id){
    
        return messageCrudRepository.findById(id);
                
    }
    
    public Message save(Message message){
    
        return messageCrudRepository.save(message);
        
    }
    
    public void delete(Message message){
    
        messageCrudRepository.delete(message);
    }
    
}

>>>>>>> 462cba8d4b12d42ef7db8f5ad90cf17de912f05a
