package com.github.lyrric.store.mapper;

import com.github.lyrric.store.entity.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.BaseMapper;

public interface CompanyInfoMapper extends BaseMapper<CompanyInfo> {

    /**
     * companyId是否重复
     * @param companyId
     * @return
     */
    @Select("select count(1) from (select company_id from company_info where company_id = #{companyId} limit 1) t ")
    Long selectCountByCompanyId(@Param("companyId") String companyId);


}