/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Venda;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gustavo Henrique 
 *         João Marcos
 */

public class VendaDAO extends GenericDAO<Venda> {
    
    @Override
    protected Venda ContruirObjeto(ResultSet rs){
        Venda venda = null;
    
        try{
            
            venda = new Venda();
            venda.setnCodVend(rs.getInt("COD_VENDA"));
            venda.setdDatVend("DATA_VENDA");
            venda.setStObsVend("OBS_VENDA");
                              
        } catch (SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Venda;
    }

    @Override
    public boolean Salvar(Venda obj) {

        String sql = "INSERT INTO public.\"Venda\"(\""+"COD_VENDA\",\"DATA_VENDA\",\"OBS_VENDA\")"+"VALUES (?,?,?);";
        
        PreparedStatement ps = null;
    
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getnCodVend());
            ps.setString(2, obj.getdDatVend());
            ps.setString(3,obj.getStObsVend());
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean Atualizar(Venda obj) {
        
        String slq = "UPDATE public.\"Venda\" SET \"DATA_VENDA\" = ?, \"OBS_VENDA\" = ? WHERE \"COD_VENDA\" = ? ;";
    
        PreparedStatement ps = null;
        
        try{
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getnCodVend());
            ps.setString(2, obj.getdDatVend());
            ps.setString(3, obj.getStObsVend());
            ps.executeUpdate();
            ps.close();
            
            return true;
        } catch (SQLException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void gerarRelatorio(){
        try{
            
            //Responsavel por criar/Carregar o relatório
            String relatorioPath = "relatorio/RelVenda.jasper";
            JasperPrint printer = JasperFillManager.fillReport(relatorioPath,null,conn);
            
            //Exibir o relatório
            JasperViewer view = new JasperViewer(printer,false);
            
            view.setVisible(true);
            
        }catch(JRException ex){
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
