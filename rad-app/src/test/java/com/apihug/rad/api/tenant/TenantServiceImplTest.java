package com.apihug.rad.api.tenant;

import com.apihug.rad.domain.tenant.TenantEntity;
import com.apihug.rad.domain.tenant.repository.TenantEntityRepository;
import com.apihug.rad.infra.tenant.TenantErrorEnum;
import com.apihug.rad.infra.tenant.TenantStatusEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.PageableResultBuilder;
import hope.common.spring.SimpleResultBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TenantServiceImplTest {

    @Mock
    private TenantEntityRepository tenantRepository;

    @Mock
    private SimpleResultBuilder<TenantSummary> summaryBuilder;

    @Mock
    private SimpleResultBuilder<TenantDetail> detailBuilder;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private PageableResultBuilder<TenantSummary> pageableBuilder;

    private TenantServiceImpl tenantService;

    @BeforeEach
    void setUp() {
        tenantService = new TenantServiceImpl(tenantRepository);
    }

    @Test
    void testCreateTenant_Success() {
        // Arrange
        CreateTenantRequest request = new CreateTenantRequest()
            .setTenantCode("acme_corp")
            .setTenantName("Acme 公司")
            .setContactEmail("contact@acme.com")
            .setContactPhone("13800138000")
            .setStatus(TenantStatusEnum.ACTIVE);

        TenantEntity savedEntity = new TenantEntity()
            .setId(1L)
            .setTenantCode("acme_corp")
            .setTenantName("Acme 公司")
            .setStatus(TenantStatusEnum.ACTIVE);

        when(tenantRepository.existsByTenantCode("acme_corp")).thenReturn(false);
        when(tenantRepository.save(any(TenantEntity.class))).thenReturn(savedEntity);

        // Act
        tenantService.createTenant(summaryBuilder, request);

        // Assert
        ArgumentCaptor<TenantEntity> entityCaptor = ArgumentCaptor.forClass(TenantEntity.class);
        verify(tenantRepository).save(entityCaptor.capture());
        TenantEntity captured = entityCaptor.getValue();
        assertEquals("acme_corp", captured.getTenantCode());
        assertEquals("Acme 公司", captured.getTenantName());
        assertEquals(TenantStatusEnum.ACTIVE, captured.getStatus());
        verify(summaryBuilder).payload(any(TenantSummary.class));
    }

    @Test
    void testCreateTenant_CodeExists() {
        // Arrange
        CreateTenantRequest request = new CreateTenantRequest()
            .setTenantCode("existing")
            .setTenantName("现有租户");

        when(tenantRepository.existsByTenantCode("existing")).thenReturn(true);

        // Act & Assert
        HopeErrorDetailException exception = assertThrows(
            HopeErrorDetailException.class,
            () -> tenantService.createTenant(summaryBuilder, request)
        );
        verify(tenantRepository, never()).save(any());
        verify(summaryBuilder, never()).payload(any());
    }

    @Test
    void testGetTenant_Success() {
        // Arrange
        Integer tenantId = 1;
        TenantEntity entity = new TenantEntity()
            .setId(1L)
            .setTenantCode("acme_corp")
            .setTenantName("Acme 公司")
            .setContactEmail("contact@acme.com")
            .setStatus(TenantStatusEnum.ACTIVE)
            .setMaxUsers(100)
            .setMaxStorageMb(10240L);

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(entity));

        // Act
        tenantService.getTenant(detailBuilder, tenantId);

        // Assert
        verify(detailBuilder).payload(any(TenantDetail.class));
    }

    @Test
    void testGetTenant_NotFound() {
        // Arrange
        Integer tenantId = 999;
        when(tenantRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
            HopeErrorDetailException.class,
            () -> tenantService.getTenant(detailBuilder, tenantId)
        );
    }

    @Test
    void testUpdateTenant_Success() {
        // Arrange
        Integer tenantId = 1;
        UpdateTenantRequest request = new UpdateTenantRequest()
            .setTenantName("新名称")
            .setContactEmail("new@acme.com")
            .setStatus(TenantStatusEnum.DISABLED);

        TenantEntity existing = new TenantEntity()
            .setId(1L)
            .setTenantCode("acme_corp")
            .setTenantName("Acme 公司");

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(tenantRepository.save(any(TenantEntity.class))).thenReturn(existing);

        // Act
        tenantService.updateTenant(stringBuilder, tenantId, request);

        // Assert
        verify(stringBuilder).done();
        verify(tenantRepository).save(any(TenantEntity.class));
    }

    @Test
    void testUpdateTenant_NotFound() {
        // Arrange
        Integer tenantId = 999;
        UpdateTenantRequest request = new UpdateTenantRequest();

        when(tenantRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
            HopeErrorDetailException.class,
            () -> tenantService.updateTenant(stringBuilder, tenantId, request)
        );
    }

    @Test
    void testDisableTenant_Success() {
        // Arrange
        Integer tenantId = 1;
        TenantEntity entity = new TenantEntity()
            .setId(1L)
            .setStatus(TenantStatusEnum.ACTIVE);

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(tenantRepository.save(any(TenantEntity.class))).thenReturn(entity);

        // Act
        tenantService.disableTenant(stringBuilder, tenantId);

        // Assert
        verify(stringBuilder).done();
        verify(tenantRepository).save(any(TenantEntity.class));
        assertEquals(TenantStatusEnum.DISABLED, entity.getStatus());
    }

    @Test
    void testDisableTenant_NotFound() {
        // Arrange
        Integer tenantId = 999;
        when(tenantRepository.findById(999L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
            HopeErrorDetailException.class,
            () -> tenantService.disableTenant(stringBuilder, tenantId)
        );
    }

    @Test
    void testConfigureTenant_Success() {
        // Arrange
        Integer tenantId = 1;
        ConfigureTenantRequest request = new ConfigureTenantRequest()
            .setMaxUsers(200)
            .setMaxStorageMb(20480L);

        TenantEntity entity = new TenantEntity().setId(1L);

        when(tenantRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(tenantRepository.save(any(TenantEntity.class))).thenReturn(entity);

        // Act
        tenantService.configureTenant(stringBuilder, tenantId, request);

        // Assert
        verify(stringBuilder).done();
        verify(tenantRepository).save(any(TenantEntity.class));
        assertEquals(200, entity.getMaxUsers());
        assertEquals(20480L, entity.getMaxStorageMb());
    }
}
