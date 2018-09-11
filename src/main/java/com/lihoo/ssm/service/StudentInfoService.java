package com.lihoo.ssm.service;

import com.lihoo.ssm.model.StudentInfo;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public interface StudentInfoService {
    int deleteByPrimaryKey(Long id);

    List<StudentInfo> selectAll();

    int updateByPrimaryKey(StudentInfo record);

    int insert(StudentInfo studentInfo);

    StudentInfo selectByPrimaryKey(Long id);

    StudentInfo selectByUsername(String username);

    StudentInfo selectByPwd(String pwd);

    int updateLoginTimeById(StudentInfo studentInfo);

    Boolean verifyPwd(StudentInfo studentInfo);

//    Boolean verifyCookie(HttpServletRequest request) throws Exception;

}
