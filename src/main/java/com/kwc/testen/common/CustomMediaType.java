package com.kwc.testen.common;

import javax.ws.rs.core.MediaType;

/**
 * @author Marius Kristensen
 */
public class CustomMediaType {
    public static final String DELIMITER = ";";
    public static final String UTF_8 = "utf-8";
    public static final String EQUALS = "=";
    public static final String APPLICATION_JSON_UTF = MediaType.APPLICATION_JSON + DELIMITER + MediaType.CHARSET_PARAMETER + EQUALS + UTF_8;

}
