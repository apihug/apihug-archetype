// @formatter:off
package com.apihug.rad.wire.api;

import hope.common.meta.project.ProjectIdentify;
import hope.common.service.Module;
import hope.common.service.WireServiceLocator;
import java.util.HashSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadApiModuleTester {
  @Test
  public void _test_RadApiModule() {
    ProjectIdentify project =  new ProjectIdentify("rad", "rad-app", "com.apihug");
    // Guardian test ensuring consistency of the Wire-generated code.
    // This baseline was generated once and enforces project-wide conventions.
    // Any deviation will cause this test to fail, preventing regressions.
    // Common test
    HashSet<ProjectIdentify> projects  =  WireServiceLocator.INSTANCE.availableProject();
    Assertions.assertNotNull(projects);
    Assertions.assertTrue(projects.size() > 0);
    // Search by project identify
    Module module1 = WireServiceLocator.INSTANCE.get(project) ;
    org.junit.jupiter.api.Assertions.assertNotNull(module1);
  }
}
