package com.lihoo.ssm.service.impl;

import com.lihoo.ssm.dao.StudentListMapper;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * #Title: StudentListServiceImpl
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/10-18:27
 */

@Service
public class StudentListServiceImpl implements StudentListService {

    @Autowired
    StudentListMapper studentListMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(StudentList record) {
        return studentListMapper.insert(record);
    }

    @Override
    public StudentList selectByPrimaryKey(Long id) {
        return studentListMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<StudentList> selectAll() {
        return studentListMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(StudentList record) {
        return studentListMapper.updateByPrimaryKey(record);
    }
}
