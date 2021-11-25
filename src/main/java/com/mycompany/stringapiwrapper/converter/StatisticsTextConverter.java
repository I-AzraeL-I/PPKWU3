package com.mycompany.stringapiwrapper.converter;

import com.mycompany.stringapiwrapper.dto.Statistics;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StatisticsTextConverter extends AbstractTextConverter<Statistics> {

    @Override
    protected boolean supports(Class<?> clazz) {
        return Statistics.class.isAssignableFrom(clazz);
    }

    @Override
    protected Statistics readInternal(Class<? extends Statistics> clazz, HttpInputMessage inputMessage) throws HttpMessageNotReadableException {
        throw new UnsupportedOperationException("Reading is not supported");
    }

    @Override
    protected void writeInternal(Statistics statistics, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody()
                .write(statistics.toString().getBytes());
    }
}
