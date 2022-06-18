package com.yejf.web.controller;

import com.yejf.web.dao.FilmDao;
import com.yejf.web.model.Film;
import com.yejf.web.model.FilmExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisDemoController {
    @Autowired
    private FilmDao filmDao;

    @RequestMapping("searchFilm")
    public List<Film> searchFilm(@RequestParam String keyword){
        FilmExample filmExample = new FilmExample();
        filmExample.or().andTitleLike("%"+keyword+"%");
        List<Film> films = filmDao.selectByExample(filmExample);
        return films;
    }
}
