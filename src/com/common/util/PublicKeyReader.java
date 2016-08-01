package com.common.util;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;
import java.util.Arrays;

public class PublicKeyReader {    
    public static PublicKey get(String filename) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int)f.length()];
        dis.readFully(keyBytes);
        System.out.println("public:");
        System.out.println(Arrays.toString(keyBytes));
        dis.close();
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }
   public static void main(String[] args) {
	   try {
		get("e:/publicKeyFile");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}

