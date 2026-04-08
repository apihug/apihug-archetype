// @formatter:off
package com.apihug.rad.api.permission;

import com.apihug.rad.domain.security.CustomerPermissionResolver;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.security.context.HopeContextHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Permission management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/permission/api.proto",
    entity = "PermissionService",
    kind = Kind.RPC,
    line = 10,
    column = 1)
public class PermissionServiceImpl implements PermissionService {

  private final CustomerPermissionResolver permissionResolver;

  public PermissionServiceImpl(CustomerPermissionResolver permissionResolver) {
    this.permissionResolver = permissionResolver;
  }

  /**
   * @apiNote
   *     <p>{@code /api/permissions/roles}
   *     <p>{@code 获取用户的角色权限集合}
   */
  @Override
  public void getRolePermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    Long customerId = (Long) HopeContextHolder.customer().getId();
    Long tenantId = (Long) HopeContextHolder.customer().getTenantId();

    Set<String> roles = permissionResolver.resolveRoles(customerId, tenantId);
    List<PermissionInfo> permissions =
        roles.stream()
            .map(code -> new PermissionInfo().setPermissionCode(code).setPermissionName(code))
            .collect(Collectors.toList());

    builder.payload(permissions);
  }

  /**
   * @apiNote
   *     <p>{@code /api/permissions/menus}
   *     <p>{@code 获取用户的菜单权限集合}
   */
  @Override
  public void getMenuPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    Long customerId = (Long) HopeContextHolder.customer().getId();
    Long tenantId = (Long) HopeContextHolder.customer().getTenantId();

    Set<String> authorities = permissionResolver.resolveAuthorities(customerId, tenantId);
    List<PermissionInfo> permissions =
        authorities.stream()
            .map(code -> new PermissionInfo().setPermissionCode(code).setPermissionName(code))
            .collect(Collectors.toList());

    builder.payload(permissions);
  }

  /**
   * @apiNote
   *     <p>{@code /api/permissions/all}
   *     <p>{@code 获取用户的所有权限（聚合）}
   */
  @Override
  public void getAllPermissions(SimpleResultBuilder<List<PermissionInfo>> builder) {
    Long customerId = (Long) HopeContextHolder.customer().getId();
    Long tenantId = (Long) HopeContextHolder.customer().getTenantId();

    Set<String> roles = permissionResolver.resolveRoles(customerId, tenantId);
    Set<String> authorities = permissionResolver.resolveAuthorities(customerId, tenantId);

    List<PermissionInfo> allPermissions = new ArrayList<>();

    // 角色
    roles.forEach(
        code ->
            allPermissions.add(
                new PermissionInfo().setPermissionCode("role:" + code).setPermissionName(code)));

    // 权限
    authorities.forEach(
        code ->
            allPermissions.add(
                new PermissionInfo().setPermissionCode(code).setPermissionName(code)));

    builder.payload(allPermissions);
  }
}
