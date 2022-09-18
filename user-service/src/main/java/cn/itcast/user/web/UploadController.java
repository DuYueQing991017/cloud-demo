package cn.itcast.user.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author 杜先森
 * @date 2022/8/23 + 14:04
 * @show    上传下载案例
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/up")
    public Object up(String nickName, MultipartFile photo , HttpServletRequest request) throws IOException {
        System.out.println("nickName:"+nickName);
        System.out.println("photo:"+photo.getOriginalFilename());       //文件名称
        System.out.println("photo:"+photo.getContentType());            //文件类型
        System.out.println("photo:"+photo.getName());                   //参数名称
        System.out.println("photo:"+photo.getSize());                   //文件大小
        String path = request.getServletContext().getRealPath("/img/");
        System.out.println(path);
        saveFile(photo,path);//文件保存
        return null;
    }
    private void saveFile(MultipartFile photo,String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();    //文件地址没有存在则创建
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);     //文件保存到哪里
    }



}
