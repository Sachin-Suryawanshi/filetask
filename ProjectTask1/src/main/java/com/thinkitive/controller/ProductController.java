//package com.thinkitive.controller;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.thinkitive.entity.AmazonProduct;
//import com.thinkitive.entity.Product;
//import com.thinkitive.repository.AmazonProductRepository;
//import com.thinkitive.repository.ProductRepository;
//import com.thinkitive.serviceimpl.AmazonProductServiceImpl;
//
//@RestController
//public class ProductController {
//	@Autowired
//	AmazonProductRepository amazonRepository;
//	@Autowired
//	ProductRepository productRepository;
//	@Autowired
//	AmazonProductServiceImpl amazonProductService;
//
//	@PostMapping(value ="/addAmazo" )
//	public AmazonProduct insertAmazonProduct(@RequestBody MultipartFile multipartFile)
//	{
//		try {
//			FileInputStream inputStream = new FileInputStream("");
//			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
//			//XSSFSheet sheet= workBook.getSheet("sheet1");
//			XSSFSheet sheet=workBook.getSheetAt(0);
//			int noOfRows=sheet.getLastRowNum();
//			int noOfCols=sheet.getRow(1).getLastCellNum();
//			for(int r=0;r<=noOfRows;r++)
//			{
//				XSSFRow row= sheet.getRow(r);
//				AmazonProduct amzonProduct=new AmazonProduct();
//				Product product=new Product();
//				for(int c=0;c<noOfCols;c++)
//				{
//					XSSFCell cell= row.getCell(c);
//					if(c==0)
//					{
//						switch (cell.getCellType()) {
//						case STRING:
//							product.setProductName(cell.getStringCellValue());
//							System.out.println(cell.getStringCellValue());
//							
//							break;
//						case NUMERIC:
//							System.out.println(cell.getNumericCellValue());
//							break;
//
//						default:
//							break;
//						}
//					}
//					if(c==1)
//					{
//						switch (cell.getCellType()) {
//						case STRING:
//							amzonProduct.setArticleNumber(cell.getStringCellValue());
//							System.out.println(cell.getStringCellValue());
//							
//							break;
//						case NUMERIC:
//							System.out.println(cell.getNumericCellValue());
//							break;
//
//						default:
//							break;
//						}
//					}
//					if(c==2)
//					{
//						switch (cell.getCellType()) {
//						case STRING:
//							//product.setProductId(cell.getStringCellValue());
//							System.out.println(cell.getStringCellValue());
//							
//							break;
//						case NUMERIC:
//							System.out.println(cell.getNumericCellValue());
//							break;
//
//						default:
//							break;
//						}
//					}
//					if(c==3)
//					{
//						switch (cell.getCellType()) {
//						case STRING:
//							//amzonProduct.setAmazonProductId();
//							System.out.println(cell.getStringCellValue());
//							
//							break;
//						case NUMERIC:
//							System.out.println(cell.getNumericCellValue());
//							break;
//
//						default:
//							break;
//						}
//					}
//					amzonProduct.setProduct(product);
//					if(amazonRepository.findByArticleNumber(amzonProduct.getArticleNumber())==null && productRepository.findById(product.getProductId())==null)
//					{
//						amazonProductService.addAmazonProduct(amzonProduct);
//					}
//					
//				}
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}
