package com.dt.platform.wrapper;

import com.dt.platform.framework.PlatformMeta;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE ,
		FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		FoxnicWebMeta.SERVICE_HRM_PACKAGE,
		FoxnicWebMeta.SERVICE_PCM_PACKAGE,
		FoxnicWebMeta.SERVICE_CHANGES_PACKAGE,
		PlatformMeta.FRAMEWORK_PACKAGE,
		PlatformMeta.SERVICE_EAM_PACKAGE,
		PlatformMeta.SERVICE_HRM_PACKAGE,
		PlatformMeta.DATACENTER_PACKAGE,
		PlatformMeta.OPS_PACKAGE,
		PlatformMeta.COMMON_PACKAGE,
		PlatformMeta.KNOWLEDGEBASE_PACKAGE,
		PlatformMeta.CONTRACT_PACKAGE,
		PlatformMeta.CUSTOMER_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WrapperAllApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}
}
