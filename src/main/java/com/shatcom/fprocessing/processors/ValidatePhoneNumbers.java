package com.shatcom.fprocessing.processors;

import com.shatcom.fprocessing.dto.ProcessingContent;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ValidatePhoneNumbers implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        ProcessingContent processingContent = exchange.getIn().getBody(ProcessingContent.class);
        if (processingContent != null) {
            if (!processingContent.getWorkPhone().substring(0, 3)
                    .equals(processingContent.getMobile().substring(0, 3))) {
                throw new RuntimeException("Error occurred. Mobile phone code doesn't match work phone code.");
            }
        } else {
            throw new RuntimeException("Processing content is NULL");
        }
    }
}
