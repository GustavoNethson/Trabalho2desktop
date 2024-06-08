/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo Henrique
 *         João Marcos
 */
public class Venda {
    
    private int nCodVend;  // Código da Venda
    private String dtDatVend; // Data da venda
    private String stObsVend; // Observação da Venda
    
    public Venda(){
    }

    public int getnCodVend() {
        return nCodVend;
    }

    public void setnCodVend(int nCodVend) {
        this.nCodVend = nCodVend;
    }

    public String getdDatVend() {
        return dtDatVend;
    }

    public void setdDatVend(String dDatVend) {
        this.dtDatVend = dDatVend;
    }

    public String getStObsVend() {
        return stObsVend;
    }

    public void setStObsVend(String stObsVend) {
        this.stObsVend = stObsVend;
    }
    
    
}
