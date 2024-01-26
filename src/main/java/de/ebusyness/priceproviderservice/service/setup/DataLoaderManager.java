package de.ebusyness.priceproviderservice.service.setup;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoaderManager {

    private final List<SetupDataLoader> dataLoaders;

    @Autowired
    public DataLoaderManager(List<SetupDataLoader> dataLoaders) {
        this.dataLoaders = dataLoaders;
    }

    @PostConstruct
    public void loadData() {
        // Sort data loaders by priority
        List<SetupDataLoader> sortedDataLoaders = dataLoaders.stream()
                .sorted((dl1, dl2) -> Integer.compare(dl1.getPriority(), dl2.getPriority()))
                .collect(Collectors.toList());

        // Load essential data
        for (SetupDataLoader dataLoader : sortedDataLoaders) {
            dataLoader.loadEssentialData();
        }

        // Load sample data
        for (SetupDataLoader dataLoader : sortedDataLoaders) {
            dataLoader.loadSampleData();
        }
    }
}