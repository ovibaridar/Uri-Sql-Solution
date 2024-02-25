package Crypto;

import java.util.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

class DES_Algorithm{
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        //String we want to encrypt
        String  msg="DES Implementation in Java!!!";
        byte[] myMsg =msg.getBytes(); //string to byte array as DES works on bytes

       

        //Generating Key
        KeyGenerator myKey = KeyGenerator.getInstance("DES");
        SecretKey desKey = myKey.generateKey();

        //initializing crypto algorithm
        Cipher cipher1 = Cipher.getInstance("DES");

        //setting encryption mode
        cipher1.init(Cipher.ENCRYPT_MODE, desKey);
        byte[] encryptedBytes=cipher1.doFinal(myMsg);
        

        //setting decryption mode
        cipher1.init(Cipher.DECRYPT_MODE, desKey);
        byte[] decryptedBytes=cipher1.doFinal(encryptedBytes);

        //print msg in byte format
        //System.out.println(Arrays.toString(encryptedBytes));
        //System.out.println(Arrays.toString(decryptedBytes));

        String encryptedmsg=new String(encryptedBytes);
        String decryptedmsg=new String(decryptedBytes);

        System.out.println("msg : "+ msg);
        System.out.println("Encrypted - "+ encryptedmsg);
        System.out.println("Decrypted msg - "+ decryptedmsg);
    }
}