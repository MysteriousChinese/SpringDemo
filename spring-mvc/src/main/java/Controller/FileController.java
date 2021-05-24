package Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.spec.ECField;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传控制器 ，要引用2个jar包  commons-fileupload  commons-io
 */
@RequestMapping("file")
@RestController
public class FileController {

    /*@ExceptionHandler*/
    public void ExceptionHandle(Exception ex){
        System.out.println(ex.getMessage());
    }

    @RequestMapping("te")
    public ModelAndView TestException() throws Exception {
        throw new Exception("测试异常5");

        /*return new ModelAndView("file");*/
    }

    @RequestMapping("init")
    public ModelAndView Page() throws Exception {

        return new ModelAndView("file");
    }


    /**
     *
     * @param fileName
     * @param fileInfo 就是spring容器中初始化的  <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
     * @return
     */
    @RequestMapping("upload")
    public Map<String,String> Upload(String fileName, MultipartFile fileInfo){
        String originalFilename = fileInfo.getOriginalFilename();
        System.out.println(fileName+"  "+originalFilename);

        HashMap<String, String> result = new HashMap<>();

        try {
            File directory = new File("G:/upload");
            if(!directory.exists()){
                directory.mkdirs();
            }

            Path filePath = Paths.get(directory.getPath(), originalFilename);
            System.out.println(filePath.toString());
            fileInfo.transferTo(new File(filePath.toString()));
            result.put("200","success");
            
        } catch (IOException e) {
            e.printStackTrace();
            result.put("404",e.getMessage());
        }

        return result;
    }
}
