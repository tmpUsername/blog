/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "user")
    private List<Article> articles = new ArrayList<>();
    @OneToMany(mappedBy = "utilisateur")
    private List<Commentaire> commentaires = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Page> page = new ArrayList<>();
    @OneToOne(mappedBy = "user")
    private NumSecu numSecu;
    @OneToMany(mappedBy = "expediteur")
    private List<Message> envoyes = new ArrayList<>();
    @ManyToMany(mappedBy = "destinataires")
    private List<Message> recus = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(Long id) {
        this.id = id;
    }

    public List<Message> getRecus() {
        return recus;
    }
    
    public void addRecu(Message m) {
        this.recus.add(m);
    }
    
    public void addEnvoye(Message m) {
        this.envoyes.add(m);
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public void setPage(List<Page> page) {
        this.page = page;
    }

    public void setRecus(List<Message> recus) {
        this.recus = recus;
    }

    public List<Message> getEnvoyes() {
        return envoyes;
    }

    public NumSecu getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(NumSecu numSecu) {
        this.numSecu = numSecu;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public List<Page> getPage() {
        return page;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog.entity.Utilisateur[ id=" + id + " ]";
    }

}
