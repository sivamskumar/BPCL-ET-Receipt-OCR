package com.bpcl.reconciliation.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class ApplicationProperties {

    private String name;
    private String version;

    private final Storage storage = new Storage();
    private final Ocr ocr = new Ocr();
    private final Retention retention = new Retention();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Storage getStorage() {
        return storage;
    }

    public Ocr getOcr() {
        return ocr;
    }

    public Retention getRetention() {
        return retention;
    }

    public static class Storage {

        private String receiptRoot;
        private String invoiceRoot;

        public String getReceiptRoot() {
            return receiptRoot;
        }

        public void setReceiptRoot(String receiptRoot) {
            this.receiptRoot = receiptRoot;
        }

        public String getInvoiceRoot() {
            return invoiceRoot;
        }

        public void setInvoiceRoot(String invoiceRoot) {
            this.invoiceRoot = invoiceRoot;
        }
    }

    public static class Ocr {

        private double minimumConfidence;

        public double getMinimumConfidence() {
            return minimumConfidence;
        }

        public void setMinimumConfidence(double minimumConfidence) {
            this.minimumConfidence = minimumConfidence;
        }
    }

    public static class Retention {

        private int operationalMonths;

        public int getOperationalMonths() {
            return operationalMonths;
        }

        public void setOperationalMonths(int operationalMonths) {
            this.operationalMonths = operationalMonths;
        }
    }
}