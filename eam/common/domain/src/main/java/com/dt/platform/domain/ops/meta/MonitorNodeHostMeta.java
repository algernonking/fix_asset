package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNodeHost;
import java.util.Date;
import java.math.BigDecimal;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-08 13:14:45
 * @sign 5EE83777E8AB2DCC42E9B49E474E2BFC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeHostMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final String NODE_ID="nodeId";
	
	/**
	 * 节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> NODE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,NODE_ID, java.lang.String.class, "节点", "节点", java.lang.String.class, null);
	
	/**
	 * 主机名称 , 类型: java.util.Date
	*/
	public static final String HOSTNAME="hostname";
	
	/**
	 * 主机名称 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> HOSTNAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,HOSTNAME, java.util.Date.class, "主机名称", "主机名称", java.util.Date.class, null);
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final String BOOTTIME="boottime";
	
	/**
	 * 启动时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> BOOTTIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,BOOTTIME, java.util.Date.class, "启动时间", "启动时间", java.util.Date.class, null);
	
	/**
	 * 系统 , 类型: java.lang.String
	*/
	public static final String OS_VERION="osVerion";
	
	/**
	 * 系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> OS_VERION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,OS_VERION, java.lang.String.class, "系统", "系统", java.lang.String.class, null);
	
	/**
	 * 架构 , 类型: java.lang.String
	*/
	public static final String ARCH="arch";
	
	/**
	 * 架构 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> ARCH_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,ARCH, java.lang.String.class, "架构", "架构", java.lang.String.class, null);
	
	/**
	 * CPU数量 , 类型: java.lang.Integer
	*/
	public static final String CPU="cpu";
	
	/**
	 * CPU数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> CPU_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU, java.lang.Integer.class, "CPU数量", "CPU数量", java.lang.Integer.class, null);
	
	/**
	 * CPU主频 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_FRE="cpuFre";
	
	/**
	 * CPU主频 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_FRE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_FRE, java.math.BigDecimal.class, "CPU主频", "CPU主频", java.math.BigDecimal.class, null);
	
	/**
	 * 内存(M) , 类型: java.lang.Integer
	*/
	public static final String MEMORY="memory";
	
	/**
	 * 内存(M) , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> MEMORY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,MEMORY, java.lang.Integer.class, "内存(M)", "内存(M)", java.lang.Integer.class, null);
	
	/**
	 * cpuSys , 类型: java.math.BigDecimal
	*/
	public static final String CPU_SYS="cpuSys";
	
	/**
	 * cpuSys , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_SYS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_SYS, java.math.BigDecimal.class, "cpuSys", "cpuSys", java.math.BigDecimal.class, null);
	
	/**
	 * cpuUser , 类型: java.math.BigDecimal
	*/
	public static final String CPU_USER="cpuUser";
	
	/**
	 * cpuUser , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_USER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_USER, java.math.BigDecimal.class, "cpuUser", "cpuUser", java.math.BigDecimal.class, null);
	
	/**
	 * cpuWait , 类型: java.math.BigDecimal
	*/
	public static final String CPU_WAIT="cpuWait";
	
	/**
	 * cpuWait , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_WAIT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_WAIT, java.math.BigDecimal.class, "cpuWait", "cpuWait", java.math.BigDecimal.class, null);
	
	/**
	 * CPU空闲旅 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_IDLE="cpuIdle";
	
	/**
	 * CPU空闲旅 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_IDLE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_IDLE, java.math.BigDecimal.class, "CPU空闲旅", "CPU空闲旅", java.math.BigDecimal.class, null);
	
	/**
	 * CPU使用率 , 类型: java.math.BigDecimal
	*/
	public static final String CPU_USED="cpuUsed";
	
	/**
	 * CPU使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> CPU_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CPU_USED, java.math.BigDecimal.class, "CPU使用率", "CPU使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD="osLoad";
	
	/**
	 * 系统负载 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> OS_LOAD_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,OS_LOAD, java.math.BigDecimal.class, "系统负载", "系统负载", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载5 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD5="osLoad5";
	
	/**
	 * 系统负载5 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> OS_LOAD5_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,OS_LOAD5, java.math.BigDecimal.class, "系统负载5", "系统负载5", java.math.BigDecimal.class, null);
	
	/**
	 * 系统负载15 , 类型: java.math.BigDecimal
	*/
	public static final String OS_LOAD15="osLoad15";
	
	/**
	 * 系统负载15 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> OS_LOAD15_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,OS_LOAD15, java.math.BigDecimal.class, "系统负载15", "系统负载15", java.math.BigDecimal.class, null);
	
	/**
	 * 内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final String MEMORY_USED="memoryUsed";
	
	/**
	 * 内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,MEMORY_USED, java.math.BigDecimal.class, "内存使用率", "内存使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 虚拟内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final String VMEMORY_USED="vmemoryUsed";
	
	/**
	 * 虚拟内存使用率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> VMEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,VMEMORY_USED, java.math.BigDecimal.class, "虚拟内存使用率", "虚拟内存使用率", java.math.BigDecimal.class, null);
	
	/**
	 * 上行流量 , 类型: java.math.BigDecimal
	*/
	public static final String NETWORK_FLOW_UP="networkFlowUp";
	
	/**
	 * 上行流量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> NETWORK_FLOW_UP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,NETWORK_FLOW_UP, java.math.BigDecimal.class, "上行流量", "上行流量", java.math.BigDecimal.class, null);
	
	/**
	 * 下流量 , 类型: java.math.BigDecimal
	*/
	public static final String NETWORK_FLOW_DOWN="networkFlowDown";
	
	/**
	 * 下流量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.math.BigDecimal> NETWORK_FLOW_DOWN_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,NETWORK_FLOW_DOWN, java.math.BigDecimal.class, "下流量", "下流量", java.math.BigDecimal.class, null);
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final String PROCESS_CNT="processCnt";
	
	/**
	 * 连接数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> PROCESS_CNT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,PROCESS_CNT, java.lang.Integer.class, "连接数", "连接数", java.lang.Integer.class, null);
	
	/**
	 * 内存 , 类型: java.lang.Integer
	*/
	public static final String P_MEMORY_USED="pMemoryUsed";
	
	/**
	 * 内存 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> P_MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,P_MEMORY_USED, java.lang.Integer.class, "内存", "内存", java.lang.Integer.class, null);
	
	/**
	 * 虚拟内存 , 类型: java.lang.Integer
	*/
	public static final String V_MEMORY_USED="vMemoryUsed";
	
	/**
	 * 虚拟内存 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> V_MEMORY_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,V_MEMORY_USED, java.lang.Integer.class, "虚拟内存", "虚拟内存", java.lang.Integer.class, null);
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final String INFO="info";
	
	/**
	 * 信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,INFO, java.lang.String.class, "信息", "信息", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNodeHost,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNodeHost.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE_ID , HOSTNAME , BOOTTIME , OS_VERION , ARCH , CPU , CPU_FRE , MEMORY , CPU_SYS , CPU_USER , CPU_WAIT , CPU_IDLE , CPU_USED , OS_LOAD , OS_LOAD5 , OS_LOAD15 , MEMORY_USED , VMEMORY_USED , NETWORK_FLOW_UP , NETWORK_FLOW_DOWN , PROCESS_CNT , P_MEMORY_USED , V_MEMORY_USED , INFO , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNodeHost {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNodeHost setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 节点
		 * @param nodeId 节点
		 * @return 当前对象
		*/
		public MonitorNodeHost setNodeId(String nodeId) {
			super.change(NODE_ID,super.getNodeId(),nodeId);
			super.setNodeId(nodeId);
			return this;
		}
		
		/**
		 * 设置 主机名称
		 * @param hostname 主机名称
		 * @return 当前对象
		*/
		public MonitorNodeHost setHostname(Date hostname) {
			super.change(HOSTNAME,super.getHostname(),hostname);
			super.setHostname(hostname);
			return this;
		}
		
		/**
		 * 设置 启动时间
		 * @param boottime 启动时间
		 * @return 当前对象
		*/
		public MonitorNodeHost setBoottime(Date boottime) {
			super.change(BOOTTIME,super.getBoottime(),boottime);
			super.setBoottime(boottime);
			return this;
		}
		
		/**
		 * 设置 系统
		 * @param osVerion 系统
		 * @return 当前对象
		*/
		public MonitorNodeHost setOsVerion(String osVerion) {
			super.change(OS_VERION,super.getOsVerion(),osVerion);
			super.setOsVerion(osVerion);
			return this;
		}
		
		/**
		 * 设置 架构
		 * @param arch 架构
		 * @return 当前对象
		*/
		public MonitorNodeHost setArch(String arch) {
			super.change(ARCH,super.getArch(),arch);
			super.setArch(arch);
			return this;
		}
		
		/**
		 * 设置 CPU数量
		 * @param cpu CPU数量
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpu(Integer cpu) {
			super.change(CPU,super.getCpu(),cpu);
			super.setCpu(cpu);
			return this;
		}
		
		/**
		 * 设置 CPU主频
		 * @param cpuFre CPU主频
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuFre(BigDecimal cpuFre) {
			super.change(CPU_FRE,super.getCpuFre(),cpuFre);
			super.setCpuFre(cpuFre);
			return this;
		}
		
		/**
		 * 设置 内存(M)
		 * @param memory 内存(M)
		 * @return 当前对象
		*/
		public MonitorNodeHost setMemory(Integer memory) {
			super.change(MEMORY,super.getMemory(),memory);
			super.setMemory(memory);
			return this;
		}
		
		/**
		 * 设置 cpuSys
		 * @param cpuSys cpuSys
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuSys(BigDecimal cpuSys) {
			super.change(CPU_SYS,super.getCpuSys(),cpuSys);
			super.setCpuSys(cpuSys);
			return this;
		}
		
		/**
		 * 设置 cpuUser
		 * @param cpuUser cpuUser
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuUser(BigDecimal cpuUser) {
			super.change(CPU_USER,super.getCpuUser(),cpuUser);
			super.setCpuUser(cpuUser);
			return this;
		}
		
		/**
		 * 设置 cpuWait
		 * @param cpuWait cpuWait
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuWait(BigDecimal cpuWait) {
			super.change(CPU_WAIT,super.getCpuWait(),cpuWait);
			super.setCpuWait(cpuWait);
			return this;
		}
		
		/**
		 * 设置 CPU空闲旅
		 * @param cpuIdle CPU空闲旅
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuIdle(BigDecimal cpuIdle) {
			super.change(CPU_IDLE,super.getCpuIdle(),cpuIdle);
			super.setCpuIdle(cpuIdle);
			return this;
		}
		
		/**
		 * 设置 CPU使用率
		 * @param cpuUsed CPU使用率
		 * @return 当前对象
		*/
		public MonitorNodeHost setCpuUsed(BigDecimal cpuUsed) {
			super.change(CPU_USED,super.getCpuUsed(),cpuUsed);
			super.setCpuUsed(cpuUsed);
			return this;
		}
		
		/**
		 * 设置 系统负载
		 * @param osLoad 系统负载
		 * @return 当前对象
		*/
		public MonitorNodeHost setOsLoad(BigDecimal osLoad) {
			super.change(OS_LOAD,super.getOsLoad(),osLoad);
			super.setOsLoad(osLoad);
			return this;
		}
		
		/**
		 * 设置 系统负载5
		 * @param osLoad5 系统负载5
		 * @return 当前对象
		*/
		public MonitorNodeHost setOsLoad5(BigDecimal osLoad5) {
			super.change(OS_LOAD5,super.getOsLoad5(),osLoad5);
			super.setOsLoad5(osLoad5);
			return this;
		}
		
		/**
		 * 设置 系统负载15
		 * @param osLoad15 系统负载15
		 * @return 当前对象
		*/
		public MonitorNodeHost setOsLoad15(BigDecimal osLoad15) {
			super.change(OS_LOAD15,super.getOsLoad15(),osLoad15);
			super.setOsLoad15(osLoad15);
			return this;
		}
		
		/**
		 * 设置 内存使用率
		 * @param memoryUsed 内存使用率
		 * @return 当前对象
		*/
		public MonitorNodeHost setMemoryUsed(BigDecimal memoryUsed) {
			super.change(MEMORY_USED,super.getMemoryUsed(),memoryUsed);
			super.setMemoryUsed(memoryUsed);
			return this;
		}
		
		/**
		 * 设置 虚拟内存使用率
		 * @param vmemoryUsed 虚拟内存使用率
		 * @return 当前对象
		*/
		public MonitorNodeHost setVmemoryUsed(BigDecimal vmemoryUsed) {
			super.change(VMEMORY_USED,super.getVmemoryUsed(),vmemoryUsed);
			super.setVmemoryUsed(vmemoryUsed);
			return this;
		}
		
		/**
		 * 设置 上行流量
		 * @param networkFlowUp 上行流量
		 * @return 当前对象
		*/
		public MonitorNodeHost setNetworkFlowUp(BigDecimal networkFlowUp) {
			super.change(NETWORK_FLOW_UP,super.getNetworkFlowUp(),networkFlowUp);
			super.setNetworkFlowUp(networkFlowUp);
			return this;
		}
		
		/**
		 * 设置 下流量
		 * @param networkFlowDown 下流量
		 * @return 当前对象
		*/
		public MonitorNodeHost setNetworkFlowDown(BigDecimal networkFlowDown) {
			super.change(NETWORK_FLOW_DOWN,super.getNetworkFlowDown(),networkFlowDown);
			super.setNetworkFlowDown(networkFlowDown);
			return this;
		}
		
		/**
		 * 设置 连接数
		 * @param processCnt 连接数
		 * @return 当前对象
		*/
		public MonitorNodeHost setProcessCnt(Integer processCnt) {
			super.change(PROCESS_CNT,super.getProcessCnt(),processCnt);
			super.setProcessCnt(processCnt);
			return this;
		}
		
		/**
		 * 设置 内存
		 * @param pMemoryUsed 内存
		 * @return 当前对象
		*/
		public MonitorNodeHost setPMemoryUsed(Integer pMemoryUsed) {
			super.change(P_MEMORY_USED,super.getPMemoryUsed(),pMemoryUsed);
			super.setPMemoryUsed(pMemoryUsed);
			return this;
		}
		
		/**
		 * 设置 虚拟内存
		 * @param vMemoryUsed 虚拟内存
		 * @return 当前对象
		*/
		public MonitorNodeHost setVMemoryUsed(Integer vMemoryUsed) {
			super.change(V_MEMORY_USED,super.getVMemoryUsed(),vMemoryUsed);
			super.setVMemoryUsed(vMemoryUsed);
			return this;
		}
		
		/**
		 * 设置 信息
		 * @param info 信息
		 * @return 当前对象
		*/
		public MonitorNodeHost setInfo(String info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public MonitorNodeHost setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorNodeHost setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNodeHost setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNodeHost setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNodeHost setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNodeHost setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNodeHost setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNodeHost setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNodeHost setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNodeHost setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
	}
}