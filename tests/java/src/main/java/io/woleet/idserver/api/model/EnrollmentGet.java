/*
 * Woleet.ID Server
 * This is Woleet.ID Server API documentation.
 *
 * OpenAPI spec version: 1.2.0
 * Contact: contact@woleet.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package io.woleet.idserver.api.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.woleet.idserver.api.model.EnrollmentBase;
import io.woleet.idserver.api.model.KeyDeviceEnum;
import java.io.IOException;
import java.util.UUID;

/**
 * EnrollmentGet
 */

public class EnrollmentGet extends EnrollmentBase {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_USER_ID = "userId";
  @SerializedName(SERIALIZED_NAME_USER_ID)
  private UUID userId;

  public EnrollmentGet id(UUID id) {
    this.id = id;
    return this;
  }

   /**
   * Enrollment identifier (allocated by the server).
   * @return id
  **/
  @ApiModelProperty(example = "feb37e23-d04e-4e71-bf53-1f1a75ba3a68", value = "Enrollment identifier (allocated by the server).")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public EnrollmentGet userId(UUID userId) {
    this.userId = userId;
    return this;
  }

   /**
   * Id of the enrolled user.
   * @return userId
  **/
  @ApiModelProperty(example = "feb37e23-d04e-4e71-bf53-1f1a75ba3a68", value = "Id of the enrolled user.")
  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnrollmentGet enrollmentGet = (EnrollmentGet) o;
    return Objects.equals(this.id, enrollmentGet.id) &&
        Objects.equals(this.userId, enrollmentGet.userId) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrollmentGet {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

