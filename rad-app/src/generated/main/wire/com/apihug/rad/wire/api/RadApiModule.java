package com.apihug.rad.wire.api;

import hope.common.meta.project.Project;
import hope.common.service.Module;
import hope.common.service.Collector;

/**
 * This is placeholder {@code Module} will be re-generated after the {@code wire} command
 */
public class RadApiModule implements Module {
    @Override
    public Collector service() {
        throw new IllegalStateException("this is mock Module, will be overwrite after wire command");
    }

    @Override
    public Project project() {
        throw new IllegalStateException(
                "this is mock module, will be overwrite after the wire command");
    }
}