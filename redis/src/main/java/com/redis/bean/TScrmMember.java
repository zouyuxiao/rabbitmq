package com.redis.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员列表对象 t_scrm_member
 * 
 * @author 李学超
 * @date 2020-04-28
 */
public class TScrmMember
{
    private static final long serialVersionUID = 1L;

    /** 会员ID */
    private Long memberid;

    /** 会员名称 */
    private String membername;

    /** 手机号 */
    private String mobile;

    /** 操作码 */
    private String membercode;

    /** 生日 */
    private Date birthday;

    /** 年龄 */
    private Integer age;

    /** 电话 */
    private String tel;

    /** 邮箱 */
    private String email;

    /** 身份证 */
    private String idcard;

    /** 性别 */
    private Integer sex;

    /** 员工标志 */
    private Integer staffFlag;

    /** 员工ID */
    private Integer staffEmpid;

    /** 会员卡号 */
    private String cardno;

    /** 会员卡类型 */
    private Integer cardtypeid;

    /** 当前可用积分 */
    private BigDecimal points;

    /** 年度累计积分 */
    private BigDecimal pointsYear;

    /** 总计积分 */
    private BigDecimal pointsTotal;

    /** 年度消费金额 */
    private BigDecimal amountYear;

    /** 总计消费金额 */
    private BigDecimal amountTotal;

    /** 末次消费日期 */
    private Date lastsalesdate;

    /** 开卡门店ID */
    private Integer crepoint;

    /** 开卡日期 */
    private Date credate;

    /** 创建人ID */
    private Integer creterid;

    /** 使用状态 */
    private Integer usestatus;

    /** 来源 */
    private Integer comefrom;

    /** 线上标志 */
    private Integer onlineflag;

    /** 国家 */
    private String country;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 县 */
    private String district;

    /** 地址 */
    private String address;

    /** 来源ID */
    private Integer sourceid;

    /** 备注 */
    private String memo;

    /** 落表时间 */
    private Date insdate;

    /** 归属公司ID */
    private Integer preEntryid;

    /** 归属门店ID */
    private Integer prePointid;

    /** 归属门店名称 */
    private String prePointName;

    /** 归属岗位ID */
    private Integer prePostid;

    /** 归属人ID */
    private Integer preEmpid;

    /** 公众号ID */
    private Integer wcServiceid;

    /** openid */
    private String openid;

    /** unionid */
    private String unionid;

    /** 认证日期 */
    private Date binddate;

    /** 发展员工ID */
    private Integer bindEmpid;

    /** 认证来源 */
    private Integer bindComefrom;

    /** 生命周期类型 */
    private Integer typeCycle;

    /** 毛利带类型 */
    private Integer typeGross;

    /** RFM类型 */
    private Integer typeRfm;

    /** 条件范围 */
    private String conditionRange;

    /** 会员卡类型 */

    /** 开卡门店 */

    public void setMemberid(Long memberid)
    {
        this.memberid = memberid;
    }

    public Long getMemberid()
    {
        return memberid;
    }
    public void setMembername(String membername) 
    {
        this.membername = membername;
    }

