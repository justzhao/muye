/**
 * WxService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public interface WxService extends javax.xml.rpc.Service {
    public java.lang.String getWxServiceSoapAddress();

    public cn.modernfarming.mis.WxServiceSoap getWxServiceSoap() throws javax.xml.rpc.ServiceException;

    public cn.modernfarming.mis.WxServiceSoap getWxServiceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
