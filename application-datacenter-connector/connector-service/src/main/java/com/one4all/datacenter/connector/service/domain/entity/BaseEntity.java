package com.one4all.datacenter.connector.service.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 基础信息
 *
 * @author liuxq
 * @since 2017-01-31 21:42
 */
public class BaseEntity implements Serializable {
	
/*	@Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
    @Transient
    private Integer page = 1;

    /**
     * 每页行数
     */
    @Transient
    private Integer rows = 10;
    
    /**
     * 总行数
     */
    @Transient
    private Integer total = 0;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
