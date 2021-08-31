package com.dt.platform.knowledgebase.controller;

 
import java.util.List;

import com.github.foxnic.sql.expr.ConditionExpr;
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


import com.dt.platform.proxy.knowledgebase.ContentServiceProxy;
import com.dt.platform.domain.knowledgebase.meta.ContentVOMeta;
import com.dt.platform.domain.knowledgebase.Content;
import com.dt.platform.domain.knowledgebase.ContentVO;
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
import com.dt.platform.domain.knowledgebase.meta.ContentMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.knowledgebase.Category;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.knowledgebase.service.IContentService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 知识库内容 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-31 22:07:21
*/

@Api(tags = "知识库内容")
@ApiSort(0)
@RestController("KnContentController")
public class ContentController extends SuperController {

	@Autowired
	private IContentService contentService;

	
	/**
	 * 添加知识库内容
	*/
	@ApiOperation(value = "添加知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
		@ApiImplicitParam(name = ContentVOMeta.CATEGORY_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "百度一下，你就知道"),
		@ApiImplicitParam(name = ContentVOMeta.PROFILE , value = "简介" , required = false , dataTypeClass=String.class , example = "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果"),
		@ApiImplicitParam(name = ContentVOMeta.KEY_WORDS , value = "关键字" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT , value = "知识内容" , required = false , dataTypeClass=String.class , example = "百度"),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT_TYPE , value = "内容类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.REVIEW_COUNT , value = "阅读数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ContentVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ContentVOMeta.LINK_ADDRESS , value = "链接地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.GRADE_ID , value = "等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.EDITOR_ID , value = "编辑人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=1)
	@NotNull(name = ContentVOMeta.ID)
	@SentinelResource(value = ContentServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.INSERT)
	public Result insert(ContentVO contentVO) {
		Result result=contentService.insert(contentVO);
		return result;
	}

	
	/**
	 * 删除知识库内容
	*/
	@ApiOperation(value = "删除知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
	})
	@ApiOperationSupport(order=2)
	@NotNull(name = ContentVOMeta.ID)
	@SentinelResource(value = ContentServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.DELETE)
	public Result deleteById(String id) {
		Result result=contentService.deleteByIdLogical(id);
		return result;
	}
	
	
	/**
	 * 批量删除知识库内容 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3) 
	@NotNull(name = ContentVOMeta.IDS)
	@SentinelResource(value = ContentServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		Result result=contentService.deleteByIdsLogical(ids);
		return result;
	}
	
	/**
	 * 更新知识库内容
	*/
	@ApiOperation(value = "更新知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
		@ApiImplicitParam(name = ContentVOMeta.CATEGORY_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "百度一下，你就知道"),
		@ApiImplicitParam(name = ContentVOMeta.PROFILE , value = "简介" , required = false , dataTypeClass=String.class , example = "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果"),
		@ApiImplicitParam(name = ContentVOMeta.KEY_WORDS , value = "关键字" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT , value = "知识内容" , required = false , dataTypeClass=String.class , example = "百度"),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT_TYPE , value = "内容类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.REVIEW_COUNT , value = "阅读数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ContentVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ContentVOMeta.LINK_ADDRESS , value = "链接地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.GRADE_ID , value = "等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.EDITOR_ID , value = "编辑人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport( order=4 , ignoreParameters = { ContentVOMeta.PAGE_INDEX , ContentVOMeta.PAGE_SIZE , ContentVOMeta.SEARCH_FIELD , ContentVOMeta.FUZZY_FIELD , ContentVOMeta.SEARCH_VALUE , ContentVOMeta.SORT_FIELD , ContentVOMeta.SORT_TYPE , ContentVOMeta.IDS } ) 
	@NotNull(name = ContentVOMeta.ID)
	@SentinelResource(value = ContentServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.UPDATE)
	public Result update(ContentVO contentVO) {
		Result result=contentService.update(contentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}
	
	
	/**
	 * 保存知识库内容
	*/
	@ApiOperation(value = "保存知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
		@ApiImplicitParam(name = ContentVOMeta.CATEGORY_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "百度一下，你就知道"),
		@ApiImplicitParam(name = ContentVOMeta.PROFILE , value = "简介" , required = false , dataTypeClass=String.class , example = "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果"),
		@ApiImplicitParam(name = ContentVOMeta.KEY_WORDS , value = "关键字" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT , value = "知识内容" , required = false , dataTypeClass=String.class , example = "百度"),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT_TYPE , value = "内容类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.REVIEW_COUNT , value = "阅读数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ContentVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ContentVOMeta.LINK_ADDRESS , value = "链接地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.GRADE_ID , value = "等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.EDITOR_ID , value = "编辑人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContentVOMeta.PAGE_INDEX , ContentVOMeta.PAGE_SIZE , ContentVOMeta.SEARCH_FIELD , ContentVOMeta.FUZZY_FIELD , ContentVOMeta.SEARCH_VALUE , ContentVOMeta.SORT_FIELD , ContentVOMeta.SORT_TYPE , ContentVOMeta.IDS } )
	@NotNull(name = ContentVOMeta.ID)
	@SentinelResource(value = ContentServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.SAVE)
	public Result save(ContentVO contentVO) {
		Result result=contentService.save(contentVO,SaveMode.NOT_NULL_FIELDS);
		return result;
	}

	
	/**
	 * 获取知识库内容
	*/
	@ApiOperation(value = "获取知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6)
	@NotNull(name = ContentVOMeta.ID)
	@SentinelResource(value = ContentServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.GET_BY_ID)
	public Result<Content> getById(String id) {
		Result<Content> result=new Result<>();
		Content content=contentService.getById(id);
		// 关联出 分类 数据
		contentService.join(content,ContentMeta.CATEGORY);
		// 关联出 编辑人 数据
		contentService.join(content,ContentMeta.EDITOR);
		result.success(true).data(content);
		return result;
	}


	/**
	 * 批量删除知识库内容 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量删除知识库内容")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ContentVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3) 
		@NotNull(name = ContentVOMeta.IDS)
		@SentinelResource(value = ContentServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.GET_BY_IDS)
	public Result<List<Content>> getByIds(List<String> ids) {
		Result<List<Content>> result=new Result<>();
		List<Content> list=contentService.getByIds(ids);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 查询知识库内容
	*/
	@ApiOperation(value = "查询知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
		@ApiImplicitParam(name = ContentVOMeta.CATEGORY_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "百度一下，你就知道"),
		@ApiImplicitParam(name = ContentVOMeta.PROFILE , value = "简介" , required = false , dataTypeClass=String.class , example = "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果"),
		@ApiImplicitParam(name = ContentVOMeta.KEY_WORDS , value = "关键字" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT , value = "知识内容" , required = false , dataTypeClass=String.class , example = "百度"),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT_TYPE , value = "内容类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.REVIEW_COUNT , value = "阅读数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ContentVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ContentVOMeta.LINK_ADDRESS , value = "链接地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.GRADE_ID , value = "等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.EDITOR_ID , value = "编辑人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ContentVOMeta.PAGE_INDEX , ContentVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ContentServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.QUERY_LIST)
	public Result<List<Content>> queryList(ContentVO sample) {
		Result<List<Content>> result=new Result<>();
		List<Content> list=contentService.queryList(sample);
		result.success(true).data(list);
		return result;
	}

	
	/**
	 * 分页查询知识库内容
	*/
	@ApiOperation(value = "分页查询知识库内容")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ContentVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1359871843053346816"),
		@ApiImplicitParam(name = ContentVOMeta.CATEGORY_ID , value = "分类" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.TITLE , value = "标题" , required = false , dataTypeClass=String.class , example = "百度一下，你就知道"),
		@ApiImplicitParam(name = ContentVOMeta.PROFILE , value = "简介" , required = false , dataTypeClass=String.class , example = "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求。百度超过千亿的中文网页数据库，可以瞬间找到相关的搜索结果"),
		@ApiImplicitParam(name = ContentVOMeta.KEY_WORDS , value = "关键字" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.LABEL , value = "标签" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT , value = "知识内容" , required = false , dataTypeClass=String.class , example = "百度"),
		@ApiImplicitParam(name = ContentVOMeta.CONTENT_TYPE , value = "内容类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.REVIEW_COUNT , value = "阅读数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ContentVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.DISPLAY , value = "是否显示" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = ContentVOMeta.LINK_ADDRESS , value = "链接地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.GRADE_ID , value = "等级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.EDITOR_ID , value = "编辑人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ContentVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8)
	@SentinelResource(value = ContentServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ContentServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Content>> queryPagedList(ContentVO sample) {

		String search="";
		if(sample.getContent()!=null&&sample.getContent().length()>0){
			search=sample.getContent();
		}
		sample.setContent(null);
		Result<PagedList<Content>> result=new Result<>();
		ConditionExpr q=new ConditionExpr();
		q.ignore("","null","empty").andIf("MATCH (title,label,profile,content) AGAINST (? IN BOOLEAN MODE)" ,search);
		PagedList<Content> list=contentService.queryPagedList(sample,q,sample.getPageSize(),sample.getPageIndex());
		contentService.join(list,ContentMeta.CATEGORY);

		// 关联出 分类 数据
		contentService.join(list,ContentMeta.CATEGORY);
		// 关联出 编辑人 数据
		contentService.join(list,ContentMeta.EDITOR);


		result.success(true).data(list);
		return result;
	}



	/**
	 * 导出 Excel
	 * */
	@SentinelResource(value = ContentServiceProxy.EXPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContentServiceProxy.EXPORT_EXCEL)
	public void exportExcel(ContentVO  sample,HttpServletResponse response) throws Exception {
			//生成 Excel 数据
			ExcelWriter ew=contentService.exportExcel(sample);
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
	}


	/**
	 * 导出 Excel 模板
	 * */
	@SentinelResource(value = ContentServiceProxy.EXPORT_EXCEL_TEMPLATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContentServiceProxy.EXPORT_EXCEL_TEMPLATE)
	public void exportExcelTemplate(HttpServletResponse response) throws Exception {
			//生成 Excel 模版
			ExcelWriter ew=contentService.exportExcelTemplate();
			//下载
			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
		}




	@SentinelResource(value = ContentServiceProxy.IMPORT_EXCEL , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@RequestMapping(ContentServiceProxy.IMPORT_EXCEL)
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

			List<ValidateResult> errors=contentService.importExcel(input,0,true);
			if(errors==null || errors.isEmpty()) {
				return ErrorDesc.success();
			} else {
				return ErrorDesc.failure().message("导入失败").data(errors);
			}
		}


}