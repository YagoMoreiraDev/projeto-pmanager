package com.cloud.yagodev.pmanager.domain.applicationservice;

import com.cloud.yagodev.pmanager.domain.entity.Project;
import com.cloud.yagodev.pmanager.domain.model.ProjectStatus;
import com.cloud.yagodev.pmanager.domain.repository.ProjectRepository;
import com.cloud.yagodev.pmanager.infrastructure.dto.SaveProjectDataDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public Project createProject(SaveProjectDataDTO saveProjectDataDTO) {

        var project = Project.builder()
                .name(saveProjectDataDTO.getName())
                .description(saveProjectDataDTO.getDescription())
                .initialDate(saveProjectDataDTO.getInitialDate())
                .finalDate(saveProjectDataDTO.getFinalDate())
                .status(ProjectStatus.PENDING)
                .build();
        log.info("Projeto criado: {}", project);
        return projectRepository.save(project);

    }
}
