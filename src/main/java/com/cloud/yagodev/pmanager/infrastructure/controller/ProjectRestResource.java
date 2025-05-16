package com.cloud.yagodev.pmanager.infrastructure.controller;

import com.cloud.yagodev.pmanager.domain.applicationservice.ProjectService;
import com.cloud.yagodev.pmanager.domain.entity.Project;
import com.cloud.yagodev.pmanager.infrastructure.dto.ProjectDTO;
import com.cloud.yagodev.pmanager.infrastructure.dto.SaveProjectDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(RestConstants.PATH_PROJECT)
@RequiredArgsConstructor
public class ProjectRestResource {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody SaveProjectDataDTO saveProjectDataDTO) {
        Project project = projectService.createProject(saveProjectDataDTO);
        return ResponseEntity.created(URI.create(RestConstants.PATH_PROJECT + "/" + project.getId()))
                .body(ProjectDTO.create(project));
    }
}
