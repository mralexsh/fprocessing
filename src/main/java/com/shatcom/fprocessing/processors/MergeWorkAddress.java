package com.shatcom.fprocessing.processors;

import com.shatcom.fprocessing.dto.ProcessingContent;
import com.shatcom.fprocessing.dto.WorkAddressInfo;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MergeWorkAddress implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        WorkAddressInfo workAddressInfo = exchange.getIn().getBody(WorkAddressInfo.class);
        ProcessingContent processingContent = exchange.getIn().getHeader("PreservePOJOContent", ProcessingContent.class);
        if (workAddressInfo != null ) {
            processingContent.setWorkAddress(workAddressInfo.getWorkAddress());
        }
        exchange.getIn().setBody(processingContent);
    }
}
