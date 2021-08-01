package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.OpsServiceVO;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-01 21:59:42
 * @sign B28BCF0CB2E012CFE4B26F17474A8DA7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class OpsServiceVOMeta extends OpsServiceMeta {
	
	/**
	 * 页码
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.Integer> PAGE_INDEX_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.Integer> PAGE_SIZE_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> SEARCH_FIELD_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> FUZZY_FIELD_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> SEARCH_VALUE_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 排序字段
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> SORT_FIELD_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> SORT_TYPE_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.OpsServiceVO,java.lang.String> IDS_PROP=new BeanProperty(com.dt.platform.domain.ops.OpsServiceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , SORT_FIELD , SORT_TYPE , IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.OpsServiceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public OpsServiceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public OpsServiceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public OpsServiceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public OpsServiceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public OpsServiceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public OpsServiceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public OpsServiceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public OpsServiceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
	}
}