    public String getMembername() 
    {
        return membername;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setMembercode(String membercode) 
    {
        this.membercode = membercode;
    }

    public String getMembercode() 
    {
        return membercode;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setAge(Integer age) 
    {
        this.age = age;
    }

    public Integer getAge() 
    {
        return age;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setIdcard(String idcard) 
    {
        this.idcard = idcard;
    }

    public String getIdcard() 
    {
        return idcard;
    }
    public void setSex(Integer sex) 
    {
        this.sex = sex;
    }

    public Integer getSex() 
    {
        return sex;
    }
    public void setStaffFlag(Integer staffFlag) 
    {
        this.staffFlag = staffFlag;
    }

    public Integer getStaffFlag() 
    {
        return staffFlag;
    }
    public void setStaffEmpid(Integer staffEmpid) 
    {
        this.staffEmpid = staffEmpid;
    }

    public Integer getStaffEmpid() 
    {
        return staffEmpid;
    }
    public void setCardno(String cardno) 
    {
        this.cardno = cardno;
    }

    public String getCardno() 
    {
        return cardno;
    }
    public void setcardtypeid(Integer cardtypeid) 
    {
        this.cardtypeid = cardtypeid;
    }

    public Integer getcardtypeid()
    {
        return cardtypeid;
    }
    public void setPoints(BigDecimal points) 
    {
        this.points = points;
    }

    public BigDecimal getPoints() 
    {
        return points;
    }
    public void setPointsYear(BigDecimal pointsYear) 
    {
        this.pointsYear = pointsYear;
    }

    public BigDecimal getPointsYear() 
    {
        return pointsYear;
    }
    public void setPointsTotal(BigDecimal pointsTotal) 
    {
        this.pointsTotal = pointsTotal;
    }

    public BigDecimal getPointsTotal() 
    {
        return pointsTotal;
    }
    public void setAmountYear(BigDecimal amountYear) 
    {
        this.amountYear = amountYear;
    }

    public BigDecimal getAmountYear() 
    {
        return amountYear;
    }
    public void setAmountTotal(BigDecimal amountTotal) 
    {
        this.amountTotal = amountTotal;
    }

    public BigDecimal getAmountTotal() 
    {
        return amountTotal;
    }
    public void setLastsalesdate(Date lastsalesdate) 
    {
        this.lastsalesdate = lastsalesdate;
    }

    public Date getLastsalesdate() 
    {
        return lastsalesdate;
    }
    public void setCrepoint(Integer crepoint) 
    {
        this.crepoint = crepoint;
    }

    public Integer getCrepoint() 
    {
        return crepoint;
    }
    public void setCredate(Date credate) 
    {
        this.credate = credate;
    }

    public Date getCredate() 
    {
        return credate;
    }
    public void setCreterid(Integer creterid) 
    {
        this.creterid = creterid;
    }

    public Integer getCreterid() 
    {
        return creterid;
    }
    public void setUsestatus(Integer usestatus) 
    {
        this.usestatus = usestatus;
    }

    public Integer getUsestatus() 
    {
        return usestatus;
    }
    public void setComefrom(Integer comefrom) 
    {
        this.comefrom = comefrom;
    }

    public Integer getComefrom() 
    {
        return comefrom;
    }
    public void setOnlineflag(Integer onlineflag) 
    {
        this.onlineflag = onlineflag;
    }

    public Integer getOnlineflag() 
    {
        return onlineflag;
    }
    public void setCountry(String country) 
    {
        this.country = country;
    }

    public String getCountry() 
    {
        return country;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setSourceid(Integer sourceid) 
    {
        this.sourceid = sourceid;
    }

    public Integer getSourceid() 
    {
        return sourceid;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }
    public void setInsdate(Date insdate) 
    {
        this.insdate = insdate;
    }

    public Date getInsdate() 
    {
        return insdate;
    }
    public void setPreEntryid(Integer preEntryid) 
    {
        this.preEntryid = preEntryid;
    }

    public Integer getPreEntryid() 
    {
        return preEntryid;
    }
    public void setPrePointid(Integer prePointid) 
    {
        this.prePointid = prePointid;
    }

    public Integer getPrePointid() 
    {
        return prePointid;
    }
    public void setPrePostid(Integer prePostid) 
    {
        this.prePostid = prePostid;
    }

    public Integer getPrePostid() 
    {
        return prePostid;
    }
    public void setPreEmpid(Integer preEmpid) 
    {
        this.preEmpid = preEmpid;
    }

    public Integer getPreEmpid() 
    {
        return preEmpid;
    }
    public void setWcServiceid(Integer wcServiceid) 
    {
        this.wcServiceid = wcServiceid;
    }

    public Integer getWcServiceid() 
    {
        return wcServiceid;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setUnionid(String unionid) 
    {
        this.unionid = unionid;
    }

    public String getUnionid() 
    {
        return unionid;
    }
    public void setBinddate(Date binddate) 
    {
        this.binddate = binddate;
    }

    public Date getBinddate() 
    {
        return binddate;
    }
    public void setBindEmpid(Integer bindEmpid) 
    {
        this.bindEmpid = bindEmpid;
    }

    public Integer getBindEmpid() 
    {
        return bindEmpid;
    }
    public void setBindComefrom(Integer bindComefrom) 
    {
        this.bindComefrom = bindComefrom;
    }

    public Integer getBindComefrom() 
    {
        return bindComefrom;
    }
    public void setTypeCycle(Integer typeCycle) 
    {
        this.typeCycle = typeCycle;
    }

    public Integer getTypeCycle() 
    {
        return typeCycle;
    }
    public void setTypeGross(Integer typeGross) 
    {
        this.typeGross = typeGross;
    }

    public Integer getTypeGross() 
    {
        return typeGross;
    }
    public void setTypeRfm(Integer typeRfm) 
    {
        this.typeRfm = typeRfm;
    }

    public Integer getTypeRfm() 
    {
        return typeRfm;
    }

    public String getPrePointName() {
        return prePointName;
    }

    public void setPrePointName(String prePointName) {
        this.prePointName = prePointName;
    }

    public String getConditionRange() {
        return conditionRange;
    }

    public void setConditionRange(String conditionRange) {
        this.conditionRange = conditionRange;
    }

    @Override
    public String toString() {
        return "TScrmMember{" +
                "memberid=" + memberid +
                ", membername='" + membername + '\'' +
                ", mobile='" + mobile + '\'' +
                ", membercode='" + membercode + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", idcard='" + idcard + '\'' +
                ", sex=" + sex +
                ", staffFlag=" + staffFlag +
                ", staffEmpid=" + staffEmpid +
                ", cardno='" + cardno + '\'' +
                ", cardtypeid=" + cardtypeid +
                ", points=" + points +
                ", pointsYear=" + pointsYear +
                ", pointsTotal=" + pointsTotal +
                ", amountYear=" + amountYear +
                ", amountTotal=" + amountTotal +
                ", lastsalesdate=" + lastsalesdate +
                ", crepoint=" + crepoint +
                ", credate=" + credate +
                ", creterid=" + creterid +
                ", usestatus=" + usestatus +
                ", comefrom=" + comefrom +
                ", onlineflag=" + onlineflag +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", sourceid=" + sourceid +
                ", memo='" + memo + '\'' +
                ", insdate=" + insdate +
                ", preEntryid=" + preEntryid +
                ", prePointid=" + prePointid +
                ", prePointName='" + prePointName + '\'' +
                ", prePostid=" + prePostid +
                ", preEmpid=" + preEmpid +
                ", wcServiceid=" + wcServiceid +
                ", openid='" + openid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", binddate=" + binddate +
                ", bindEmpid=" + bindEmpid +
                ", bindComefrom=" + bindComefrom +
                ", typeCycle=" + typeCycle +
                ", typeGross=" + typeGross +
                ", typeRfm=" + typeRfm +
                ", conditionRange='" + conditionRange + '\'' +
                '}';
    }
}
