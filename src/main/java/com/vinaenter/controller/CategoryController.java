package com.vinaenter.controller;

import com.vinaenter.dao.CategoryDao;
import com.vinaenter.dao.NewDao;
import com.vinaenter.dao.New_ImgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired private CategoryDao categoryDao;
    @Autowired private NewDao newDao;

    @ModelAttribute
    public void setCategory(Model model){
        model.addAttribute("listCat",categoryDao.findAll());
    }

    @RequestMapping("/cat/{id}")
    public ModelAndView loadIndex(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("anews.cat");
        mav.addObject("catId",id);
        mav.addObject("listNew",newDao.findAllByCatId(id));
        return mav;
    }
}
