package com.dt.platform.eam.controller;


import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "我的事项")
@ApiSort(0)
@RestController("EamMyBusinessController")
public class MyBusinessController  extends SuperController {


}
