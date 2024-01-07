package de.ebusyness.priceproviderservice.service.setup;

public interface SetupDataLoader {
    int getPriority();

    void loadEssentialData();

    void loadSampleData();
}