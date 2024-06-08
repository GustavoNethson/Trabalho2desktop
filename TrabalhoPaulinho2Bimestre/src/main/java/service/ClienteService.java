/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.ctc.wstx.shaded.msv_core.util.Util;
import com.google.gson.Gson;
import dto.ClienteDTO;
import dto.ProdutoDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Gustavo Henrique
 *         João Marcos
 */
public class ClienteService {
    private static String URLWEBSERVICE = "";
    private static int SUCESSO = 200;
    
    public static ClienteDTO buscaProduto(int nCodCli) throws Exception{
        String urlChamada = URLWEBSERVICE + nCodCli + "/json";
        
        try{
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        
            if(conexao.getResponseCode() != SUCESSO){
                throw new RuntimeException("Erro ao conectar: "+conexao.getResponseMessage());
            }
            
            //Pegando a resposta da API
            //pegando a resposta da api
            BufferedReader resposta = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream()));
            
            String json = Util.converteJsonString(resposta);
            
            Gson gson = new Gson();
            ClienteDTO dto = gson.fromJson(json, ClienteDTO.class);
                    
            return dto; 
            
        }catch(Exception ex){
            throw new Exception("Erro ao retornar endereço: "+ex);
        }
            
        }
        
    }
}
