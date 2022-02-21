package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNodeValueLastVO;
import java.util.List;
import com.dt.platform.domain.ops.MonitorNodeValueLast;
import java.util.Date;
import java.math.BigDecimal;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-20 14:46:45
 * @sign FDFB11067B851B9CEA9CE82B4038AD40
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeValueLastVOMeta extends MonitorNodeValueLastMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_CODE="monitorTplCode";
	
	/**
	 * 监控模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> MONITOR_TPL_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,MONITOR_TPL_CODE, java.lang.String.class, "监控模版", "监控模版", java.lang.String.class, null);
	
	/**
	 * 结果状态 , 类型: java.lang.String
	*/
	public static final String RESULT_STATUS="resultStatus";
	
	/**
	 * 结果状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> RESULT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,RESULT_STATUS, java.lang.String.class, "结果状态", "结果状态", java.lang.String.class, null);
	
	/**
	 * 结果内容 , 类型: java.lang.String
	*/
	public static final String RESULT_MESSAGE="resultMessage";
	
	/**
	 * 结果内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> RESULT_MESSAGE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,RESULT_MESSAGE, java.lang.String.class, "结果内容", "结果内容", java.lang.String.class, null);
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final String INDICATOR_CODE="indicatorCode";
	
	/**
	 * 指标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> INDICATOR_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,INDICATOR_CODE, java.lang.String.class, "指标", "指标", java.lang.String.class, null);
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final String HOSTNAME="hostname";
	
	/**
	 * 主机名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> HOSTNAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,HOSTNAME, java.lang.String.class, "主机名称", "主机名称", java.lang.String.class, null);
	
	/**
	 * 系统时间 , 类型: java.lang.String
	*/
	public static final String OS_DATETIME="osDatetime";
	
	/**
	 * 系统时间 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> OS_DATETIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,OS_DATETIME, java.lang.String.class, "系统时间", "系统时间", java.lang.String.class, null);
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final String BOOTTIME="boottime";
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.util.Date> BOOTTIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,BOOTTIME, java.util.Date.class, "启动时间", "启动时间", java.util.Date.class, null);
	
	/**
	 * 系统 , 类型: java.lang.String
	*/
	public static final String OS_VERION="osVerion";
	
	/**
	 * 系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> OS_VERION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,OS_VERION, java.lang.String.class, "系统", "系统", java.lang.String.class, null);
	
	/**
	 * 架构 , 类型: java.lang.String
	*/
	public static final String ARCH="arch";
	
	/**
	 * 架构 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> ARCH_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,ARCH, java.lang.String.class, "架构", "架构", java.lang.String.class, null);
	
	/**
	 * CPU数量 , 类型: java.lang.Integer
	*/
	public static final String CPU_NUMBER="cpuNumber";
	
	/**
	 * CPU数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> CPU_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_NUMBER, java.lang.Integer.class, "CPU数量", "CPU数量", java.lang.Integer.class, null);
	
	/**
	 * CPU主频 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_FREE="cpuFree";
	
	/**
	 * CPU主频 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_FREE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_FREE, java.math.BigDecimal.class, "CPU主频", "CPU主频", java.math.BigDecimal.class, null);
	
	/**
	 * cpuSys , 类型: java.math.BigDecimal
	*/
	public static final String CPU_SYS="cpuSys";
	
	/**
	 * cpuSys , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_SYS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_SYS, java.math.BigDecimal.class, "cpuSys", "cpuSys", java.math.BigDecimal.class, null);
	
	/**
	 * cpuUser , 类型: java.math.BigDecimal
	*/
	public static final String CPU_USER="cpuUser";
	
	/**
	 * cpuUser , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_USER, java.math.BigDecimal.class, "cpuUser", "cpuUser", java.math.BigDecimal.class, null);
	
	/**
	 * cpuWait , 类型: java.math.BigDecimal
	*/
	public static final String CPU_WAIT="cpuWait";
	
	/**
	 * cpuWait , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_WAIT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_WAIT, java.math.BigDecimal.class, "cpuWait", "cpuWait", java.math.BigDecimal.class, null);
	
	/**
	 * CPU空闲旅 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_IDLE="cpuIdle";
	
	/**
	 * CPU空闲旅 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_IDLE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_IDLE, java.math.BigDecimal.class, "CPU空闲旅", "CPU空闲旅", java.math.BigDecimal.class, null);
	
	/**
	 * CPU使用率 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_USED="cpuUsed";
	
	/**
	 * CPU使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> CPU_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CPU_USED, java.math.BigDecimal.class, "CPU使用率", "CPU使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD="osLoad";
	
	/**
	 * 系统负载 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> OS_LOAD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,OS_LOAD, java.math.BigDecimal.class, "系统负载", "系统负载", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载5 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD5="osLoad5";
	
	/**
	 * 系统负载5 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> OS_LOAD5_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,OS_LOAD5, java.math.BigDecimal.class, "系统负载5", "系统负载5", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载15 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD15="osLoad15";
	
	/**
	 * 系统负载15 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> OS_LOAD15_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,OS_LOAD15, java.math.BigDecimal.class, "系统负载15", "系统负载15", java.math.BigDecimal.class, null);
	
	/**
	 * 上行流量 , 类型: java.math.BigDecimal
	*/
	public static final String NETWORK_FLOW_UP="networkFlowUp";
	
	/**
	 * 上行流量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> NETWORK_FLOW_UP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,NETWORK_FLOW_UP, java.math.BigDecimal.class, "上行流量", "上行流量", java.math.BigDecimal.class, null);
	
	/**
	 * 下流量 , 类型: java.math.BigDecimal
	*/
	public static final String NETWORK_FLOW_DOWN="networkFlowDown";
	
	/**
	 * 下流量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> NETWORK_FLOW_DOWN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,NETWORK_FLOW_DOWN, java.math.BigDecimal.class, "下流量", "下流量", java.math.BigDecimal.class, null);
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final String PROCESS_CNT="processCnt";
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> PROCESS_CNT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,PROCESS_CNT, java.lang.Integer.class, "连接数", "连接数", java.lang.Integer.class, null);
	
	/**
	 * 物理内存(M) , 类型: java.lang.Long
	*/
	public static final String P_MEMORY_SIZE="pMemorySize";
	
	/**
	 * 物理内存(M) , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> P_MEMORY_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,P_MEMORY_SIZE, java.lang.Long.class, "物理内存(M)", "物理内存(M)", java.lang.Long.class, null);
	
	/**
	 * 虚拟内存(M) , 类型: java.lang.Long
	*/
	public static final String V_MEMORY_SIZE="vMemorySize";
	
	/**
	 * 虚拟内存(M) , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> V_MEMORY_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,V_MEMORY_SIZE, java.lang.Long.class, "虚拟内存(M)", "虚拟内存(M)", java.lang.Long.class, null);
	
	/**
	 * 物理内存使用率 , 类型: java.lang.Long
	*/
	public static final String P_MEMORY_USED="pMemoryUsed";
	
	/**
	 * 物理内存使用率 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> P_MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,P_MEMORY_USED, java.lang.Long.class, "物理内存使用率", "物理内存使用率", java.lang.Long.class, null);
	
	/**
	 * 虚拟内存使用率 , 类型: java.lang.Long
	*/
	public static final String V_MEMORY_USED="vMemoryUsed";
	
	/**
	 * 虚拟内存使用率 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> V_MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,V_MEMORY_USED, java.lang.Long.class, "虚拟内存使用率", "虚拟内存使用率", java.lang.Long.class, null);
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final String INFO="info";
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,INFO, java.lang.String.class, "信息", "信息", java.lang.String.class, null);
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final String LABEL1="label1";
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LABEL1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LABEL1, java.lang.String.class, "标签1", "标签1", java.lang.String.class, null);
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final String LABEL2="label2";
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LABEL2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LABEL2, java.lang.String.class, "标签2", "标签2", java.lang.String.class, null);
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final String LABEL3="label3";
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LABEL3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LABEL3, java.lang.String.class, "标签3", "标签3", java.lang.String.class, null);
	
	/**
	 * 编码1 , 类型: java.lang.String
	*/
	public static final String CODE1="code1";
	
	/**
	 * 编码1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> CODE1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CODE1, java.lang.String.class, "编码1", "编码1", java.lang.String.class, null);
	
	/**
	 * 编码2 , 类型: java.lang.String
	*/
	public static final String CODE2="code2";
	
	/**
	 * 编码2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> CODE2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CODE2, java.lang.String.class, "编码2", "编码2", java.lang.String.class, null);
	
	/**
	 * 编码3 , 类型: java.lang.String
	*/
	public static final String CODE3="code3";
	
	/**
	 * 编码3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> CODE3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CODE3, java.lang.String.class, "编码3", "编码3", java.lang.String.class, null);
	
	/**
	 * 数值1 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER1="valueNumber1";
	
	/**
	 * 数值1 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> VALUE_NUMBER1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_NUMBER1, java.math.BigDecimal.class, "数值1", "数值1", java.math.BigDecimal.class, null);
	
	/**
	 * 数值2 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER2="valueNumber2";
	
	/**
	 * 数值2 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> VALUE_NUMBER2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_NUMBER2, java.math.BigDecimal.class, "数值2", "数值2", java.math.BigDecimal.class, null);
	
	/**
	 * 数值3 , 类型: java.math.BigDecimal
	*/
	public static final String VALUE_NUMBER3="valueNumber3";
	
	/**
	 * 数值3 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> VALUE_NUMBER3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_NUMBER3, java.math.BigDecimal.class, "数值3", "数值3", java.math.BigDecimal.class, null);
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final String VALUE_STR1="valueStr1";
	
	/**
	 * 字符串1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> VALUE_STR1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_STR1, java.lang.String.class, "字符串1", "字符串1", java.lang.String.class, null);
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final String VALUE_STR2="valueStr2";
	
	/**
	 * 字符串2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> VALUE_STR2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_STR2, java.lang.String.class, "字符串2", "字符串2", java.lang.String.class, null);
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final String VALUE_STR3="valueStr3";
	
	/**
	 * 字符串3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> VALUE_STR3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_STR3, java.lang.String.class, "字符串3", "字符串3", java.lang.String.class, null);
	
	/**
	 * 整数1 , 类型: java.lang.Long
	*/
	public static final String VALUE_INT1="valueInt1";
	
	/**
	 * 整数1 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> VALUE_INT1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_INT1, java.lang.Long.class, "整数1", "整数1", java.lang.Long.class, null);
	
	/**
	 * 整数2 , 类型: java.lang.Long
	*/
	public static final String VALUE_INT2="valueInt2";
	
	/**
	 * 整数2 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> VALUE_INT2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_INT2, java.lang.Long.class, "整数2", "整数2", java.lang.Long.class, null);
	
	/**
	 * 整数3 , 类型: java.lang.Long
	*/
	public static final String VALUE_INT3="valueInt3";
	
	/**
	 * 整数3 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> VALUE_INT3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VALUE_INT3, java.lang.Long.class, "整数3", "整数3", java.lang.Long.class, null);
	
	/**
	 * 标签列1 , 类型: java.lang.String
	*/
	public static final String LIST_LABEL1="listLabel1";
	
	/**
	 * 标签列1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_LABEL1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_LABEL1, java.lang.String.class, "标签列1", "标签列1", java.lang.String.class, null);
	
	/**
	 * 标签列2 , 类型: java.lang.String
	*/
	public static final String LIST_LABEL2="listLabel2";
	
	/**
	 * 标签列2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_LABEL2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_LABEL2, java.lang.String.class, "标签列2", "标签列2", java.lang.String.class, null);
	
	/**
	 * 标签列3 , 类型: java.lang.String
	*/
	public static final String LIST_LABEL3="listLabel3";
	
	/**
	 * 标签列3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_LABEL3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_LABEL3, java.lang.String.class, "标签列3", "标签列3", java.lang.String.class, null);
	
	/**
	 * 编码列1 , 类型: java.lang.String
	*/
	public static final String LIST_CODE1="listCode1";
	
	/**
	 * 编码列1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_CODE1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_CODE1, java.lang.String.class, "编码列1", "编码列1", java.lang.String.class, null);
	
	/**
	 * 编码列2 , 类型: java.lang.String
	*/
	public static final String LIST_CODE2="listCode2";
	
	/**
	 * 编码列2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_CODE2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_CODE2, java.lang.String.class, "编码列2", "编码列2", java.lang.String.class, null);
	
	/**
	 * 编码列3 , 类型: java.lang.String
	*/
	public static final String LIST_CODE3="listCode3";
	
	/**
	 * 编码列3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_CODE3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_CODE3, java.lang.String.class, "编码列3", "编码列3", java.lang.String.class, null);
	
	/**
	 * 数值列1 , 类型: java.math.BigDecimal
	*/
	public static final String LIST_VALUE_NUMBER1="listValueNumber1";
	
	/**
	 * 数值列1 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> LIST_VALUE_NUMBER1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_NUMBER1, java.math.BigDecimal.class, "数值列1", "数值列1", java.math.BigDecimal.class, null);
	
	/**
	 * 数值列2 , 类型: java.math.BigDecimal
	*/
	public static final String LIST_VALUE_NUMBER2="listValueNumber2";
	
	/**
	 * 数值列2 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> LIST_VALUE_NUMBER2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_NUMBER2, java.math.BigDecimal.class, "数值列2", "数值列2", java.math.BigDecimal.class, null);
	
	/**
	 * 数值列3 , 类型: java.math.BigDecimal
	*/
	public static final String LIST_VALUE_NUMBER3="listValueNumber3";
	
	/**
	 * 数值列3 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.math.BigDecimal> LIST_VALUE_NUMBER3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_NUMBER3, java.math.BigDecimal.class, "数值列3", "数值列3", java.math.BigDecimal.class, null);
	
	/**
	 * 字符串列1 , 类型: java.lang.String
	*/
	public static final String LIST_VALUE_STR1="listValueStr1";
	
	/**
	 * 字符串列1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_VALUE_STR1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_STR1, java.lang.String.class, "字符串列1", "字符串列1", java.lang.String.class, null);
	
	/**
	 * 字符串列2 , 类型: java.lang.String
	*/
	public static final String LIST_VALUE_STR2="listValueStr2";
	
	/**
	 * 字符串列2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_VALUE_STR2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_STR2, java.lang.String.class, "字符串列2", "字符串列2", java.lang.String.class, null);
	
	/**
	 * 字符串列3 , 类型: java.lang.String
	*/
	public static final String LIST_VALUE_STR3="listValueStr3";
	
	/**
	 * 字符串列3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> LIST_VALUE_STR3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_STR3, java.lang.String.class, "字符串列3", "字符串列3", java.lang.String.class, null);
	
	/**
	 * 整数列1 , 类型: java.lang.Long
	*/
	public static final String LIST_VALUE_INT1="listValueInt1";
	
	/**
	 * 整数列1 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> LIST_VALUE_INT1_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_INT1, java.lang.Long.class, "整数列1", "整数列1", java.lang.Long.class, null);
	
	/**
	 * 整数列2 , 类型: java.lang.Long
	*/
	public static final String LIST_VALUE_INT2="listValueInt2";
	
	/**
	 * 整数列2 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> LIST_VALUE_INT2_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_INT2, java.lang.Long.class, "整数列2", "整数列2", java.lang.Long.class, null);
	
	/**
	 * 整数列3 , 类型: java.lang.Long
	*/
	public static final String LIST_VALUE_INT3="listValueInt3";
	
	/**
	 * 整数列3 , 类型: java.lang.Long
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Long> LIST_VALUE_INT3_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,LIST_VALUE_INT3, java.lang.Long.class, "整数列3", "整数列3", java.lang.Long.class, null);
	
	/**
	 * 唯一标识 , 类型: java.lang.String
	*/
	public static final String UID="uid";
	
	/**
	 * 唯一标识 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> UID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,UID, java.lang.String.class, "唯一标识", "唯一标识", java.lang.String.class, null);
	
	/**
	 * 是否连接 , 类型: java.lang.Integer
	*/
	public static final String IS_CONNECTED="isConnected";
	
	/**
	 * 是否连接 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> IS_CONNECTED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,IS_CONNECTED, java.lang.Integer.class, "是否连接", "是否连接", java.lang.Integer.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeValueLastVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeValueLastVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NODE_ID , MONITOR_TPL_CODE , RESULT_STATUS , RESULT_MESSAGE , INDICATOR_CODE , HOSTNAME , OS_DATETIME , BOOTTIME , OS_VERION , ARCH , CPU_NUMBER , CPU_FREE , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_SIZE , V_MEMORY_SIZE , P_MEMORY_USED , V_MEMORY_USED , INFO , LABEL1 , LABEL2 , LABEL3 , CODE1 , CODE2 , CODE3 , VALUE_NUMBER1 , VALUE_NUMBER2 , VALUE_NUMBER3 , VALUE_STR1 , VALUE_STR2 , VALUE_STR3 , VALUE_INT1 , VALUE_INT2 , VALUE_INT3 , LIST_LABEL1 , LIST_LABEL2 , LIST_LABEL3 , LIST_CODE1 , LIST_CODE2 , LIST_CODE3 , LIST_VALUE_NUMBER1 , LIST_VALUE_NUMBER2 , LIST_VALUE_NUMBER3 , LIST_VALUE_STR1 , LIST_VALUE_STR2 , LIST_VALUE_STR3 , LIST_VALUE_INT1 , LIST_VALUE_INT2 , LIST_VALUE_INT3 , UID , IS_CONNECTED , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNodeValueLastVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MonitorNodeValueLastVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 监控模版
		 * @param monitorTplCode 监控模版
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setMonitorTplCode(String monitorTplCode) {
			super.change(MONITOR_TPL_CODE,super.getMonitorTplCode(),monitorTplCode);
			super.setMonitorTplCode(monitorTplCode);
			return this;
		}
		
		/**
		 * 设置 结果状态
		 * @param resultStatus 结果状态
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setResultStatus(String resultStatus) {
			super.change(RESULT_STATUS,super.getResultStatus(),resultStatus);
			super.setResultStatus(resultStatus);
			return this;
		}
		
		/**
		 * 设置 结果内容
		 * @param resultMessage 结果内容
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setResultMessage(String resultMessage) {
			super.change(RESULT_MESSAGE,super.getResultMessage(),resultMessage);
			super.setResultMessage(resultMessage);
			return this;
		}
		
		/**
		 * 设置 指标
		 * @param indicatorCode 指标
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setIndicatorCode(String indicatorCode) {
			super.change(INDICATOR_CODE,super.getIndicatorCode(),indicatorCode);
			super.setIndicatorCode(indicatorCode);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostname 主机名称
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setHostname(String hostname) {
			super.change(HOSTNAME,super.getHostname(),hostname);
			super.setHostname(hostname);
			return this;
		}
		
		/**
		 * 设置 系统时间
		 * @param osDatetime 系统时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setOsDatetime(String osDatetime) {
			super.change(OS_DATETIME,super.getOsDatetime(),osDatetime);
			super.setOsDatetime(osDatetime);
			return this;
		}
		
		/**
		 * 设置 启动时间
		 * @param boottime 启动时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setBoottime(Date boottime) {
			super.change(BOOTTIME,super.getBoottime(),boottime);
			super.setBoottime(boottime);
			return this;
		}
		
		/**
		 * 设置 系统
		 * @param osVerion 系统
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setOsVerion(String osVerion) {
			super.change(OS_VERION,super.getOsVerion(),osVerion);
			super.setOsVerion(osVerion);
			return this;
		}
		
		/**
		 * 设置 架构
		 * @param arch 架构
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setArch(String arch) {
			super.change(ARCH,super.getArch(),arch);
			super.setArch(arch);
			return this;
		}
		
		/**
		 * 设置 CPU数量
		 * @param cpuNumber CPU数量
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuNumber(Integer cpuNumber) {
			super.change(CPU_NUMBER,super.getCpuNumber(),cpuNumber);
			super.setCpuNumber(cpuNumber);
			return this;
		}
		
		/**
		 * 设置 CPU主频
		 * @param cpuFree CPU主频
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuFree(BigDecimal cpuFree) {
			super.change(CPU_FREE,super.getCpuFree(),cpuFree);
			super.setCpuFree(cpuFree);
			return this;
		}
		
		/**
		 * 设置 cpuSys
		 * @param cpuSys cpuSys
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuSys(BigDecimal cpuSys) {
			super.change(CPU_SYS,super.getCpuSys(),cpuSys);
			super.setCpuSys(cpuSys);
			return this;
		}
		
		/**
		 * 设置 cpuUser
		 * @param cpuUser cpuUser
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuUser(BigDecimal cpuUser) {
			super.change(CPU_USER,super.getCpuUser(),cpuUser);
			super.setCpuUser(cpuUser);
			return this;
		}
		
		/**
		 * 设置 cpuWait
		 * @param cpuWait cpuWait
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuWait(BigDecimal cpuWait) {
			super.change(CPU_WAIT,super.getCpuWait(),cpuWait);
			super.setCpuWait(cpuWait);
			return this;
		}
		
		/**
		 * 设置 CPU空闲旅
		 * @param cpuIdle CPU空闲旅
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuIdle(BigDecimal cpuIdle) {
			super.change(CPU_IDLE,super.getCpuIdle(),cpuIdle);
			super.setCpuIdle(cpuIdle);
			return this;
		}
		
		/**
		 * 设置 CPU使用率
		 * @param cpuUsed CPU使用率
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCpuUsed(BigDecimal cpuUsed) {
			super.change(CPU_USED,super.getCpuUsed(),cpuUsed);
			super.setCpuUsed(cpuUsed);
			return this;
		}
		
		/**
		 * 设置 系统负载
		 * @param osLoad 系统负载
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setOsLoad(BigDecimal osLoad) {
			super.change(OS_LOAD,super.getOsLoad(),osLoad);
			super.setOsLoad(osLoad);
			return this;
		}
		
		/**
		 * 设置 系统负载5
		 * @param osLoad5 系统负载5
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setOsLoad5(BigDecimal osLoad5) {
			super.change(OS_LOAD5,super.getOsLoad5(),osLoad5);
			super.setOsLoad5(osLoad5);
			return this;
		}
		
		/**
		 * 设置 系统负载15
		 * @param osLoad15 系统负载15
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setOsLoad15(BigDecimal osLoad15) {
			super.change(OS_LOAD15,super.getOsLoad15(),osLoad15);
			super.setOsLoad15(osLoad15);
			return this;
		}
		
		/**
		 * 设置 上行流量
		 * @param networkFlowUp 上行流量
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setNetworkFlowUp(BigDecimal networkFlowUp) {
			super.change(NETWORK_FLOW_UP,super.getNetworkFlowUp(),networkFlowUp);
			super.setNetworkFlowUp(networkFlowUp);
			return this;
		}
		
		/**
		 * 设置 下流量
		 * @param networkFlowDown 下流量
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setNetworkFlowDown(BigDecimal networkFlowDown) {
			super.change(NETWORK_FLOW_DOWN,super.getNetworkFlowDown(),networkFlowDown);
			super.setNetworkFlowDown(networkFlowDown);
			return this;
		}
		
		/**
		 * 设置 连接数
		 * @param processCnt 连接数
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setProcessCnt(Integer processCnt) {
			super.change(PROCESS_CNT,super.getProcessCnt(),processCnt);
			super.setProcessCnt(processCnt);
			return this;
		}
		
		/**
		 * 设置 物理内存(M)
		 * @param pMemorySize 物理内存(M)
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setPMemorySize(Long pMemorySize) {
			super.change(P_MEMORY_SIZE,super.getPMemorySize(),pMemorySize);
			super.setPMemorySize(pMemorySize);
			return this;
		}
		
		/**
		 * 设置 虚拟内存(M)
		 * @param vMemorySize 虚拟内存(M)
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setVMemorySize(Long vMemorySize) {
			super.change(V_MEMORY_SIZE,super.getVMemorySize(),vMemorySize);
			super.setVMemorySize(vMemorySize);
			return this;
		}
		
		/**
		 * 设置 物理内存使用率
		 * @param pMemoryUsed 物理内存使用率
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setPMemoryUsed(Long pMemoryUsed) {
			super.change(P_MEMORY_USED,super.getPMemoryUsed(),pMemoryUsed);
			super.setPMemoryUsed(pMemoryUsed);
			return this;
		}
		
		/**
		 * 设置 虚拟内存使用率
		 * @param vMemoryUsed 虚拟内存使用率
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setVMemoryUsed(Long vMemoryUsed) {
			super.change(V_MEMORY_USED,super.getVMemoryUsed(),vMemoryUsed);
			super.setVMemoryUsed(vMemoryUsed);
			return this;
		}
		
		/**
		 * 设置 信息
		 * @param info 信息
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setInfo(String info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 标签1
		 * @param label1 标签1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setLabel1(String label1) {
			super.change(LABEL1,super.getLabel1(),label1);
			super.setLabel1(label1);
			return this;
		}
		
		/**
		 * 设置 标签2
		 * @param label2 标签2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setLabel2(String label2) {
			super.change(LABEL2,super.getLabel2(),label2);
			super.setLabel2(label2);
			return this;
		}
		
		/**
		 * 设置 标签3
		 * @param label3 标签3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setLabel3(String label3) {
			super.change(LABEL3,super.getLabel3(),label3);
			super.setLabel3(label3);
			return this;
		}
		
		/**
		 * 设置 编码1
		 * @param code1 编码1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCode1(String code1) {
			super.change(CODE1,super.getCode1(),code1);
			super.setCode1(code1);
			return this;
		}
		
		/**
		 * 设置 编码2
		 * @param code2 编码2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCode2(String code2) {
			super.change(CODE2,super.getCode2(),code2);
			super.setCode2(code2);
			return this;
		}
		
		/**
		 * 设置 编码3
		 * @param code3 编码3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCode3(String code3) {
			super.change(CODE3,super.getCode3(),code3);
			super.setCode3(code3);
			return this;
		}
		
		/**
		 * 设置 数值1
		 * @param valueNumber1 数值1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueNumber1(BigDecimal valueNumber1) {
			super.change(VALUE_NUMBER1,super.getValueNumber1(),valueNumber1);
			super.setValueNumber1(valueNumber1);
			return this;
		}
		
		/**
		 * 设置 数值2
		 * @param valueNumber2 数值2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueNumber2(BigDecimal valueNumber2) {
			super.change(VALUE_NUMBER2,super.getValueNumber2(),valueNumber2);
			super.setValueNumber2(valueNumber2);
			return this;
		}
		
		/**
		 * 设置 数值3
		 * @param valueNumber3 数值3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueNumber3(BigDecimal valueNumber3) {
			super.change(VALUE_NUMBER3,super.getValueNumber3(),valueNumber3);
			super.setValueNumber3(valueNumber3);
			return this;
		}
		
		/**
		 * 设置 字符串1
		 * @param valueStr1 字符串1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueStr1(String valueStr1) {
			super.change(VALUE_STR1,super.getValueStr1(),valueStr1);
			super.setValueStr1(valueStr1);
			return this;
		}
		
		/**
		 * 设置 字符串2
		 * @param valueStr2 字符串2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueStr2(String valueStr2) {
			super.change(VALUE_STR2,super.getValueStr2(),valueStr2);
			super.setValueStr2(valueStr2);
			return this;
		}
		
		/**
		 * 设置 字符串3
		 * @param valueStr3 字符串3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueStr3(String valueStr3) {
			super.change(VALUE_STR3,super.getValueStr3(),valueStr3);
			super.setValueStr3(valueStr3);
			return this;
		}
		
		/**
		 * 设置 整数1
		 * @param valueInt1 整数1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueInt1(Long valueInt1) {
			super.change(VALUE_INT1,super.getValueInt1(),valueInt1);
			super.setValueInt1(valueInt1);
			return this;
		}
		
		/**
		 * 设置 整数2
		 * @param valueInt2 整数2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueInt2(Long valueInt2) {
			super.change(VALUE_INT2,super.getValueInt2(),valueInt2);
			super.setValueInt2(valueInt2);
			return this;
		}
		
		/**
		 * 设置 整数3
		 * @param valueInt3 整数3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setValueInt3(Long valueInt3) {
			super.change(VALUE_INT3,super.getValueInt3(),valueInt3);
			super.setValueInt3(valueInt3);
			return this;
		}
		
		/**
		 * 设置 标签列1
		 * @param listLabel1 标签列1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListLabel1(String listLabel1) {
			super.change(LIST_LABEL1,super.getListLabel1(),listLabel1);
			super.setListLabel1(listLabel1);
			return this;
		}
		
		/**
		 * 设置 标签列2
		 * @param listLabel2 标签列2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListLabel2(String listLabel2) {
			super.change(LIST_LABEL2,super.getListLabel2(),listLabel2);
			super.setListLabel2(listLabel2);
			return this;
		}
		
		/**
		 * 设置 标签列3
		 * @param listLabel3 标签列3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListLabel3(String listLabel3) {
			super.change(LIST_LABEL3,super.getListLabel3(),listLabel3);
			super.setListLabel3(listLabel3);
			return this;
		}
		
		/**
		 * 设置 编码列1
		 * @param listCode1 编码列1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListCode1(String listCode1) {
			super.change(LIST_CODE1,super.getListCode1(),listCode1);
			super.setListCode1(listCode1);
			return this;
		}
		
		/**
		 * 设置 编码列2
		 * @param listCode2 编码列2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListCode2(String listCode2) {
			super.change(LIST_CODE2,super.getListCode2(),listCode2);
			super.setListCode2(listCode2);
			return this;
		}
		
		/**
		 * 设置 编码列3
		 * @param listCode3 编码列3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListCode3(String listCode3) {
			super.change(LIST_CODE3,super.getListCode3(),listCode3);
			super.setListCode3(listCode3);
			return this;
		}
		
		/**
		 * 设置 数值列1
		 * @param listValueNumber1 数值列1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueNumber1(BigDecimal listValueNumber1) {
			super.change(LIST_VALUE_NUMBER1,super.getListValueNumber1(),listValueNumber1);
			super.setListValueNumber1(listValueNumber1);
			return this;
		}
		
		/**
		 * 设置 数值列2
		 * @param listValueNumber2 数值列2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueNumber2(BigDecimal listValueNumber2) {
			super.change(LIST_VALUE_NUMBER2,super.getListValueNumber2(),listValueNumber2);
			super.setListValueNumber2(listValueNumber2);
			return this;
		}
		
		/**
		 * 设置 数值列3
		 * @param listValueNumber3 数值列3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueNumber3(BigDecimal listValueNumber3) {
			super.change(LIST_VALUE_NUMBER3,super.getListValueNumber3(),listValueNumber3);
			super.setListValueNumber3(listValueNumber3);
			return this;
		}
		
		/**
		 * 设置 字符串列1
		 * @param listValueStr1 字符串列1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueStr1(String listValueStr1) {
			super.change(LIST_VALUE_STR1,super.getListValueStr1(),listValueStr1);
			super.setListValueStr1(listValueStr1);
			return this;
		}
		
		/**
		 * 设置 字符串列2
		 * @param listValueStr2 字符串列2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueStr2(String listValueStr2) {
			super.change(LIST_VALUE_STR2,super.getListValueStr2(),listValueStr2);
			super.setListValueStr2(listValueStr2);
			return this;
		}
		
		/**
		 * 设置 字符串列3
		 * @param listValueStr3 字符串列3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueStr3(String listValueStr3) {
			super.change(LIST_VALUE_STR3,super.getListValueStr3(),listValueStr3);
			super.setListValueStr3(listValueStr3);
			return this;
		}
		
		/**
		 * 设置 整数列1
		 * @param listValueInt1 整数列1
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueInt1(Long listValueInt1) {
			super.change(LIST_VALUE_INT1,super.getListValueInt1(),listValueInt1);
			super.setListValueInt1(listValueInt1);
			return this;
		}
		
		/**
		 * 设置 整数列2
		 * @param listValueInt2 整数列2
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueInt2(Long listValueInt2) {
			super.change(LIST_VALUE_INT2,super.getListValueInt2(),listValueInt2);
			super.setListValueInt2(listValueInt2);
			return this;
		}
		
		/**
		 * 设置 整数列3
		 * @param listValueInt3 整数列3
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setListValueInt3(Long listValueInt3) {
			super.change(LIST_VALUE_INT3,super.getListValueInt3(),listValueInt3);
			super.setListValueInt3(listValueInt3);
			return this;
		}
		
		/**
		 * 设置 唯一标识
		 * @param uid 唯一标识
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setUid(String uid) {
			super.change(UID,super.getUid(),uid);
			super.setUid(uid);
			return this;
		}
		
		/**
		 * 设置 是否连接
		 * @param isConnected 是否连接
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setIsConnected(Integer isConnected) {
			super.change(IS_CONNECTED,super.getIsConnected(),isConnected);
			super.setIsConnected(isConnected);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNodeValueLast setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}