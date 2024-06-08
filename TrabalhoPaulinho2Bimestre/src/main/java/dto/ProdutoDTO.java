/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Gustavo Henrique da Silva Nethson
 *         João Marcos Contini Tavares Pereira
 */
public class ProdutoDTO {
    
    private int nCodProd; //Código do produto
    private String stDescProd; // Descrição do produto
    private String stCatProd; // Categoria do produto
    private double doValProd; // Valor unitário do produto

    public int getnCodProd() {
        return nCodProd;
    }

    public String getStDescProd() {
        return stDescProd;
    }

    public String getStCatProd() {
        return stCatProd;
    }

    public double getDoValProd() {
        return doValProd;
    }
    
    
}
