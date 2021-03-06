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
 * API token status (a &#x60;blocked&#x60; API token cannot be used).
 */
@JsonAdapter(APITokenStatusEnum.Adapter.class)
public enum APITokenStatusEnum {
  
  ACTIVE("active"),
  
  BLOCKED("blocked");

  private String value;

  APITokenStatusEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static APITokenStatusEnum fromValue(String text) {
    for (APITokenStatusEnum b : APITokenStatusEnum.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + text + "'");
  }

  public static class Adapter extends TypeAdapter<APITokenStatusEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final APITokenStatusEnum enumeration) throws IOException {
      jsonWriter.value(enumeration.getValue());
    }

    @Override
    public APITokenStatusEnum read(final JsonReader jsonReader) throws IOException {
      String value = jsonReader.nextString();
      return APITokenStatusEnum.fromValue(String.valueOf(value));
    }
  }
}

