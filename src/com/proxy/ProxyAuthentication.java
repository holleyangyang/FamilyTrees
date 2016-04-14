package com.proxy;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class ProxyAuthentication extends Authenticator implements HttpProxy {

	private String username;
    private String password;
    private String host;
    private int port;

    public ProxyAuthentication(){

    }

    public ProxyAuthentication(String host,int port){
        this.host = host;
        this.port = port;
    }

    public ProxyAuthentication(String host,int port,String username,String password){
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(username,password.toCharArray());
    }

    /**
     * 开始使用代理
     * @author 王成委
     */
    public void startProxy(){
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", host);
        System.setProperty("http.proxyPort", String.valueOf(port));

        if(username != null && !"".equals(username))
            Authenticator.setDefault(this);
    }

    /**
     * 停止使用代理
     * @author 王成委
     */
    public void endProxy(){
        //System.se
        System.setProperty("http.proxySet", "false");
        System.setProperty("http.proxyHost", "");
        System.setProperty("http.proxyPort", "");
        Authenticator.setDefault(null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
