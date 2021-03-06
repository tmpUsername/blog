/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Commentaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "id_page")
    private Page page;

    public Commentaire(Long id, Page page, Utilisateur utilisateur) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.page = page;
        page.getCommentaires().add(this);
        utilisateur.getCommentaires().add(this);
    }

    public Commentaire(Long id, Article article, Utilisateur user) {
        this.id = id;
        this.article = article;
        this.utilisateur = user;
        article.getCommentaires().add(this);
        user.getCommentaires().add(this);
    }

    public Commentaire() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
        if (!(object instanceof Commentaire)) {
            return false;
        }
        Commentaire other = (Commentaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog.entity.Commentaire[ id=" + id + " ]";
    }

}
