/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity.test;

import blog.entity.Article;
import blog.entity.Commentaire;
import blog.entity.Utilisateur;
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
        em.getTransaction().begin();
        
        //Utilisateur
        Utilisateur util = new Utilisateur(1L);
        em.persist(util);
        
        Utilisateur util2 = new Utilisateur(2L);
        em.persist(util2);
        
        Utilisateur util3 = new Utilisateur(3L);
        em.persist(util3);
        
        //article
        Article article1 = new Article(1L, util);
        em.persist(article1);
        
        Article article2 = new Article(2L, util2);
        em.persist(article2);
        
        Article article3 = new Article(3L, util2);
        em.persist(article3);
        //commentaire
        Commentaire com = new Commentaire(1L, article1);
        em.persist(com);
        
        Commentaire com2 = new Commentaire(2L, article2);
        em.persist(com2);
        
        Commentaire com3 = new Commentaire(3L, article2);
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
        Assert.assertEquals(2, art.getCommentaires().size());
    }
    
    @Test
    public void articleUtilisateurOK() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Utilisateur util = em.find(Utilisateur.class, 2L);
        Article art = em.find(Article.class, 2L);
        Assert.assertTrue(util.getArticles().contains(art));
    }
    
    @Test
    public void compteArticleUtilisateurOK(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        Utilisateur util = em.find(Utilisateur.class, 2L);
        Assert.assertEquals(2, util.getArticles().size());
    }
}
