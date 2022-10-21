/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michael
 */
@Entity
@Table(name = "CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCursoid", query = "SELECT c FROM Curso c WHERE c.cursoid = :cursoid"),
    @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Curso.findByCreditos", query = "SELECT c FROM Curso c WHERE c.creditos = :creditos"),
    @NamedQuery(name = "Curso.findBySemestre", query = "SELECT c FROM Curso c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Curso.findByEstuduantesadmitidos", query = "SELECT c FROM Curso c WHERE c.estuduantesadmitidos = :estuduantesadmitidos")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSOID")
    private Integer cursoid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CREDITOS")
    private Integer creditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "ESTUDUANTESADMITIDOS")
    private Integer estuduantesadmitidos;

    public Curso() {
    }

    public Curso(Integer cursoid, String nombre, Integer creditos, Integer semestre, Integer estuduantesadmitidos) {
        this.cursoid = cursoid;
        this.nombre = nombre;
        this.creditos = creditos;
        this.semestre = semestre;
        this.estuduantesadmitidos = estuduantesadmitidos;
    }

    
    
    public Curso(Integer cursoid) {
        this.cursoid = cursoid;
    }

    public Integer getCursoid() {
        return cursoid;
    }

    public void setCursoid(Integer cursoid) {
        this.cursoid = cursoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getEstuduantesadmitidos() {
        return estuduantesadmitidos;
    }

    public void setEstuduantesadmitidos(Integer estuduantesadmitidos) {
        this.estuduantesadmitidos = estuduantesadmitidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoid != null ? cursoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursoid == null && other.cursoid != null) || (this.cursoid != null && !this.cursoid.equals(other.cursoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.Curso[ cursoid=" + cursoid + " ]";
    }
    
}
