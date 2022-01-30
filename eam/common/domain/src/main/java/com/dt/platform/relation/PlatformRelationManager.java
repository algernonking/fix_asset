package com.dt.platform.relation;

import com.dt.platform.relation.modules.*;
import com.dt.platform.relation.modules.HrmRelationManager;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.relation.modules.*;


public class PlatformRelationManager extends RelationManager {

	public PlatformRelationManager() {
		super(
				new OAuthRelationManager(),
				new SystemRelationManager(),
				new CodeExampleRelationManager(),
				new org.github.foxnic.web.relation.modules.HrmRelationManager(),
				new PcmRelationManager(),
				new BpmRelationManager(),
				new DataPermRelationManager(),
				new JobRelationManager(),
				//
				new HrmRelationManager(),
				new KnRelationManager(),
				new EamRelationManager(),
				new OpsRelationManager(),
				new CommonRelationManager(),
				new DatacenterRelationManager(),
				new ContractRelationManager(),
				new MonitorRelationManager()

		);
		//启动动态刷入
		startMonitor();
	}

	public void startMonitor() {
//		if(SpringUtil.isReady()) {
//			SimpleTaskManager tm=new SimpleTaskManager();
//			tm.doIntervalTask(new Runnable() {
//				@Override
//				public void run() {
//					doReConfigAndValidate();
//				}
//			}, 3000);
//		}
	}


	protected void doReConfigAndValidate() {
		PlatformRelationManager.this.reconfig();
//		FoxnicWebRelationManager.this.validate();
//		Logger.info("FoxnicWebRelationManager Reconfig");
	}


	@Override
	protected void config() {}






}
