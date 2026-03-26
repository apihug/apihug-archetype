// @formatter:off
package com.apihug.rad.api.platform;

import hope.common.api.PageRequest;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import java.lang.Long;
import java.lang.String;
import javax.annotation.Generated;

@ProtoFrom(
    value = "com/apihug/rad/api/platform/api.proto",
    entity = "PlatformService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
@Generated("H.O.P.E. Infra Team")
public interface PlatformService {
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
  default void getPlatformMembers(PageableResultBuilder<PlatformMemberInfo> builder,
      GetPlatformMembersRequest getPlatformMembersRequest, PageRequest pageParameter) {
    builder.notImplemented();
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
  default void addPlatformMember(SimpleResultBuilder<String> builder,
      AddPlatformMemberRequest addPlatformMemberRequest) {
    builder.notImplemented();
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
  default void removePlatformMember(SimpleResultBuilder<String> builder, Long memberId) {
    builder.notImplemented();
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
  default void togglePlatformMemberFreeze(SimpleResultBuilder<String> builder, Long memberId) {
    builder.notImplemented();
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
  default void updatePlatformMemberRole(SimpleResultBuilder<String> builder, Long memberId,
      UpdatePlatformMemberRoleRequest updatePlatformMemberRoleRequest) {
    builder.notImplemented();
  }
}
