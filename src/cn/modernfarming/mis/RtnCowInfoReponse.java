/**
 * RtnCowInfoReponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class RtnCowInfoReponse  implements java.io.Serializable {
    private int rtnCode;

    private java.lang.String rtnMessage;

    private cn.modernfarming.mis.CowInfo rtnCowInfo;

    public RtnCowInfoReponse() {
    }

    public RtnCowInfoReponse(
           int rtnCode,
           java.lang.String rtnMessage,
           cn.modernfarming.mis.CowInfo rtnCowInfo) {
           this.rtnCode = rtnCode;
           this.rtnMessage = rtnMessage;
           this.rtnCowInfo = rtnCowInfo;
    }


    /**
     * Gets the rtnCode value for this RtnCowInfoReponse.
     * 
     * @return rtnCode
     */
    public int getRtnCode() {
        return rtnCode;
    }


    /**
     * Sets the rtnCode value for this RtnCowInfoReponse.
     * 
     * @param rtnCode
     */
    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }


    /**
     * Gets the rtnMessage value for this RtnCowInfoReponse.
     * 
     * @return rtnMessage
     */
    public java.lang.String getRtnMessage() {
        return rtnMessage;
    }


    /**
     * Sets the rtnMessage value for this RtnCowInfoReponse.
     * 
     * @param rtnMessage
     */
    public void setRtnMessage(java.lang.String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }


    /**
     * Gets the rtnCowInfo value for this RtnCowInfoReponse.
     * 
     * @return rtnCowInfo
     */
    public cn.modernfarming.mis.CowInfo getRtnCowInfo() {
        return rtnCowInfo;
    }


    /**
     * Sets the rtnCowInfo value for this RtnCowInfoReponse.
     * 
     * @param rtnCowInfo
     */
    public void setRtnCowInfo(cn.modernfarming.mis.CowInfo rtnCowInfo) {
        this.rtnCowInfo = rtnCowInfo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RtnCowInfoReponse)) return false;
        RtnCowInfoReponse other = (RtnCowInfoReponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.rtnCode == other.getRtnCode() &&
            ((this.rtnMessage==null && other.getRtnMessage()==null) || 
             (this.rtnMessage!=null &&
              this.rtnMessage.equals(other.getRtnMessage()))) &&
            ((this.rtnCowInfo==null && other.getRtnCowInfo()==null) || 
             (this.rtnCowInfo!=null &&
              this.rtnCowInfo.equals(other.getRtnCowInfo())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getRtnCode();
        if (getRtnMessage() != null) {
            _hashCode += getRtnMessage().hashCode();
        }
        if (getRtnCowInfo() != null) {
            _hashCode += getRtnCowInfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RtnCowInfoReponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCowInfoReponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtnCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtnMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rtnCowInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCowInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CowInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
