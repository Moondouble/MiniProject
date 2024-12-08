package miniProject.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("WishDTO")
public class WishDTO
{
String memberNum;
String goodsNum;
Date wishDate;
}
