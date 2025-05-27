package com.example.util;

import javax.persistence.*;

public class JpaUtil {
    // cria uma fabrica de EntityManager
    private static EntityManagerFactory factory;

    static{
        // Retorna uma fabíca de EntityManager de acordo o persistence.xml
        factory = Persistence.createEntityManagerFactory("IFBA-PU");
    }

    // Este método retorna um EntityManager
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

    // Ao encerrar a aplicação a f´brica é fechada
    public static void close(){
        factory.close();
    }



}
