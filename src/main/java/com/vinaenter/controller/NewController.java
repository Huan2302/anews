package com.vinaenter.controller;

import com.vinaenter.dao.CategoryDao;
import com.vinaenter.dao.NewDao;
import com.vinaenter.dao.New_ImgDao;
import com.vinaenter.model.NewModel;
import com.vinaenter.model.New_ImgModel;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class NewController {
    @Autowired private CategoryDao categoryDao;
    @Autowired private NewDao newDao;
    @Autowired private New_ImgDao new_imgDao;

    @ModelAttribute
    public void setCategory(Model model){
        model.addAttribute("listCat",categoryDao.findAll());
    }

    @RequestMapping("/index")
    public ModelAndView loadIndex(){
        ModelAndView mav = new ModelAndView("anews.index");
        mav.addObject("listNew",newDao.findAll());
        return mav;
    }

    @RequestMapping("/new/add")
    public String addN(Map<String, Object> model){
        NewModel newModel = new NewModel();
        model.put("new", newModel);
        model.put("listCat",categoryDao.findAll());
        return "anews.add";
    }

    @RequestMapping(value = "/new/add",method = RequestMethod.POST)
    public String addNew(@ModelAttribute("new") NewModel newModel, @RequestParam("file") List<MultipartFile> multipartFileList
            , HttpServletRequest request, @Valid @ModelAttribute("new") NewModel newModel_msg, BindingResult rs){
        if(rs.hasErrors()) {
            return "anews.add";
        }
        long new_id = newDao.insertNew(newModel);
        if (!multipartFileList.isEmpty()) {
            for (MultipartFile multipartFile:multipartFileList){
                try {
                    String fileName = multipartFile.getOriginalFilename();
                    String getFile = getFileNameServer(fileName);
                    File fileRoot = pathFile(getFile,"template/img",request);
                    multipartFile.transferTo(fileRoot);

                    New_ImgModel newImgModel = new New_ImgModel();
                    newImgModel.setName(getFile);
                    newImgModel.setNew_id(new_id);
                    new_imgDao.insertImg(newImgModel);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "redirect:/index";
    }

    @RequestMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable int id){
        ModelAndView mav = new ModelAndView("anews.detail");
        NewModel newModel= newDao.findOneById(id);
        mav.addObject("listImgByNewId",new_imgDao.findNewImdByNewId(id));
        mav.addObject("news",newModel);
        return mav;
    }

    public String getFileNameServer(String fileName){
        if (!StringUtils.isEmpty(fileName)){
            String extention = FilenameUtils.getExtension(fileName);
            String base = FilenameUtils.getBaseName(fileName);
            StringBuilder builder = new StringBuilder();
            builder.append(base).append("-").append(System.nanoTime()).append(".").append(extention);
            return builder.toString();
        }
        return StringUtils.EMPTY;
    }

    public File pathFile(String fileName, String folder, HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath(""); // trả về đường dẫn tuyệt đối của web(target)
        File disry = new File(rootPath+folder); // đường dẫn folder
        if (!disry.exists()){
            disry.mkdirs();
        }
        File file = new File(rootPath+folder+"/"+fileName);
        return file;
    }
}
