package com.shatcom.fprocessing.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.jsonvalidator.JsonValidationException;

import java.util.List;
import java.util.stream.Collectors;

public class ExceptionMessage implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Object e = exchange.getProperties().get("CamelExceptionCaught");
        if (e != null) {
            if (e instanceof JsonValidationException) {
                JsonValidationException v = (JsonValidationException) e;
                List<String> l = v.getErrors()
                        .stream()
                        .map(validationMessage -> validationMessage.toString())
                        .collect(Collectors.toList());
                exchange.getIn().setBody(" ----- JSON VALIDATION ERRORS --- \n" + String.join("\n", l));
            } else {
                exchange.getIn().setBody(e.toString());
            }
        } else {
            exchange.getIn().setBody("Unknown error occurred.");
        }
    }
}
