package com.apihug.rad.api.department;

import com.apihug.rad.domain.department.DepartmentEntity;
import com.apihug.rad.domain.department.repository.DepartmentEntityRepository;
import com.apihug.rad.infra.department.DeptStatusEnum;
import com.apihug.rad.infra.department.DepartmentErrorEnum;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.spring.SimpleResultBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("部门管理 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private DepartmentEntityRepository departmentRepository;

    @Mock
    private SimpleResultBuilder<DepartmentSummary> summaryBuilder;

    @Mock
    private SimpleResultBuilder<DepartmentDetail> detailBuilder;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private SimpleResultBuilder<DepartmentTreeNode> treeNodeBuilder;

    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentServiceImpl(departmentRepository);
    }

    @Test
    @DisplayName("创建部门 - 成功")
    void testCreateDepartment_Success() {
        CreateDepartmentRequest request = new CreateDepartmentRequest()
            .setParentId(0L)
            .setDeptCode("tech_dev")
            .setDeptName("研发部")
            .setSortOrder(10)
            .setStatus(DeptStatusEnum.ACTIVE);

        DepartmentEntity savedEntity = new DepartmentEntity()
            .setId(1L)
            .setParentId(0L)
            .setDeptCode("tech_dev")
            .setDeptName("研发部")
            .setStatus(DeptStatusEnum.ACTIVE);

        when(departmentRepository.existsByDeptCode("tech_dev")).thenReturn(false);
        when(departmentRepository.save(any(DepartmentEntity.class))).thenReturn(savedEntity);

        departmentService.createDepartment(summaryBuilder, request);

        ArgumentCaptor<DepartmentEntity> entityCaptor = ArgumentCaptor.forClass(DepartmentEntity.class);
        verify(departmentRepository).save(entityCaptor.capture());
        DepartmentEntity captured = entityCaptor.getValue();
        assertEquals("tech_dev", captured.getDeptCode());
        verify(summaryBuilder).payload(any(DepartmentSummary.class));
    }

    @Test
    @DisplayName("创建部门 - 代码已存在")
    void testCreateDepartment_CodeExists() {
        CreateDepartmentRequest request = new CreateDepartmentRequest()
            .setDeptCode("existing")
            .setDeptName("现有部门");

        when(departmentRepository.existsByDeptCode("existing")).thenReturn(true);

        assertThrows(HopeErrorDetailException.class, () -> 
            departmentService.createDepartment(summaryBuilder, request));
        verify(departmentRepository, never()).save(any());
    }

    @Test
    @DisplayName("获取部门详情 - 成功")
    void testGetDepartment_Success() {
        Integer departmentId = 1;
        DepartmentEntity entity = new DepartmentEntity()
            .setId(1L)
            .setDeptCode("tech_dev")
            .setDeptName("研发部");

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(entity));

        departmentService.getDepartment(detailBuilder, departmentId);

        verify(detailBuilder).payload(any(DepartmentDetail.class));
    }

    @Test
    @DisplayName("获取部门详情 - 未找到")
    void testGetDepartment_NotFound() {
        Integer departmentId = 999;
        when(departmentRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            departmentService.getDepartment(detailBuilder, departmentId));
    }

    @Test
    @DisplayName("更新部门 - 成功")
    void testUpdateDepartment_Success() {
        Integer departmentId = 1;
        UpdateDepartmentRequest request = new UpdateDepartmentRequest()
            .setDeptName("新名称")
            .setSortOrder(20);

        DepartmentEntity existing = new DepartmentEntity().setId(1L);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(departmentRepository.save(any(DepartmentEntity.class))).thenReturn(existing);

        departmentService.updateDepartment(stringBuilder, departmentId, request);

        verify(departmentRepository).save(any(DepartmentEntity.class));
    }

    @Test
    @DisplayName("更新部门 - 未找到")
    void testUpdateDepartment_NotFound() {
        Integer departmentId = 999;
        when(departmentRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            departmentService.updateDepartment(stringBuilder, departmentId, new UpdateDepartmentRequest()));
    }

    @Test
    @DisplayName("删除部门 - 成功")
    void testDeleteDepartment_Success() {
        Integer departmentId = 1;
        DepartmentEntity entity = new DepartmentEntity().setId(1L);

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(departmentRepository.findByParentId(1L)).thenReturn(Arrays.asList());
        when(departmentRepository.save(any(DepartmentEntity.class))).thenAnswer(invocation -> {
            DepartmentEntity e = invocation.getArgument(0);
            e.setDeleted(true);
            return e;
        });

        departmentService.deleteDepartment(stringBuilder, departmentId);

        assertTrue(entity.isDeleted());
    }

    @Test
    @DisplayName("删除部门 - 有子部门")
    void testDeleteDepartment_HasChildren() {
        Integer departmentId = 1;
        DepartmentEntity entity = new DepartmentEntity().setId(1L);
        List<DepartmentEntity> children = Arrays.asList(new DepartmentEntity().setId(2L));

        when(departmentRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(departmentRepository.findByParentId(1L)).thenReturn(children);

        HopeErrorDetailException exception = assertThrows(HopeErrorDetailException.class, () -> 
            departmentService.deleteDepartment(stringBuilder, departmentId));
        
        verify(departmentRepository, never()).save(any());
        assertNotNull(exception);
    }

    @Test
    @DisplayName("删除部门 - 未找到")
    void testDeleteDepartment_NotFound() {
        Integer departmentId = 999;
        when(departmentRepository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(HopeErrorDetailException.class, () -> 
            departmentService.deleteDepartment(stringBuilder, departmentId));
    }

    @Test
    @DisplayName("获取部门树 - 成功")
    void testGetDepartmentTree_Success() {
        List<DepartmentEntity> allDepts = Arrays.asList(
            new DepartmentEntity().setId(1L).setParentId(0L).setDeptCode("tech"),
            new DepartmentEntity().setId(2L).setParentId(0L).setDeptCode("sales")
        );

        when(departmentRepository.findAll()).thenReturn(allDepts);

        departmentService.getDepartmentTree(treeNodeBuilder);

        verify(departmentRepository).findAll();
        verify(treeNodeBuilder).payload(any(DepartmentTreeNode.class));
    }

    @Test
    @DisplayName("获取部门树 - 空树")
    void testGetDepartmentTree_Empty() {
        when(departmentRepository.findAll()).thenReturn(Arrays.asList());

        departmentService.getDepartmentTree(treeNodeBuilder);

        verify(departmentRepository).findAll();
        verify(treeNodeBuilder).payload(any(DepartmentTreeNode.class));
    }
}
