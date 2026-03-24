package com.apihug.rad.api.department;

import com.apihug.rad.domain.department.DepartmentEmployeeEntity;
import com.apihug.rad.domain.department.repository.DepartmentEmployeeEntityRepository;
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

@DisplayName("部门员工管理 Service 单元测试")
@ExtendWith(MockitoExtension.class)
class DepartmentEmployeeServiceImplTest {

    @Mock
    private DepartmentEmployeeEntityRepository employeeRepository;

    @Mock
    private SimpleResultBuilder<String> stringBuilder;

    @Mock
    private SimpleResultBuilder<DepartmentEmployeeList> listBuilder;

    private DepartmentEmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new DepartmentEmployeeServiceImpl(employeeRepository);
    }

    @Test
    @DisplayName("添加员工到部门 - 成功")
    void testAddEmployeeToDepartment_Success() {
        // Arrange
        AddEmployeeRequest request = new AddEmployeeRequest()
            .setEmployeeId(1L)
            .setDepartmentId(2L)
            .setPosition("工程师");

        when(employeeRepository.existsByEmployeeIdAndDepartmentId(1L, 2L)).thenReturn(false);
        when(employeeRepository.save(any(DepartmentEmployeeEntity.class))).thenReturn(new DepartmentEmployeeEntity());

        // Act
        employeeService.addEmployeeToDepartment(stringBuilder, request);

        // Assert
        ArgumentCaptor<DepartmentEmployeeEntity> entityCaptor = ArgumentCaptor.forClass(DepartmentEmployeeEntity.class);
        verify(employeeRepository).save(entityCaptor.capture());
        DepartmentEmployeeEntity captured = entityCaptor.getValue();
        assertEquals(1L, captured.getEmployeeId());
        assertEquals(2L, captured.getDepartmentId());
        assertEquals("工程师", captured.getPosition());
        verify(stringBuilder).done();
    }

    @Test
    @DisplayName("添加员工到部门 - 已存在")
    void testAddEmployeeToDepartment_AlreadyExists() {
        // Arrange
        AddEmployeeRequest request = new AddEmployeeRequest()
            .setEmployeeId(1L)
            .setDepartmentId(2L);

        when(employeeRepository.existsByEmployeeIdAndDepartmentId(1L, 2L)).thenReturn(true);

        // Act
        employeeService.addEmployeeToDepartment(stringBuilder, request);

        // Assert
        verify(employeeRepository, never()).save(any());
        verify(stringBuilder).done();
    }

    @Test
    @DisplayName("从部门移除员工 - 成功")
    void testRemoveEmployeeFromDepartment_Success() {
        // Arrange
        Integer employeeId = 1;
        RemoveEmployeeRequest request = new RemoveEmployeeRequest()
            .setEmployeeId(2L);

        DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity();
        when(employeeRepository.findByEmployeeIdAndDepartmentId(1L, 2L)).thenReturn(Optional.of(entity));

        // Act
        employeeService.removeEmployeeFromDepartment(stringBuilder, employeeId, request);

        // Assert
        verify(employeeRepository).delete(entity);
        verify(stringBuilder).done();
    }

    @Test
    @DisplayName("从部门移除员工 - 不存在")
    void testRemoveEmployeeFromDepartment_NotExists() {
        // Arrange
        Integer employeeId = 1;
        RemoveEmployeeRequest request = new RemoveEmployeeRequest()
            .setEmployeeId(2L);

        when(employeeRepository.findByEmployeeIdAndDepartmentId(1L, 2L)).thenReturn(Optional.empty());

        // Act
        employeeService.removeEmployeeFromDepartment(stringBuilder, employeeId, request);

        // Assert
        verify(employeeRepository, never()).delete(any());
        verify(stringBuilder).done();
    }

    @Test
    @DisplayName("员工调岗 - 成功")
    void testTransferEmployee_Success() {
        // Arrange
        TransferEmployeeRequest request = new TransferEmployeeRequest()
            .setEmployeeId(1L)
            .setFromDepartmentId(2L)
            .setToDepartmentId(3L)
            .setPosition("经理");

        DepartmentEmployeeEntity oldEntity = new DepartmentEmployeeEntity();
        when(employeeRepository.findByEmployeeIdAndDepartmentId(1L, 2L)).thenReturn(Optional.of(oldEntity));
        when(employeeRepository.save(any(DepartmentEmployeeEntity.class))).thenReturn(new DepartmentEmployeeEntity());

        // Act
        employeeService.transferEmployee(stringBuilder, request);

        // Assert
        verify(employeeRepository).delete(oldEntity);
        ArgumentCaptor<DepartmentEmployeeEntity> entityCaptor = ArgumentCaptor.forClass(DepartmentEmployeeEntity.class);
        verify(employeeRepository).save(entityCaptor.capture());
        DepartmentEmployeeEntity captured = entityCaptor.getValue();
        assertEquals(1L, captured.getEmployeeId());
        assertEquals(3L, captured.getDepartmentId());
        assertEquals("经理", captured.getPosition());
        assertTrue(captured.getIsPrimary());
        verify(stringBuilder).done();
    }

    @Test
    @DisplayName("获取部门员工列表 - 成功")
    void testGetDepartmentEmployees_Success() {
        // Arrange
        Integer departmentId = 1;
        List<DepartmentEmployeeEntity> entities = Arrays.asList(
            new DepartmentEmployeeEntity().setEmployeeId(1L).setPosition("工程师"),
            new DepartmentEmployeeEntity().setEmployeeId(2L).setPosition("经理")
        );

        when(employeeRepository.findByDepartmentId(1L)).thenReturn(entities);

        // Act
        employeeService.getDepartmentEmployees(listBuilder, departmentId);

        // Assert
        ArgumentCaptor<DepartmentEmployeeList> listCaptor = ArgumentCaptor.forClass(DepartmentEmployeeList.class);
        verify(listBuilder).payload(listCaptor.capture());
        DepartmentEmployeeList captured = listCaptor.getValue();
        assertEquals(1L, captured.getDepartmentId());
        assertEquals(2, captured.getEmployees().size());
    }

    @Test
    @DisplayName("获取部门员工列表 - 空列表")
    void testGetDepartmentEmployees_Empty() {
        // Arrange
        Integer departmentId = 1;
        when(employeeRepository.findByDepartmentId(1L)).thenReturn(Arrays.asList());

        // Act
        employeeService.getDepartmentEmployees(listBuilder, departmentId);

        // Assert
        ArgumentCaptor<DepartmentEmployeeList> listCaptor = ArgumentCaptor.forClass(DepartmentEmployeeList.class);
        verify(listBuilder).payload(listCaptor.capture());
        DepartmentEmployeeList captured = listCaptor.getValue();
        assertEquals(1L, captured.getDepartmentId());
        assertTrue(captured.getEmployees().isEmpty());
    }
}
