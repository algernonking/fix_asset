package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorNode;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeValue;
import java.util.List;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import com.dt.platform.domain.ops.MonitorTpl;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-02-19 19:33:24
 * @sign AD05D1BF87A9419EA366092F81827D76
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorNodeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String NODE_IP="nodeIp";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NODE_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NODE_IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PID="pid";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> PID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,PID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 子类型 , 类型: java.lang.String
	*/
	public static final String SUB_TYPE="subType";
	
	/**
	 * 子类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> SUB_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SUB_TYPE, java.lang.String.class, "子类型", "子类型", java.lang.String.class, null);
	
	/**
	 * 节点分组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 节点分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,GROUP_ID, java.lang.String.class, "节点分组", "节点分组", java.lang.String.class, null);
	
	/**
	 * 主机名 , 类型: java.lang.String
	*/
	public static final String NODE_NAME="nodeName";
	
	/**
	 * 主机名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NODE_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NODE_NAME, java.lang.String.class, "主机名", "主机名", java.lang.String.class, null);
	
	/**
	 * 可见主机名 , 类型: java.lang.String
	*/
	public static final String NODE_NAME_SHOW="nodeNameShow";
	
	/**
	 * 可见主机名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NODE_NAME_SHOW_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NODE_NAME_SHOW, java.lang.String.class, "可见主机名", "可见主机名", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String NODE_TYPE="nodeType";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NODE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NODE_TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 是否启用 , 类型: java.lang.String
	*/
	public static final String NODE_ENABLED="nodeEnabled";
	
	/**
	 * 是否启用 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NODE_ENABLED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NODE_ENABLED, java.lang.String.class, "是否启用", "是否启用", java.lang.String.class, null);
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,STATUS, java.lang.String.class, "监控状态", "监控状态", java.lang.String.class, null);
	
	/**
	 * 凭证(SSH) , 类型: java.lang.String
	*/
	public static final String SSH_VOUCHER_ID="sshVoucherId";
	
	/**
	 * 凭证(SSH) , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> SSH_VOUCHER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SSH_VOUCHER_ID, java.lang.String.class, "凭证(SSH)", "凭证(SSH)", java.lang.String.class, null);
	
	/**
	 * SSH端口 , 类型: java.lang.Integer
	*/
	public static final String SSH_PORT="sshPort";
	
	/**
	 * SSH端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> SSH_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SSH_PORT, java.lang.Integer.class, "SSH端口", "SSH端口", java.lang.Integer.class, null);
	
	/**
	 * Agent端口 , 类型: java.lang.Integer
	*/
	public static final String AGENT_PORT="agentPort";
	
	/**
	 * Agent端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> AGENT_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,AGENT_PORT, java.lang.Integer.class, "Agent端口", "Agent端口", java.lang.Integer.class, null);
	
	/**
	 * Zabbix代理端口 , 类型: java.lang.Integer
	*/
	public static final String ZABBIX_AGENG_PORT="zabbixAgengPort";
	
	/**
	 * Zabbix代理端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> ZABBIX_AGENG_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,ZABBIX_AGENG_PORT, java.lang.Integer.class, "Zabbix代理端口", "Zabbix代理端口", java.lang.Integer.class, null);
	
	/**
	 * Snmp端口 , 类型: java.lang.Integer
	*/
	public static final String SNMP_PORT="snmpPort";
	
	/**
	 * Snmp端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> SNMP_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SNMP_PORT, java.lang.Integer.class, "Snmp端口", "Snmp端口", java.lang.Integer.class, null);
	
	/**
	 * Snmp版本 , 类型: java.lang.String
	*/
	public static final String SNMP_VERSION="snmpVersion";
	
	/**
	 * Snmp版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> SNMP_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SNMP_VERSION, java.lang.String.class, "Snmp版本", "Snmp版本", java.lang.String.class, null);
	
	/**
	 * Snmp团体 , 类型: java.lang.String
	*/
	public static final String SNMP_COMMUNITY="snmpCommunity";
	
	/**
	 * Snmp团体 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> SNMP_COMMUNITY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SNMP_COMMUNITY, java.lang.String.class, "Snmp团体", "Snmp团体", java.lang.String.class, null);
	
	/**
	 * Jmx端口 , 类型: java.lang.Integer
	*/
	public static final String JMX_PORT="jmxPort";
	
	/**
	 * Jmx端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> JMX_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,JMX_PORT, java.lang.Integer.class, "Jmx端口", "Jmx端口", java.lang.Integer.class, null);
	
	/**
	 * Jmx端口 , 类型: java.lang.Integer
	*/
	public static final String IMPI_PORT="impiPort";
	
	/**
	 * Jmx端口 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> IMPI_PORT_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,IMPI_PORT, java.lang.Integer.class, "Jmx端口", "Jmx端口", java.lang.Integer.class, null);
	
	/**
	 * Jdbc地址 , 类型: java.lang.String
	*/
	public static final String JDBC_URL="jdbcUrl";
	
	/**
	 * Jdbc地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> JDBC_URL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,JDBC_URL, java.lang.String.class, "Jdbc地址", "Jdbc地址", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * ssh凭证 , 类型: com.dt.platform.domain.ops.MonitorVoucher
	*/
	public static final String SSH_VOUCHER="sshVoucher";
	
	/**
	 * ssh凭证 , 类型: com.dt.platform.domain.ops.MonitorVoucher
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorVoucher> SSH_VOUCHER_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,SSH_VOUCHER, com.dt.platform.domain.ops.MonitorVoucher.class, "ssh凭证", "ssh凭证", com.dt.platform.domain.ops.MonitorVoucher.class, null);
	
	/**
	 * 数据库信息 , 类型: com.dt.platform.domain.ops.MonitorNodeDb
	*/
	public static final String MONITOR_NODE_DB="monitorNodeDb";
	
	/**
	 * 数据库信息 , 类型: com.dt.platform.domain.ops.MonitorNodeDb
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorNodeDb> MONITOR_NODE_DB_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_NODE_DB, com.dt.platform.domain.ops.MonitorNodeDb.class, "数据库信息", "数据库信息", com.dt.platform.domain.ops.MonitorNodeDb.class, null);
	
	/**
	 * 数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeValue
	*/
	public static final String MONITOR_NODE_VALUE_LIST="monitorNodeValueList";
	
	/**
	 * 数值信息 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorNodeValue
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorNodeValue> MONITOR_NODE_VALUE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_NODE_VALUE_LIST, java.util.List.class, "数值信息", "数值信息", com.dt.platform.domain.ops.MonitorNodeValue.class, null);
	
	/**
	 * 节点分组 , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final String MONITOR_NODE_GROUP="monitorNodeGroup";
	
	/**
	 * 节点分组 , 类型: com.dt.platform.domain.ops.MonitorNodeGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorNodeGroup> MONITOR_NODE_GROUP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_NODE_GROUP, com.dt.platform.domain.ops.MonitorNodeGroup.class, "节点分组", "节点分组", com.dt.platform.domain.ops.MonitorNodeGroup.class, null);
	
	/**
	 * 节点类型 , 类型: com.dt.platform.domain.ops.MonitorNodeType
	*/
	public static final String MONITOR_NODE_TYPE="monitorNodeType";
	
	/**
	 * 节点类型 , 类型: com.dt.platform.domain.ops.MonitorNodeType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorNodeType> MONITOR_NODE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_NODE_TYPE, com.dt.platform.domain.ops.MonitorNodeType.class, "节点类型", "节点类型", com.dt.platform.domain.ops.MonitorNodeType.class, null);
	
	/**
	 * 节点子类型 , 类型: com.dt.platform.domain.ops.MonitorNodeSubtype
	*/
	public static final String MONITOR_NODE_SUB_TYPE="monitorNodeSubType";
	
	/**
	 * 节点子类型 , 类型: com.dt.platform.domain.ops.MonitorNodeSubtype
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorNodeSubtype> MONITOR_NODE_SUB_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_NODE_SUB_TYPE, com.dt.platform.domain.ops.MonitorNodeSubtype.class, "节点子类型", "节点子类型", com.dt.platform.domain.ops.MonitorNodeSubtype.class, null);
	
	/**
	 * 监控模版列表 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final String MONITOR_TPL_LIST="monitorTplList";
	
	/**
	 * 监控模版列表 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.MonitorTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,com.dt.platform.domain.ops.MonitorTpl> MONITOR_TPL_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_TPL_LIST, java.util.List.class, "监控模版列表", "监控模版列表", com.dt.platform.domain.ops.MonitorTpl.class, null);
	
	/**
	 * 监控模版Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String MONITOR_TPL_IDS="monitorTplIds";
	
	/**
	 * 监控模版Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorNode,java.lang.String> MONITOR_TPL_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorNode.class ,MONITOR_TPL_IDS, java.util.List.class, "监控模版Ids", "监控模版Ids", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NODE_IP , PID , TYPE , SUB_TYPE , GROUP_ID , NODE_NAME , NODE_NAME_SHOW , NODE_TYPE , NODE_ENABLED , STATUS , SSH_VOUCHER_ID , SSH_PORT , AGENT_PORT , ZABBIX_AGENG_PORT , SNMP_PORT , SNMP_VERSION , SNMP_COMMUNITY , JMX_PORT , IMPI_PORT , JDBC_URL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , SSH_VOUCHER , MONITOR_NODE_DB , MONITOR_NODE_VALUE_LIST , MONITOR_NODE_GROUP , MONITOR_NODE_TYPE , MONITOR_NODE_SUB_TYPE , MONITOR_TPL_LIST , MONITOR_TPL_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorNode {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorNode setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param nodeIp IP
		 * @return 当前对象
		*/
		public MonitorNode setNodeIp(String nodeIp) {
			super.change(NODE_IP,super.getNodeIp(),nodeIp);
			super.setNodeIp(nodeIp);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param pid 父节点
		 * @return 当前对象
		*/
		public MonitorNode setPid(String pid) {
			super.change(PID,super.getPid(),pid);
			super.setPid(pid);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public MonitorNode setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 子类型
		 * @param subType 子类型
		 * @return 当前对象
		*/
		public MonitorNode setSubType(String subType) {
			super.change(SUB_TYPE,super.getSubType(),subType);
			super.setSubType(subType);
			return this;
		}
		
		/**
		 * 设置 节点分组
		 * @param groupId 节点分组
		 * @return 当前对象
		*/
		public MonitorNode setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 主机名
		 * @param nodeName 主机名
		 * @return 当前对象
		*/
		public MonitorNode setNodeName(String nodeName) {
			super.change(NODE_NAME,super.getNodeName(),nodeName);
			super.setNodeName(nodeName);
			return this;
		}
		
		/**
		 * 设置 可见主机名
		 * @param nodeNameShow 可见主机名
		 * @return 当前对象
		*/
		public MonitorNode setNodeNameShow(String nodeNameShow) {
			super.change(NODE_NAME_SHOW,super.getNodeNameShow(),nodeNameShow);
			super.setNodeNameShow(nodeNameShow);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param nodeType 类型
		 * @return 当前对象
		*/
		public MonitorNode setNodeType(String nodeType) {
			super.change(NODE_TYPE,super.getNodeType(),nodeType);
			super.setNodeType(nodeType);
			return this;
		}
		
		/**
		 * 设置 是否启用
		 * @param nodeEnabled 是否启用
		 * @return 当前对象
		*/
		public MonitorNode setNodeEnabled(String nodeEnabled) {
			super.change(NODE_ENABLED,super.getNodeEnabled(),nodeEnabled);
			super.setNodeEnabled(nodeEnabled);
			return this;
		}
		
		/**
		 * 设置 监控状态
		 * @param status 监控状态
		 * @return 当前对象
		*/
		public MonitorNode setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 凭证(SSH)
		 * @param sshVoucherId 凭证(SSH)
		 * @return 当前对象
		*/
		public MonitorNode setSshVoucherId(String sshVoucherId) {
			super.change(SSH_VOUCHER_ID,super.getSshVoucherId(),sshVoucherId);
			super.setSshVoucherId(sshVoucherId);
			return this;
		}
		
		/**
		 * 设置 SSH端口
		 * @param sshPort SSH端口
		 * @return 当前对象
		*/
		public MonitorNode setSshPort(Integer sshPort) {
			super.change(SSH_PORT,super.getSshPort(),sshPort);
			super.setSshPort(sshPort);
			return this;
		}
		
		/**
		 * 设置 Agent端口
		 * @param agentPort Agent端口
		 * @return 当前对象
		*/
		public MonitorNode setAgentPort(Integer agentPort) {
			super.change(AGENT_PORT,super.getAgentPort(),agentPort);
			super.setAgentPort(agentPort);
			return this;
		}
		
		/**
		 * 设置 Zabbix代理端口
		 * @param zabbixAgengPort Zabbix代理端口
		 * @return 当前对象
		*/
		public MonitorNode setZabbixAgengPort(Integer zabbixAgengPort) {
			super.change(ZABBIX_AGENG_PORT,super.getZabbixAgengPort(),zabbixAgengPort);
			super.setZabbixAgengPort(zabbixAgengPort);
			return this;
		}
		
		/**
		 * 设置 Snmp端口
		 * @param snmpPort Snmp端口
		 * @return 当前对象
		*/
		public MonitorNode setSnmpPort(Integer snmpPort) {
			super.change(SNMP_PORT,super.getSnmpPort(),snmpPort);
			super.setSnmpPort(snmpPort);
			return this;
		}
		
		/**
		 * 设置 Snmp版本
		 * @param snmpVersion Snmp版本
		 * @return 当前对象
		*/
		public MonitorNode setSnmpVersion(String snmpVersion) {
			super.change(SNMP_VERSION,super.getSnmpVersion(),snmpVersion);
			super.setSnmpVersion(snmpVersion);
			return this;
		}
		
		/**
		 * 设置 Snmp团体
		 * @param snmpCommunity Snmp团体
		 * @return 当前对象
		*/
		public MonitorNode setSnmpCommunity(String snmpCommunity) {
			super.change(SNMP_COMMUNITY,super.getSnmpCommunity(),snmpCommunity);
			super.setSnmpCommunity(snmpCommunity);
			return this;
		}
		
		/**
		 * 设置 Jmx端口
		 * @param jmxPort Jmx端口
		 * @return 当前对象
		*/
		public MonitorNode setJmxPort(Integer jmxPort) {
			super.change(JMX_PORT,super.getJmxPort(),jmxPort);
			super.setJmxPort(jmxPort);
			return this;
		}
		
		/**
		 * 设置 Jmx端口
		 * @param impiPort Jmx端口
		 * @return 当前对象
		*/
		public MonitorNode setImpiPort(Integer impiPort) {
			super.change(IMPI_PORT,super.getImpiPort(),impiPort);
			super.setImpiPort(impiPort);
			return this;
		}
		
		/**
		 * 设置 Jdbc地址
		 * @param jdbcUrl Jdbc地址
		 * @return 当前对象
		*/
		public MonitorNode setJdbcUrl(String jdbcUrl) {
			super.change(JDBC_URL,super.getJdbcUrl(),jdbcUrl);
			super.setJdbcUrl(jdbcUrl);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MonitorNode setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorNode setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorNode setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorNode setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorNode setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorNode setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorNode setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorNode setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorNode setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ssh凭证
		 * @param sshVoucher ssh凭证
		 * @return 当前对象
		*/
		public MonitorNode setSshVoucher(MonitorVoucher sshVoucher) {
			super.change(SSH_VOUCHER,super.getSshVoucher(),sshVoucher);
			super.setSshVoucher(sshVoucher);
			return this;
		}
		
		/**
		 * 设置 数据库信息
		 * @param monitorNodeDb 数据库信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeDb(MonitorNodeDb monitorNodeDb) {
			super.change(MONITOR_NODE_DB,super.getMonitorNodeDb(),monitorNodeDb);
			super.setMonitorNodeDb(monitorNodeDb);
			return this;
		}
		
		/**
		 * 设置 数值信息
		 * @param monitorNodeValueList 数值信息
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeValueList(List<MonitorNodeValue> monitorNodeValueList) {
			super.change(MONITOR_NODE_VALUE_LIST,super.getMonitorNodeValueList(),monitorNodeValueList);
			super.setMonitorNodeValueList(monitorNodeValueList);
			return this;
		}
		
		/**
		 * 设置 节点分组
		 * @param monitorNodeGroup 节点分组
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeGroup(MonitorNodeGroup monitorNodeGroup) {
			super.change(MONITOR_NODE_GROUP,super.getMonitorNodeGroup(),monitorNodeGroup);
			super.setMonitorNodeGroup(monitorNodeGroup);
			return this;
		}
		
		/**
		 * 设置 节点类型
		 * @param monitorNodeType 节点类型
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeType(MonitorNodeType monitorNodeType) {
			super.change(MONITOR_NODE_TYPE,super.getMonitorNodeType(),monitorNodeType);
			super.setMonitorNodeType(monitorNodeType);
			return this;
		}
		
		/**
		 * 设置 节点子类型
		 * @param monitorNodeSubType 节点子类型
		 * @return 当前对象
		*/
		public MonitorNode setMonitorNodeSubType(MonitorNodeSubtype monitorNodeSubType) {
			super.change(MONITOR_NODE_SUB_TYPE,super.getMonitorNodeSubType(),monitorNodeSubType);
			super.setMonitorNodeSubType(monitorNodeSubType);
			return this;
		}
		
		/**
		 * 设置 监控模版列表
		 * @param monitorTplList 监控模版列表
		 * @return 当前对象
		*/
		public MonitorNode setMonitorTplList(List<MonitorTpl> monitorTplList) {
			super.change(MONITOR_TPL_LIST,super.getMonitorTplList(),monitorTplList);
			super.setMonitorTplList(monitorTplList);
			return this;
		}
		
		/**
		 * 设置 监控模版Ids
		 * @param monitorTplIds 监控模版Ids
		 * @return 当前对象
		*/
		public MonitorNode setMonitorTplIds(List<String> monitorTplIds) {
			super.change(MONITOR_TPL_IDS,super.getMonitorTplIds(),monitorTplIds);
			super.setMonitorTplIds(monitorTplIds);
			return this;
		}
	}
}