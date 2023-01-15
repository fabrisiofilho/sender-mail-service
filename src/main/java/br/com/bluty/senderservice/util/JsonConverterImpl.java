package br.com.bluty.senderservice.util;

import com.google.gson.Gson;

public class JsonConverterImpl<T> implements JsonConverter<T>{

    final Class<T> typeParameterClass;
    private Gson gson;

    public JsonConverterImpl(Class<T> typeParameterClass, Gson gson) {
        this.typeParameterClass = typeParameterClass;
        this.gson = gson;
    }

    @Override
    public T jsonToObject(String json) {
        return gson.fromJson(json, typeParameterClass);
    }

    @Override
    public String objectToJson(T object) {
        return gson.toJson(object);
    }

}
