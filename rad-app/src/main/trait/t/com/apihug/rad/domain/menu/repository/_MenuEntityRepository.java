// @formatter:off
package t.com.apihug.rad.domain.menu.repository;

import com.apihug.rad.domain.menu.MenuEntity;
import com.apihug.rad.domain.menu.repository.MenuEntityRepository;
import com.apihug.rad.infra.menu.MenuStatusEnum;
import hope.common.meta.annotation.Template;
import hope.common.spring.data.persistence.spring.EasyCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.relational.core.query.Criteria;
import java.util.List;
import java.util.Optional;
import static com.apihug.rad.domain.menu.dsl.MenuEntityDSL.*;

/**
 * @see MenuEntityRepository
 * @see com.apihug.rad.domain.menu.MenuEntity
 */
@Template(type = Template.Type.TRAIT, usage = "Menu repository extension")
interface _MenuEntityRepository extends MenuEntityRepository {

  @Query
  Optional<MenuEntity> findByMenuCode(String menuCode);

  @Query
  boolean existsByMenuCode(String menuCode);

  @Query
  List<MenuEntity> findByParentId(Long parentId);

  // ========== Tenant-scoped query methods ==========

  @Query
  boolean existsByMenuCodeAndTenantId(String menuCode, Long tenantId);

  @Query
  List<MenuEntity> findByParentIdAndTenantId(Long parentId, Long tenantId);

  @Query
  List<MenuEntity> findByTenantIdAndDeletedFalse(Long tenantId);

  // ========== 搜索方法（使用 EasyCriteria） ==========

  @Query
  default Page<MenuEntity> searchMenus(
      Long tenantId,
      String keyword,
      com.apihug.rad.infra.menu.MenuTypeEnum menuType,
      MenuStatusEnum status,
      hope.common.api.PageRequest pageParameter) {
    var pageable = page(pageParameter);
    Criteria criteria = EasyCriteria.eq(_Tenantable_.TENANT_ID, tenantId)
        .and(EasyCriteria.eq(_Deletable_.DELETED, false));

    if (keyword != null && !keyword.isBlank()) {
      criteria = criteria.and(
          EasyCriteria.like(Domain.MenuCode, keyword)
              .or(EasyCriteria.like(Domain.MenuName, keyword)));
    }

    if (menuType != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.MenuType, menuType.name()));
    }

    if (status != null) {
      criteria = criteria.and(EasyCriteria.eq(Domain.Status, status.name()));
    }

    return this.findAll(criteria, pageable);
  }
}
