package com.amiaka.InitialDepoService;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.amiaka.Models.InitialDeposite;

@Mapper
public interface InitialDepoMapper {
	
   @Select("SELECT * FROM INITIAL_DEPOSITE")	
   InitialDeposite[] getInitialDeposites();
}
