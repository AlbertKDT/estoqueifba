package com.example.repository;

import java.util.List;

import javax.persistence.*;
import com.example.model.Categoria;
import com.example.util.JpaUtil;

public class CategoriaReposity {
    private EntityManager manager;
    
    public CategoriaReposity(){
        manager = JpaUtil.getEntityManager();
    }

    public void inserir(Categoria categoria){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.persist(categoria);
        et.commit();
    }

    public void alterar(Categoria categoria){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.merge(categoria);
        et.commit();
    }

    public void excluir(Categoria categoria){
        EntityTransaction et = manager.getTransaction();
        et.begin();
        manager.remove(categoria);
        et.commit();
    }

    public Categoria buscarPorId(int id){
        return manager.find(Categoria.class, id);
    }

    public List<Categoria> listarTodos(){
        TypedQuery<Categoria> sql = manager.createQuery("from Categoria", Categoria.class);
        return sql.getResultList();
    }
}