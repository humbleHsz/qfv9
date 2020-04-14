package com.qf.qfv9background.controller;

import Util.MultiUploadResultBean;
import Util.ResultBean;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/upload")
    @ResponseBody
    public ResultBean upload(MultipartFile file){
        String savePath="/Users/gh_23/Desktop/pic";

        BufferedInputStream bis;
        try {
            File sf=new File(savePath+"/"+file.getOriginalFilename());

            bis=new BufferedInputStream(file.getInputStream());
            FileOutputStream fos = new FileOutputStream(sf);

            int len;
            byte []bytes=new byte[1024];
            while((len=bis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
            fos.flush();
            fos.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/multiUpload")
    @ResponseBody
    public MultiUploadResultBean multiUpload(MultipartFile []files, HttpServletRequest request) {

        MultiUploadResultBean resultBean = new MultiUploadResultBean();
        String[] data = new String[files.length];
        for (int i = 0; i < files.length; i++) {

            String savePath="/Users/gh_23/Desktop/pic";

            BufferedInputStream bis;
            try {
                File sf=new File(savePath+"/"+files[i].getOriginalFilename());

                bis=new BufferedInputStream(files[i].getInputStream());
                FileOutputStream fos = new FileOutputStream(sf);

                int len;
                byte []bytes=new byte[1024];
                while((len=bis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
                fos.flush();
                fos.close();
                bis.close();

                data[i]=savePath+"/"+files[i].getOriginalFilename();

            } catch (IOException e) {
                e.printStackTrace();
                resultBean.setErrno("-1");
                return resultBean;
            }

            }

        resultBean.setErrno("0");
        resultBean.setData(data);
        return resultBean;
    }
}
