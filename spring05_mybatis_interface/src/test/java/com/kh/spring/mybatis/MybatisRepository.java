package com.kh.spring.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.model.dto.Member;

@Mapper
public interface MybatisRepository {

	@Select("select password from member where user_id = #{userId}")
	String selectPasswordByUserId(String userId);
	
	@Select("select * from member where user_id = #{userId}")
	Member selectMemberByUserId(String userId);
	
	@Select("select *"
			+ "  		from member"
			+ "  		inner join rent_master using(user_id)"
			+ "  		where user_id = #{userId}")
	List<Map<String,Object>> selectRentAndMemberByUserId(String userId);
	
	List<Map<String,Object>> selectRentBookByUserId(String userId);
	
	void insertWithDto(Member member);
	
	void insertWithMap(Map<String,Object> commandMap);
	
	@Delete("delete from member where user_id = #{userId}")
	void delete(String userId);
	
	@Update("update member set password = #{password} where user_id=#{userId} ")
	void update(Member member);
	
	
	@Update("{call sp_rent_extend(#{rbIdx,mode=IN})}")
	void procedure(String bkIdx);
	
	@Insert("insert into book (TITLE, AUTHOR, BK_IDX) values (#{title}, #{author}, SC_BK_IDX.nextval)")
	void test01(Map<String,String> book);
	
	@Update("update rent_book set extension_cnt = 0 where extension_cnt &gt;= 2")
	void test02();
	
	
}
