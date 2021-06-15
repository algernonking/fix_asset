package com.dt.eam.wrapper;

import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.dt.eam.framework.EamMeta;

@ComponentScan(basePackages = { 
		FoxnicWebMeta.SERVICE_STORAGE_PACKAGE , FoxnicWebMeta.SERVICE_SYSTEM_PACKAGE , FoxnicWebMeta.SERVICE_OAUTH_PACKAGE,
		EamMeta.SERVICE_EAM_PACKAGE,EamMeta.SERVICE_HRM_PACKAGE
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
public class WrapperAllApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperAllApp.class, args);
	}
}
