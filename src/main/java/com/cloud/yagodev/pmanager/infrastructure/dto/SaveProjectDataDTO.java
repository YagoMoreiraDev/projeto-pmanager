package com.cloud.yagodev.pmanager.infrastructure.dto;

import com.cloud.yagodev.pmanager.domain.model.ProjectStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveProjectDataDTO {
    private final String name;
    private final String description;
    private final LocalDate initialDate;
    private final LocalDate finalDate;
    private final ProjectStatus status;
}
