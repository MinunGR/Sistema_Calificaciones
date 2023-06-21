package com.med.sistema_calificaciones.model;

/**
 *
 * @author RomanMendoza
 */
public class Materia {

    private String nombreMateria, codigoMateria;
    private int cicloMateria;

    public Materia() {
    }

    public Materia(String nombreMateria, String codigoMateria, int CicloMateria) {
        this.nombreMateria = nombreMateria;
        this.codigoMateria = codigoMateria;
        this.cicloMateria = CicloMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public int getCicloMateria() {
        return cicloMateria;
    }

    public void setCicloMateria(int cicloMateria) {
        this.cicloMateria = cicloMateria;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombreMateria=" + nombreMateria + ", codigoMateria=" + codigoMateria + ", CicloMateria=" + cicloMateria + '}';
    }

}
