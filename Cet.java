/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "cet", catalog = "exam", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cet.findAll", query = "SELECT c FROM Cet c")
    , @NamedQuery(name = "Cet.findByRollno", query = "SELECT c FROM Cet c WHERE c.rollno = :rollno")
    , @NamedQuery(name = "Cet.findByScore", query = "SELECT c FROM Cet c WHERE c.score = :score")})
public class Cet implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rollno")
    private Integer rollno;
    @Column(name = "score")
    private Integer score;

    public Cet() {
    }

    public Cet(Integer rollno) {
        this.rollno = rollno;
    }

    public Integer getRollno() {
        return rollno;
    }

    public void setRollno(Integer rollno) {
        Integer oldRollno = this.rollno;
        this.rollno = rollno;
        changeSupport.firePropertyChange("rollno", oldRollno, rollno);
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        Integer oldScore = this.score;
        this.score = score;
        changeSupport.firePropertyChange("score", oldScore, score);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rollno != null ? rollno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cet)) {
            return false;
        }
        Cet other = (Cet) object;
        if ((this.rollno == null && other.rollno != null) || (this.rollno != null && !this.rollno.equals(other.rollno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "exam.Cet[ rollno=" + rollno + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
