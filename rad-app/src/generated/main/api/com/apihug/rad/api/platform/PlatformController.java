// @formatter:off
package com.apihug.rad.api.platform;

import hope.common.api.PageRequest;
import hope.common.api.Pageable;
import hope.common.api.Result;
import hope.common.api.annotation.ParameterObject;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.service.Priority;
import hope.common.service.api.ServiceMethod;
import hope.common.service.api.ServiceMethodContext;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import hope.common.spring.aspect.Aspect;
import hope.common.spring.aspect.AspectManager;
import hope.common.spring.helper.PageRequestGuardian;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import java.lang.Long;
import java.lang.String;
import java.lang.System;
import java.lang.Throwable;
import java.util.Map;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "PlatformService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public class PlatformController {
  public static final String _SVC_NAME = "com.apihug.rad.api.platform.PlatformService";

  protected final PlatformService _service;

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public PlatformController(PlatformService service) {
    this._service = service;
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [PLATFORM_MEMBER_VIEW]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/members}
   * 	<p>{@code 获取平台成员列表，支持状态筛选和关键词搜索}
   */
  @GetMapping("/api/platforms/members")
  public ResponseEntity<Result<Pageable<PlatformMemberInfo>>> getPlatformMembers(
      @ParameterObject GetPlatformMembersRequest getPlatformMembersRequest,
      @ParameterObject PageRequest pageParameter) {
    final PageableResultBuilder<PlatformMemberInfo> builder = new PageableResultBuilder<PlatformMemberInfo>();
    getPlatformMembersRequest = getPlatformMembersRequest == null ? new GetPlatformMembersRequest(): getPlatformMembersRequest;
    pageParameter = PageRequestGuardian.guard(pageParameter);
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "getPlatformMembersRequest", getPlatformMembersRequest, "pageParameter", pageParameter);
    try {
      aspect().before(Apis.GetPlatformMembers, _ctx);
      _service.getPlatformMembers(builder, getPlatformMembersRequest, pageParameter);
      ResponseEntity<Result<Pageable<PlatformMemberInfo>>> res = builder.done();
      aspect().after(Apis.GetPlatformMembers, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.GetPlatformMembers, exception);
      aspect().exception(Apis.GetPlatformMembers, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [PLATFORM_MEMBER_ADD]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/members}
   * 	<p>{@code 将指定客户添加为平台成员，并设置平台角色}
   */
  @PostMapping("/api/platforms/members")
  public ResponseEntity<Result<String>> addPlatformMember(
      @RequestBody @Valid AddPlatformMemberRequest addPlatformMemberRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    addPlatformMemberRequest = addPlatformMemberRequest == null ? new AddPlatformMemberRequest(): addPlatformMemberRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "addPlatformMemberRequest", addPlatformMemberRequest);
    try {
      aspect().before(Apis.AddPlatformMember, _ctx);
      _service.addPlatformMember(builder, addPlatformMemberRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.AddPlatformMember, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.AddPlatformMember, exception);
      aspect().exception(Apis.AddPlatformMember, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [PLATFORM_MEMBER_REMOVE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/members/{memberId}}
   * 	<p>{@code 移除平台成员，同时重置客户的 platform_type 为 NA。OWNER 角色不允许被移除}
   */
  @DeleteMapping("/api/platforms/members/{memberId}")
  public ResponseEntity<Result<String>> removePlatformMember(
      @Valid @PathVariable(name = "memberId", required = true) @Min(1) Long memberId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "memberId", memberId);
    try {
      aspect().before(Apis.RemovePlatformMember, _ctx);
      _service.removePlatformMember(builder, memberId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.RemovePlatformMember, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.RemovePlatformMember, exception);
      aspect().exception(Apis.RemovePlatformMember, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [PLATFORM_MEMBER_FREEZE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/members/{memberId}/toggle-freeze}
   * 	<p>{@code 切换平台成员冻结状态：PM_ACTIVE ↔ PM_LOCKED}
   */
  @PostMapping("/api/platforms/members/{memberId}/toggle-freeze")
  public ResponseEntity<Result<String>> togglePlatformMemberFreeze(
      @Valid @PathVariable(name = "memberId", required = true) @Min(1) Long memberId) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "memberId", memberId);
    try {
      aspect().before(Apis.TogglePlatformMemberFreeze, _ctx);
      _service.togglePlatformMemberFreeze(builder, memberId);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.TogglePlatformMemberFreeze, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.TogglePlatformMemberFreeze, exception);
      aspect().exception(Apis.TogglePlatformMemberFreeze, _ctx, exception);
      throw exception;
    }
  }

  /**
   *
   * Authorization:
   *
   * <ul>
   * 	<li>PredefinedRoleCheckerType: PLATFORM</li>
   * 	<li>Authorities: [PLATFORM_MEMBER_UPDATE_ROLE]</li>
   * </ul>
   * @apiNote
   * 	<p>{@code /api/platforms/members/{memberId}/role}
   * 	<p>{@code 更新平台成员的平台角色（MEMBER/MANAGER/OWNER），并同步更新 CustomerEntity.platform_type}
   */
  @PutMapping("/api/platforms/members/{memberId}/role")
  public ResponseEntity<Result<String>> updatePlatformMemberRole(
      @Valid @PathVariable(name = "memberId", required = true) @Min(1) Long memberId,
      @RequestBody @Valid UpdatePlatformMemberRoleRequest updatePlatformMemberRoleRequest) {
    final SimpleResultBuilder<String> builder = new SimpleResultBuilder<String>();
    updatePlatformMemberRoleRequest = updatePlatformMemberRoleRequest == null ? new UpdatePlatformMemberRoleRequest(): updatePlatformMemberRoleRequest;
    final Map<String, Object> _ctx = Map.of(Aspect.START_TIME, System.currentTimeMillis(), Aspect.CHANNEL, "API", "memberId", memberId, "updatePlatformMemberRoleRequest", updatePlatformMemberRoleRequest);
    try {
      aspect().before(Apis.UpdatePlatformMemberRole, _ctx);
      _service.updatePlatformMemberRole(builder, memberId, updatePlatformMemberRoleRequest);
      ResponseEntity<Result<String>> res = builder.done();
      aspect().after(Apis.UpdatePlatformMemberRole, _ctx, res);
      return res;
    } catch (Throwable exception) {
      logger.error("FAIL_ACTION" + Apis.UpdatePlatformMemberRole, exception);
      aspect().exception(Apis.UpdatePlatformMemberRole, _ctx, exception);
      throw exception;
    }
  }

  public AspectManager aspect() {
    return AspectManager.get();
  }

  public interface Apis {
    ServiceMethodContext GetPlatformMembers = new ServiceMethodContext("com.apihug.rad.api.platform.PlatformService", "GetPlatformMembers", "/api/platforms/members", Priority.LOW, ServiceMethod.HttpMethod.GET);

    ServiceMethodContext AddPlatformMember = new ServiceMethodContext("com.apihug.rad.api.platform.PlatformService", "AddPlatformMember", "/api/platforms/members", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext RemovePlatformMember = new ServiceMethodContext("com.apihug.rad.api.platform.PlatformService", "RemovePlatformMember", "/api/platforms/members/{memberId}", Priority.LOW, ServiceMethod.HttpMethod.DELETE);

    ServiceMethodContext TogglePlatformMemberFreeze = new ServiceMethodContext("com.apihug.rad.api.platform.PlatformService", "TogglePlatformMemberFreeze", "/api/platforms/members/{memberId}/toggle-freeze", Priority.LOW, ServiceMethod.HttpMethod.POST);

    ServiceMethodContext UpdatePlatformMemberRole = new ServiceMethodContext("com.apihug.rad.api.platform.PlatformService", "UpdatePlatformMemberRole", "/api/platforms/members/{memberId}/role", Priority.LOW, ServiceMethod.HttpMethod.PUT);
  }
}
