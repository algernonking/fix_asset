package com.dt.platform.common.service.impl;


import com.dt.platform.common.service.ICodeModuleService;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.busi.id.SequenceType;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.stereotype.Service;
import com.github.foxnic.api.transter.Result;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 编码分配属性 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-08-07 22:35:49
*/


@Service("CodeParseService")
public class CodeModuleServiceImpl implements ICodeModuleService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }


	/**
	 * 测试
	 * */
	private void test(){
		System.out.println(parseCode("${string_fix,CODE}"));
		System.out.println(parseCode("${string_fix,CODE}${time,yyyy}${time,mm}${time,dd}${string_fix,-}${number_rand,5}"));
		System.out.println(parsePlaceholder("{time,yyyy}"));
		System.out.println(parsePlaceholder("{time,mm}"));
		System.out.println(parsePlaceholder("{time,dd}"));
		System.out.println(parsePlaceholder("{time,hh}"));
		System.out.println(parsePlaceholder("{time,mm}"));
		System.out.println(parsePlaceholder("{time,ss}"));
		System.out.println(parsePlaceholder("{string_fix,AS}"));
		System.out.println(parsePlaceholder("{string_fix,-}"));
		System.out.println(parsePlaceholder("{string_fix,/}"));
		System.out.println(parsePlaceholder("{string_rand,5}"));
		System.out.println(parsePlaceholder("{number_seq,5,asset}"));
		System.out.println(parsePlaceholder("{number_seq,0,asset}"));
		System.out.println("1-"+parsePlaceholder("{number_rand,1}"));
		System.out.println(parsePlaceholder("{number_rand,2}"));
		System.out.println(parsePlaceholder("{number_rand,3}"));
		System.out.println(parsePlaceholder("{number_rand,5}"));
		System.out.println(parsePlaceholder("{number_rand,8}"));
		System.out.println(parsePlaceholder("{number_rand}"));
	}


	/**
	 * 获取业务编码
	 * @param module 传入业务编码模块
	 * @return 返回编号
	 * */
	public Result generateCode(String module){
		Result result = new Result();
		Rcd rs=dao.queryRecord("select b.rule rule from sys_code_allocation a,sys_code_rule b where a.rule_id=b.id and a.deleted=0 and b.deleted=0 and a.module=?",module);
		if(rs==null){
			ErrorDesc.failure().message("id 不允许为 null 。");
		}
		String code=parseCode(rs.getString("rule"));
		result.success(true);
		result.data(code);
		return result;

	}

	/**
	 * 生成编码
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseCode(String ph){
//		if (ph==null){
//			return null;
//		}
		String result="";
		String[] pharr=ph.split("\\$");
		for(int i=0;i< pharr.length;i++){
			if(i>0){
				result=result+parsePlaceholder(pharr[i]);
			}
		}
		return result;
	}

	/**
	 * 解析占位符编码
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parsePlaceholder(String ph){
//		if(ph==null){
//			return "";
//		}
		String type=ph.replaceAll("\\{","").replaceAll("\\}","").split(",")[0];
		if(type.equals(CodeAttrTypeEnum.TIME.code())){
			return parseTime(ph);
		}else if (type.equals(CodeAttrTypeEnum.STRING_FIX.code())){
			return parseStringFix(ph);
		}else if (type.equals(CodeAttrTypeEnum.STRING_RAND.code())){
			return parseStringRand(ph);
		}else if (type.equals(CodeAttrTypeEnum.NUMBER_RAND.code())){
			return parseNumberRand(ph);
		}else if (type.equals(CodeAttrTypeEnum.NUMBER_SEQ.code())){
			return parseNumberSeq(ph);
		}else if (type.equals(CodeAttrTypeEnum.ORG.code())){
			return "";
		}
		return null;
	}

	/**
	 * 解析时间占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseTime(String ph){
		String timeNow = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS").format(Calendar.getInstance().getTime());
		String [] timeArr=timeNow.split("-");
		String year=timeArr[0];
		String month=timeArr[1];
		String day=timeArr[2];
		String hour=timeArr[3];
		String mins=timeArr[4];
		String second=timeArr[4];
//		if(ph==null){
//			return "";
//		}
		return ph.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",yyyy\\}",year)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",month)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",dd\\}",day)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",hh\\}",hour)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",mm\\}",mins)
				.replaceAll("\\{"+ CodeAttrTypeEnum.TIME.code() +",ss\\}",second);
	}

	/**
	 * 解析字符串占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseStringFix(String ph){
//		if(ph==null){
//			return "";
//		}
		return ph.replaceAll("\\{"+CodeAttrTypeEnum.STRING_FIX.code() +",","")
				.replaceAll("\\}","").trim();
	}

	/**
	 * 按照指定长度生成字符串
	 * @param length 长度
	 * @return 返回随时资产负债
	 * */
	public String getRandomString(int length){
		String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++){
			int number=random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 解析字符串占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseStringRand(String ph){
		int phLength=1;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		if(attr.length>=2){
			phLength=Integer.valueOf(attr[1]);
		}
		return getRandomString(phLength).toUpperCase();
	}

	/**
	 * 解析数字类型占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseNumberRand(String ph){
		int phLength=1;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		if(attr.length>=2){
			phLength=Integer.valueOf(attr[1]);
		}
		return String.valueOf((int)((Math.random()*9+1)*Math.pow(10,phLength-1)));
	}

	/**
	 * 解析数字类型占位符
	 * @param ph 传入占位符
	 * @return 返回编号
	 * */
	public String parseNumberSeq(String ph){
		String seqSource="default";
		int phLength=0;
		String[] attr=ph.replaceAll("\\{","").replaceAll("\\}","").split(",");
		for(int i=0;i<attr.length;i++){
			if(i==1){
				phLength=Integer.valueOf(attr[i]);
			}else if(i==2){
				seqSource=attr[i];
			}
		}
		System.out.println("##############"+seqSource);
		dao.createSequence(seqSource, SequenceType.AI,5);
		System.out.println("############2##"+seqSource);
		return dao.getNextSequenceValue(seqSource);
	}


}