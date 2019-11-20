/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.fotoas.forbis.model;

/**
 *
 * @author Sars
 */
public class ProjectTexts {
    private String text;

    public ProjectTexts() {
    }

    public ProjectTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return  text ;
    }

    
    
}
