package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private long period = 10_000_000_000_000L;
    protected String processorVersion;
    private int valueOfCheap;

    public LocalProcessor(String processorName, long period,
                          String processorVersion, int valueOfCheap) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void iterateListHashCodes(List<String> stringList) {
        for (String str: stringList) {
            System.out.println(str.hashCode());
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullNameProcessor(List<String> stringList) {
        return processorName += String.join(" ", stringList);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        try (Scanner informationScanner = new Scanner(file)) {
            StringBuilder version = new StringBuilder(processorVersion);
            while (informationScanner.hasNext()) {
                version.append(informationScanner.nextLine());
            }
            processorVersion = version.toString();
        }
    }
}
