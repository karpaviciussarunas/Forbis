/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.fotoas.forbis.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lt.fotoas.forbis.DAO.TextDao;
import lt.fotoas.forbis.model.ProjectTexts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sars
 */
@Controller
public class TextController {

    TextDao textDao = new TextDaoImpl();

    @RequestMapping(value = "/")
    public String runer() {
        return "index";
    }

    @RequestMapping(path = "result", method = RequestMethod.POST)
    public ModelAndView result(
            @RequestParam(name = "inputText", required = false) String inputText
    ) {
        List lastText = listOfWords(inputFilter(inputText), lastLetters(inputFilter(inputText)));

        ProjectTexts projectText = new ProjectTexts(lastText.toString());
        textDao.addText(projectText);

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("lastText", lastText);
        return mv;
    }

    @RequestMapping(path = "list", method = RequestMethod.POST)
    public ModelAndView list(@RequestParam(name = "projectList", required = false) String projectList) {
        
        ModelAndView mv;
        List textList = new ArrayList();
        if (textDao.getAllTexts() == null) {
            mv = new ModelAndView("index");
            return mv;
        } else {
            mv = new ModelAndView("list");
            for (ProjectTexts text : textDao.getAllTexts()) {
                textList.add(text);
            }
        }
        mv.addObject("lastText", textList);
        return mv;
    }

    @GetMapping("back")
    public String back() {
        return "redirect:/";
    }

//    Replace all symbols except alphabets and space
    static String inputFilter(String str) {
        String filter = str.replaceAll("[^A-Za-z\" \"]+", "");
        return filter;
    }
//      Taking all unique last letters from words of String and sorting by alphabetical
    static List lastLetters(String str) {
//     Take the unique last letter of the words
        Set<String> uniqueLetters = new HashSet<String>();
        // Extract words from the sentence 
        String words[] = str.split(" ");
//         For every word 
        for (int i = 0; i < words.length; i++) {
//           Take the last letter if possible
            if (words[i].length() > 0) {
                uniqueLetters.add(words[i].substring(words[i].length() - 1));
            }
        }
//      Sorting letters by alphabetically
        List<String> sortedLettersList = new ArrayList<String>(uniqueLetters);
        Collections.sort(sortedLettersList);

        return sortedLettersList;
    }

//    Method take String and last letter then giving back List of 'letter - number - words' as:  "b 2 web lab"
    static List listOfWords(String str, List letters) {
        List wordsList = new ArrayList();

        for (Object letter : letters) {
            String value = (String) letter;

            // To store the count 
            int cnt = 0;
            String word = "";
            // Extract words from the sentence 
            String words[] = str.split(" ");
            // For every word 
            for (int i = 0; i < words.length; i++) {
                // If it ends with the given leter 
                if (words[i].endsWith(value)) {
                    cnt++;
                    word += words[i] + " ";
                }
            }
            String textLine = value + " " + cnt + " " + word;
            wordsList.add(textLine);
        }
        return wordsList;
    }

}
