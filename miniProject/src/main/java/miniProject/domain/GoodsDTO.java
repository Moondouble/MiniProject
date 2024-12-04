package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("goods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContents;
	String goodsCategory;
	String empNum;
	String memberNum;
	Integer visitCount;
	Date goodsRegist;
	String updateEmpNum;
	Date goodsUpdateDate;
	
	// 디비에 파일명을 저장하기 위해 주가합니다.
	String goodsMainImage;
	String goodsMainStoreImage;
	String goodsDetailImage;
	String goodsDetailStoreImage;
}

