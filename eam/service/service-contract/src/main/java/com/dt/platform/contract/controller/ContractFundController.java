package com.dt.platform.contract.controller;

 
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.contract.ContractFundServiceProxy;
import com.dt.platform.domain.contract.meta.ContractFundVOMeta;
import com.dt.platform.domain.contract.ContractFund;
import com.dt.platform.domain.contract.ContractFundVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.contract.meta.ContractFundMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.contract.service.IContractFundService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 资金明细 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-02 09:30:30
*/

@Api(tags = "资金明细")
@ApiSort(0)
@RestController("ContContractFundController")
public class ContractFundController extends SuperController {

	@Autowired
	private IContractFundService contractFundService;

	
	/**
	 * 添加资金明细
	*/
	@ApiOperation(value = "添加资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.MONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractFundVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.RECEIPT_PAYMENT_TIME , value = "收付时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractFundVOMeta.INVOICE_ID , value = "发票" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ContractFundVOMeta.ID)
	@SentinelResource(value = ContractFundServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.INSERT)
	public Result insert(ContractFundVO contractFundVO) {
		Result result=contractFundService.insert(contractFundVO);
		return result;
	}

	
	/**
	 * 删除资金明细
	*/
	@ApiOperation(value = "删除资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContractFundVOMeta.ID)
	@SentinelResource(value = ContractFundServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contractFundService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除资金明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContractFundVOMeta.IDS)
	@SentinelResource(value = ContractFundServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contractFundService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新资金明细
	*/
	@ApiOperation(value = "更新资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.MONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractFundVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.RECEIPT_PAYMENT_TIME , value = "收付时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractFundVOMeta.INVOICE_ID , value = "发票" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContractFundVOMeta.PAGE_INDEX , ContractFundVOMeta.PAGE_SIZE , ContractFundVOMeta.SEARCH_FIELD , ContractFundVOMeta.FUZZY_FIELD , ContractFundVOMeta.SEARCH_VALUE , ContractFundVOMeta.SORT_FIELD , ContractFundVOMeta.SORT_TYPE , ContractFundVOMeta.IDS } ) 
	@NotNull(name = ContractFundVOMeta.ID)
	@SentinelResource(value = ContractFundServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.UPDATE)
	public Result update(ContractFundVO contractFundVO) {
		Result result=contractFundService.update(contractFundVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存资金明细
	*/
	@ApiOperation(value = "保存资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.MONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractFundVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.RECEIPT_PAYMENT_TIME , value = "收付时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractFundVOMeta.INVOICE_ID , value = "发票" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractFundVOMeta.PAGE_INDEX , ContractFundVOMeta.PAGE_SIZE , ContractFundVOMeta.SEARCH_FIELD , ContractFundVOMeta.FUZZY_FIELD , ContractFundVOMeta.SEARCH_VALUE , ContractFundVOMeta.SORT_FIELD , ContractFundVOMeta.SORT_TYPE , ContractFundVOMeta.IDS } )
	@NotNull(name = ContractFundVOMeta.ID)
	@SentinelResource(value = ContractFundServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.SAVE)
	public Result save(ContractFundVO contractFundVO) {
		Result result=contractFundService.save(contractFundVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取资金明细
	*/
	@ApiOperation(value = "获取资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContractFundVOMeta.ID)
	@SentinelResource(value = ContractFundServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.GET_BY_ID)
	public Result<ContractFund> getById(String id) {
		Result<ContractFund> result=new Result<>();
		ContractFund contractFund=contractFundService.getById(id);
		result.success(true).data(contractFund);
		return result;
	}


	/**
	 * 批量删除资金明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除资金明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContractFundVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContractFundVOMeta.IDS)
		@SentinelResource(value = ContractFundServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.GET_BY_IDS)
	public Result<List<ContractFund>> getByIds(List<String> ids) {
		Result<List<ContractFund>> result=new Result<>();
		List<ContractFund> list=contractFundService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询资金明细
	*/
	@ApiOperation(value = "查询资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.MONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractFundVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.RECEIPT_PAYMENT_TIME , value = "收付时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractFundVOMeta.INVOICE_ID , value = "发票" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContractFundVOMeta.PAGE_INDEX , ContractFundVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContractFundServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.QUERY_LIST)
	public Result<List<ContractFund>> queryList(ContractFundVO sample) {
		Result<List<ContractFund>> result=new Result<>();
		List<ContractFund> list=contractFundService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询资金明细
	*/
	@ApiOperation(value = "分页查询资金明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContractFundVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.MONEY , value = "总金额" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = ContractFundVOMeta.FUND_DIRECT , value = "资金流向" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.RECEIPT_PAYMENT_TIME , value = "收付时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = ContractFundVOMeta.INVOICE_ID , value = "发票" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContractFundVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContractFundServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContractFundServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ContractFund>> queryPagedList(ContractFundVO sample) {
		Result<PagedList<ContractFund>> result=new Result<>();
		PagedList<ContractFund> list=contractFundService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContractFundServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractFundServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContractFundVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=contractFundService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContractFundServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractFundServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=contractFundService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ContractFundServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContractFundServiceProxy.IMPORT_EXCEL)
	public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

			//获得上传的文件
			Map<String, MultipartFile> map = request.getFileMap();
			InputStream input=null;
			for (MultipartFile mf : map.values()) {
				input=StreamUtil.bytes2input(mf.getBytes());
				break;
			}

			if(input==null) {
				return ErrorDesc.failure().message("缺少上传的文件");
			}

			List<ValidateResult> errors=contractFundService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}