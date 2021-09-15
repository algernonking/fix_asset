

/opt/upload/tpl


delete from sys_file where id like 'T001_%';
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_1','eam_asset_borrow.docx','tpl/T001/eam_asset_borrow.docx',10000,'application/doc','docx')




Mapping List:
delete from sys_user_file where tenant_id='T001'


/tpl/asset_doc.docx
/tpl/asset_down.xlsx




	String path = AssetRepairController.class.getClassLoader().getResource("").getPath();



		InputStream inputStream =this.getClass().getClassLoader().getResourceAsStream("labeltpl2.docx");



		System.out.println(path);
			//生成 Excel 模版

			///Users/lank/IdeaProjectsnew/eam/eam/wrapper/wrapper-all/target/classes/
			Map<String, Object> data = new HashMap<>();
			data.put("name", "Sayi");
			data.put("classname", "2019-08-04");


			XWPFTemplate template = XWPFTemplate.compile(inputStream).render(data);

		//	template.writeAndClose(new FileOutputStream("output.docx"));

	//	template.write(OutputStream stream);
	//		ExcelWriter ew=assetRepairService.exportExcelTemplate();
	//			//下载
	//			DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());

			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition","attachment;filename=\""+"out_template.docx"+"\"");
			OutputStream out = response.getOutputStream();
		    template.write( out);
			BufferedOutputStream bos = new BufferedOutputStream(out);
			template.write(bos);
			bos.flush();
			out.flush();
			PoitlIOUtils.closeQuietlyMulti(template, bos, out);
