package org.github.foxnic.web.wrapper;

import com.dt.platform.framework.PlatformMeta;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.github.foxnic.web.framework.FoxnicWebMeta;
import org.github.foxnic.web.framework.starter.BootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {
		PlatformMeta.FRAMEWORK_PACKAGE, FoxnicWebMeta.SERVICE_CAMUNDA_PACKAGE,
})
@SpringBootApplication(exclude = {FeignAutoConfiguration.class})
@EnableProcessApplication
public class WrapperCamundaApp {

	public static void main(String[] args) {
		BootApplication.run(WrapperCamundaApp.class, args);
	}

}
