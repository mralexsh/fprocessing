package com.shatcom.fprocessing.processors;

import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Value;

public class CalculateFileName {

    @Value("${files.marker_extension}")
    private String filesMarkerExtension;

    @Value("${files.extension}")
    private String filesExtension;


    public void makeActualFileHeader(Exchange exchange) throws Exception {
        String fName = exchange.getIn().getHeader("CamelFileNameOnly", String.class);
        exchange.getIn().setHeader("ActualFileName", fName.replaceAll(filesMarkerExtension, filesExtension));
    }

    public void makeMarkerFileHeader(Exchange exchange) throws Exception {
        String fName = exchange.getIn().getHeader("CamelFileNameOnly", String.class);
        exchange.getIn().setHeader("MarkerFileName", fName.replaceAll(filesExtension, filesMarkerExtension));
    }
}
