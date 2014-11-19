/**
 * GetCowInfoByCowIDResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class GetCowInfoByCowIDResponse  implements java.io.Serializable {
    private cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowIDResult;

    public GetCowInfoByCowIDResponse() {
    }

    public GetCowInfoByCowIDResponse(
           cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowIDResult) {
           this.getCowInfoByCowIDResult = getCowInfoByCowIDResult;
    }


    /**
     * Gets the getCowInfoByCowIDResult value for this GetCowInfoByCowIDResponse.
     * 
     * @return getCowInfoByCowIDResult
     */
    public cn.modernfarming.mis.RtnCowInfoReponse getGetCowInfoByCowIDResult() {
        return getCowInfoByCowIDResult;
    }


    /**
     * Sets the getCowInfoByCowIDResult value for this GetCowInfoByCowIDResponse.
     * 
     * @param getCowInfoByCowIDResult
     */
    public void setGetCowInfoByCowIDResult(cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowIDResult) {
        this.getCowInfoByCowIDResult = getCowInfoByCowIDResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetCowInfoByCowIDResponse)) return false;
        GetCowInfoByCowIDResponse other = (GetCowInfoByCowIDResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.getCowInfoByCowIDResult==null && other.getGetCowInfoByCowIDResult()==null) || 
             (this.getCowInfoByCowIDResult!=null &&
              this.getCowInfoByCowIDResult.equals(other.getGetCowInfoByCowIDResult())));
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
        if (getGetCowInfoByCowIDResult() != null) {
            _hashCode += getGetCowInfoByCowIDResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetCowInfoByCowIDResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowInfoByCowIDResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getCowInfoByCowIDResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowInfoByCowIDResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCowInfoReponse"));
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
