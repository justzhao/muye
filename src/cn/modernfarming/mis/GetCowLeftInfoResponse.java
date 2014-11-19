/**
 * GetCowLeftInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetCowLeftInfoResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfoResult;

    public GetCowLeftInfoResponse() {
    }

    public GetCowLeftInfoResponse(
           cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfoResult) {
           this.getCowLeftInfoResult = getCowLeftInfoResult;
    }


    /**
     * Gets the getCowLeftInfoResult value for this GetCowLeftInfoResponse.
     * 
     * @return getCowLeftInfoResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetCowLeftInfoResult() {
        return getCowLeftInfoResult;
    }


    /**
     * Sets the getCowLeftInfoResult value for this GetCowLeftInfoResponse.
     * 
     * @param getCowLeftInfoResult
     */
    public void setGetCowLeftInfoResult(cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfoResult) {
        this.getCowLeftInfoResult = getCowLeftInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCowLeftInfoResponse)) return false;
        GetCowLeftInfoResponse other = (GetCowLeftInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCowLeftInfoResult==null && other.getGetCowLeftInfoResult()==null) || 
             (this.getCowLeftInfoResult!=null &&
              this.getCowLeftInfoResult.equals(other.getGetCowLeftInfoResult())));
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
        if (getGetCowLeftInfoResult() != null) {
            _hashCode += getGetCowLeftInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCowLeftInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowLeftInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCowLeftInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowLeftInfoResult"));
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
