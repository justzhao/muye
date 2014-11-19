/**
 * RtnDataTableResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class RtnDataTableResponse  implements java.io.Serializable {
    private int rtnCode;

    private java.lang.String rtnMessage;

    private cn.modernfarming.mis.RtnDataTableResponseRtnDataTable rtnDataTable;

    public RtnDataTableResponse() {
    }

    public RtnDataTableResponse(
           int rtnCode,
           java.lang.String rtnMessage,
           cn.modernfarming.mis.RtnDataTableResponseRtnDataTable rtnDataTable) {
           this.rtnCode = rtnCode;
           this.rtnMessage = rtnMessage;
           this.rtnDataTable = rtnDataTable;
    }


    /**
     * Gets the rtnCode value for this RtnDataTableResponse.
     * 
     * @return rtnCode
     */
    public int getRtnCode() {
        return rtnCode;
    }


    /**
     * Sets the rtnCode value for this RtnDataTableResponse.
     * 
     * @param rtnCode
     */
    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }


    /**
     * Gets the rtnMessage value for this RtnDataTableResponse.
     * 
     * @return rtnMessage
     */
    public java.lang.String getRtnMessage() {
        return rtnMessage;
    }


    /**
     * Sets the rtnMessage value for this RtnDataTableResponse.
     * 
     * @param rtnMessage
     */
    public void setRtnMessage(java.lang.String rtnMessage) {
        this.rtnMessage = rtnMessage;
    }


    /**
     * Gets the rtnDataTable value for this RtnDataTableResponse.
     * 
     * @return rtnDataTable
     */
    public cn.modernfarming.mis.RtnDataTableResponseRtnDataTable getRtnDataTable() {
        return rtnDataTable;
    }


    /**
     * Sets the rtnDataTable value for this RtnDataTableResponse.
     * 
     * @param rtnDataTable
     */
    public void setRtnDataTable(cn.modernfarming.mis.RtnDataTableResponseRtnDataTable rtnDataTable) {
        this.rtnDataTable = rtnDataTable;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RtnDataTableResponse)) return false;
        RtnDataTableResponse other = (RtnDataTableResponse) obj;
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
            ((this.rtnDataTable==null && other.getRtnDataTable()==null) || 
             (this.rtnDataTable!=null &&
              this.rtnDataTable.equals(other.getRtnDataTable())));
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
        if (getRtnDataTable() != null) {
            _hashCode += getRtnDataTable().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RtnDataTableResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
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
        elemField.setFieldName("rtnDataTable");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">rtnDataTableResponse>rtnDataTable"));
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
