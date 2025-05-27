package com.example;

import javax.persistence.EntityManager;

import com.example.model.Categoria;
import com.example.repository.CategoriaReposity;
import com.example.util.JpaUtil;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        CategoriaReposity catRep = new CategoriaReposity();
        Categoria c = new Categoria("ALIMENTACAO");
        Categoria c1 = new Categoria("LIMPEZA");
        Categoria c2 = new Categoria("TESTE");
        catRep.inserir(c);
        catRep.inserir(c1);
        catRep.inserir(c2);
        System.out.println(catRep.listarTodos());
        Categoria alt = catRep.buscarPorId(3);
        alt.setNome("APAGME");
        catRep.alterar(alt);
        System.out.println(catRep.listarTodos());
        catRep.excluir(alt);
        System.out.println(catRep.listarTodos());

    }
}