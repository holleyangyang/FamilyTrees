package com.common.util;


import java.security.Key;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import sun.misc.BASE64Encoder;

public class TestEncryptAndDecrypt {    
    public static void main(String[] args) throws Exception {
        String input = "thisIsMyPassword$7788";
        Cipher cipher = Cipher.getInstance("RSA");        
        
        RSAPrivateKey privKey = (RSAPrivateKey) PrivateKeyReader.get("e:/privateKeyFile");
        cipher.init(Cipher.ENCRYPT_MODE, privKey);
        
        
        byte[] cipherText = cipher.doFinal(input.getBytes());
        //加密后的东西
        System.out.println("cipher: " + new String(cipherText));     
        
        
        //开始解密
        RSAPublicKey pubKey = (RSAPublicKey) PublicKeyReader.get("e:/publicKeyFile");
      
        System.out.println("start");
        System.out.println(getKeyString(pubKey));
        System.out.println("end");
        System.out.println("bbbb"+pubKey+"asdasdasdasda");
        cipher.init(Cipher.DECRYPT_MODE, pubKey);
        byte[] plainText = cipher.doFinal(cipherText);
        System.out.println("plain : " + new String(plainText));
    }
    public static String getKeyString(Key key) throws Exception {
        byte[] keyBytes = key.getEncoded();
        String s = (new BASE64Encoder()).encode(keyBytes);
        return s;
  }

}