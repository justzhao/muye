/**
 * GetAllDeptResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetAllDeptResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getAllDeptResult;

    public GetAllDeptResponse() {
    }

    public GetAllDeptResponse(
           cn.modernfarming.mis.RtnDataTableResponse getAllDeptResult) {
           this.getAllDeptResult = getAllDeptResult;
    }


    /**
     * Gets the getAllDeptResult value for this GetAllDeptResponse.
     * 
     * @return getAllDeptResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetAllDeptResult() {
        return getAllDeptResult;
    }


    /**
     * Sets the getAllDeptResult value for this GetAllDeptResponse.
     * 
     * @param getAllDeptResult
     */
    public void setGetAllDeptResult(cn.modernfarming.mis.RtnDataTableResponse getAllDeptResult) {
        this.getAllDeptResult = getAllDeptResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetAllDeptResponse)) return false;
        GetAllDeptResponse other = (GetAllDeptResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getAllDeptResult==null && other.getGetAllDeptResult()==null) || 
             (this.getAllDeptResult!=null &&
              this.getAllDeptResult.equals(other.getGetAllDeptResult())));
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
        if (getGetAllDeptResult() != null) {
            _hashCode += getGetAllDeptResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetAllDeptResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetAllDeptResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getAllDeptResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetAllDeptResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
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
