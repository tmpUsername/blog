/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity.test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author admin
 */
public class BlogTest {

    @BeforeClass
    public static void genere() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        //On vide la base
        em.getTransaction().begin();
        em.createQuery("DELETE FROM NumSecu n").executeUpdate();
        em.createQuery("DELETE FROM Article a").executeUpdate();
        em.createQuery("DELETE FROM Page p").executeUpdate();
        em.createQuery("DELETE FROM Message m").executeUpdate();
        em.createQuery("DELETE FROM Commentaire c").executeUpdate();
        em.createQuery("DELETE FROM Utilisateur u").executeUpdate();
        em.getTransaction().commit();
        
        //on genere la base
        em.getTransaction().begin();
        
    }
    
    @Test
    public void commentaireArticleOK(){
        
    }
}
