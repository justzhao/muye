/**
 * GetCowMilkingInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetCowMilkingInfoResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfoResult;

    public GetCowMilkingInfoResponse() {
    }

    public GetCowMilkingInfoResponse(
           cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfoResult) {
           this.getCowMilkingInfoResult = getCowMilkingInfoResult;
    }


    /**
     * Gets the getCowMilkingInfoResult value for this GetCowMilkingInfoResponse.
     * 
     * @return getCowMilkingInfoResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetCowMilkingInfoResult() {
        return getCowMilkingInfoResult;
    }


    /**
     * Sets the getCowMilkingInfoResult value for this GetCowMilkingInfoResponse.
     * 
     * @param getCowMilkingInfoResult
     */
    public void setGetCowMilkingInfoResult(cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfoResult) {
        this.getCowMilkingInfoResult = getCowMilkingInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCowMilkingInfoResponse)) return false;
        GetCowMilkingInfoResponse other = (GetCowMilkingInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCowMilkingInfoResult==null && other.getGetCowMilkingInfoResult()==null) || 
             (this.getCowMilkingInfoResult!=null &&
              this.getCowMilkingInfoResult.equals(other.getGetCowMilkingInfoResult())));
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
        if (getGetCowMilkingInfoResult() != null) {
            _hashCode += getGetCowMilkingInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCowMilkingInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowMilkingInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCowMilkingInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowMilkingInfoResult"));
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
