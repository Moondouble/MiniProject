package miniProject.command;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class GoodsCommand {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContents;
	String goodsCategory;
	String empNum;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
	MultipartFile goodsMainImage;
	MultipartFile goodsDetailImage[];
}
