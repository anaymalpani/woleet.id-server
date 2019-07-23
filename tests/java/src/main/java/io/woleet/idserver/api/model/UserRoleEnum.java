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
import io.swagger.annotations.ApiModel;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * User role.
 */
@JsonAdapter(UserRoleEnum.Adapter.class)
public enum UserRoleEnum {
  
  USER("user"),
  
  ADMIN("admin");

  private String value;

  UserRoleEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static UserRoleEnum fromValue(String text) {
    for (UserRoleEnum b : UserRoleEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }

  public static class Adapter extends TypeAdapter<UserRoleEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final UserRoleEnum enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public UserRoleEnum read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return UserRoleEnum.fromValue(String.valueOf(value));
    }
  }
}

