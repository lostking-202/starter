package com.example.starter;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.sqlclient.templates.annotations.Column;
import io.vertx.sqlclient.templates.annotations.RowMapped;
import java.io.Serializable;

/**
 * @Author: Zhangchao
 *
 * @Date: 2018/12/03 16:09
 */
@RowMapped
@DataObject
public class TIotSysRole implements Serializable {


  private static final long serialVersionUID = 637675111497113059L;
  @Column(name="n_id")
  private Long id;

  @Column(name = "n_org_id")
  private Long orgId;
  @Column(name="n_application_id")
  private Long applicationId;
  @Column(name="c_name")
  private String name;
  @Column(name="c_role_type")
  private String roleType;
  @Column(name="c_note")
  private String note;
  @Column(name="n_user_id")
  private Long userId;
  @Column(name="n_create_time")
  private Long createTime;
  @Column(name="n_role_order")
  private Integer roleOrder;
  @Column(name="n_status")
  private Integer status;
  @Column(name = "n_update_time")
  private Long updateTime;

  //扩展字段

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoleType() {
    return this.roleType;
  }

  public void setRoleType(String roleType) {
    this.roleType = roleType;
  }

  public String getNote() {
    return this.note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Long getUserId() {
    return this.userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Long createTime) {
    this.createTime = createTime;
  }

  public Integer getRoleOrder() {
    return this.roleOrder;
  }

  public void setRoleOrder(Integer roleOrder) {
    this.roleOrder = roleOrder;
  }

  public Long getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }

  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * 角色类型
   */
  public enum TYPE {
    HIGH_SUPER("1"),ENTERPRISE_SUPER("2"),ENTERPRISE_NORMAL("3");
    public String value;

    TYPE(String value) {
      this.value = value;
    }

  }

  /**
   * 状态 0-正常 1-停用
   */
  public enum STATUS {
    NORMAL(0),STOP(1);
    public Integer value;

    STATUS(Integer value) {
      this.value = value;
    }

  }
}
