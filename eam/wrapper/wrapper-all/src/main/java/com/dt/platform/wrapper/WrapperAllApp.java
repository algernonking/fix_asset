package com.dt.platform.wrapper;

import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.dt.platform.framework.PlatformMeta;

@ComponentScan(basePackages = {
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE ,
		FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE ,
		FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		PlatformMeta.FRAMEWORK_PACKAGE,
		PlatformMeta.SERVICE_EAM_PACKAGE,
		PlatformMeta.SERVICE_HRM_PACKAGE,
		PlatformMeta.DATACENTER_PACKAGE,
		PlatformMeta.OPS_PACKAGE,
		PlatformMeta.COMMON_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WrapperAllApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}
}
