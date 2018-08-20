package com.cy.comm.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5 {
	public static void main(String[] args){  
        
        
	    /*  //md5加密  
	        String hashAlgorithmName = "MD5";  
	        String credentials = "admin";  
	        int hashIterations = 1024;  
	        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);  
	        System.out.println(obj);*/  
	          
	          
	        String hashAlgorithmName = "MD5";  
	        String credentials = "2";  
	        int hashIterations = 1024;  
	        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");  
	        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);  
	        System.out.println(obj);  
	          
	    }  
	public static String getMd5BySalt(String password,String salt){
		 ByteSource credentialsSalt = ByteSource.Util.bytes(salt);//盐值
		 int hashIterations = 1024;  //加密次数
	     Object obj = new SimpleHash("MD5", password, credentialsSalt, hashIterations);  
		return String.valueOf(obj);
	}
}
