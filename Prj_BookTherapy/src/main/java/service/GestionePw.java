package service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class GestionePw {
	private static String generateHash(String password) throws NoSuchAlgorithmException {
        //usiamo una libreria built-in di java per ottenere l'istanza di SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        //codifico e poi renderizzo a stringa giusto per poter leggere il risultato
        byte[] byteHash = md.digest(password.getBytes());
        return byteToString(byteHash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {


        //Password1
        String hash1 = generateHash("Password1");
        System.out.println("Password1 in hash: " + hash1);
        //Password2 
        String hash2 = generateHash("Password2");
        System.out.println("Password2 in hash: " + hash2);
        //Password3 
        String hash3 = generateHash("Password3");
        System.out.println("Password3 in hash: " + hash3);
        
      //Password4 
        String hash4 = generateHash("Password4");
        System.out.println("Password4 in hash: " + hash4);
     
    }

    

    private static String byteToString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
