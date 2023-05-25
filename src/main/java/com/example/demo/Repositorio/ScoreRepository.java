<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Score;
import com.example.demo.Repositorio.CRUD.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> findAll(){
    
        return (List<Score>) scoreCrudRepository.findAll();
        
    }
    
    public Optional<Score> getScore(int id){
    
        return scoreCrudRepository.findById(id);
                
    }
    
    public Score save(Score score){
    
        return scoreCrudRepository.save(score);
        
    }
    
    public void delete(Score score){
    
        scoreCrudRepository.delete(score);
    }
    
}

=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Repositorio;

import com.example.demo.Modelo.Score;
import com.example.demo.Repositorio.CRUD.ScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;
    
    public List<Score> findAll(){
    
        return (List<Score>) scoreCrudRepository.findAll();
        
    }
    
    public Optional<Score> getScore(int id){
    
        return scoreCrudRepository.findById(id);
                
    }
    
    public Score save(Score score){
    
        return scoreCrudRepository.save(score);
        
    }
    
    public void delete(Score score){
    
        scoreCrudRepository.delete(score);
    }
    
}

>>>>>>> 462cba8d4b12d42ef7db8f5ad90cf17de912f05a
