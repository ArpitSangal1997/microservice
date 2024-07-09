package com.arpit.department.service;

import com.arpit.department.entity.Department;
import com.arpit.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public Department findByDepartmentId(Long id) {
        log.info("inside service of get department");
        return departmentRepository.findByDepartmentId(id);
    }

    public Department saveDepartment(Department department) {
      log.info("inside service of save department");
      return departmentRepository.save(department);
    }
}
