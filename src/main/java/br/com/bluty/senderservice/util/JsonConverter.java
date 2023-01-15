package br.com.bluty.senderservice.util;

public interface JsonConverter<T> {

    T jsonToObject(String json);

    String objectToJson(T object);

}
