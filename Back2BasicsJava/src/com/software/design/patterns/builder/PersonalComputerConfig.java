package com.software.design.patterns.builder;

public class PersonalComputerConfig {
    // Mandatory
    private final String cabinet;
    private final String motherboard;
    private final String cpu;
    private final String ram;
    private final String psu;
    private final String storage;

    // Optional
    private final String gpu;
    private final String additionalStorage;
    private final String peripherals;

    // Private constructor
    private PersonalComputerConfig(PcBuilder builder) {
        this.cabinet = builder.cabinet;
        this.motherboard = builder.motherboard;
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.psu = builder.psu;
        this.storage = builder.storage;
        // Optioanls are here
        this.gpu = builder.gpu == null ? "None" : builder.gpu;
        this.additionalStorage = builder.additionalStorage == null ? "None" : builder.additionalStorage;
        this.peripherals = builder.peripherals == null ? "None" : builder.peripherals;
    }

    // Public static nested Builder class
    public static class PcBuilder {
        // Mandatory
        private final String cabinet;
        private final String motherboard;
        private final String cpu;
        private final String ram;
        private final String psu;
        private final String storage;

        // Optional
        private String gpu;
        private String additionalStorage;
        private String peripherals;

        public PcBuilder(String cabinet, String motherboard, String cpu, String ram, String psu, String storage) {
            this.cabinet = cabinet;
            this.motherboard = motherboard;
            this.cpu = cpu;
            this.ram = ram;
            this.psu = psu;
            this.storage = storage;
        }

        public PcBuilder addGpu(String nameOfComponent) {
            this.gpu = nameOfComponent;
            return this;
        }

        public PcBuilder addAdditionalStorage(String nameOfComponent) {
            this.additionalStorage = nameOfComponent;
            return this;
        }

        public PcBuilder addPeripherals(String nameOfComponent) {
            this.peripherals = nameOfComponent;
            return this;
        }

        public PersonalComputerConfig build() {
            return new PersonalComputerConfig(this);
        }
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getPsu() {
        return psu;
    }

    public String getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public String getAdditionalStorage() {
        return additionalStorage;
    }

    public String getPeripherals() {
        return peripherals;
    }
}