/**
 * GetDiseaseCowsInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetDiseaseCowsInfoResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfoResult;

    public GetDiseaseCowsInfoResponse() {
    }

    public GetDiseaseCowsInfoResponse(
           cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfoResult) {
           this.getDiseaseCowsInfoResult = getDiseaseCowsInfoResult;
    }


    /**
     * Gets the getDiseaseCowsInfoResult value for this GetDiseaseCowsInfoResponse.
     * 
     * @return getDiseaseCowsInfoResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetDiseaseCowsInfoResult() {
        return getDiseaseCowsInfoResult;
    }


    /**
     * Sets the getDiseaseCowsInfoResult value for this GetDiseaseCowsInfoResponse.
     * 
     * @param getDiseaseCowsInfoResult
     */
    public void setGetDiseaseCowsInfoResult(cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfoResult) {
        this.getDiseaseCowsInfoResult = getDiseaseCowsInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDiseaseCowsInfoResponse)) return false;
        GetDiseaseCowsInfoResponse other = (GetDiseaseCowsInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDiseaseCowsInfoResult==null && other.getGetDiseaseCowsInfoResult()==null) || 
             (this.getDiseaseCowsInfoResult!=null &&
              this.getDiseaseCowsInfoResult.equals(other.getGetDiseaseCowsInfoResult())));
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
        if (getGetDiseaseCowsInfoResult() != null) {
            _hashCode += getGetDiseaseCowsInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDiseaseCowsInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDiseaseCowsInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDiseaseCowsInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDiseaseCowsInfoResult"));
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
