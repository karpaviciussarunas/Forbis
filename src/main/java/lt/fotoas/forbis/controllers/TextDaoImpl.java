/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.fotoas.forbis.controllers;

import java.util.ArrayList;
import java.util.List;
import lt.fotoas.forbis.DAO.TextDao;
import lt.fotoas.forbis.model.ProjectTexts;

/**
 *
 * @author Sars
 */
public class TextDaoImpl implements TextDao {

    //list is working as a database
    List<ProjectTexts> textList;

    public TextDaoImpl() {
        textList = new ArrayList<ProjectTexts>();
    }
//retrive list of text from the database

    @Override
    public List<ProjectTexts> getAllTexts() {
        return textList;
    }

    @Override
    public void addText(ProjectTexts text) {
        ProjectTexts pt = new ProjectTexts(text.toString());
        textList.add(pt);
    }

}
