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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Utilisateur expediteur;
    @ManyToMany
    @JoinTable(name = "utilisateur message")
    private List<Utilisateur> destinataires = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public Message() {
    }

    public Message(Long id, Utilisateur expediteur, List<Utilisateur> destinataires) {
        this.id = id;
        this.expediteur = expediteur;
        expediteur.getEnvoye().add(this);
        destinataires.forEach(destinataire ->
                destinataire.getRecu().add(this)
        );    
    }

    public Utilisateur getExpediteur() {
        return expediteur;
    }

    public List<Utilisateur> getDestinataire() {
        return destinataires;
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
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "blog.entity.Message[ id=" + id + " ]";
    }
    
}
