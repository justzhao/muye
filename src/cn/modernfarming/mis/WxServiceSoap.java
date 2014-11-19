/**
 * WxServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public interface WxServiceSoap extends java.rmi.Remote {

    /**
     * 用户登陆，返回登陆状态：true为认证通过，false为认证失败
     */
    public cn.modernfarming.mis.RtnDataTableResponse userLogin(java.lang.String loginName, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 获取部门岗位列表
     */
    public cn.modernfarming.mis.RtnDataTableResponse getAllDept() throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的牛只基本信息
     */
    public cn.modernfarming.mis.RtnCowInfoReponse getCowInfoByCowID(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的繁殖进程信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowBreedingInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的疾病进程信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowDiseaseInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的产犊信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowCalvingInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的断奶信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowWeaningInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的盲乳头信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowBlindInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的离场信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowLeftInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牛号的测产奶量信息<br>目前提供最近20次测产明细
     */
    public cn.modernfarming.mis.RtnDataTableResponse getCowMilkingInfo(java.lang.String cowID) throws java.rmi.RemoteException;

    /**
     * 查询指定牧场的疾病存栏信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getDiseaseCowsInfo(java.lang.String farmName) throws java.rmi.RemoteException;

    /**
     * 查询所有牧场信息
     */
    public cn.modernfarming.mis.RtnDataTableResponse getAllFarmInfo() throws java.rmi.RemoteException;

    /**
     * 获取生产日报日常汇总指标
     */
    public cn.modernfarming.mis.RtnDataTableResponse getDairyProductSummary() throws java.rmi.RemoteException;
}
