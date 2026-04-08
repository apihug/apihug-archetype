package com.apihug.rad.domain.security;

import com.apihug.rad.domain.platform.PlatformMemberEntity;
import com.apihug.rad.domain.platform.repository.PlatformMemberEntityRepository;
import com.apihug.rad.domain.tenant.TenantMemberEntity;
import com.apihug.rad.domain.tenant.repository.TenantMemberEntityRepository;
import com.apihug.rad.infra.platform.PlatformMemberStatusEnum;
import com.apihug.rad.infra.security.RadCustomer;
import com.apihug.rad.infra.tenant.TenantMemberStatusEnum;
import hope.common.meta.annotation.Template;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Service for resolving and populating customer's platform-level and tenant-level role types.
 *
 * <p>This service retrieves the membership information for a customer at both platform and tenant
 * levels, then populates the corresponding role types into the {@link RadCustomer} object. This
 * enables the customer object to carry predefined role type information for authorization and
 * access control purposes.
 *
 * <p>The resolution process:
 * <ul>
 *   <li>Platform level: Determines the customer's role within the entire platform ecosystem</li>
 *   <li>Tenant level: Determines the customer's role within a specific tenant organization</li>
 * </ul>
 *
 * @see RadCustomer
 * @see PlatformMemberEntity
 * @see TenantMemberEntity
 */
@Template(
    type = Template.Type.SERVICE,
    usage = "Customer Platform and tenant predefined type resolve",
    percentage = 70)
@Service
public class CustomerPlatformTenantPredefinedTypeService {

  /** Repository for accessing platform member entities. */
  protected final PlatformMemberEntityRepository platformMemberEntityRepository;

  /** Repository for accessing tenant member entities. */
  protected final TenantMemberEntityRepository tenantMemberEntityRepository;

  /**
   * Constructs a new instance with the required repositories.
   *
   * @param platformMemberEntityRepository repository for platform membership data
   * @param tenantMemberEntityRepository repository for tenant membership data
   */
  public CustomerPlatformTenantPredefinedTypeService(
      PlatformMemberEntityRepository platformMemberEntityRepository,
      TenantMemberEntityRepository tenantMemberEntityRepository) {
    this.platformMemberEntityRepository = platformMemberEntityRepository;
    this.tenantMemberEntityRepository = tenantMemberEntityRepository;
  }

  /**
   * Populates the platform and tenant role types for the given customer.
   *
   * <p>This method queries the platform and tenant membership records for the customer and sets
   * the corresponding role types on the customer object. Only active memberships are considered;
   * inactive or non-existent memberships are silently ignored.
   *
   * <p>The method performs the following operations:
   * <ol>
   *   <li>Queries the customer's platform membership by customer ID</li>
   *   <li>If the platform membership is active, sets the platform role type</li>
   *   <li>Queries the customer's tenant membership by customer ID and tenant ID</li>
   *   <li>If the tenant membership is active, sets the tenant role type</li>
   * </ol>
   *
   * <p><b>Note:</b> Consider implementing caching for better performance as this method may be
   * called frequently during authentication and authorization flows.
   *
   * @param customer the customer object to populate with role type information; must have a valid
   *                 ID and tenant ID set before calling this method
   */
  // TODO Should we cache it?
  public void popupCustomerPlatformAndTenantRoleType(RadCustomer customer) {
    // Resolve platform-level role type
    Optional<PlatformMemberEntity> optionalPlatformMember =
        platformMemberEntityRepository.findByCustomerId(customer.getId());
    if (optionalPlatformMember.isPresent()) {
      PlatformMemberEntity platformMemberEntity = optionalPlatformMember.get();
      if (PlatformMemberStatusEnum.PM_ACTIVE == platformMemberEntity.getStatus()) {
        customer.setPlatformType(platformMemberEntity.getPlatformRole());
      }
    }

    // Resolve tenant-level role type
    Optional<TenantMemberEntity> optionalTenantMemberEntity =
        tenantMemberEntityRepository.findByCustomerIdAndTenantId(
            customer.getId(), customer.getTenantId());
    if (optionalTenantMemberEntity.isPresent()) {
      TenantMemberEntity tenantMemberEntity = optionalTenantMemberEntity.get();
      if (TenantMemberStatusEnum.TM_ACTIVE == tenantMemberEntity.getStatus()) {
        customer.setTenantType(tenantMemberEntity.getMemberRole());
      }
    }
  }
}
