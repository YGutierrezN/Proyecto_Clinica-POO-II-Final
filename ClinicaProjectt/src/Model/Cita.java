/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jx
 */
public class Cita {
    private String id;
    private String fecha;
    private String nom_doctor;
    private String nom_paciente;
    private String estado_cita;
    private String nom_especialidad;

    public Cita() {
    }

    public Cita(String id, String fecha, String nom_doctor, String nom_paciente, String estado_cita, String nom_especialidad) {
        this.id = id;
        this.fecha = fecha;
        this.nom_doctor = nom_doctor;
        this.nom_paciente = nom_paciente;
        this.estado_cita = estado_cita;
        this.nom_especialidad = nom_especialidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNom_doctor() {
        return nom_doctor;
    }

    public void setNom_doctor(String nom_doctor) {
        this.nom_doctor = nom_doctor;
    }

    public String getNom_paciente() {
        return nom_paciente;
    }

    public void setNom_paciente(String nom_paciente) {
        this.nom_paciente = nom_paciente;
    }

    public String getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(String estado_cita) {
        this.estado_cita = estado_cita;
    }

    public String getNom_especialidad() {
        return nom_especialidad;
    }

    public void setNom_especialidad(String nom_especialidad) {
        this.nom_especialidad = nom_especialidad;
    }
    
    
}
