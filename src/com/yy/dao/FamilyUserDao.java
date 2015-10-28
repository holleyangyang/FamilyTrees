package com.yy.dao;

import java.util.List;

import org.mybatis.spring.annotation.Mapper;
import org.springframework.stereotype.Service;

import com.yy.entity.FamilyUser;

@Service
@Mapper("familyUserDao")
public interface FamilyUserDao {
	public List<FamilyUser> getUserByTreeId(String treeId);
}
