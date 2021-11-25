package com.mycompany.stringapiwrapper.converter;

import com.mycompany.stringapiwrapper.configuration.MediaTypeExtended;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

public abstract class AbstractCsvConverter<T> extends AbstractHttpMessageConverter<T> {

    private static final MediaType SUPPORTED_MEDIA_TYPE = MediaTypeExtended.TEXT_CSV;

    public AbstractCsvConverter() {
        super(SUPPORTED_MEDIA_TYPE);
    }
}
