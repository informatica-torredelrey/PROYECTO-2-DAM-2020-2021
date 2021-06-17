/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author admin
 */
public class EncriptaPass {
    
    //Para agregar salt y hacer que la contraseña sea mas dificil de desencriptar
    private static final String SALT = "08b5b649124BfNFPRgf9/fq97ZiA=a0f78b6d59b2KF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=a0f78b6d59b293398fb1d55a30582716739/fq97ZiA=a0f78b6d59b208e12bd190200aa0f78b6BfNFPRBfNFPRgfKF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=gfKF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=d59b293398fb1338d1db1fd5e8059cdfd1d28BfNFPRgfKF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=49fe50aa0f78b6d59b293398fb1BfNFPRgfKF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=BfNFPRgfKF8Ke9kpoNAagmcI4/Hya5o/rq9/fq97ZiA=edc694a1";
    
    // M E T O D O  C O N  S H A 5 1 2
    
    //Esta clase esta diseñada para encriptar las contraseñas de los usuarios
    public static String StringToHash(String pass){
        String passHash = SHA512_SecurePass(pass);
        return passHash;

    }

    private static String SHA512_SecurePass(String pass) {
        String passGenerada = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(pass.getBytes());
            byte[] bytes = md.digest(SALT.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            passGenerada = sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncriptaPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return passGenerada;
    }
    
    // M E T O D O  C O N  A E S
    
    private static SecretKeySpec secretKey;
    private static byte[] key;
    
    //Pone clave
    public static void setKey(String myKey) throws UnsupportedEncodingException{
        MessageDigest sha = null;
        try{
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKey = new SecretKeySpec(key, "AES");
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    //Encripta el texto
    public static String AESEncriptar(String codigo){
        try{
            setKey(SALT);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(codigo.getBytes("UTF-8")));
        }catch (Exception e){
            System.out.println("Error al encriptar: " + e.toString());
        }
        return null;
    }
    
}
