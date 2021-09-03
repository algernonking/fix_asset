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
