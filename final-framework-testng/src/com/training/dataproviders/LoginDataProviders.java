package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getnewproducts(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			
			obj[0] = temp.getprdct_name(); 
			obj[1] = temp.getmeta(); 
			obj[2] = temp.getmodel(); 
			obj[3] = temp.getprice(); 
			obj[4] = temp.getquantity(); 
			obj[5] = temp.getcategory(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\UniformTestcase\\TestData.xlsx"; 
		String SheetName="Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\UniformTestcase\\TestData.xlsx"; 
		String SheetName="Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\Users\\IBM_ADMIN\\Desktop\\UniformTestcase\\TestData.xlsx"; 
		String SheetName="Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,SheetName); 
	}
	// create one more from 33 to 38 line //
	
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\Users\\IBM_ADMIN\\Desktop\\UniformTestcase\\TestData.xlsx", "Sheet1"); 
	}
}
