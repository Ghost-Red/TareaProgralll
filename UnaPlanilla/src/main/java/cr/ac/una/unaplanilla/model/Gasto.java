/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.unaplanilla.model;

/**
 *
 * @author james
 */
public class Gasto {
    private double monto;
    private String descripcion;
    
    public Gasto (double monto,String descripcion){
        this.monto=monto;
        this.descripcion=descripcion;
        sumarIVA();
    }
    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void sumarIVA(){
        this.monto+=this.monto*0.13;
    }
    
}
