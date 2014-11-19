/**
 * WxServiceSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class WxServiceSoapStub extends org.apache.axis.client.Stub implements cn.modernfarming.mis.WxServiceSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[13];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UserLogin");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "loginName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "UserLoginResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllDept");
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetAllDeptResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowInfoByCowID");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCowInfoReponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnCowInfoReponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowInfoByCowIDResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowBreedingInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowBreedingInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowDiseaseInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowDiseaseInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowCalvingInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowCalvingInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowWeaningInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowWeaningInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowBlindInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowBlindInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowLeftInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowLeftInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetCowMilkingInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "cowID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowMilkingInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDiseaseCowsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "farmName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDiseaseCowsInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllFarmInfo");
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetAllFarmInfoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDairyProductSummary");
        oper.setReturnType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse"));
        oper.setReturnClass(cn.modernfarming.mis.RtnDataTableResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDairyProductSummaryResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

    }

    public WxServiceSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WxServiceSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WxServiceSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetAllDept");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetAllDept.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetAllDeptResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetAllDeptResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetAllFarmInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetAllFarmInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetAllFarmInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetAllFarmInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowBlindInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowBlindInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowBlindInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowBlindInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowBreedingInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowBreedingInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowBreedingInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowBreedingInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowCalvingInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowCalvingInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowCalvingInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowCalvingInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowDiseaseInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowDiseaseInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowDiseaseInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowDiseaseInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowInfoByCowID");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowInfoByCowID.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowInfoByCowIDResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowInfoByCowIDResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowLeftInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowLeftInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowLeftInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowLeftInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowMilkingInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowMilkingInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowMilkingInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowMilkingInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowWeaningInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowWeaningInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetCowWeaningInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetCowWeaningInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDairyProductSummary");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetDairyProductSummary.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDairyProductSummaryResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetDairyProductSummaryResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDiseaseCowsInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetDiseaseCowsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">GetDiseaseCowsInfoResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.GetDiseaseCowsInfoResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", ">rtnDataTableResponse>rtnDataTable");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.RtnDataTableResponseRtnDataTable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CowInfo");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.CowInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnCowInfoReponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.RtnCowInfoReponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "rtnDataTableResponse");
            cachedSerQNames.add(qName);
            cls = cn.modernfarming.mis.RtnDataTableResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cn.modernfarming.mis.RtnDataTableResponse userLogin(java.lang.String loginName, java.lang.String password) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/UserLogin");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "UserLogin"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {loginName, password});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getAllDept() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetAllDept");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetAllDept"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowID(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowInfoByCowID");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowInfoByCowID"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnCowInfoReponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnCowInfoReponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnCowInfoReponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowBreedingInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowBreedingInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowBreedingInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowDiseaseInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowDiseaseInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowDiseaseInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowCalvingInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowCalvingInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowCalvingInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowWeaningInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowWeaningInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowBlindInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowBlindInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowBlindInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowLeftInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowLeftInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfo(java.lang.String cowID) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetCowMilkingInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetCowMilkingInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cowID});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfo(java.lang.String farmName) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetDiseaseCowsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDiseaseCowsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {farmName});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getAllFarmInfo() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetAllFarmInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetAllFarmInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummary() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://mis.modernfarming.cn/GetDairyProductSummary");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GetDairyProductSummary"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cn.modernfarming.mis.RtnDataTableResponse) _resp;
            } catch (java.lang.Exception _exception) {
                return (cn.modernfarming.mis.RtnDataTableResponse) org.apache.axis.utils.JavaUtils.convert(_resp, cn.modernfarming.mis.RtnDataTableResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
