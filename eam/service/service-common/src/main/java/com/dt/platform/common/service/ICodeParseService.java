package com.dt.platform.common.service;


import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.dt.platform.domain.common.CodeRule;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ISuperService;
import com.github.foxnic.dao.excel.ExcelStructure;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.dao.excel.ValidateResult;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.OrderBy;
import com.github.foxnic.sql.meta.DBField;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * <p>
 * 编码分配规则 服务接口
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-08 09:13:29
*/

public interface ICodeParseService {


    /**
     * 获取业务编码
     * @param module 传入业务编码模块
     * @return 返回编号
     * */
    String getBusinessCode(String module);

    /**
     * 生成编码
     * @param ph 传入占位符
     * @return 返回编号
     * */
     String parseCode(String ph);


    /**
     * 解析占位符编码
     * @param ph 传入占位符
     * @return 返回编号
     * */
    String parsePlaceholder(String ph);


    /**
     * 解析时间占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    String parseTime(String ph);


    /**
     * 解析字符串占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    String parseStringFix(String ph);


    /**
     * 按照指定长度生成字符串
     * @param length 长度
     * @return 返回随时资产负债
     * */
    String getRandomString(int length);


    /**
     * 解析字符串占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
     String parseStringRand(String ph);


    /**
     * 解析数字类型占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    String parseNumberRand(String ph);


    /**
     * 解析数字类型占位符
     * @param ph 传入占位符
     * @return 返回编号
     * */
    String parseNumberSeq(String ph);

}