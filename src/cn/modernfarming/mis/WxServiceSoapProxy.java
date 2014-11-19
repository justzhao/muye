package cn.modernfarming.mis;

public class WxServiceSoapProxy implements cn.modernfarming.mis.WxServiceSoap {
  private String _endpoint = null;
  private cn.modernfarming.mis.WxServiceSoap wxServiceSoap = null;
  
  public WxServiceSoapProxy() {
    _initWxServiceSoapProxy();
  }
  
  public WxServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWxServiceSoapProxy();
  }
  
  private void _initWxServiceSoapProxy() {
    try {
      wxServiceSoap = (new cn.modernfarming.mis.WxServiceLocator()).getWxServiceSoap();
      if (wxServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wxServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wxServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wxServiceSoap != null)
      ((javax.xml.rpc.Stub)wxServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.modernfarming.mis.WxServiceSoap getWxServiceSoap() {
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap;
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse userLogin(java.lang.String loginName, java.lang.String password) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.userLogin(loginName, password);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getAllDept() throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getAllDept();
  }
  
  public cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowID(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowInfoByCowID(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowBreedingInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowBreedingInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowDiseaseInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowDiseaseInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowCalvingInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowCalvingInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowWeaningInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowBlindInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowBlindInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowLeftInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfo(java.lang.String cowID) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getCowMilkingInfo(cowID);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfo(java.lang.String farmName) throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getDiseaseCowsInfo(farmName);
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getAllFarmInfo() throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getAllFarmInfo();
  }
  
  public cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummary() throws java.rmi.RemoteException{
    if (wxServiceSoap == null)
      _initWxServiceSoapProxy();
    return wxServiceSoap.getDairyProductSummary();
  }
  
  
}