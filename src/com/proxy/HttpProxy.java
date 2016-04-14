package com.proxy;

	public interface HttpProxy {

	    public void startProxy();

	    public void endProxy();

	    public String getUsername();

	    public void setUsername(String username);

	    public String getPassword();

	    public void setPassword(String password);

	    public String getHost();

	    public void setHost(String host);

	    public int getPort();

	    public void setPort(int port);
}
