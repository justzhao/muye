/**
 * GetCowWeaningInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetCowWeaningInfoResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfoResult;

    public GetCowWeaningInfoResponse() {
    }

    public GetCowWeaningInfoResponse(
           cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfoResult) {
           this.getCowWeaningInfoResult = getCowWeaningInfoResult;
    }


    /**
     * Gets the getCowWeaningInfoResult value for this GetCowWeaningInfoResponse.
     * 
     * @return getCowWeaningInfoResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetCowWeaningInfoResult() {
        return getCowWeaningInfoResult;
    }


    /**
     * Sets the getCowWeaningInfoResult value for this GetCowWeaningInfoResponse.
     * 
     * @param getCowWeaningInfoResult
     */
    public void setGetCowWeaningInfoResult(cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfoResult) {
        this.getCowWeaningInfoResult = getCowWeaningInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCowWeaningInfoResponse)) return false;
        GetCowWeaningInfoResponse other = (GetCowWeaningInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCowWeaningInfoResult==null && other.getGetCowWeaningInfoResult()==null) || 
             (this.getCowWeaningInfoResult!=null &&
              this.getCowWeaningInfoResult.equals(other.getGetCowWeaningInfoResult())));
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
        if (getGetCowWeaningInfoResult() != null) {
            _hashCode += getGetCowWeaningInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCowWeaningInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowWeaningInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCowWeaningInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowWeaningInfoResult"));
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
