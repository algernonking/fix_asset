package com.dt.platform.relation;

import com.dt.platform.relation.modules.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.relation.modules.*;


public class PlatformRelationManager extends RelationManager {

	public PlatformRelationManager() {
		super(
				new OAuthRelationManager(),
				new SystemRelationManager(),
				new CodeExampleRelationManager(),
				new HrmRelationManager(),
				new PcmRelationManager(),
				//
				new HRMRelationManager(),
				new KNRelationManager(),
				new EAMRelationManager(),
				new OPSRelationManager(),
				new CommonRelationManager(),
				new DCRelationManager(),
				new ContractRelationManager()

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
