package com.netcracker.edu.inventory.model.impl;

public class WifiRouter extends AbstractDevice {
    protected String securityProtocol;

    public void setSecurityProtocol(String securityProtocol) {
        this.securityProtocol = securityProtocol;
    }

    public String getSecurityProtocol() {
        return securityProtocol;
    }
}
