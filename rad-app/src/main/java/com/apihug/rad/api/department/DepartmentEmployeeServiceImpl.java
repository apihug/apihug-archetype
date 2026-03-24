// @formatter:off
package com.apihug.rad.api.department;

import com.apihug.rad.domain.department.DepartmentEmployeeEntity;
import com.apihug.rad.domain.department.repository.DepartmentEmployeeEntityRepository;
import hope.common.api.exceptions.HopeErrorDetailException;
import hope.common.meta.annotation.Kind;
import hope.common.meta.annotation.ProtoFrom;
import hope.common.meta.annotation.Template;import hope.common.spring.SimpleResultBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Template(type = Template.Type.SERVICE, usage = "Department employee management", percentage = 90)
@Service
@SuppressWarnings("Duplicates")
@ProtoFrom(
    value = "com/apihug/rad/api/department/employee.proto",
    entity = "DepartmentEmployeeService",
    kind = Kind.RPC,
    line = 10,
    column = 1
)
public class DepartmentEmployeeServiceImpl implements DepartmentEmployeeService {

  private final DepartmentEmployeeEntityRepository employeeRepository;

  public DepartmentEmployeeServiceImpl(DepartmentEmployeeEntityRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public void addEmployeeToDepartment(SimpleResultBuilder<String> builder,
      AddEmployeeRequest addEmployeeRequest) {
    // 检查是否已存在
    if (employeeRepository.existsByEmployeeIdAndDepartmentId(
        addEmployeeRequest.getEmployeeId(), addEmployeeRequest.getDepartmentId())) {
      builder.done();
      return;
    }

    // 创建关联
    DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity()
        .setEmployeeId(addEmployeeRequest.getEmployeeId())
        .setDepartmentId(addEmployeeRequest.getDepartmentId())
        .setPosition(addEmployeeRequest.getPosition())
        .setIsPrimary(false);

    employeeRepository.save(entity);
    builder.done();
  }

  @Override
  public void removeEmployeeFromDepartment(SimpleResultBuilder<String> builder,
      Integer employeeId, RemoveEmployeeRequest removeEmployeeRequest) {
    // employeeId 从路径参数获取，removeEmployeeRequest 用于未来扩展
    employeeRepository.findByEmployeeIdAndDepartmentId(employeeId.longValue(),
        removeEmployeeRequest.getEmployeeId())
        .ifPresent(employeeRepository::delete);

    builder.done();
  }

  @Override
  public void transferEmployee(SimpleResultBuilder<String> builder,
      TransferEmployeeRequest transferEmployeeRequest) {
    // 从原部门移除
    employeeRepository.findByEmployeeIdAndDepartmentId(
        transferEmployeeRequest.getEmployeeId(),
        transferEmployeeRequest.getFromDepartmentId())
        .ifPresent(employeeRepository::delete);

    // 添加到新部门
    DepartmentEmployeeEntity entity = new DepartmentEmployeeEntity()
        .setEmployeeId(transferEmployeeRequest.getEmployeeId())
        .setDepartmentId(transferEmployeeRequest.getToDepartmentId())
        .setPosition(transferEmployeeRequest.getPosition())
        .setIsPrimary(true);

    employeeRepository.save(entity);
    builder.done();
  }

  @Override
  public void getDepartmentEmployees(SimpleResultBuilder<DepartmentEmployeeList> builder,
      Integer departmentId) {
    List<DepartmentEmployeeEntity> employees =
        employeeRepository.findByDepartmentId(departmentId.longValue());

    DepartmentEmployeeList list = new DepartmentEmployeeList();
    list.setDepartmentId(departmentId.longValue());
    list.setEmployees(employees.stream()
        .map(e -> {
          EmployeeInfo info = new EmployeeInfo();
          info.setId(e.getEmployeeId());
          info.setPosition(e.getPosition());
          info.setJoinedAt(LocalDateTime.now());
          return info;
        })
        .collect(Collectors.toList()));

    builder.payload(list);
  }
}
