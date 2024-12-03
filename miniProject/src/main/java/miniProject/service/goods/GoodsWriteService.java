package miniProject.service.goods;

import java.io.File;
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

@Service
public class GoodsWriteService {
	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	
	public void execute(GoodsCommand goodsCommand,HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsContents(goodsCommand.getGoodsContents());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
//		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
//		if (auth == null || auth.getUserId() == null) {
//		    throw new IllegalStateException("로그인 정보가 없습니다. 다시 로그인하세요.");
//		}
//		String memberNum = memberMapper.getMemberNum(auth.getUserId());
//		if (memberNum == null) {
//		    throw new IllegalStateException("회원 정보를 찾을 수 없습니다.");
//		}
//		dto.setMemberNum(memberNum);
		AuthInfoDTO auth = new AuthInfoDTO();
		auth.setUserId("testUser"); // 임의 사용자 ID 설정
		session.setAttribute("auth", auth); // 세션에 auth 저장
//		////// 파일 추가
//		/// 경로
//		URL resource = getClass().getClassLoader().getResource("/static/upload");
//		if (resource == null) {
//		    throw new IllegalStateException("업로드 경로를 찾을 수 없습니다.");
//		}
//		System.out.println("resource : " + resource);
//		String filrDir = resource.getFile();
//		//String filrDir = "C:/Users/misolaptop1/eclipse-workspace/real_time_data_process_20240708/springBootMVCShopping/target/classes/static/upload";
//		////////파일 관련 내용
//		//  메인이미지
//		MultipartFile mf = goodsCommand.getGoodsMainImage();
//		if (mf == null || mf.isEmpty()) {
//		    throw new IllegalArgumentException("메인 이미지가 제공되지 않았습니다.");
//		}
//		String originalFile = mf.getOriginalFilename();
//		/// 저장하기 위한 이름 만들기 : UUID : shfioshiof30750937skfhs
//		// 확장자 : .jpg, .png : abcd.abdc.jpg
//		String extension = originalFile.substring(originalFile.lastIndexOf("."));
//		// 이름 짖기
//		String storeName = UUID.randomUUID().toString().replace("-", "");
//		String storeFileName = storeName + extension;
//		// 파일 생성
//		File file = new File(filrDir + "/" + storeFileName);
//		try {
//			mf.transferTo(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		/// dto에저장
//		dto.setGoodsMainImage(originalFile);
//		dto.setGoodsMainStoreImage(storeFileName);
//		////
//		if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()) {
//			String originalTotal = ""; 
//			String storeTotal = "";
//			for(MultipartFile mpf : goodsCommand.getGoodsDetailImage()) {
//				originalFile = mpf.getOriginalFilename();//오류
//				extension = originalFile.substring(originalFile.lastIndexOf("."));
//				storeName = UUID.randomUUID().toString().replace("-", "");
//				storeFileName = storeName + extension;
//				file = new File(filrDir + "/" + storeFileName);
//				try {
//					mpf.transferTo(file);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				originalTotal += originalFile + "/";
//				storeTotal += storeFileName +"/";
//			}
//			dto.setGoodsDetailImage(originalTotal);
//			dto.setGoodsDetailStoreImage(storeTotal);
//		}
		goodsMapper.goodsInsert(dto);
	}
}
