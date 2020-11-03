package com.github.lyrric.store.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.IdentityDialect;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * ID自增
 * @author
 * @version $Id: IdAutoIncrementStrategy.java, v0.1 2018/11/4 0:06
 */
@Data
public class BaseEntity {

    @Id
    @KeySql(dialect = IdentityDialect.MYSQL)
    @Column(insertable = false, updatable = false)
    protected Long id;

}