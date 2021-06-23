package com.awslamda.demo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.Date;

/**
 * The type Feature.
 * <p>
 * Feature : It will used to store feature details
 */
@DynamoDBTable(tableName = "feature")
public class Feature {

  /**
   * CustID: It will be the feature key
   * */
  @DynamoDBHashKey
  private Integer custId;

  /**
   *featureCode: It will be the feature key
   *
   */
  @DynamoDBHashKey(attributeName = "Feature_code")
  private String featureCode;

  /**
   * featureName: feature name
   * */
  @DynamoDBAttribute(attributeName = "Feature name")
  private String featureName;

  /**
   * enable : feature is enable or not
   * */
  @DynamoDBAttribute(attributeName = "Enabled")
  private Boolean enable;

  /**
   * Sets insert date.
   *
   * @param insertDate the insert date
   */
  public void setInsertDate(Date insertDate) {
    this.insertDate = insertDate;
  }

  /**
   *insertDate : feature inserted date
   * */
  @DynamoDBAttribute(attributeName = "Inserted")
  private Date insertDate=new Date();

  /**
   * Gets insert date.
   *
   * @return the insert date
   */
  public Date getInsertDate() {
    return insertDate;
  }

  /**
   * Gets cust id.
   *
   * @return the cust id
   */
  public Integer getCustId() {
    return custId;
  }

  /**
   * Sets cust id.
   *
   * @param custId the cust id
   */
  public void setCustId(Integer custId) {
    this.custId = custId;
  }

  /**
   * Gets feature code.
   *
   * @return the feature code
   */
  public String getFeatureCode() {
    return featureCode;
  }

  /**
   * Sets feature code.
   *
   * @param featureCode the feature code
   */
  public void setFeatureCode(String featureCode) {
    this.featureCode = featureCode;
  }

  /**
   * Gets feature name.
   *
   * @return the feature name
   */
  public String getFeatureName() {
    return featureName;
  }

  /**
   * Sets feature name.
   *
   * @param featureName the feature name
   */
  public void setFeatureName(String featureName) {
    this.featureName = featureName;
  }

  /**
   * Gets enable.
   *
   * @return the enable
   */
  public Boolean getEnable() {
    return enable;
  }

  /**
   * Sets enable.
   *
   * @param enable the enable
   */
  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  @Override
  public String toString() {
    return "Feature{" +
            "custId=" + custId +
            ", Feature_code='" + featureCode + '\'' +
            ", Feature name='" + featureName + '\'' +
            ", enable=" + enable +
            ", insertDate=" + insertDate +
            '}';
  }
}
