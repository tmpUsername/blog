/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity.test;

import blog.entity.Article;
import blog.entity.Commentaire;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import junit.framework.Assert;
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
        
        //article
        em.getTransaction().begin();
        Article article1 = new Article();
        article1.setId(1L);
        em.persist(article1);
        
        Article article2 = new Article();
        article2.setId(2L);
        em.persist(article2);
        
        Article article3 = new Article();
        article3.setId(3L);
        em.persist(article3);
        //commentaire
        Commentaire com = new Commentaire();
        com.setId(1L);
        com.setArticle(article1);
        article1.getCommentaires().add(com);
        em.persist(com);
        
        Commentaire com2 = new Commentaire();
        com2.setId(2L);
        com2.setArticle(article2);
        article2.getCommentaires().add(com2);
        em.persist(com2);
        
        Commentaire com3 = new Commentaire();
        com3.setId(3L);
        com3.setArticle(article2);
        article2.getCommentaires().add(com3);
        em.persist(com3);
        
        //termine
        em.getTransaction().commit();
    }

    @Test
    public void commentaireArticleOK() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Article art = em.find(Article.class, 2L);
        Commentaire com = em.find(Commentaire.class, 2L);
        Assert.assertTrue(art.getCommentaires().contains(com));
    }
    
    @Test
    public void compteCommentaireArticleOK(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Article art = em.find(Article.class, 2L);
        Assert.assertEquals(art.getCommentaires().size(), 2);
    }
}
