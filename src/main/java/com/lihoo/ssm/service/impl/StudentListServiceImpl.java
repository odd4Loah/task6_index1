package com.lihoo.ssm.service.impl;

import com.danga.MemCached.MemCachedClient;
import com.lihoo.ssm.dao.StudentListMapper;
import com.lihoo.ssm.model.StudentList;
import com.lihoo.ssm.service.StudentListService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    public static Logger logger = LogManager.getLogger(StudentListServiceImpl.class);

    @Autowired
    StudentListMapper studentListMapper;

    @Autowired
    private MemCachedClient memCachedClient;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentListMapper.deleteByPrimaryKey(id);
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

    @Override
    public List<StudentList> getJavaList() {
        List<StudentList> javaList;
        if (memCachedClient.get("javaList") != null) {
            logger.info("从缓存中取出java学员List");
            javaList = (List<StudentList>) memCachedClient.get("javaList");
            logger.info(javaList);
        } else {
            javaList = studentListMapper.getJavaList();
            memCachedClient.set("javaList", javaList, 60);
        }
        return javaList;
    }

    @Override
    public List<StudentList> getWebList() {
        List<StudentList> webList;
        if (memCachedClient.get("webList") != null) {
            logger.info("从缓存中取出web学员List");
            webList = (List<StudentList>) memCachedClient.get("webList");
            logger.info(webList);
        } else {
            webList = studentListMapper.getWebList();
            memCachedClient.set("webList", webList, 60);
        }
        return webList;
    }


    @Override
    public int insert(StudentList record) {
        int oneStu = studentListMapper.insert(record);
        if (oneStu > 0) {
            logger.info("成功插入一条缓存数据");
            if ("java".equals(record.getStudyType())) {
                List<StudentList> javaLists = studentListMapper.getJavaList();
                logger.info("取出Java学员List：" + javaLists);
                memCachedClient.replace("javaList", javaLists, 60);
                logger.info("缓存中的Java学员List：" + memCachedClient.get("javaList"));
            }
            if ("web".equals(record.getStudyType())) {
                List<StudentList> webLists = studentListMapper.getWebList();
                logger.info("取出Web学员List：" + webLists);
                memCachedClient.replace("webList", webLists, 60);
                logger.info("缓存中的Web学员List：" + memCachedClient.get("webList"));
            }
        } else {
            logger.info("插入缓存失败");
        }
        return oneStu;
    }

}
