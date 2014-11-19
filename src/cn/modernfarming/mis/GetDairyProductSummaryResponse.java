/**
 * GetDairyProductSummaryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetDairyProductSummaryResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummaryResult;

    public GetDairyProductSummaryResponse() {
    }

    public GetDairyProductSummaryResponse(
           cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummaryResult) {
           this.getDairyProductSummaryResult = getDairyProductSummaryResult;
    }


    /**
     * Gets the getDairyProductSummaryResult value for this GetDairyProductSummaryResponse.
     * 
     * @return getDairyProductSummaryResult
     */
    public cn.modernfarming.mis.RtnDataTableResponse getGetDairyProductSummaryResult() {
        return getDairyProductSummaryResult;
    }


    /**
     * Sets the getDairyProductSummaryResult value for this GetDairyProductSummaryResponse.
     * 
     * @param getDairyProductSummaryResult
     */
    public void setGetDairyProductSummaryResult(cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummaryResult) {
        this.getDairyProductSummaryResult = getDairyProductSummaryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDairyProductSummaryResponse)) return false;
        GetDairyProductSummaryResponse other = (GetDairyProductSummaryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getDairyProductSummaryResult==null && other.getGetDairyProductSummaryResult()==null) || 
             (this.getDairyProductSummaryResult!=null &&
              this.getDairyProductSummaryResult.equals(other.getGetDairyProductSummaryResult())));
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
        if (getGetDairyProductSummaryResult() != null) {
            _hashCode += getGetDairyProductSummaryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDairyProductSummaryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDairyProductSummaryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDairyProductSummaryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDairyProductSummaryResult"));
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
