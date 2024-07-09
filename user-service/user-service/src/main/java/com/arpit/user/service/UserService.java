package com.arpit.user.service;

import com.arpit.user.VO.Department;
import com.arpit.user.VO.ResponseTemplateVO;
import com.arpit.user.entity.User;
import com.arpit.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside save method of user");
        return repository.save(user);
    }

    public ResponseTemplateVO getaUserWithDepartment(Long id) {
        ResponseTemplateVO vo =new ResponseTemplateVO();
        User user = repository.findByUserId(id);
        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
