package miniProject.service.goods;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import miniProject.command.GoodsCommand;
import miniProject.domain.AuthInfoDTO;
import miniProject.domain.GoodsDTO;
import miniProject.mapper.GoodsMapper;
import miniProject.mapper.MemberMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GoodsWriteService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsWriteService.class);

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    MemberMapper memberMapper;

    public void execute(GoodsCommand goodsCommand, HttpSession session) {
        GoodsDTO dto = new GoodsDTO();
        dto.setGoodsContents(goodsCommand.getGoodsContents());
        dto.setGoodsName(goodsCommand.getGoodsName());
        dto.setGoodsNum(goodsCommand.getGoodsNum());
        dto.setGoodsPrice(goodsCommand.getGoodsPrice());
        dto.setGoodsCategory(goodsCommand.getGoodsCategory());
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String memberNum = memberMapper.getMemberNum(auth.getUserId());
		dto.setMemberNum(memberNum);
        
        // 파일 추가
        URL resource = null;
        try {
            resource = getClass().getClassLoader().getResource("static/upload");
            if (resource == null) {
                logger.warn("Resource is null, using default path");
                resource = new File("static/upload").toURI().toURL();
            }
        } catch (MalformedURLException e) {
            logger.error("Malformed URL Exception", e);
        }
        
        if (resource != null) {
            String fileDir = resource.getFile();
            logger.info("Resource URL: " + resource);

            // 메인이미지
            MultipartFile mf = goodsCommand.getGoodsMainImage();
            String originalFile = mf.getOriginalFilename();
            String extension = originalFile.substring(originalFile.lastIndexOf("."));
            String storeName = UUID.randomUUID().toString().replace("-", "");
            String storeFileName = storeName + extension;
            File file = new File(fileDir + "/" + storeFileName);
            try {
                mf.transferTo(file);
            } catch (Exception e) {
                logger.error("Error transferring main image file", e);
            }
            dto.setGoodsMainImage(originalFile);
            dto.setGoodsMainStoreImage(storeFileName);

            // 상세이미지
            if (!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
                StringBuilder originalTotal = new StringBuilder();
                StringBuilder storeTotal = new StringBuilder();
                for (MultipartFile mpf : goodsCommand.getGoodsDetailImage()) {
                    originalFile = mpf.getOriginalFilename();
                    extension = originalFile.substring(originalFile.lastIndexOf("."));
                    storeName = UUID.randomUUID().toString().replace("-", "");
                    storeFileName = storeName + extension;
                    file = new File(fileDir + "/" + storeFileName);
                    try {
                        mpf.transferTo(file);
                    } catch (Exception e) {
                        logger.error("Error transferring detail image file", e);
                    }
                    originalTotal.append(originalFile).append("/");
                    storeTotal.append(storeFileName).append("/");
                }
                dto.setGoodsDetailImage(originalTotal.toString());
                dto.setGoodsDetailStoreImage(storeTotal.toString());
            }

            goodsMapper.goodsInsert(dto);
        } else {
            logger.error("Resource URL is null, cannot proceed with file operations");
        }
    }
}


