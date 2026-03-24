// @formatter:off
package com.apihug.rad.wire.api;

import hope.common.meta.artifact.Artifact;
import hope.common.meta.project.Project;
import hope.common.meta.project.ProjectAuthority;
import hope.common.meta.project.ProjectPersistence;
import hope.common.meta.project.ProjectStatus;
import hope.common.service.Module;
import java.lang.Override;
import java.lang.String;

public class RadApiModule implements Module<RadApiCollector> {
  protected final Project project;

  protected final RadApiCollector api;

  public RadApiModule() {
    project =  new Project();
    api =  new RadApiCollector();
    project.setName("rad");
    project.setDescription("apihug rapid application development template");
    project.setDomain("rad");
    project.setPackageName("com.apihug.rad");
    project.setApplication("rad-app");
    project.setIdentifier("rad");
    project.setApiRoot("/api");
    Artifact artifact = new Artifact();
    project.setArtifact(artifact);
    artifact.setArtifactId("rad-app");
    artifact.setGroupId("com.apihug");
    artifact.setVersion("0.1.1-SNAPSHOT");
    ProjectStatus status = new ProjectStatus();
    project.setStatus(status);
    status.setCreatedTimestamp("2026-03-20");
    status.setCreatedBy("admin");
    ProjectAuthority authority = new ProjectAuthority();
    project.setAuthority(authority);
    authority.setEnumClass("com.apihug.rad.infra.settings.RadAuthorityEnum");
    authority.setCodePrefix(10240000L);
    ProjectPersistence persistence = new ProjectPersistence();
    project.setPersistence(persistence);
    persistence.setIdentifyType(ProjectPersistence.Type.LONG);
    persistence.setTenantType(ProjectPersistence.Type.LONG);
    persistence.setFormat(ProjectPersistence.Format.DEFAULT);
    persistence.setUpper(ProjectPersistence.Upper.DEFAULT);
  }

  @Override
  public Project project() {
    return project;
  }

  @Override
  public RadApiCollector service() {
    return api;
  }

  @Override
  public String version() {
    return "0.1.1-SNAPSHOT";
  }
}
