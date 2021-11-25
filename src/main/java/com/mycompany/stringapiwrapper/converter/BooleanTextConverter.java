package com.mycompany.stringapiwrapper.converter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BooleanTextConverter extends AbstractTextConverter<Boolean> {

    @Override
    protected boolean supports(Class<?> clazz) {
        return Boolean.class.isAssignableFrom(clazz);
    }

    @Override
    protected Boolean readInternal(Class<? extends Boolean> clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        throw new UnsupportedOperationException("Reading is not supported");
    }

    @Override
    protected void writeInternal(Boolean aBoolean, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody()
                .write(aBoolean.toString().getBytes());
    }
}
