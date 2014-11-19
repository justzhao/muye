/**
 * CowInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.modernfarming.mis;

public class CowInfo  implements java.io.Serializable {
    private java.lang.String cowID;

    private java.lang.String earNO;

    private java.lang.String TID1;

    private java.lang.String TID2;

    private java.lang.String EPC;

    private boolean sex;

    private java.lang.String currFarm;

    private java.lang.String currGroup;

    private java.lang.String currGroupNO;

    private java.lang.String lastFindGroupNO;

    private java.util.Calendar lastFindTime;

    private java.lang.String birthFarm;

    private java.util.Calendar enterDate;

    private int bornLact;

    private int currLact;

    private java.util.Calendar birthday;

    private java.util.Calendar lastCalvDate;

    private java.math.BigDecimal bornWeight;

    private java.math.BigDecimal bornValue;

    private boolean isET;

    private boolean isTwin;

    private boolean isInsurance;

    private java.lang.String currCategory;

    private java.util.Calendar ablactDate;

    private java.lang.String ablactOperator;

    private java.lang.String fatherNO;

    private java.lang.String motherNO;

    private java.lang.String maFatherNO;

    private java.lang.String maMotherNO;

    private java.lang.String variety;

    private java.lang.String varietyPurity;

    private java.lang.String color;

    private java.lang.String from;

    private java.lang.String groCode;

    private java.lang.String repCode;

    private java.util.Calendar fbDate;

    private int period;

    private boolean nomateSign;

    private java.lang.String nomateReason;

    private java.util.Calendar nomateDate;

    private java.lang.String nomatePerson;

    private java.util.Calendar leftDate;

    private java.lang.String leftWhere;

    private java.lang.String leftReason;

    private java.lang.String leftPerson;

    private java.math.BigDecimal leftValue;

    private java.lang.String isAlive;

    public CowInfo() {
    }

    public CowInfo(
           java.lang.String cowID,
           java.lang.String earNO,
           java.lang.String TID1,
           java.lang.String TID2,
           java.lang.String EPC,
           boolean sex,
           java.lang.String currFarm,
           java.lang.String currGroup,
           java.lang.String currGroupNO,
           java.lang.String lastFindGroupNO,
           java.util.Calendar lastFindTime,
           java.lang.String birthFarm,
           java.util.Calendar enterDate,
           int bornLact,
           int currLact,
           java.util.Calendar birthday,
           java.util.Calendar lastCalvDate,
           java.math.BigDecimal bornWeight,
           java.math.BigDecimal bornValue,
           boolean isET,
           boolean isTwin,
           boolean isInsurance,
           java.lang.String currCategory,
           java.util.Calendar ablactDate,
           java.lang.String ablactOperator,
           java.lang.String fatherNO,
           java.lang.String motherNO,
           java.lang.String maFatherNO,
           java.lang.String maMotherNO,
           java.lang.String variety,
           java.lang.String varietyPurity,
           java.lang.String color,
           java.lang.String from,
           java.lang.String groCode,
           java.lang.String repCode,
           java.util.Calendar fbDate,
           int period,
           boolean nomateSign,
           java.lang.String nomateReason,
           java.util.Calendar nomateDate,
           java.lang.String nomatePerson,
           java.util.Calendar leftDate,
           java.lang.String leftWhere,
           java.lang.String leftReason,
           java.lang.String leftPerson,
           java.math.BigDecimal leftValue,
           java.lang.String isAlive) {
           this.cowID = cowID;
           this.earNO = earNO;
           this.TID1 = TID1;
           this.TID2 = TID2;
           this.EPC = EPC;
           this.sex = sex;
           this.currFarm = currFarm;
           this.currGroup = currGroup;
           this.currGroupNO = currGroupNO;
           this.lastFindGroupNO = lastFindGroupNO;
           this.lastFindTime = lastFindTime;
           this.birthFarm = birthFarm;
           this.enterDate = enterDate;
           this.bornLact = bornLact;
           this.currLact = currLact;
           this.birthday = birthday;
           this.lastCalvDate = lastCalvDate;
           this.bornWeight = bornWeight;
           this.bornValue = bornValue;
           this.isET = isET;
           this.isTwin = isTwin;
           this.isInsurance = isInsurance;
           this.currCategory = currCategory;
           this.ablactDate = ablactDate;
           this.ablactOperator = ablactOperator;
           this.fatherNO = fatherNO;
           this.motherNO = motherNO;
           this.maFatherNO = maFatherNO;
           this.maMotherNO = maMotherNO;
           this.variety = variety;
           this.varietyPurity = varietyPurity;
           this.color = color;
           this.from = from;
           this.groCode = groCode;
           this.repCode = repCode;
           this.fbDate = fbDate;
           this.period = period;
           this.nomateSign = nomateSign;
           this.nomateReason = nomateReason;
           this.nomateDate = nomateDate;
           this.nomatePerson = nomatePerson;
           this.leftDate = leftDate;
           this.leftWhere = leftWhere;
           this.leftReason = leftReason;
           this.leftPerson = leftPerson;
           this.leftValue = leftValue;
           this.isAlive = isAlive;
    }


    /**
     * Gets the cowID value for this CowInfo.
     * 
     * @return cowID
     */
    public java.lang.String getCowID() {
        return cowID;
    }


    /**
     * Sets the cowID value for this CowInfo.
     * 
     * @param cowID
     */
    public void setCowID(java.lang.String cowID) {
        this.cowID = cowID;
    }


    /**
     * Gets the earNO value for this CowInfo.
     * 
     * @return earNO
     */
    public java.lang.String getEarNO() {
        return earNO;
    }


    /**
     * Sets the earNO value for this CowInfo.
     * 
     * @param earNO
     */
    public void setEarNO(java.lang.String earNO) {
        this.earNO = earNO;
    }


    /**
     * Gets the TID1 value for this CowInfo.
     * 
     * @return TID1
     */
    public java.lang.String getTID1() {
        return TID1;
    }


    /**
     * Sets the TID1 value for this CowInfo.
     * 
     * @param TID1
     */
    public void setTID1(java.lang.String TID1) {
        this.TID1 = TID1;
    }


    /**
     * Gets the TID2 value for this CowInfo.
     * 
     * @return TID2
     */
    public java.lang.String getTID2() {
        return TID2;
    }


    /**
     * Sets the TID2 value for this CowInfo.
     * 
     * @param TID2
     */
    public void setTID2(java.lang.String TID2) {
        this.TID2 = TID2;
    }


    /**
     * Gets the EPC value for this CowInfo.
     * 
     * @return EPC
     */
    public java.lang.String getEPC() {
        return EPC;
    }


    /**
     * Sets the EPC value for this CowInfo.
     * 
     * @param EPC
     */
    public void setEPC(java.lang.String EPC) {
        this.EPC = EPC;
    }


    /**
     * Gets the sex value for this CowInfo.
     * 
     * @return sex
     */
    public boolean isSex() {
        return sex;
    }


    /**
     * Sets the sex value for this CowInfo.
     * 
     * @param sex
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }


    /**
     * Gets the currFarm value for this CowInfo.
     * 
     * @return currFarm
     */
    public java.lang.String getCurrFarm() {
        return currFarm;
    }


    /**
     * Sets the currFarm value for this CowInfo.
     * 
     * @param currFarm
     */
    public void setCurrFarm(java.lang.String currFarm) {
        this.currFarm = currFarm;
    }


    /**
     * Gets the currGroup value for this CowInfo.
     * 
     * @return currGroup
     */
    public java.lang.String getCurrGroup() {
        return currGroup;
    }


    /**
     * Sets the currGroup value for this CowInfo.
     * 
     * @param currGroup
     */
    public void setCurrGroup(java.lang.String currGroup) {
        this.currGroup = currGroup;
    }


    /**
     * Gets the currGroupNO value for this CowInfo.
     * 
     * @return currGroupNO
     */
    public java.lang.String getCurrGroupNO() {
        return currGroupNO;
    }


    /**
     * Sets the currGroupNO value for this CowInfo.
     * 
     * @param currGroupNO
     */
    public void setCurrGroupNO(java.lang.String currGroupNO) {
        this.currGroupNO = currGroupNO;
    }


    /**
     * Gets the lastFindGroupNO value for this CowInfo.
     * 
     * @return lastFindGroupNO
     */
    public java.lang.String getLastFindGroupNO() {
        return lastFindGroupNO;
    }


    /**
     * Sets the lastFindGroupNO value for this CowInfo.
     * 
     * @param lastFindGroupNO
     */
    public void setLastFindGroupNO(java.lang.String lastFindGroupNO) {
        this.lastFindGroupNO = lastFindGroupNO;
    }


    /**
     * Gets the lastFindTime value for this CowInfo.
     * 
     * @return lastFindTime
     */
    public java.util.Calendar getLastFindTime() {
        return lastFindTime;
    }


    /**
     * Sets the lastFindTime value for this CowInfo.
     * 
     * @param lastFindTime
     */
    public void setLastFindTime(java.util.Calendar lastFindTime) {
        this.lastFindTime = lastFindTime;
    }


    /**
     * Gets the birthFarm value for this CowInfo.
     * 
     * @return birthFarm
     */
    public java.lang.String getBirthFarm() {
        return birthFarm;
    }


    /**
     * Sets the birthFarm value for this CowInfo.
     * 
     * @param birthFarm
     */
    public void setBirthFarm(java.lang.String birthFarm) {
        this.birthFarm = birthFarm;
    }


    /**
     * Gets the enterDate value for this CowInfo.
     * 
     * @return enterDate
     */
    public java.util.Calendar getEnterDate() {
        return enterDate;
    }


    /**
     * Sets the enterDate value for this CowInfo.
     * 
     * @param enterDate
     */
    public void setEnterDate(java.util.Calendar enterDate) {
        this.enterDate = enterDate;
    }


    /**
     * Gets the bornLact value for this CowInfo.
     * 
     * @return bornLact
     */
    public int getBornLact() {
        return bornLact;
    }


    /**
     * Sets the bornLact value for this CowInfo.
     * 
     * @param bornLact
     */
    public void setBornLact(int bornLact) {
        this.bornLact = bornLact;
    }


    /**
     * Gets the currLact value for this CowInfo.
     * 
     * @return currLact
     */
    public int getCurrLact() {
        return currLact;
    }


    /**
     * Sets the currLact value for this CowInfo.
     * 
     * @param currLact
     */
    public void setCurrLact(int currLact) {
        this.currLact = currLact;
    }


    /**
     * Gets the birthday value for this CowInfo.
     * 
     * @return birthday
     */
    public java.util.Calendar getBirthday() {
        return birthday;
    }


    /**
     * Sets the birthday value for this CowInfo.
     * 
     * @param birthday
     */
    public void setBirthday(java.util.Calendar birthday) {
        this.birthday = birthday;
    }


    /**
     * Gets the lastCalvDate value for this CowInfo.
     * 
     * @return lastCalvDate
     */
    public java.util.Calendar getLastCalvDate() {
        return lastCalvDate;
    }


    /**
     * Sets the lastCalvDate value for this CowInfo.
     * 
     * @param lastCalvDate
     */
    public void setLastCalvDate(java.util.Calendar lastCalvDate) {
        this.lastCalvDate = lastCalvDate;
    }


    /**
     * Gets the bornWeight value for this CowInfo.
     * 
     * @return bornWeight
     */
    public java.math.BigDecimal getBornWeight() {
        return bornWeight;
    }


    /**
     * Sets the bornWeight value for this CowInfo.
     * 
     * @param bornWeight
     */
    public void setBornWeight(java.math.BigDecimal bornWeight) {
        this.bornWeight = bornWeight;
    }


    /**
     * Gets the bornValue value for this CowInfo.
     * 
     * @return bornValue
     */
    public java.math.BigDecimal getBornValue() {
        return bornValue;
    }


    /**
     * Sets the bornValue value for this CowInfo.
     * 
     * @param bornValue
     */
    public void setBornValue(java.math.BigDecimal bornValue) {
        this.bornValue = bornValue;
    }


    /**
     * Gets the isET value for this CowInfo.
     * 
     * @return isET
     */
    public boolean isIsET() {
        return isET;
    }


    /**
     * Sets the isET value for this CowInfo.
     * 
     * @param isET
     */
    public void setIsET(boolean isET) {
        this.isET = isET;
    }


    /**
     * Gets the isTwin value for this CowInfo.
     * 
     * @return isTwin
     */
    public boolean isIsTwin() {
        return isTwin;
    }


    /**
     * Sets the isTwin value for this CowInfo.
     * 
     * @param isTwin
     */
    public void setIsTwin(boolean isTwin) {
        this.isTwin = isTwin;
    }


    /**
     * Gets the isInsurance value for this CowInfo.
     * 
     * @return isInsurance
     */
    public boolean isIsInsurance() {
        return isInsurance;
    }


    /**
     * Sets the isInsurance value for this CowInfo.
     * 
     * @param isInsurance
     */
    public void setIsInsurance(boolean isInsurance) {
        this.isInsurance = isInsurance;
    }


    /**
     * Gets the currCategory value for this CowInfo.
     * 
     * @return currCategory
     */
    public java.lang.String getCurrCategory() {
        return currCategory;
    }


    /**
     * Sets the currCategory value for this CowInfo.
     * 
     * @param currCategory
     */
    public void setCurrCategory(java.lang.String currCategory) {
        this.currCategory = currCategory;
    }


    /**
     * Gets the ablactDate value for this CowInfo.
     * 
     * @return ablactDate
     */
    public java.util.Calendar getAblactDate() {
        return ablactDate;
    }


    /**
     * Sets the ablactDate value for this CowInfo.
     * 
     * @param ablactDate
     */
    public void setAblactDate(java.util.Calendar ablactDate) {
        this.ablactDate = ablactDate;
    }


    /**
     * Gets the ablactOperator value for this CowInfo.
     * 
     * @return ablactOperator
     */
    public java.lang.String getAblactOperator() {
        return ablactOperator;
    }


    /**
     * Sets the ablactOperator value for this CowInfo.
     * 
     * @param ablactOperator
     */
    public void setAblactOperator(java.lang.String ablactOperator) {
        this.ablactOperator = ablactOperator;
    }


    /**
     * Gets the fatherNO value for this CowInfo.
     * 
     * @return fatherNO
     */
    public java.lang.String getFatherNO() {
        return fatherNO;
    }


    /**
     * Sets the fatherNO value for this CowInfo.
     * 
     * @param fatherNO
     */
    public void setFatherNO(java.lang.String fatherNO) {
        this.fatherNO = fatherNO;
    }


    /**
     * Gets the motherNO value for this CowInfo.
     * 
     * @return motherNO
     */
    public java.lang.String getMotherNO() {
        return motherNO;
    }


    /**
     * Sets the motherNO value for this CowInfo.
     * 
     * @param motherNO
     */
    public void setMotherNO(java.lang.String motherNO) {
        this.motherNO = motherNO;
    }


    /**
     * Gets the maFatherNO value for this CowInfo.
     * 
     * @return maFatherNO
     */
    public java.lang.String getMaFatherNO() {
        return maFatherNO;
    }


    /**
     * Sets the maFatherNO value for this CowInfo.
     * 
     * @param maFatherNO
     */
    public void setMaFatherNO(java.lang.String maFatherNO) {
        this.maFatherNO = maFatherNO;
    }


    /**
     * Gets the maMotherNO value for this CowInfo.
     * 
     * @return maMotherNO
     */
    public java.lang.String getMaMotherNO() {
        return maMotherNO;
    }


    /**
     * Sets the maMotherNO value for this CowInfo.
     * 
     * @param maMotherNO
     */
    public void setMaMotherNO(java.lang.String maMotherNO) {
        this.maMotherNO = maMotherNO;
    }


    /**
     * Gets the variety value for this CowInfo.
     * 
     * @return variety
     */
    public java.lang.String getVariety() {
        return variety;
    }


    /**
     * Sets the variety value for this CowInfo.
     * 
     * @param variety
     */
    public void setVariety(java.lang.String variety) {
        this.variety = variety;
    }


    /**
     * Gets the varietyPurity value for this CowInfo.
     * 
     * @return varietyPurity
     */
    public java.lang.String getVarietyPurity() {
        return varietyPurity;
    }


    /**
     * Sets the varietyPurity value for this CowInfo.
     * 
     * @param varietyPurity
     */
    public void setVarietyPurity(java.lang.String varietyPurity) {
        this.varietyPurity = varietyPurity;
    }


    /**
     * Gets the color value for this CowInfo.
     * 
     * @return color
     */
    public java.lang.String getColor() {
        return color;
    }


    /**
     * Sets the color value for this CowInfo.
     * 
     * @param color
     */
    public void setColor(java.lang.String color) {
        this.color = color;
    }


    /**
     * Gets the from value for this CowInfo.
     * 
     * @return from
     */
    public java.lang.String getFrom() {
        return from;
    }


    /**
     * Sets the from value for this CowInfo.
     * 
     * @param from
     */
    public void setFrom(java.lang.String from) {
        this.from = from;
    }


    /**
     * Gets the groCode value for this CowInfo.
     * 
     * @return groCode
     */
    public java.lang.String getGroCode() {
        return groCode;
    }


    /**
     * Sets the groCode value for this CowInfo.
     * 
     * @param groCode
     */
    public void setGroCode(java.lang.String groCode) {
        this.groCode = groCode;
    }


    /**
     * Gets the repCode value for this CowInfo.
     * 
     * @return repCode
     */
    public java.lang.String getRepCode() {
        return repCode;
    }


    /**
     * Sets the repCode value for this CowInfo.
     * 
     * @param repCode
     */
    public void setRepCode(java.lang.String repCode) {
        this.repCode = repCode;
    }


    /**
     * Gets the fbDate value for this CowInfo.
     * 
     * @return fbDate
     */
    public java.util.Calendar getFbDate() {
        return fbDate;
    }


    /**
     * Sets the fbDate value for this CowInfo.
     * 
     * @param fbDate
     */
    public void setFbDate(java.util.Calendar fbDate) {
        this.fbDate = fbDate;
    }


    /**
     * Gets the period value for this CowInfo.
     * 
     * @return period
     */
    public int getPeriod() {
        return period;
    }


    /**
     * Sets the period value for this CowInfo.
     * 
     * @param period
     */
    public void setPeriod(int period) {
        this.period = period;
    }


    /**
     * Gets the nomateSign value for this CowInfo.
     * 
     * @return nomateSign
     */
    public boolean isNomateSign() {
        return nomateSign;
    }


    /**
     * Sets the nomateSign value for this CowInfo.
     * 
     * @param nomateSign
     */
    public void setNomateSign(boolean nomateSign) {
        this.nomateSign = nomateSign;
    }


    /**
     * Gets the nomateReason value for this CowInfo.
     * 
     * @return nomateReason
     */
    public java.lang.String getNomateReason() {
        return nomateReason;
    }


    /**
     * Sets the nomateReason value for this CowInfo.
     * 
     * @param nomateReason
     */
    public void setNomateReason(java.lang.String nomateReason) {
        this.nomateReason = nomateReason;
    }


    /**
     * Gets the nomateDate value for this CowInfo.
     * 
     * @return nomateDate
     */
    public java.util.Calendar getNomateDate() {
        return nomateDate;
    }


    /**
     * Sets the nomateDate value for this CowInfo.
     * 
     * @param nomateDate
     */
    public void setNomateDate(java.util.Calendar nomateDate) {
        this.nomateDate = nomateDate;
    }


    /**
     * Gets the nomatePerson value for this CowInfo.
     * 
     * @return nomatePerson
     */
    public java.lang.String getNomatePerson() {
        return nomatePerson;
    }


    /**
     * Sets the nomatePerson value for this CowInfo.
     * 
     * @param nomatePerson
     */
    public void setNomatePerson(java.lang.String nomatePerson) {
        this.nomatePerson = nomatePerson;
    }


    /**
     * Gets the leftDate value for this CowInfo.
     * 
     * @return leftDate
     */
    public java.util.Calendar getLeftDate() {
        return leftDate;
    }


    /**
     * Sets the leftDate value for this CowInfo.
     * 
     * @param leftDate
     */
    public void setLeftDate(java.util.Calendar leftDate) {
        this.leftDate = leftDate;
    }


    /**
     * Gets the leftWhere value for this CowInfo.
     * 
     * @return leftWhere
     */
    public java.lang.String getLeftWhere() {
        return leftWhere;
    }


    /**
     * Sets the leftWhere value for this CowInfo.
     * 
     * @param leftWhere
     */
    public void setLeftWhere(java.lang.String leftWhere) {
        this.leftWhere = leftWhere;
    }


    /**
     * Gets the leftReason value for this CowInfo.
     * 
     * @return leftReason
     */
    public java.lang.String getLeftReason() {
        return leftReason;
    }


    /**
     * Sets the leftReason value for this CowInfo.
     * 
     * @param leftReason
     */
    public void setLeftReason(java.lang.String leftReason) {
        this.leftReason = leftReason;
    }


    /**
     * Gets the leftPerson value for this CowInfo.
     * 
     * @return leftPerson
     */
    public java.lang.String getLeftPerson() {
        return leftPerson;
    }


    /**
     * Sets the leftPerson value for this CowInfo.
     * 
     * @param leftPerson
     */
    public void setLeftPerson(java.lang.String leftPerson) {
        this.leftPerson = leftPerson;
    }


    /**
     * Gets the leftValue value for this CowInfo.
     * 
     * @return leftValue
     */
    public java.math.BigDecimal getLeftValue() {
        return leftValue;
    }


    /**
     * Sets the leftValue value for this CowInfo.
     * 
     * @param leftValue
     */
    public void setLeftValue(java.math.BigDecimal leftValue) {
        this.leftValue = leftValue;
    }


    /**
     * Gets the isAlive value for this CowInfo.
     * 
     * @return isAlive
     */
    public java.lang.String getIsAlive() {
        return isAlive;
    }


    /**
     * Sets the isAlive value for this CowInfo.
     * 
     * @param isAlive
     */
    public void setIsAlive(java.lang.String isAlive) {
        this.isAlive = isAlive;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CowInfo)) return false;
        CowInfo other = (CowInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cowID==null && other.getCowID()==null) || 
             (this.cowID!=null &&
              this.cowID.equals(other.getCowID()))) &&
            ((this.earNO==null && other.getEarNO()==null) || 
             (this.earNO!=null &&
              this.earNO.equals(other.getEarNO()))) &&
            ((this.TID1==null && other.getTID1()==null) || 
             (this.TID1!=null &&
              this.TID1.equals(other.getTID1()))) &&
            ((this.TID2==null && other.getTID2()==null) || 
             (this.TID2!=null &&
              this.TID2.equals(other.getTID2()))) &&
            ((this.EPC==null && other.getEPC()==null) || 
             (this.EPC!=null &&
              this.EPC.equals(other.getEPC()))) &&
            this.sex == other.isSex() &&
            ((this.currFarm==null && other.getCurrFarm()==null) || 
             (this.currFarm!=null &&
              this.currFarm.equals(other.getCurrFarm()))) &&
            ((this.currGroup==null && other.getCurrGroup()==null) || 
             (this.currGroup!=null &&
              this.currGroup.equals(other.getCurrGroup()))) &&
            ((this.currGroupNO==null && other.getCurrGroupNO()==null) || 
             (this.currGroupNO!=null &&
              this.currGroupNO.equals(other.getCurrGroupNO()))) &&
            ((this.lastFindGroupNO==null && other.getLastFindGroupNO()==null) || 
             (this.lastFindGroupNO!=null &&
              this.lastFindGroupNO.equals(other.getLastFindGroupNO()))) &&
            ((this.lastFindTime==null && other.getLastFindTime()==null) || 
             (this.lastFindTime!=null &&
              this.lastFindTime.equals(other.getLastFindTime()))) &&
            ((this.birthFarm==null && other.getBirthFarm()==null) || 
             (this.birthFarm!=null &&
              this.birthFarm.equals(other.getBirthFarm()))) &&
            ((this.enterDate==null && other.getEnterDate()==null) || 
             (this.enterDate!=null &&
              this.enterDate.equals(other.getEnterDate()))) &&
            this.bornLact == other.getBornLact() &&
            this.currLact == other.getCurrLact() &&
            ((this.birthday==null && other.getBirthday()==null) || 
             (this.birthday!=null &&
              this.birthday.equals(other.getBirthday()))) &&
            ((this.lastCalvDate==null && other.getLastCalvDate()==null) || 
             (this.lastCalvDate!=null &&
              this.lastCalvDate.equals(other.getLastCalvDate()))) &&
            ((this.bornWeight==null && other.getBornWeight()==null) || 
             (this.bornWeight!=null &&
              this.bornWeight.equals(other.getBornWeight()))) &&
            ((this.bornValue==null && other.getBornValue()==null) || 
             (this.bornValue!=null &&
              this.bornValue.equals(other.getBornValue()))) &&
            this.isET == other.isIsET() &&
            this.isTwin == other.isIsTwin() &&
            this.isInsurance == other.isIsInsurance() &&
            ((this.currCategory==null && other.getCurrCategory()==null) || 
             (this.currCategory!=null &&
              this.currCategory.equals(other.getCurrCategory()))) &&
            ((this.ablactDate==null && other.getAblactDate()==null) || 
             (this.ablactDate!=null &&
              this.ablactDate.equals(other.getAblactDate()))) &&
            ((this.ablactOperator==null && other.getAblactOperator()==null) || 
             (this.ablactOperator!=null &&
              this.ablactOperator.equals(other.getAblactOperator()))) &&
            ((this.fatherNO==null && other.getFatherNO()==null) || 
             (this.fatherNO!=null &&
              this.fatherNO.equals(other.getFatherNO()))) &&
            ((this.motherNO==null && other.getMotherNO()==null) || 
             (this.motherNO!=null &&
              this.motherNO.equals(other.getMotherNO()))) &&
            ((this.maFatherNO==null && other.getMaFatherNO()==null) || 
             (this.maFatherNO!=null &&
              this.maFatherNO.equals(other.getMaFatherNO()))) &&
            ((this.maMotherNO==null && other.getMaMotherNO()==null) || 
             (this.maMotherNO!=null &&
              this.maMotherNO.equals(other.getMaMotherNO()))) &&
            ((this.variety==null && other.getVariety()==null) || 
             (this.variety!=null &&
              this.variety.equals(other.getVariety()))) &&
            ((this.varietyPurity==null && other.getVarietyPurity()==null) || 
             (this.varietyPurity!=null &&
              this.varietyPurity.equals(other.getVarietyPurity()))) &&
            ((this.color==null && other.getColor()==null) || 
             (this.color!=null &&
              this.color.equals(other.getColor()))) &&
            ((this.from==null && other.getFrom()==null) || 
             (this.from!=null &&
              this.from.equals(other.getFrom()))) &&
            ((this.groCode==null && other.getGroCode()==null) || 
             (this.groCode!=null &&
              this.groCode.equals(other.getGroCode()))) &&
            ((this.repCode==null && other.getRepCode()==null) || 
             (this.repCode!=null &&
              this.repCode.equals(other.getRepCode()))) &&
            ((this.fbDate==null && other.getFbDate()==null) || 
             (this.fbDate!=null &&
              this.fbDate.equals(other.getFbDate()))) &&
            this.period == other.getPeriod() &&
            this.nomateSign == other.isNomateSign() &&
            ((this.nomateReason==null && other.getNomateReason()==null) || 
             (this.nomateReason!=null &&
              this.nomateReason.equals(other.getNomateReason()))) &&
            ((this.nomateDate==null && other.getNomateDate()==null) || 
             (this.nomateDate!=null &&
              this.nomateDate.equals(other.getNomateDate()))) &&
            ((this.nomatePerson==null && other.getNomatePerson()==null) || 
             (this.nomatePerson!=null &&
              this.nomatePerson.equals(other.getNomatePerson()))) &&
            ((this.leftDate==null && other.getLeftDate()==null) || 
             (this.leftDate!=null &&
              this.leftDate.equals(other.getLeftDate()))) &&
            ((this.leftWhere==null && other.getLeftWhere()==null) || 
             (this.leftWhere!=null &&
              this.leftWhere.equals(other.getLeftWhere()))) &&
            ((this.leftReason==null && other.getLeftReason()==null) || 
             (this.leftReason!=null &&
              this.leftReason.equals(other.getLeftReason()))) &&
            ((this.leftPerson==null && other.getLeftPerson()==null) || 
             (this.leftPerson!=null &&
              this.leftPerson.equals(other.getLeftPerson()))) &&
            ((this.leftValue==null && other.getLeftValue()==null) || 
             (this.leftValue!=null &&
              this.leftValue.equals(other.getLeftValue()))) &&
            ((this.isAlive==null && other.getIsAlive()==null) || 
             (this.isAlive!=null &&
              this.isAlive.equals(other.getIsAlive())));
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
        if (getCowID() != null) {
            _hashCode += getCowID().hashCode();
        }
        if (getEarNO() != null) {
            _hashCode += getEarNO().hashCode();
        }
        if (getTID1() != null) {
            _hashCode += getTID1().hashCode();
        }
        if (getTID2() != null) {
            _hashCode += getTID2().hashCode();
        }
        if (getEPC() != null) {
            _hashCode += getEPC().hashCode();
        }
        _hashCode += (isSex() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCurrFarm() != null) {
            _hashCode += getCurrFarm().hashCode();
        }
        if (getCurrGroup() != null) {
            _hashCode += getCurrGroup().hashCode();
        }
        if (getCurrGroupNO() != null) {
            _hashCode += getCurrGroupNO().hashCode();
        }
        if (getLastFindGroupNO() != null) {
            _hashCode += getLastFindGroupNO().hashCode();
        }
        if (getLastFindTime() != null) {
            _hashCode += getLastFindTime().hashCode();
        }
        if (getBirthFarm() != null) {
            _hashCode += getBirthFarm().hashCode();
        }
        if (getEnterDate() != null) {
            _hashCode += getEnterDate().hashCode();
        }
        _hashCode += getBornLact();
        _hashCode += getCurrLact();
        if (getBirthday() != null) {
            _hashCode += getBirthday().hashCode();
        }
        if (getLastCalvDate() != null) {
            _hashCode += getLastCalvDate().hashCode();
        }
        if (getBornWeight() != null) {
            _hashCode += getBornWeight().hashCode();
        }
        if (getBornValue() != null) {
            _hashCode += getBornValue().hashCode();
        }
        _hashCode += (isIsET() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsTwin() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isIsInsurance() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCurrCategory() != null) {
            _hashCode += getCurrCategory().hashCode();
        }
        if (getAblactDate() != null) {
            _hashCode += getAblactDate().hashCode();
        }
        if (getAblactOperator() != null) {
            _hashCode += getAblactOperator().hashCode();
        }
        if (getFatherNO() != null) {
            _hashCode += getFatherNO().hashCode();
        }
        if (getMotherNO() != null) {
            _hashCode += getMotherNO().hashCode();
        }
        if (getMaFatherNO() != null) {
            _hashCode += getMaFatherNO().hashCode();
        }
        if (getMaMotherNO() != null) {
            _hashCode += getMaMotherNO().hashCode();
        }
        if (getVariety() != null) {
            _hashCode += getVariety().hashCode();
        }
        if (getVarietyPurity() != null) {
            _hashCode += getVarietyPurity().hashCode();
        }
        if (getColor() != null) {
            _hashCode += getColor().hashCode();
        }
        if (getFrom() != null) {
            _hashCode += getFrom().hashCode();
        }
        if (getGroCode() != null) {
            _hashCode += getGroCode().hashCode();
        }
        if (getRepCode() != null) {
            _hashCode += getRepCode().hashCode();
        }
        if (getFbDate() != null) {
            _hashCode += getFbDate().hashCode();
        }
        _hashCode += getPeriod();
        _hashCode += (isNomateSign() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNomateReason() != null) {
            _hashCode += getNomateReason().hashCode();
        }
        if (getNomateDate() != null) {
            _hashCode += getNomateDate().hashCode();
        }
        if (getNomatePerson() != null) {
            _hashCode += getNomatePerson().hashCode();
        }
        if (getLeftDate() != null) {
            _hashCode += getLeftDate().hashCode();
        }
        if (getLeftWhere() != null) {
            _hashCode += getLeftWhere().hashCode();
        }
        if (getLeftReason() != null) {
            _hashCode += getLeftReason().hashCode();
        }
        if (getLeftPerson() != null) {
            _hashCode += getLeftPerson().hashCode();
        }
        if (getLeftValue() != null) {
            _hashCode += getLeftValue().hashCode();
        }
        if (getIsAlive() != null) {
            _hashCode += getIsAlive().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CowInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CowInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cowID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CowID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("earNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "EarNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TID1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "TID1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TID2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "TID2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EPC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "EPC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sex");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "Sex"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currFarm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CurrFarm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currGroup");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CurrGroup"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currGroupNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CurrGroupNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastFindGroupNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LastFindGroupNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastFindTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LastFindTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthFarm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "BirthFarm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enterDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "EnterDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bornLact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "BornLact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currLact");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CurrLact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthday");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "Birthday"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastCalvDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LastCalvDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bornWeight");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "BornWeight"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bornValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "BornValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isET");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "IsET"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isTwin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "IsTwin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isInsurance");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "IsInsurance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("currCategory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "CurrCategory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ablactDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "AblactDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ablactOperator");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "AblactOperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fatherNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "FatherNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("motherNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "MotherNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maFatherNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "MaFatherNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maMotherNO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "MaMotherNO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variety");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "Variety"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("varietyPurity");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "VarietyPurity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("color");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "Color"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("from");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "From"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "GroCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "RepCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fbDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "FbDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("period");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "Period"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomateSign");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "NomateSign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomateReason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "NomateReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomateDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "NomateDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nomatePerson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "NomatePerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leftDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LeftDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leftWhere");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LeftWhere"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leftReason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LeftReason"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leftPerson");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LeftPerson"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("leftValue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "LeftValue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isAlive");
        elemField.setXmlName(new javax.xml.namespace.QName("http://mis.modernfarming.cn/", "IsAlive"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
