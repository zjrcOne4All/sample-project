package com.one4all.datacenter.connector.service.dao.h2;

import com.one4all.datacenter.connector.service.domain.entity.h2.BiOrderTable;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface H2OrderMapper {

    /**
     * 不使用tk.mybatis通用mapper，采用mybatis原生注解式sql的样例
     * @return
     */
    @Select("Select * from BI_ORDER_TABLE")
    List<BiOrderTable> selectAll();

}
