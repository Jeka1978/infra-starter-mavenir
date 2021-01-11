package com.epam.infrastartermavenir;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evgeny Borisov
 */
@Data
@ConfigurationProperties(prefix = "corona")
public class StarterProps {

    private String packageToScanForException;
    private boolean enabled;
}
