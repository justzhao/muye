/**
 * WxServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class WxServiceLocator extends org.apache.axis.client.Service implements cn.modernfarming.mis.WxService {

    public WxServiceLocator() {
    }


    public WxServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WxServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WxServiceSoap
    private java.lang.String WxServiceSoap_address = "http://weixin.xdmy.co:8080/mfWxService/WxService.asmx";
// private java.lang.String WxServiceSoap_address = "http://localhost:8080/mfWxService/WxService.asmx";
    public java.lang.String getWxServiceSoapAddress() {
        return WxServiceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WxServiceSoapWSDDServiceName = "WxServiceSoap";

    public java.lang.String getWxServiceSoapWSDDServiceName() {
        return WxServiceSoapWSDDServiceName;
    }

    public void setWxServiceSoapWSDDServiceName(java.lang.String name) {
        WxServiceSoapWSDDServiceName = name;
    }

    public cn.modernfarming.mis.WxServiceSoap getWxServiceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WxServiceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWxServiceSoap(endpoint);
    }

    public cn.modernfarming.mis.WxServiceSoap getWxServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.modernfarming.mis.WxServiceSoapStub _stub = new cn.modernfarming.mis.WxServiceSoapStub(portAddress, this);
            _stub.setPortName(getWxServiceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWxServiceSoapEndpointAddress(java.lang.String address) {
        WxServiceSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.modernfarming.mis.WxServiceSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.modernfarming.mis.WxServiceSoapStub _stub = new cn.modernfarming.mis.WxServiceSoapStub(new java.net.URL(WxServiceSoap_address), this);
                _stub.setPortName(getWxServiceSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WxServiceSoap".equals(inputPortName)) {
            return getWxServiceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "WxService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "WxServiceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WxServiceSoap".equals(portName)) {
            setWxServiceSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
